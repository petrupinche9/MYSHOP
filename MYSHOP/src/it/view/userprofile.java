package it.view;

import it.model.user;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userprofile extends JFrame{
    private JLabel client;
    private JButton VISUALIZZAACQUISTIButton;
    private JButton MODIFICADATIPERSONALIButton;
    private JPanel panel;

    public userprofile() {
        setContentPane(panel);
        client.setText(Session.getInstance().getClienteLoggato().getUsername());
        MODIFICADATIPERSONALIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userinfo cf=new userinfo();
                user cli= Session.getInstance().getClienteLoggato();
                //set dati
                cf.setAge(String.valueOf(cli.getAge()));
                cf.setEmail(cli.getEmail());
                cf.setName(cli.getName());
                cf.setSurname(cli.getSurname());
                cf.setOccupation(cli.getOccupation());
                cf.setTelephone(String.valueOf(cli.getTelephone()));
                cf.setUsername(cli.getUsername());
                cf.setPasswd(cli.getPassword());

                cf.setVisible(true);
                cf.pack();
                cf.setSize(700,500);
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        VISUALIZZAACQUISTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaspesauser c=new listaspesauser();
                c.setVisible(true);
                c.pack();
                c.setLocationRelativeTo(null);
                c.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
    }


}
