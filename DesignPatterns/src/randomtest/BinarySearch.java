/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class BinarySearch {

    public static void main(String[] args) {

        int x[] = {10,11,23,45,89,100};
        int key = 45;

        new BinarySearch().binarySearch(x,0, x.length-1,key);
        
    }

    public void binarySearch(int x[], int low,int high,int key){

        int mid = (low + high )/2;

        if(x[mid] == key) System.out.println("Found");
        else if(x[mid] > key){
            binarySearch(x, mid, high, key);
        }
        else if(x[mid] < key){
          binarySearch(x, 0, mid, key);
        }

        

    }
}
