package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registration extends JFrame implements ActionListener

{
	JLabel userlbl,phnlbl,agelbl,adrslbl,passlbl,imglbl;
	JTextField userfld,phnfld,agefld,adrsfld;
	JPasswordField passfld;
	JButton rgstsbtn, backbtn;
	JPanel panel;
	Color c1,c2,c3,c4,c5;
	Font myFont;
	Frame f1;
	ImageIcon img;
	
	
	public Registration()
	{	
	    super("REGISTRATION");
		this.setSize(1010,680);
		this.setLocationRelativeTo(null);
		
		 c1 = new Color(147,201,246);
		 c2 = new Color(90,158,240);
		 c3 = new Color(219,201,82);
		 c4 = new Color(186,186,186);
		 c5=  new Color(0,19,119);
		myFont = new Font ("Arial", Font.PLAIN,15);
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
        panel.setBackground(Color.WHITE);
		
		userlbl = new JLabel(" Username ");
		userlbl.setBounds(120,140, 125, 40);
		userlbl.setBackground(c1);
		userlbl.setOpaque(true);
		userlbl.setForeground(Color.BLACK);
		userlbl.setFont(myFont);
		panel.add(userlbl);
		
		userfld = new JTextField();
		userfld.setBounds(215,140, 135, 40);
	    userfld.setFont(myFont);
		panel.add(userfld);
		
		phnlbl = new JLabel(" Phone ");
		phnlbl.setBounds(120,190, 125, 40);
		phnlbl.setBackground(c1);
		phnlbl.setOpaque(true);
		phnlbl.setForeground(Color.BLACK);
		phnlbl.setFont(myFont);
		panel.add(phnlbl);
		
		phnfld = new JTextField();
		phnfld.setBounds(215,190, 135, 40);
	    phnfld.setFont(myFont);
		panel.add(phnfld);
		
		agelbl = new JLabel(" Age ");
		agelbl.setBounds(120,240, 125, 40);
		agelbl.setBackground(c1);
		agelbl.setOpaque(true);
		agelbl.setForeground(Color.BLACK);
		agelbl.setFont(myFont);
		panel.add(agelbl);
		
		agefld = new JTextField();
		agefld.setBounds(215,240, 135, 40);
	    agefld.setFont(myFont);
		panel.add(agefld);
		
		adrslbl = new JLabel(" Address ");
		adrslbl.setBounds(120,290, 125, 40);
		adrslbl.setBackground(c1);
		adrslbl.setOpaque(true);
		adrslbl.setForeground(Color.BLACK);
		adrslbl.setFont(myFont);
		panel.add(adrslbl);
		
		adrsfld = new JTextField();
		adrsfld.setBounds(215,290, 135, 40);
	    adrsfld.setFont(myFont);
		panel.add(adrsfld);
		
		passlbl = new JLabel(" Password");
		passlbl.setBounds(120,340, 125, 40);
	    passlbl.setBackground(c1);
		passlbl.setOpaque(true);
		passlbl.setForeground(Color.BLACK);
		passlbl.setFont(myFont);
		panel.add(passlbl);
		
		passfld = new JPasswordField();
		passfld.setBounds(215,340, 135, 40);
		passfld.setFont(myFont);
		passfld.setEchoChar('$');
		panel.add(passfld);
		
	
		
		rgstsbtn=new JButton("Register");
		rgstsbtn.setBounds(125,500,100,30);
		rgstsbtn.setBackground(c3);
		rgstsbtn.setFont(myFont);
        rgstsbtn.addActionListener(this);
		panel.add(rgstsbtn);
		
		backbtn = new JButton("Back");
		backbtn.setBounds(260,500, 80, 30);
		backbtn.setBackground(c4);
		backbtn.setFont(myFont);
        backbtn.addActionListener(this);
		panel.add(backbtn);
		
		
		img=new ImageIcon("./Images/oop2.jpg");
		imglbl=new JLabel(img);
		imglbl.setBounds(460,0,550,680);
		panel.add(imglbl);
		
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
   {
		String username = userfld.getText();
		String phone = phnfld.getText();
		String age = agefld.getText();
		String address =adrsfld.getText();
		String password = new String(passfld.getPassword());
		
		
		User u1=new User(username,phone,age,address,password);
		u1.addUser();
		
		if(ae.getSource() == rgstsbtn)
	{
		if (username.isEmpty() || phone.isEmpty() || age.isEmpty() || address.isEmpty() || password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill up all boxes");
		}
		
		JOptionPane.showMessageDialog(this, "Registration Completed");
		Frame f1=new Frame();
		f1.setVisible(true);
		
	}
	else if(ae.getSource() == backbtn){
		Frame f1=new Frame();
		f1.setVisible(true);
	}
}
}