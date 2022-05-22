import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Practice {
    JFrame frame;
    JButton b;

    public static void main(String[] args) {
        Practice gui = new Practice();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b = new JButton("A");
        b.addActionListener(new BListenger());

        frame.getContentPane().add(BorderLayout.SOUTH, b);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    class BListenger implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (b.getText().equals("A")) {
                b.setText("B");
            } else {
                b.setText("A");
            }
        }
    }
}
