package com.botanik;

import com.botanik.controller.SpecimenOverviewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Expression teyyub is undefined on line 18, column 14 in
 * Templates/javafx/FXML.java. Jan 7, 2018 10:47:29 AM
 */
public class Botanika extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("com.botanik/view/FXMLDocument.fxml"));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Botanika");
        initRootLayout();
        showSpecimenOverview();
//        Scene scene = new Scene(root);

//        stage.setScene(scene);
//        stage.show();
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/mainLayout.fxml"));

            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("exception in file load \t" + e.getLocalizedMessage());
        }
    }

    public void showSpecimenOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/SpecimenOverview.fxml"));
            AnchorPane specimenOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(specimenOverview);
            SpecimenOverviewController controller = loader.getController();
            controller.setBotanik(this);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
