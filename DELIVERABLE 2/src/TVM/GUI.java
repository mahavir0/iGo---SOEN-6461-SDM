/**
 * 
 */
package TVM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Bank.CardChecker;

import java.awt.*;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

/**
 * @author Mahavir
 *
 */
public class GUI implements ActionListener {

	static GraphicsConfiguration gc;
	
	Ticket ticket = new Ticket();
	Recharge recharge = new Recharge();
	String trip = "";
	double price;

	
//	JPanel panel = new JPanel(new GridLayout(ticket.getValue().size(), 1, 10, 10));
//	JTextField textField = new JTextField();
//	JFrame frame = new JFrame("iGo - TVM",gc);
	
	JPanel panel;
	JTextField textField;
	JFrame frame;
	/**
	 * 
	 */
	public GUI() {
		// TODO Auto-generated constructor stub
		panel = new JPanel(new GridLayout(ticket.getValue().size(), 1, 10, 10));
		textField = new JTextField();
		frame = new JFrame("iGo - TVM",gc);
//		frame.getContentPane().setBackground(Color.y);
	}

	public void mainPage() {
		textField.setText("");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 300));
//		frame.getContentPane().setBackground(Color.BLUE);
//		frame.setBackground(Color.RED);
//		frame.setBackground( new Color("blue"));

		panel.setBorder(new EmptyBorder(new Insets(60, 80, 60, 80)));
		panel.setBorder(new EmptyBorder(new Insets(40, 80, 40, 80)));

		JLabel label = new JLabel("Welcome to iGo");
		panel.add(label);
		
		JButton j1 = new JButton("Purchase a new Ticket");
		panel.add(j1);
		j1.addActionListener(this);

		JButton j2 = new JButton("Recharge a Card (OPUS)");
		panel.add(j2);
		j2.addActionListener(this);

		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void rechargeCard() {
		panel.removeAll();
		textField.setText("");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel.setBorder(new EmptyBorder(new Insets(120, 160, 120, 160)));
		panel.setBorder(new EmptyBorder(new Insets(45, 90, 40, 90)));
		
		//===========================================================================//
		
		JButton[] ja = new JButton[recharge.getRechargeOption().size()];
		int i=0;
		for(Entry<String, Double> entry : recharge.getRechargeOption().entrySet()) {
			String key = entry.getKey();
		    Double value = entry.getValue();
		    String temp = key + " - " + value + "$";
		    ja[i] = new JButton(temp);
		    panel.add(ja[i]);
		    ja[i].addActionListener(this);
		}
		JButton back = new JButton("Back to HomePage");
		panel.add(back);
		back.addActionListener(this);
		
		
		//===========================================================================//
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void buyTicket() {
		panel.removeAll();
		textField.setText("");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel.setBorder(new EmptyBorder(new Insets(120, 160, 120, 160)));
		panel.setBorder(new EmptyBorder(new Insets(45, 90, 40, 90)));

		JButton[] ja = new JButton[ticket.getValue().size()];
		int i=0;
		for (Entry<String, Double> entry : ticket.getValue().entrySet()) {
		    String key = entry.getKey();
		    Double value = entry.getValue();
		    String temp = key + " - " + value + "$";
		    ja[i] = new JButton(temp);
		    panel.add(ja[i]);
		    ja[i].addActionListener(this);
		}

		JButton back = new JButton("Back to HomePage");
		panel.add(back);
		back.addActionListener(this);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void paymentMethod(String a) {
		textField.setText("");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel.setBorder(new EmptyBorder(new Insets(120, 160, 120, 160)));
		panel.setBorder(new EmptyBorder(new Insets(45, 90, 40, 90)));

		JLabel jb = new JLabel("Payment Option :");
		
		JButton j1 = new JButton("Submit Card");
		JButton j2 = new JButton("Submit Cash");
		
		panel.add(jb);
		panel.add(j1);
		panel.add(j2);

		j1.addActionListener(this);
		j2.addActionListener(this);

		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void paymentMethodCard(String a) {
		panel.removeAll();
		textField.setText("Enter your card number here");
		JLabel label1 = new JLabel("Enter your Debit/Credit card number : ");
		panel.add(label1);
		panel.add(textField);

		JButton submitCard = new JButton("Procced Payment");
		submitCard.addActionListener(this);

		JButton back = new JButton("Back");
		back.addActionListener(this);

		panel.add(submitCard);
		panel.add(back);

		panel.revalidate();
		panel.repaint();
	}

	public void paymentMethodCash(String a) {
		panel.removeAll();
		textField.setText("Provide your Bill here");
		JLabel label1 = new JLabel("Insert Your Cash :");
		panel.add(label1);
		panel.add(textField);

		JButton submitCash = new JButton("Submitt Cash");
		submitCash.addActionListener(this);

		JButton back = new JButton("Back");
		back.addActionListener(this);

		panel.add(submitCash);
		panel.add(back);

		panel.revalidate();
		panel.repaint();
	}

	public void receiptMethod() {
		panel.removeAll();

		JLabel lb = new JLabel("Select Receipt Method :");
		panel.add(lb);
		
		JButton email = new JButton("Email Receipt");
		email.addActionListener(this);

		JButton paper = new JButton("Paper Receipt");
		paper.addActionListener(this);

		panel.add(email);
		panel.add(paper);

		panel.revalidate();
		panel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String b = arg0.getActionCommand();
		if(b.equals("Back to HomePage")) {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			mainPage();
		}else if (b.equals("Purchase a new Ticket")) {
			buyTicket();
		} else if(b.equals("Recharge a Card (OPUS)")) {
			rechargeCard();
		} else if (b.equals("Submit Card")) {
			paymentMethodCard(b);
		} else if (b.equals("Submit Cash")) {
			paymentMethodCash(b);
		} else if (b.equals("Back")) {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			buyTicket();
		} else if (b.equals("Submitt Cash")) {

			try {
				Double p = Double.parseDouble(textField.getText()); 
				if (p < price) {
					JOptionPane.showMessageDialog(frame, "Insufficient, cash");
				} else if (p > price) {
					JOptionPane.showMessageDialog(frame, "Payment Successfull.");
					JOptionPane.showMessageDialog(frame, "Here is your change : " + (p-price) + "$");
					receiptMethod();
				} else {
					receiptMethod();
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "Payment Denied. Please Provide a Cash!");
			}

		} else if (b.equals("Procced Payment")) {
			if(textField.getText().equals("") || textField.getText().length()<16 || textField.getText().length()>16)
				JOptionPane.showMessageDialog(frame, "Please enter the valid card Details");
			else {
				
				boolean valid = false;
				try {
					valid = CardChecker.validateCardNumber(textField.getText());
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(frame, "Please enter the valid card Details");
				}	
				if (!valid) {
					JOptionPane.showMessageDialog(frame, "Invalid Card Number");
				} else {
					JOptionPane.showMessageDialog(frame, "Payment Successfull.");
					receiptMethod();
				}
			}
		} else if (b.equals("Email Receipt") || b.equals("Paper Receipt")) {
			JOptionPane.showMessageDialog(frame, "Receipt generated");
			JOptionPane.showMessageDialog(frame, "Ticket printed");
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			mainPage();
		} else {
			panel.removeAll();
			System.out.println(b);
			trip = arg0.getActionCommand().split(" -")[0];
			if(trip.contains("Recharge")) {
				price = recharge.getRechargeOption().get(trip);
			}else {
				price = ticket.getValue().get(trip);
			}
			System.out.println(price);
			paymentMethod(b);
		}
	}

}
