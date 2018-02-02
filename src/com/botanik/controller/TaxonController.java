package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Institution;
import com.botanik.model.Rank;
import com.botanik.model.Status;
import com.botanik.model.Type;
import com.botanik.model.Voucher;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Botanika mainApp;
    
    @FXML
    private ComboBox rankCombo;
    ObservableList<Rank> rankList;
    
    @FXML
    private ComboBox taxStatusCombo;
    ObservableList<Status> statusList;
    
    
    
    @FXML
    private TextField author1TextField;
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private Label id_label;
    private AutoCompletionBinding<String> bindAutoCompletion;
    
    public TaxonController() {
        
        System.out.println("default constructor");
    }
    
    @FXML
    public void initialize() {
        bindAutoCompletion = TextFields.bindAutoCompletion(author1TextField, "aasdadasd");
        System.out.println("init Taxon controller");
//        id_label.setText("NEW");
//        rankList =  FXCollections.observableArrayList(continentDAO.getRanks());

//        System.out.println("rankList " +rankList);
    }
    
    public void setBotanika(Botanika botanika) {
        mainApp = botanika;
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
            
            Dialog<Pair<String, String>> dialog = new Dialog<>();
            Optional<Pair<String, String>> result = dialog.showAndWait();

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
}
