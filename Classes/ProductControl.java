package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductControl extends JFrame implements ActionListener {
    JLabel nameLabel;
    JTextField nameTF;
    JButton setAvailabilityButton, backButton;
    JCheckBox availableCheckbox;
    JPanel panel;

    private Products productsFrame;

    public ProductControl(Products productsFrame) {
        super("Product Control");
        this.productsFrame = productsFrame;
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);


        nameLabel = new JLabel("Product Name:");
        nameLabel.setBounds(50, 40, 100, 25);
        panel.add(nameLabel);
        nameTF = new JTextField();
        nameTF.setBounds(160, 40, 180, 25);
        panel.add(nameTF);

        availableCheckbox = new JCheckBox("Available");
        availableCheckbox.setBounds(50, 80, 100, 25);
		availableCheckbox.setBackground(Color.RED);
		availableCheckbox.setForeground(Color.WHITE);
        availableCheckbox.setSelected(true);
        panel.add(availableCheckbox);

        setAvailabilityButton = new JButton("Set Availability");
        setAvailabilityButton.setBounds(160, 80, 120, 25);
		setAvailabilityButton.setBackground(Color.BLUE);
		setAvailabilityButton.setForeground(Color.WHITE);
        setAvailabilityButton.addActionListener(this);
        panel.add(setAvailabilityButton);
            
        backButton = new JButton("Back");
        backButton.setBounds(290, 80, 80, 25);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);

        this.add(panel);
    }

   public void actionPerformed(ActionEvent ae) {
    String command = ae.getActionCommand();

    if (command.equals("Set Availability")) {
        setProductAvailability();
    } else if (command.equals("Back")) {
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
    }
}
        
    private void setProductAvailability() {
        String productName = nameTF.getText().trim();
        boolean isAvailable = availableCheckbox.isSelected();
        JPanel productPanel = null;
        if (productName.equals(productsFrame.getBike1Name())) {
            productPanel = productsFrame.p1;
        } else if (productName.equals(productsFrame.getBike2Name())) {
            productPanel = productsFrame.p2;
        } else if (productName.equals(productsFrame.getBike3Name())) {
            productPanel = productsFrame.p3;
        } else if (productName.equals(productsFrame.getBike4Name())) {
            productPanel = productsFrame.p4;
        }

        if (productPanel != null) {
            productsFrame.updateProductVisibility(productPanel, isAvailable);
            JOptionPane.showMessageDialog(this, "Product visibility updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Product not found or invalid name.");
        }
    }
}