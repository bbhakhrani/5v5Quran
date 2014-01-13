package com.example.v5quran;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public void goRegister(View v){
		Intent registerPage = new Intent(this, RegisterActivity.class);
		startActivity(registerPage);
		
	}
	public void login(View v){
		Intent mainPage = new Intent(this, MainActivity.class);
		startActivity(mainPage);
	}
}
