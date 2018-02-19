package com.botanik.controller;

import com.botanik.dao.impl.AuthorDAOJDBC;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.AuthorDAO;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Base;
import com.botanik.model.Family;
import com.botanik.model.Genus;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Feb 4, 2018 , 4:45:56 PM
 */
public class FamilyController {

    ContinentDAO familyDAO = new ContinentDAOJDBC();
    AuthorDAO authorDAO = new AuthorDAOJDBC();
    private Stage dialogStage;

    @FXML
    private TextField family_field;
    @FXML
    private ComboBox categoryCombo;
    List<Base> categoryList = new ArrayList();
    ObservableList<Base> category;

    @FXML
    public void initialize() {
        categoryList = familyDAO.getFamilyCategoryList();
        category = FXCollections.observableArrayList(categoryList);
        categoryCombo.setItems(category);
//        loadAuthors();
//        bindAutoCompletion = TextFields.bindAutoCompletion(author_field, authors);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void saveFamily() {
        if (isInputValid()) {
            Family family = new Family();
            family.setName(family_field.getText().trim());
            
            Base category= (Base)categoryCombo.getSelectionModel().getSelectedItem();
            family.setCategory_id(category.getId());
            authorDAO.saveFamily(family);
            dialogStage.close();
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (family_field.getText() == null || family_field.getText().length() == 0) {
            errorMessage += "Family is invalid!\n";
        }
//        if (author_field.getText() == null || author_field.getText().length() == 0) {
//            errorMessage += "Author is invalid!\n";
//        }
//        if (brummit_field.getText() == null || brummit_field.getText().length() == 0) {
//            errorMessage += "Brummit is invalid\n";
//        }
//        if (author_field.getText() == null || author_field.getText().length() == 0) {
//            errorMessage += "Author is invalid!\n";
//        }
//        if (author_field.getText() == null || author_field.getText().length() == 0) {
//            errorMessage += "Author is invalid!\n";
//        }
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
