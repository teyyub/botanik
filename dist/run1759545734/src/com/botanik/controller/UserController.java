package com.botanik.controller;

import com.botanik.Botanika;
import com.botanik.dao.impl.UserDAOJDBC;
import com.botanik.dao.intf.UserDAO;
import com.botanik.model.User;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:17:12 PM
 */
public class UserController {

    private final UserDAO userDAO = new UserDAOJDBC();
    private Stage dialogStage;
    @FXML
    private TextField user_field;

    @FXML
    private PasswordField password_field;
    private BorderPane rootLayout;
    private Stage stage;
    private User user;
    private Logger logger = LoggerFactory.getLogger("teyyub");
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private ImageView loginImage; 
    
    @FXML
    public void initialize(){
        loginImage.setImage(new Image("image/login.jpg"));
    }
    @FXML
    private void login() {
        try {
            if (isInputValid()) {
                user = userDAO.user(user_field.getText().trim(), password_field.getText().trim());
                System.out.println("login");
                logger.error("saved successfuly");
                initRootLayout();
                showSpecimenOverview();
                loadLeftMenu();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Information");
            alert.setHeaderText("Error accurredd");
            alert.setContentText("Contact with admin" + e.toString());

            alert.showAndWait();
        }

    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (user_field.getText().trim() == null || user_field.getText().trim().length() == 0) {
            errorMessage += "No valid name!\n";
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

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/mainLayout.fxml"));

            rootLayout = (BorderPane) loader.load();
            stage = new Stage();
            // Show the scene containing the root layout.
//            primaryStage.close();
            Scene scene = new Scene(rootLayout);            
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setMinHeight(1000);
            stage.setMinWidth(1000);
            stage.show();
            Stage oldStage = (Stage) btnLogin.getScene().getWindow();
            oldStage.close();
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
//            controller.setBotanik(this);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    public void loadLeftMenu() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Botanika.class.getResource("view/LeftMenu.fxml"));
            AnchorPane leftMenu = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setLeft(leftMenu);
//            SpecimenOverviewController controller = loader.getController();
//            controller.setBotanik(this);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

}
