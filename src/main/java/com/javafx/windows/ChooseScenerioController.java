package com.javafx.windows;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChooseScenerioController {
	
	String text = "";
	
	@FXML
    private Button button;

    @FXML
    void showReference(ActionEvent event) {
    	FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("SecondScreen.fxml"));

		try {
			Loader.load();
		} catch (Exception e) {
			Logger.getLogger(PleaseProvideController.class.getName()).log(Level.SEVERE, null, e);
		}

		FXMLController fxmlController = Loader.getController();
		fxmlController.setTextFromTextArea(text);

		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		Scene scene = new Scene(p);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Show References Screen");
		stage.setScene(scene);
		stage.showAndWait();
    }

    @FXML
    void controlFromSource(ActionEvent event) {
    	Stage stagescreen = (Stage) button.getScene().getWindow();
		
		FXMLLoader Loader = new FXMLLoader();
		Loader.setLocation(getClass().getResource("SearchTextFromSource.fxml"));

		try {
			Loader.load();
		} catch (Exception e) {
			Logger.getLogger(PleaseProvideController.class.getName()).log(Level.SEVERE, null, e);
		}
		
		SearchTextFromSourceController ssc = Loader.getController();
		ssc.setTextFromTextArea(text);
		ssc.getAllThesisName();
		
		Parent p = Loader.getRoot();
		Stage stage = new Stage();
		Scene scene = new Scene(p);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Search From Source");
		stage.setScene(scene);
		stage.showAndWait();
		stagescreen.close();
    }

	public void getTextFromTextArea(String text) {
		this.text = text;
	}

}
