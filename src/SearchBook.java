import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchBook extends JDialog implements Sample{
    JTextField bookTitle;
    JButton search;
    String title;
    public SearchBook(JFrame parent, String[] books) {
        super(parent, "Search Book", true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        bookTitle = new JTextField(14);
        bookTitle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                title = bookTitle.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search(title, books);
                    bookTitle.setText("");
                }
            }
        });
        search = new JButton("Press Enter");
        search.setForeground(Color.BLACK);
        search.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 12));
        search.setBackground(Color.darkGray);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                title = bookTitle.getText();
                search(title, books);
                bookTitle.setText("");
            }
        });
        panel.add(bookTitle);
        panel.add(search);

        setSize(300, 80);
        setLocationRelativeTo(parent);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        add(panel);

    }

    public void search(String title, String[] books) {
        boolean bookFound = false;
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter title of the book.");
            return;
        }
        for (String book: books) {
            if (book.equalsIgnoreCase(title)) {
                JOptionPane.showMessageDialog(null, "Book Found.");
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            JOptionPane.showMessageDialog(null, "Book not Found.");
        }
    }
}