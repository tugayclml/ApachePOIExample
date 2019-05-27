package com.javafx.windows;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.findSource.AudioVisualMedia;
import com.findSource.FindBrochureSource;
import com.findSource.FindDatabaseSource;
import com.findSource.FindEditorSource;
import com.findSource.FindEncyclopediaSource;
import com.findSource.FindMessageFromForum;
import com.findSource.FindThesisSource;
import com.findSource.FindTranslateSource;
import com.findSource.FindWebSiteSource;
import com.findSource.NoAuthorNoDateSource;
import com.httprequest.Requests;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AcceptORDeclineController {
	
	FindEditorSource findEditorSource = new FindEditorSource();
	FindTranslateSource translaterReference = new FindTranslateSource();
	FindThesisSource thesisRefenrence = new FindThesisSource();
	FindBrochureSource brochureRefenrence = new FindBrochureSource();
	AudioVisualMedia audioReference = new AudioVisualMedia();
	FindDatabaseSource databaseReference = new FindDatabaseSource();
	FindEncyclopediaSource encyclopediaReference = new FindEncyclopediaSource();
	FindMessageFromForum messageFromForumReference = new FindMessageFromForum();
	FindWebSiteSource webSiteReference = new FindWebSiteSource();
	NoAuthorNoDateSource noAuthorReference = new NoAuthorNoDateSource();
	
	List<String> ed, trans, thesis, brochure, audio, database, encyclopedia, messageForum, webSites, noAuthor, noAttribute;
	
	Requests request = new Requests();

    @FXML
    private Button button;

    @FXML
    private AnchorPane root;
    
    List<String> allreferences = new ArrayList<>();

    @FXML
    void clickOkeyButton(ActionEvent event) {
    	Stage stage = (Stage) button.getScene().getWindow();
    	stage.close();
    	
    	findEditorReferences(allreferences);
    	findTranslateReferences(allreferences);
    	findThesisReferences(allreferences);
    	findBrochureReferences(allreferences);
    	findAudioVisualReferences(allreferences);
    	findDatabaseReferences(allreferences);
    	findEncyclopediaReferences(allreferences);
    	findMessageFromForumReferences(allreferences);
    	findWebsiteReferences(allreferences);
    	findNoAuthorReferences(allreferences);
    	findHasNoAttributeReference(allreferences);
    	
    }

    @FXML
    void clickDeclineButton(ActionEvent event) {
    	Stage stage = (Stage) button.getScene().getWindow();
    	stage.close();
    }
    
    public void getListFromReferences(List<String> references){
    	this.allreferences = references;
    }
    
    public void findEditorReferences(List<String> list) {
    	ed = new ArrayList<String>();
    	ed = findEditorSource.findEditorSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<ed.size();i++) {
	  		obj.put(""+i,""+ed.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/editorreferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "editor";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
	  	
    }
    
    public void findTranslateReferences(List<String> list) {
    	trans = new ArrayList<String>();
    	trans = translaterReference.findTranslateSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<trans.size();i++) {
	  		obj.put(""+i,""+trans.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/translatereferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "translate";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findThesisReferences(List<String> list) {
    	thesis = new ArrayList<String>();
    	thesis = thesisRefenrence.findThesisSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<thesis.size();i++) {
	  		obj.put(""+i,""+thesis.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/thesisreferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "thesis";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findBrochureReferences(List<String> list) {
    	brochure = new ArrayList<String>();
    	brochure = brochureRefenrence.findBrochureSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<brochure.size();i++) {
	  		obj.put(""+i,""+brochure.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/brochurereferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "brochure";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findAudioVisualReferences(List<String> list) {
    	audio = new ArrayList<String>();
    	audio = audioReference.findAudioVisualMediaSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<audio.size();i++) {
	  		obj.put(""+i,""+audio.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/audiovisualreferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "audiovisual";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findDatabaseReferences(List<String> list) {
    	database = new ArrayList<String>();
    	database = databaseReference.findDatabaseSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<database.size();i++) {
	  		obj.put(""+i,""+database.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/databasereferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "database";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findEncyclopediaReferences(List<String> list) {
    	encyclopedia = new ArrayList<String>();
    	encyclopedia = encyclopediaReference.findEncyclopediaSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<encyclopedia.size();i++) {
	  		obj.put(""+i,""+encyclopedia.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/encyclopediareferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "encyclopedia";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findMessageFromForumReferences(List<String> list) {
    	messageForum = new ArrayList<String>();
    	messageForum = messageFromForumReference.findMessageFromForum(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<messageForum.size();i++) {
	  		obj.put(""+i,""+messageForum.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/messagefromforumreferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "messagefromforum";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findWebsiteReferences(List<String> list) {
    	webSites = new ArrayList<String>();
    	webSites = webSiteReference.findWebSiteSource(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<webSites.size();i++) {
	  		obj.put(""+i,""+webSites.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/websitereferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "website";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findNoAuthorReferences(List<String> list) {
    	noAuthor = new ArrayList<String>();
    	noAuthor = noAuthorReference.findNoAuthorNoDate(list);
    	JSONObject obj=new JSONObject();
	  	for(int i=0;i<noAuthor.size();i++) {
	  		obj.put(""+i,""+noAuthor.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/noauthorreferences/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "noauthor";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
    
    public void findHasNoAttributeReference(List<String> list) {
    	noAttribute = new ArrayList<String>();
    	for(int i=0;i<list.size();i++) {
    		if(findEditorSource.isEditorReference(list.get(i)) ){
    		}else if(translaterReference.isTranslateReference(list.get(i))) {
    		}else if(thesisRefenrence.isThesisReference(list.get(i))) {
    		}else if(brochureRefenrence.isBrochureReference(list.get(i))) {
    		}else if(audioReference.isAudioVisualReference(list.get(i))) {
    		}else if(databaseReference.isDatabaseReference(list.get(i))) {
    		}else if(encyclopediaReference.isEncyclopediaReference(list.get(i))) {
    		}else if(messageFromForumReference.isMessageFromForumReference(list.get(i))) {
    		}else if(webSiteReference.isWebSiteReference(list.get(i))) {
    		}else if(noAuthorReference.isNoAuthorReference(list.get(i))) {
    		}else {
    			noAttribute.add(list.get(i));
    		}
    	}
    	
    	JSONObject obj = new JSONObject();
    	for(int i=0;i<noAttribute.size();i++) {
	  		obj.put(""+i,noAttribute.get(i));
	  	}
	  	if(obj.length() != 0) {
	    	String url = "https://djangorestapi2.herokuapp.com/api/v1/references/";
	    	String nameofthesis = "Deneme Deneme";
	    	String nameofreferences = "";
	    	String referenceArray = obj.toString();
	    	String response = request.postRequest(url, nameofthesis, nameofreferences, referenceArray);
	  	}
    }
}
