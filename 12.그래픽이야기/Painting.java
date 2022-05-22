import java.awt.*;
import javax.swing.*;

public class Painting extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyDrwaPannel mv = new MyDrwaPannel();

        frame.getContentPane().add(mv);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

class MyDrwaPannel extends JPanel {
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        Color startColor = new Color(red, blue, green);

        red = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        System.out.println(red + " " + blue + " " + green);
        Color endColor = new Color(red, blue, green);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);

    }
}