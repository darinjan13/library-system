import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchBook extends JDialog {
    JPanel panel;
    JRadioButton searchAuthor, searchTitle;
    JTextField textField;
    JButton search;

    DefaultTableModel booksModel;
    String[] booksColumnNames = {"Title", "Author", "Quantity"};
    JTable booksTable;
    ButtonGroup buttonGroup;

    public SearchBook(JFrame parent, Library library){
        super(parent, "Search Books", true);
        panel  = new JPanel(null);
        searchAuthor = new JRadioButton("Search by Author", true);
        searchAuthor.setBounds(10, 30, 150, 30);
        searchTitle = new JRadioButton("Search by Title");
        searchTitle.setBounds(160, 30, 150, 30);
        textField = new JTextField();
        textField.setBounds(70, 60, 150, 30);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    search(library);
            }
        });

        search = new JButton("Search");
        search.setBounds(90, 90, 110, 30);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search(library);
            }
        });

        buttonGroup = new ButtonGroup();

        buttonGroup.add(searchAuthor);
        buttonGroup.add(searchTitle);

        booksTable = new JTable(booksModel);
        booksTable.setBounds(10, 10, 200, 200);

        JScrollPane booksScrollPane = new JScrollPane(booksTable);
        booksScrollPane.setBounds(50, 120, 190, 100);

        add(searchAuthor);
        add(searchTitle);
        add(textField);
        add(search);
        add(booksScrollPane);
        setSize(300, 300);
        setLayout(null);
        setLocationRelativeTo(parent);

    }

    public void search(Library library) {
        String search = textField.getText();
        String[][] booksByAuthor;
        if (searchAuthor.isSelected()) {
            if (search.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please enter the author.");
            } else {
                if (library.isAuthorExist(search)) {
                    booksByAuthor = library.searchByAuthor(search);
                    DefaultTableModel booksModel = new DefaultTableModel(booksByAuthor, booksColumnNames);
                    booksTable.setModel(booksModel);
                    booksTable.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Author does not exist!");
                }
            }
        } else if (searchTitle.isSelected()) {
            if (search.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please enter the title.");
            } else {
                if (library.searchByTitle(search).length > 0){
                    booksByAuthor = library.searchByTitle(search);
                    DefaultTableModel booksModel = new DefaultTableModel(booksByAuthor, booksColumnNames);
                    booksTable.setModel(booksModel);
                    booksTable.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "Book does not exist!");
                }
            }
        }
        textField.setText("");
    }
}
