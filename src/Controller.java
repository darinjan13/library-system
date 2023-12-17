import javax.swing.*;

public class Controller implements Sample{
    JFrame frame;

    public Controller() {
        frame = new JFrame("Library System");
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
        ViewBooks viewBooks = new ViewBooks(frame);
        viewBooks.setVisible(true);
    }
    public void showAddBook() {
        AddBooks addBooks = new AddBooks(frame);
        addBooks.setVisible(true);
    }

    public void showRemoveBook() throws Exception {
        WatchDirectory watchDirectory = new WatchDirectory(FOLDER_PATH);
        watchDirectory.start();
        RemoveBook removeBook = new RemoveBook(frame, watchDirectory.getFileNames());
        if (watchDirectory.getFileNames().length != 0) {
            removeBook.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Book is empty.");
        }
    }

    public void showCheckInBook() throws Exception {
        WatchDirectory watchDirectory = new WatchDirectory(FOLDER_PATH);
        watchDirectory.start();
        CheckInBook checkInBook = new CheckInBook(frame, watchDirectory.getFileNames());
        checkInBook.setVisible(true);
    }

    public void showCheckOutBook() throws Exception {
        WatchDirectory watchDirectory = new WatchDirectory(FOLDER_PATH);
        watchDirectory.start();
        CheckOutBook checkOutBook = new CheckOutBook(frame, watchDirectory.getFileNames());
        checkOutBook.setVisible(true);
    }

    public void showSearchBook() throws Exception {
        WatchDirectory watchDirectory = new WatchDirectory(FOLDER_PATH);
        watchDirectory.start();
        SearchBook searchBook = new SearchBook(frame, watchDirectory.getFileNames());
        searchBook.setVisible(true);
    }
}
