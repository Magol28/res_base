    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class ConexionDB {
   static Connection  conecta= null;

    public static Connection conetar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conecta =DriverManager.getConnection("jdbc:mysql://localhost/avanzada","root","7895123va");
            System.out.println("Conecta");
            
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.out.println("error");
        }
        return conecta;
    }
    
}
