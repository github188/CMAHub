package com.neuseeker.cmahub;

import java.util.UUID;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;



public abstract class MultipleFragmentActivity extends FragmentActivity {


	ViewPager mViewPager;
	MyMultipleFragmentAdapter mPagerAdapter;
	
	protected abstract Fragment createFragment(int id);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fm = getSupportFragmentManager();
		mViewPager = (ViewPager)findViewById(R.id.main_page_viewpager);
		mPagerAdapter = new MyMultipleFragmentAdapter(fm);
		mViewPager.setAdapter(mPagerAdapter);
		
		
		mViewPager.setCurrentItem(0);
		
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
}