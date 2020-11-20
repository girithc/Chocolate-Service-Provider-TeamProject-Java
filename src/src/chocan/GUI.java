package chocan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.io.FileNotFoundException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	JLabel label;
	JFrame frame;
	JPanel panel;
	JLabel subHead;
	JTextField textBox;
	
	JButton home = new JButton(new AbstractAction("Home") {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new GUI();
		}
	});
	
	JButton manager = new JButton(new AbstractAction("Manager") {
		@Override
		public void actionPerformed(ActionEvent e) {
			/*  
			 * Add Button functionality
			 */
			
			
		}
	});
	
	JButton provider = new JButton(new AbstractAction("Provider") {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				ProviderLoginScreen();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	
	JButton operator = new JButton(new AbstractAction("Operator") {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	});
	
	ProviderDatabase providers;
	Provider currentProvider;

	public GUI() {
		
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		subHead = new JLabel();
		frame.getContentPane();
		
		/*
		 * HOME BUTTON
		 */
		//home.setText("Home");
		home.setBounds(390, 240, 100, 25);
		home.setVisible(false);
		
		
		/*
		 * Format Label
		 */
		label.setBounds(105, 15, 350, 100);
		label.setText("Chocaholics Anonymous");
		label.setFont(new Font("Futura", Font.BOLD, 23));
		
		subHead.setBounds(150, 50, 250, 100);
		subHead.setText("Please select your account type");
		//label.set
		
		
		
		/*
		 * Format operator button
		 */
		Dimension size = operator.getPreferredSize();
		operator.setBounds(55, 180, size.width+6, size.height+5);
		//operator.setBackground(new Color(12855079));
		//operator.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		//operator.setLocation(166, 135);
		
		/*
		 * Format provider button
		 */
		size = provider.getPreferredSize();
		provider.setBounds(203, 180, size.width+10, size.height+5);

		
		/*
		 * Format manager button
		 */
		size = manager.getPreferredSize();
		manager.setBounds(351, 180, size.width+8, size.height+5);

		
		
		
		/*
		 * Format panel
		 */
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setLayout(null);
		panel.add(label);
		panel.add(subHead);
		panel.add(manager);
		panel.add(provider);
		panel.add(operator);
		panel.add(home);
		
		/*
		 * Format frame 
		 */
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chocan Software");
		
		frame.pack();
		frame.add(panel);//, BorderLayout.CENTER);		//Add operations above these
		frame.setSize(500, 300);
		frame.setVisible(true);
		
		Dimension frameDim = new Dimension();
		frameDim = frame.getSize();
		System.out.println(frameDim.toString());
		
	}
	
	private void ProviderLoginScreen() throws Exception {
		
		manager.setVisible(false);
		provider.setVisible(false);
		operator.setVisible(false);
		subHead.setVisible(false);
		home.setVisible(true);
		providers = new ProviderDatabase();
		currentProvider = new Provider();
		
		
		/*
		 * Instantiate Text field
		 */
		textBox = new JTextField();
		textBox.setBounds(180, 125, 140, 25);
		
		panel.add(textBox);
		
		
		
		
		
		/*
		 * Restructure GUI window
		 */
		label.setText("Enter your ChocAn Provider Number");
		label.setFont(new Font("Serif", Font.PLAIN, 14));
		label.setBounds(143, 55, 350, 100);
		
		/*
		 * FUNCTIONALITY
		 */
		
		textBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	try {
					currentProvider = providers.getProvider(textBox.getText());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
		if(currentProvider.getIDNumber() != null) {
			//new GUI();
		} else {
			subHead.setText("Incorrect provider number");
			subHead.setLocation(180, 155);
			subHead.setVisible(true);
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new GUI();
	}
	
}
