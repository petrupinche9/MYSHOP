import javax.swing.*;

public class MENU extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel Login;
    private JButton LOGINButton;
    private JButton LOGINASGUESTButton;

    public MENU(){
        setContentPane(Login);
        setTitle("MYSHOP");
        setSize(480,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MENU frame= new MENU();
    }



}
