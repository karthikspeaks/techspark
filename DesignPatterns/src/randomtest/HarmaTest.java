/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

/**
 *
 * @author kamohan2
 */
public class HarmaTest {

    public static void main(String[] args) {

        String[] arr1 = {"4", "8", "3", "6"};


        System.out.println(new HarmaTest().xyx(arr1));

    }

    public boolean xyx(String[] arr) {

        int size = arr.length;
        if (size != 4) {
            System.out.println("size check");
            return false;
        }

        int[] intarr = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {

            try {

                int num = Integer.parseInt(arr[i]);

                int q = num / 10;

                if (q != 0) {
                    System.out.println("q check");
                    return false;
                }

                intarr[count++] = num;

            } catch (Exception e) {
                return false;
            }

        }

        for (int j = 0; j < size; j++) {

            if (j > 0 && j < size - 1) {
                if (Math.abs(intarr[j] - intarr[j + 1]) == 1 || Math.abs(intarr[j + 1] - intarr[j]) == 1) {
                    System.out.println("j check");
                    return false;
                }
            }
        }

        return true;
    }
}
