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

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox cbid;
    JTextField tfidno, tfname, tfdeposit, t5, t6;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    JButton Add, cancel;
    JLabel tfdate;

    NewCustomer() {

        JLabel lblName = new JLabel("NEW CUSTOMER FORM");
        lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblName.setBounds(118, 11, 260, 53);
        add(lblName);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i3 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(480, 10, 300, 500);
        add(l1);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 76, 200, 20);
        lblId.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblId);

        cbid = new JComboBox(new String[]{"Passport", "Aadhar Card", "Voter Id", "Driving license", "Ration Card"});
        cbid.setBounds(240, 76, 150, 20);
        cbid.setBackground(Color.WHITE);
        add(cbid);

        JLabel l2 = new JLabel("Number :");
        l2.setBounds(35, 111, 200, 16);
        l2.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(l2);

        tfidno = new JTextField();
        tfidno.setBounds(240, 111, 150, 20);
        add(tfidno);
        tfidno.setColumns(10);

        JLabel lblName_1 = new JLabel("Name :");
        lblName_1.setBounds(35, 151, 200, 20);
        lblName_1.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblName_1);

        tfname = new JTextField();
        tfname.setBounds(240, 151, 150, 20);
        add(tfname);
        tfname.setColumns(10);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 20);
        lblGender.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblGender);

        rbmale = new JRadioButton("Male");
        rbmale.setFont(new Font("Raleway", Font.ROMAN_BASELINE, 16));
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(240, 191, 65, 16);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setFont(new Font("Raleway", Font.ROMAN_BASELINE, 16));
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setBounds(315, 191, 100, 16);
        add(rbfemale);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 20);
        lblCountry.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblCountry);

        JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
        lblReserveRoomNumber.setBounds(35, 274, 200, 20);
        lblReserveRoomNumber.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblReserveRoomNumber);

        croom = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room where availability='Available'");
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
        }
        croom.setBounds(240, 274, 150, 20);
        add(croom);
        JLabel lblCheckInStatus = new JLabel("Checked-In :");
        lblCheckInStatus.setBounds(35, 316, 200, 20);
        lblCheckInStatus.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblCheckInStatus);

        Date date = new Date();
        tfdate = new JLabel("" + date);
        tfdate.setBounds(240, 316, 155, 25);
        tfdate.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(tfdate);

        JLabel lblDeposite = new JLabel("Deposit :");
        lblDeposite.setBounds(35, 359, 200, 20);
        lblDeposite.setFont(new Font("Yu Mincho", Font.PLAIN, 16));
        add(lblDeposite);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(240, 359, 150, 20);

        add(tfdeposit);
        tfdeposit.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(240, 231, 150, 20);
        add(t6);
        t6.setColumns(10);

        Add = new JButton("ADD");
        Add.setBounds(40, 420, 120, 30);
        Add.setForeground(Color.WHITE);
        Add.setBackground(Color.BLACK);
        Add.addActionListener(this);
        Add.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        add(Add);

        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 420, 120, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Yu Mincho", Font.BOLD, 16));
        add(cancel);

        setBounds(530, 230, 800, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Add) {
            String id = (String) cbid.getSelectedItem();
            String idno = tfidno.getText();
            String name = tfname.getText();
            String gender = null;

            if (rbmale.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String room = croom.getSelectedItem();
            String time = tfdate.getText();
            String country = t6.getText(); 
            String deposit = tfdeposit.getText();
            try {
                String q1 = "insert into customer values('" + id + "','"+idno+"','"+name + "','" + gender + "','" + country + "','" + room + "','" + time+ "','" + deposit + "')";
                String q2="update room set availability = 'Occupied' where roomnumber ='"+room+"'";
                Conn c=new Conn();
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
               
                JOptionPane.showMessageDialog(null, "New Customer added successfully");
                setVisible(false);
                new Reception();
                
            } catch (Exception a) {
                a.printStackTrace();
            }

        } else if (e.getSource() == cancel) {
             setVisible(false);
             new Reception();
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }

}
