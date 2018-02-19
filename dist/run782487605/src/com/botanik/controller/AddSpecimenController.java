package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.ContinentDAOJDBC;
import com.botanik.dao.impl.SpecimenDAOJDBC;
import com.botanik.dao.impl.TaxonDAOJDBC;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.dao.intf.SpecimenDAO;
import com.botanik.dao.intf.TaxonDAO;
import com.botanik.model.Collection;
import com.botanik.model.Collector;
import com.botanik.model.Country;
import com.botanik.model.GmapModel;
import com.botanik.model.ImageFile;
import com.botanik.model.Institution;
import com.botanik.model.Region;
import com.botanik.model.Series;
import com.botanik.model.SpecimenSaveModel;
import com.botanik.model.Status;
import com.botanik.model.Taxon;
import com.botanik.model.Type;
import com.botanik.model.Voucher;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author teyyub
 */
public class AddSpecimenController {

    ContinentDAO continentDAO = new ContinentDAOJDBC();
    TaxonDAO taxonDAO = new TaxonDAOJDBC();
    SpecimenDAO specimenDAO = new SpecimenDAOJDBC();
    private Botanika mainApp;
    Collector collector;
    ObservableList<Country> countryList;
    ObservableList<Region> regionList;
    @FXML
    private ComboBox voucherCombo;
    ObservableList<Voucher> voucherList;
//    private File selectedFile;
//    private File destinationFile;
//    private Image selectedImage;
    ImageFile imageFile = new ImageFile();
//    private String file_ext;

    @FXML
    private ComboBox status_combo;
    ObservableList<Status> statusList;

    @FXML
    private ComboBox institutionCombo;
    ObservableList<Institution> institutionList;

    @FXML
    private ComboBox ttypeCombo;
    ObservableList<Type> t_typeList;

    List<Taxon> taxons = new ArrayList();
    Map<String, Number> taxonMap = new HashMap();

    List<Collector> addCollectors = new ArrayList();
    Map<String, Number> addCollectorMap = new HashMap();

    List<Collector> firstCollectors = new ArrayList();
    Map<String, Number> firstCollectorsMap = new HashMap();

    List<Series> serieses = new ArrayList();
    Map<String, Number> seriesMap = new HashMap<>();

    List<Collection> collectionList;
    ObservableList<Collection> collections;

    @FXML
    private TextField taxon_field;

    private AutoCompletionBinding<Taxon> bindAutoCompletionTaxon;
    private AutoCompletionBinding<Series> bindAutoCompletionSeries;
    private AutoCompletionBinding<Collector> bindAutoCompletionFirstCollector;
    private AutoCompletionBinding<Collector> bindAutoCompletionAddCollector;
    @FXML
    private ImageView imageView;

    @FXML
    private TextField def_rev_conf_field, first_collector_field, add_collector_field, herba_no_field, ident_his_field, typified_by_field, number_field,
            n1_field, n2_field, n3_field, e1_field, e2_field, e3_field;

    @FXML
    DatePicker begin_date, end_date;

    @FXML
    private TextArea locality_field, annotation_field, habitat_field, note_field, literature_field;

    @FXML
    private Label id_label;

    @FXML
    private ComboBox country_combo, region_combo, collection_combo;
    GoogleMapView mapView;
    GoogleMap map;
    @FXML
    private ImageView googleMapImage;

    public void setBotanika(Botanika botanika) {
        mainApp = botanika;
    }

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void initialize() {
        loadTaxonAutoCompletion();
        loadSeriesAutoCompletion();
        loadInstitionList();
        loadVoucherList();
        loadTTypeList();
        loadStatusList();
        id_label.setText("NEW");
        mapView = new GoogleMapView();
        loadCountryList();
        loadRegionList();
        loadFirstCollector();
        loadAddCollector();
        loadCollection();
    }

    private void loadCollection() {
        collectionList = continentDAO.getCollection();
        collections = FXCollections.observableArrayList(collectionList);
        collection_combo.setItems(collections);

    }

    private void loadFirstCollector() {
        firstCollectors = continentDAO.getCollectorByType(1);
        bindAutoCompletionFirstCollector = TextFields.bindAutoCompletion(first_collector_field, firstCollectors);
        for (Collector col : firstCollectors) {
            firstCollectorsMap.put(col.getName(), col.getId());
        }
    }

