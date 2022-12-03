import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Title: Assignment 4
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







        //Trail
        Data d = Data.getInstance();
        Data d2 = Data.getInstance();
        CodeGeneration cg = new CodeGeneration();
        cg.addObserver(panelSourceCode);
        d.addObserver(cg);
        // String classnametest, classinherit;
        // ArrayList<String> ass = new ArrayList<String>();
        // ArrayList<String> agg = new ArrayList<String>();
        // ArrayList<String> ass2 = new ArrayList<String>();
        // ArrayList<String> agg2 = new ArrayList<String>();

        // classnametest  = "Jash";
        // classinherit = "Person";
        // ass.add("Student");
        // agg.add("Homework");
        // d.addClass(classnametest , classinherit, agg, ass);

        // classnametest  = "Javier";
        // classinherit = "Person";
        // ass2.add("Teacher");
        // agg2.add("Test");
        // d2.addClass(classnametest , classinherit, agg2, ass2);
        // //d2.addClass(classnametest , null, agg, null);
        // //classinherit = "Person";
        // agg2.add("Test2");
        //d2.updateClass(classnametest , null, agg2, null);
        //ass2.add("Teacher");
        
        //panelSourceCode.printCode();
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
