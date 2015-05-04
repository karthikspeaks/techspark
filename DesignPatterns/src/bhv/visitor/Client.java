/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamohan2
 */
public class Client {

    public static void main(String[] args) {

        List<IVisitor> visitors = new ArrayList<IVisitor>();
        visitors.add(new Plumber());
        visitors.add(new Electrician());

        List<IPremise> premises = new ArrayList<IPremise>();
        premises.add(new Home());
        premises.add(new Office());

        for(IPremise premise : premises){

            for(IVisitor visitor : visitors){
                premise.accept(visitor);
            }
            
        }

    }

}
