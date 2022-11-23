import javax.swing.*;
import java.awt.*;

/**
 * Title: Assingment 3
 * Description:  CSE 564 : Singleton, Decorator, Observer Pattern
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
