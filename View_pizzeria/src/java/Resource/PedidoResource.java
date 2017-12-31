/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Class.Pedido;
import Class.Pedido_pizza;
import Class.Persona;
import Class.Pizza;
import ClassDAO.PedidoDAO;
import ClassDAO.Pedido_pizzaDAO;
import ClassDAO.PersonaDAO;
import ClassDAO.PizzaDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mago
 */
@Path("Pedido")
public class PedidoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidoResource
     */
    public PedidoResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.PedidoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{ID_cliente}/{ID_pizza}/{quantity}")  
    public String getXml(@PathParam("ID_cliente") int ID_cliente,@PathParam("ID_pizza") int ID_pizza,@PathParam("quantity") int quantity) {
       try {
                
                
           
            int  cantidad=quantity;
            
            
             PersonaDAO personadao= new PersonaDAO();
             PizzaDAO pizzdao= new PizzaDAO();
             PedidoDAO pedidodao = new PedidoDAO();
             Pedido_pizzaDAO Pedido_pizzadao=new Pedido_pizzaDAO();
                     
             int id_siguinete= personadao.ID_maximo()+1;
            
            
            
            Persona persona= personadao.getPersona(ID_cliente+"");
            Pizza pizza= pizzdao.getpizza(ID_pizza+"");
            
            
            
            
            Pedido_pizza pedido_pizza= new Pedido_pizza(pizza.getID_pizza(), id_siguinete, cantidad);
            Pedido pedido= new Pedido(id_siguinete,persona.getID() , (float)(pizza.getPrecio()*cantidad));
            
            
            
            pedido.setID_pedido(id_siguinete);
            
            
           pedidodao.putPedido(pedido);
           Pedido_pizzadao.putPedido_pizzaDAO(pedido_pizza);
            
               String retorno="{ \" Pedido número  \": "+id_siguinete+","  
                        + "\" pizza de \" :\""+pizza.getNombre()+"\","
                       + " \"cantidad \":"+quantity+","
                       + "\" precio \": "+pedido.getTotal_pedido()+"}";
           
               return retorno;
            } catch (Exception e) {
                System.out.println(e.toString()
                );
                }
                
                        
                        return null;
    }

    /**
     * PUT method for updating or creating an instance of PedidoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
