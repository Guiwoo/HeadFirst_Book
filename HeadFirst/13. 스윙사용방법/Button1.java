import javax.swing.*;
import java.awt.*;

public class Button1 {
    JFrame frame = new JFrame();
    JButton button = new JButton("There is no spoon");

    public static void main(String[] args) {
        Button1 guio = new Button1();
        guio.everyWhere();
    }

    public void go() {
        frame.getContentPane().add(BorderLayout.EAST, button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void goNorth() {
        Font bgFont = new Font("serif", Font.BOLD, 28);
        button.setFont(bgFont);
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void everyWhere() {
        JButton btn1 = new JButton("North");
        JButton btn2 = new JButton("East");
        JButton btn3 = new JButton("South");
        JButton btn4 = new JButton("West");
        JButton center = new JButton("Center");
        frame.getContentPane().add(BorderLayout.NORTH, btn1);
        frame.getContentPane().add(BorderLayout.EAST, btn2);
        frame.getContentPane().add(BorderLayout.SOUTH, btn3);
        frame.getContentPane().add(BorderLayout.WEST, btn4);
        frame.getContentPane().add(BorderLayout.CENTER, center);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
