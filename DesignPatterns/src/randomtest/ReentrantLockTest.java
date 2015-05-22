/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamohan2
 */
public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {

        int[] steps = {2000, 1000, 3000};

        MySharedResource res = new MySharedResource();
        MyThread[] t = new MyThread[3];
        for (int i = 0; i < 3; i++) {

            MyThread m = new MyThread(res, steps[i]);
            t[i]= m;
            m.setName(i + "");
            m.start();
        }

        for(MyThread r : t)
            r.join();
            

        System.out.println(res.readX());

    }
}

class MySharedResource {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int x = 0;

    public void changeX(int cx) {

        lock.writeLock().lock();
        try {
            x = x + cx;

        } finally {
            lock.writeLock().unlock();
        }

    }

    public int readX() {
        lock.readLock().lock();
        try {
            return x;
        } finally {
            lock.readLock().unlock();
        }
    }
}

class MyThread extends Thread {

    private MySharedResource res;
    private int step;

    MyThread(MySharedResource res, int step) {
        this.res = res;
        this.step = step;

    }

    public void run() {

        String tid = Thread.currentThread().getName();
        System.out.println(tid + "  read ->" + res.readX());
        res.changeX(step);
        System.out.println(tid + " writing " + step + " applied.");
        try {
            Thread.sleep(step);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
}
