import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {
    JButton btn;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        btn = new JButton("Click me");

        btn.addActionListener(
                this);

        frame.getContentPane().add(btn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        btn.setText("I've been clicked.!");
    }
}
