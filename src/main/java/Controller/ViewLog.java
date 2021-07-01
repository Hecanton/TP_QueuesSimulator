package Controller;

import javax.swing.*;
import java.awt.*;

public class ViewLog extends JFrame {

    private JTextArea logtext = new JTextArea(30,40);
    JScrollPane scrollPane;

    public ViewLog() {


        JPanel content = new JPanel();

        scrollPane= new JScrollPane(logtext);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        content.add(scrollPane);

        this.setLocation(300,200);
        this.setContentPane(content);
        this.setSize(2000,5000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setVisible(true);
        this.setTitle("ViewLog");
    }

    public void setLogtext(String logtext) {
        this.logtext.setText(logtext);
    }
}
