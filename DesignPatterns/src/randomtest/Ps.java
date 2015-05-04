/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class Ps {

    public static void main(String[] args) {

    new Ps().palindrome("aabaa");

    }

     static int palindrome(String str) {

        int count = 0;
        for(int i=0; i< str.length(); i++){
            for(int j=1; j < str.length(); j++){
                String sub = str.substring(i,j);
                System.out.println(sub);
            }
        }
        return count;
    }
}
