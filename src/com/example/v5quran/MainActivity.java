package com.example.v5quran;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.AlarmManager;

public class MainActivity extends Activity {
	Spinner freq;
	TimePicker setTime;
	TextView setTimeLabel;
	Button setAlrm;
	AlarmReciever alarm = new AlarmReciever();
	//Context dialogContext = this;
	private static String spinContent[] = new String[] {"5 Minutes", "10 Minutes", "15 Minutes", 
		"30 Minutes", "45 Minutes", "1 Hour", "2 Hours"};
	
	//private SimpleDateFormat dateFormatter;
	
	PendingIntent operation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//dateFormatter = new SimpleDateFormat("HH:MM:SS");
		
		setContentView(R.layout.activity_main);

		freq = (Spinner) findViewById(R.id.freqSpinner);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_spinner_item, spinContent);
		freq.setAdapter(adapter);
		
	}
	
	public void setAlarm(View v){
		setTime = (TimePicker) findViewById(R.id.timePicker1);
		setTime.clearFocus();
		int hr = setTime.getCurrentHour();
		int min = setTime.getCurrentMinute();
		setTimeLabel = (TextView) findViewById(R.id.setTimeLabel);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hr);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, 0);
		//System.currentTimeMillis();
		setTimeLabel.setText(""+(cal.getTimeInMillis()-System.currentTimeMillis()));
		alarm.setAlarm(this, hr, min);
	}
//		AlarmManager alrmMan = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//		alrmMan.cancel(operation);
//		
//		Intent alrmIntent = new Intent(this, AlertActivity.class);
//		
//		setTime = (TimePicker) findViewById(R.id.timePicker1);
//		setTime.clearFocus();
//		int hr = setTime.getCurrentHour();
//		int min = setTime.getCurrentMinute();
//		//int curTime =(hr*60 + min)*60*1000;
//		
//		//int yr = Calendar.getInstance().get(Calendar.YEAR);
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.HOUR_OF_DAY, hr);
//		cal.set(Calendar.MINUTE, min);
//		cal.set(Calendar.SECOND, 0);
//		long time = cal.getTimeInMillis();
////		long time = new GregorianCalendar(instance.get(Calendar.YEAR), 
////				instance.get(Calendar.MONTH), hr, min, 0).getTimeInMillis();//currently fixed timezone
//		
//		setTimeLabel = (TextView) findViewById(R.id.setTimeLabel);
//		setTimeLabel.setText(dateFormatter.format(cal.getTime()));
//		operation = PendingIntent.getActivity(
//				this, 1, alrmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//		alrmMan.setRepeating(AlarmManager.RTC_WAKEUP, time, 24*60*60*1000, operation);
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
