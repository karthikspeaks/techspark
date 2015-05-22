/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class StringPaliandrome {

    public static void main(String[] args) {

        String yes = "Red rum, sir, is murder";
        String no = "Programcreek is awesome";

        System.out.println("yes->"+new StringPaliandrome().isPaliandrome(no));

        
    }

    public boolean isPaliandrome(String string){

        string = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int fp = 0;
        int bp = string.length()-1;


        int mid= (fp + (bp-fp))/2;
        while(fp< mid && bp> mid){

            System.out.println("string.charAt(fp)->"+string.charAt(fp));
            System.out.println("string.charAt(bp)->"+string.charAt(bp));
            
            if(string.charAt(fp) != string.charAt(bp))
            {
                return false;
            }

            fp++;
            bp--;
        }

        return true;
    }

}
