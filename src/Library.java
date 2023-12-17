import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Library extends JFrame{
    JPanel panel;
    JButton viewBooks, addBooks, removeBook, checkInBook, checkOutBook, searchBook;
    public Library() {
        Controller controller = new Controller();
        panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        viewBooks = new JButton("View Books");
        viewBooks.setForeground(Color.RED);
        viewBooks.setBackground(Color.LIGHT_GRAY);
        viewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showViewBooks();
            }
        });

        addBooks = new JButton("Add Books");
        addBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showAddBook();
            }
        });

        removeBook = new JButton("Remove Book");
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showRemoveBook();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        checkInBook = new JButton("Check In Book");
        checkInBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showCheckInBook();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        checkOutBook = new JButton("Check Out Book");
        checkOutBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showCheckOutBook();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        searchBook = new JButton("Search Book");
        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.showSearchBook();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        panel.add(viewBooks);
        panel.add(addBooks);
        panel.add(removeBook);
        panel.add(checkInBook);
        panel.add(checkOutBook);
        panel.add(searchBook);
        setTitle("Library System");
        getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
