package Logic;

import Model.Client;
import Model.Server;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addClient(List<Server> servers, Client c) {
        int min = 9999;
        for(Server serv : servers){
            if(serv.getClients().size() < min){
                min = serv.getClients().size();
            }
        }
        for(Server serv : servers){
            if(serv.getClients().size() == min){
                serv.addClient(c);
                break;
            }
        }
    }
}
