/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Class.Descuento;
import Class.Persona;
import ClassDAO.DescuentoDAO;
import ClassDAO.PersonaDAO;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.Calendar;
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
 * @author Cesar Obando
 */
@Path("descuento")
public class DescuentoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DescuentoResource
     */
    public DescuentoResource() {
    }

    /**
     * Retrieves representation of an instance of Resource.DescuentoResource
     * @param birthdateClient
     * @param total
     * @return an instance of java.lang.String
     */


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("edad/{date}/{value}")    
    public String getJson(@PathParam("date") String birthdateClient,@PathParam("value") float total ) {
       
            Gson gson= new Gson();
                     String [] datos= (birthdateClient.split("-"));
            
            Calendar cal= Calendar.getInstance();
                     
            int now = cal.get(Calendar.YEAR); 
            Date birthdate  = new Date(Integer.parseInt(datos[0]), Integer.parseInt (datos[1]), Integer.parseInt(datos[2]));

            
            Float value=(float)0,discount=(float)0;

            int anios = now - birthdate.getYear();

            if(anios<0)
            {
                return gson.toJson("-1:"+total);
            }
            if(anios > 21 && anios <30 )
            {

                discount= (float)(total*0.12);
                value = total - discount;
                return gson.toJson(discount+":"+value);
            }

            return gson.toJson("-1:"+total);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{date}")
    public String getDiscount(@PathParam("date") String date){
        String[] datefull=date.split("@");
        Date toexamine=new Date(Integer.parseInt(datefull[0]),Integer.parseInt(datefull[1])-1,Integer.parseInt(datefull[2]));
        DescuentoDAO descdao=new DescuentoDAO();
        Gson gson=new Gson(); 
        String json= gson.toJson(descdao.Select_Descuento(toexamine));
        if(json.equals("null")) return "a";
        return json;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("bday/{date}/user/{id}")
    public String getDiscountBDay(@PathParam("date") String date,@PathParam("id") String id){
        Persona tocheck_person= new PersonaDAO().Select_persona(Integer.parseInt(id));
        String[] datefull=date.split("@");
        Gson gson=new Gson();
        System.out.println(datefull[2]);
        if(tocheck_person.getFecha_de_nacimiento().getDate()==Integer.parseInt(datefull[2])
           &&tocheck_person.getFecha_de_nacimiento().getMonth()==(Integer.parseInt(datefull[1])-1)){
            return gson.toJson(new Descuento(1,tocheck_person.getFecha_de_nacimiento(), (float) 0.1,"Feliz Cumpleaños!!!"));
        }
        return "a";
    }
    
    
}
