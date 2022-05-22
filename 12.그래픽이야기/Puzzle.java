import javax.swing.*;
import java.awt.*;

public class Puzzle {
    int x = 1;
    int y = 1;

    public static void main(String[] args) {
        Puzzle p = new Puzzle();
        p.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawP drawP = new MyDrawP();
        frame.getContentPane().add(drawP);
        frame.setSize(500, 270);
        frame.setVisible(true);

        for (int i = 0; i < 124; i++, y++, x++) {
            x++;
            drawP.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
        }
    }

    class MyDrawP extends JPanel {
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;

            g.setColor(Color.blue);
            g.fillRect(x, y, 500 - x * 2, 250 - y * 2);
        }
    }
}
