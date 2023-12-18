import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                            String[] borrower1 = library.getBorrower().toArray(new String[0]);
                            System.out.println(borrower1.length);
                            for (Borrower borrower : library.getBorrower()) {
                                    Books borrowedBook = borrower.getBorrowedBook();
                                    if (borrowedBook != null) {
                                        writer.println("Borrower Name: " + borrower.getName());
                                        writer.println("Contact: " + borrower.getContact());
                                        writer.println("Borrowed Book Title: " + borrowedBook.getBookTitle());
                                        writer.println("Borrowed Book Author: " + borrowedBook.getBookAuthor());
                                    }
                                    writer.close();
                                }
                        } catch (IOException ie) {
                            JOptionPane.showMessageDialog(null, "Something error occured while printing the file,", "Error", JOptionPane.ERROR_MESSAGE);
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
                                    } else {
                                        JOptionPane.showMessageDialog(null, name + " has no borrowed books.");
                                    }
                                    writer.close();
                                } else {
                                    JOptionPane.showMessageDialog(null, name + " has no borrowed books.");
                                }
                            }
                        } catch (IOException ie) {
                            JOptionPane.showMessageDialog(null, "Something error occured while printing the file,", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
            }
        });

        JPanel panel = new JPanel();
        panel.add(borrowersScrollPane);
        panel.add(print);
        getContentPane().add(panel);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}
