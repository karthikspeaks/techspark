/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author kamohan2
 */
public class LongestConsecutiveSeq {

    public static void main(String[] args) {

        int a[] = {100, 4, 200, 9, 10,3, 2};

        new QuickSort().sort(a, 0, a.length - 1);

        Set s = new HashSet();
        int length = 0;


        int prev = -1;
        boolean init = true;
        for (int x : a) {


            if (Math.abs(x - prev) == 1 || init) {
                s.add(x);
                length++;

                prev = x;

                init = false;
            }
        }

        System.out.println("Length="+length);
        System.out.println("Sequence ->"+s);
    }
}
