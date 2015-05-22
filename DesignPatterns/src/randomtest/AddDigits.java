/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class AddDigits {

    public static void main(String[] args) {

        int x = 23511111;

        int sum = 0;

        while (x > 0) {
            sum += x % 10;

            x = x / 10;

        }
        System.out.println("Sum ->" + sum);
    }
}
