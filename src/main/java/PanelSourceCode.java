import javax.swing.*;
import java.awt.*;

/**
 * Title: Assignment 4
 * Description:  CSE 564 : Final project
 *
 * @author Aaditya Muley
 * ASUrite : amuley2
 * ASU ID : 1225526185
 * @version 1.0
 */
public class PanelSourceCode extends JPanel {
    
    PanelSourceCode() {
        JPanel codePanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(codePanel);

        this.setLayout(new GridLayout());
        this.add(scrollPane);
    }
}
