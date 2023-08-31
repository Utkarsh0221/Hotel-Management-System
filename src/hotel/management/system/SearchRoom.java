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

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton btnNewButton,submit;
    JLabel lblAvailability, lblCleanStatus, lblNewLabel, lblNewLabel_1, lblId, l1, searchroom, lblbed;
    JComboBox bedtype;
    JCheckBox checkRoom;

    SearchRoom() {

        setBounds(450, 200, 800, 600);

        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        l1 = new JLabel(i2);
//        l1.setBounds(550, 0, 600, 600);
//        add(l1);
        searchroom = new JLabel("Search For Room");
        searchroom.setBounds(285, 25, 250, 30);
        searchroom.setFont(new Font("Yu Mincho", Font.BOLD, 18));
        add(searchroom);

        lblbed = new JLabel("BedType");
        lblbed.setBounds(60, 65, 100, 20);
        lblbed.setFont(new Font("Yu Mincho", Font.BOLD, 15));
        add(lblbed);

        bedtype = new JComboBox(new String[]{"Single Bed", "Double Bed"});
        bedtype.setBounds(175, 65, 120, 20);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);

        checkRoom = new JCheckBox("Only display Available");
        checkRoom.setBounds(440, 65, 200, 20);
        checkRoom.setBackground(Color.WHITE);
        add(checkRoom);

        table = new JTable();
        table.setBounds(0, 200, 800, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }

//        JButton btnLoadData = new JButton("Load Data");
//
//        btnLoadData.setBounds(100, 470, 120, 30);
//        btnLoadData.setBackground(Color.BLACK);
//        btnLoadData.setForeground(Color.WHITE);
//        add(btnLoadData);
        btnNewButton = new JButton("Back");

        btnNewButton.setBounds(250, 505, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        add(btnNewButton);
        
        submit = new JButton("Submit");

        submit.setBounds(390, 503, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(160, 180, 73, 14);
        lblAvailability.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblAvailability);

        lblCleanStatus = new JLabel("Clean Status");
        lblCleanStatus.setBounds(320, 180, 82, 14);
        lblCleanStatus.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblCleanStatus);

        lblNewLabel = new JLabel("Price");
        lblNewLabel.setBounds(480, 180, 46, 14);
        lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Bed Type");
        lblNewLabel_1.setBounds(640, 180, 76, 14);
        lblNewLabel_1.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblNewLabel_1);

        lblId = new JLabel("Room Number");
        lblId.setBounds(5, 180, 94, 14);
        lblId.setFont(new Font("Yu Mincho", Font.BOLD, 13));
        add(lblId);

        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        
        if(a.getSource()==submit){
            try {
                
                String q1="Select * from room where bed_type='"+bedtype.getSelectedItem()+"'";
                String q2="Select * from room where availability = 'available' AND bed_type='"+bedtype.getSelectedItem()+"'";
                Conn c= new Conn();
                ResultSet rs;
                if(checkRoom.isSelected()){
                    rs=c.s.executeQuery(q2);
                }else{
                    rs= c.s.executeQuery(q1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }

}
