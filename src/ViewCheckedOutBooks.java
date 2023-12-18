import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewCheckedOutBooks extends JDialog {
    String[] borrowersColumnNames = {"Title", "Author" , "Borrower's Name", "Borrower's Contact"};
    Object[] options = {"All", "By Name", "Cancel"};
    DefaultTableModel borrowedBooksModel;
    JButton print;
    JTable borrowedBooksTable;

    public ViewCheckedOutBooks(JFrame parent, Library library) {
        super(parent, "Checked out Books", true);

        String[][] borrowers = library.getBorrowers();

        borrowedBooksModel = new DefaultTableModel(borrowers, borrowersColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        borrowedBooksTable = new JTable(borrowedBooksModel);

        JScrollPane borrowersScrollPane = new JScrollPane(borrowedBooksTable);

        print = new JButton("Print Record on a text file");
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int choice = JOptionPane.showOptionDialog(null, "Print all records or Print only by borrowers name?", "Choose what to print.", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                    if (choice == 0) {
                        try {
                            PrintWriter writer = new PrintWriter( "BorrowedBooks.txt");
                            System.out.println(library.borrowerLength());
                            for (Borrower borrower : library.getBorrower()) {
                                    Books borrowedBook = borrower.getBorrowedBook();
                                if (borrowedBook != null) {
                                    writer.println("Borrower Name: " + borrower.getName());
                                    writer.println("Contact Number: " + borrower.getContact());
                                    writer.println("Borrowed Book Title: " + borrowedBook.getBookTitle());
                                    writer.println("Borrowed Book Author: " + borrowedBook.getBookAuthor());
                                    writer.println("----------------------------");
                                }
                                }
                            writer.close();
                        } catch (IOException ie) {
                            JOptionPane.showMessageDialog(null, "Something error occurred while printing the file,", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else if (choice == 1) {
                        String name = JOptionPane.showInputDialog("Enter name of borrower");
                        try {
                            for (Borrower borrower : library.getBorrower()) {
                                if (borrower.getName().equals(name)) {
                                    Books borrowedBook = borrower.getBorrowedBook();
                                    PrintWriter writer = new PrintWriter(name + ".txt");
                                    if (borrowedBook != null) {
                                        writer.println("Borrower Name: " + borrower.getName());
                                        writer.println("Contact: " + borrower.getContact());
                                        writer.println("Borrowed Book Title: " + borrowedBook.getBookTitle());
                                        writer.println("Borrowed Book Author: " + borrowedBook.getBookAuthor());
                                        writer.println("----------------------------");
                                    } else {
                                        JOptionPane.showMessageDialog(null, name + " has no borrowed books.");
                                    }
                                    writer.close();
                                } else {
                                    JOptionPane.showMessageDialog(null, name + " has no borrowed books.");
                                }
                            }
                        } catch (IOException ie) {
                            JOptionPane.showMessageDialog(null, "Something error occurred while printing the file,", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
            }
        });

        JPanel panel = new JPanel();
        panel.add(borrowersScrollPane);
        panel.add(print);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    dispose();
            }
        });

        setFocusable(true);
        getContentPane().add(panel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}
