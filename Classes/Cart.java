package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


    public class Cart extends JFrame implements ActionListener {
    JButton backbtn, buyNowBtn;
    JPanel buttonPanel, itemsPanel;
    Color c4, c5;
    Font font2,font3;
    JLabel totalPriceLabel;

    private Products productsFrame;
    private Products.CartItem[] cartItems;
    private int cartSize;

    public Cart(Products productsFrame, Products.CartItem[] cartItems, int cartSize) {
        super("CART");
        this.productsFrame = productsFrame;
        this.cartItems = cartItems;
        this.cartSize = cartSize;
        this.setSize(1010, 600);
        this.setLocationRelativeTo(null);
       
        
        c4 = new Color(186, 186, 186);
        c5 = new Color(0, 19, 119);
        font2 = new Font("Arial", Font.BOLD, 25);
		font3 = new Font("Arial", Font.BOLD, 16);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(c4);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        
        backbtn = new JButton("Back");
        backbtn.setPreferredSize(new Dimension(100, 50));
        backbtn.setBackground(c5);
        backbtn.setForeground(Color.WHITE);
        backbtn.setFont(font2);
        backbtn.addActionListener(this);
        buttonPanel.add(backbtn);

        buyNowBtn = new JButton("Buy Now");
        buyNowBtn.setPreferredSize(new Dimension(150, 50));
        buyNowBtn.setBackground(new Color(46, 139, 87));
        buyNowBtn.setForeground(Color.WHITE);
        buyNowBtn.setFont(font2);
        buyNowBtn.addActionListener(this);
        buttonPanel.add(buyNowBtn);

        this.add(buttonPanel, BorderLayout.NORTH);

        itemsPanel = new JPanel();
        itemsPanel.setBackground(c4);
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        double total = 0.0;

        for (int i = 0; i < cartSize; i++) {
            Products.CartItem item = cartItems[i];
            
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            itemPanel.setPreferredSize(new Dimension(900, 180));
            itemPanel.setBackground(Color.WHITE);
            itemPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel nameLabel = new JLabel("Name: " + item.product.name);
            JLabel priceLabel = new JLabel("Price: " + String.format("%.2f", item.product.price) + "TK");
            JLabel totalLabel = new JLabel("Total: " + String.format("%.2f", item.product.price * item.quantity) + "TK");

            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
            quantityPanel.setOpaque(false);

            JButton minusBtn = new JButton("-");
            minusBtn.setPreferredSize(new Dimension(50, 30));
			minusBtn.setFont(font3);
            JLabel quantityLabel = new JLabel(String.valueOf(item.quantity));
			quantityLabel.setFont(font3);
            JButton plusBtn = new JButton("+");
            plusBtn.setPreferredSize(new Dimension(50, 30));
			plusBtn.setFont(font3);
            
            quantityPanel.add(minusBtn);
            quantityPanel.add(quantityLabel);
            quantityPanel.add(plusBtn);

            itemPanel.add(Box.createVerticalStrut(5));
            itemPanel.add(nameLabel);
            itemPanel.add(Box.createVerticalStrut(5));
            itemPanel.add(priceLabel);
            itemPanel.add(Box.createVerticalStrut(5));
            itemPanel.add(totalLabel);
            itemPanel.add(Box.createVerticalStrut(10));
            itemPanel.add(new JLabel("Quantity:"));
            itemPanel.add(Box.createVerticalStrut(5));
            itemPanel.add(quantityPanel);
			itemPanel.setFont(font2);

            
            minusBtn.addActionListener(new QuantityButtonListener(item, quantityLabel, totalLabel, -1));
            plusBtn.addActionListener(new QuantityButtonListener(item, quantityLabel, totalLabel, 1));
            
            itemsPanel.add(itemPanel);
            itemsPanel.add(Box.createVerticalStrut(20));
            
            total += item.product.price * item.quantity;
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        this.add(scrollPane, BorderLayout.CENTER);

        
        JPanel totalPanel = new JPanel();
        totalPanel.setBackground(c4);
        totalPanel.setPreferredSize(new Dimension(900, 60));
        totalPanel.setLayout(new BorderLayout());

        totalPriceLabel = new JLabel("Cart Total Amount: " + String.format("%.2f", total) + "TK");
        totalPriceLabel.setFont(font2);
        totalPriceLabel.setForeground(c5);
        totalPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        totalPanel.add(totalPriceLabel, BorderLayout.CENTER);
        this.add(totalPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            productsFrame.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == buyNowBtn) {
            double total = calculateTotal();
            
            PaymentSystem paymentSystem = new PaymentSystem(total);
            paymentSystem.setVisible(true);
        }
    }
    
    private double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < cartSize; i++) {
            total += cartItems[i].product.price * cartItems[i].quantity;
        }
        return total;
    }
    
    private class QuantityButtonListener implements ActionListener {
        private Products.CartItem item;
        private JLabel quantityLabel;
        private JLabel totalLabel;
        private int change;

        public QuantityButtonListener(Products.CartItem item, JLabel quantityLabel, JLabel totalLabel, int change) {
            this.item = item;
            this.quantityLabel = quantityLabel;
            this.totalLabel = totalLabel;
            this.change = change;
        }
        
        public void actionPerformed(ActionEvent e) {
            int newQuantity = item.quantity + change;
            if (newQuantity >= 1) {
                item.quantity = newQuantity;
                quantityLabel.setText(String.valueOf(item.quantity));
                totalLabel.setText("Total: " + String.format("%.2f", item.product.price * item.quantity) + "TK");
                totalPriceLabel.setText("Cart Total Amount: " + String.format("%.2f", calculateTotal()) + "TK");
            }
        }
    }
}
