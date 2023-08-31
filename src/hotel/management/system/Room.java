package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener {

    JTable table;
    JButton btnNewButton;
    JLabel lblAvailability, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblId, l1;

    Room() {

        setBounds(450, 200, 1100, 600);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
        l1.setBounds(550, 0, 600, 600);
        add(l1);

        table = new JTable();
        table.setBounds(0, 40, 550, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }

//        JButton btnLoadData = new JButton("Load Data");
//
//        btnLoadData.setBounds(100, 470, 120, 30);
//        btnLoadData.setBackground(Color.BLACK);
//        btnLoadData.setForeground(Color.WHITE);
//        add(btnLoadData);

        btnNewButton = new JButton("Back");

        btnNewButton.setBounds(225, 470, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        add(btnNewButton);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(110, 15, 73, 14);
        lblAvailability.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(218, 15, 82, 14);
        lblCleanStatus.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblCleanStatus);

        lblNewLabel = new JLabel("Price");
        lblNewLabel.setBounds(330, 15, 46, 14);
        lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Bed Type");
        lblNewLabel_1.setBounds(440, 15, 76, 14);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_1);

        lblId = new JLabel("Room Number");
        lblId.setBounds(5, 15, 94, 14);
        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblId);

        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == btnNewButton) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Room();
    }

}
