import javax.swing.*;
import javax.swing.Action;

public class Firstpage {
    public void firstPage() {

        JFrame f = new JFrame();

        JButton startButton = new JButton("Start");
        startButton.setBounds(130, 100, 100, 40);

        f.add(startButton);

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
        JFrame frontpage = new JFrame();
        JPasswordField Password = new JPasswordField();
        JLabel P1 = new JLabel("Enter password");


    }

}