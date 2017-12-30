/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Descuento;
import Class.Pizza;
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
 * @author alexm
 */
public class DescuentoDAO {
    public Descuento Select_Descuento(Date date){
        date.setYear(2017);
        if(date.getDay()==2){
            date.setDate(27);
            date.setMonth(12);
        }
        Connection probar = ConexionDB.conetar();           
        //modificar
        String sql = "SELECT * FROM fecha_descuento WHERE fecha = '" +date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+ "'";
        System.out.println(date.getYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
        //sql="select * from producto  where cod_Prod="+codigo;
        try {
            Statement pst = probar.createStatement();
            ResultSet res = pst.executeQuery(sql);

            if (res.next()) {
                int id_descuento=res.getInt("id_fecha");
                Date fecha = res.getDate("fecha");
                float precio= res.getFloat("porcentaje_descuento");
                String descripcion= res.getString("descrip_descuento");
                return new Descuento(id_descuento, fecha, precio, descripcion);
            }
        } catch (SQLException | HeadlessException e) {
            //JOptionPane.showMessageDialog(null, e.toString());
            e.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null, "problemas en la base de datos");
        return null;
    }
}
