package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class EmprunteurController implements Initializable {
    @FXML
    private TableView<emprunteur> tEmprunteurs;
    @FXML
    private TableColumn<emprunteur, Integer> id_etudiant;
    @FXML
    private TableColumn<emprunteur, Integer> id_livre;
    @FXML
    private TableColumn<emprunteur, String> retour_livre;

    @FXML
    private Label txt_info = new Label();

    @FXML
    private TextField txt_id_etudiant;

    @FXML
    private TextField txt_code_livre;

    @FXML
    private TextField txt_date_retour_livre;

    ObservableList<emprunteur> listE;


    ObservableList<emprunteur> getProductList() {
        ObservableList<emprunteur> pers = FXCollections.observableArrayList();
        return pers;
    }

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public void getInfos() throws SQLException, ClassNotFoundException {
        Connection connection = mysqlConnectJava.ConnectDb();

        String prenom = "", nom ="", titre ="";

        String sqlprenom = "select prenom from member where id_member = '" + txt_id_etudiant.getText().toString() + "';";
        String sqlnom = "select nom from member where id_member = '" + txt_id_etudiant.getText().toString() + "';";
        String sqltitre = "select titre from book where code = '" + txt_code_livre.getText().toString() + "';";

        try {
            PreparedStatement statement1 = connection.prepareStatement(sqlprenom);
            PreparedStatement statement2 = connection.prepareStatement(sqlnom);
            PreparedStatement statement3 = connection.prepareStatement(sqltitre);

            ResultSet resultSet1 = statement1.executeQuery();
            ResultSet resultSet2 = statement2.executeQuery();
            ResultSet resultSet3 = statement3.executeQuery();

            if (resultSet1.next()){
                prenom = resultSet1.getString("prenom");

            }
            if (resultSet2.next()){
                nom = resultSet2.getString("nom");

            }
            if (resultSet3.next()){
                titre = resultSet3.getString("titre");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        txt_info.setText("Informations\nFirst name " + prenom + "\nLast name " + nom + "\nTitre : " + titre);
    }


    @FXML
    void getSelectedEm(MouseEvent event) {
        index = tEmprunteurs.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        txt_id_etudiant.setText(id_etudiant.getCellData(index).toString());
        txt_code_livre.setText(id_livre.getCellData(index).toString());
        txt_date_retour_livre.setText(retour_livre.getCellData(index).toString());

    }
       public void back_em(){
           Main m = new Main();
           try {
               m.changeScene("Dashboard.fxml" , 700 , 400);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
      public void refreshEm(){
        initialize(null , null);
      }
    public void AjouterEm() throws SQLException, ClassNotFoundException {
        conn = mysqlConnectJava.ConnectDb();
        String insert_sql = "Insert into emprunteur(id_etudiant , id_livre , date_retour) values(? , ? , ?)";
        try {
            pst = conn.prepareStatement(insert_sql);
            pst.setInt(1, Integer.parseInt(txt_id_etudiant.getText().toString()));
            pst.setInt(2, Integer.parseInt(txt_code_livre.getText().toString()));
            pst.setString(3, txt_date_retour_livre.getText().toString());
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Set things as you do for livre
        id_etudiant.setCellValueFactory(new PropertyValueFactory<emprunteur, Integer>("etudiant"));
        id_livre.setCellValueFactory(new PropertyValueFactory<emprunteur, Integer>("livre"));
        retour_livre.setCellValueFactory(new PropertyValueFactory<emprunteur, String>("retourLivre"));


        try {
            conn = mysqlConnectJava.ConnectDb();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            listE = mysqlConnectJava.getDataEmprunteur();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tEmprunteurs.setItems(listE);
    }
}
