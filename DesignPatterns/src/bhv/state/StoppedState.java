/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.state;

/**
 *
 * @author kamohan2
 */
public class StoppedState implements EngineState{

    public void function(Context context) {
       System.out.println("Stopped State now...");

        context.setEngineState(this);
    }

}
