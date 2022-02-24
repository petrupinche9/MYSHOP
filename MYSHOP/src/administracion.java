import javax.swing.*;

public class administracion extends JFrame
{
    private JButton aggiungiProfottoButton;
    private JButton modificaProdottoButton;
    private JButton eliminaProdottoButton;
    private JButton eliminaServizioButton;
    private JButton modificaServizioButton;
    private JButton aggiungiServizioButton;
    private JPanel administracionPanel;

    public administracion()
    {
        setContentPane(administracionPanel);
        setTitle("MODIFICA MYSHOP");
        setSize(300, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
