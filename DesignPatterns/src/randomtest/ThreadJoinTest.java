/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamohan2
 */
public class ThreadJoinTest {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main start");
        MyThread arr[] = new MyThread[3];
        for(int i=0;i < 3; i++){
            
            arr[i] = new MyThread();
            Thread t = new Thread(arr[i]);
            t.setName(i+"");
            t.start();
            t.join();

        }

        String all = "";
        for(MyThread v : arr){

            all += v.getPass();
                    
        }
        System.out.println("Main done ->"+all);
    }

}

class MyThread implements Runnable{

    private String pass;

    public void run(){

        pass = Thread.currentThread().getName();
        System.out.println("Thread running ->"+pass);

        if(pass.equals("2"))
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getPass() {
        return pass;
    }


}