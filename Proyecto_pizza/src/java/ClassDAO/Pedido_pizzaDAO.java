/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Pedido_pizza;
import Control.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mago
 */
public class Pedido_pizzaDAO {
     public void insert(Pedido_pizza add) throws SQLException {
        Connection dbConnection = ConexionDB.conetar();
        String insertTableSQL = "INSERT INTO pedido_pizza"
                + "( ID_pizza, ID_pedido,Cantidad) VALUES"
                + "(?,?,?)";

        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, add.getID_pizza());
            preparedStatement.setInt(2, add.getID_Pedido());
            
            preparedStatement.setInt(3, add.getCantidad());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into   Pedido_pizza table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        dbConnection.close();

        
    }
}
