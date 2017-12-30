/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Persona;
import Control.ConexionDB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Mago
 */
public class PersonaDAO {
    
      public Persona Select_persona(int  id){
            Connection probar = ConexionDB.conetar();

                

     
        //modificar
        String sql = "SELECT * FROM persona WHERE ID = '" + id + "'";
        //sql="select * from producto  where cod_Prod="+codigo;
        try {
            Statement pst = probar.createStatement();
            ResultSet res = pst.executeQuery(sql);

            if (res.next()) {
                 int ID=res.getInt("ID");
    
     
    
                
                String Nombre = res.getString("Nombre");
                String Apellido= res.getString("Apellido");

                 Date  Fecha_de_nacimiento= res.getDate("Fecha_de_nacimiento");
                 probar.close();
                return new Persona (ID, Nombre, Apellido, Fecha_de_nacimiento);
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        JOptionPane.showMessageDialog(null, "problemas en la base de datos");
        return null;
    }
      public Persona  best_customer(){
          Connection probar = ConexionDB.conetar();
          String sql="SELECT id, count(id) FROM pedido group by id   order  by  count(id) desc";
          try {
            Statement pst = probar.createStatement();
            ResultSet res = pst.executeQuery(sql);

            if (res.next()) {
                 int ID=res.getInt("id");
                 
                 probar.close();
                        
                 return Select_persona(ID);
                
               
                 

               
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        JOptionPane.showMessageDialog(null, "problemas en la base de datos");
        return null;
      }
}
