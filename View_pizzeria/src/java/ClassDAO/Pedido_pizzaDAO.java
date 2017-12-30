/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassDAO;

import Class.Pedido_pizza;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.http.HttpException;
import utils.IP;
import utils.RestClient;

/**
 *
 * @author Mago
 */
public class Pedido_pizzaDAO {
    public void putPedido_pizzaDAO(Pedido_pizza pedido_pizza) throws URISyntaxException, HttpException, IOException{
     RestClient.doPut("http://"+IP.IP_publica()+":8080/Proyecto_pizza/webresources/Pedido_pizza/"+pedido_pizza.getID_pizza()+"/"+pedido_pizza.getID_pedido()+"/"+pedido_pizza.getCantidad()+"","");
           
    }
}
