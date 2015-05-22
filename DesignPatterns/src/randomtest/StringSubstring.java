/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class StringSubstring {

    public static void main(String[] args) {

        String str = "abc";

        int v = str.length();

        for (int i = 0; i < v; i++) {

            for (int j = 1; j <= v - i; j++) {
                String sub = str.substring(i, i + j);

                System.out.println(sub);
            }



        }


    }
}
