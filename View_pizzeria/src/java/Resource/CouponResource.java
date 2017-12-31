/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Class.Persona;
import ClassDAO.Cupones;
import ClassDAO.PersonaDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.apache.http.HttpException;

/**
 * REST Web Service
 *
 * @author Mago
 */
@Path("Coupon")
public class CouponResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CouponResource
     */
    public CouponResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.CouponResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws HttpException, IOException, URISyntaxException {
    Gson gson= new Gson();
        PersonaDAO best= new PersonaDAO();
            
            Persona premiada= best.best();
             Cupones cupon = new Cupones();
             
             cupon.Cupones_best();
               String retorno=gson.toJson(premiada);
               
            return "{\"El mejor cliente \":"+retorno+"}" ;
    }
           
    }

    /**
     * PUT method for updating or creating an instance of CouponResource
     * @param content representation for the resource
     */
   

