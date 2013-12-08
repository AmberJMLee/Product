import pointOfSale.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Tea extends JApplet implements ActionListener
{
	JLabel title = new JLabel("Welcome to our humble shop!");
	JLabel footer = new JLabel("");
	JTextField username = new JTextField("Enter Username");
	JTextField password = new JTextField("Enter Password");
	JButton login = new JButton("Log in");
	JButton account = new JButton("Register for Amber's Tea Party");
	JButton printer = new JButton("Print Receipt");
	
	ImageIcon image = new ImageIcon("245.png");
	JLabel imageLabel = new JLabel(image);
	
	ArrayList<Product> product = new ArrayList<Product>();
	ArrayList<String> cart= new ArrayList<String>();
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<User> users = new ArrayList<User>();
	
	int[] tracker = new int[4];
	DecimalFormat money = new DecimalFormat("0.00");
	
	String[] names = new String[4];
	String[] pwords = new String[4];

	public void init()
	{
		setSize(400,600);
	    Container contentPane = getContentPane();
	    contentPane.setLayout(new GridLayout(26, 2));
	    contentPane.setBackground(Color.pink);
	    
	    product.add(new Product("Green Tea", "Herbal Drink", new BigDecimal(1.5), 0, "", "245.png"));
	    product.add(new Product("Lemon Tea", "Citrus Drink", new BigDecimal(2.0), 0, "", "WTF.jpg"));
	    product.add(new Product("Cookie", "Hardened egg-sugar mix...?", new BigDecimal(0.5), 0, "", "WTF.jpg"));
	    product.add(new Product("Cake", "Baked egg-yeast-sugar mix", new BigDecimal(2.5), 0, "", "WTF.jpg"));
	    
	    users.add(new User("Amber","Lee"));
	    users.add(new User("Jhosselin","Rocha"));
	    users.add(new User("Arnice", "Willis"));
	    users.add(new User("Syd","Bechet"));
	    
	    Arrays.fill(tracker, 1);
	    
	    account.addActionListener(this);
		login.addActionListener(this);
		printer.addActionListener(this);
		add(title);
		add(imageLabel);
		add(username);
		add(password);
		add(login);
		add(account);
		add(footer);
	}
	
	int limit = 5;
	JLabel[] label = new JLabel[4];
	BigDecimal total = BigDecimal.ZERO;
	JTextField password2 = new JTextField("Type your password again");
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Register for Amber's Tea Party"))
		{
			setSize(500,600);
		    Container contentPane = getContentPane();
		    contentPane.setLayout(new GridLayout(26, 2));
		    contentPane.setBackground(Color.red);
		    title.setText("Give us your new login information, and you'll be ready to shop!");
		    remove(account);
		    remove(login);
		    remove(footer);
		    add(password2);
		    account.setText("REGISTER");
		    add(account);
		    add(footer);
		}
		if(e.getActionCommand().equals("REGISTER"))
		{
			if(password.getText().equals(password2.getText()))
			{
				users.add(new User(username.getText(),password.getText()));
				title.setText("Thank you so much! You're now ready to shop!");
				remove(login);
				remove(username);
				remove(password);
				remove(password2);
				remove(footer);
				account.setText("OK");
				
			}
			else
			{
				title.setText("Your passwords do not match. Please try again.");
			}
		}
		
		if(e.getActionCommand().equals("Log in"))
		{
			for(int i = 0; i < users.size(); i++)
			{
				names[i] = (users.get(i)).getUsername();
				pwords[i] = (users.get(i)).getPassword();
			}
			if(Arrays.asList(names).contains(username.getText())&&Arrays.asList(names).indexOf(username.getText())==Arrays.asList(pwords).indexOf(password.getText()))
			{
				
			    title.setText("Welcome back, "+username.getText()+"!");
			    remove(username);
				remove(password);
				remove(footer);
				remove(login);
				remove(account);
				setSize(400,600);
			    Container contentPane = getContentPane();
			    contentPane.setLayout(new GridLayout(26, 2));
			    contentPane.setBackground(Color.pink);
			    remove(account);
			    add(new JLabel("Choose what to place on your shopping list"));
			    for(int i = 0; i<=3; i++)
			    {
			    	String temp = (product.get(i)).getName();
			    	buttons.add(new JButton(temp));
			    	buttons.get(i).addActionListener(this);
			    	add(buttons.get(i));
			    }
			    add(new JLabel("Shopping cart"));
			    add(printer);
			    label[0] = new JLabel("");
			    label[1] = new JLabel("");
			    label[2] = new JLabel("");
			    label[3] = new JLabel("");
			    label[4] = new JLabel("");
			}
			else
			{
				if(limit>1)
				{
					limit--;
					title.setText("Username or password is unknown. Please try again");
				}
				else
				{
					setSize(500,200);
					Container contentPane = getContentPane();
				    contentPane.setLayout(new GridLayout(3, 1));
				    contentPane.setBackground(Color.white);
					remove(imageLabel);
					remove(username);
					remove(password);
					remove(login);
					remove(account);
					remove(footer);
					title.setText(" Please try again in 10 minutes.");
				}
			}
		}
		
		if(e.getActionCommand().equals("OK"))
		{
			setSize(400,600);
		    Container contentPane = getContentPane();
		    contentPane.setLayout(new GridLayout(26, 2));
		    contentPane.setBackground(Color.pink);
		    remove(account);
		    add(new JLabel("Choose what to place on your shopping list"));
		    for(int i = 0; i<=3; i++)
		    {
		    	String temp = (product.get(i)).getName();
		    	buttons.add(new JButton(temp));
		    	buttons.get(i).addActionListener(this);
		    	add(buttons.get(i));
		    }
		    add(new JLabel("Shopping cart"));
		    add(printer);
		    label[0] = new JLabel("");
		    label[1] = new JLabel("");
		    label[2] = new JLabel("");
		    label[3] = new JLabel("");
		    label[4] = new JLabel("");
		    
		}
		
		if(e.getActionCommand().equals(product.get(0).getName()))
		{
			
			product.get(0).setQuantity();
			if(tracker[0]==1)
			{
				add(label[0]);
				label[0].setText(product.get(0).getName()+"           $"+money.format(product.get(0).getPrice().multiply(new BigDecimal(product.get(0).getQuantity()))));
				tracker[0]--;
			}
			else if (tracker[0]==0)
			{
				
				label[0].setText(product.get(0).getName()+"x"+ product.get(0).getQuantity()+"           $"+money.format(product.get(0).getPrice().multiply(new BigDecimal(product.get(0).getQuantity()))));
			}
		}
		
		if(e.getActionCommand().equals(product.get(1).getName()))
		{
			
			product.get(1).setQuantity();
			if(tracker[1]==1)
			{
				add(label[1]);
				label[1].setText(product.get(1).getName()+"          $"+money.format(product.get(1).getPrice().multiply(new BigDecimal(product.get(1).getQuantity()))));
				tracker[1]--;
			}
			else if (tracker[1]==0)
			{
				
				label[1].setText(product.get(1).getName()+"x"+ product.get(1).getQuantity()+"         $"+money.format(product.get(1).getPrice().multiply(new BigDecimal(product.get(1).getQuantity()))));
			}
		}
		
		if(e.getActionCommand().equals(product.get(2).getName()))
		{
			
			product.get(2).setQuantity();
			if(tracker[2]==1)
			{
				add(label[2]);
				label[2].setText(product.get(2).getName()+"                $"+money.format(product.get(2).getPrice().multiply(new BigDecimal(product.get(2).getQuantity()))));
				tracker[2]--;
			}
			else if (tracker[2]==0)
			{
				
				label[2].setText(product.get(2).getName()+"x"+ product.get(2).getQuantity()+"                 $"+money.format(product.get(2).getPrice().multiply(new BigDecimal(product.get(2).getQuantity()))));
			}
		}
		
		if(e.getActionCommand().equals(product.get(3).getName()))
		{
			
			product.get(3).setQuantity();
			if(tracker[3]==1)
			{
				add(label[3]);
				label[3].setText(product.get(3).getName()+"                  $"+money.format(product.get(3).getPrice().multiply(new BigDecimal(product.get(3).getQuantity()))));
				tracker[3]--;
			}
			else if (tracker[3]==0)
			{
				
				label[3].setText(product.get(3).getName()+"x"+ product.get(3).getQuantity()+"                    $"+money.format(product.get(3).getPrice().multiply(new BigDecimal(product.get(3).getQuantity()))));
			}
		}
		
		
		if(e.getActionCommand().equals("Print Receipt"))
		{
			for(int i = 0; i <=3; i++)
			{
				total = total.add(product.get(i).getPrice().multiply(new BigDecimal(product.get(i).getQuantity())));
			}
			title.setText("Printing... please wait");
			add(new JLabel("Subotal:                  $" +String.valueOf(money.format(total))));
			add(new JLabel("Tax:                          $"+String.valueOf(money.format(total.multiply(new BigDecimal(0.15))))));
			add(new JLabel("Total:                       $"+String.valueOf(money.format(total.add(total.multiply(new BigDecimal(0.15)))))));
			Printer printer = new Printer();
			printer.printToPrinter("Receipt for Amber's Tea Party"+"\n"+
									label[0].getText()+"\n"+
									label[1].getText()+"\n"+
									label[2].getText()+"\n"+
									label[3].getText()+"\n"+
									"Subotal:                  $" +String.valueOf(money.format(total))+"\n"+
									"Tax:                          $"+String.valueOf(money.format(total.multiply(new BigDecimal(0.15))))+"\n"+
									"Total:                       $"+String.valueOf(money.format(total.add(total.multiply(new BigDecimal(0.15))))));
		}
	}
}
