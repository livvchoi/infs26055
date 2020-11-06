package au.edu.unsw.business.infs2605.W4E1IndiefyLoginScreen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LoginScreenController {
    
    Database database = new Database();

    @FXML
    private Button login;
    
    @FXML
    private TextField usernameBox;
    
    @FXML
    private PasswordField passwordBox;
    
    @FXML
    private Label message;
    
    @FXML
    TableView students;
    
    @FXML
    TableColumn id;
    
    @FXML
    TableColumn name;
        
//    @FXML
//    private void switchToDashboard() throws IOException 
//    {
//        App.setRoot("dashboard");
//    }
     
    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws SQLException, IOException 
    {        
        Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement st = conn.createStatement();
                        
        String username = usernameBox.getText();
        String password = passwordBox.getText();

        boolean success = database.loginCheck(username, password); 
        
            if (success == true)
            {
                App.setRoot("dashboard");
            }
            else 
            {
                message.setText("Incorrect Username or Password");
            }
    }


//    private void handleNextButtonAction(ActionEvent event) throws IOException {
//
//        App.setRoot("secondary");
//
//    }

    
    public void initialise() throws SQLException {
        Database database = new Database();
      
    }

}