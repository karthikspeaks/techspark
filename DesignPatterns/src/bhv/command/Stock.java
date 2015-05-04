/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.command;

/**
 *
 * @author kamohan2
 */
public class Stock {

    private int qty;

    private String symbol;

    public Stock(String symbol,int qty) {
        this.qty = qty;
        this.symbol = symbol;
    }

    

    public void buy(){
         System.out.print("Bought "+qty+" of "+symbol);
    }

    public void sell(){

        System.out.print("Sold "+qty+" of "+symbol);
    }

}
