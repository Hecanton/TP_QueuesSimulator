package Logic;

import Controller.ViewLog;
import Model.Client;
import Model.Server;
import Controller.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SimulationManager implements Runnable{
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int maxArrivalTime;
    public int minArrivalTime;
    public int nrServers;
    public int nrClients;

    private StringBuilder fisier;
    public SelectionPolicy selectionPolicy;
    private Scheduler scheduler;
    private List<Client> generatedClients;
    private ViewLog view;

    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int maxArrivalTime, int minArrivalTime, int nrServers, int nrClients, SelectionPolicy selectionPolicy) {
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.maxArrivalTime = maxArrivalTime;
        this.minArrivalTime = minArrivalTime;
        this.nrServers = nrServers;
        this.nrClients = nrClients;
        this.selectionPolicy = selectionPolicy;
        this.fisier = new StringBuilder();

        scheduler = new Scheduler(nrServers,nrClients,selectionPolicy);
        generateNRandomClients();
    }

    private void generateNRandomClients(){
        Random random = new Random();
        generatedClients = new ArrayList<>();
        for(int i=1; i<=nrClients; i++){
            Client c = new Client(i,minArrivalTime + random.nextInt(maxArrivalTime - minArrivalTime + 1), minProcessingTime + random.nextInt(maxProcessingTime - minProcessingTime +1));
            generatedClients.add(c);
        }
        Collections.sort(generatedClients);
    }

    public void run(){
        view=new ViewLog();
        int time=0;

        while(time <= timeLimit) {
            while (!generatedClients.isEmpty() && time == generatedClients.get(0).getArrivalTime()) {
                Client c = generatedClients.get(0);
                scheduler.dispatchClient(c);
                generatedClients.remove(c);
            }
            System.out.println();
            System.out.println("Timp: " + time);
            System.out.println("Waiting clients: ");
            fisier.append("\nTimp: "+time + "\n");
            fisier.append("Waiting clients: ");
            for (Client c : generatedClients) {
                System.out.println(c.toString() + "");
                fisier.append(c.toString()+" ");
            }
            for (int i = 0; i < scheduler.getServers().size(); i++) { // pentru fiecare lista de clienti (coada de magazin)
                Server server = scheduler.getServers().get(i);
                int nrClienti=server.getClients().size();//Numarul de clienti din lista
                if(nrClienti >0){
                    System.out.println("Queue " + (i+1) + ": ");
                    fisier.append("\nQueue " + (i+1) +":");
                    for(Client c : scheduler.getServers().get(i).getClients()){
                        System.out.println(c + " ");
                        fisier.append(c+" ");
                    }
                }
                else if(nrClienti == 0){
                    System.out.println("Queue " + (i+1) + ": closed");
                    fisier.append("\nQueue " + (i+1) + ":closed ");
                }
            }


            view.setLogtext(fisier.toString());
            time++;
            if(time>timeLimit){
                break;
            }
            int ok=0;
            if(generatedClients.isEmpty()){
                for(Server server : scheduler.getServers())
                {
                    if(server.getClients().isEmpty())
                        ok++;
                }
                if(ok==scheduler.getServers().size())
                    break;
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        generateFisier(fisier.toString());
    }

        public static void generateFisier(String s){
        try{
            FileWriter fileWriter = new FileWriter("Fisier.txt");
            fileWriter.write(s);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
