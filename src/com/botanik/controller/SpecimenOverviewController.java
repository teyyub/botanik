package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Continent;
import com.botanik.model.Country;
import com.botanik.model.Region;
import com.botanik.model.Specimen;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author teyyub , Jan 7, 2018 , 1:17:37 PM
 */
public class SpecimenOverviewController {

    // Reference to the main application.
    private Botanika mainApp;

    private Stage dialogStage;
    private Specimen specimen;
    private boolean okClicked = false;
    ContinentDAO continentDAO = new ContinentDAOJDBC();
    @FXML
    private ComboBox countryCombo;
    ObservableList<Country> countryList ;

    @FXML
    private ComboBox continentCombo;
    ObservableList<Continent> list ;
    
     @FXML
    private ComboBox regionCombo;
    ObservableList<Region> regionList ;
    
    @FXML
    private void initialize() {
        list = FXCollections.observableArrayList(continentDAO.getContinents());
        countryList = FXCollections.observableArrayList(continentDAO.getCountries());
        regionList = FXCollections.observableArrayList(continentDAO.getRegions());
        continentCombo.setItems(list);
        countryCombo.setItems(countryList);
        regionCombo.setItems(regionList);
    }

    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public SpecimenOverviewController() {
        
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private void showPersonDetails(Specimen specimen) {
        if (specimen != null) {
        // Fill the labels with info from the person object.

            // TODO: We need a way to convert the birthday into a String! 
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.

        }
    }

    @FXML
    private void addSpecimen() {
        System.out.println("addSpecimen Clicked");
        try {
            System.out.println("addSpecimen Clicked");
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/AddSpecimen.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
//        dialogStage.initModality(Modality.WINDOW_MODAL);
//        dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

//
//        // Set the person into the controller.
//        PersonEditDialogController controller = loader.getController();
//        controller.setDialogStage(dialogStage);
//        controller.setPerson(person);
        } catch (IOException e) {
            e.getLocalizedMessage();

        }
    }

    public void setBotanik(Botanika botanik) {
        mainApp = botanik;
    }
}
