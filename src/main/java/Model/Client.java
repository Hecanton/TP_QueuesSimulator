package Model;

public class Client implements Comparable<Client> {
    private int clientId;
    private int arrivalTime;
    private int processingTime;

    public Client(int clientId, int arrivalTime, int processingTime) {
        this.clientId = clientId;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public String toString(){
        return"("+ clientId + " " + arrivalTime + " " + processingTime + ");";
    }

    public int compareTo(Client c){
        return this.getArrivalTime()-c.getArrivalTime();
    }
}
