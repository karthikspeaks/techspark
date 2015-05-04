/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package randomtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kamohan2
 */
public class MyIterations {

    public static void main(String[] args) {

        List l = new ArrayList();

        l.add("a");

        List il1 = new ArrayList();
        il1.add("ia1");
        il1.add("ia2");

        List ill1 = new ArrayList();
        ill1.add("iia1");
        ill1.add("iia2");

        il1.add(ill1);

        l.add(il1);

        l.add("b");


        MyIterator my = new MyIterator(l);
        
        while(my.hasNext()){
            
            System.out.println(my.next());
        }

        
    }
}

class MyIterator implements Iterator<Object> {

    private List<Object> list;
    private int currentPosition;

    public MyIterator(List<Object> list) {
        this.list = list;
    }



    public boolean hasNext() {
        return currentPosition < list.size();
    }

    public Object next() {
        Object o = list.get(currentPosition);
        if(o instanceof List)
        {
            return nextInner((List)o);
        }
        currentPosition = currentPosition + 1 ;
        return o;
    }

    public Object nextInner(List l){

        
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
