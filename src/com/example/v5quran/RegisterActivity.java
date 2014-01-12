package com.example.v5quran;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class RegisterActivity extends Activity {
	private final String url = "http://humz.herokuapp.com";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
	public void registerUser(View v){
		
	}

}
