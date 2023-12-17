import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RemoveBook extends JDialog implements Sample{
    JComboBox comboBox;
    JButton removeButton, addBookButton;
    public RemoveBook(JFrame parent, String[] books) {
        super(parent, "Remove Book", true);
        comboBox = new JComboBox<>(books);
        removeButton = new JButton("Remove Book?");
        addBookButton = new JButton("Add Book");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = books.length;
                    String selectedBook = comboBox.getSelectedItem().toString();
                    int selectedBookIndex = comboBox.getSelectedIndex();
                    File bookSelected = new File(FOLDER_PATH + "\\" + selectedBook + ".txt");
                    if (bookSelected.delete()) {
                        JOptionPane.showMessageDialog(null, "Book " + comboBox.getSelectedItem().toString().toUpperCase() + " removed");
                        comboBox.removeItemAt(selectedBookIndex);
                        i--;
                    }
                    if (i == 0) {
                        JOptionPane.showMessageDialog(null, "There is no books available, add some books first.", "Message", JOptionPane.ERROR_MESSAGE);
                        setVisible(false);
                    }
                }
        });

        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(removeButton);
        getContentPane().add(panel);
        setSize(200, 100);
        setLocationRelativeTo(parent);
    }
}
