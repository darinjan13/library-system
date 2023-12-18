import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddBooks extends JDialog{
    Library library;
    JTextField title, author, quantity;
    JLabel titleLabel, authorLabel, quantityLabel;
    JButton addBook;
    public AddBooks(JFrame parent, Library library) {
        super(parent, "Add Books", true);
        this.library = library;
        titleLabel = new JLabel("Title: ");
        titleLabel.setBounds(50, 10,50, 20);
        title = new JTextField();
        title.setBounds(150, 10, 100, 20);
        title.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    addBook();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    dispose();
            }
        });

        authorLabel = new JLabel("Author: ");
        authorLabel.setBounds(50, 60, 50, 20);
        author = new JTextField();
        author.setBounds(150, 60, 100, 20);
        author.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    addBook();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    dispose();
            }
        });

        quantityLabel = new JLabel("Quantity: ");
        quantityLabel.setBounds(50, 110, 70, 20);
        quantity = new JTextField();
        quantity.setBounds(150, 110, 100, 20);
        quantity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    addBook();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    dispose();
            }
        });

        addBook = new JButton("Add Books");
        addBook.setBounds(100, 160, 100, 30);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        add(titleLabel);
        add(title);
        add(authorLabel);
        add(author);
        add(quantityLabel);
        add(quantity);
        add(addBook);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    dispose();
            }
        });

        setFocusable(true);

        setSize(300, 300);
        setLocationRelativeTo(parent);
        setLayout(null);
    }
    public void addBook() {
        String strTitle = title.getText();
        String strAuthor = author.getText();
        String strQuantity = quantity.getText();
        if (strTitle.isBlank() || strAuthor.isBlank() || strQuantity.isBlank())
            JOptionPane.showMessageDialog(null, "Please enter complete details");
        else {
            try {
                int quantityInt = Integer.parseInt(strQuantity);
                Books book = new Books(strTitle, strAuthor, quantityInt);
                if (library.isBookExist(book)) {
                    JOptionPane.showMessageDialog(null, "Book Already exist so the quantity of the book is added.");
                    library.addBook(book);
                } else {
                    JOptionPane.showMessageDialog(null, "Book successfully added.");
                    library.addBook(book);
                }
                title.setText("");
                author.setText("");
                quantity.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number for the quantity.", JOptionPane.MESSAGE_PROPERTY, JOptionPane.ERROR_MESSAGE);
                quantity.setText("");
            }
        }
    }
}