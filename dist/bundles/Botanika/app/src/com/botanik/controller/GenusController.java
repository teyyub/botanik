package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.AuthorDAOJDBC;
import com.botanik.dao.impl.GenusDAOJDBC;
import com.botanik.dao.intf.AuthorDAO;
import com.botanik.dao.intf.GenusDAO;
import com.botanik.model.Author;
import com.botanik.model.Family;
import com.botanik.model.Genus;
import com.botanik.model.Taxon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author teyyub , Feb 4, 2018 , 2:48:47 PM
 */
public class GenusController {
    
    GenusDAO genusDAO = new GenusDAOJDBC();
    AuthorDAO authorDAO = new AuthorDAOJDBC();
    private Botanika mainApp;
    private Stage dialogStage;
    
    @FXML
    private TextField genus_field, author_field, ref_no_field, additional_field, family_field, taxon_field;
    @FXML
    private TextArea remarks_field;
    @FXML
    private CheckBox hybrid_field, accepted_field;
    
    private AutoCompletionBinding<Author> bindAutoCompletion;
    private AutoCompletionBinding<Family> bindAutoCompletionFamily;
    private AutoCompletionBinding<Taxon> bindAutoCompletionTaxon;
    
    private Map<String, Number> authorMap = new HashMap();
    private Map<String, Number> familyMap = new HashMap();
    private Map<String, Number> taxonMap = new HashMap();
    
    private List<Author> authors = new ArrayList();
    private List<Family> families = new ArrayList();
    private List<Taxon> taxons = new ArrayList();

    public void setMainApp(Botanika mainApp) {
        this.mainApp = mainApp;
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    public void initialize() {
        loadAuthors();
//        loadFamilies();
        loadTaxons();
        bindAutoCompletion = TextFields.bindAutoCompletion(author_field, authors);        
        bindAutoCompletionTaxon = TextFields.bindAutoCompletion(taxon_field, taxons);
        loadFamilyAutoComplete();
    }
    
    private void loadFamilyAutoComplete() {
        loadFamilies();
        bindAutoCompletionFamily = TextFields.bindAutoCompletion(family_field, families);
    }
    
    private void loadAuthors() {
        authors = authorDAO.getAuthors();
        for (Author a : authors) {
            authorMap.put(a.getName(), a.getId());
        }
    }
    
    private void loadFamilies() {
        families = authorDAO.getFamilies();
        for (Family f : families) {
            familyMap.put(f.getName(), f.getId());
        }
    }
    
    private void loadTaxons() {
        taxons = genusDAO.getTaxonList();
        for (Taxon t : taxons) {
            taxonMap.put(t.getName(), t.getId());
        }
    }

    @FXML
    private void saveGenus() {
        System.out.println("saveGenus clicked");
        if (isInputValid()) {
            Genus genus = new Genus();
            genus.setName(genus_field.getText().trim());
            genus.setRef_no(ref_no_field.getText());
            genus.setAddition(additional_field.getText());
            genus.setRemarks(remarks_field.getText().trim());
            
            Number author_id = authorMap.get(author_field.getText());
            genus.setAuthor_id(author_id);
            
            Number family_id = familyMap.get(family_field.getText());
            genus.setFamily_id(family_id);
            
            genusDAO.saveGenus(genus);
            dialogStage.close();
        }
    }
    
    private boolean isInputValid() {
        String errorMessage = "";
        if (author_field.getText() == null || author_field.getText().length() == 0) {
            errorMessage += "Genus is invalid!\n";
        }
        if (author_field.getText() == null || author_field.getText().length() == 0) {
            errorMessage += "Author is invalid!\n";
        }
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
    
    @FXML
    private void addAuthor() {
        System.out.println("addAuthor clikced");
        try {
            System.out.println("addAuthor clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/Author.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            
            AuthorController controller = loader.getController();
//
//            controller.loadRankList();
//            controller.loadTaxStatusList();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Author");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
        } catch (Exception e) {
            System.out.println("exception in addAuthor " + e.getMessage());
        }
    }
    
    @FXML
    private void addFamily() {
        System.out.println("addFamily clikced");
        try {
            System.out.println("addFamily clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/Family.fxml"));
            
            AnchorPane page = (AnchorPane) loader.load();
            
            FamilyController controller = loader.getController();
//
//            controller.loadRankList();
//            controller.loadTaxStatusList();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Family");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            controller.setDialogStage(dialogStage);            
            dialogStage.showAndWait();
            System.out.println("close family dialog");
            loadFamilyAutoComplete();
        } catch (Exception e) {
            System.out.println("exception in addFamily " + e.getMessage());
        }
    }
    
}
