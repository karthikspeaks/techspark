/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cr.absfact;

/**
 *
 * @author kamohan2
 */
public class Client {

    public static void main(String[] args) {

        IAbstractCarFactory gmFactory = new GMFactory();
        IAbstractCarFactory fordFactory = new FordFactory();

        ISportsCarFactory gmSportsCar = gmFactory.createSportsCar();
        IEconomyCarFactory gmEconCar = gmFactory.createEconomyCar();
        ISportsCarFactory fordSportsCar = fordFactory.createSportsCar();
        IEconomyCarFactory fordEconCar = fordFactory.createEconomyCar();

        gmSportsCar.driveFast();
        gmEconCar.driveSlow();

        fordSportsCar.driveFast();
        fordEconCar.driveSlow();

    }
}
