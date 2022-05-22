import java.awt.*;
import javax.swing.*;

public class Animation {
    int x = 0;
    int y = 0;

    public static void main(String[] args) {
        Animation gui = new Animation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrwaPanel mv = new MyDrwaPanel();

        frame.getContentPane().add(BorderLayout.CENTER, mv);

        frame.setSize(400, 400);
        frame.setVisible(true);
        for (int i = 0; i < 150; i++) {
            x++;
            y++;
            mv.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
        }
    }

    class MyDrwaPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillOval(x, y, this.getWidth(), this.getHeight());

            g.setColor(Color.YELLOW);
            g.fillOval(x, y, 50, 50);
        }
    }
}
