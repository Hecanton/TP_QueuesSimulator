package org.example;

import Controller.Controller;
import Controller.View;
import Logic.SelectionPolicy;
import Logic.SimulationManager;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //SimulationManager gen = new SimulationManager(20,4,2,3,1,2,10, SelectionPolicy.SHORTEST_QUEUE);
        ////Thread t = new Thread(gen);
        //t.start();
        View view = new View();
        Controller controller = new Controller(view);
        view.setVisible(true);
    }
}
