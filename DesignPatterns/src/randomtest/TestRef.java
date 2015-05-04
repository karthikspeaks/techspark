/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

/**
 *
 * @author kamohan2
 */
public class TestRef {

    public static void main(String[] args) {

        A a = new A(1);
        
        System.out.println(a);

        change(a);
        System.out.println(a + "after ");

    }

   static void  change(A a){

        a = new A(5);

        System.out.println(a +" in ");
    }

}

class A{

    int a;

    A(int x){
        a= x;
    }

    public String toString(){
        return ""+a;
    }

}
