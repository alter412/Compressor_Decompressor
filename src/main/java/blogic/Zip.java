package blogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Zip implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if (command.equals("compress")) {
            JFileChooser jfc = new JFileChooser();
            int val = jfc.showOpenDialog(null);
            if (val == jfc.APPROVE_OPTION) {
                String file = jfc.getSelectedFile().toString();
                String parent = jfc.getCurrentDirectory().toString();
                FileInputStream fis = null;
                FileOutputStream fos = null;
                GZIPOutputStream gzip = null;

                try {
                 fis = new FileInputStream(file);
                 fos = new FileOutputStream(parent + "/" + "compressedFile");
                 gzip = new GZIPOutputStream(fos);

                    byte[] arr = new byte[1024];
                    int l;
                    while ((l = fis.read(arr)) != -1) {
                        gzip.write(arr, 0, l);
                    }
                    fis.close();
                  //  fos.close();
                    gzip.close();
                    JOptionPane.showMessageDialog(null,"File compressed successfully!","Information",JOptionPane.INFORMATION_MESSAGE,null);

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"File not found!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"IO Error occur try again!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                }
            }

        } else if (command.equals("decompress")) {
            JFileChooser jfc = new JFileChooser();
            int val = jfc.showOpenDialog(null);
            if (val == jfc.APPROVE_OPTION) {
                String file = jfc.getSelectedFile().toString();
                String parent = jfc.getCurrentDirectory().toString();
                FileInputStream fis = null;
                FileOutputStream fos = null;
                GZIPInputStream gzip = null;

                try {
                    fis = new FileInputStream(file);
                    fos = new FileOutputStream(parent + "/" + "decompressedFile");
                    gzip = new GZIPInputStream(fis);

                    byte[] arr = new byte[1024];
                    int l;
                    while ((l = gzip.read(arr)) != -1) {
                        fos.write(arr, 0, l);
                    }
                    //fis.close();
                    fos.close();
                    gzip.close();
                    JOptionPane.showMessageDialog(null,"File decompressed successfully!","Information",JOptionPane.INFORMATION_MESSAGE,null);

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"File not found!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"IO Error occur try again!","Error",JOptionPane.ERROR_MESSAGE,null);
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}