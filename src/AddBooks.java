import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.*;

public class AddBooks extends JDialog implements Sample{
    JTextField title, author, quantity;
    JButton addBook;
    public AddBooks(JFrame parent) {
        super(parent, "Add Books", true);
        title = new JTextField();
        title.setBounds(150, 10, 100, 20);

        author = new JTextField();
        author.setBounds(150, 60, 100, 20);

        quantity = new JTextField();
        quantity.setBounds(150, 110, 100, 20);

        addBook = new JButton("Add Books");
        addBook.setBounds(150, 160, 100, 20);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strTitle = title.getText();
                String strAuthor = author.getText();
                String strQuantity = quantity.getText();
                String fileName = strTitle + ".txt";
                if (strTitle.isEmpty() || strAuthor.isBlank() || strQuantity.isBlank())
                    JOptionPane.showMessageDialog(null, "Please enter details");
                else {
                    int quantity = Integer.parseInt(strQuantity);
                    Books books = new Books(strTitle, strAuthor, quantity);
                }
            }
        });
//        addBook.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String strTitle = title.getText();
//                String strAuthor = author.getText();
//                String strQuantity = quantity.getText();
//                String fileName = strTitle + ".txt";
//                if (strTitle.isEmpty() || strAuthor.isBlank() || strQuantity.isBlank())
//                    JOptionPane.showMessageDialog(null, "Please enter details");
//                else {
//                    File file = new File(FOLDER_PATH, fileName);
//                    try {
//                        PrintWriter pr = new PrintWriter(file);
//                        pr.println("Title: " + strTitle);
//                        pr.println("Author: " + strAuthor);
//                        pr.println("Quantity: " + strQuantity);
//                        JOptionPane.showMessageDialog(null, "Book " + strTitle.toUpperCase() + " by " + strAuthor.toUpperCase() +" Added.");
//                        title.setText("");
//                        author.setText("");
//                        quantity.setText("");
//                        pr.close();
//                    } catch (FileNotFoundException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                }
//            }
//        });

        JPanel panel = new JPanel();

        add(title);
        add(author);
        add(quantity);
        add(addBook);

//        getContentPane().add(panel);
        setSize(400, 500);
        setLocationRelativeTo(parent);
        setLayout(null);
    }
}
