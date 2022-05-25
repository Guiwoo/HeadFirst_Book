import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleGui3c {
    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        SimpleGui3c gui = new SimpleGui3c();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelBtn = new JButton("Change Label");
        labelBtn.addActionListener(new LableListener());

        JButton colorBtn = new JButton("Change color");
        colorBtn.addActionListener(new ColorListner());

        label = new JLabel("I am a label");

        MyDrwaPane mv = new MyDrwaPane();

        frame.getContentPane().add(BorderLayout.SOUTH, colorBtn);
        frame.getContentPane().add(BorderLayout.CENTER, mv);
        frame.getContentPane().add(BorderLayout.EAST, labelBtn);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class LableListener implements ActionListener {
        public void actionPerformed(ActionEvent envet) {
            label.setText("Ouch !");
        }
    }

    class ColorListner implements ActionListener {
        public void actionPerformed(ActionEvent envet) {
            frame.repaint();
        }
    }
}

class MyDrwaPane extends JPanel {
    public void paintComponent(Graphics g) {
        // Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        Color mColor = new Color(red, blue, green);

        g.setColor(mColor);
        g.fillOval(50, 50, 100, 100);
    }
}