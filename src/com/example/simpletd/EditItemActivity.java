package com.example.simpletd;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class EditItemActivity extends ActionBarActivity {

	ArrayList<String> items; 
	ArrayAdapter<String> itemsAdapter;
	EditText  editText;
	private final int REQUEST_CODE = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/

		String ItemName = getIntent().getStringExtra("ItenName");
		//String Position = getIntent().getStringExtra("Position");				
		editText = (EditText) findViewById(R.id.editText1);		
		editText.setText(ItemName);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}
 
	// 	Check this method 

	public void onClick(View v) {
		  // closes the activity and returns to first screen
		 /*EditText etName = (EditText) findViewById(R.id.editText1);
		 Log.d(etName.toString(), "Test");
		  // Prepare data intent 
		  Intent data = new Intent();
		  // Pass relevant data back as a result
		  data.putExtra("name", etName.getText().toString());
		  // Activity finished ok, return the data
		  setResult(RESULT_OK, data); // set result code and bundle data for response
		  this.finish(); */
		
	     Intent i = new Intent(EditItemActivity.this, TodoActivity.class);
		 i.putExtra("mode", 2); // pass arbitrary data to launched activity
		 startActivityForResult(i, REQUEST_CODE);
		 		
		}

/*	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  // REQUEST_CODE is defined above
	  if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
	     // Extract name value from result extras
	     String name = data.getExtras().getString("name");
	     // Toast the name to display temporarily on screen
	     Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
	  }
	} */

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_edit_item,
					container, false);
			return rootView;
		}
	}

}
