/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class QuickSort {

    public static void main(String[] args) {

        int a[] = {100, 4, 200, 1, 3, 2};

        new QuickSort().sort(a, 0, a.length - 1);

        for (int x : a) {
            System.out.println(x);
        }
    }

    public void sort(int a[], int low, int high) {

        if (a == null || a.length == 0) {
            return;
        }

        int i = low;
        int j = high;

        int mid = (low + (high - low) / 2);

        int pivot = a[mid];

        while (i <= j) {


            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }

            if (i <= j) {

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                i++;
                j--;
            }

        }

        if (low < j) {
            sort(a, low, j);
        }
        if (i < high) {
            sort(a, i, high);
        }




    }
}
