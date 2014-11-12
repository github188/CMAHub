package com.neuseeker.cmahub;

import java.util.UUID;
import java.sql.Timestamp;
import java.util.ArrayList;

import android.content.Context;

public class DeviceManager {
	private ArrayList<DeviceEntity> mDevices;
	
	private static DeviceManager sDeviceManager;
	private Context mAppContext;
	
	private DeviceManager(Context appContext) {
		mAppContext = appContext;
		mDevices = new ArrayList<DeviceEntity>();
		for (int i = 0; i < 10; i++) {
			DeviceEntity e = 
					new DeviceEntity("Test","Test","Test","Test",
							new Timestamp(System.currentTimeMillis()),
							DeviceEntity.DATA_TYPE.ETYPE_UNKNOWN);
			mDevices.add(e);
		}
	}
	
	public static DeviceManager get(Context c) {
		if (sDeviceManager == null) {
			sDeviceManager = new DeviceManager(c.getApplicationContext());
		}
		
		return sDeviceManager;
	}
	
	public ArrayList<DeviceEntity> getDevices() {
		return mDevices;
	}
	
	public DeviceEntity getDevice(UUID id) {
		for (DeviceEntity e : mDevices) {
			if (e.getId().equals(id)) {
				return e;
			}
		}
		
		//FIXME:
		//Test purpose only.
		return mDevices.get(0);
		//return null;
	}
	
}