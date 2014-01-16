package com.example.v5quran;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {
	private final String url = "http://humz.herokuapp.com";
	EditText fname;
	EditText lname;
	EditText email;

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
		fname = (EditText) findViewById(R.id.fname);
		lname = (EditText) findViewById(R.id.lname);
		email = (EditText) findViewById(R.id.email);
		
		String[] input = new String[3];
		input[0] = fname.getText().toString();
		input[1] = lname.getText().toString();
		input[2] = email.getText().toString();
		
		//Check to see if email already exists
		
		Register reg = new Register(this);
		Log.d("test", "fail -1");
		reg.execute(input); //change to get user id in return
		
		//pass in user id, and store for later use.
		//Intent mainPage = new Intent(this, MainActivity.class);
		//startActivity(mainPage);
		
	}
	
	private class Register extends AsyncTask<String, Void, String> {
		private Context context;
		private ProgressDialog dialog;
		boolean success;
		public Register(Activity activity){
			context = activity;
			//dialog = new ProgressDialog(context);
			success = true;
		}
		protected void onPreExecute(){
//			dialog.setMessage("Logging in");
//			dialog.show();
		}
		
		@Override
		protected String doInBackground(String... input) {
			//String url = "http://humz.herokuapp.com";
			HttpClient httpClient = new DefaultHttpClient();
			
			HttpPost httpPost =  new HttpPost (url+"/user");
			
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(3);
			nameValuePair.add(new BasicNameValuePair("fname", input[0]));
			nameValuePair.add(new BasicNameValuePair("lname", input[1]));
			nameValuePair.add(new BasicNameValuePair("email", input[2]));
			
			// Url Encoding the POST parameters
			try {
			    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
			}
			catch (UnsupportedEncodingException e) {
				
				Log.d("test", "fail 0");
			}

			//Button cancel = (Button) findViewById(R.id.cancelButton);
			//cancel.setText("fail");
			String json = null;
			try{
				HttpResponse response = httpClient.execute(httpPost);
				json = EntityUtils.toString(response.getEntity());
				Log.d("test",json);
			} catch(ClientProtocolException e){
				
				Log.d("test", "fail 1");
			} catch (IOException e){
				Log.d("text", "fail 2");
			} catch (Exception e){
				
				Log.d("text", e.toString());
			}
			String id = null;
			if(json!=null){
				JSONObject user;
				try {
					user = new JSONObject(json);
					id = user.getString("id");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return id;
		}
		
		@Override
	    protected void onPostExecute(String result) {
			int userId = Integer.parseInt(result);	    
//			if(dialog.isShowing()){
//				dialog.dismiss();
//			}
			Intent mainPage = new Intent(getApplicationContext(), MainActivity.class);
			mainPage.putExtra("id", userId);
			startActivity(mainPage);
			
		}	
	}

}
