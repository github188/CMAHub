package com.neuseeker.cmahub;

import java.util.UUID;

import java.sql.Timestamp;
import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.neuseeker.cmahub.DeviceEntity.DATA_TYPE;


public class DeviceManager {
	private static final String TAG = "DeviceManager";
	private ArrayList<DeviceEntity> mDevices = null;
	
	private static DeviceManager sDeviceManager;
	private Context mAppContext;
	
	private DeviceManager(Context appContext) {
		mAppContext = appContext;
	}
	
	public static DeviceManager get(Context c) {
		if (sDeviceManager == null) {
			sDeviceManager = new DeviceManager(c.getApplicationContext());
		}
		
		return sDeviceManager;
	}
	
	public ArrayList<DeviceEntity> getDevices() {
		if (null == mDevices) {
			updateDeviceList();
		}
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
	
	private void updateDeviceList() {
		if (null != mDevices) {
			mDevices = null;
		}
		
		RequestQueue requestQueue = Volley.newRequestQueue(mAppContext);
		String JSONDataUrl = 
				"http://10.160.254.13/android_connect/query_cma.php?table=sd_cd";
		//final ProgressDialog progressDialog = ProgressDialog.
		//		show(mAppContext, "This is title", "...Loading...");
		
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
				JSONDataUrl,
				null,
				new Response.Listener<JSONObject>(
						) {
					@Override
					public void onResponse(JSONObject response) {
						
			//			if (progressDialog.isShowing() && progressDialog != null) {
			//				progressDialog.dismiss();
			//			}
						boolean err = getDevicesFromJson(response);
					}
				},
				new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError arg0) {
						Log.d(TAG, "Sorry, Error" + arg0.getMessage());
						
					}
				});
		requestQueue.add(jsonObjectRequest);
		
		requestQueue.start();
	}
	
	
	private boolean getDevicesFromJson(JSONObject response) {
		
		try {
			String result = response.getString("success");
	
			if (!result.equals("1")) {
				Log.d(TAG, "CMA Server response an Error.");
				return false;
			}
			
			if (null == mDevices) {
				mDevices = new ArrayList<DeviceEntity>();
			}
			
			Log.d(TAG, "CMA Server response OK.");
			JSONArray items = response.getJSONArray("data");
			
			for (int i = 0; i < items.length(); i++) {
				JSONObject item = (JSONObject)items.get(i);
				String sObjId;
				String sDeviceName = "NULL";
				String sDeviceId;
				String sLinkedDeviceId;
				String sDescription = "NULL";
				Timestamp sTimestamp = new Timestamp(System.currentTimeMillis()); 
				String sType;
				
				sObjId = item.getString("OBJID");
				sDeviceId = item.getString("DeviceCode");
				sLinkedDeviceId =  item.getString("LinkedDevice");
				
				
				sType = item.getString("JCLXBM");
				
				
				DeviceEntity d = new DeviceEntity(sObjId,
						sDeviceName, sDeviceId, sLinkedDeviceId,
			    		sDescription, sTimestamp, DeviceEntity.getTypeFromString(sType));
				
				
				mDevices.add(d);
//				String deviceName, String deviceID, String linkedDeviceID,
//	    		String description, Timestamp lastupload, DATA_TYPE type
	    		
//				String sLinkedDeivceId = itemArray['sLinkedDeviceId'];
//				DeviceEntity d = new DeviceEntity(result, result, result, result, null, null)
			}
		} catch (JSONException e) {
			Log.d(TAG, "Json parse error." + e.getMessage());
			return false;
		}
		
		return false;
	}
	
}