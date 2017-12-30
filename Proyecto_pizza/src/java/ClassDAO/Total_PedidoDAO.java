/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Persona;
import Class.Pizza;
import Class.Total_Pedido;
import Control.ConexionDB;
import com.mysql.jdbc.*;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexm
 */
public class Total_PedidoDAO {
    public Total_Pedido get_pedido(int id){
        Total_Pedido pedido=null;
        Connection probar = (Connection) ConexionDB.conetar();           
        //modificar
        String sql = "SELECT a.id_pedido,b.id,b.nombre,b.apellido,a.total_pedido,c.porcentaje_descuento "
                + "FROM pedido a, persona b, fecha_descuento c "
                + "WHERE a.id_pedido=1 AND a.id=b.id AND a.id_fecha=c.id_fecha;";
        //sql="select * from producto  where cod_Prod="+codigo;
        try {
            Statement pst = (Statement) probar.createStatement();
            ResultSet res = pst.executeQuery(sql);
            //System.out.println(id);
            if (res.next()) {
                int id_pedido= res.getInt("id_pedido");
                int id_user=res.getInt("id");                
                String nombre = res.getString("nombre");
                String apellido= res.getString("apellido");
                float total= res.getFloat("total_pedido");
                float descuento = res.getFloat("porcentaje_descuento");
                System.out.println(id_pedido);
                pedido=new Total_Pedido(id_pedido,new Persona(id_user,nombre,apellido,null),total,descuento,new ArrayList<Pizza>());
                
            }
            probar.close();
         //agregando mas elementos al pedido
         
        } catch (SQLException | HeadlessException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
        
        probar = (Connection) ConexionDB.conetar();           
        //modificar
        sql = "select a.id_pizza, a.nombre, a.precio,b.cantidad "
                + "FROM pizza a, pedido_pizza b "
                + "WHERE b.id_pedido='"+id+"' AND a.id_pizza=b.id_pizza; ";
        //sql="select * from producto  where cod_Prod="+codigo;
        try {
            Statement pst = (Statement) probar.createStatement();
            ResultSet res = pst.executeQuery(sql);

            while (res.next()) {
                int id_pizza= res.getInt("id_pizza");         
                String nombre = res.getString("nombre");              
                float precio= res.getFloat("precio");
                int cantidad= res.getInt("cantidad");
                Pizza pizza=new Pizza(id_pizza, nombre, "", precio, cantidad);
                pedido.getDetalle_pedido().add(pizza);
            }
            probar.close();
         //agregando mas elementos al pedido
         
        } catch (SQLException | HeadlessException e) {
            System.out.println("Error en la base de datos");
        }
        return pedido;
    }
}
