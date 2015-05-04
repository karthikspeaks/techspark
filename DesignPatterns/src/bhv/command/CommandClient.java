/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.command;

/**
 *
 * @author kamohan2
 */
public class CommandClient {

    public static void main(String[] args) {

        Broker b = new Broker();

        b.placeOrder(new BuyOrder("ABC",100));
        b.placeOrder(new BuyOrder("HBO",100));

        b.placeOrder(new SellOrder("ABC",10));
         
        b.executeOrders();


    }

}
