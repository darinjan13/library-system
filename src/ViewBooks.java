import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewBooks extends JDialog {
    String[][] fileContents;
    DefaultTableModel model;
    String[] columnNames = {"Title", "Author", "Quantity"};

    JTable table;

    public ViewBooks(JFrame parent) {
        super(parent, "View Books", true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) throws NullPointerException{
                final File folder = new File("C:\\Users\\admin\\IdeaProjects\\library-system\\src\\Books");
                File[] files = folder.listFiles();
                fileContents = new String[files.length][];
                for (int i = 0;i < files.length;i++) {
                    if (files[i].isFile()) {
                        try (BufferedReader br = new BufferedReader(new FileReader(files[i]))) {
                            List<String> lines = new ArrayList<>();
                            String line;
                            while ((line = br.readLine()) != null) {
                                String removeTitle = line.replaceAll("Title: ", "");
                                String removeAuthor = removeTitle.replaceAll("Author: ", "");
                                String removeQuantity = removeAuthor.replaceAll("Quantity: ", "");
                                lines.add(removeQuantity);
                            }
                            fileContents[i] = lines.toArray(new String[0]);
                        } catch (IOException exception) {
                            // Handle the exception
                        }

                    }
                }
                model = new DefaultTableModel(fileContents, columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                table = new JTable(model);

                JScrollPane scrollPane = new JScrollPane(table);
                JPanel panel = new JPanel();

                panel.add(scrollPane);

                getContentPane().add(panel);
                setSize(500, 500);
                setLocationRelativeTo(parent);
            }
        });

    }

}
