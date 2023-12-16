import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AddBooks extends JDialog implements Sample{
    JTextField title, author;
    JButton addBook;
    public AddBooks(JFrame parent) {
        super(parent, "Add Books", true);
        title = new JTextField();
        title.setBounds(50, 10, 100, 50);
        title.setColumns(10);

        author = new JTextField();
        author.setBounds(50, 60, 100, 50);
        author.setColumns(10);

        addBook = new JButton("Add Books");
        addBook.setBounds(50, 110, 100, 50);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strTitle = title.getText();
                String strAuthor = author.getText();
                String fileName = strTitle + ".txt";
                File file = new File(FOLDER_PATH, fileName);
                try {
                    PrintWriter pr = new PrintWriter(file);
                    pr.println("Title: " + strTitle);
                    pr.println("Author: " + strAuthor);
                    JOptionPane.showMessageDialog(null, "Book " + strTitle.toUpperCase() + " by " + strAuthor.toUpperCase() +" Added.");
                    title.setText("");
                    author.setText("");
                    pr.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JPanel panel = new JPanel();

        panel.add(title);
        panel.add(author);
        panel.add(addBook);

        getContentPane().add(panel);
        setSize(400, 100);
        setLocationRelativeTo(parent);
    }

    @Override
    public String[] getFileNames() {
        return null;
    }
}
