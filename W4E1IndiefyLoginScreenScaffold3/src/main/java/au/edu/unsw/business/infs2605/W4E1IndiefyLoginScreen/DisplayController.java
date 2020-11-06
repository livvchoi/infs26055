/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

/**
 *
 * @author oliviachoi
 */
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javafx.beans.DefaultProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author oliviachoi
 */

@DefaultProperty(value="image")
public class DisplayController {
    
    @FXML
    private Button tracks;
    
    @FXML
    private Button display;
            
    @FXML
    private ImageView kildaBeach = new ImageView();
    
    @FXML
    private Label showMessage1;
    
    
    @FXML
    private void switchToDisplay() throws IOException 
    {
        App.setRoot("display");
    }
    
    @FXML
    private void handleBackToDisplayButtonAction(ActionEvent event) throws IOException
    {
        switchToDisplay(); 
    }
    
    @FXML
    private void switchToTable() throws IOException
    {
        App.setRoot("secondary");
    }
    
    @FXML
    private void handleBackToTableButtonAction(ActionEvent event) throws IOException 
    {
        switchToTable(); 
    }
    
    @FXML
    public void initialize() throws SQLException 
    {
        showMessage1.setText("Olivia Choi z5258685");
        File file = new File("src/main/resources/Image/beach.jpg");
        Image image = new Image(file.toURI().toString());
        kildaBeach.setImage(image);
    }
}

