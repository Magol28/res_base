/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Mago
 */
public class Pedido_pizza {
    private int ID_pizza;
    private int ID_pedido;
   private int Cantidad;

    public Pedido_pizza(int ID_pizza, int ID_pedido, int Cantidad) {
        this.ID_pizza = ID_pizza;
        this.ID_pedido = ID_pedido;
        this.Cantidad = Cantidad;
    }

   

    public Pedido_pizza() {
    }

    /**
     * @return the ID_pizza
     */
    public int getID_pizza() {
        return ID_pizza;
    }

    /**
     * @param ID_pizza the ID_pizza to set
     */
    public void setID_pizza(int ID_pizza) {
        this.ID_pizza = ID_pizza;
    }

    /**
     * @return the ID_Pedido
     */
   

    /**
     * @return the ID_pedido
     */
    public int getID_pedido() {
        return ID_pedido;
    }

    /**
     * @param ID_pedido the ID_pedido to set
     */
    public void setID_pedido(int ID_pedido) {
        this.ID_pedido = ID_pedido;
    }

    /**
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
}
