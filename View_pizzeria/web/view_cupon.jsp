<%-- 
    Document   : view_cupon
    Created on : 30/12/2017, 11:28:42
    Author     : Mago
--%>

<%@page import="Class.Persona"%>
<%@page import="ClassDAO.Cupones"%>
<%@page import="Class.Cupon"%>
<%@page import="ClassDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Generación de cupones</h1>
        <form method="GET" >
            <label>  Generar cupos para el mejor cliente </label>
            <input type="submit">
           </form>
        <%
           
         try {
                
                PersonaDAO best= new PersonaDAO();
            
            Persona premiada= best.best();
             Cupones cupon = new Cupones();
             
             cupon.Cupones_best();
               
             out.println("Se genero un cupon para "+ "nombre:"+ premiada.getNombre()+"  Apellido: "+ premiada.getApellido());
           
            } catch (Exception e) {
                    out.println(e.toString());
                }
                
          
         

                %>
    </body>
</html>
