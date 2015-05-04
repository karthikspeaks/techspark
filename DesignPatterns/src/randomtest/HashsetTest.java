/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author kamohan2
 */
public class HashsetTest {

    public static void main(String[] args) {

        Set s = new LinkedHashSet();

        s.add(new Employee(1,"A"));
        s.add(new Employee(2,"B"));
        s.add(new Employee(2,"B"));

        System.out.println(s);


    }

}

class Employee implements Comparable{

    int id;
    String name;


    Employee(int id,String name){
        this.id = id;
        this.name = name;
    }


    public boolean equals(Object obj){

        Employee in = (Employee)obj;

        return in.id == this.id;


    }

    public int hashCode(){
        return id;
    }

    public String toString(){

        return id+" - "+name;
    }

    public int compareTo(Object t) {
        Employee in = (Employee)t;

        if(in.id == this.id) return 0;
        else if (in.id > this.id) return -1;
        return 1;
    }

}