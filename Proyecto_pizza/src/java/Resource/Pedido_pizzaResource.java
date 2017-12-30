/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Class.Pedido_pizza;
import ClassDAO.Pedido_pizzaDAO;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("Pedido_pizza")
public class Pedido_pizzaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Pedido_pizzaResource
     */
    public Pedido_pizzaResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.Pedido_pizzaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     *   private int ID_pizza;
    private int ID_pedido;
   private int Cantidad;
     * PUT method for updating or creating an instance of Pedido_pizzaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     @Path("/{ID_pizza}/{ID_pedido}/{Cantidad}")    
    public void putJson(@PathParam("ID_pizza") int ID_pizza,@PathParam("ID_pedido") int ID_pedido,@PathParam("Cantidad") int Cantidad) throws SQLException {
        
        
        Pedido_pizzaDAO add= new Pedido_pizzaDAO();
        add.insert(new Pedido_pizza(ID_pizza,ID_pedido,Cantidad))
        ;
    }
}
