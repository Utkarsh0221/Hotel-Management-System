
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    //JFrame j;
    
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    Login(){
        setBounds(650, 300, 600, 300);
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 130, 30);
        add(user);
        user.setFont(new Font("Serif",Font.ROMAN_BASELINE,20));
        
         username= new JTextField();
        username.setBounds(180, 20, 130, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 130, 30);
        add(pass);
        pass.setFont(new Font("Serif",Font.ROMAN_BASELINE,20));
        
         password= new JPasswordField();
        password.setBounds(180, 70, 130, 30);
        add(password);
        
        login=new JButton("Login");
        login.setBounds(50, 135, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Serif",Font.PLAIN,17));
        login.addActionListener(this);
        add(login);
        
         cancel=new JButton("cancel");
        cancel.setBounds(180, 135, 100, 30);
         cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Serif",Font.PLAIN,17));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        setVisible(true);
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==login){
           String user=username.getText();
           String pass=password.getText();
           try {
               Conn c=new Conn();
               String query="select * from login where username ='" + user + "' and password ='" + pass + "'";
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next()){
                   new Dashboard();
                   setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(null, "Invalid username or password");
                   setVisible(false);
               }
           } catch (Exception a) {
                a.printStackTrace();
           }
       }else if(e.getSource()==cancel){
           setVisible(false);
       }
    }
    
     public static void main(String [] args){
        new Login();
    }

}
