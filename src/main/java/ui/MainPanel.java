package ui;

import blogic.Zip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel {
    // main panel which contains both the buttons
    private JPanel panelMain;
    // compress button
    private JButton compress;
    // decompress button
    private JButton decompress;
    public MainPanel(){
        // Adding the action listener for the compress button
        compress.addActionListener(new Zip());
        // Adding the action listener for the decompress button
        decompress.addActionListener(new Zip());
    }

    // Getter method to return the main panel
    public JPanel getPanelMain(){
        return this.panelMain;
    }
}
