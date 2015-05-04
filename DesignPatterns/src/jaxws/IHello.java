/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author kamohan2
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface IHello {

    @WebMethod
    String hello(String name);

}
