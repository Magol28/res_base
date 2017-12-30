/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import ClassDAO.PersonaDAO;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mago
 */
@Path("Best_Customer")
public class Best_CustomerResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Best_CustomerResource
     */
    public Best_CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.Best_CustomerResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       Gson gson = new Gson();
        PersonaDAO best= new PersonaDAO();
         
            return gson.toJson(best.best_customer());    
       
    }

    /**
     * PUT method for updating or creating an instance of Best_CustomerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
