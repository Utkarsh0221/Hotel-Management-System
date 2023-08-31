package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Reception extends JFrame implements ActionListener {

    JButton btnNewCustomerForm, btnNewButton, btnNewButton_1, btnNewButton_2, btnManagerInfo,btnNewButton_3,btnSearchRoom,btnNewButton_5,btnNewButton_6,btnPickUpSerice,btnNewButton_4,btnNewButton_7;

    Reception() {

        setBounds(530, 200, 900, 600);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(270, 30, 500, 470);
        add(l1);

        btnNewCustomerForm = new JButton("New Customer Form");
//		btnNewCustomerForm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try{
//				NewCustomer custom = new NewCustomer();
//				custom.setVisible(true);
//                                setVisible(false);
//			}catch(Exception e1){
//				e1.printStackTrace();
//			}
//			}
//		});
        btnNewCustomerForm.setBounds(10, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        btnNewCustomerForm.addActionListener(this);
        add(btnNewCustomerForm);

        btnNewButton = new JButton("Room");

        btnNewButton.setBounds(10, 70, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);

        add(btnNewButton);

        btnNewButton_1 = new JButton("Department");

        btnNewButton_1.setBounds(10, 110, 200, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.addActionListener(this);

        add(btnNewButton_1);

        btnNewButton_2 = new JButton("All Employee Info");

        btnNewButton_2.setBounds(10, 150, 200, 30);
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.addActionListener(this);

        add(btnNewButton_2);

        btnNewButton_3 = new JButton("Customer Info");

        btnNewButton_3.setBounds(10, 190, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);
        btnNewButton_3.addActionListener(this);
        add(btnNewButton_3);

        btnManagerInfo = new JButton("Manager Info");
        btnManagerInfo.setBounds(10, 230, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);
        btnManagerInfo.addActionListener(this);
        add(btnManagerInfo);

        btnNewButton_4 = new JButton("Check Out");

        btnNewButton_4.setBounds(10, 270, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);
        btnNewButton_4.addActionListener(this);

        add(btnNewButton_4);

        btnNewButton_5 = new JButton("Update Check Status");
//
        btnNewButton_5.setBounds(10, 310, 200, 30);
        btnNewButton_5.setBackground(Color.BLACK);
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.addActionListener(this);

        add(btnNewButton_5);

        btnNewButton_6 = new JButton("Update Room Status");
        btnNewButton_6.setBounds(10, 350, 200, 30);
        btnNewButton_6.setBackground(Color.BLACK);
        btnNewButton_6.setForeground(Color.WHITE);
        btnNewButton_6.addActionListener(this);

        add(btnNewButton_6);

        btnPickUpSerice = new JButton("Pick up Service");
        btnPickUpSerice.setBounds(10, 390, 200, 30);
        btnPickUpSerice.setBackground(Color.BLACK);
        btnPickUpSerice.setForeground(Color.WHITE);
        btnPickUpSerice.addActionListener(this);

        add(btnPickUpSerice);

        btnSearchRoom = new JButton("Search Room");

        btnSearchRoom.setBounds(10, 430, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
        btnSearchRoom.addActionListener(this);
        add(btnSearchRoom);

         btnNewButton_7 = new JButton("Log Out");

        btnNewButton_7.setBounds(10, 470, 200, 30);
        btnNewButton_7.setBackground(Color.BLACK);
        btnNewButton_7.setForeground(Color.WHITE);
        btnNewButton_7.addActionListener(this);
        add(btnNewButton_7);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewCustomerForm) {
            setVisible(false);
            new NewCustomer();
        } else if (e.getSource() == btnNewButton) {
            setVisible(false);
            new Room();
        } else if (e.getSource() == btnNewButton_1) {
            setVisible(false);
            new Department();
        } else if (e.getSource() == btnNewButton_2) {
            setVisible(false);
            new Employeeinfo();
        } else if (e.getSource() == btnManagerInfo) {
            setVisible(false);
            new Managerinfo();
        }
        else if(e.getSource()==btnNewButton_3){
            setVisible(false);
            new Customerinfo();
        }
        else if(e.getSource()==btnSearchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(e.getSource()==btnNewButton_5){
            setVisible(false);
            new UpdateCheck();
        }
        else if(e.getSource()==btnNewButton_6){
            setVisible(false);
            new UpdateRoom();
        }
        else if(e.getSource()==btnPickUpSerice){
            setVisible(false);
            new PickUp();
        }
        else if(e.getSource()==btnNewButton_4){
            setVisible(false);
            new CheckOut();
        }
        
        else if(e.getSource()==btnNewButton_7){
            setVisible(false);
        }
         
    }

    public static void main(String[] args) {
        new Reception();
    }
}
