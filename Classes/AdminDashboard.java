package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {
    JButton backbtn, productbtn,userbtn; 
    JPanel panel;
	Font myFont;

    public AdminDashboard() {
        super("Admin Control");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
		
		myFont=new Font("Arial", Font.BOLD, 18);
     

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        userbtn = new JButton("UserData");
        userbtn.setBounds(100, 150, 180, 50);
		userbtn.setBackground(Color.RED);
		userbtn.setForeground(Color.WHITE);
        userbtn.setFont(myFont);
        userbtn.addActionListener(this);
        panel.add(userbtn);


        productbtn = new JButton("Product");
        productbtn.setBounds(320, 150, 180, 50);
        productbtn.setBackground(Color.BLUE);
        productbtn.setForeground(Color.WHITE);
        productbtn.setFont(myFont);
        productbtn.addActionListener(this);
        panel.add(productbtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(200, 230, 180, 50);
		backbtn.setBackground(Color.BLACK);
		backbtn.setForeground(Color.WHITE);
        backbtn.setFont(myFont);
        backbtn.addActionListener(this);
        panel.add(backbtn);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            Admin a1 = new Admin();
            a1.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == productbtn) {
            Products productFrame = new Products();
            ProductControl pc = new ProductControl(productFrame);
            pc.setVisible(true);
            this.dispose();
        }
        else if(ae.getSource() == userbtn) {
            UserControl uc = new UserControl();
            uc.setVisible(true);
            this.dispose();
        }
    }
}
