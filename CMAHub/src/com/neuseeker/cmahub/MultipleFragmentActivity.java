package com.neuseeker.cmahub;

import java.util.UUID;

import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;



public abstract class MultipleFragmentActivity extends FragmentActivity {


	ViewPager mViewPager;
	MyMultipleFragmentAdapter mPagerAdapter;
	MyOnPageChangeListener mListener;
	
	View mLayout;
	
	protected abstract Fragment createFragment(int id);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		LayoutInflater inflater = getLayoutInflater();
//		mLayout = inflater.inflate(R.layout.activity_main, null);
//		setContentView(mLayout);
		setBarItemSelected(0);
		setContentView(R.layout.activity_main);
		//setBarItemSelected(0);
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager = (ViewPager)findViewById(R.id.main_page_viewpager);
		mPagerAdapter = new MyMultipleFragmentAdapter(fm);
		mViewPager.setAdapter(mPagerAdapter);
		
		mListener = new MyOnPageChangeListener(this, mViewPager);
		mViewPager.setOnPageChangeListener(mListener);
		
		
		mViewPager.setCurrentItem(0);
		
		
	}
	
	public void setBarItemSelected(int position) {
		
		View root = getLayoutInflater().inflate(R.layout.bottom_bar, null);
		//RelativeLayout layout = (RelativeLayout)(root.findViewById(R.id.bottomtab));
		
		//RelativeLayout head= (RelativeLayout)layout.findViewById(R.id.index_linear_foot); 
		
		//ImageView img_device = (ImageView)(findViewById(R.id.bottomtab).findViewById(R.id.img_bottomtab_devices));
		ImageView img_device = (ImageView)(root.findViewById(R.id.img_bottomtab_devices));
		ImageView img_data = (ImageView)(root.findViewById(R.id.img_bottomtab_data));
		ImageView img_service = (ImageView)(root.findViewById(R.id.img_bottomtab_services));
		ImageView img_setting = (ImageView)(root.findViewById(R.id.img_bottomtab_settings));
		
		switch (position) {
		case 0: {
//			img_device.setImageDrawable(
//					getResources().
//					getDrawable(R.drawable.bottomtab_devices_pressed));
			img_device.setImageResource(R.drawable.bottomtab_devices_pressed);
			img_data.setImageResource(R.drawable.bottomtab_data_normal);
			img_service.setImageResource(R.drawable.bottomtab_services_normal);
			img_setting.setImageResource(R.drawable.bottomtab_settings_normal);
			break;
		}
		case 1: {
			img_device.setImageResource(R.drawable.bottomtab_devices_normal);
			img_data.setImageResource(R.drawable.bottomtab_data_pressed);
			img_service.setImageResource(R.drawable.bottomtab_services_normal);
			img_setting.setImageResource(R.drawable.bottomtab_settings_normal);
		}
		case 2: {
			img_device.setImageResource(R.drawable.bottomtab_devices_normal);
			img_data.setImageResource(R.drawable.bottomtab_data_normal);
			img_service.setImageResource(R.drawable.bottomtab_services_pressed);
			img_setting.setImageResource(R.drawable.bottomtab_settings_normal);
		}
		case 3: {
			img_device.setImageResource(R.drawable.bottomtab_devices_normal);
			img_data.setImageResource(R.drawable.bottomtab_data_normal);
			img_service.setImageResource(R.drawable.bottomtab_services_normal);
			img_setting.setImageResource(R.drawable.bottomtab_settings_pressed);
		}
		default: {
			img_device.setImageResource(R.drawable.bottomtab_devices_pressed);
			img_data.setImageResource(R.drawable.bottomtab_data_normal);
			img_service.setImageResource(R.drawable.bottomtab_services_normal);
			img_setting.setImageResource(R.drawable.bottomtab_settings_normal);
		}
		}
		
	}
	
	public class MyMultipleFragmentAdapter extends FragmentStatePagerAdapter {
		public MyMultipleFragmentAdapter(FragmentManager fm) {
			super(fm);
		}
		
	
		@Override
		public int getCount() {
			return 4;
		}
		
		@Override
		public Fragment getItem(int position) {
			Fragment fragment = null;
			switch (position) {
			case 0: {
				fragment = DeviceListFragment.newInstance(null);
				break;
			}
			case 1: {
				fragment = DataManageFragment.newInstance(null);
				break;
			}
			case 2: {
				fragment = ServiceManageFragment.newInstance(null);
				break;
			}
			case 3: {
				fragment = SettingFragment.newInstance(null);
				break;
			}
			}
			return fragment;
		}
	}
	
	private class MyOnPageChangeListener implements OnPageChangeListener {
		private MultipleFragmentActivity mActivity;
		private ViewPager mViewPager;
		public MyOnPageChangeListener(MultipleFragmentActivity activity, ViewPager viewPager) {
			mActivity = activity;
			mViewPager = viewPager;
		}
		
		@Override
		public void onPageScrollStateChanged(int state) {
			//TODO:
		}
		
		@Override
		public void onPageScrolled(int position,
				float positionOffset,
				int positionOffsetPixels) {
			//TODO:
		}
		
		@Override
		public void onPageSelected(int position) {
			mActivity.setBarItemSelected(position);
		}
				
	}
}