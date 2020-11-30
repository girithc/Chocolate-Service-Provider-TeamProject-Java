package chocan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GUI {
	
					//Create basic components of GUI
	JFrame frame;
	JPanel panel;
	JLabel subHead;
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	JLabel label6 = new JLabel();
	JLabel label7 = new JLabel();
	JLabel label8 = new JLabel();
	JTextField textBox = new JTextField();
	JTextField textBox2 = new JTextField();
	JTextField textBox3 = new JTextField();
	JTextField textBox4 = new JTextField();
	JTextField textBox5 = new JTextField();
	JTextField textBox6 = new JTextField();
	JTextField textBox7 = new JTextField();
	JList<String> list;
	JScrollPane scrollPane;
	
	JButton back = new JButton();				//Create function-specific buttons
	JButton manager = new JButton();
	JButton provider = new JButton();
	JButton operator = new JButton();
	JButton validateMember = new JButton();	
	JButton billChocAn = new JButton();
	JButton addMember = new JButton();
	JButton deleteMember = new JButton();
	JButton updateMember = new JButton();
	JButton addProvider = new JButton();
	JButton deleteProvider = new JButton();
	JButton updateProvider = new JButton();
	JButton submit = new JButton();
	JButton providerDirectory = new JButton();
	JButton home = new JButton(new AbstractAction("Home") {		//Create a specific button for restarting program, functionality is global
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override												//so we have to set functionality in the variable declarations
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			new GUI();
		}
	});
	
	ProviderDatabase providers;		//Implement ProviderDatabase for program functionality
	Provider currentProvider;
	
	MemberDatabase members;			//Implement MemberDatabase for program functionality
	Member currentMember;
	
	ProviderDirectory services;		//Implement ProviderDirectory for program functionality
	
	Dimension size;					//Create a variable for Dimension object--used for internal calculations

	public GUI() {
		
		frame = new JFrame();			//Instantiate basic control variables
		panel = new JPanel();
		label = new JLabel();
		subHead = new JLabel();
		textBox = new JTextField();
		
		frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Ends program on close
		frame.setTitle("Chocan Software");
		frame.pack();
		frame.add(panel);											//Add panel to frame
		frame.setSize(500, 300);								//Set size width=500, height = 300
		
		mainScreen(); 							//Format the main screen
		
		frame.setVisible(true);					//Show frame
	}
	
	private void mainScreen() {
		
		home.setBounds(390, 240, 100, 25);		//Set bounds of home button  (x , y, width, height)
		home.setVisible(false);					//Do not show home button on home screen
		
		label.setBounds(105, 15, 350, 100);	
		label.setText("Chocaholics Anonymous");				//Format Label
		label.setFont(new Font("Futura", Font.BOLD, 23));	
		
		subHead.setBounds(150, 50, 250, 100);					//Format sub header
		subHead.setText("Please select your account type");
		
		
		operator = new JButton(new AbstractAction("Operator") {		//Define functionality for operator
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				operatorTerminal();
			}
		});
		
		size = operator.getPreferredSize();
		operator.setBounds(55, 180, size.width+6, size.height+5);	//Format operator button based on recommended size

		
		provider = new JButton(new AbstractAction("Provider") { 	//Define functionality for provider
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					providerLoginScreen();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		size = provider.getPreferredSize();
		provider.setBounds(203, 180, size.width+10, size.height+5);		//Format provider button

		
		manager = new JButton(new AbstractAction("Manager") {	//Define functionality for manager
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		size = manager.getPreferredSize();
		manager.setBounds(351, 180, size.width+8, size.height+5);	//Format manager button
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	//Formats panel on the frame object
		panel.setLayout(null);												//No predetermined layout
		panel.add(label);
		panel.add(subHead);
		panel.add(manager);
		panel.add(provider);								//Add objects to the panel
		panel.add(operator);
		panel.add(home);						
	}
	
	private void providerLoginScreen() throws Exception {
		
		//Visibility 
		
		resetScreen();								//Set blank screen
		home.setVisible(true);							//Show home button
		label.setVisible(true);							//Show label
		providers = new ProviderDatabase();				//Create database to be accessed
		textBox = new JTextField();						//Create input text box		
		textBox.setBounds(180, 125, 140, 25);
		panel.add(textBox);								//Add to panel
		label.setText("Enter your ChocAn Provider Number");
		label.setFont(new Font("Serif", Font.PLAIN, 14));			//Restructure label
		label.setBounds(143, 55, 350, 100);
		
		//Functionality
		
		String[] all = new String[10]; 
		all = providers.getAllProviderID();
		for(int i = 0; i < 3; i++) {
			System.out.println(all[i]);
		}
		
		textBox.addActionListener(new ActionListener() {							//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	try {
		    		if(providers.searchProvider(textBox.getText())) {				  //If input ID is found as an ID in provider directory
		    			currentProvider = providers.getProvider(textBox.getText());
		    			providerTerminal();											//Then start the providerTerminal menu
		    		} else {
		    			subHead.setText("Incorrect provider number");				//Else show error message
		    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
		    			subHead.setForeground(new Color(132453650));
		    			subHead.setLocation(175, 115);
		    			subHead.setVisible(true);
		    		}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});
	}
	
	private void providerTerminal() {
		
		validateMember = new JButton(new AbstractAction("Validate Member") {	//Create a specific button for validate member functionality
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validateMember(0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		billChocAn = new JButton(new AbstractAction("Bill ChocAn") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				resetScreen();
				try {
					validateMember(1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		resetScreen();
		
		frame.setTitle("Provider Terminal");
		label.setBounds(193, 5, 350, 100);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setText("Select an action");
		label.setVisible(true);
		subHead.setForeground(new Color(0));
		subHead.setText("Welcome " + currentProvider.getName() + "!");
		subHead.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
		subHead.setBounds(13, -30, 350, 100);
		subHead.setVisible(true);
		home.setVisible(true);		
		validateMember.setBounds(43, 80, 127, 35);
		validateMember.setVisible(true);
		billChocAn.setBounds(185, 80, 127, 35);
		billChocAn.setVisible(true);
		panel.add(validateMember);
		panel.add(billChocAn);
	
		
		
	}
	
	private void validateMember(int type) throws Exception {	//@param determines what follows after the member is validated. 0 = Nothing, 1 = BillChocAn,
		
		back = new JButton(new AbstractAction("Back") {		//Create a specific button for operator terminal
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				providerTerminal();
			}
		});
		
		members = new MemberDatabase();				//Create database to be accessed
		textBox = new JTextField();						//Create input text box		
		
		//Visibility
		
		resetScreen();
		home.setVisible(true);							//Show home button
		label.setVisible(true);							//Show label
		textBox.setVisible(true);
		back.setBounds(7, 240, 100, 25);
		back.setVisible(true);
		textBox.setBounds(180, 125, 140, 25);
		panel.add(textBox);								//Add to panel
		label.setText("Enter Member's ID");
		label.setFont(new Font("Serif", Font.PLAIN, 14));			//Restructure label
		label.setBounds(195, 55, 350, 100);
		panel.add(back);
		
		//Functionality
		
		//
		String[] all = new String[10]; 
		all = members.getAllMemberID();			//For testing use only
		for(int i = 0; i < 3; i++) {
			System.out.println(all[i]);
		}
		
		textBox.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	try {
		    		if(members.searchMember(textBox.getText()) && members.getMember(textBox.getText()).getSuspended() == false) {	//If input ID is found as an ID in member directory
		    			subHead.setText("     Validated");																	//Display Valid message			
		    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
		    			subHead.setForeground(new Color(1330678324));
		    			subHead.setLocation(200, 115);
		    			subHead.setVisible(true);
		    			currentMember = members.getMember(textBox.getText());
		    			if(type == 1 && subHead.isVisible()) {
		    				billChocAnMemberValidated();				//Run billChocAnMemberValidated screen 
		    			}
		    		} else if(members.searchMember(textBox.getText()) && members.getMember(textBox.getText()).getSuspended() == true){
		    			subHead.setText("Member Suspended");														//Display Suspended message
		    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
		    			subHead.setForeground(new Color(132453650));
		    			subHead.setLocation(200, 115);
		    			subHead.setVisible(true);
		    		} else {
		    			subHead.setText("Invalid Member");															//Else show error message
		    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
		    			subHead.setForeground(new Color(132453650));
		    			subHead.setLocation(200, 115);
		    			subHead.setVisible(true);
		    		}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});
		
		
	}
	
	private void billChocAnMemberValidated() throws Exception {
		
		services = new ProviderDirectory();
		list = new JList<String>();
		
		resetScreen();
		list.setListData(services.getAllServices());
		for(int i = 2; i < 2; i++) {
			System.out.println(list.getComponent(i));
		}
		scrollPane = new JScrollPane();
	    scrollPane.setViewportView(list);
	    list.setLayoutOrientation(JList.VERTICAL_WRAP);
	    scrollPane.setVisible(true);
	    scrollPane.setBounds(290, 55, 200, 200);
	    panel.add(scrollPane);
		

		
		
	}
	
	private void operatorTerminal() {
		
		resetScreen();
		home.setVisible(true);
		addMember = new JButton(new AbstractAction("Add Member") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				try {
					addPerson(0);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		deleteMember = new JButton(new AbstractAction("Delete Member") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				try {
					deletePerson(0);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		updateMember = new JButton(new AbstractAction("Update Member") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addProvider = new JButton(new AbstractAction("Add Provider") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				try {
					addPerson(1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		deleteProvider = new JButton(new AbstractAction("Delete Provider") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				try {
					deletePerson(1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		updateProvider = new JButton(new AbstractAction("Update Provider") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		frame.setTitle("Operator Terminal");
		label.setBounds(193, 5, 350, 100);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setText("Select an action");
		label.setVisible(true);
		subHead.setForeground(new Color(0));
		subHead.setText("Interactive Mode");
		subHead.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
		subHead.setBounds(13, -30, 350, 100);
		subHead.setVisible(true);
		home.setVisible(true);	
		
		addMember.setBounds(108, 85, 127, 35);
		addMember.setVisible(true);
		panel.add(addMember);
		deleteMember.setBounds(108, 130, 127, 35);
		deleteMember.setVisible(true);
		panel.add(deleteMember);
		updateMember.setBounds(108, 175, 127, 35);
		updateMember.setVisible(true);
		panel.add(updateMember);
		addProvider.setBounds(265, 85, 127, 35);
		addProvider.setVisible(true);
		panel.add(addProvider);
		deleteProvider.setBounds(265, 130, 127, 35);
		deleteProvider.setVisible(true);
		panel.add(deleteProvider);
		updateProvider.setBounds(265, 175, 127, 35);
		updateProvider.setVisible(true);
		panel.add(updateProvider);
		
		
		
		}
	
	private void addPerson(int type) throws FileNotFoundException {
		
		resetScreen();
		
		Member inputMember = new Member();
		members = new MemberDatabase();
		
		Provider inputProvider = new Provider();
		providers = new ProviderDatabase();
		
		textBox = new JTextField();
		textBox2 = new JTextField();
		textBox3 = new JTextField();
		textBox4 = new JTextField();
		textBox5 = new JTextField();
		textBox6 = new JTextField();
		textBox7 = new JTextField();
		
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		label8 = new JLabel();
		
		submit = new JButton(new AbstractAction("Submit") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				if (type == 0) {
					inputMember.setName(textBox.getText());
					inputMember.setIDNumber(textBox2.getText());
					inputMember.setEmail(textBox3.getText());
					inputMember.setStreetAddress(textBox4.getText());
					inputMember.setCity(textBox5.getText());
					inputMember.setState(textBox6.getText());
					inputMember.setZip(textBox7.getText());
					textBox.setText("");
					textBox2.setText("");
					textBox3.setText("");
					textBox4.setText("");
					textBox5.setText("");
					textBox6.setText("");
					textBox7.setText("");
					try {
						members.addMember(inputMember);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					inputProvider.setName(textBox.getText());
					inputProvider.setIDNumber(textBox2.getText());
					inputProvider.setEmail(textBox3.getText());
					inputProvider.setStreetAddress(textBox4.getText());
					inputProvider.setCity(textBox5.getText());
					inputProvider.setState(textBox6.getText());
					inputProvider.setZip(textBox7.getText());
					textBox.setText("");
					textBox2.setText("");
					textBox3.setText("");
					textBox4.setText("");
					textBox5.setText("");
					textBox6.setText("");
					textBox7.setText("");
					try {
						providers.addProvider(inputProvider);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		submit.setBounds(180, 240, 140, 25);
		submit.setVisible(true);
		
		back = new JButton(new AbstractAction("Back") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				operatorTerminal();
			}
		});
		back.setBounds(7, 240, 100, 25);
		back.setVisible(true);
		
		textBox.setVisible(true);
		textBox.setBounds(15, 60, 140, 25);
		
		textBox2.setVisible(true);
		textBox2.setBounds(215, 60, 140, 25);
		
		textBox3.setVisible(true);
		textBox3.setBounds(15, 110, 240, 25);

		textBox4.setVisible(true);
		textBox4.setBounds(15, 160, 340, 25);

		textBox5.setVisible(true);
		textBox5.setBounds(15, 210, 140, 25);

		textBox6.setVisible(true);
		textBox6.setBounds(175, 210, 140, 25);

		textBox7.setVisible(true);
		textBox7.setBounds(335, 210, 140, 25);
		
		if(type == 0) {
			label.setText("Add Member");
		} else {
			label.setText("Add Provider");
		}
		label.setBounds(193, -30, 350, 100);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setVisible(true);
		
		label2.setText("Name");
		label2.setBounds(20, 40, 140, 25);
		
		if (type == 0) {
			label3.setText("Member ID Number");
		} else {
			label3.setText("Provider ID Number");
		}
		label3.setBounds(220, 40, 140, 25);
		
		label4.setText("Email");
		label4.setBounds(20, 90, 140, 25);
		
		label5.setText("Street Address");
		label5.setBounds(20, 140, 140, 25);
		
		label6.setText("City");
		label6.setBounds(20, 190, 140, 25);
		
		label7.setText("State");
		label7.setBounds(180, 190, 140, 25);
		
		label8.setText("Zip Code");
		label8.setBounds(340, 190, 140, 25);
		
		
		panel.add(textBox);
		panel.add(textBox2);
		panel.add(textBox3);
		panel.add(textBox4);
		panel.add(textBox5);
		panel.add(textBox6);
		panel.add(textBox7);
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(back);
		panel.add(submit);
		
	}
	
	private void deletePerson(int type) throws FileNotFoundException{
		
		members = new MemberDatabase();
		providers = new ProviderDatabase();
		
		resetScreen();
		
		back = new JButton(new AbstractAction("Back") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				operatorTerminal();
			}
		});
		back.setBounds(7, 240, 100, 25);
		back.setVisible(true);
		
		if(type == 0) {
			label.setText("Delete Member");
		} else {
			label.setText("Delete Provider");
		}
		label.setBounds(193, -30, 350, 100);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setVisible(true);
		
		textBox.setBounds(180, 125, 140, 25);
		textBox.setVisible(true);
		
		if(type == 0) {
			label2.setText("Enter Member's ID");
		} else {
			label2.setText("Enter Provider's ID");
		}
		label2.setFont(new Font("Serif", Font.PLAIN, 14));			//Restructure label
		label2.setBounds(195, 55, 350, 100);
		label2.setVisible(true);
		
		submit = new JButton(new AbstractAction("Remove") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				if(type == 0) {
					try {
						if(members.searchMember(textBox.getText())) {	
			    			subHead.setText("Member Removed");																	//Display Valid message			
			    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			    			subHead.setForeground(new Color(1330678324));
			    			subHead.setLocation(200, 145);
			    			subHead.setVisible(true);
			    			
			    		} else {
			    			subHead.setText("Member Not Found");																	//Display Valid message			
			    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			    			subHead.setForeground(new Color(132453650));
			    			subHead.setLocation(200, 145);
			    			subHead.setVisible(true);
			    		}
						members.deleteMember(textBox.getText());
						textBox.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						if(providers.searchProvider(textBox.getText())) {	
			    			subHead.setText("Provider Removed");																	//Display Valid message			
			    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			    			subHead.setForeground(new Color(1330678324));
			    			subHead.setLocation(200, 145);
			    			subHead.setVisible(true);
			    			
			    		} else {
			    			subHead.setText("Provider Not Found");																	//Display Valid message			
			    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			    			subHead.setForeground(new Color(132453650));
			    			subHead.setLocation(200, 145);
			    			subHead.setVisible(true);
			    		}
						providers.deleteProvider(textBox.getText());
						textBox.setText("");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		submit.setBounds(180, 155, 140, 25);
		submit.setVisible(true);
		
		panel.add(label);
		panel.add(label2);
		panel.add(back);
		panel.add(textBox);		
		panel.add(submit);
		panel.add(subHead);
		
		
	}
	
	private void resetScreen() {											//Resets every element in the panel to not visible.
		label.setVisible(false);											//This requires each new element to be manually set to 
		subHead.setVisible(false);											//visible when they are needed in a specific screen
		textBox.setVisible(false);
		home.setVisible(false);
		manager.setVisible(false);
		provider.setVisible(false);
		operator.setVisible(false);
		validateMember.setVisible(false);
		back.setVisible(false);
		billChocAn.setVisible(false);
		addMember.setVisible(false);
		deleteMember.setVisible(false);
		updateMember.setVisible(false);
		addProvider.setVisible(false);
		deleteProvider.setVisible(false);
		updateProvider.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		label6.setVisible(false);
		label7.setVisible(false);
		label8.setVisible(false);
		textBox2.setVisible(false);
		textBox3.setVisible(false);
		textBox4.setVisible(false);
		textBox5.setVisible(false);
		textBox6.setVisible(false);
		textBox7.setVisible(false);
		submit.setVisible(false);
	}
	
	public static void main(String[] args) {
		new GUI();	//Creating a new GUI() object will simply run the program
	}
	
}
