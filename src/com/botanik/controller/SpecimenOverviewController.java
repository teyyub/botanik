package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Base;
import com.botanik.model.Continent;
import com.botanik.model.Country;
import com.botanik.model.Institution;
import com.botanik.model.Region;
import com.botanik.model.Specimen;
import com.botanik.model.Type;
import com.botanik.model.Voucher;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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
    ObservableList<Country> countryList;

    @FXML
    private ComboBox continentCombo;
    ObservableList<Continent> list;

    @FXML
    private ComboBox regionCombo;
    ObservableList<Region> regionList;
    @FXML
    TableView overviewTable;
    private List<Region> regions = new ArrayList();
    private List<Country> countries = new ArrayList();
    private List<Institution> institions = new ArrayList<>();
    private List<Voucher> vouchers = new ArrayList<>();
    private List<Type> types = new ArrayList<>();

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
        System.out.println("init SpecimenOverviewController ");
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
    private void addRegionsFile() throws FileNotFoundException, IOException {
        System.out.println("addRegionsFile() clicked");
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
        System.out.println("selected file:" + file);

        readFileLines(file);
        continentDAO.saveTType(types);
//        continentDAO.saveVoucher(vouchers);
//        continentDAO.saveInstitution(institions);
//        continentDAO.saveContries(countries);
    }

    private void readFileLines(File file) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        FileReader fr = null;
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
//            Institution ins = new Institution(sCurrentLine.trim());
//            institions.add(ins);
//              Voucher vou = new Voucher(sCurrentLine.trim());
//              vouchers.add(vou);
            Type t = new Type(sCurrentLine.trim());
            types.add(t);
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
//            

            AnchorPane page = (AnchorPane) loader.load();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Spaciment");
//        dialogStage.initModality(Modality.WINDOW_MODAL);
//        dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
            overviewTable.refresh();
//      
//        // Set the person into the controller.
//         AddSpecimenController controller = loader.getController();
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
