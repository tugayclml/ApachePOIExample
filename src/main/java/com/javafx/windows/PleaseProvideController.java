package com.javafx.windows;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import example_TextReading.ExtractDocxDocument;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PleaseProvideController {

	Stage stage;
	ExtractDocxDocument extractor;
	String path = null, content = null;

	@FXML
	private TextArea textArea;

	@FXML
	private AnchorPane root;

	@FXML
	private Button button;

	@FXML
	void clickChooseFileButton(ActionEvent event) throws Exception {

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			path = file.getAbsolutePath();
			System.out.println("Path : " + path);
			if (ControlPath(path)) {
				content = readFile(path);
				textArea.setText(content);
			}

		}

		if (path != null) {
			
			if(ControlPath(path)) {
				FXMLLoader Loader = new FXMLLoader();
				Loader.setLocation(getClass().getResource("SecondScreen.fxml"));

				try {
					Loader.load();
				} catch (Exception e) {
					Logger.getLogger(PleaseProvideController.class.getName()).log(Level.SEVERE, null, e);
				}

				FXMLController fxmlController = Loader.getController();
				fxmlController.getTextFromTextArea(textArea.getText());

				Parent p = Loader.getRoot();
				Stage stage = new Stage();
				Scene scene = new Scene(p);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setTitle("Show References Screen");
				stage.setScene(scene);
				stage.showAndWait();
			}else {
				FXMLLoader Loader2 = new FXMLLoader();
				Loader2.setLocation(getClass().getResource("AlertBox.fxml"));
				
				try {
					Loader2.load();
				} catch (Exception e) {
					Logger.getLogger(AlertBoxController.class.getName()).log(Level.SEVERE, null, e);
				}
				
				Parent p2 = Loader2.getRoot();
				Stage stage2 = new Stage();
				Scene scene2 = new Scene(p2);
				scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage2.setTitle("WARNING");
				stage2.setScene(scene2);
				stage2.showAndWait();
			}
		}

	}

	public String readFile(String path) {
		extractor = new ExtractDocxDocument();
		String text = extractor.readDocxDocument(path);
		System.out.println(text);
		return text;
	}

	public boolean ControlPath(String path) {
		if (path.endsWith(".docx")) {
			return true;
		} else {
			return false;
		}
	}

}
