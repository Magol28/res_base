/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Pizza;

import Control.ConexionDB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mago
 */
public class PizzaDAO {
    
    public Pizza Select_pizza(int  id){
            Connection probar = ConexionDB.conetar();

                

        //modificar
        String sql = "SELECT * FROM pizza WHERE ID_PIZZA = '" + id + "'";
        //sql="select * from producto  where cod_Prod="+codigo;
        try {
            Statement pst = probar.createStatement();
            ResultSet res = pst.executeQuery(sql);

            if (res.next()) {
                 int ID_pizza=res.getInt("ID_pizza");
    
     
    
                
                String Nombre = res.getString("Nombre");
                String Categoria= res.getString("Categoria");

                 float precio= res.getFloat("precio");
                 

                return new Pizza (ID_pizza, Nombre, Categoria, precio);
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        JOptionPane.showMessageDialog(null, "problemas en la base de datos");
        return null;
    }
}
