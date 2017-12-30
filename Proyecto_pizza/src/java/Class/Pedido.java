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
public class Pedido {
     private int ID_pedido;
     private int ID;
     private float total_pedido;

    public Pedido(int ID_pedido, int ID, float total_pedido) {
        this.ID_pedido = ID_pedido;
        this.ID = ID;
        this.total_pedido = total_pedido;
    }

    public Pedido() {
    }

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
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the total_pedido
     */
    public float getTotal_pedido() {
        return total_pedido;
    }

    /**
     * @param total_pedido the total_pedido to set
     */
    public void setTotal_pedido(float total_pedido) {
        this.total_pedido = total_pedido;
    }


    
}
