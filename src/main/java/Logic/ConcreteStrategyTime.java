package Logic;

import Model.Client;
import Model.Server;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addClient(List<Server> servers, Client c) {
        int min = 9999;
        for(Server serv : servers){
            if(serv.getWaitingPeriod().intValue() < min){
                min = serv.getWaitingPeriod().intValue();
            }
        }
        for(Server serv : servers){
            if(serv.getWaitingPeriod().intValue() == min){
                serv.addClient(c);
                break;
            }
        }
    }
}
