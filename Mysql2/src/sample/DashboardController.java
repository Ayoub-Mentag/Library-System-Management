package sample;

import javafx.collections.ModifiableObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
//    @FXML
//    private  Label nb_membres = new Label();
    @FXML
    private Label nb_livre= new Label();
    @FXML
    private Label nb_emprunteur= new Label();
    @FXML
    private Label nb_membre= new Label();
    public DashboardController() {
    }



    public void userLogout() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out");
        alert.setContentText("Vous étes sur de sortir ?");
        ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == okButton) {
                Main m = new Main();
                try {
                    m.changeScene("login.fxml" , 350 , 370);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });}
    public void voirLivres(){
        Main m = new Main();
        try {
            m.changeScene("tableauLivre.fxml" , 725 , 570);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void voirMembres(){
          Main m = new Main();
        try {
            m.changeScene("membres.fxml" ,  1350, 570);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void voirEmprunteurs(){
        Main m = new Main();
        try {
            m.changeScene("emprunteur.fxml" ,  615, 442);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setM() throws SQLException, ClassNotFoundException {

        int nb_membres = 0;
        String count_membres = "SELECT count(*) as nm FROM member;";

        Connection connection = mysqlConnectJava.ConnectDb();

        try {
            PreparedStatement statement = connection.prepareStatement(count_membres);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                nb_membres = resultSet.getInt("nm");

            }
        }catch (Exception e){
            System.out.println("OOPS");
        }
        nb_membre.setText(Integer.toString(nb_membres));
    }

    public void set() throws SQLException, ClassNotFoundException {
        int nb_livres = 0;
        String count_livres = "SELECT count(*) as nl FROM book;";

        Connection connection = mysqlConnectJava.ConnectDb();
        try {
            PreparedStatement statement = connection.prepareStatement(count_livres);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                nb_livres = resultSet.getInt("nl");

            }
        }catch (Exception e){
            System.out.println("OOPS");
        }

       nb_livre.setText(Integer.toString(nb_livres));
    }
    public void setE() throws SQLException, ClassNotFoundException {
        int nb_emprunteurs = 0;
        String count_livres = "SELECT count(date_retour) as ne FROM emprunteur;";

        Connection connection = mysqlConnectJava.ConnectDb();
        try {
            PreparedStatement statement = connection.prepareStatement(count_livres);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                nb_emprunteurs = resultSet.getInt("ne");

            }
        }catch (Exception e){
            System.out.println("OOPS");
        }

        nb_emprunteur.setText(Integer.toString(nb_emprunteurs));
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            set();
            setM();
            setE();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
