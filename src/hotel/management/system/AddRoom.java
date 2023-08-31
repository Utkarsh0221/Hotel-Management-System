package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class AddRoom extends JFrame implements ActionListener {

    JComboBox comboBox, comboBox_2, comboBox_3;
    JButton b1, b2;
    JTextField tfroomno, t2;

    AddRoom() {
        setBounds(450, 200, 1100, 500);
        setLayout(null);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(500, 30, 500, 370);
        add(l15);

        JLabel l10 = new JLabel("Add Rooms");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(194, 10, 120, 22);
        add(l10);

        JLabel l1 = new JLabel("Room Number");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(65, 70, 120, 25);
        add(l1);

        tfroomno = new JTextField();
        tfroomno.setBounds(190, 70, 165, 25);
        add(tfroomno);

        JLabel l2 = new JLabel("Availability");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(65, 115, 120, 25);
        add(l2);

        comboBox = new JComboBox(new String[]{"Available", "Occupied"});
        comboBox.setBounds(190, 115, 165, 25);
        //comboBox.setForeground(Color.WHITE); 
        comboBox.setBackground(Color.WHITE);
        add(comboBox);

        JLabel l3 = new JLabel("Cleaning Status");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(64, 160, 120, 22);
        add(l3);

        comboBox_2 = new JComboBox(new String[]{"Cleaned", "Dirty"});
        comboBox_2.setBounds(190, 160, 165, 25);
        //comboBox_2.setForeground(Color.WHITE);
        comboBox_2.setBackground(Color.WHITE);
        add(comboBox_2);

        JLabel l4 = new JLabel("Price");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(64, 205, 102, 22);
        add(l4);

        t2 = new JTextField();
        t2.setBounds(190, 205, 165, 25);
        add(t2);

        JLabel l5 = new JLabel("Bed Type");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(64, 250, 102, 22);
        add(l5);

        comboBox_3 = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        comboBox_3.setBounds(190, 250, 165, 25);
        //comboBox_3.setForeground(Color.WHITE);
        comboBox_3.setBackground(Color.WHITE);
        add(comboBox_3);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 321, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 321, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
        add(b2);

        setBackground(Color.WHITE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
            try {
                Conn c = new Conn();
                String room = tfroomno.getText();
                String available = (String) comboBox.getSelectedItem();
                String status = (String) comboBox_2.getSelectedItem();
                String price = t2.getText();
                String type = (String) comboBox_3.getSelectedItem();
                String str = "INSERT INTO room values( '" + room + "', '" + available + "', '" + status + "','" + price + "', '" + type + "')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Room Successfully Added");
                setVisible(false);

            } catch (Exception ee) {
                System.out.println(ee);
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
