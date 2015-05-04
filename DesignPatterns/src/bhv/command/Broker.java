/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.command;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamohan2
 */
public class Broker {

    List<IOrder> orders = new ArrayList<IOrder>();

    public void placeOrder(IOrder order){

        orders.add(order);
    }


    public void executeOrders(){

      for(IOrder order : orders){
          order.execute();
      }
    }
}
