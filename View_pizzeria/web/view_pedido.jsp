<%-- 
    Document   : view_pedido
    Created on : 16/12/2017, 16:05:42
    Author     : Mago
--%>

<%@page import="ClassDAO.Pedido_pizzaDAO"%>
<%@page import="ClassDAO.PedidoDAO"%>
<%@page import="ClassDAO.PizzaDAO"%>
<%@page import="ClassDAO.PersonaDAO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="Class.Pizza"%>
<%@page import="Class.Persona"%>
<%@page import="Class.Pedido_pizza"%>
<%@page import="Class.Pedido"%>
<%@page import="utils.RestClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1> Realizar pedido </h1>
        <form method="GET" >
            <label>  ID del cliente </label>
            <input  type="text"  name="txtid"   >
             <label>  ID  de la pizza </label>
            <input type="text" name="txtidpizza">
            <label>  Cantidad de pizzas </label>
            <input type="text" name="txtcantidad">
            <input type="submit">
           </form>
            
            <%
                
            try {
                
                
            String idclient=request.getParameter("txtid");
            String idpizza=request.getParameter("txtidpizza");
            int  cantidad=Integer.parseInt(request.getParameter("txtcantidad"));
            
            
             PersonaDAO personadao= new PersonaDAO();
             PizzaDAO pizzdao= new PizzaDAO();
             PedidoDAO pedidodao = new PedidoDAO();
             Pedido_pizzaDAO Pedido_pizzadao=new Pedido_pizzaDAO();
                     
             int id_siguinete= personadao.ID_maximo()+1;
            
            
            
            Persona persona= personadao.getPersona(idclient);
            Pizza pizza= pizzdao.getpizza(idpizza);
            
            
            
            
            Pedido_pizza pedido_pizza= new Pedido_pizza(pizza.getID_pizza(), id_siguinete, cantidad);
            Pedido pedido= new Pedido(id_siguinete,persona.getID() , (float)(pizza.getPrecio()*cantidad));
            
            
            
            pedido.setID_pedido(id_siguinete);
            
            
           pedidodao.putPedido(pedido);
           Pedido_pizzadao.putPedido_pizzaDAO(pedido_pizza);
            
               
           
            } catch (Exception e) {
                    out.println(e.toString());
                }
                
          
         

                %>

        
    </body>
</html>
