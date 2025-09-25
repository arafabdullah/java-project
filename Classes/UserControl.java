package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class UserControl extends JFrame implements ActionListener {
    JLabel userLabel, passLabel, numberLabel, ageLabel, addressLabel;
    JTextField userTF, passTF, numberTF, ageTF, addressTF;
    JButton searchButton, updateButton, deleteButton, backButton;
    JPanel panel;

    public UserControl() {
        super("User Control");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 80, 25);
        panel.add(userLabel);
        userTF = new JTextField();
        userTF.setBounds(140, 30, 180, 25);
        panel.add(userTF);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 70, 80, 25);
        panel.add(passLabel);
        passTF = new JTextField();
        passTF.setBounds(140, 70, 180, 25);
        panel.add(passTF);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(140, 110, 80, 25);
		searchButton.setBackground(Color.GREEN);
		searchButton.setForeground(Color.BLACK);
        searchButton.addActionListener(this);
        panel.add(searchButton);

        numberLabel = new JLabel("Number:");
        numberLabel.setBounds(50, 150, 80, 25);
        panel.add(numberLabel);
        numberTF = new JTextField();
        numberTF.setBounds(140, 150, 180, 25);
        panel.add(numberTF);

        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 190, 80, 25);
        panel.add(ageLabel);
        ageTF = new JTextField();
        ageTF.setBounds(140, 190, 180, 25);
        panel.add(ageTF);

        addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 230, 80, 25);
        panel.add(addressLabel);
        addressTF = new JTextField();
        addressTF.setBounds(140, 230, 180, 25);
        panel.add(addressTF);

        updateButton = new JButton("Update");
        updateButton.setBounds(50, 280, 90, 30);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        panel.add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(150, 280, 90, 30);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(this);
        panel.add(deleteButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(250, 280, 90, 30);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("Search")) {
            searchUser();
        } else if (command.equals("Update")) {
            updateUser();
        } else if (command.equals("Delete")) {
            deleteUser();
        } else if (command.equals("Back")) {
            AdminDashboard ad = new AdminDashboard();
            ad.setVisible(true);
            this.dispose();
        }
    }
    
    private void searchUser() {
        String username = userTF.getText();
        String password = passTF.getText();
        
        try {
            File file = new File("./Datas/Data.txt");
            Scanner sc = new Scanner(file);
            boolean found = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] values = line.split("\t");
                if (values.length >= 5 && values[0].equals(username) && values[4].equals(password)) {
                    numberTF.setText(values[1]);
                    ageTF.setText(values[2]);
                    addressTF.setText(values[3]);
                    found = true;
                    break;
                }
            }
            sc.close();
            if (!found) {
                JOptionPane.showMessageDialog(this, "User not found.");
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, "Error reading file.");
        }
    }
    
    private void updateUser() {
        String oldUsername = userTF.getText();
        String oldPassword = passTF.getText();
        String newNumber = numberTF.getText();
        String newAge = ageTF.getText();
        String newAddress = addressTF.getText();

        try {
            File inputFile = new File("./Datas/Data.txt");
            File tempFile = new File("./Datas/temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean updated = false;

            while ((currentLine = reader.readLine()) != null) {
                String[] values = currentLine.trim().split("\t");
                if (values.length >= 5 && values[0].equals(oldUsername) && values[4].equals(oldPassword)) {
                    writer.write(oldUsername + "\t" + newNumber + "\t" + newAge + "\t" + newAddress + "\t" + oldPassword + System.getProperty("line.separator"));
                    updated = true;
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (updated) {
                JOptionPane.showMessageDialog(this, "User information updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "User not found for update.");
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, "Error updating user data.");
        }
    }
    
    private void deleteUser() {
        String username = userTF.getText();
        String password = passTF.getText();

        try {
            File inputFile = new File("./Datas/Data.txt");
            File tempFile = new File("./Datas/temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean deleted = false;

            while ((currentLine = reader.readLine()) != null) {
                String[] values = currentLine.trim().split("\t");
                if (values.length >= 5 && values[0].equals(username) && values[4].equals(password)) {
                    deleted = true;
                    continue; 
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (deleted) {
                JOptionPane.showMessageDialog(this, "User deleted successfully.");
                userTF.setText("");
                passTF.setText("");
                numberTF.setText("");
                ageTF.setText("");
                addressTF.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "User not found for deletion.");
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, "Error deleting user data.");
        }
    }
}
