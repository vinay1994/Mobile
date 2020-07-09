package com.fliplearn.flipapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class APIUtil 
{
	// http://localhost:8080/RESTfulExample/json/product/get
		public static void main(String[] args) {

		  try {

			URL url = new URL("http://bl.fliplearn.com/user/getUserByUuid/305243165081");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//response = client.execute(httpGet);

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet("http://bl.fliplearn.com/user/getUserByUuid/305243165081");

			HttpResponse response = client.execute(httpGet);

			HttpEntity entity = response.getEntity();
			String json = EntityUtils.toString(entity);


			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println("Hello");
				System.out.println(output);
				
			}

			  JSONObject obj = new JSONObject(json);

			  List<String> list = new ArrayList<String>();
			  JSONArray array = obj.getJSONArray("user");
			  for(int i = 0 ; i < array.length() ; i++){
			      System.out.println(array.getJSONObject(i).getString("loginId"));
			      
				conn.disconnect();
			  }

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }

		}
           

}
