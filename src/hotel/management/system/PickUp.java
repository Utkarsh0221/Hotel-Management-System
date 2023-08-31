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

public class PickUp extends JFrame implements ActionListener {

    JTable table;
    JButton btnNewButton, submit;
    JLabel lblAvailability, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblId, l1, searchroom, lblbed;
    JComboBox bedtype;
    JCheckBox checkRoom;
    Choice typeofcar;

    PickUp() {

        setBounds(450, 200, 900, 600);

        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        l1 = new JLabel(i2);
//        l1.setBounds(550, 0, 600, 600);
//        add(l1);
        searchroom = new JLabel("Pick Up Service");
        searchroom.setBounds(285, 25, 250, 30);
        searchroom.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        add(searchroom);

        lblbed = new JLabel("Type of Car");
        lblbed.setBounds(60, 65, 100, 20);
        lblbed.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblbed);

        typeofcar = new Choice();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while (rs.next()) {
                typeofcar.add(rs.getString("brand"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        typeofcar.setBounds(180, 65, 150, 20);
        add(typeofcar);

        table = new JTable();
        table.setBounds(0, 200, 900, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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

        btnNewButton.setBounds(250, 505, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        add(btnNewButton);

        submit = new JButton("Submit");

        submit.setBounds(390, 505, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        lblId = new JLabel("Name");
        lblId.setBounds(5, 180, 94, 14);
        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblId);

        lblAvailability = new JLabel("Age");
        lblAvailability.setBounds(128, 180, 73, 14);
        lblAvailability.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblAvailability);

        lblCleanStatus = new JLabel("Gender");
        lblCleanStatus.setBounds(258, 180, 82, 14);
        lblCleanStatus.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblCleanStatus);

        lblNewLabel = new JLabel("Company");
        lblNewLabel.setBounds(388, 180, 76, 14);
        lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Model");
        lblNewLabel_1.setBounds(518, 180, 76, 14);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_1);

        lblNewLabel_1 = new JLabel("Availability");
        lblNewLabel_1.setBounds(641, 180, 76, 14);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_1);

        lblNewLabel_1 = new JLabel("Location");
        lblNewLabel_1.setBounds(770, 180, 76, 14);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_1);

        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent a) {

        if (a.getSource() == submit) {
            try {

                String q = "Select * from driver where brand='" + typeofcar.getSelectedItem() + "'";

                Conn c = new Conn();
                ResultSet rs;

                rs = c.s.executeQuery(q);

                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new PickUp();
    }

}
