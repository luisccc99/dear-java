import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        Image image = new ImageIcon("duck.jpg").getImage();
        g.drawImage(image, 5, 5, this);
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
