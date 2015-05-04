/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class Exceptiontest {

    public static void main(String[] args) {

        try{

            throw new java.lang.NullPointerException("hi");

        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
