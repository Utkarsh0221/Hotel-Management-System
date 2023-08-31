
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener{
    
      JComboBox comboBox, cbgender, comboBox_3,comboBox_1;
    JButton b1, b2;
    JTextField tfname, tfcar,tfage,tfmodel,t5;

    AddDriver() {
        setBounds(450, 200, 1100, 500);
        setLayout(null);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(500, 30, 500, 370);
        add(l15);

        JLabel l10 = new JLabel("Add Driver");
        l10.setFont(new Font("Tahoma", Font.BOLD, 18));
        l10.setBounds(194, 10, 120, 22);
        add(l10);

        JLabel l1 = new JLabel("NAME");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setBounds(65, 70, 120, 25);
        add(l1);

        tfname = new JTextField();
        tfname.setBounds(220, 70, 165, 25);
        add(tfname);

        JLabel l2 = new JLabel("AGE");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setBounds(65, 115, 120, 25);
        add(l2);

         tfage = new JTextField();
        tfage.setBounds(220, 115, 165, 25);
        add(tfage);

        JLabel l3 = new JLabel("GENDER");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(64, 160, 120, 22);
        add(l3);

        cbgender = new JComboBox(new String[]{"MALE", "FEMALE"});
        cbgender.setBounds(220, 160, 165, 25);
        //comboBox_2.setForeground(Color.WHITE);
        cbgender.setBackground(Color.WHITE);
        add(cbgender);

        JLabel l4 = new JLabel("CAR COMPANY");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setBounds(64, 205, 120, 22);
        add(l4);

        tfcar = new JTextField();
        tfcar.setBounds(220, 205, 165, 25);
        add(tfcar);

        JLabel l5 = new JLabel("MODEL");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setBounds(64, 250, 102, 22);
        add(l5);

       tfmodel = new JTextField();
        tfmodel.setBounds(220, 250, 165, 25);
        add(tfmodel);
        
         JLabel l6 = new JLabel("AVAILABLE");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
	l6.setBounds(64, 295, 102, 22);
	add(l6);


        comboBox_1 = new JComboBox(new String[] { "Available", "Busy" });
	comboBox_1.setBounds(220, 295, 165, 25);
        comboBox_1.setBackground(Color.WHITE);
	add(comboBox_1);

        
        JLabel l7 = new JLabel("LOCATION");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
	l7.setBounds(64, 335, 102, 22);
	add(l7);


        t5 = new JTextField();
	t5.setBounds(220, 335, 165, 25);
        add(t5);
        

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 18));
        add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 380, 111, 33);
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
                String name = tfname.getText();
                String age = tfage.getText();
                String gender = (String)cbgender.getSelectedItem();
                String company  = tfcar.getText();
                String brand = tfmodel.getText();
                String available = (String)comboBox_1.getSelectedItem();
                String location = t5.getText();
                String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";

                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                setVisible(false);

            } catch (Exception ee) {
                System.out.println(ee);
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
