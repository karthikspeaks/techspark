/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.visitor;

/**
 *
 * @author kamohan2
 */
public class Plumber implements IVisitor {

    public String getName() {
        return "Plumber";
    }

    public void visit(IPremise premise) {

        System.out.println(premise.getName() + " visited by " +getName());
    }

}
