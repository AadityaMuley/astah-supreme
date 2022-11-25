import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Title: Assingment 4
 * Description:  CSE 564 : Final project
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
        setSize(1000,700);

        this.setLayout(new BorderLayout());

        //MENU
        panelMenubar = new PanelMenubar();
        panelMenubar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(panelMenubar, BorderLayout.NORTH);

        //SOURCE CODE & UML
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panelSourceCode = new PanelSourceCode();
        panelDrawUml = new PanelDrawUml();
        panel.add(panelSourceCode);
        panel.add(panelDrawUml);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(panel, BorderLayout.CENTER);

        //STATUS
        panelStatusBar = new PanelStatusBar();
        panelStatusBar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(panelStatusBar, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
