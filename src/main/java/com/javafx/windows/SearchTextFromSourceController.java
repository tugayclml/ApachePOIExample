package com.javafx.windows;

import java.io.IOException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SearchTextFromSourceController {
	
    @FXML
    private Button button;

    @FXML
    private TextArea selectedText = new TextArea();

    @FXML
    private ComboBox<String> selectedSource = new ComboBox<>();

    @FXML
    private TextArea parsedDocx = new TextArea();

    @FXML
    private Label resultSearch = new Label();
    
    @FXML
    void controlTextFromSource(ActionEvent event) {
    	JSONObject obj = new JSONObject();
    	obj.put("nameofthesis", selectedSource.getSelectionModel().getSelectedItem());
    	obj.put("controltext", selectedText.getText());
		String payload = obj.toString();
        StringEntity entity = new StringEntity(payload,
                ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("https://djangorestapi2.herokuapp.com/api/v1/sourceControl/");
        request.setEntity(entity);
		
        HttpResponse response;
        try {
			response = httpClient.execute(request);
			String body = new BasicResponseHandler().handleResponse(response);
			String resp = body.replaceAll("[\"]","");
			resultSearch.setText(resp);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void setTextFromTextArea(String content) {
		parsedDocx.setText(content);
	}
    
    public void getAllThesisName() {

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://djangorestapi2.herokuapp.com/api/v1/getallthesisname/");
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		
        HttpResponse response;
        try {
			response = httpClient.execute(request);
			String body = new BasicResponseHandler().handleResponse(response);
			String resp = body.substring(1, body.length()-1);
			String[] sourcelist = resp.split("---");
			for(int i=0;i<sourcelist.length;i++) {
				selectedSource.getItems().add(sourcelist[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }

}
