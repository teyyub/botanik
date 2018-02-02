package com.botanik.controller;

import com.botanik.model.Collector;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Feb 1, 2018 , 11:46:43 AM
 */
public class DialogController {

    Collector collector;
    private Stage dialogStage;
    @FXML
    private TextField nameText;
    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void insertButtonClicked() {
        if(isInputValid()){
            dialogStage.close();
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (nameText.getText() == null || nameText.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
