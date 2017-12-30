/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Persona;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpException;
import utils.IP;
import utils.RestClient;


/**
 *
 * @author Mago
 */
public class PersonaDAO {

    public int ID_maximo() throws HttpException, IOException, URISyntaxException{
          Gson gson= new Gson();

    
         return gson.fromJson(RestClient.doGet("http://"+IP.IP_publica()+":8080/Proyecto_pizza/webresources/maxid"), int.class);
    }
    
    
    public Persona getPersona(String id) throws HttpException, IOException, URISyntaxException{
        Gson gson= new Gson();
     return gson.fromJson(RestClient.doGet("http://"+IP.IP_publica()+":8080/Proyecto_pizza/webresources/Client/"+id), Persona.class);
    }
    public Persona best() throws HttpException, IOException, URISyntaxException{
        Gson gson= new Gson();
         Persona nueva ;
       
              nueva= gson.fromJson(RestClient.doGet("http://"+IP.IP_publica()+":8080/Proyecto_pizza/webresources/Best_Customer"), Persona.class);
      
        return nueva;      
    }
}
