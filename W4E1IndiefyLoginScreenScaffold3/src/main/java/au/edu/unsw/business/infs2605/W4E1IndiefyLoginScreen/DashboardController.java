/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author oliviachoi
 */
public class DashboardController {
    
    Database database = new Database();

    @FXML
    private Button dashboard;  
    
    @FXML
    private Button supplier;
    
    @FXML
    private Button order;     
    
    @FXML
    private Button display; 
    
    @FXML
    private Button settings;  
    
    @FXML
    private Button signOut;  
    
    
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
    private void switchToLoginPage() throws IOException 
    {
        App.setRoot("LoginScreen");
    }

    @FXML
    private void handleBackToSignOutButtonAction(ActionEvent event) throws IOException
    {
        switchToLoginPage(); 
    }    
    
    @FXML
    public void initialise() throws SQLException 
    {
        Database database = new Database();
      
    }
    
}
