import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Library {
    JPanel panel;
    JButton viewBooks, addBooks, removeBook, borrowBook, searchBook;
    public Library(Controller controller) {
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
                controller.showRemoveBook();
            }
        });

        borrowBook = new JButton("Borrow Book");
        borrowBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showBorrowBook();
            }
        });

        searchBook = new JButton("Search Book");
        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showSearchBook();
            }
        });

        panel.add(viewBooks);
        panel.add(addBooks);
        panel.add(removeBook);
        panel.add(borrowBook);
        panel.add(searchBook);
    }

    public JPanel getPanel() {
        return panel;
    }

}
