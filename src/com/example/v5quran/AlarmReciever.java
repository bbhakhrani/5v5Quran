package com.example.v5quran;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;


public class AlarmReciever extends BroadcastReceiver {
	
	private AlarmManager alrmMgr;
	
	private PendingIntent operation;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		
		dialogBuilder.setTitle("Test");
		dialogBuilder.setMessage("click to close");
		dialogBuilder.setCancelable(false);
		dialogBuilder.setPositiveButton("close", 
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});
		dialogBuilder.setNegativeButton("snooze", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.cancel();
			}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.show();

	}
	public void setAlarm(Context context, int hr, int min){
		AlarmManager alrmMan = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		
		Intent alrmIntent = new Intent(context, AlarmReciever.class);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hr);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, 0);

		operation = PendingIntent.getActivity(
		context, 1, alrmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		alrmMan.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), /*1*1*60*1000,*/ operation);
		
	}
	
	public void cancelAlarm(Context context){
		
	}

}
