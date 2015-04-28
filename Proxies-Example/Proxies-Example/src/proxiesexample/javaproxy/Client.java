/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proxiesexample.javaproxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamohan2
 */
public class Client {

    public static void main(String[] args) {

        List list = (List) Proxy.newProxyInstance(MyListInvocationHandler.class.getClassLoader(), new Class[]{List.class}, new MyListInvocationHandler(new ArrayList()));


        System.out.println(list);
        list.add("32");

        System.out.println(list);

        list.add("1");

        System.out.println(list);

        list.clear();

        System.out.println(list);
    }
}
