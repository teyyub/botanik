package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.AuthorDAOJDBC;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.impl.GenusDAOJDBC;
import com.botanik.dao.impl.TaxonDAOJDBC;
import com.botanik.dao.intf.AuthorDAO;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.dao.intf.GenusDAO;
import com.botanik.dao.intf.TaxonDAO;
import com.botanik.model.Author;
import com.botanik.model.Epithet;
import com.botanik.model.Genus;
import com.botanik.model.Rank;
import com.botanik.model.Species;
import com.botanik.model.Status;
import com.botanik.model.Taxon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class TaxonController {

    ContinentDAO continentDAO = new ContinentDAOJDBC();
    AuthorDAO authorDAO = new AuthorDAOJDBC();
    GenusDAO genusDAO = new GenusDAOJDBC();
    TaxonDAO taxonDAO = new TaxonDAOJDBC();
//    private Botanika mainApp;

    @FXML
    private ComboBox rankCombo;
    ObservableList<Rank> rankList;

    @FXML
    private ComboBox taxStatusCombo;
    ObservableList<Status> statusList;

    @FXML
    private TextField author1TextField, author2TextField, author3TextField, author4TextField, author5TextField, author6TextField;
    @FXML
    private TextField species_field, sub_species_field, variety_field, sub_variety_field, forma_field, sub_forma_field;
    
    @FXML
    private TextField genus_field;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private Label id_label;
    
    private AutoCompletionBinding<Author> bindAutoCompletion;
    private AutoCompletionBinding<Species> bindAutoCompletionSpecies;
    private AutoCompletionBinding<Genus> bindAutoCompletionGenus;
    
    List<Author> authors = new ArrayList<>();
    List<Species> specieses = new ArrayList<>();
    List<Genus> genuses = new ArrayList();
    
    Map<String, Number> mapGenus = new HashMap();
    Map<String, Number> mapAuthor = new HashMap();
    Map<String, Number> mapSpecies = new HashMap();
    
    
    private Stage dialogStage;

    public TaxonController() {

        System.out.println("default constructor");
    }

    @FXML
    public void initialize() {   
        System.out.println("init Taxon controller");
        loadGenusAutocomplete();
        loadAuthorAutocomplete(); 
        loadSpeciesAutcomplete();   
    }
    private void loadGenuses(){
        genuses = genusDAO.getGenuses();
        for(Genus g :genuses){
            mapGenus.put(g.getName(), g.getId());
        }
    }
    private void loadGenusAutocomplete(){
        loadGenuses();
        bindAutoCompletionGenus = TextFields.bindAutoCompletion(genus_field, genuses);
    }
    private void loadAuthorAutocomplete(){
        loadAuthors();
        bindAutoCompletion = TextFields.bindAutoCompletion(author1TextField, authors);
        bindAutoCompletion = TextFields.bindAutoCompletion(author2TextField, authors);
        bindAutoCompletion = TextFields.bindAutoCompletion(author3TextField, authors);
        bindAutoCompletion = TextFields.bindAutoCompletion(author4TextField, authors);
        bindAutoCompletion = TextFields.bindAutoCompletion(author5TextField, authors);
        bindAutoCompletion = TextFields.bindAutoCompletion(author6TextField, authors);
    }
    private void loadSpeciesAutcomplete(){
        loadSpecies();
        bindAutoCompletionSpecies = TextFields.bindAutoCompletion(species_field, specieses);
        bindAutoCompletionSpecies = TextFields.bindAutoCompletion(sub_species_field, specieses);
        bindAutoCompletionSpecies = TextFields.bindAutoCompletion(variety_field, specieses);
        bindAutoCompletionSpecies = TextFields.bindAutoCompletion(sub_variety_field, specieses);
        bindAutoCompletionSpecies = TextFields.bindAutoCompletion(forma_field, specieses);
        bindAutoCompletionSpecies = TextFields.bindAutoCompletion(sub_forma_field, specieses);
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private void loadAuthors() {
        authors = authorDAO.getAuthors();
        for (Author a :authors){
            mapAuthor.put(a.getName(), a.getId());
        }
    }

    private void loadSpecies() {
        specieses  = authorDAO.getSpecies();
        for (Species s :specieses){
            mapAuthor.put(s.getName(), s.getId());
        }
    }

    public void setBotanika(Botanika botanika) {
//        mainApp = botanika;
    }

    @FXML
    private void addNewTaxonClicked() {

    }

    public void loadRankList() {
        System.out.println("loadRankList");
        rankList = FXCollections.observableArrayList(continentDAO.getRanks());
        rankCombo.setItems(rankList);

    }

    public void loadTaxStatusList() {
        System.out.println("loadTaxStatusList");
        statusList = FXCollections.observableArrayList(continentDAO.getTaxStatus());
        taxStatusCombo.setItems(statusList);

    }

    @FXML
    private void labelClicked() {
        System.out.println("label clikced");
        try {
            System.out.println("addNewTaxonClicked clicked");

//            Dialog<Pair<String, String>> dialog = new Dialog<>();
//            Optional<Pair<String, String>> result = dialog.showAndWait();

//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Botanika.class.getResource("view/epitetDialog.fxml"));
//
//            AnchorPane page = (AnchorPane) loader.load(); 
////        // Create the dialog Stage.
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Add Taxon");
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);
        } catch (Exception e) {
            System.out.println("exception in addNewTaxonClicked " + e);

        }
    }

    @FXML
    private void addAuthor() {
        try {
            System.out.println("addAuthor clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/Author.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Author");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            AuthorController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
            System.out.println("close addauthor dialog");
            loadAuthors();
            bindAutoCompletion = TextFields.bindAutoCompletion(author1TextField, authors);
            bindAutoCompletion = TextFields.bindAutoCompletion(author2TextField, authors);
            bindAutoCompletion = TextFields.bindAutoCompletion(author3TextField, authors);
            bindAutoCompletion = TextFields.bindAutoCompletion(author4TextField, authors);
            bindAutoCompletion = TextFields.bindAutoCompletion(author5TextField, authors);
            bindAutoCompletion = TextFields.bindAutoCompletion(author6TextField, authors);
        } catch (Exception e) {
            System.out.println("exception in addAuthorClicked " + e);

        }
    }

    @FXML
    private void addSpecies() {
        try {
            System.out.println("addAuthor clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/Specy.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            DialogController controller = loader.getController();
//
//            controller.loadRankList();
//            controller.loadTaxStatusList();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Specy");
//            dialogStage.initModality(Modality.APPLICATION_MODAL);             
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setResizable(false);
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            System.out.println("close addauthor dialog");
            loadSpecies();
            loadSpeciesAutcomplete();
//            bindAutoCompletion = TextFields.bindAutoCompletion(author2TextField, authors);
//            bindAutoCompletion = TextFields.bindAutoCompletion(author3TextField, authors);
//            bindAutoCompletion = TextFields.bindAutoCompletion(author4TextField, authors);
//            bindAutoCompletion = TextFields.bindAutoCompletion(author5TextField, authors);
//            bindAutoCompletion = TextFields.bindAutoCompletion(author6TextField, authors);
        } catch (Exception e) {
            System.out.println("exception in addSpecyClicked " + e);

        }
    }

    @FXML
    private void addGenus() {
        try {
            System.out.println("addGenus clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/Genus.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            GenusController controller = loader.getController();
//
//            controller.loadRankList();
//            controller.loadTaxStatusList();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Genus");

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            controller.setDialogStage(dialogStage);
            
            dialogStage.showAndWait();
            System.out.println("close addGenus dialog");
            loadGenusAutocomplete(); 
        } catch (Exception e) {
            System.out.println("exception in addGenusClicked " + e);

        }
    }
    @FXML
    private void saveTaxon(){
        Taxon t = new Taxon();
        Number genus_id = mapGenus.get(genus_field.getText());
        Rank rank = (Rank) rankCombo.getSelectionModel().getSelectedItem();
        Status status = (Status) taxStatusCombo.getSelectionModel().getSelectedItem();
        Number species_id = mapSpecies.get(species_field.getText());
        Number sub_species_id = mapSpecies.get(sub_species_field.getText());
        Number variety_id = mapSpecies.get(sub_variety_field.getText());
        Number sub_variety_id = mapSpecies.get(sub_variety_field.getText());
        Number forma_id = mapSpecies.get(forma_field.getText());
        Number sub_forma_id = mapSpecies.get(sub_forma_field.getText());
        Number author_id = mapSpecies.get(author1TextField.getText());
        Number s_author_id = mapSpecies.get(author2TextField.getText());
        Number v_author_id = mapSpecies.get(author3TextField.getText());
        Number sv_author_id = mapSpecies.get(author4TextField.getText());
        Number f_author_id = mapSpecies.get(author5TextField.getText());
        Number sf_author_id = mapSpecies.get(author6TextField.getText());
//        Number accepted_taxon_id = mapSpecies.get(species_field.getText());
        
        t.setGenus_id(genus_id);
        t.setRank_id(rank.getId());
        t.setTax_status_id(status.getId());
        t.setSpecies_id(species_id);
        t.setSub_species_id(sub_species_id);
        t.setVariety_id(variety_id);
        t.setSub_variety_id(sub_variety_id);
        t.setForma_id(forma_id);
        t.setSub_forma_id(sub_forma_id);
        t.setAuthor_id(author_id);
        t.setSub_author_id(s_author_id);
        t.setV_author_id(v_author_id);
        t.setSv_author_id(sv_author_id);
        t.setF_author_id(f_author_id);
        t.setSf_author_id(sf_author_id);
        taxonDAO.saveTaxon(t);
        dialogStage.close();
    }

}
