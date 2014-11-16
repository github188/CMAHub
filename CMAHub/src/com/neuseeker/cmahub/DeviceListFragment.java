package com.neuseeker.cmahub;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView;

public class DeviceListFragment extends ListFragment {
	public static final String EXTRA_CMA_ID = "cmahubintent.CMA_ID";
	private static final String TAG = "DeviceListFragment";
	
	private ArrayList<DeviceEntity> mDevices;

	
	public static DeviceListFragment newInstance(UUID id) {
		//TODO:
		Bundle args = new Bundle();
		
		DeviceListFragment fragment = new DeviceListFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mDevices = DeviceManager.get(getActivity()).getDevices();
		DeviceListAdapter adapter = new DeviceListAdapter(mDevices);
		setListAdapter(adapter);
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup parent,
			Bundle savedInstanceState) {
		View v = super.onCreateView(inflater, parent, savedInstanceState);
		
		return v;
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		DeviceEntity e = ((DeviceListAdapter)getListAdapter()).getItem(position);
		Intent i = new Intent(getActivity(), DeviceDetailPagerActivity.class);
		i.putExtra(DeviceDetailFragment.EXTRA_DEVICEENTITY_ID, e.getId());
		startActivityForResult(i, 0);
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		((DeviceListAdapter)getListAdapter()).notifyDataSetChanged();
	}
	private class DeviceListAdapter extends ArrayAdapter<DeviceEntity> {
		public DeviceListAdapter(ArrayList<DeviceEntity> devices) {
			super(getActivity(), android.R.layout.simple_list_item_1, devices);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (null == convertView) {
				convertView = getActivity().getLayoutInflater().
						inflate(R.layout.devices_list_item, null);
			}
			
			DeviceEntity c = getItem(position);
//			ImageView vendor_logo = 
//					(ImageView)convertView.findViewById(R.id.vender_logo);
			TextView deviceName = 
					(TextView)convertView.findViewById(R.id.device_name_value);
			deviceName.setText(c.getDeviceName());
			
			TextView deviceType = 
					(TextView)convertView.findViewById(R.id.device_type_value);
			deviceType.setText(c.getDataTypeString());
			TextView deviceID = 
					(TextView)convertView.findViewById(R.id.device_id_value);
			deviceID.setText(c.getDeviceID());
			
			TextView linkedDeviceID = 
					(TextView)convertView.findViewById(R.id.linked_device_id_value);
			linkedDeviceID.setText(c.getLinkedDeviceID());
			
			TextView description = 
					(TextView)convertView.findViewById(R.id.device_description_value);
			description.setText(c.getDescription());
			
			TextView lastupload = 
					(TextView)convertView.findViewById(R.id.device_lastupload_value);
			
			lastupload.setText(c.getLastupload().toString());
			
			
			
			return convertView;
		}
	}
	
}