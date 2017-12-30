/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Pizza;
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
public class PizzaDAO {
    public Pizza getpizza(String idpizza) throws HttpException, IOException, URISyntaxException{
        Gson gson= new Gson();
     return gson.fromJson(RestClient.doGet("http://"+IP.IP_publica()+":8080/Proyecto_pizza/webresources/Pizza/"+idpizza), Pizza.class);
    }
}
