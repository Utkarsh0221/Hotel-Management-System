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

public class UpdateCheck extends JFrame implements ActionListener {

    JTextField tfroom, tfname, tfdate, tfdeposit, tfpayment;
    Choice c1;
    JButton back, update, check;

    UpdateCheck() {
        setBounds(400, 300, 1000, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        JLabel lblUpdateCheckStatus = new JLabel("Update Status");
        lblUpdateCheckStatus.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblUpdateCheckStatus.setBounds(124, 11, 222, 25);
        add(lblUpdateCheckStatus);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(450, 70, 476, 270);
        add(l1);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setBounds(25, 88, 46, 16);
        lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 13));
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
        lblNewLabel_1.setBounds(25, 129, 107, 16);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_1);

        tfroom = new JTextField();
        tfroom.setBounds(248, 129, 140, 20);
        add(tfroom);

        JLabel lblNewLabel_2 = new JLabel("Name  ");
        lblNewLabel_2.setBounds(25, 174, 97, 16);
        lblNewLabel_2.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Checked-in ");
        lblNewLabel_3.setBounds(25, 216, 107, 16);
        lblNewLabel_3.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Amount Paid   ");
        lblNewLabel_4.setBounds(25, 261, 107, 16);
        lblNewLabel_4.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Pending Amount ");
        lblNewLabel_5.setBounds(25, 302, 150, 16);
        lblNewLabel_5.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_5);

        tfname = new JTextField();
        tfname.setBounds(248, 174, 140, 20);
        add(tfname);
        tfname.setColumns(10);

        tfdate = new JTextField();
        tfdate.setBounds(248, 216, 140, 20);
        add(tfdate);
        tfdate.setColumns(10);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(248, 261, 140, 20);
        add(tfdeposit);
        tfdeposit.setColumns(10);

        tfpayment = new JTextField();
        tfpayment.setBounds(248, 302, 140, 20);
        add(tfpayment);
        tfpayment.setColumns(10);

        check = new JButton("Check");
        check.setBounds(100, 400, 80, 25);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        back = new JButton("Back");
        back.setBounds(250, 400, 80, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        update = new JButton("Update");
        update.setBounds(400, 400, 80, 25);
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
                    tfname.setText(rs.getString("name"));
                    tfdate.setText(rs.getString("Checkintime"));
                    tfdeposit.setText(rs.getString("deposit"));
                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfdeposit.getText());
                     tfpayment.setText(""+amountpaid);
                }

            } catch (Exception a) {
                a.printStackTrace();
            }
        } else if (e.getSource() == update) {
          
            String number=c1.getSelectedItem();
            String name=tfname.getText();
            String room= tfroom.getText();
            String checkintime=tfdate.getText();
            String deposit=tfdeposit.getText();
            
            try {
                Conn c=new Conn();
                c.s.executeUpdate("update customer set room='"+room+"',name='"+name+"', checkintime='"+checkintime+"', deposit='"+deposit+"' where number ='"+number+"'");
                
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
        new UpdateCheck();
    }
}
