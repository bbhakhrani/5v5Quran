package com.example.v5quran;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
		Button cancel = (Button) findViewById(R.id.cancelButton);
		Register reg = new Register();
		Log.d("test", "fail -1");
		reg.execute(new String[] {});
		
	}
	
	private class Register extends AsyncTask<String, Void, String> {
		@Override
		
		protected String doInBackground(String... urls) {
			Button cancel = (Button) findViewById(R.id.cancelButton);
			HttpClient httpClient = new DefaultHttpClient();
			
			HttpPost httpPost =  new HttpPost ("http://humz.herokuapp.com/users");
			
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(3);
			nameValuePair.add(new BasicNameValuePair("fname", "er"));
			nameValuePair.add(new BasicNameValuePair("lname", "Bilal"));
			nameValuePair.add(new BasicNameValuePair("email", "tester@gmail.com"));
			
			// Url Encoding the POST parameters
			try {
			    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
			}
			catch (UnsupportedEncodingException e) {
				
				Log.d("test", "fail 0");
			}

			//Button cancel = (Button) findViewById(R.id.cancelButton);
			//cancel.setText("fail");
			
			try{
				HttpResponse response = httpClient.execute(httpPost);
				
				Log.d("test","fail .5");
			} catch(ClientProtocolException e){
				
				Log.d("test", "fail 1");
			} catch (IOException e){
				Log.d("text", "fail 2");
			} catch (Exception e){
				
				cancel.setText(e.toString());
			}
			String test = "pass";
			Log.d("test", test);
			return test;
		}
		
		@Override
	    protected void onPostExecute(String result) {
			Log.d("test", result);
	    }
		
		
	}

}
