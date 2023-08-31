/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{

    public Dashboard() {
        setBounds(0, 0, 1920, 1025);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons2/hotel_img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 1025, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1920, 1025);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 48));
        text.setBounds(550, 60, 1000, 85);
        image.add(text);
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0, 0, 1920,35 );
        image.add(mb);
        
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        mb.add(hotel);
        hotel.setForeground(Color.BLUE);
        hotel.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,14));
        JMenuItem reception = new JMenuItem("RECEPTION");
	hotel.add(reception);
        reception.addActionListener(this);
        JMenu admin=new JMenu("ADMIN");
        mb.add(admin);
        admin.setForeground(Color.BLUE);
        admin.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,14));
        JMenuItem employee = new JMenuItem("ADD EMPLOYEE");
	admin.add(employee);
        employee.addActionListener(this);
        JMenuItem rooms = new JMenuItem("ADD ROOMS");
	admin.add(rooms);
        rooms.addActionListener(this);
        JMenuItem driver = new JMenuItem("ADD DRIVERS");
	admin.add(driver);
        driver.addActionListener(this);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals("ADD EMPLOYEE")){
          new AddEmployee();
      }else if(e.getActionCommand().equals("ADD ROOMS")){
          new AddRoom();
      }
      else if(e.getActionCommand().equals("ADD DRIVERS")){
          new AddDriver();
      }
      else if(e.getActionCommand().equals("RECEPTION")){
          new Reception();
    }
}

}
