package com.neuseeker.cmahub;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DeviceDataFragment extends Fragment {
	public static final String EXTRA_DEVICEENTITY_ID = "cmahubintent.DEVICEENTITY_ID";
	DeviceEntity mDevices;
	
	public static DeviceDataFragment newInstance(UUID deviceEntityId) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DEVICEENTITY_ID, deviceEntityId);
		
		DeviceDataFragment fragment = new DeviceDataFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		UUID deviceEntityId = 
				(UUID)getArguments().getSerializable(EXTRA_DEVICEENTITY_ID);
		
		mDevices = DeviceManager.get(getActivity()).getDevice(deviceEntityId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_device_data, parent, false);
		
		return v;
	}
}