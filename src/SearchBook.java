import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchBook extends JDialog implements Sample{
    JTextField bookTitle;
    JButton search;
    public SearchBook(JFrame parent) {
        super(parent, "Search Book", true);
        bookTitle = new JTextField(14);
        bookTitle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String title = bookTitle.getText();
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search(title);
                    bookTitle.setText("");
                }
            }
        });
        search = new JButton("Search Book");
        search.addActionListener(new ActionListener() {
            String title = bookTitle.getText();
            @Override
            public void actionPerformed(ActionEvent e) {
                search(title);
            }
        });
        add(bookTitle);
        add(search);

        setSize(300, 80);
        setLocationRelativeTo(parent);
        setLayout(new FlowLayout(FlowLayout.LEFT));

    }

    @Override
    public String[] getFileNames() {
        String[] files = new String[FILES.length];
        for (int i = 0; i < FILES.length; i++) {
            String fileName = FILES[i].getName();
            files[i] = fileName.substring(0, fileName.lastIndexOf("."));
        }
        return files;
    }
    public void search(String title) {
        boolean bookFound = false;
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter title of the book.");
            return;
        }
        for (String book: getFileNames()) {
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
