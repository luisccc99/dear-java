import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C implements ActionListener {
    JButton colorButton = new JButton("click me");
    JButton labelButton = new JButton("I change labels");
    JFrame frame = new JFrame();
    JLabel label = new JLabel("I'm a label");

    public void go() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GradientCircle circle = new GradientCircle();

        frame.getContentPane().add(BorderLayout.CENTER, circle);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);

        labelButton.addActionListener(new LabelListener());
        colorButton.addActionListener(new ColorListener());

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == colorButton) {
            frame.repaint();
        } else {
            label.setText("Omg");
        }
    }

    class LabelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            label.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            frame.repaint();
        }
    }

    public static void main(String[] args) {
        SimpleGui3C simple = new SimpleGui3C();
        simple.go();
    }


}
