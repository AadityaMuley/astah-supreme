import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Title: Assingment 3
 * Description:  CSE 564 : Singleton, Decorator, Observer Pattern
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class Main extends JFrame {
    
    PanelMenubar panelMenubar;
    PanelSourceCode panelSourceCode;
    PanelDrawUml panelDrawUml;
    PanelStatusBar panelStatusBar;
    
    Main() {
        
        setTitle("Astah Replica - CSE 564 Final Project");
        setLayout(new GridLayout(3, 1));
        setSize(500,500);
        
        panelMenubar = new PanelMenubar();
        add(panelMenubar);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panelSourceCode = new PanelSourceCode();
        panelDrawUml = new PanelDrawUml();
        panel.add(panelSourceCode);
        panel.add(panelDrawUml);
        add(panel);
        
        panelStatusBar = new PanelStatusBar();
        add(panelStatusBar);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
