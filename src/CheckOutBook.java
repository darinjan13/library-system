import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CheckOutBook extends JDialog implements Sample{
    JComboBox comboBox;
    JTextField borrowerName, bookName;
    JButton checkOut;

    public CheckOutBook(JFrame parent, String[] books) {
        super(parent, "Check Out Book", true);
        comboBox = new JComboBox<>(books);
        comboBox.setBounds(100, 10, 100, 30);

        borrowerName = new JTextField();
        borrowerName.setBounds(100, 40, 100, 30);

        checkOut = new JButton("Check out Book");
        checkOut.setBounds(100, 70, 100, 30);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = comboBox.getSelectedItem().toString();
                File bookSelected = new File(FOLDER_PATH + "\\" + selectedBook + ".txt");
                try {
                    File inputFile = bookSelected;
                    File tempFile = new File(CHECKED_OUT_PATH + "\\" + "tempfile.txt");
                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
        });

        add(comboBox);
        add(borrowerName);
        add(checkOut);
        setLayout(null);
        setSize(300, 500);
        setLocationRelativeTo(parent);
    }
}
