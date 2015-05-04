/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.absfact;

/**
 *
 * @author kamohan2
 */
public class GMFactory implements IAbstractCarFactory {

    public ISportsCarFactory createSportsCar() {
        return new Corvette();
    }

    public IEconomyCarFactory createEconomyCar() {
        return new Cavalier();
    }

}
