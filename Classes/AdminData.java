package Classes;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class AdminData{
	private String uname;
	private String unumber;
	private String uage;
	private String uaddress;
	private String upass;
	private File myfile;
	private FileWriter fwrite;
	private Scanner sc;
	
	public AdminData()
	{
	}

	public AdminData(String uname,String unumber,String uage,String uaddress,String upass)
	
	{
		this.uname=uname;
		this.unumber=unumber;
		this.uage=uage;
		this.uaddress=uaddress;
		this.upass=upass;
	}
	
	public void setUname(String uname)
	{this.uname=uname;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUnumber(String unumber)
	{this.unumber=unumber;
	}
	public String getUnumber()
	{
		return unumber;
	}
    public void setUage(String uage)
	{this.uage=uage;
	}
	public String getUage()
	{
		return uage;
	}
	public void setUaddress(String uaddress)
	{this.uaddress=uaddress;
	}
	public String getUaddress()
	{
		return uaddress;
	}
	public void setUpass(String upass)
	{this.upass=upass;
	}
	public String getUpass()
	{
		return upass;
	}

    public void addAdminData()
	{ 
	   try
	   {
		myfile=new File("./Datas/AdData.txt");
		
		fwrite=new FileWriter(myfile,true);
		
		fwrite.write(getUname()+"\t");
		fwrite.write(getUnumber()+"\t");
		fwrite.write(getUage()+"\t");
		fwrite.write(getUaddress()+"\t");
		fwrite.write(getUpass()+"\n");
		
		fwrite.flush();
		fwrite.close();
		
	}
	catch(IOException ioe)
	{
		ioe.printStackTrace();
	}
	}
	
	public boolean getAdminData(String username,String password)
	{ 
	   boolean flag=false;
	   
	   try
	   {
	   myfile=new File("./Datas/AdData.txt");
	   sc=new Scanner(myfile);
	   
	   
	 while(sc.hasNextLine())
	 {
		 
		 String line=sc.nextLine();
		 String [] value=line.split("\t");
		 if(value.length >=5&&value[0].equals(username)&&value[4].equals(password))
		 { 
	         flag=true;
		 }
	 }
	   }
		 catch(IOException ioe)
		 { 
		   ioe.printStackTrace();
		 }
		 return flag;
	 }
}