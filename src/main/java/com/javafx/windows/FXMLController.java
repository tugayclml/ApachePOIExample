package com.javafx.windows;

import java.util.ArrayList;
import java.util.List;

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

import example_TextReading.ExtractDocxDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

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

	String path = null, content = null;
	List<String> list = new ArrayList<>();
	List<String> ed, trans, thesis, brochure, audio, database, encyclopedia, messageForum, webSites, noAuthor;

	@FXML
	private AnchorPane root;

	@FXML
	private ListView<String> listView = new ListView<String>();

	@FXML
	void clickShowReferenceButton(ActionEvent event) {
		list = findReferences(content);
		listView.getItems().removeAll(list);
		for (int i = 0; i < list.size(); i++) {
			listView.getItems().add(list.get(i));
		}
	}

	@FXML
	void clickFindAudioVisualButton(ActionEvent event) {
		audio = new ArrayList<>();
		audio = audioReference.findAudioVisualMediaSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < audio.size(); i++) {
			System.out.println(audio.get(i));
			listView.getItems().add(audio.get(i));
		}
	}

	@FXML
	void clickFindBrochureButton(ActionEvent event) {
		brochure = new ArrayList<>();
		brochure = brochureRefenrence.findBrochureSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < brochure.size(); i++) {
			System.out.println(brochure.get(i));
			listView.getItems().add(brochure.get(i));
		}
	}

	@FXML
	void clickFindDatabaseButton(ActionEvent event) {
		database = new ArrayList<>();
		database = databaseReference.findDatabaseSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < database.size(); i++) {
			System.out.println(database.get(i));
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
			System.out.println(encyclopedia.get(i));
			listView.getItems().add(encyclopedia.get(i));
		}
	}

	@FXML
	void clickFindMessageFromForum(ActionEvent event) {
		messageForum = new ArrayList<>();
		messageForum = messageFromForumReference.findMessageFromForum(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < messageForum.size(); i++) {
			System.out.println(messageForum.get(i));
			listView.getItems().add(messageForum.get(i));
		}
	}

	@FXML
	void clickFindNoAuthorButton(ActionEvent event) {
		noAuthor = new ArrayList<>();
		noAuthor = noAuthorReference.findNoAuthorNoDate(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < noAuthor.size(); i++) {
			System.out.println(noAuthor.get(i));
			listView.getItems().add(noAuthor.get(i));
		}
	}

	@FXML
	void clickFindThesisButton(ActionEvent event) {
		thesis = new ArrayList<>();
		thesis = thesisRefenrence.findThesisSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < thesis.size(); i++) {
			System.out.println(thesis.get(i));
			listView.getItems().add(thesis.get(i));
		}
	}

	@FXML
	void clickFindTranslateButton(ActionEvent event) {
		trans = new ArrayList<>();
		trans = translaterReference.findTranslateSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < trans.size(); i++) {
			System.out.println(trans.get(i));
			listView.getItems().add(trans.get(i));
		}
	}

	@FXML
	void clickFindWebsiteButton(ActionEvent event) {
		webSites = new ArrayList<>();
		webSites = webSiteReference.findWebSiteSource(list);
		listView.getItems().removeAll(list);
		for (int i = 0; i < webSites.size(); i++) {
			System.out.println(webSites.get(i));
			listView.getItems().add(webSites.get(i));
		}
	}

	public List<String> findReferences(String text) {
		List<String> references = new ArrayList<>();
		ExtractDocxDocument extractor = new ExtractDocxDocument();
		references = extractor.startWithReferences(text);

		for (int i = 0; i < references.size(); i++) {
			System.out.println(i + " : " + references.get(i));
		}
		return references;
	}

	public void getTextFromTextArea(String content) {
		this.content = content;
	}

}
