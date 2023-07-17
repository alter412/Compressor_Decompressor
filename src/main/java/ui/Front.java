package ui;

import javax.swing.*;
import java.awt.*;


class Front{
    JFrame win;
    JButton compress,decompress;
    Front(){
        win = new JFrame("Compressor Decompressor");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
        win.setBackground(Color.black);
        win.setLayout(null);
        win.setBounds(100,100,800,800);

        compress = new JButton("compress");
        compress.setFocusable(false);
        compress.setSize(50,50);
        compress.setBounds(400,150,150,100);


        decompress = new JButton("decompress");
        decompress.setFocusable(false);
        decompress.setSize(150,150);
        decompress.setBounds(700,150,150,100);

        win.add(compress);
        win.add(decompress);


    }

    public static void main(String[] args) {
        Front f = new Front();
    }
}