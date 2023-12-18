import javax.swing.*;

public class Controller{
    Library library = new Library();
    JFrame frame;

    public Controller() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//    public void showMainPanel() {
//        Library library = new Library();
//        frame.getContentPane().add(library.getPanel());
//        frame.setSize(500,100);
//        frame.setLocationRelativeTo(null);
//
//        frame.setVisible(true);
//    }

    public void showViewBooks() {
        ViewBooks viewBooks = new ViewBooks(frame, library);
        viewBooks.setVisible(true);
    }
    public void showAddBook() {
        AddBooks addBooks = new AddBooks(frame, library);
        addBooks.setVisible(true);
    }

    public void showRemoveBook() {
        RemoveBook removeBook = new RemoveBook(frame, library);
        if (library.isBookEmpty()) {
            JOptionPane.showMessageDialog(null, "Book is empty.", JOptionPane.OPTIONS_PROPERTY, JOptionPane.ERROR_MESSAGE);
        } else {
            removeBook.setVisible(true);
        }
    }

    public void showCheckInBook() {
        CheckInBook checkInBook = new CheckInBook(frame, library);
        if (library.isBorrowerEmpty()) {
            JOptionPane.showMessageDialog(null, "Book is empty.", JOptionPane.OPTIONS_PROPERTY, JOptionPane.ERROR_MESSAGE);
        } else {
            checkInBook.setVisible(true);
        }
    }

    public void showCheckOutBook() {
        CheckOutBook checkOutBook = new CheckOutBook(frame, library);
        if (library.isBookEmpty()) {
            JOptionPane.showMessageDialog(null, "Book is empty.", JOptionPane.OPTIONS_PROPERTY, JOptionPane.ERROR_MESSAGE);
        } else {
            checkOutBook.setVisible(true);
        }
    }

    public void showSearchBook() {
        SearchBook searchBook = new SearchBook(frame, library);
        if (library.isBookEmpty()) {
            JOptionPane.showMessageDialog(null, "Book is empty.", JOptionPane.OPTIONS_PROPERTY, JOptionPane.ERROR_MESSAGE);
        } else {
            searchBook.setVisible(true);
        }
    }
    public void showViewCheckedOutBooks() {
        ViewCheckedOutBooks viewCheckedOutBooks = new ViewCheckedOutBooks(frame, library);
        if (library.isBorrowerEmpty()) {
            JOptionPane.showMessageDialog(null, "There is currently no checked out book.", JOptionPane.OPTIONS_PROPERTY, JOptionPane.ERROR_MESSAGE);
        } else {
            viewCheckedOutBooks.setVisible(true);
        }
    }
}