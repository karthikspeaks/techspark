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
public class StringTests {

    public static void main(String[] args) {

        //String s1 = new String("abc");

        //String s2 = new String("abc");

        //System.out.println(s1 == s2);

        StringResource res = new StringResource();

        Thread t = new Thread(new MyThread(res));
        t.setName("A");

        Thread t1 = new Thread(new MyThread(res));
        t1.setName("B");

        t.start(); t1.start();

    }

}

class StringResource {

    String s = "abc";

    public void changeS(String s) {

        synchronized (s) {
            try {
                 Thread.sleep(10000);
                System.out.println(Thread.currentThread().getName());
               
                this.s = s;
            } catch (InterruptedException ex) {
                Logger.getLogger(StringResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getS() {
        return s;
    }
}

class MyThread implements Runnable {

    StringResource res;

    MyThread(StringResource res){
        this.res = res;
    }

    public void run() {

        try {
            
            String name = Thread.currentThread().getName();
            System.out.println("*********************"+name);
            System.out.println(" get S ->"+res.getS());
            res.changeS(name + " " + System.currentTimeMillis());
            Thread.sleep(10000);

            System.out.println("*********************"+name);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
