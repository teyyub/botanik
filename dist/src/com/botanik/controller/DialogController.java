package com.botanik.controller;

import com.botanik.dao.impl.AuthorDAOJDBC;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.AuthorDAO;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Collector;
import com.botanik.model.FirstCollector;
import com.botanik.model.Species;
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
    AuthorDAO speciesDAO = new AuthorDAOJDBC();
    ContinentDAO collectorDAO = new ContinentDAOJDBC();
    Collector collector;
    private Stage dialogStage;
    private int button_index; 
    @FXML
    private TextField nameText;

    public int getButton_index() {
        return button_index;
    }

    public void setButton_index(int button_index) {
        this.button_index = button_index;
    }
    
    
    
    
    
    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void insertButtonClicked() {
        if(isInputValid()){
            if (button_index==1){
                //first collector
                Collector fc = new Collector();
                fc.setName(nameText.getText());
                fc.setType(1);
                collectorDAO.saveCollector(fc);
                
                dialogStage.close();
            
            }else if(button_index==2){
//                additional collector
                Collector ac = new Collector();
                ac.setName(nameText.getText());
                ac.setType(2);
                collectorDAO.saveCollector(ac);                
                dialogStage.close();
            }  else {
             Species s = new Species();
             s.setName(nameText.getText().trim());
             speciesDAO.saveSpecies(s);
             dialogStage.close();
            }
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
