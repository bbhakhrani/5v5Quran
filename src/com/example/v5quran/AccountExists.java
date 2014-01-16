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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.util.Log;

public class AccountExists extends AsyncTask<String, Void, String> {

	@Override
	protected String doInBackground(String... email) {
		// TODO Auto-generated method stub
//		String url = "http://humz.herokuapp.com";
//		HttpClient httpClient = new DefaultHttpClient();
//		
//		HttpGet httpGet = new HttpGet(url+"");
//		//HttpPost httpPost =  new HttpPost (url+"/user");
//		
//		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
//	//	nameValuePair.add(new BasicNameValuePair("fname", input[0]));
//		//nameValuePair.add(new BasicNameValuePair("lname", input[1]));
//		nameValuePair.add(new BasicNameValuePair("email", email[0]));
//		
//		// Url Encoding the POST parameters
//		try {
//		    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
//		}
//		catch (UnsupportedEncodingException e) {
//			
//			Log.d("test", "fail 0");
//		}
//
//		//Button cancel = (Button) findViewById(R.id.cancelButton);
//		//cancel.setText("fail");
//		
//		try{
//			HttpResponse response = httpClient.execute(httpPost);
//			
//			Log.d("test","fail .5");
//		} catch(ClientProtocolException e){
//			
//			Log.d("test", "fail 1");
//		} catch (IOException e){
//			Log.d("text", "fail 2");
//		} catch (Exception e){
//			
//			Log.d("text", e.toString());
//		}
		String test = "pass";
		//Log.d("test", test);
		return test;
	}

}
