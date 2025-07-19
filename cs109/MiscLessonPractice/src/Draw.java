package MiscLessonPractice.src;
import java.awt.*;
import javax.swing.*;

public class Draw extends JPanel {
    public static void main(String[] args) {
        // let's setup the frame so we can keep adding to our program
        JFrame f = new JFrame("woot woot");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new Draw());
        f.setSize(290, 325);
        f.setLocation(550, 25);
        f.setVisible(true);
    }

    public void paint(Graphics g) {
        // custom color
        // String hexColor = new String("0x45e5B");
        g.setColor(Color.cyan);
        // draw a line (starting x,y; ending x,y)
        g.drawLine(70, 10, 40, 80);
        Graphics2D g2 = (Graphics2D) g;
        g2.fillOval(21, 21, 23, 6);
        Polygon p = new Polygon();
        for (int i = 0; i < 9; i++) {
            p.addPoint((int) (200 + 35 * Math.cos(i * 2 * Math.PI / 9)),
                    (int) (200 + 35 * Math.sin(i * 2 * Math.PI / 9)));
        }
        g2.drawPolygon(p);
    }
}
