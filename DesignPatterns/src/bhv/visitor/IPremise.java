/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.visitor;

/**
 *
 * @author kamohan2
 */
public interface IPremise {

    String getName();
    void accept(IVisitor visitor);

}
