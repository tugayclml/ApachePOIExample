package com.httprequest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class Requests {
	
	public Requests() {
		
	}
	
	public String postRequest(String url,String nameofthesis, String nameofreferences, String referenceArray){
		
		JSONObject obj = new JSONObject();
		obj.put("nameofthesis", nameofthesis);
		obj.put(nameofreferences+"references", referenceArray);
		String payload = obj.toString();
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        request.setEntity(entity);

        HttpResponse response;
		try {
			response = httpClient.execute(request);
			String resp = response.toString();
			return resp;
		} catch (IOException e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}
	
	public String controlReference(String url,String reference,String referenceType) {
		
		JSONObject obj = new JSONObject();
		obj.put("reference", reference);
		obj.put("referenceType", referenceType);
		String payload = obj.toString();
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        request.setEntity(entity);
		
        HttpResponse response;
        try {
			response = httpClient.execute(request);
			String body = new BasicResponseHandler().handleResponse(response);
			String resp = body.replaceAll("[\"]","");
			return resp;
		} catch (IOException e) {
			e.printStackTrace();
			return "Something went wrong";
		}
	}

}
