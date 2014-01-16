package com.example.v5quran;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
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
	//String data;
	private int streak;
	private String expiration; //date that streak resets
	private Set<String> streakHist;
	private Date current; //object to get current date
	//int id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int id = 0;
		Bundle args = getIntent().getExtras();
		if(args!=null){
			id = args.getInt("id");
		}
		Log.d("test", Integer.toString(id));
		SharedPreferences prefs = getSharedPreferences("mainData", 0);
		SharedPreferences.Editor editor = prefs.edit();
		if(prefs.contains("streak")){
			streak = prefs.getInt("streak", 0);
		}
		else{
			streak =0;
			editor.putInt("streak", streak);
		}
		String data = setUserData(id);
		
		editor.commit();
	}
	
	public String setUserData(int id){
		String data = "";
		Integer[] input = new Integer[1];
		input[0] = id;
		GetUserInfo getData = new GetUserInfo();
		getData.execute(input);
		try {
			data = getData.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class GetUserInfo extends AsyncTask<Integer, Void, String> {
		//String result;
		
		boolean success;
		
		
		
		@Override
		protected String doInBackground(Integer... input) {
			String url = "http://humz.herokuapp.com/user/" +input[0].toString();
			HttpClient httpClient = new DefaultHttpClient();
			
			HttpGet httpGet =  new HttpGet(url);
			
			String json = null;
			try{
				HttpResponse response = httpClient.execute(httpGet);
				json = EntityUtils.toString(response.getEntity());
				Log.d("test",json);
				success = true;
			} catch(ClientProtocolException e){
				success = false;
				Log.d("test", "fail 1");
			} catch (IOException e){
				Log.d("text", "fail 2");
				success = false;
			} catch (Exception e){
				success = false;
				Log.d("text", e.toString());
			}
		//	String id = null;
			
			return json;
		}
		
		@Override
	    protected void onPostExecute(String json) {
			//data = json;
			
			
		}	
	}

}
