import javax.swing.*;

public class MENU extends JFrame{
    private JPanel Login;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton loginAsGuestButton;

    private MENU(){
        setContentPane(Login);
        setTitle("MYSHOP");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
       /*DBMS CONNECT String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                        + "database=AdventureWorks;"
                        + "user=yourusername@yourserver;"
                        + "password=yourpassword;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
        MENU frame= new MENU();
    }
}
