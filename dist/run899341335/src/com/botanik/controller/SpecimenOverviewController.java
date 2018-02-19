package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.impl.SpecimenDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.dao.intf.SpecimenDAO;
import com.botanik.model.Base;
import com.botanik.model.Country;
import com.botanik.model.Institution;
import com.botanik.model.Region;
import com.botanik.model.SearchModel;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    SpecimenDAO specimenDAO = new SpecimenDAOJDBC();

    @FXML
    private ComboBox countryCombo;
    ObservableList<Country> countryList;

//    @FXML
//    private ComboBox continentCombo;
//    ObservableList<Continent> list;
    @FXML
    private ComboBox regionCombo;
    ObservableList<Region> regionList;
    ObservableList<Specimen> specimenList;
    @FXML
    TableView searchTable;

    @FXML
    private TableColumn<Specimen, String> taxonColumn;
    @FXML
    private TableColumn<Specimen, String> collectorColumn;
    @FXML
    private TableColumn<Specimen, String> dateColumn;
    @FXML
    private TableColumn<Specimen, String> locationColumn;
    @FXML
    private TableColumn<Specimen, String> typusColumn;
    @FXML
    private TableColumn<Specimen, String> collectionColumn;
    
    

    private List<Region> regions = new ArrayList();
    private List<Country> countries = new ArrayList();
    private List<Institution> institions = new ArrayList<>();
    private List<Voucher> vouchers = new ArrayList<>();
    private List<Type> types = new ArrayList<>();
    private List<Base> familyCategories = new ArrayList<>();

    @FXML
    private TextField taxon_field, family_field, number_field;

    @FXML
    private DatePicker date_field;

    @FXML
    private void initialize() {
//        list = FXCollections.observableArrayList(continentDAO.getContinents());
        countryList = FXCollections.observableArrayList(continentDAO.getCountries());
        regionList = FXCollections.observableArrayList(continentDAO.getRegions());

//        continentCombo.setItems(list);
        countryCombo.setItems(countryList);
        regionCombo.setItems(regionList);

        PropertyValueFactory<Specimen, String> taxonProperty = new PropertyValueFactory<>("taxonName");
        taxonColumn.setCellValueFactory(taxonProperty);

        PropertyValueFactory<Specimen, String> collectorProperty = new PropertyValueFactory<>("collectorName");
        collectorColumn.setCellValueFactory(collectorProperty);
        
        PropertyValueFactory<Specimen, String> dateProperty = new PropertyValueFactory<>("beginDate");
        dateColumn.setCellValueFactory(dateProperty);
        
        PropertyValueFactory<Specimen, String> locationProperty = new PropertyValueFactory<>("location");
        locationColumn.setCellValueFactory(locationProperty);
        
        PropertyValueFactory<Specimen, String> typusProperty = new PropertyValueFactory<>("typus");
        typusColumn.setCellValueFactory(typusProperty);
        
        PropertyValueFactory<Specimen, String> collectionProperty = new PropertyValueFactory<>("collection");
        collectionColumn.setCellValueFactory(collectionProperty);
        
        

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
//        System.out.println("addRegionsFile() clicked");
//        FileChooser fileChooser = new FileChooser();
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
//        fileChooser.getExtensionFilters().add(extFilter);
//        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
//        System.out.println("selected file:" + file);
//        if (file != null) {
//            readFileLines(file);
//        }
//        continentDAO.saveFamilyCategory(familyCategories);
//        continentDAO.saveTType(types);
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
//            Type t = new Type(sCurrentLine.trim());
//            types.add(t);
            Base familyCategory = new Base();
            familyCategory.setName(sCurrentLine.trim());
            familyCategories.add(familyCategory);
        }
    }
    /*
     this button open new dialog for new specimens
     */

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
            AddSpecimenController controller = loader.getController();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Spaciment");
//        dialogStage.initModality(Modality.WINDOW_MODAL);
//        dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

//      
//        // Set the person into the controller.
//         
//        controller.setDialogStage(dialogStage);
//        controller.setPerson(person);
        } catch (IOException e) {
            System.out.println("exception in addSpecimenClicked " + e.getMessage());

        }
    }

    @FXML
    private void searchSpecimen() {
        System.out.println("searchSpecimen");
        Number country_id, region_id;
//        Country country = null;
//        Region region = null;
        if (countryCombo.getSelectionModel().getSelectedIndex() != -1) {
            Country country = (Country) countryCombo.getSelectionModel().getSelectedItem();
            country_id = country.getId();
        } else {
            country_id = -1;
        }
        if (regionCombo.getSelectionModel().getSelectedIndex() != -1) {
            Region region = (Region) regionCombo.getSelectionModel().getSelectedItem();
            region_id = region.getId();
        } else {
            region_id = -1;
        }
        SearchModel model = new SearchModel(taxon_field.getText(), family_field.getText(), number_field.getText(), date_field.getValue(), country_id, region_id);

        specimenList = FXCollections.observableArrayList(specimenDAO.getSpecimenByModel(model));
        searchTable.setItems(specimenList);
        System.out.println("specimenList " + specimenList.size());
    }

    public void setBotanik(Botanika botanik) {
        mainApp = botanik;
    }
}
