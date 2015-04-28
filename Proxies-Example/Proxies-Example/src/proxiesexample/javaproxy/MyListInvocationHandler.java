/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proxiesexample.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 *
 * @author kamohan2
 */
public class MyListInvocationHandler implements InvocationHandler {

    private List list;

    MyListInvocationHandler(List list) {
        this.list = list;
    }

    public Object invoke(Object o, Method method, Object[] os) throws Throwable {

        if (method.getName().startsWith("clear")) {
            return false;
        }

        return method.invoke(list, os);
    }
}