    private void loadAddCollector() {
        addCollectors = continentDAO.getCollectorByType(2);
        bindAutoCompletionAddCollector = TextFields.bindAutoCompletion(add_collector_field, addCollectors);
        for (Collector col : addCollectors) {
            addCollectorMap.put(col.getName(), col.getId());
        }
    }

    private void loadRegionList() {
        regionList = FXCollections.observableArrayList(continentDAO.getRegions());
        region_combo.setItems(regionList);
    }

    private void loadCountryList() {
        countryList = FXCollections.observableArrayList(continentDAO.getCountries());
        country_combo.setItems(countryList);
    }

    @FXML
    private void loadImage() {
        System.out.println("loadimage");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        try {
            imageView.setImage(imageFile.image(fileChooser.showOpenDialog(dialogStage))); //fileChooser.showOpenDialog(dialogStage)
        } catch (IOException e) {
            System.out.println("exception ");
        }

    }

    private void loadTaxon() {
        System.out.println("loadTaxon");
        taxons = taxonDAO.getTaxon();
        for (Taxon t : taxons) {
            taxonMap.put(t.getFull_name(), t.getId());
        }
    }

    private void loadTaxonAutoCompletion() {
        System.out.println("loadTaxonAutoCompletion");
        loadTaxon();
        bindAutoCompletionTaxon = TextFields.bindAutoCompletion(taxon_field, taxons);
    }

    private void loadSeries() {
        System.out.println("loadSeries");
        serieses = continentDAO.getSerieses();
        for (Series s : serieses) {
            seriesMap.put(s.getName(), s.getId());
        }
    }

    private void loadSeriesAutoCompletion() {
        System.out.println("loadSeriesAutoCompletion");
        loadSeries();
//        bindAutoCompletionSeries = TextFields.bindAutoCompletion(series_field, serieses);
    }

    public void loadVoucherList() {
        System.out.println("loadVoucherList");
        voucherList = FXCollections.observableArrayList(continentDAO.getVoucherList());
        voucherCombo.setItems(voucherList);
    }

