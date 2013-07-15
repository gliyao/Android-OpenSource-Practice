package com.example.helloopensource;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;

public class MyTabListener implements TabListener {

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		if(tab.getText()=="Video"){
			Log.d("test", "click video tab");
//			FragmentManager fragmentManager = getFragmentManager();  // 取得FragmentManager（如果不向下相容，就不用加Support）
//			FragmentManager fragmentManager = getSupportFragmentManager();  // 取得FragmentManager（如果不向下相容，就不用加Support）
//			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//		    AlertListFragment f = new AlertListFragment();  // 把上面的FragmentA new出來！
//		    fragmentTransaction.add(R.id., f);  // 丟入到llParent之中
//		    fragmentTransaction.commit(); // 必須commit以後才會真正add
 
		}
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

}
