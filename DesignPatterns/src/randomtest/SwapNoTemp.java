/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class SwapNoTemp {

    public static void main(String[] args) {

        int x = 20;
        int y = 30;

        System.out.println("x->"+x);

        System.out.println("y->"+y);

      //  x = x + y;
        //y = x - y;
        //x = x - y;

        x = x * y;
        y = x / y;
        x = x / y;

        System.out.println("x->"+x);

        System.out.println("y->"+y);

        int a = 5; //101
        int b = 4; //100

        System.out.println( a );//010
    }

}
