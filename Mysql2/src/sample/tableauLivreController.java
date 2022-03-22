package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;

public class tableauLivreController implements Initializable {
    @FXML
    private TableView<book> tBooks;
    @FXML
    private TableColumn<book, Integer> code_book;
    @FXML
    private TableColumn<book, String> titre_book;
    @FXML
    private TableColumn<book, String> auteur_book;

    @FXML
    private TableColumn<book, String> edition_book;

    @FXML
    private TableColumn<book, Integer> nbExemplaire_book;



    @FXML
    private ImageView bach_arr;


    @FXML
    private ImageView ic_refresh;
    @FXML
    private TextField txt_auteur;

    @FXML
    private TextField txt_edition;

    @FXML
    private TextField txt_nbExemplaire;

    @FXML
    private TextField txt_titre;


    @FXML
    private TextField txt_code;





    ObservableList<book> listF;

    ObservableList<book> getProductList() {
        ObservableList<book> pers = FXCollections.observableArrayList();
        return pers;
    }

    int index = -1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void getSelected(MouseEvent event) {
        index = tBooks.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        txt_code.setText(code_book.getCellData(index).toString());
        txt_titre.setText(titre_book.getCellData(index).toString());
        txt_auteur.setText(auteur_book.getCellData(index).toString());
        txt_edition.setText(edition_book.getCellData(index).toString());
        txt_nbExemplaire.setText(nbExemplaire_book.getCellData(index).toString());

    }


    public tableauLivreController() {
    }

    public void refresh() {
            initialize(null, null);
    }

    public void back() {
        Main m = new Main();
        try {
            m.changeScene("Dashboard.fxml" , 700 , 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modifierLivre(ActionEvent event) throws SQLException, ClassNotFoundException {
        conn = mysqlConnectJava.ConnectDb();

        String titre = txt_titre.getText().toString();
        String auteur = txt_auteur.getText().toString();
        String edition = txt_edition.getText().toString();
        int nbExemplaire = Integer.parseInt(txt_nbExemplaire.getText().toString());
        int code = Integer.parseInt(txt_code.getText().toString());
        String update_sql = "update book set titre = '" + titre + "' ,auteur = '" + auteur + "' ,edition= '" + edition + "' ,nbExemplaire = " + nbExemplaire + " where code = " + code + ";";

        try {
            pst = conn.prepareStatement(update_sql);
//            pst.setString(1 , txt_titre.getText().toString());
//            pst.setString(2, txt_auteur.getText().toString());
//            pst.setString(3 , txt_edition.getText().toString());
//            pst.setInt(4 , Integer.parseInt(txt_nbExemplaire.getText().toString()));
//            pst.setInt(5 , Integer.parseInt(txt_code.getText().toString()));
            pst.execute();
            txt_auteur.setText("");
            txt_code.setText("");
            txt_edition.setText("");
            txt_nbExemplaire.setText("");
            txt_titre.setText("");

        } catch (Exception e) {

        }
    }

    public void ajouterLivre(ActionEvent event) throws SQLException, ClassNotFoundException {
        conn = mysqlConnectJava.ConnectDb();
        String insert_sql = "Insert into book(titre , auteur , edition , nbExemplaire) values(? , ? , ? , ? )";
        try {
            pst = conn.prepareStatement(insert_sql);
            pst.setString(1, txt_titre.getText().toString());
            pst.setString(2, txt_auteur.getText().toString());
            pst.setString(3, txt_edition.getText().toString());
            pst.setInt(4, Integer.parseInt(txt_nbExemplaire.getText().toString()));
            pst.execute();
            txt_auteur.setText("");
            txt_code.setText("");
            txt_edition.setText("");
            txt_nbExemplaire.setText("");
            txt_titre.setText("");

        } catch (Exception e) {

        }
    }

    public void supprimerLivre(ActionEvent event) throws SQLException, ClassNotFoundException {
        conn = mysqlConnectJava.ConnectDb();
        int code = Integer.parseInt(txt_code.getText().toString());
//        String titre = txt_titre.getText().toString();
        String delete_sql = "delete from book where code = " + code + ";";
        try {
            pst = conn.prepareStatement(delete_sql);
            //   pst.setString(1 , txt_titre.getText().toString());
            pst.execute();
            txt_auteur.setText("");
            txt_code.setText("");
            txt_edition.setText("");
            txt_nbExemplaire.setText("");
            txt_titre.setText("");
            //     UpdateTable();

        } catch (Exception e) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        code_book.setCellValueFactory(new PropertyValueFactory<book, Integer>("code"));
        titre_book.setCellValueFactory(new PropertyValueFactory<book, String>("titre"));
        auteur_book.setCellValueFactory(new PropertyValueFactory<book, String>("auteur"));
        edition_book.setCellValueFactory(new PropertyValueFactory<book, String>("edition"));
        nbExemplaire_book.setCellValueFactory(new PropertyValueFactory<book, Integer>("nbExemplaire"));

        try {
            conn = mysqlConnectJava.ConnectDb();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            listF = mysqlConnectJava.getDataBook();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        tBooks.setItems(listF);
    }

}
