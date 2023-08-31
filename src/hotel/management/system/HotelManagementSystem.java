/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

/**
 *
 * @author SkyNet
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{

     HotelManagementSystem() {
         setSize(1400,800);
         setLocation(260, 100);
         
         
         //ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons2/hotel_img5.jpg"));
         Image i2 = i1.getImage().getScaledInstance(1400, 800, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         setLayout(null);
         image.setBounds(0, 0,1400,800);//1366,565
         add(image);
         
         JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
         text.setBounds(20, 700, 600, 30);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("serif",Font.TRUETYPE_FONT,35));
         image.add(text);
         
         JButton next=new JButton("Next");
         next.setBounds(1150, 680, 150, 50);
         next.setBackground(Color.WHITE);
         next.setForeground(Color.RED);
         next.setFont(new Font("serif",Font.BOLD,20));
         image.add(next);
         next.addActionListener(this);
         setVisible(true);
         while(true){
                        text.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        text.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
         
         
    }
     
     @Override
    public void actionPerformed(ActionEvent e) {
         setVisible(false);
       new Login();
    }
    
      public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
