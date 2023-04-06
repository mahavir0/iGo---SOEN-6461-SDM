/**
 * 
 */
package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Bank.CardChecker;
import Model.Recharge;
import Model.Ticket;

import java.awt.*;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	}

	public void mainPage() {
		textField.setText("");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(500, 300));

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
		
		frame.getContentPane().setBackground(Color.ORANGE);
	}

	public void rechargeCard() {
		panel.removeAll();
		textField.setText("");
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel.setBorder(new EmptyBorder(new Insets(120, 160, 120, 160)));
		panel.setBorder(new EmptyBorder(new Insets(45, 90, 40, 90)));
		
		//===========================================================================//
		//Dynamic option from the Recharge

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
		
		//===================================================
		//Dynamic Ticket Option from the Ticket
		
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

		//====================================================
		
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

	public boolean validateEmail(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";    
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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
					JOptionPane.showMessageDialog(frame, "Insufficient, cash", "Warning", JOptionPane.WARNING_MESSAGE);
				} else if (p > price) {
					JOptionPane.showMessageDialog(frame, "Payment Successfull.", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(frame, "Collect your change : " + (p-price) + "$", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
					receiptMethod();
				} else {
					receiptMethod();
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(frame, "Payment Denied. Please Provide a Cash!", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else if (b.equals("Procced Payment")) {
			if(textField.getText().equals("") || textField.getText().length()<16 || textField.getText().length()>16)
				JOptionPane.showMessageDialog(frame, "Please enter the valid card Details", "Warning", JOptionPane.WARNING_MESSAGE);
			else {
				
				boolean valid = false;
				try {
					valid = CardChecker.validateCardNumber(textField.getText());
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(frame, "Please enter the valid card Details", "Warning", JOptionPane.WARNING_MESSAGE);
				}	
				if (!valid) {
					JOptionPane.showMessageDialog(frame, "Invalid Card Number", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame, "Payment Successfull.","Payment Status", JOptionPane.INFORMATION_MESSAGE);
					receiptMethod();
				}
			}
		} else if (b.equals("Paper Receipt")) {
			JOptionPane.showMessageDialog(frame, "Receipt generated","Receipt Confirmation", JOptionPane.INFORMATION_MESSAGE);
			ImageIcon icon = new ImageIcon("src/Icons/smiley-icon.png");
			JOptionPane.showMessageDialog(frame, "Thank you for Using iGo\nDon't forget to collect your cards/tickets and change!", "Merci!", JOptionPane.INFORMATION_MESSAGE, icon);
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			mainPage();
		} else if (b.equals("Email Receipt")) {
			String m = "";
			while(m.equals("")) {
				m = JOptionPane.showInputDialog(frame, "Enter your e-mail :", "abc@xyz.com");
				if(m == null)
					break;
				if(!validateEmail(m)) {
					JOptionPane.showMessageDialog(frame, "Please Provide valid e-mail address", "Error", JOptionPane.ERROR_MESSAGE);
					m = "";
				}
			}
			if(m == null) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				receiptMethod();
			} else {
				JOptionPane.showMessageDialog(frame, "Receipt generated and sent to : "+m,"Receipt Confirmation", JOptionPane.INFORMATION_MESSAGE);
				ImageIcon icon = new ImageIcon("src/Icons/smiley-icon.png");
				JOptionPane.showMessageDialog(frame, "Thank you for Using iGo\nDon't forget to collect your cards/tickets and change!", "Merci!", JOptionPane.INFORMATION_MESSAGE, icon);
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				mainPage();
			}
		} else {
			panel.removeAll();
			trip = arg0.getActionCommand().split(" -")[0];
			if(trip.contains("Recharge")) {
				price = recharge.getRechargeOption().get(trip);
			}else {
				price = ticket.getValue().get(trip);
			}
			paymentMethod(b);
		}
	}

}
