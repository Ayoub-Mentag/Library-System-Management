package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class mysqlConnectJava {
     private static  Connection connection;

    public  static  Connection ConnectDb() throws ClassNotFoundException, SQLException {

        String dbName="library";
        String userName="root";
        String password="";
        try {

             connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
//        try {
//            Connection conn = DriverManager.getConnection(url, "root", "1234");
//            return conn;
//        } catch (Exception e) {
//            return null;
//        }
    }


    public static ObservableList<book> getDataBook() throws SQLException, ClassNotFoundException {
        Connection con = ConnectDb();
        ObservableList<book> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("select * from book");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new book(Integer.parseInt(rs.getString("Code")), rs.getString("Titre"),
                        rs.getString("Auteur"), rs.getString("Edition"),
                        Integer.parseInt(rs.getString("NbExemplaire")) ) );


            }
        } catch (Exception e) {
        } finally {

            try {

            } catch (Exception e) {
            }
        }
        return list;
    }
    public static ObservableList<member> getDataMember() throws SQLException, ClassNotFoundException {
        Connection con = ConnectDb();
        ObservableList<member> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("select * from member");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new member(
                        rs.getInt("id_member") , rs.getString("user_name"),
                        rs.getString("password"), rs.getString("prenom"),
                        rs.getString("nom"), rs.getString("nCart") , rs.getString("adresse")
                        , rs.getString("ville") , rs.getString("pays") ,rs.getString("email")
                        , rs.getString("telephone") , rs.getString("profession") ,rs.getString("anne_etude")
                        , rs.getString("specialite")
                            ));

            }
        } catch (Exception e) {
        } finally {

            try {

            } catch (Exception e) {
            }
        }
        System.out.println(list.size());
        return list;
    }

    public static ObservableList<emprunteur> getDataEmprunteur() throws SQLException, ClassNotFoundException{
        Connection con = ConnectDb();
        ObservableList<emprunteur> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("select * from emprunteur");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new emprunteur(
                        rs.getInt("id_etudiant") , rs.getInt("id_livre"),
                        rs.getString("date_retour")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {

            } catch (Exception e) {
            }
        }
        return list;
    }



}


