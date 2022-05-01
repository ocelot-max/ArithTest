package org.wiselot.ArithTest.Test;

import org.wiselot.ArithTest.Driver.Driver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverInfo extends JFrame implements Driver.MessageInterFace, Driver.InputInterface {
    private final JTextArea InfoOut = new JTextArea(25,32);
    private final JPanel panel1 = new JPanel();
    private final JButton button1 = new JButton();
    private final JButton button2 = new JButton();
    private final JTextField textField = new JTextField(1);

    private ArrayList<String> inputs = new ArrayList<>();
    private boolean ready = false;

    public DriverInfo(Driver driver) {
        this.setBounds(300,200,800,600);
        button1.setBounds(750,550,50,50);
        button1.setText("清空");
        button2.setBounds(700,500,50,50);
        button2.setText("提交");
        InfoOut.setEditable(false);
        panel1.add(InfoOut);
        panel1.add(button1);
        this.add(panel1);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoOut.setText("");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputs.add(textField.getText());
                textField.setText("");
                ready = true;
            }
        });
    }

    @Override
    public void messageFlush(String message) {
        InfoOut.append(message+"\n");
    }

    @Override
    public ArrayList<String> getInput() {
        if(ready){
            return inputs;
        }
        else{
            return null;
        }
    }
}
