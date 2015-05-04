/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] items = {100,23,70,9,50,8,56,12,78};

        new BubbleSort().bubbleSort(items);

        for(int i : items)
            System.out.println("\t->"+i);
    }

    public void bubbleSort(int[] items) {

        for (int pass = 0; pass <= items.length - 2; pass++) {

            for (int i = 0; i <= items.length - pass - 2; i++) {

                if (items[i] > items[i + 1]) {

                    int temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                }


            }

        }
    }
}
