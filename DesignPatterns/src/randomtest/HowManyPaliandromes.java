/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class HowManyPaliandromes {

    public static void main(String[] args) {


        String s = "abc";

        for(int i=0;i < s.length(); i++){

            for(int j=i+1; j < s.length() ; j++){

                char ia = s.charAt(i);
                char ib = s.charAt(j);

                String a = String.valueOf(ia)+ String.valueOf(ib);
                
                System.out.println(a);
            }
        }
        


    }

}
