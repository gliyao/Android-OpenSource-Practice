package com.example.helloopensource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.androidquery.AQuery;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.navdrawer.SimpleSideDrawer;

public class MainActivity extends SherlockFragmentActivity {

	private TabListener tablistner;
	private ActionBar bar;
	private SimpleSideDrawer mSlidingMenu;
	private AQuery aq;
	public static Context appContext;
	private static String TAG = "TabActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSlidingMenu = new SimpleSideDrawer(this);
		mSlidingMenu.setLeftBehindContentView(R.layout.left_menu);

		bar = getSupportActionBar();// GetActionBar
		bar.setHomeButtonEnabled(true);// EnableHomeButton
		bar.setDisplayHomeAsUpEnabled(true);// AddHomeButton "<"

		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.addTab(bar.newTab().setText("Alert").setTabListener(new MyTabListener(new AlertListFragment())));
		bar.addTab(bar.newTab().setText("Profolio").setTabListener(new MyTabListener(new ProfolioFragment())));

		aq = new AQuery(this);//like jQuery
		// aq.id(R.id.button1).clicked(this, "buttonCliecked");

		// Log.d("test", "log testing.");
		//
		// String[] array = this.fileList();
		// this.deleteFile("hello_file");
		//
		// String FILENAME = "liyao.json";
		// String string = "{\"name\":\"Bob\", \"age\":13}";
		//
		// FileOutputStream fos;
		// try {
		// fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		// fos.write(string.getBytes());
		// fos.close();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onMenuItemSelected(int featureId, MenuItem item) {

		int itemId = item.getItemId();
		switch (itemId) {
		case android.R.id.home:
			mSlidingMenu.toggleLeftDrawer();
			break;
		}
		return true;
	}

	public void buttonCliecked(View view) {
		Toast.makeText(getApplicationContext(), "Onclick works", Toast.LENGTH_LONG).show();
		mSlidingMenu.toggleLeftDrawer();

		// JsonFactory factory = new JsonFactory();
		// // configure, if necessary:
		// factory.enable(JsonParser.Feature.ALLOW_COMMENTS);

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try {

			// mapper.writeValue(new File("result.json"), value);
			// String filePath = this.getFilesDir().getPath().toString() +
			// "/user.json";
			InputStream ins = getResources().openRawResource(R.raw.liyao);
			MyValue value2 = mapper.readValue(ins, MyValue.class);
			Log.d("test", "my value: " + value2.name);

			String[] array = this.fileList();
			for (String fileName : array) {
				Log.d("test", fileName);
				String filePath = this.getFilesDir().getPath().toString() + "/" + fileName;
				File file = new File(filePath);
				MyValue value = mapper.readValue(file, MyValue.class);
				Log.d("test", "my value: " + value.name);
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public class MyTabListener implements TabListener {
		public Fragment fragment;

		public MyTabListener(Fragment fragment) {
			this.fragment = fragment;
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {

			if (fragment == null) {
				Log.v("test", "fragment is null");
			}

			if (ft == null) {
				Log.v("test", "fragment TRANSACTION is null");
			}

			ft.replace(R.id.fragment_container, fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			Toast.makeText(MainActivity.appContext, "Reselected!", Toast.LENGTH_LONG).show();

		}

	}
}
