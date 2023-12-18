import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CheckOutBook extends JDialog {
    Library library;
    JLabel[] label;
    JPanel[] panel;
    JComboBox comboBox;
    JTextField borrowerName, borrowerContact;
    JButton checkOut;

    public CheckOutBook(JFrame parent, Library library) {
        super(parent, "Check Out Book", true);
        this.library = library;
        String[] titles = library.getBookTitles().toArray(new String[0]);
        comboBox = new JComboBox<>(titles);
        comboBox.setPreferredSize(new Dimension(100, 30));

        borrowerName = new JTextField();
        borrowerName.setPreferredSize(new Dimension(150, 30));
        borrowerName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    checkOut();
            }
        });

        borrowerContact = new JTextField();
        borrowerContact.setPreferredSize(new Dimension(150, 30));
        borrowerContact.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    checkOut();
            }
        });

        checkOut = new JButton("Check out Book");
        checkOut.setBounds(100, 100, 100, 30);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkOut();
            }
        });

        panel = new JPanel[4];
        label = new JLabel[4];
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            panel[i].setMaximumSize(new Dimension(400, 100));
            label[i] = new JLabel();
            label[i].setPreferredSize(new Dimension(200, 20));
        }
        label[0].setText("Book Title: ");
        label[1].setText("Borrowers Name: ");
        label[2].setText("Borrowers Contact Number: ");

        panel[0].add(label[0]);
        panel[0].add(comboBox);
        panel[1].add(label[1]);
        panel[1].add(borrowerName);
        panel[2].add(label[2]);
        panel[2].add(borrowerContact);
        panel[3].add(checkOut);
        for (int i = 0; i < 4; i++) {
            getContentPane().add(panel[i]);
        }
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 300);
        setLocationRelativeTo(parent);
    }

    public void checkOut() {
        String selectedBook = comboBox.getSelectedItem().toString();
        String borrowerNameStr = borrowerName.getText();
        String borrowerContactStr = borrowerContact.getText();

        if (borrowerNameStr.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter borrower's name.");

        }
        else if (borrowerContactStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter your contact number.");
        }
        else {
            try {
                int borrowerContactNumber = Integer.parseInt(borrowerContactStr);
                Borrower borrower = new Borrower(borrowerNameStr, borrowerContactNumber);
                Books books = library.getBookByTitle(selectedBook);
                if (library.addBorrwer(borrower, books)) {
                    JOptionPane.showMessageDialog(null, "Checked out Successfully.");
                    borrowerName.setText("");
                    borrowerContact.setText("");
                }
                else
                    JOptionPane.showMessageDialog(null, "The book you want to borrow is not available.");
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(null, "Please enter correct contact number.");
                borrowerContact.setText("");

            }

        }

    }
}