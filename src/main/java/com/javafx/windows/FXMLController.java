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

import example_TextReading.ExtractDocxDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLController {

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
	Requests postRequest = new Requests();

	String path = null, content = null;
	List<String> list = new ArrayList<>();
	List<String> ed, trans, thesis, brochure, audio, database, encyclopedia, messageForum, webSites, noAuthor;

	@FXML
	private AnchorPane root;

	@FXML
	private ListView<String> listView = new ListView<String>();
	
	@FXML
	private Button button;

	@FXML
	void clickShowReferenceButton(ActionEvent event) {
		List<String> allreferences = new ArrayList<>();
		list = findReferences(content);
		listView.getItems().removeAll(list);
		for (int i = 0; i < list.size(); i++) {
			listView.getItems().add(list.get(i));
			allreferences.add(list.get(i));
		}
		
		FXMLLoader aodLoader = new FXMLLoader();
		aodLoader.setLocation(getClass().getResource("AcceptORDecline.fxml"));
		
		try {
			aodLoader.load();
		} catch (Exception e) {
			Logger.getLogger(PleaseProvideController.class.getName()).log(Level.SEVERE, null, e);
		}
		
		AcceptORDeclineController references = aodLoader.getController();
		references.getListFromReferences(allreferences);
		
		Parent p = aodLoader.getRoot();
		Stage stage = new Stage();
		Scene scene = new Scene(p);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Accept or Decline");
		stage.setScene(scene);
		stage.showAndWait();
	}

	@FXML
	void clickFindAudioVisualButton(ActionEvent event) {
		audio = new ArrayList<>();
		audio = audioReference.findAudioVisualMediaSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < audio.size(); i++) {
			listView.getItems().add(audio.get(i));
		}
	}

	@FXML
	void clickFindBrochureButton(ActionEvent event) {
		brochure = new ArrayList<>();
		brochure = brochureRefenrence.findBrochureSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < brochure.size(); i++) {
			listView.getItems().add(brochure.get(i));
		}
	}

	@FXML
	void clickFindDatabaseButton(ActionEvent event) {
		database = new ArrayList<>();
		database = databaseReference.findDatabaseSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < database.size(); i++) {
			listView.getItems().add(database.get(i));
		}
	}

	@FXML
	void clickFindEditorButton(ActionEvent event) {
		ed = new ArrayList<>();
		ed = findEditorSource.findEditorSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < ed.size(); i++) {
			listView.getItems().add(list.get(i));
		}

	}

	@FXML
	void clickFindEncyclopediaButton(ActionEvent event) {
		encyclopedia = new ArrayList<>();
		encyclopedia = encyclopediaReference.findEncyclopediaSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < encyclopedia.size(); i++) {
			listView.getItems().add(encyclopedia.get(i));
		}
	}

	@FXML
	void clickFindMessageFromForum(ActionEvent event) {
		messageForum = new ArrayList<>();
		messageForum = messageFromForumReference.findMessageFromForum(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < messageForum.size(); i++) {
			listView.getItems().add(messageForum.get(i));
		}
	}

	@FXML
	void clickFindNoAuthorButton(ActionEvent event) {
		noAuthor = new ArrayList<>();
		noAuthor = noAuthorReference.findNoAuthorNoDate(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < noAuthor.size(); i++) {
			listView.getItems().add(noAuthor.get(i));
		}
	}

	@FXML
	void clickFindThesisButton(ActionEvent event) {
		thesis = new ArrayList<>();
		thesis = thesisRefenrence.findThesisSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < thesis.size(); i++) {
			listView.getItems().add(thesis.get(i));
		}
	}

	@FXML
	void clickFindTranslateButton(ActionEvent event) {
		trans = new ArrayList<>();
		trans = translaterReference.findTranslateSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < trans.size(); i++) {
			listView.getItems().add(trans.get(i));
		}
	}

	@FXML
	void clickFindWebsiteButton(ActionEvent event) {
		webSites = new ArrayList<>();
		webSites = webSiteReference.findWebSiteSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < webSites.size(); i++) {
			listView.getItems().add(webSites.get(i));
		}
	}

	public List<String> findReferences(String text) {
		List<String> references = new ArrayList<>();
		ExtractDocxDocument extractor = new ExtractDocxDocument();
		references = extractor.startWithReferences(text);
		return references;
	}

	public void setTextFromTextArea(String content) {
		this.content = content;
	}

}
