/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.visitor;

/**
 *
 * @author kamohan2
 */
public class Home implements IPremise {

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return "Home";
    }

}
