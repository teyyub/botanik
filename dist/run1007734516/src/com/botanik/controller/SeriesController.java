package com.botanik.controller;

import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Series;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Feb 5, 2018 , 11:43:48 AM
 */
public class SeriesController {

    public Stage dialogStage;
    private ContinentDAO seriesDAO = new ContinentDAOJDBC();
    @FXML
    private TextField name_field;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    
    @FXML
    private void saveSeries(){
        if(isInputValid()){
            Series s = new Series();
            s.setName(name_field.getText());
            seriesDAO.saveSeries(s);
            dialogStage.close();
        }
    }
    private boolean isInputValid() {
        String errorMessage = "";
        if (name_field.getText() == null || name_field.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
