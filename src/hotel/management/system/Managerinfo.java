package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Managerinfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    JLabel name, age, gender, budget, department, mobileno, salary, email, aadhar;

    Managerinfo() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 1000, 600);

        //setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");

        back.setBounds(430, 450, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        name = new JLabel("Name");
        name.setBounds(3, 10, 100, 20);
        name.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(name);

        age = new JLabel("Age");
        age.setBounds(125, 10, 100, 20);
        age.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(age);

        gender = new JLabel("Gender");
        gender.setBounds(250, 10, 100, 20);
        gender.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(gender);


        department = new JLabel("Job");
        department.setBounds(375, 10, 100, 20);
        department.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(department);

        mobileno = new JLabel("Phone");
        mobileno.setBounds(500, 10, 100, 20);
        mobileno.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(mobileno);

        salary = new JLabel("Salary");
        salary.setBounds(625, 10, 100, 20);
        salary.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(salary);

        email = new JLabel("Email");
        email.setBounds(755, 10, 100, 20);
        email.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(email);

        aadhar = new JLabel("Aadhar");
        aadhar.setBounds(875, 10, 100, 20);
        aadhar.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(aadhar);

        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new Managerinfo();
    }

}

