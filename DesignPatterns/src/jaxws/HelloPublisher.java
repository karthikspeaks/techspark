/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jaxws;

import javax.xml.ws.Endpoint;

/**
 *
 * @author kamohan2
 */
public class HelloPublisher {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:5555/ws/hello", new HelloImpl());
        
    }

}
