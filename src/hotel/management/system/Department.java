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

public class Department extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    JLabel lblAvailability, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblId, l1;

    Department() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 700, 500);

        //setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        table = new JTable();
        table.setBounds(0, 40, 700, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");

        back.setBounds(290, 350, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        

        lblAvailability = new JLabel("Department");
        lblAvailability.setBounds(160, 10, 100, 20);
        lblAvailability.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblAvailability);

        lblCleanStatus = new JLabel("Budget");
        lblCleanStatus.setBounds(425, 10, 100, 20);
        lblCleanStatus.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblCleanStatus);

        

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
        new Department();
    }

}
