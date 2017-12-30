/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Mago
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Resource.Best_CustomerResource.class);
        resources.add(Resource.ClientResource.class);
        resources.add(Resource.CuponResource.class);
        resources.add(Resource.DescuentoResource.class);
        resources.add(Resource.MaxidResource.class);
        resources.add(Resource.PedidoResource.class);
        resources.add(Resource.Pedido_pizzaResource.class);
        resources.add(Resource.PizzaResource.class);
    }
    
}