    public void loadStatusList() {
        System.out.println("loadStatusList");
        statusList = FXCollections.observableArrayList(continentDAO.getSpecimenStatusList());
        status_combo.setItems(statusList);
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

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Taxon");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            TaxonController controller = loader.getController();

            controller.loadRankList();
            controller.loadTaxStatusList();
            controller.setDialogStage(dialogStage);
//            dialogStage.setAlwaysOnTop(true);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setResizable(false);

            dialogStage.showAndWait();
        } catch (Exception e) {
            System.out.println("exception in addNewTaxonClicked " + e);

        }
    }

    @FXML
    private void addSeries() {
        try {
            System.out.println("addSeries clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/Series.fxml"));

            AnchorPane page = (AnchorPane) loader.load();
            SeriesController controller = loader.getController();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add Series");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
            loadSeriesAutoCompletion();

        } catch (Exception e) {
            System.out.println("exception in addSeries " + e);

        }
    }

    @FXML
    private void addVoucher() {
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
    private void addType() {
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
    private void addFirstCollector() {
        try {
            System.out.println("addFirstCollector clicked");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/epitetDialog.fxml"));

            AnchorPane page = (AnchorPane) loader.load();

//            controller.loadRankList();
//            controller.loadTaxStatusList();
//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add First Collector");
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setResizable(false);
            DialogController controller = loader.getController();
            controller.setButton_index(1);
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
        } catch (Exception e) {
            System.out.println("exception in addFirstCollector " + e);

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
            controller.setButton_index(2);
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
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setResizable(false);
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
        Number institute_id;
        Number status_id;
        Number country_id;
        Number region_id;
        Number voucher_id;
        Number type_id;
        Number collection_id;
        Number firstCollector_id;
        Number addCollector_id;
        if (isInputValid()) {
            try {

                System.out.println(institutionCombo.getSelectionModel());

                if (institutionCombo.getSelectionModel().getSelectedIndex() != -1) {
                    Institution ins = (Institution) institutionCombo.getValue();
                    institute_id = ins.getId();
                } else {
                    institute_id = -1;
                }

                if (status_combo.getSelectionModel().getSelectedIndex() != -1) {
                    Status sta = (Status) status_combo.getSelectionModel().getSelectedItem();
                    status_id = sta.getId();
                } else {
                    status_id = -1;
                }
                if (country_combo.getSelectionModel().getSelectedIndex() != -1) {
                    Country country = (Country) country_combo.getSelectionModel().getSelectedItem();
                    country_id = country.getId();
                } else {
                    country_id = -1;
                }
                if (region_combo.getSelectionModel().getSelectedIndex() != -1) {
                    Region region = (Region) region_combo.getSelectionModel().getSelectedItem();
                    region_id = region.getId();
                } else {
                    region_id = -1;
                }
                if (voucherCombo.getSelectionModel().getSelectedIndex() != -1) {
                    Voucher voucher = (Voucher) voucherCombo.getSelectionModel().getSelectedItem();
                    voucher_id = voucher.getId();
                } else {
                    voucher_id = -1;
                }
                if (ttypeCombo.getSelectionModel().getSelectedIndex() != -1) {
                    Type type = (Type) ttypeCombo.getSelectionModel().getSelectedItem();
                    type_id = type.getId();
                } else {
                    type_id = -1;
                }
                if (collection_combo.getSelectionModel().getSelectedIndex() != -1) {
                    Collection collection = (Collection) collection_combo.getSelectionModel().getSelectedItem();
                    collection_id = collection.getId();
                } else {
                    collection_id = -1;
                }
                Long gen_id = System.currentTimeMillis();
                System.out.println("gen_id " + gen_id);

                Number taxon_id = taxonMap.get(taxon_field.getText());

                firstCollector_id = (firstCollectorsMap.get(first_collector_field.getText()));
                addCollector_id = (addCollectorMap.get(add_collector_field.getText()));
                Date date1 = null, date2 = null;
                if (begin_date.getValue() != null) {
                    LocalDate localdate1 = begin_date.getValue();
                    date1 = Date.from(localdate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

                } else {
                    date1 = null;
                }
                if (end_date.getValue() != null) {
                    LocalDate localdate2 = end_date.getValue();
                    date2 = Date.from(localdate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

                } else {
                    date2 = null;
                }

                GmapModel gmapModel = new GmapModel(
                        Double.valueOf(n1_field.getText()), Double.valueOf(n2_field.getText()),
                        Double.valueOf(n3_field.getText()), Double.valueOf(e1_field.getText()),
                        Double.valueOf(e2_field.getText()), Double.valueOf(e3_field.getText()));

                SpecimenSaveModel saveModel = new SpecimenSaveModel(institute_id,
                        herba_no_field.getText(), collection_id, type_id, status_id,
                        country_id, region_id, voucher_id, taxon_id, def_rev_conf_field.getText(),
                        ident_his_field.getText(), typified_by_field.getText(),
                        firstCollector_id, addCollector_id,
                        date1, date2, locality_field.getText(), annotation_field.getText(),
                        habitat_field.getText(), literature_field.getText(),
                        note_field.getText(), gmapModel, imageFile);

                specimenDAO.saveSpecimen(saveModel);

            } catch (Exception e) {
                System.out.println("exception in saving " + e.getMessage());
            }

        }
    }

    @FXML
    private void showMap() throws MalformedURLException, IOException {
        if (isMapValid()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/GoogleMapView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            GMapController controller = loader.getController();

//        // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Show in Map");
            dialogStage.setResizable(false);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            dialogStage.initStyle(StageStyle.UTILITY);
            dialogStage.setResizable(false);

            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();
        }

    }

    private boolean isMapValid() {
        String errorMessage = "";
        if (n1_field.getText().trim() == null || n1_field.getText().trim().length() == 0) {
            errorMessage += "Field value is invalid";
        }
        if (n2_field.getText().trim() == null || n2_field.getText().trim().length() == 0) {
            errorMessage += "Field value is invalid";
        }
        if (n3_field.getText().trim() == null || n3_field.getText().trim().length() == 0) {
            errorMessage += "Field value is invalid";
        }

        if (e1_field.getText().trim() == null || e1_field.getText().trim().length() == 0) {
            errorMessage += "Field value is invalid";
        }
        if (e2_field.getText().trim() == null || e2_field.getText().trim().length() == 0) {
            errorMessage += "Field value is invalid";
        }

        if (e3_field.getText().trim() == null || e3_field.getText().trim().length() == 0) {
            errorMessage += "Field value is invalid";
        }
        if (errorMessage.length() != 0) {
//            return true;
//        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
        return true;
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
            errorMessage += "ident_his is invalid\n";
        }

        if (typified_by_field.getText() == null || typified_by_field.getText().length() == 0) {
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
