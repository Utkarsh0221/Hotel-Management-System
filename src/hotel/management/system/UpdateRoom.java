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

public class UpdateRoom extends JFrame implements ActionListener {

    JTextField tfroom, tfavailability, tfstatus, tfdeposit, tfpayment;
    Choice c1;
    JButton back, update, check;

    UpdateRoom() {
        setBounds(400, 300, 1000, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        JLabel lblUpdateCheckStatus = new JLabel("Update Room Status");
        lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.BOLD, 23));
        lblUpdateCheckStatus.setBounds(118, 11, 250, 25);
        add(lblUpdateCheckStatus);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(550, 250, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l2 = new JLabel(i2);
        //JLabel l2 = new JLabel(i2);
        l2.setBounds(450, 70, 500, 280);
        add(l2);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(25, 88, 46, 18);
        lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblNewLabel);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }
        } catch (Exception e) {
        }
        c1.setBounds(248, 88, 140, 20);
        add(c1);

        JLabel lblNewLabel_1 = new JLabel("Room Number ");
        lblNewLabel_1.setBounds(25, 135, 107, 18);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblNewLabel_1);

        tfroom = new JTextField();
        tfroom.setBounds(248, 135, 140, 20);
        add(tfroom);

        JLabel lblNewLabel_2 = new JLabel("Availability ");
        lblNewLabel_2.setBounds(25, 182, 97, 18);
        lblNewLabel_2.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblNewLabel_2);

        tfavailability = new JTextField();
        tfavailability.setBounds(248, 182, 140, 20);
        add(tfavailability);
        //tfavailability.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Cleaning Status");
        lblNewLabel_3.setBounds(25, 229, 115, 22);
        lblNewLabel_3.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblNewLabel_3);

        tfstatus = new JTextField();
        tfstatus.setBounds(248, 229, 140, 20);
        add(tfstatus);
        //tfstatus.setColumns(10);

//        JLabel lblNewLabel_4 = new JLabel("Amount Paid   ");
//        lblNewLabel_4.setBounds(25, 261, 107, 16);
//        lblNewLabel_4.setFont(new Font("Yu Mincho", Font.BOLD, 13));
//        add(lblNewLabel_4);
//
//        tfdeposit = new JTextField();
//        tfdeposit.setBounds(248, 261, 140, 20);
//        add(tfdeposit);
//        tfdeposit.setColumns(10);
//
//        JLabel lblNewLabel_5 = new JLabel("Pending Amount ");
//        lblNewLabel_5.setBounds(25, 302, 150, 16);
//        lblNewLabel_5.setFont(new Font("Yu Mincho", Font.BOLD, 13));
//        add(lblNewLabel_5);
//
//        tfpayment = new JTextField();
//        tfpayment.setBounds(248, 302, 140, 20);
//        add(tfpayment);
//        tfpayment.setColumns(10);
        check = new JButton("Check");
        check.setBounds(70, 330, 80, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        back = new JButton("Back");
        back.setBounds(190, 330, 80, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        update = new JButton("Update");
        update.setBounds(310, 330, 80, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            String id = c1.getSelectedItem();
            String q1 = "select * from customer where number ='" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(q1);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));

                }
                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber='" + tfroom.getText() + "'");
                while (rs2.next()) {
                  
                    tfavailability.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                }
            

            } catch (Exception a) {
                a.printStackTrace();
            }
        } else if (e.getSource() == update) {

            String number = c1.getSelectedItem();
           
            String room = tfroom.getText();
            String available = tfavailability.getText();
            String status = tfstatus.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability='" + available + "',cleaning_status='" + status + "' where roomnumber = '"+room+"'");

                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception ae) {
                ae.printStackTrace();
            }

        } else {
            setVisible(false);
            new Reception();

        }
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
