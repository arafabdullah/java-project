package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaymentSystem extends JFrame implements ActionListener {
    JLabel msglbl;
    JButton backbtn, paymentBtn;  
    JPanel panel;
	Font myFont;

    public PaymentSystem(double totalAmount) {
        super("Payment System");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        
        myFont=new Font("Arial", Font.BOLD, 18);
		
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);

        msglbl = new JLabel("Total amount to be paid: " + String.format("%.2f", totalAmount)+"TK");
        msglbl.setBounds(100, 100, 400, 50);
        msglbl.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(msglbl);

        
        backbtn = new JButton("Back");
        backbtn.setBounds(100, 250, 180, 50);
		backbtn.setBackground(Color.WHITE);
		backbtn.setForeground(Color.BLACK);
        backbtn.setFont(myFont);
        backbtn.addActionListener(this);
        panel.add(backbtn);


        paymentBtn = new JButton("Make Payment");
        paymentBtn.setBounds(320, 250, 180, 50);
        paymentBtn.setBackground(Color.BLUE);
        paymentBtn.setForeground(Color.WHITE);
        paymentBtn.setFont(myFont);
        paymentBtn.addActionListener(this);
        panel.add(paymentBtn);


        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            Products products = new Products();
            products.setVisible(true);
        } else if (ae.getSource() == paymentBtn) {
            JOptionPane.showMessageDialog(this, "Payment successful! Thank you for your order.", "Success", JOptionPane.INFORMATION_MESSAGE);
            Products products = new Products();
            products.setVisible(true);
        }
    }
}