package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Collector;
import com.botanik.model.Institution;
import com.botanik.model.Specimen;
import com.botanik.model.Type;
import com.botanik.model.Voucher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class AddSpecimenController {

    ContinentDAO continentDAO = new ContinentDAOJDBC();
    private Botanika mainApp;
    Collector collector;
    @FXML
    private ComboBox voucherCombo;
    ObservableList<Voucher> voucherList;
    @FXML
    private ComboBox institutionCombo;
    ObservableList<Institution> institutionList;

    @FXML
    private ComboBox ttypeCombo;
    ObservableList<Type> t_typeList;

    @FXML
    private TextField taxon_field;

    @FXML
    private TextField def_rev_conf_field;

    @FXML
    private TextField ident_his_field;

    @FXML
    private TextField typified_by_field;
    
    public void setBotanika(Botanika botanika) {
        mainApp = botanika;
    }

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void initialize() {
        loadInstitionList();
        loadVoucherList();
        loadTTypeList();
//       loadTaxStatusList();
    }

    public void loadVoucherList() {
        System.out.println("loadVoucherList");
        voucherList = FXCollections.observableArrayList(continentDAO.getVoucherList());
        voucherCombo.setItems(voucherList);
    }

    public void loadInstitionList() {
        System.out.println("loadInstitionList");
        institutionList = FXCollections.observableArrayList(continentDAO.getInstitutionList());
        institutionCombo.setItems(institutionList);
    }

    public void loadTTypeList() {
        System.out.println("loadTType");
        t_typeList = FXCollections.observableArrayList(continentDAO.getTTypesList());
        ttypeCombo.setItems(t_typeList);
    }

    @FXML
    private void addNewTaxonClicked() {
        try {
            System.out.println("addNewTaxonClicked clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/TaxonOverview.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            TaxonController controller = loader.getController();

            controller.loadRankList();
            controller.loadTaxStatusList();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Taxon");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (Exception e) {
            System.out.println("exception in addNewTaxonClicked " + e);

        }
    }

    @FXML
    private void addCollectorClicked() {
        try {
            System.out.println("addNewTaxonClicked clicked");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/epitetDialog.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

            DialogController controller = loader.getController();

//            Label foo = (Label)loader.getNamespace().get("textLabel");
//            System.out.println("foo="+foo);
//            foo.setText("istediyim sey");
//            TaxonController controller =  loader.getController();
//            controller.loadRankList();
//            controller.loadTaxStatusList();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Collector");
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            controller.setCollector(collector);
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
        } catch (Exception e) {
            System.out.println("exception in addNewTaxonClicked " + e);

        }
    }

    @FXML
    private void saveSpecimen() {
        System.out.println("clicked saveSpecimen");
        if (isInputValid()) {
            Specimen specimen = new Specimen();
            specimen.setTaxon_id(1);
            System.out.println(institutionCombo.getSelectionModel());

            Institution ins = (Institution) institutionCombo.getSelectionModel().getSelectedItem();

            specimen.setInstitution_id(ins.getId());
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (taxon_field.getText() == null || taxon_field.getText().length() == 0) {
            errorMessage += "Taxon is invalid!\n";
        }
        if (def_rev_conf_field.getText() == null || def_rev_conf_field.getText().length() == 0) {
            errorMessage += " def_rev_conf is invalid\n";
        }

        if (ident_his_field.getText() == null || ident_his_field.getText().length() == 0) {
            errorMessage +="ident_his is invalid\n";
        }
        
        if(typified_by_field.getText() ==null || typified_by_field.getText().length() ==0){
            errorMessage += "typified_by is invalid\n";
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
