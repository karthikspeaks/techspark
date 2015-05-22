/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class Tests {

    public static void main(String[] args) {

        int a[] = {51, 31, 21, 11,10};

        int v = new Tests().maxDifference(a);

        System.out.println(v);

    }

    public int maxDifference(int[] a) {


        //as per the method retun contract.
        int maxDifferenceValue = -1;


        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {

                if (a[i] < a[j]) {

                    int diff = a[j] - a[i];

                    if (diff > maxDifferenceValue) {
                        maxDifferenceValue = diff;
                    }
                }
            }
        }

        return maxDifferenceValue;

    }
}
