/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bhv.state;

/**
 *
 * @author kamohan2
 */
public class Client {

    public static void main(String args[]){

        Context c = new Context();

        StoppedState s = new StoppedState();
        s.function(c);

        RunningState r = new RunningState();
        r.function(c);

        
    }

}
