package it.view;

import it.model.user;
import it.util.Session;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class userprofile {
    private JLabel client;
    private JButton VISUALIZZAACQUISTIButton;
    private JButton MODIFICADATIPERSONALIButton;

    public userprofile() {
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
                cf.setLocationRelativeTo(null);
                cf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });
        VISUALIZZAACQUISTIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaspesauser c=new listaspesauser();
            }
        });
    }
}
