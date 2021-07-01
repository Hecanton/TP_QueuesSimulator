package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class View extends JFrame {
    private JTextField nrClients     = new JTextField(2);
    private JTextField nrServers     = new JTextField(2);
    private JTextField maxArrivalTime     = new JTextField(2);
    private JTextField minArrivalTime     = new JTextField(2);
    private JTextField maxProcessingTime     = new JTextField(2);
    private JTextField minProcessingTime     = new JTextField(2);
    private JTextField simulationTime     = new JTextField(2);
    private JTextField logs = new JTextField();

    private JButton    shortestTime = new JButton("Shortest Time");
    private JButton    shortestQueue = new JButton("Shortest Queue");



    public View(){
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(100,70));
        add (content);

        JPanel content2=new JPanel();
        JPanel content3=new JPanel();
        JPanel content4=new JPanel();
        JPanel content5=new JPanel();

        JPanel content6=new JPanel();
        JPanel content7=new JPanel();
        JPanel content8=new JPanel();
        JPanel content9=new JPanel();

        content3.setLayout(new BorderLayout(10,10));
        content2.setLayout(new FlowLayout());
        content4.setLayout(new FlowLayout());
        content5.setLayout(new FlowLayout());

        content6.setLayout(new BorderLayout(10,10));
        content7.setLayout(new FlowLayout());
        content8.setLayout(new FlowLayout());
        content9.setLayout(new FlowLayout());

        content2.add(new JLabel("Clients Number"));
        content2.add(nrClients);
        content2.add(new JLabel(" Servers Number"));
        content2.add(nrServers);
        content2.add(new JLabel(" Simulation time"));
        content2.add(simulationTime);
        content2.add(new JLabel(" Min arrival time"));
        content2.add(minArrivalTime);
        content2.add(new JLabel(" Max arrival time"));
        content2.add(maxArrivalTime);
        content2.add(new JLabel(" Min processing time"));
        content2.add(minProcessingTime);
        content2.add(new JLabel(" Max processing time"));
        content2.add(maxProcessingTime);

        content5.add(shortestTime);
        content5.add(shortestQueue);



        content3.add(content4,"North");
        content3.add(content2,"Center");
        content3.add(content5,"South");

        content6.add(content7,"North");
        content6.add(content8,"Center");
        content6.add(content9,"South");


        content.add(content3,"North");
        content.add(content6,"Center");


        this.setLocation(300,200);
        this.setContentPane(content);
        this.setSize(2000,10000);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.setTitle("View");
    }

    public String getNrClients() { return nrClients.getText();}
    public String getNrServers() { return nrServers.getText();}
    public String getSimulationTime() { return simulationTime.getText(); }
    public String getMaxArrivalTime() { return maxArrivalTime.getText();}
    public String getMinArrivalTime() { return minArrivalTime.getText();}
    public String getMaxProcessingTime(){ return maxProcessingTime.getText(); }
    public String getMinProcessingTime(){ return minProcessingTime.getText(); }


    public void addShortestQueueListener(ActionListener actionListener){
        shortestQueue.addActionListener(actionListener);
    }

    public void addShortestTimeListener(ActionListener actionListener) {
        shortestTime.addActionListener(actionListener);
    }

    }

