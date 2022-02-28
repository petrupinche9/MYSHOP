package it.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHelper {

    private static MailHelper instance;

    private static String FROM = "MYSHOP22@gmail.com";
    private static String PASSWORD = "finalmente22";

    public static synchronized MailHelper getInstance() {
        if(instance == null)
            instance = new MailHelper();
        return instance;
    }



        // metodo per inviare mail
    // new MailHelper().send("petruzzi.matteo99@gmail.com", "myshop", "msg di test");


    public void send(String to,String sub,String msg){
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(FROM,PASSWORD);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("message not sent");
        }

    }

}
