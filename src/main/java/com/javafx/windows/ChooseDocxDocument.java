package com.javafx.windows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.findSource.*;

import example_TextReading.ExtractDocxDocument;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ChooseDocxDocument extends Application{

	Stage window;
	Scene mainScene,referencesScene;
	ExtractDocxDocument extractor;
	String text = null,path=null,content=null;
	ListView<String> listView;
	List<String> list,ed,trans,thesis,brochure,audio,database,encyclopedia,messageForum,webSites,noAuthor;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Choose Your Docx Document");
		
		final FileChooser fileChooser = new FileChooser();
		
		Button chooseFile = new Button("Choose File");
		chooseFile.setOnAction(e -> {
			File file = fileChooser.showOpenDialog(window);
			if(file!=null) {
				path = file.getAbsolutePath();
				content = readFile(path);
			}
			window.setScene(referencesScene);
		});
		
		listView = new ListView<String>();
		
		Button showList = new Button("Show List");
		showList.setOnAction(e -> {
			list = findReferences(content);
			for(int i=0;i<list.size();i++) {
				listView.getItems().add(list.get(i));
			}
		});
		
		VBox leftMenu = new VBox();
		leftMenu.getChildren().addAll(chooseFile,showList);
		leftMenu.setAlignment(Pos.CENTER);
		
		HBox centerMenu = new HBox();
		centerMenu.getChildren().add(listView);
		centerMenu.setAlignment(Pos.CENTER);
		
		FindEditorSource editorReference = new FindEditorSource();
		ed = new ArrayList<>();
		Button findEditor = new Button("Find Editor");
		findEditor.setOnAction(e -> {
			ed = editorReference.findEditorSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<ed.size();i++) {
				listView.getItems().add(ed.get(i));
			}
		});
		
		FindTranslateSource translaterReference = new FindTranslateSource();
		trans = new ArrayList<>();
		Button findTranslate = new Button("Find Translate");
		extracted(translaterReference, findTranslate);
		
		FindThesisSource thesisRefenrence = new FindThesisSource();
		thesis = new ArrayList<>();
		Button findThesis = new Button("Find Thesis");
		findThesis.setOnAction(e -> {
			thesis = thesisRefenrence.findThesisSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<thesis.size();i++) {
				listView.getItems().add(thesis.get(i));
			}
		});
		
		FindBrochureSource brochureRefenrence = new FindBrochureSource();
		brochure = new ArrayList<>();
		Button findBrochure = new Button("Find Brochure");
		findBrochure.setOnAction(e -> {
			brochure = brochureRefenrence.findBrochureSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<brochure.size();i++) {
				listView.getItems().add(brochure.get(i));
			}
		});
		
		AudioVisualMedia audioReference = new AudioVisualMedia();
		audio = new ArrayList<>();
		Button findAudio = new Button("Find Audio Visual");
		findAudio.setOnAction(e -> {
			audio = audioReference.findAudioVisualMediaSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<audio.size();i++) {
				listView.getItems().add(audio.get(i));
			}
		});
		
		FindDatabaseSource databaseReference = new FindDatabaseSource();
		database = new ArrayList<>();
		Button findDatabase = new Button("Find Database");
		findDatabase.setOnAction(e -> {
			database = databaseReference.findDatabaseSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<database.size();i++) {
				listView.getItems().add(database.get(i));
			}
		});
		
		FindEncyclopediaSource encyclopediaReference = new FindEncyclopediaSource();
		encyclopedia = new ArrayList<>();
		Button findEncyclopedia = new Button("Find Encyclopedia");
		findEncyclopedia.setOnAction(e -> {
			encyclopedia = encyclopediaReference.findEncyclopediaSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<encyclopedia.size();i++) {
				listView.getItems().add(encyclopedia.get(i));
			}
		});
		
		FindMessageFromForum messageFromForumReference = new FindMessageFromForum();
		messageForum = new ArrayList<>();
		Button findMessageFromForum = new Button("Find Message From Forum");
		findMessageFromForum.setOnAction(e -> {
			messageForum = messageFromForumReference.findMessageFromForum(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<messageForum.size();i++) {
				listView.getItems().add(messageForum.get(i));
			}
		});
		
		FindWebSiteSource webSiteReference = new FindWebSiteSource();
		webSites = new ArrayList<>();
		Button findWebSites = new Button("Find Web Sites");
		findWebSites.setOnAction(e -> {
			webSites = webSiteReference.findWebSiteSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<webSites.size();i++) {
				listView.getItems().add(webSites.get(i));
			}
		});

		NoAuthorNoDateSource noAuthorReference = new NoAuthorNoDateSource();
		noAuthor = new ArrayList<>();
		Button findNoAuthorReference = new Button("Find No Author");
		findNoAuthorReference.setOnAction(e -> {
			noAuthor = noAuthorReference.findNoAuthorNoDate(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<noAuthor.size();i++) {
				listView.getItems().add(noAuthor.get(i));
			}
		});
		
		VBox rightMenu = new VBox();
		rightMenu.getChildren().addAll(findEditor,findTranslate,findThesis,findBrochure,findAudio,findDatabase,
				findEncyclopedia,findMessageFromForum,findWebSites,findNoAuthorReference);
		
		rightMenu.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(leftMenu);
		borderPane.setCenter(centerMenu);
		borderPane.setRight(rightMenu);
		
		referencesScene = new Scene(borderPane,600,600);
		
		StackPane sp = new StackPane();
		sp.getChildren().add(chooseFile);
		
		mainScene = new Scene(sp,300,300);
		window.setScene(mainScene);
		window.show();
	}

	private void extracted(FindTranslateSource translaterReference, Button findTranslate) {
		findTranslate.setOnAction(e -> {
			trans = translaterReference.findTranslateSource(list);
			listView.getItems().removeAll(list);
			for(int i=0;i<trans.size();i++) {
				listView.getItems().add(trans.get(i));
			}
		});
	}
	
	public String readFile(String path) {
		extractor = new ExtractDocxDocument();
		String text = extractor.readDocxDocument(path);
		return text;
	}
	
	public List<String> findReferences(String text){
		List<String> references = new ArrayList<>();
		references = extractor.startWithReferences(text);
		return references;
	}
	
}
