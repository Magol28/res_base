/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Class.Pedido;
import Class.Total_Pedido;
import com.google.gson.Gson;
import ClassDAO.PedidoDAO;
import ClassDAO.Total_PedidoDAO;
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
@Path("Pedido")
public class PedidoResource {

    @Context
    private UriInfo context;

    /**
     *   private int ID_pedido;
     private int ID;
     private float total_pedido;
     */
    public PedidoResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.PedidoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{ID_pedido}")
    public String getJson(@PathParam("ID_pedido")int ID_pedido) {
        //TODO return proper representation object
        Gson gson=new Gson();
        Total_PedidoDAO a=new Total_PedidoDAO();
        System.out.println(ID_pedido);
        Total_Pedido pedido= a.get_pedido(ID_pedido);
        return gson.toJson(pedido);
    }

    /**
     * PUT method for updating or creating an instance of PedidoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     @Path("/{ID_pedido}/{ID}/{total_pedido}")   
    public void putJson(@PathParam("ID_pedido") int ID_pedido,@PathParam("ID") int ID,@PathParam("total_pedido") float total_pedido) throws SQLException {
        
        PedidoDAO  add= new PedidoDAO();
        Pedido nuevo= new Pedido(ID_pedido,ID,total_pedido);
        
         add.insert(nuevo);
        
        
       
    }
}
