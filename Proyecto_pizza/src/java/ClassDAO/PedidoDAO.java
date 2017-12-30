/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Pedido;
import Control.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 *       private int ID_pedido;
     private int ID;
     private float total_pedido;
 * @author Mago
 */
public class PedidoDAO {
    
    
         public void insert(Pedido add) throws SQLException {
        Connection dbConnection = ConexionDB.conetar();
        String insertTableSQL = "INSERT INTO pedido"
                + "( ID_PEDIDO,TOTAL_PEDIDO,ID) VALUES"
                + "(?,?,?)";
             System.out.println("llego");

        try {

            PreparedStatement preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, add.getID_pedido());
            
            preparedStatement.setFloat(2, add.getTotal_pedido());
            preparedStatement.setInt(3, add.getID());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into   Pedido_pizza table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        dbConnection.close();


    }
}
