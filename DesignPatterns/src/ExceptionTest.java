/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kamohan2
 */
public class ExceptionTest {

    public static void main(String[] args) {

        
        A.m1();



    }

  
}

class A {

    static void  m1(){

        System.out.println("A");
    }

}

class B extends A {

    static void  m1(){

        System.out.println("B");
    }

}
