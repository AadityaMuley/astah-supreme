import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class PanelStatusBar extends JPanel implements Observer {
    
    private static JLabel label;
    private static String[] status = new String[2];
    private String l;
    Status s;

    PanelStatusBar() {
        label = new JLabel("Application started - Welcome!!!");
        add(label);
    }


    @Override
    public void update(Observable o, Object arg) {
        status = ((BoxAttributes)o).getStatus();

        if(status[0].equalsIgnoreCase("1")) {
            l = "New class named - " + status[1] + " - created";
            s = new Status(l);
        }
        else {
            if(status[1].equalsIgnoreCase("1")) {
                l = "New Association relation created";
                s = new Status(l);
            }
            else if(status[1].equalsIgnoreCase("2")) {
                l = "New Aggregation relation created";
                s = new Status(l);
            }
            else {
                l = "New Inheritance relation created";
                s = new Status(l);
            }
        }
    }

}