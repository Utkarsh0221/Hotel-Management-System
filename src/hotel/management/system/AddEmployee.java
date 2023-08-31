package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname, tfphone, tfadhar, tfemail, tsalary, tfage;
    JButton submit,back;
    JComboBox cjjob;
    JRadioButton male, female;

    AddEmployee() {
        setLayout(null);
        setBounds(500, 300, 900, 520);
        getContentPane().setBackground(Color.WHITE);
        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 110, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(190, 30, 150, 30);
        add(tfname);

        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 110, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(age);

        tfage = new JTextField();
        tfage.setBounds(190, 80, 150, 30);
        add(tfage);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 130, 110, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(190, 130, 60, 30);
        male.setFont(new Font("Tahoma", Font.PLAIN, 14));
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("FEMALE");
        female.setBounds(250, 130, 90, 30);
        female.setFont(new Font("Tahoma", Font.PLAIN, 14));
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup bg= new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel job = new JLabel("JOB");
        job.setBounds(60, 180, 110, 30);
        job.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(job);
        String[] str = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cjjob = new JComboBox(str);
        cjjob.setBackground(Color.WHITE);
        cjjob.setBounds(190, 180, 150, 30);
        add(cjjob);

        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 230, 110, 30);
        salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(190, 230, 150, 30);
        add(tsalary);

        JLabel phone = new JLabel("PHONE NO");
        phone.setBounds(60, 280, 110, 30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(190, 280, 150, 30);
        add(tfphone);

        JLabel email = new JLabel("EMAIL");
        email.setBounds(60, 330, 110, 30);
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(190, 330, 150, 30);
        add(tfemail);

        JLabel adhaar = new JLabel("ADHAAR");
        adhaar.setBounds(60, 380, 110, 30);
        adhaar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(adhaar);

        tfadhar = new JTextField();
        tfadhar.setBounds(190, 380, 150, 30);
        add(tfadhar);

        submit = new JButton("Submit");
        submit.setBounds(150, 420, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        submit.addActionListener(this);
        back=new JButton("Back");
        back.setBounds(275, 420, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);
        back.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 550, 380);
        add(image);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tsalary.getText();
        String phone = tfphone.getText();
        String aadhar = tfadhar.getText();
        String email = tfemail.getText();
        String job=(String)cjjob.getSelectedItem();

        String gender = null;

        if (male.isSelected()) {
            gender = "male";

        } else if (female.isSelected()) {
            gender = "female";
        }
        try {
            Conn c=new Conn();
             String query = "insert into employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+phone+"', '"+salary+"','"+email+"', '"+aadhar+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Employee added successfully");
             setVisible(false);
        } catch (Exception a) {
            a.printStackTrace();
        }
        }else if(e.getSource()==back){
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
