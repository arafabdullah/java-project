package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame implements MouseListener, ActionListener
{
    JLabel userlbl,passlbl,imglbl;
    JTextField userfld;
	JPasswordField passfld;
	JButton loginbtn,rgstsbtn, backbtn,mngbtn;
	ImageIcon backgroundimg;
	JPanel panel;
	Color c1,c2,c3,c4;
	Font myFont;
	
	public Admin()
	{	
	    super("Admin Login");
		this.setSize(1010,680);
		this.setLocationRelativeTo(null);
		
		 c1 = new Color(147,201,246);
		 c2 = new Color(90,158,240);
		 c3 = new Color(219,201,82);
		 c4 = new Color(186,186,186);
		myFont = new Font ("Arial", Font.PLAIN,15);
		
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userlbl = new JLabel(" Username ");
		userlbl.setBounds(480,180, 120, 40);
		userlbl.setBackground(c1);
		userlbl.setOpaque(true);
		userlbl.setForeground(Color.BLACK);
		userlbl.setFont(myFont);
		panel.add(userlbl);
		
		userfld = new JTextField();
		userfld.setBounds(570,180, 135, 40);
	    userfld.setFont(myFont);
		panel.add(userfld);
		
		passlbl = new JLabel(" Password");
		passlbl.setBounds(480,230, 120, 40);
	    passlbl.setBackground(c1);
		passlbl.setOpaque(true);
		passlbl.setForeground(Color.BLACK);
		passlbl.setFont(myFont);
		panel.add(passlbl);
		
		passfld = new JPasswordField();
		passfld.setBounds(570,230, 135, 40);
		passfld.setFont(myFont);
		passfld.setEchoChar('$');
		panel.add(passfld);
		
		loginbtn = new JButton("Login");
		loginbtn.setBounds(440, 300, 80, 30);
		loginbtn.setBackground(c2);
		loginbtn.setFont(myFont);
		loginbtn.addMouseListener(this);
        loginbtn.addActionListener(this);
		panel.add(loginbtn);
		
		rgstsbtn=new JButton("Register");
		rgstsbtn.setBounds(560,300,100,30);
		rgstsbtn.setBackground(c3);
		rgstsbtn.setFont(myFont);
		rgstsbtn.addMouseListener(this);
        rgstsbtn.addActionListener(this);
		panel.add(rgstsbtn);
		
		backbtn = new JButton("Back");
		backbtn.setBounds(685,300, 80, 30);
		backbtn.setBackground(c4);
		backbtn.setFont(myFont);
		backbtn.addMouseListener(this);
        backbtn.addActionListener(this);
		panel.add(backbtn);
		
		
		backgroundimg=new ImageIcon("./Images/oop4.jpg");
		imglbl=new JLabel("",backgroundimg,JLabel.CENTER);
		imglbl.setBounds(0,0,1000,650);
		panel.add(imglbl);
		
		
       
        
		
		
		
		
		this.add(panel);
	}
	
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
		{
			
			if(me.getSource() == loginbtn)
			{
				loginbtn.setBackground(Color.RED);
				loginbtn.setForeground(Color.WHITE);
			}
			
		else if (me.getSource() == rgstsbtn)
		{
			rgstsbtn.setBackground(Color.BLUE);
			rgstsbtn.setForeground(Color.WHITE);
		}
		else if (me.getSource() == backbtn)
		{
			backbtn.setBackground(Color.GREEN);
			backbtn.setForeground(Color.BLACK);
		}
		else {}
		}
		
		
		public void mouseExited(MouseEvent me)
		{ 
		if(me.getSource() == loginbtn)
			{
				loginbtn.setBackground(c2);
				loginbtn.setForeground(Color.BLACK);
			}
			
		else if (me.getSource() == rgstsbtn)
		{
			rgstsbtn.setBackground(c3);
			rgstsbtn.setForeground(Color.BLACK);
		}
		else if (me.getSource() == backbtn)
		{
			backbtn.setBackground(c4);
			backbtn.setForeground(Color.BLACK);
		}
		}
		
public void actionPerformed(ActionEvent ae)
{        String s1=userfld.getText();
         String s5=passfld.getText();
		 
         if(ae.getSource()==loginbtn)
	 {  if(s1.isEmpty() || s5.isEmpty())
		 { JOptionPane.showMessageDialog(null, "Fill up All");
		 }
		 else 
		 { 
	      AdminData a2=new AdminData();
		  
		  if(a2.getAdminData(s1,s5)==true)
		  {
 
         JOptionPane.showMessageDialog(null, "Successfully Login");
		 this.setVisible(false);
		 AdminDashboard a4 =new AdminDashboard();
		 a4.setVisible(true);
		 }
		 else 
		 { 
	    JOptionPane.showMessageDialog(null, "Invalid");
		 }
		 }
	 }
		  
	 else if(ae.getSource()==rgstsbtn)
	 {
		 RegAdmin rgstr =new RegAdmin();
		  rgstr.setVisible(true);
		  
	 }
	 
	 else if (ae.getSource()==backbtn)
	 { 
	      Frame f1=new Frame();
		f1.setVisible(true);
	 }
		 
}
}
