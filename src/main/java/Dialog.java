import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog extends JDialog {

    private String content;

    public Dialog() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200, 100));

        JTextArea textArea = new JTextArea();

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane pane = new JScrollPane(textArea);
        pane.setPreferredSize(new Dimension(200, 100));
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton button = new JButton("OK");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content = textArea.getText();

                //////
                System.out.println("button Pressed content: " + content);

                if (e.getActionCommand().equals("OK")) {
                    setVisible(false);
                }
            }
        });

        this.add(pane, BorderLayout.CENTER);
        this.add(button, BorderLayout.SOUTH);
    }


    public String getName() {
        //////
        System.out.println("getName content: " + content);

        if (content != null) {
            return content;
        }
        else {
            return "Default";
        }
    }

}
