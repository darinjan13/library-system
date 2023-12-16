import javax.swing.*;

public class Controller {
    JFrame frame;

    public Controller() {
        frame = new JFrame("Library System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void showMainPanel() {
        Library library = new Library(this);
        frame.getContentPane().add(library.getPanel());
        frame.setSize(500,100);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public void showViewBooks() {
        ViewBooks viewBooks = new ViewBooks(frame);
        viewBooks.setVisible(true);
    }
    public void showAddBook() {
        AddBooks addBooks = new AddBooks(frame);
        addBooks.setVisible(true);
    }

    public void showRemoveBook() {
        RemoveBook removeBook = new RemoveBook(frame);
        removeBook.setVisible(true);
    }

    public void showBorrowBook() {
        BorrowBook borrowBook = new BorrowBook(frame);
        borrowBook.setVisible(true);
    }

    public void showSearchBook() {
        SearchBook searchBook = new SearchBook(frame);
        searchBook.setVisible(true);
    }
}
