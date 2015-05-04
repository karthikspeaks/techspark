/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.visitor;

/**
 *
 * @author kamohan2
 */
public class Electrician implements IVisitor {

    public String getName() {
        return "Electrician";
    }

    public void visit(IPremise premise) {

         System.out.println(premise.getName() + " visited by " +getName());
    }

}
