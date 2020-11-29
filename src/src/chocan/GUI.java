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
import java.util.Timer;
import java.util.concurrent.TimeUnit;

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
	
	JLabel label;				//Create basic components of GUI
	JFrame frame;
	JPanel panel;
	JLabel subHead;
	JTextField textBox;
	JTextField textBox2;
	JTextField textBox3;
	JTextField textBox4;
	JTextField textBox5;
	JTextField textBox6;
	JTextField textBox7;
	JTextField textBox8;
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
	JButton home = new JButton(new AbstractAction("Home") {		//Create a specific button for restarting program, functionality is global
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
			@Override
			public void actionPerformed(ActionEvent e) {
				operatorTerminal();
			}
		});
		
		size = operator.getPreferredSize();
		operator.setBounds(55, 180, size.width+6, size.height+5);	//Format operator button based on recommended size

		
		provider = new JButton(new AbstractAction("Provider") { 	//Define functionality for provider
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
		//
		
		members.getMember("11880129").setSuspended(true);  //For testing Member Suspended case
		
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
			@Override												
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		deleteMember = new JButton(new AbstractAction("Delete Member") {		
			@Override												
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		updateMember = new JButton(new AbstractAction("Update Member") {		
			@Override												
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addProvider = new JButton(new AbstractAction("Add Provider") {		
			@Override												
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		deleteProvider = new JButton(new AbstractAction("Delete Provider") {		
			@Override												
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		updateProvider = new JButton(new AbstractAction("Update Provider") {		
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
		
		addMember.setBounds(43, 80, 127, 35);
		addMember.setVisible(true);
		panel.add(addMember);
		deleteMember.setBounds(43, 125, 127, 35);
		deleteMember.setVisible(true);
		panel.add(deleteMember);
		updateMember.setBounds(43, 170, 127, 35);
		updateMember.setVisible(true);
		panel.add(updateMember);
		addProvider.setBounds(185, 80, 127, 35);
		addProvider.setVisible(true);
		panel.add(addProvider);
		deleteProvider.setBounds(185, 125, 127, 35);
		deleteProvider.setVisible(true);
		panel.add(deleteProvider);
		updateProvider.setBounds(185, 170, 127, 35);
		updateProvider.setVisible(true);
		panel.add(updateProvider);
		
		
		
		}
	
	private void addPerson(int type) {
		
		Member inputMember = new Member();
		
		textBox = new JTextField();
		textBox2 = new JTextField();
		textBox3 = new JTextField();
		textBox4 = new JTextField();
		textBox5 = new JTextField();
		textBox6 = new JTextField();
		textBox7 = new JTextField();
		textBox8 = new JTextField();
		
		textBox.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setName(textBox.getText());
		    }
		});
		textBox.setVisible(true);
		textBox.setBounds(180, 125, 140, 25);
		
		textBox2.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setIDNumber(textBox.getText());
		    }
		});
		textBox2.setVisible(true);
		textBox.setBounds(180, 125, 140, 25);
		
		textBox3.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setEmail(textBox.getText());
		    }
		});
		textBox3.setVisible(true);
		textBox3.setBounds(180, 125, 140, 25);
		
		textBox4.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setStreetAddress(textBox.getText());
		    }
		});
		textBox4.setVisible(true);
		textBox4.setBounds(180, 125, 140, 25);
		
		textBox5.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setCity(textBox.getText());
		    }
		});
		textBox5.setVisible(true);
		textBox5.setBounds(180, 125, 140, 25);
		
		textBox6.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setState(textBox.getText());
		    }
		});
		textBox6.setVisible(true);
		textBox6.setBounds(180, 125, 140, 25);
		
		textBox7.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setZip(textBox.getText());
		    }
		});
		textBox7.setVisible(true);
		textBox7.setBounds(180, 125, 140, 25);
		
		textBox8.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	inputMember.setEmail(textBox.getText());
		    }
		});
		textBox8.setVisible(true);
		textBox8.setBounds(180, 125, 140, 25);
	
		
		
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
	}
	
	public static void main(String[] args) {
		new GUI();															//Creating a new GUI() object will simply run the program
	}
	
}
