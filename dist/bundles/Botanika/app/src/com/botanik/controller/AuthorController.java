package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.AuthorDAOJDBC;
import com.botanik.dao.intf.AuthorDAO;
import com.botanik.model.Author;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class AuthorController {

    AuthorDAO authorDAO = new AuthorDAOJDBC();
    private Botanika mainApp;
    private Stage dialogStage;
    @FXML
    private TextField author_field;
    @FXML
    private TextArea brummit_field;


    @FXML
    public void initialize() {
//        loadAuthors();
//        bindAutoCompletion = TextFields.bindAutoCompletion(author_field, authors);
    }

    public void setBotanika(Botanika botanika) {
        mainApp = botanika;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void saveAuthor() {
        System.out.println("saveAuthor clicked");
        if (isInputValid()) {
            Author author = new Author();
            author.setName(author_field.getText().trim());
            author.setBrummit(brummit_field.getText().trim());
            authorDAO.saveAuthor(author);
            dialogStage.close();
        }
    }

    

    private boolean isInputValid() {
        String errorMessage = "";
        if (author_field.getText() == null || author_field.getText().length() == 0) {
            errorMessage += "Author is invalid!\n";
        }
        if (brummit_field.getText() == null || brummit_field.getText().length() == 0) {
            errorMessage += "Brummit is invalid\n";
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
