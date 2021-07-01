package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Client> clients;
    private AtomicInteger waitingPeriod;


    public Server() {
        clients = new PriorityBlockingQueue<>();
        waitingPeriod = new AtomicInteger(0);

    }

    public void addClient (Client newClient){
        clients.add(newClient);
        waitingPeriod.addAndGet(newClient.getProcessingTime());
    }

    public void run(){
        while(true){
            if(!clients.isEmpty()){
                AtomicInteger processTime = new AtomicInteger(0);
                processTime.addAndGet(clients.peek().getProcessingTime());
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                processTime.addAndGet(-1);

                if(processTime.intValue() == 0){
                    clients.poll();
                }
                else {
                    clients.peek().setProcessingTime((processTime.intValue()));

                }
            }
        }
    }

        public BlockingQueue<Client> getClients(){
        return clients;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }
}
