import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame{
    JPanel panel;
    JButton viewBooks, addBooks, removeBook, checkInBook, checkOutBook, searchBook, checkedOutBooks;
    ImageIcon background = new ImageIcon("C:\\Users\\admin\\IdeaProjects\\library-system\\src\\uc.jpg");
    Image img = background.getImage();
    Image temp = img.getScaledInstance(500, 60, Image.SCALE_SMOOTH);
    public Home() {
        Controller controller = new Controller();
        viewBooks = new JButton("View Books");
        viewBooks.setForeground(Color.BLACK);
        viewBooks.setBackground(Color.WHITE);
        viewBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showViewBooks();
            }
        });

        addBooks = new JButton("Add Books");
        addBooks.setForeground(Color.BLACK);
        addBooks.setBackground(Color.WHITE);
        addBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.showAddBook();
            }
        });

        removeBook = new JButton("Remove Book");
        removeBook.setForeground(Color.BLACK);
        removeBook.setBackground(Color.WHITE);
        removeBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showRemoveBook();
            }
        });

        checkInBook = new JButton("Check In Book");
        checkInBook.setForeground(Color.BLACK);
        checkInBook.setBackground(Color.WHITE);
        checkInBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showCheckInBook();
            }
        });

        checkOutBook = new JButton("Check Out Book");
        checkOutBook.setForeground(Color.BLACK);
        checkOutBook.setBackground(Color.WHITE);
        checkOutBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showCheckOutBook();
            }
        });

        searchBook = new JButton("Search Book");
        searchBook.setForeground(Color.BLACK);
        searchBook.setBackground(Color.WHITE);
        searchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showSearchBook();
            }
        });
        checkedOutBooks = new JButton("View Checked out Books");
        checkedOutBooks.setForeground(Color.BLACK);
        checkedOutBooks.setBackground(Color.WHITE);
        checkedOutBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showViewCheckedOutBooks();
            }
        });

        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(new BorderLayout());
        back.setBounds(0, 0, 500, 60);

        panel = new JPanel();
        panel.setBackground(new Color(174, 186, 250));
        panel.add(back);
        panel.add(viewBooks);
        panel.add(addBooks);
        panel.add(removeBook);
        panel.add(checkInBook);
        panel.add(checkOutBook);
        panel.add(searchBook);
        panel.add(checkedOutBooks);
        setTitle("Library System");
        getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

}