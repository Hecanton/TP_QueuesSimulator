package Logic;

import Model.Client;
import Model.Server;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNrServers;
    private int maxNrClients;
    private Strategy strategy;
    private SelectionPolicy policy;

    public Scheduler(int maxNrServers, int maxNrClients, SelectionPolicy policy) {
        this.maxNrServers = maxNrServers;
        this.maxNrClients = maxNrClients;
        this.policy = policy;
        changeStrategy(policy);
        this.servers = new ArrayList<>();
        for(int i=0; i<maxNrServers; i++){
            Server server = new Server();
            Thread thread = new Thread(server);
            servers.add(server);
            thread.start();
        }
    }
    public void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE)
            strategy = new ConcreteStrategyQueue();
        if(policy == SelectionPolicy.SHORTEST_TIME)
            strategy = new  ConcreteStrategyTime();
    }

    public void dispatchClient(Client c){
        strategy.addClient(servers,c);
    }

    public List<Server> getServers() {
        return servers;
    }
}
