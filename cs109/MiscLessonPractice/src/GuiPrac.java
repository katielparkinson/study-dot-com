package MiscLessonPractice.src;

import java.awt.*;
import javax.swing.*;

public class GuiPrac {
    public static void main(String[] args) {
        JFrame myf = new JFrame("Swing Application");
        myf.setSize(500, 500);
        myf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel myj = new JPanel();
        myj.setLayout(new FlowLayout());

        JTextArea text1 = new JTextArea("Programming Is Usually Taught By Examples");
        JScrollPane scroll = new JScrollPane(text1);

        String motto = "Enter Name:";
        JOptionPane.showInputDialog(myf, motto);

        JLabel myl = new JLabel("ree ree ree");

        myf.add(scroll);
        myf.getContentPane().add(myl, BorderLayout.CENTER);
        myf.getContentPane().add(text1, BorderLayout.NORTH);

        myf.setLocationRelativeTo(null);
        myf.setVisible(true);
    }
}
