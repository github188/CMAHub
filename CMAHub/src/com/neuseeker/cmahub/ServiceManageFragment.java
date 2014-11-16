package com.neuseeker.cmahub;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class ServiceManageFragment extends Fragment {
	private static final String TAG = "ServiceManageFragment";
	
	
	public static ServiceManageFragment newInstance(UUID id) {
		//TODO:
		Bundle args = new Bundle();
		
		ServiceManageFragment fragment = new ServiceManageFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		//TODO:
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup parent,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_service_manage, parent, false);
		return v;
	}
}