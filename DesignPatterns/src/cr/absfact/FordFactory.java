/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.absfact;

/**
 *
 * @author kamohan2
 */
public class FordFactory implements IAbstractCarFactory{

    public ISportsCarFactory createSportsCar() {
        return new Mustang();
    }

    public IEconomyCarFactory createEconomyCar() {
        return new Ikon();
    }

}
