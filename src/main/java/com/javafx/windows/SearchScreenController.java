package com.javafx.windows;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SearchScreenController {
	@FXML
	private Button button;
	
	@FXML
    private TextField selectedReferenceTextField = new TextField();
	
	@FXML
	private Label resultLabel = new Label();
	
	@FXML
	private ListView<String> listView = new ListView<String>();
	
	List<String> list = new ArrayList<>();
	
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
	Requests request = new Requests();
	
	@FXML
	void searchButton(ActionEvent event) {
		String reference = selectedReferenceTextField.getText();
		String url = "https://djangorestapi2.herokuapp.com/api/v1/controlReference/";
		if (reference.isEmpty()) {
			FXMLLoader Loader2 = new FXMLLoader();
			Loader2.setLocation(getClass().getResource("AlertBox.fxml"));
			
			try {
				Loader2.load();
			} catch (Exception e) {
				Logger.getLogger(AlertBoxController.class.getName()).log(Level.SEVERE, null, e);
			}
			
			AlertBoxController alert = Loader2.getController();
			alert.setWarningMessage("You should select on of the references!");
			
			Parent p2 = Loader2.getRoot();
			Stage stage2 = new Stage();
			Scene scene2 = new Scene(p2);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage2.setTitle("WARNING");
			stage2.setScene(scene2);
			stage2.showAndWait();
			
		}else {
			
			if(findEditorSource.isEditorReference(reference) ){
				request.controlReference(url, reference, "editorreferences");
			}else if(translaterReference.isTranslateReference(reference)) {
				String resp = request.controlReference(url, reference, "translatereferences");
				resultLabel.setText(resp);
			}else if(thesisRefenrence.isThesisReference(reference)) {
				request.controlReference(url, reference, "thesisreferences");
			}else if(brochureRefenrence.isBrochureReference(reference)) {
				request.controlReference(url, reference, "brochurereferences");
			}else if(audioReference.isAudioVisualReference(reference)) {
				request.controlReference(url, reference, "audiovisualreferences");
			}else if(databaseReference.isDatabaseReference(reference)) {
				request.controlReference(url, reference, "databasereferences");
			}else if(encyclopediaReference.isEncyclopediaReference(reference)) {
				request.controlReference(url, reference, "encyclopediareferences");
			}else if(messageFromForumReference.isMessageFromForumReference(reference)) {
				request.controlReference(url, reference, "messagefromforumreferences");
			}else if(webSiteReference.isWebSiteReference(reference)) {
				request.controlReference(url, reference, "websitereferences");
			}else if(noAuthorReference.isNoAuthorReference(reference)) {
				request.controlReference(url, reference, "noauthorreferences");
			}else {
				request.controlReference(url, reference, "references");
			}
		}
		
	}
	
	public void getReferncesList(List<String> list){
		this.list = list;
	}
	
	public void setReferencesList(List<String> list) {
		for(int i=0;i<list.size();i++) {
			listView.getItems().add(list.get(i));
		}
	}
	
	public void setTextSelectedItem() {
		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				 selectedReferenceTextField.setText(newValue);
			}
			
		});
		
	}
	
	
	
}
