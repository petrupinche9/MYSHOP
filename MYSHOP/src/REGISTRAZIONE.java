import javax.swing.*;

public class REGISTRAZIONE extends JFrame
{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton COMPLETAREGISTRAZIONEButton;
    private JPanel RegistrazionePannello;

    public REGISTRAZIONE()
    {
        setContentPane(RegistrazionePannello);
        setTitle("REGISTRAZIONE MYSHOP");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
