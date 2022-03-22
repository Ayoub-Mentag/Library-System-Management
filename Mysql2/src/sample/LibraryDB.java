package sample;

import java.sql.*;


public class LibraryDB {
     public boolean validateLogin(String username , String password) throws SQLException, ClassNotFoundException {
         Connection connection = mysqlConnectJava.ConnectDb();
         String url = "jdbc:mysql://localhost:3306/Library";
         String root = "root";
         String pass = "1234";

         try {

             String sql = "SELECT * FROM admin WHERE admin = ? AND password = ?;";
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1, username);
             statement.setString(2, password);
             ResultSet resultSet = statement.executeQuery();

             if(resultSet.next()){
                 return true;
             }

         } catch (SQLException e) {
             System.out.println("Ooops, error");
             e.printStackTrace();
         }
         return false;
     }
}
