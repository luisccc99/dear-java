import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, Color.blue, 50, 50, Color.pink);
        g2d.setPaint(gradient);
        g2d.fillRoundRect(0,0, 100, 100, 15, 15);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MyDrawPanel drawing = new MyDrawPanel();
        frame.getContentPane().add(drawing);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
