package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class membresTableauController  implements Initializable {
    @FXML
    private TableView<member> tmembers;
    @FXML
    private TableColumn<member, Integer> id_member;
    @FXML
    private TableColumn<member, String> user_name_member;
    @FXML
    private TableColumn<member, String> password_member;

    @FXML
    private TableColumn<member, String> prenom_member;

    @FXML
    private TableColumn<member, String> nom_member;

    @FXML
    private TableColumn<member, String> nCart_member;
    @FXML
    private TableColumn<member, String> adresse_member;
    @FXML
    private TableColumn<member, String> ville_member;
    @FXML
    private TableColumn<member, String> pays_member;
    @FXML
    private TableColumn<member, String> email_member;
    @FXML
    private TableColumn<member, String> telephone_member;
    @FXML
    private TableColumn<member, String> profession_member;
    @FXML
    private TableColumn<member, String> anne_etude_member;
    @FXML
    private TableColumn<member, String> specialite_member;

    @FXML
    private ImageView back_arr_member;


    @FXML
    private ImageView ic_refresh_member;

    ObservableList<member> listM;


    ObservableList<book> getProductList() {
        ObservableList<book> pers = FXCollections.observableArrayList();
        return pers;
    }

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public membresTableauController() {
    }

    public void refresh_member() {
        initialize(null, null);
    }
    public void back_member() {
        Main m = new Main();
        try {
            m.changeScene("Dashboard.fxml" , 700 , 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Set things as you do for livre
        id_member.setCellValueFactory(new PropertyValueFactory<member, Integer>("id_member"));
        user_name_member.setCellValueFactory(new PropertyValueFactory<member, String>("user_name"));
        password_member.setCellValueFactory(new PropertyValueFactory<member, String>("password"));
        prenom_member.setCellValueFactory(new PropertyValueFactory<member, String>("prenom"));
        nom_member.setCellValueFactory(new PropertyValueFactory<member, String>("nom"));
        nCart_member.setCellValueFactory(new PropertyValueFactory<member, String>("ncart"));
        adresse_member.setCellValueFactory(new PropertyValueFactory<member, String>("adresse"));
        ville_member.setCellValueFactory(new PropertyValueFactory<member, String>("ville"));
        pays_member.setCellValueFactory(new PropertyValueFactory<member, String>("pays"));
        email_member.setCellValueFactory(new PropertyValueFactory<member, String>("email"));
        telephone_member.setCellValueFactory(new PropertyValueFactory<member, String>("telephone"));
        profession_member.setCellValueFactory(new PropertyValueFactory<member, String>("profession"));
        anne_etude_member.setCellValueFactory(new PropertyValueFactory<member, String>("anne_etude"));
        specialite_member.setCellValueFactory(new PropertyValueFactory<member, String>("specialite"));

        try {
            conn = mysqlConnectJava.ConnectDb();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            listM = mysqlConnectJava.getDataMember();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tmembers.setItems(listM);
    }



}
