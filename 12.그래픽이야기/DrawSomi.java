import java.awt.*;
import javax.swing.*;

public class DrawSomi {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        My mv = new My();

        frame.getContentPane().add(mv);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 500);
        frame.setVisible(true);

    }
}

class My extends JPanel {
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("somiFace.jpg").getImage();
        g.drawImage(image, 3, 4, this);
    }
}