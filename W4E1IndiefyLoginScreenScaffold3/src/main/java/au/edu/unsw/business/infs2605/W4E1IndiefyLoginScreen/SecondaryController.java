package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SecondaryController 
{
    Database database = new Database();

    @FXML
    private TableView<Tracks> tracks;
    
    @FXML
    private TableColumn<Tracks, String> suppliername;
    
    @FXML
    private TableColumn<Tracks, String> address;
    
    @FXML
    private TableColumn<Tracks, Integer> phone;

    @FXML
    private TableColumn<Tracks, Integer> supplierID;

    @FXML
    private Label showMessage;
    
    @FXML
    private Button display;
    
    @FXML
    private Button tracks1;
    
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
    public void initialize() throws SQLException 
    {
        Database database = new Database();
                
        showMessage.setText("Olivia Choi z5258685");

        database.initialise();
        database.insertTracks();
        

        ObservableList<Tracks> trackList = FXCollections.observableArrayList();

        trackList = database.getTracks();
       
        tracks.setItems(trackList);
        
        suppliername.setCellValueFactory(new PropertyValueFactory<>("suppliername"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        supplierID.setCellValueFactory(new PropertyValueFactory<>("supplierID"));
    }

    
    
}