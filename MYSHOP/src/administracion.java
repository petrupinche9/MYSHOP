import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ascoltatore4 implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        JButton b = (JButton)event.getSource();
    }
}

public class administracion extends JFrame
{
    private JButton aggiungiProfottoButton;
    private JButton modificaProdottoButton;
    private JButton eliminaProdottoButton;
    private JButton eliminaServizioButton;
    private JButton modificaServizioButton;
    private JButton aggiungiServizioButton;
    private JPanel administracionPanel;
    Ascoltatore4 listener4 = new Ascoltatore4();

    public administracion()
    {
        setContentPane(administracionPanel);
        setTitle("MODIFICA MYSHOP");
        aggiungiProfottoButton.addActionListener(listener4);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
