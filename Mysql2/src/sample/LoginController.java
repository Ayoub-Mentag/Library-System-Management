package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Button btnLogin;
    @FXML
    private TextField adminname;
    @FXML
    private PasswordField password;
    @FXML
    private Label errorLabel = new Label();

    private LibraryDB libraryDB = new LibraryDB();

    public LoginController() {

    }


    public void userLogIn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        checkLogin();
    }

    private void checkLogin() throws IOException, SQLException, ClassNotFoundException {
        String adminName = adminname.getText().toString();
        String p = password.getText().toString();
        if (adminName.equals("")){
            errorLabel.setText("Name Cannot be empty !!");
            return;
        }
        if (p.equals("")){
            errorLabel.setText("Password Cannot be empty !!");
        }
        else {
            if (libraryDB.validateLogin(adminName , p)){
                Main m = new Main();
                m.changeScene("dashboard.fxml" , 700 , 400);
                //errorLabel.setText("Success");
            }
            else{
                errorLabel.setText("Mot pass ou nom d'utilisateur est incorrect !!");
            }
        }

    }

}
