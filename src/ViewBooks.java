import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class ViewBooks extends JDialog {

    List<List<String>> bookDataList;
    DefaultTableModel booksModel;
    String[] booksColumnNames = {"Title", "Author", "Quantity"};

    JTable booksTable, borrowedBooksTable;

    public ViewBooks(JFrame parent, Library library) {
        super(parent, "View Books", true);
        bookDataList = library.getBooks();
        String[][] bookDataArray = new String[bookDataList.size()][];
        for (int i = 0; i < bookDataList.size(); i++) {
            List<String> row = bookDataList.get(i);
            bookDataArray[i] = row.toArray(new String[0]);
        }



        booksModel = new DefaultTableModel(bookDataArray, booksColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        booksTable = new JTable(booksModel);

        JScrollPane booksScrollPane = new JScrollPane(booksTable);

        JPanel panel = new JPanel();
        panel.add(booksScrollPane);
        add(panel);

        setSize(500, 500);
        getContentPane().add(panel);
        setLocationRelativeTo(parent);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowOpened(WindowEvent e){
//                bookDataList = library.getBooks();
//                String[][] bookDataArray = new String[bookDataList.size()][];
//                for (int i = 0; i < bookDataList.size(); i++) {
//                    List<String> row = bookDataList.get(i);
//                    bookDataArray[i] = row.toArray(new String[0]);
//                }
//
//
//
//                booksModel = new DefaultTableModel(bookDataArray, booksColumnNames) {
//                    @Override
//                    public boolean isCellEditable(int row, int column) {
//                        return false;
//                    }
//                };
//
//                booksTable = new JTable(booksModel);
//
//                JScrollPane booksScrollPane = new JScrollPane(booksTable);
//
//                String[][] borrowers = library.getBorrowers();
//
//                borrowedBooksModel = new DefaultTableModel(borrowers, borrowersColumnNames) {
//                    @Override
//                    public boolean isCellEditable(int row, int column) {
//                        return false;
//                    }
//                };
//
//                borrowedBooksTable = new JTable(borrowedBooksModel);
//
//                JScrollPane borrowersScrollPane = new JScrollPane(borrowedBooksTable);
//
//
//                add(booksScrollPane);
//                add(borrowersScrollPane);
//
////                getContentPane().add(panel);
//                setSize(500, 500);
//                setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//                setLocationRelativeTo(parent);
//            }
//        });

    }

}
