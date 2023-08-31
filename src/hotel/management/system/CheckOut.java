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

public class CheckOut extends JFrame implements ActionListener {

    Choice c1;
    JLabel lbroomno, lbcheckintime, lbcheckouttime;
    JButton back, checkout;

    CheckOut() {
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("CheckOut");
        text.setBounds(350, 25, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lbid = new JLabel("Customer Id");
        lbid.setBounds(50, 70, 100, 20);
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbid);

        
        JLabel lbroom = new JLabel("Room No.");
        lbroom.setBounds(50, 110, 100, 20);
        lbroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbroom);

        lbroomno = new JLabel();
        lbroomno.setBounds(180, 110, 100, 20);
        lbroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbroomno);

        JLabel lbcheckin = new JLabel("CheckIn Time");
        lbcheckin.setBounds(50, 150, 100, 20);
        lbcheckin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbcheckin);

        lbcheckintime = new JLabel();
        lbcheckintime.setBounds(180, 150, 150, 20);
        lbcheckintime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbcheckintime);

        JLabel lbcheckout = new JLabel("CheckOut Time");
        lbcheckout.setBounds(50, 190, 150, 20);
        lbcheckout.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbcheckout);

        Date date = new Date();
        lbcheckouttime = new JLabel("" + date);
        lbcheckouttime.setBounds(180, 190, 150, 20);
        lbcheckouttime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbcheckouttime);

        back = new JButton("Back");
        back.setBounds(70, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        checkout = new JButton("CheckOut");
        checkout.setBounds(210, 300, 100, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
                lbroomno.setText(rs.getString("room"));
                lbcheckintime.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(180, 70, 140, 20);
        add(c1);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(475, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(360, 65, 475, 250);
        add(l1);

        setBounds(450, 300, 900, 400);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkout) {

            String q1 = "delete from customer where number ='" + c1.getSelectedItem() + "' ";
            String q2 = "update room set availability='available' where roomnumber ='" + lbroomno.getText() + "'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "checkOut Successfull");
                setVisible(false);
                new Reception();

            } catch (Exception a) {
                a.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
