import javax.swing.*;

/**
 * Title: Assingment 3
 * Description:  CSE 564 : Singleton, Decorator, Observer Pattern
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class PanelStatusBar extends JPanel {
    
    PanelStatusBar() {
        JButton button = new JButton("Status bar");
        add(button);
    }
}
