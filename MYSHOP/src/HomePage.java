import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HomePage extends JFrame{
    private JPanel panel1;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JTable table1;

    // da aggiungere il metodo per aggiornare da database
    public HomePage() {
        Icon aboutIcon = new ImageIcon("image/lampadario.jpg");
        Icon addIcon = new ImageIcon("image/sedia.jpg");
        Icon copyIcon = new ImageIcon("image/sedia_game.jpg");
        String[] columns = {"Id", "Name", "Address", "Image"};
        //data for JTable in a 2D table
        Object[][] data = {
                {1, "Thomas", "Alaska", new ImageIcon("user1.png") },
                {2, "Jean", "Arizona", new ImageIcon("user2.png") },
                {3, "Yohan", "California", new ImageIcon("user3.png") },
                {4, "Emily", "Florida", new ImageIcon("user4.png") }
        };
        DefaultTableModel model = new DefaultTableModel(data, columns);

        JTable table = new JTable(model) {
            public Class getColumnClass(int column) {
                return (column == 3) ? Icon.class : Object.class;
            }
        };
        table.setRowHeight(60);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JLabel labelHead = new JLabel("List of employees");
        labelHead.setFont(new Font("Arial", Font.TRUETYPE_FONT,20));
        getContentPane().add(labelHead,BorderLayout.PAGE_START);
        table1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                //Set row height to 60 pixels

            }

        });
    }
}
