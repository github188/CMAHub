package com.neuseeker.cmahub;

import android.app.Activity;
//import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.app.Fragment;


//public class MainActivity extends SingleFragmentActivity {
//	@Override
//	protected Fragment createFragment() {
//		return new DeviceListFragment();
//	}
//}

public class MainActivity extends MultipleFragmentActivity {
	@Override
	protected Fragment createFragment(int id) {
		switch (id) {
		case 0:
			return new DeviceListFragment();
		case 1:
			return new DataManageFragment();
		case 2:
			return new ServiceManageFragment();
		case 3:
			return new SettingFragment();
		default:
			return new DeviceListFragment();
				
		}
		
	}
}

//public class MainActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initData();
//        initView();
//    }
//    
//    public void initView() {
//    	
//    }
//    
//    public void initData() {
//    	
//    }
//}
