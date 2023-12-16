import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckIn extends JFrame {

    JTextField studentName;
    JButton submit;
    public CheckIn() {
        studentName = new JTextField(30);
        studentName.setBounds(45, 40, 100, 30);
        studentName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });
        submit = new JButton("Check in");
        submit.setBounds(45, 80, 100 , 30);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        add(studentName);
        add(submit);
        setTitle("Check In");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void login() {
        if (!studentName.getText().isEmpty()) {
            Controller controller = new Controller();
            controller.showMainPanel();
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Enter your Name.");
        }
    }

}
