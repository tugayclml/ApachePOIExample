package com.javafx.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AlertBoxController {
	
	@FXML
    private AnchorPane root;

    @FXML
    private Button button;

    @FXML
    void clickOkeyButton(ActionEvent event) throws Exception{
    	Stage stage = (Stage) button.getScene().getWindow();
    	stage.close();
    }
}
