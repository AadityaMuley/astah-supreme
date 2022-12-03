import javax.swing.*;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class Status {
    
    public Status(String l) {
    
        JDialog d = new JDialog();
        
        JLabel label = new JLabel(l);
        
        d.add(label);
        d.setSize(200, 100);
        d.setLocationRelativeTo(null);
        d.setVisible(true);
    }
}
