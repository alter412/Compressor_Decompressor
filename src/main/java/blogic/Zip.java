package blogic;
// importing required classes
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// creating actionListener for compressor and decompressor buttons
public class Zip implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        // fetching the command to which button was pressed
        String command = e.getActionCommand();

        // compressed button pressed
        if (command.equals("compress")) {
            // open file chooser
            JFileChooser jfc = new JFileChooser();
            int val = jfc.showOpenDialog(null);
            // if some was selected only then perform the action
            if (val == jfc.APPROVE_OPTION) {
                // fetch the selected file
                String file = jfc.getSelectedFile().toString();
               // fetch the parent directory, to be used later while saving compressed file
                String parent = jfc.getCurrentDirectory().toString();
                // using required file streams
                FileInputStream fis = null;
                FileOutputStream fos = null;
                // used for compression
                GZIPOutputStream gzip = null;

                try {
                 fis = new FileInputStream(file);
                 // save the compressed file at the given path
                 fos = new FileOutputStream(parent + "/" + "compressedFile");
                 gzip = new GZIPOutputStream(fos);

                    byte[] arr = new byte[1024];
                    int l;
                    // write using not reached the end of file
                    while ((l = fis.read(arr)) != -1) {
                        gzip.write(arr, 0, l);
                    }
                    // close all streams
                    fis.close();
                    gzip.close();
                    // conformation message dialog
                    JOptionPane.showMessageDialog(null,"File compressed successfully!","Information",JOptionPane.INFORMATION_MESSAGE,null);

                } catch (FileNotFoundException ex) {
                    // if file not found then this error dialog will be displayed
                    JOptionPane.showMessageDialog(null,"File not found!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    // if io error occurred
                    JOptionPane.showMessageDialog(null,"IO Error occur try again!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                }
            }

        } else if (command.equals("decompress")) {
            // open the file chooser
            JFileChooser jfc = new JFileChooser();
            int val = jfc.showOpenDialog(null);
            // perform action only when file is selected
            if (val == jfc.APPROVE_OPTION) {
                // fetch the file name
                String file = jfc.getSelectedFile().toString();
                // fetch the current directory
                String parent = jfc.getCurrentDirectory().toString();
                // using required file streams
                FileInputStream fis = null;
                FileOutputStream fos = null;
                // used while decompressing
                GZIPInputStream gzip = null;

                try {
                    fis = new FileInputStream(file);
                    // save the file at the given location
                    fos = new FileOutputStream(parent + "/" + "decompressedFile");
                    gzip = new GZIPInputStream(fis);

                    byte[] arr = new byte[1024];
                    int l;
                    // write while not reached end of file
                    while ((l = gzip.read(arr)) != -1) {
                        fos.write(arr, 0, l);
                    }
                    // close all streams
                    fos.close();
                    gzip.close();
                    // conformation dialog message
                    JOptionPane.showMessageDialog(null,"File decompressed successfully!","Information",JOptionPane.INFORMATION_MESSAGE,null);

                } catch (FileNotFoundException ex) {
                    // error dialog when file not found
                    JOptionPane.showMessageDialog(null,"File not found!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    // error dialog when io error occurred
                    JOptionPane.showMessageDialog(null,"IO Error occur try again!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}