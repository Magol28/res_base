/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Persona;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpException;
import utils.IP;
import utils.RestClient;

/**
 *
 * @author Mago
 */
public class Cupones {
    public void Cupones_best() throws IOException, HttpException, URISyntaxException{
        PersonaDAO customer= new PersonaDAO();
        Persona premiada= customer.best();
        System.out.println(premiada.getID());
        RestClient.doPut("http://"+IP.IP_publica()+":8080/Proyecto_pizza/webresources/Cupon/"+premiada.getID(),"");
        
        
        
    }
    
}
