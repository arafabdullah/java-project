package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Products extends JFrame implements ActionListener {

    public JPanel p1, p2, p3, p4;
    JLabel p1imglbl, p1namelbl, p1pricelbl, p1englbl, p1pwrlbl;
    JLabel p2imglbl, p2namelbl, p2pricelbl, p2englbl, p2pwrlbl;
    JLabel p3imglbl, p3namelbl, p3pricelbl, p3englbl, p3pwrlbl;
    JLabel p4imglbl, p4namelbl, p4pricelbl, p4englbl, p4pwrlbl;

    JButton backbtn, p1cartbtn, p2cartbtn, p3cartbtn, p4cartbtn;

    JPanel panel;
    Font font2;
    ImageIcon p1img, p2img, p3img, p4img;

    private static CartItem[] cartItems = new CartItem[4];
    private static int cartSize = 0;

    public Product bike1 = new Product("R15 V4", 370000.00);
    public Product bike2 = new Product("Honda CBR 150R", 390000.00);
    public Product bike3 = new Product("Suzuki GSXR 150", 420000.00);
    public Product bike4 = new Product("Royal Enfield Bullet350", 450000.00);

    public Products() {
        super("PRODUCTS");
        this.setSize(1010,550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        writeProductsToFile();

        font2 = new Font("Arial", Font.BOLD, 18);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.RED);

        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(20, 50, 220, 400);
        p1.setBackground(Color.WHITE);
        panel.add(p1);

        p1namelbl = new JLabel(" R15 V4");
        p1namelbl.setBounds(10, 170, 180, 20);
        p1namelbl.setFont(font2);
        p1.add(p1namelbl);

        p1pricelbl = new JLabel("PRICE: 370000TK");
        p1pricelbl.setBounds(10, 210, 180, 20);
        p1pricelbl.setFont(font2);
        p1.add(p1pricelbl);
        
        p1englbl = new JLabel("Engine: 155 CC ");
        p1englbl.setBounds(10, 250, 180, 20);
        p1englbl.setFont(font2);
        p1.add(p1englbl);
        
        p1pwrlbl = new JLabel("Power: 18.4 PS");
        p1pwrlbl.setBounds(10, 290, 180, 20);
        p1pwrlbl.setFont(font2);
        p1.add(p1pwrlbl);
        
        p1cartbtn = new JButton("Add to Cart");
        p1cartbtn.setBounds(10, 350, 180, 30);
        p1cartbtn.setBackground(Color.BLUE);
        p1cartbtn.setForeground(Color.WHITE);
        p1cartbtn.addActionListener(this);
        p1.add(p1cartbtn);

        p1img = new ImageIcon("./Images/bike1.jpg");
        p1imglbl = new JLabel(p1img);
        p1imglbl.setBounds(5, 10, 200, 150);
        p1.add(p1imglbl);

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(260, 50, 220,400);
        p2.setBackground(Color.WHITE);
        panel.add(p2);

        p2img = new ImageIcon("./Images/bike2.png");
        p2imglbl = new JLabel(p2img);
        p2imglbl.setBounds(5, 10, 200, 150);
        p2.add(p2imglbl);

        p2namelbl = new JLabel(" Honda CBR 150R ");
        p2namelbl.setBounds(10, 170, 180, 20);
        p2namelbl.setFont(font2);
        p2.add(p2namelbl);

        p2pricelbl = new JLabel("PRICE: 390000TK");
        p2pricelbl.setBounds(10, 210, 180, 20);
        p2pricelbl.setFont(font2);
        p2.add(p2pricelbl);
        
        p2englbl = new JLabel(" Engine: 149 CC ");
        p2englbl.setBounds(10, 250, 180, 20);
        p2englbl.setFont(font2);
        p2.add(p2englbl);
        
        p2pwrlbl = new JLabel(" Power: 17.1 PS");
        p2pwrlbl.setBounds(10, 290, 180, 20);
        p2pwrlbl.setFont(font2);
        p2.add(p2pwrlbl);
        
        p2cartbtn = new JButton("Add to Cart");
        p2cartbtn.setBounds(10, 350, 180, 30);
        p2cartbtn.setBackground(Color.BLUE);
        p2cartbtn.setForeground(Color.WHITE);
        p2cartbtn.addActionListener(this);
        p2.add(p2cartbtn);

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(500, 50, 220,400);
        p3.setBackground(Color.WHITE);
        panel.add(p3);

        p3img = new ImageIcon("./Images/bike3.jpg");
        p3imglbl = new JLabel(p3img);
        p3imglbl.setBounds(5, 10, 200, 150);
        p3.add(p3imglbl);

        p3namelbl = new JLabel(" Suzuki GSXR 150");
        p3namelbl.setBounds(10, 170, 180, 20);
        p3namelbl.setFont(font2);
        p3.add(p3namelbl);

        p3pricelbl = new JLabel("PRICE: 420000TK");
        p3pricelbl.setBounds(10, 210, 180, 20);
        p3pricelbl.setFont(font2);
        p3.add(p3pricelbl);
        
        p3englbl = new JLabel(" Engine: 147.3 CC ");
        p3englbl.setBounds(10, 250, 180, 20);
        p3englbl.setFont(font2);
        p3.add(p3englbl);
        
        p3pwrlbl = new JLabel(" Power: 19.3 PS");
        p3pwrlbl.setBounds(10, 290, 180, 20);
        p3pwrlbl.setFont(font2);
        p3.add(p3pwrlbl);
        
        p3cartbtn = new JButton("Add to Cart");
        p3cartbtn.setBounds(10, 350, 180, 30);
        p3cartbtn.setBackground(Color.BLUE);
        p3cartbtn.setForeground(Color.WHITE);
        p3cartbtn.addActionListener(this);
        p3.add(p3cartbtn);

       
        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(740, 50, 220,400);
        p4.setBackground(Color.WHITE);
        panel.add(p4);

        p4img = new ImageIcon("./Images/bike4.jpg");
        p4imglbl = new JLabel(p4img);
        p4imglbl.setBounds(5, 10, 200, 150);
        p4.add(p4imglbl);

        p4namelbl = new JLabel("Royal Enfield Bullet");
        p4namelbl.setBounds(10, 170, 180, 20);
        p4namelbl.setFont(font2);
        p4.add(p4namelbl);

        p4pricelbl = new JLabel("PRICE: 450000TK");
        p4pricelbl.setBounds(10, 210, 180, 20);
        p4pricelbl.setFont(font2);
        p4.add(p4pricelbl);
        
        p4englbl = new JLabel(" Engine: 349 CC ");
        p4englbl.setBounds(10, 250, 180, 20);
        p4englbl.setFont(font2);
        p4.add(p4englbl);
        
        p4pwrlbl = new JLabel("Power: 25.5 PS");
        p4pwrlbl.setBounds(10, 290, 180, 20);
        p4pwrlbl.setFont(font2);
        p4.add(p4pwrlbl);
        
        p4cartbtn = new JButton("Add to Cart");
        p4cartbtn.setBounds(10, 350, 180, 30);
        p4cartbtn.setBackground(Color.BLUE);
        p4cartbtn.setForeground(Color.WHITE);
        p4cartbtn.addActionListener(this);
        p4.add(p4cartbtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(915, 0, 80, 50);
        backbtn.setBackground(new Color(0, 19, 119));
        backbtn.setForeground(Color.WHITE);
        backbtn.setFont(font2);
        backbtn.addActionListener(this);
        panel.add(backbtn);

        this.add(panel);
    }

    public void updateProductVisibility(JPanel productPanel, boolean isVisible) {
        productPanel.setVisible(isVisible);
        this.panel.revalidate();
        this.panel.repaint();
    }
    
    public String getBike1Name() {
        return bike1.name;
    }
    
    public String getBike2Name() {
        return bike2.name;
    }

    public String getBike3Name() {
        return bike3.name;
    }

    public String getBike4Name() {
        return bike4.name;
    }
 
 
    private void addToCart(Product product) {
        for (int i = 0; i < cartSize; i++) {
            if (cartItems[i].product.name.equals(product.name)) {
                cartItems[i].quantity++;
                return;
            }
        }

        if (cartSize < cartItems.length) {
            cartItems[cartSize++] = new CartItem(product, 1);
        } else {
            System.out.println("Cart is full!");
        }
    }


    private void showCartView() {
        Cart cart = new Cart(this, cartItems, cartSize);
        cart.setVisible(true);
        this.setVisible(false);
    }

   
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backbtn) {
            
            Frame f1 = new Frame();
            f1.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == p1cartbtn) {
            addToCart(bike1);
            showCartView();
        } else if (ae.getSource() == p2cartbtn) {
            addToCart(bike2);
            showCartView();
        } else if (ae.getSource()== p3cartbtn) {
            addToCart(bike3);
            showCartView();
        } else if (ae.getSource() == p4cartbtn) {
            addToCart(bike4);
            showCartView();
        }
    }
	
    private void writeProductsToFile() {
        try {
            File productsFile = new File("./Datas/Products.txt");
            if (!productsFile.exists()) {
                FileWriter writer = new FileWriter(productsFile);
                writer.write(bike1.name + "\t" + bike1.price + "\n");
                writer.write(bike2.name + "\t" + bike2.price + "\n");
                writer.write(bike3.name + "\t" + bike3.price + "\n");
                writer.write(bike4.name + "\t" + bike4.price + "\n");
                writer.close();
            }
        } catch (IOException e) {
            System.err.println("Error writing products to file: " + e.getMessage());
        }
    }

    public static class Product {
        public String name;
        public double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    public static class CartItem {
        public Product product;
        public int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }
}