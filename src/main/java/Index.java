import ui.MainPanel;

import javax.swing.*;

public class Index {
    public static void main(String[] args) {
        // Main Frame of the application
        JFrame frame = new JFrame("Compressor and Decompressor");
        // Setting default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting Bounds of the frame
        frame.setBounds(100,100,800,800);
        // Adding the Main Panel which contains the buttons
        frame.add(new MainPanel().getPanelMain());
        // Making the frame visible
        frame.setVisible(true);
    }
}
