import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBook extends JDialog {
    Library library;
    JComboBox comboBox;
    JButton removeButton, addBookButton;
    public RemoveBook(JFrame parent, Library library) {
        super(parent, "Remove Book", true);
        this.library = library;
        String[] titles = library.getBookTitles().toArray(new String[0]);
        comboBox = new JComboBox<>(titles);
        removeButton = new JButton("Remove Book?");
        addBookButton = new JButton("Add Book");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = titles.length;
                String selectedBook = comboBox.getSelectedItem().toString();
                int selectedBookIndex = comboBox.getSelectedIndex();
                if (library.removeBook(selectedBook)) {
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

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 100));
        panel.setBounds(10,10,300,300);
        panel.add(comboBox);
        panel.add(removeButton);
        getContentPane().add(panel);
        setSize(300, 300);
        setLocationRelativeTo(parent);
    }
}