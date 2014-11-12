package com.neuseeker.cmahub;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.view.ViewPager;

import android.util.Log;

public class DeviceDetailPagerActivity extends FragmentActivity {
	ViewPager mViewPager;
	MyAdapter mPagerAdapter;
	UUID showDeviceId;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_device_detail_pager);
		mViewPager = (ViewPager)findViewById(R.id.device_detail_viewPager);
		FragmentManager fm = getSupportFragmentManager();
		mPagerAdapter = new MyAdapter(fm);

		final ArrayList<DeviceEntity> devices = DeviceManager.get(this).getDevices();
		
		mViewPager.setAdapter(mPagerAdapter);
		UUID deviceEntityId = (UUID)getIntent().getSerializableExtra(DeviceDetailFragment.EXTRA_DEVICEENTITY_ID);
		mViewPager.setCurrentItem(0);
	}
	
	public class MyAdapter extends FragmentStatePagerAdapter {
		public MyAdapter(FragmentManager fm) {
			super(fm);
		}
		
		@Override
		public int getCount() {
			return 2;
		}
		
		@Override
		public Fragment getItem(int position) {
			if (position == 0) {
				return DeviceDetailFragment.newInstance(showDeviceId);
			} else if (position == 1) {
				return DeviceDataFragment.newInstance(showDeviceId);
			}
			
			return null;
		}
	}
}