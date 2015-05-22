/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class StringReverse {

    public static void main(String[] args) {

        String s = "abcdef";

        int len = s.length()-1;
        String rev = "";
        while(len >=0 ){

            rev+=s.charAt(len--);
        }
        System.out.println("rev -"+rev);
    }

}
