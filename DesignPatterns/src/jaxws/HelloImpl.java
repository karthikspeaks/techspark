/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jaxws;

import javax.jws.WebService;

/**
 *
 * @author kamohan2
 */
@WebService (endpointInterface= "jaxws.IHello")
public class HelloImpl implements IHello{

    public String hello(String name) {
        return "Hello "+name;
    }

}
