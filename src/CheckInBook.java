import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class CheckInBook extends JDialog {
    Library library;
    JLabel[] label;
    JPanel[] panel;
    JTextField bookTitle, borrowerName;
    JButton checkIn;

    public CheckInBook(JFrame parent, Library library) {
        super(parent, "Check in Book", true);
        this.library = library;
        bookTitle = new JTextField();
        bookTitle.setPreferredSize(new Dimension(150, 30));
        bookTitle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    checkIn();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    setVisible(false);
            }
        });


        borrowerName = new JTextField();
        borrowerName.setPreferredSize(new Dimension(150, 30));
        borrowerName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkIn();
                }
            }
        });

        checkIn = new JButton("Check in Book");
        checkIn.setBounds(100, 100, 100, 30);
        checkIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkIn();
            }
        });

        panel = new JPanel[3];
        label = new JLabel[3];
        for (int i = 0; i < panel.length; i++) {
            panel[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            panel[i].setMaximumSize(new Dimension(400, 100));
            label[i] = new JLabel();
            label[i].setPreferredSize(new Dimension(150, 20));
        }
        label[0].setText("Book Title: ");
        label[1].setText("Borrowers Name: ");

        panel[0].add(label[0]);
        panel[0].add(bookTitle);
        panel[1].add(label[1]);
        panel[1].add(borrowerName);
        panel[2].add(checkIn);
        for (int i = 0; i < 3; i++) {
            getContentPane().add(panel[i]);
        }
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 300);
        setLocationRelativeTo(parent);
    }

    public void checkIn() {
        String bookTitleStr = bookTitle.getText();
        String borrowerNameStr = borrowerName.getText();
        if (bookTitleStr.isBlank()){
            JOptionPane.showMessageDialog(null, "Please enter book's title.");
        } else if (borrowerNameStr.isBlank()) {
            JOptionPane.showMessageDialog(null, "Please enter borrower's name.");
        } else {
            if (!library.borrowerExists(borrowerNameStr)) {
                JOptionPane.showMessageDialog(null, "You don't have any book borrowed.");
            } else if (!library.borrowedBookExists(bookTitleStr)){
                JOptionPane.showMessageDialog(null, "You did not borrow the book that you entered.");
            } else {
                library.checkInBook(bookTitleStr, borrowerNameStr);
                JOptionPane.showMessageDialog(null, "Book has returned.");
                bookTitle.setText("");
                borrowerName.setText("");
            }
        }
    }
}