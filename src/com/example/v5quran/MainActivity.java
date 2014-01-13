package com.example.v5quran;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.AlarmManager;

public class MainActivity extends Activity {
	public static final String PREFS_NAME = "MyPrefsFile";
	private int streak;
	private String expiration; //date that streak resets
	private Set<String> streakHist;
	private Date current; //object to get current date
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences prefs = getSharedPreferences("mainData", 0);
		SharedPreferences.Editor editor = prefs.edit();
		if(prefs.contains("streak")){
			streak = prefs.getInt("streak", 0);
		}
		else{
			streak =0;
			editor.putInt("streak", streak);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
