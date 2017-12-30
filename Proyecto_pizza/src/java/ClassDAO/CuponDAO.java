/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Cupon;
import Control.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mago
 */
public class CuponDAO {
  public void insert(Cupon add) throws SQLException {
        Connection dbConnection = ConexionDB.conetar();
        String insertTableSQL = "INSERT INTO cupon"
                + "( ID) VALUES"
                + "(?)";
             System.out.println("cupones");

        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, add.getID());
            
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into   cupon table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        dbConnection.close();


    }    
}
