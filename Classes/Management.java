package Classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Management extends JFrame implements ActionListener {
    JLabel nameLabel, priceLabel;
    JTextField nameField, priceField;
    JButton updateBtn, removeBtn, backBtn;
    JPanel panel;

    public Management() {
        super("Product Management");
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        nameLabel = new JLabel("Product Name:");
        nameLabel.setBounds(50, 50, 150, 30);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(200, 50, 200, 30);
        panel.add(nameField);

        priceLabel = new JLabel("New Price (TK):");
        priceLabel.setBounds(50, 100, 150, 30);
        panel.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(200, 100, 200, 30);
        panel.add(priceField);

        updateBtn = new JButton("Update Product");
        updateBtn.setBounds(50, 180, 150, 40);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        removeBtn = new JButton("Remove Product");
        removeBtn.setBounds(220, 180, 150, 40);
        removeBtn.addActionListener(this);
        panel.add(removeBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(150, 240, 100, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        this.add(panel);
    }

    private void updateProduct() {
        String name = nameField.getText();
        String priceText = priceField.getText();

        if (name.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both a name and a new price.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            // Here you would add the logic to update the product in your data source
            JOptionPane.showMessageDialog(this, "Product " + name + " updated to price " + price + "TK.");
            // Example:
            // Products.updateProductData(name, price);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price. Please enter a number.");
        }
    }

    private void removeProduct() {
        String name = nameField.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a product name to remove.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove " + name + "?", "Confirm Removal", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Here you would add the logic to remove the product from your data source
            JOptionPane.showMessageDialog(this, "Product " + name + " removed successfully.");
            // Example:
            // Products.removeProductData(name);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == updateBtn) {
            updateProduct();
        } else if (ae.getSource() == removeBtn) {
            removeProduct();
        } else if (ae.getSource() == backBtn) {
            this.dispose();
            Frame f1 = new Frame();
            f1.setVisible(true);
        }
    }
}