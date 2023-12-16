import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class RemoveBook extends JDialog implements Sample{
    JComboBox comboBox;
    JButton removeButton;
    public RemoveBook(JFrame parent) {
        super(parent, "Remove Book", true);

        comboBox = new JComboBox<>(getFileNames());
        removeButton = new JButton("Remove Book?");

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = comboBox.getSelectedItem().toString();
                File bookSelected = new File(FOLDER_PATH + "\\" + selectedBook + ".txt");
                System.out.println(bookSelected);
                if (bookSelected.delete()) {
                    JOptionPane.showMessageDialog(null, "Book " + comboBox.getSelectedItem().toString().toUpperCase() + " removed");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(removeButton);
        getContentPane().add(panel);
        setSize(500, 500);
        setLocationRelativeTo(parent);
    }

    @Override
    public String[] getFileNames() {
        String[] files = new String[FILES.length];
        for (int i = 0; i < FILES.length; i++) {
            String fileName = FILES[i].getName();
            files[i] = fileName.substring(0, fileName.lastIndexOf("."));
        }
        return files;
    }
}
