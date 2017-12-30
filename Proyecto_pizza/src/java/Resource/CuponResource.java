/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Class.Cupon;
import ClassDAO.CuponDAO;
import java.sql.SQLException;
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
@Path("Cupon")
public class CuponResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CuponResource
     */
    public CuponResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.CuponResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CuponResource
     * @param ID
     * @throws java.sql.SQLException
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     @Path("/{ID}")   
    public void putjson(@PathParam("ID") int ID) throws SQLException {
        CuponDAO cupon = new CuponDAO();
        System.out.println("llego al put");
        cupon.insert(new Cupon(ID,0));
        
    }
}
