/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.command;

/**
 *
 * @author kamohan2
 */
public class SellOrder implements IOrder {

    Stock stock;

    SellOrder(String symbol,int qty){

        stock = new Stock(symbol,qty);
    }
    

    public void execute() {
        stock.sell();
    }

}
