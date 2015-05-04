/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author kamohan2
 */
public class NumberPairs {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new FileInputStream("t"));
        
        int[] array = {23,11,4,30,90,23};
        int key = 34;

        int countPairs = 0;
        Set<Integer> usedNumbers = new HashSet<Integer>();
        for(int i=0; i < array.length ; i++){

            if(usedNumbers.contains(array[i])) continue;
            
            for(int j=i+1; j< array.length; j++){

                if(usedNumbers.contains(array[j])) continue;

                System.out.println("Comparing - "+array[i] + " " + array[j]);
                if(array[i] + array[j] == key){

                    ++countPairs;

                    usedNumbers.add(array[i]);
                    usedNumbers.add(array[j]);

                    System.out.println("Number pair ->"+array[i]);
                    System.out.println("Number pair ->"+array[j]);
                    
                }

                
            }


        }
        
        System.out.println("Pairs ->"+countPairs);
    }

}
