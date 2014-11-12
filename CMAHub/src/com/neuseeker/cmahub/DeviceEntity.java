package com.neuseeker.cmahub;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

public class DeviceEntity {
	
	private UUID mId;
	public enum DATA_TYPE {
		ETYPE_FBJC,
		ETYPE_QX,
		ETYPE_DXWD,
		ETYPE_IMAGE,
		ETYPE_VIDEO,
		ETYPE_WH,
		ETYPE_UNKNOWN
				
	};
    private String mDeviceName;
    private String mDeviceID;
    private String mLinkedDeviceID;
    private String mDescription;
    private Timestamp mLastupload;
    private DATA_TYPE mDataType;
    private HashMap<String, String> mData;
    
    public DeviceEntity(String deviceName, String deviceID, String linkedDeviceID,
    		String description, Timestamp lastupload, DATA_TYPE type) {
    	mDeviceName = deviceName;
    	mDeviceID = deviceID;
    	mLinkedDeviceID = linkedDeviceID;
    	mDescription = description;
    	mLastupload = lastupload;
    	mDataType = type;
    	mId = UUID.randomUUID();
    }
    
    private void setDataType(DATA_TYPE type) {
    	mDataType = type;
    }
    
    public DATA_TYPE getDataType() {
    	return mDataType;
    }
    
    public String getDataTypeString() {
    	String ret = "";
    	switch (mDataType) {
    	case ETYPE_FBJC:
    		ret = "�������";
    		break;
    	case ETYPE_QX:
    		ret = "΢������";
    		break;
    	case ETYPE_DXWD:
    		ret = "�¶ȼ��";
    		break;
    	case ETYPE_IMAGE:
    		ret = "ͼ����";
    		break;
    	case ETYPE_VIDEO:
    		ret = "��Ƶ���";
    		break;
    	case ETYPE_WH:
    		ret = "�ۻ���";
    		break;
    	case ETYPE_UNKNOWN:
    	default:
    		ret = "δ֪����";
    	}
    	
    	return ret;
    }
    private void setDeviceName(String deviceName) {
    	mDeviceName = deviceName;
    }
    
    public String getDeviceName() {
    	return mDeviceName;
    }
    
    private void setDeviceID(String deviceID) {
    	mDeviceID = deviceID;
    }
    
    public String getDeviceID() {
    	return mDeviceID;
    }
    
    private void setLinkedDeviceID(String linkedDeviceID) {
    	mLinkedDeviceID = linkedDeviceID;
    }
    
    public String getLinkedDeviceID() {
    	return mLinkedDeviceID;
    }
    
    private void setDecription(String description) {
    	mDescription = description;
    }
    
    public String getDescription() {
    	return mDescription;
    }
    
    private void setLastuplaod(Timestamp lastupload) {
    	mLastupload = lastupload;
    }
    
    public Timestamp getLastupload() {
    	return mLastupload;
    }
    
    public UUID getId() {
    	return mId;
    }
    
    public HashMap<String, String> getData() {
    	return mData;
    }
}
