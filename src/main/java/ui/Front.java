package ui;

import javax.swing.*;
import java.awt.*;
import blogic.Zip;

class Front{
    // main frame window
    JFrame win;
    // compress and decompress button
    JButton compress,decompress;
    Front(){
        // set the title
        win = new JFrame("Compressor Decompressor");
        // set the default close operation behavior
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // make the frame visible
        win.setVisible(true);
        // set background as black
        win.getContentPane().setBackground(Color.black);
        // set layout to null for full control
        win.setLayout(null);
        // set the bounds of frame
        win.setBounds(100,100,800,800);

        // set the button text
        compress = new JButton("compress");
        compress.setFocusable(false);
        // set the size and bounds
        compress.setSize(50,50);
        compress.setBounds(400,150,150,100);
        // add action listener
        compress.addActionListener(new Zip());

        // set the button text
        decompress = new JButton("decompress");
        decompress.setFocusable(false);
        // set the size and bounds
        decompress.setSize(150,150);
        decompress.setBounds(700,150,150,100);
        // set the action listener
        decompress.addActionListener(new Zip());

        // add both buttons to the main frame window
        win.add(compress);
        win.add(decompress);


    }

    // main method where the Front class object is created
    public static void main(String[] args) {
        Front f = new Front();
    }
}