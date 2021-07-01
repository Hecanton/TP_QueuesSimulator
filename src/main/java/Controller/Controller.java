package Controller;

import Logic.SelectionPolicy;
import Logic.SimulationManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class Controller {
    private View view;
    public Controller(View view){
        this.view=view;

        view.addShortestQueueListener(new ShortestTimeListener());
        view.addShortestTimeListener(new ShortestQueueListener());
    }

    class  ShortestTimeListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int nrClients = parseInt(view.getNrClients());
            int nrServers = parseInt(view.getNrServers());
            int simulationTime = parseInt(view.getSimulationTime());
            int maxArrivalTime = parseInt(view.getMaxArrivalTime());
            int minArrivalTime= parseInt(view.getMinArrivalTime());
            int maxProcessingTime= parseInt(view.getMaxProcessingTime());
            int minProcessingTime= parseInt(view.getMinProcessingTime());

            SimulationManager gen = new SimulationManager(simulationTime,maxProcessingTime,minProcessingTime,maxArrivalTime,minArrivalTime,nrServers,nrClients, SelectionPolicy.SHORTEST_TIME);
            Thread t = new Thread(gen);
            t.start();

        }
    }
    class  ShortestQueueListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            int nrClients = parseInt(view.getNrClients());
            int nrServers = parseInt(view.getNrServers());
            int simulationTime = parseInt(view.getSimulationTime());
            int maxArrivalTime = parseInt(view.getMaxArrivalTime());
            int minArrivalTime= parseInt(view.getMinArrivalTime());
            int maxProcessingTime= parseInt(view.getMaxProcessingTime());
            int minProcessingTime= parseInt(view.getMinProcessingTime());

            SimulationManager gen = new SimulationManager(simulationTime,maxProcessingTime,minProcessingTime,maxArrivalTime,minArrivalTime,nrServers,nrClients, SelectionPolicy.SHORTEST_QUEUE);
            Thread t = new Thread(gen);
            t.start();

        }
    }
}
