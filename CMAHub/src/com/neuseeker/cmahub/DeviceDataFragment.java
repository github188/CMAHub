package com.neuseeker.cmahub;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeviceDataFragment extends Fragment {
	public static final String EXTRA_DEVICEENTITY_ID = "cmahubintent.DEVICEENTITY_ID";
	DeviceEntity mDevice;
	
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
		
		mDevice = DeviceManager.get(getActivity()).getDevice(deviceEntityId);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup parent, Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_device_data, parent, false);
		
		//LinearLayout dataZone = (LinearLayout)(getActivity().findViewById(R.layout.fragment_device_data));
		LinearLayout mDataZone = (LinearLayout)(v.findViewById(R.id.data_zone));
//		LinearLayout mDataZone = (LinearLayout)((getActivity().getApplicationContext().
//						findViewById(R.id.data_zone)));
		
		
		mDataZone = (LinearLayout)generateDataZone(mDataZone, mDevice);
		

		
		return v;
	}
	
	private View generateDataZone(View layout, DeviceEntity device) {
		View ret = null;
		switch (device.getDataType()) {
		case ETYPE_FBJC: {
			ret = generateFBJCDataZone(layout, device);
			break;
		}
		case ETYPE_QX: {
			ret = generateQXDataZone(layout, device);
			break;
		}
		case ETYPE_DXWD: {
			ret = generateDXWDDataZone(layout, device);
			break;
		}
		case ETYPE_IMAGE: {
			ret = generateImageDataZone(layout, device);
			break;
		}
		case ETYPE_VIDEO: {
			ret = generateVideoDataZone(layout, device);
			break;
		}
		case ETYPE_WH: {
			ret = generateWHDataZone(layout, device);
			break;
		}
		case ETYPE_UNKNOWN:
			ret = generateDefaultDataZone(layout, device);
			default:
				
		}
		
		return ret;
	}
	
	private View generateFBJCDataZone(View layout, DeviceEntity device) {
		return generateDefaultDataZone(layout, device);
	}
	
	private View generateQXDataZone(View layout, DeviceEntity device) {
		return generateDefaultDataZone(layout, device);
	}
	
	private View generateDXWDDataZone(View layout, DeviceEntity device) {
		return generateDefaultDataZone(layout, device);
	}
	
	private View generateImageDataZone(View layout, DeviceEntity device) {
		return generateDefaultDataZone(layout, device);
	}
	
	private View generateVideoDataZone(View layout, DeviceEntity device) {
		return generateDefaultDataZone(layout, device);
	}
	
	private View generateWHDataZone(View layout, DeviceEntity device) {
		return generateDefaultDataZone(layout, device);
	}
	
	private View generateDefaultDataZone(View layout, DeviceEntity device) {
		//HashMap<String, String> datas = device.getData();
		HashMap<String, String> datas = getTestData();
				
		Iterator iter = datas.entrySet().iterator();
				
		while (iter.hasNext()) {
			HashMap.Entry entry = (HashMap.Entry)iter.next();
			
			LinearLayout subLayout = new LinearLayout(getActivity());
			LinearLayout.LayoutParams subParam = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);
			subLayout.setOrientation(LinearLayout.HORIZONTAL);
					
			TextView tKey = new TextView(getActivity());
			TextView tValue = new TextView(getActivity());
			TextView tIndent = new TextView(getActivity());
			
			tIndent.setText(" = ");
			tIndent.setTextSize(18);
			tIndent.setTextColor(Color.rgb(0,  255,  0));
			
			tKey.setText((String)entry.getKey());
			tValue.setText((String)entry.getValue());
					
			tKey.setTextSize(18);
			tKey.setTextColor(Color.rgb(0, 255, 0));
			
			tKey.setTypeface(Typeface.create((String)null, Typeface.BOLD_ITALIC));
			
			tValue.setTextSize(18);
			tValue.setTextColor(Color.rgb(238, 238, 0));
			
			
			
			subLayout.addView(tKey);
			subLayout.addView(tIndent);
			subLayout.addView(tValue);
			
					
			((LinearLayout)layout).addView(subLayout);
					
		}
				
		return layout;
	}
	
	private HashMap<String, String> getTestData() {
		HashMap<String, String> ret = new HashMap<String, String>();
		ret.put("AcquisitionTime", "2014-11-12 15:35");
		ret.put("Average_WindSpeed_10min", "10.000");
		ret.put("Average_WindDirection_10min", "10.000");
		ret.put("Max_WindSpeed", "10.000");
		ret.put("Extreme_WindSpeed", "10.000");
		ret.put("Standard_WindSpeed", "10.000");
		ret.put("Air_Temperature", "10.000");
		ret.put("Humidity", "10.000");
		ret.put("Air_Pressure", "10.000");
		ret.put("Precipitation", "10.000");
		ret.put("Precipitation_Intensity", "10.000");
		ret.put("Radiation_Intensity", "10.000");
		return ret;
	}
	
}