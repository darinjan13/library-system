import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInBook extends JDialog implements Sample{

//    String[] months = new String[] { "Jan", "February", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    JComboBox comboBox;
    JButton removeButton;

//    JTextField borrowerName, days, years;
    JTextField borrowerName;

    public CheckInBook(JFrame parent, String[] books) {
        super(parent, "Borrow Book", true);

        comboBox = new JComboBox<>(books);
        comboBox.setBounds(100, 10, 100, 30);

        borrowerName = new JTextField();
        borrowerName.setBounds(100, 50, 100, 30);

//        comboBoxMonth = new JComboBox<>(months);
//        comboBoxMonth.setBounds(50, 70, 100, 30);
//        days = new JTextField(3);
//        days.setBounds(160, 70, 25, 30);
//        years = new JTextField(3);
//        years.setBounds(190, 70, 50, 30);

        removeButton = new JButton("Remove Book?");
        removeButton.setBounds(100, 210, 100 ,50);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(comboBox);
        add(borrowerName);
//        add(comboBoxMonth);
//        add(days);
//        add(years);
        add(removeButton);
        setLayout(null);
        setSize(300, 500);
        setLocationRelativeTo(parent);
    }
}
