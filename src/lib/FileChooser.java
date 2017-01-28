package lib;
/**
 *This is a basic GUI page for selecting the saved .class file or .exe
 *file of the user program
 * 
 * @author Parth Doshi
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class FileChooser extends JFrame {

   public FileChooser() {
    super("Select your file from here");
    setSize(500,500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    
    JButton openButton = new JButton("Open");
    final JLabel statusbar = new JLabel("Output of your selection will go here");

    // Create a file chooser that opens up as an Open dialog
    openButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        JFileChooser chooser = new JFileChooser();
        //chooser.setMultiSelectionEnabled(true);
        int option = chooser.showOpenDialog(FileChooser.this);
        if (option == JFileChooser.APPROVE_OPTION) {
          File[] sf = chooser.getSelectedFiles();
          String filelist = "nothing";
          if (sf.length > 0) filelist = sf[0].getName();
          for (int i = 1; i < sf.length; i++) {
            filelist += ", " + sf[i].getName();
          }
          statusbar.setText("You chose " + filelist);
        }
        else {
          statusbar.setText("You canceled.");
        }
      }
    });

    c.add(openButton);
    c.add(statusbar);
  }

  public static void main(String args[]) {
    FileChooser fc = new FileChooser();
    fc.setVisible(true);
  }
}