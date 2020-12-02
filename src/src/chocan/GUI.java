package chocan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;



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
	JTable table;
	JScrollPane scrollPane = new JScrollPane();
	JRadioButton active = new JRadioButton("Active");
	JRadioButton suspended = new JRadioButton("Suspended");
	ButtonGroup status = new ButtonGroup();
	JTextArea reportWindow = new JTextArea();
	JScrollPane scroll = new JScrollPane();
	
	JButton back = new JButton();				//Create function-specific buttons
	JButton manager = new JButton();
	JButton provider = new JButton();
	JButton operator = new JButton();
	JButton mainAccountingProcedureButton = new JButton();
	JButton validateMember = new JButton();	
	JButton billChocAn = new JButton();
	JButton addMember = new JButton();
	JButton deleteMember = new JButton();
	JButton updateMember = new JButton();
	JButton addProvider = new JButton();
	JButton deleteProvider = new JButton();
	JButton updateProvider = new JButton();
	JButton requestMemberReports = new JButton();
	JButton requestProviderReports = new JButton();
	JButton requestSummaryReports = new JButton();
	JButton requestEFTReports = new JButton();
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

	String dateProvided;
	String oldID;
	
	ServicePerformed inputService;
	
	WeeksServices weeksServices;
	
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
		frame.setResizable(false);
		
		mainScreen(); 							//Format the main screen
		
		frame.setVisible(true);					//Show frame
	}
	
	private void mainScreen() {
		
		resetScreen();
		
		home.setBounds(390, 240, 100, 25);		//Set bounds of home button  (x , y, width, height)
		home.setVisible(false);					//Do not show home button on home screen
		
		label.setBounds(105, 15, 350, 100);	
		label.setText("Chocaholics Anonymous");				//Format Label
		label.setFont(new Font("Futura", Font.BOLD, 23));
		label.setVisible(true);
		
		subHead.setBounds(150, 50, 250, 100);					//Format sub header
		subHead.setText("Please select your account type");
		subHead.setVisible(true);
		
		
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
		operator.setBounds(55, 160, size.width+6, size.height+5);	//Format operator button based on recommended size
		operator.setVisible(true);

		
		provider = new JButton(new AbstractAction("Provider") { 	//Define functionality for provider
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					providerLoginScreen(0);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		size = provider.getPreferredSize();
		provider.setBounds(203, 160, size.width+10, size.height+5);		//Format provider button
		provider.setVisible(true);
		
		manager = new JButton(new AbstractAction("Manager") {	//Define functionality for manager
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				managerTerminal();
			}
		});
		
		size = manager.getPreferredSize();
		manager.setBounds(351, 160, size.width+8, size.height+5);	//Format manager button
		manager.setVisible(true);
		
		
		mainAccountingProcedureButton = new JButton(new AbstractAction("Run Main Accounting Procedure") {	//Define functionality for manager
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				SendWeeklyReports mAP = new SendWeeklyReports();
				try {
					mAP.mainAccountingProcedure();
					resetScreen();
					label.setText("Weekly Reports Have Been Written");
					label.setBounds(103, 30, 450, 100);
					label.setFont(new Font("Serif", Font.BOLD, 20));
					label.setVisible(true);
					
					submit = new JButton(new AbstractAction("Return") {		
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override												
						public void actionPerformed(ActionEvent e) {
							mainScreen();
						}
					});
					submit.setBounds(180, 140, 140, 35);
					submit.setVisible(true);
					
				} catch (Exception e1) {
					resetScreen();
					label.setText("Error Writing Reports. Please Try Again");
					label.setBounds(63, 30, 450, 100);
					label.setFont(new Font("Serif", Font.BOLD, 20));
					label.setVisible(true);
					
					submit = new JButton(new AbstractAction("Return") {		
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						@Override												
						public void actionPerformed(ActionEvent e) {
							mainScreen();
						}
					});
					submit.setBounds(180, 140, 140, 35);
					submit.setVisible(true);
					
				}
				panel.add(label);
				panel.add(submit);
				
				
			}
		});
		
		size = mainAccountingProcedureButton.getPreferredSize();
		mainAccountingProcedureButton.setBounds(121, 220, size.width+8, size.height+5);	//Format manager button
		mainAccountingProcedureButton.setVisible(true);
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));	//Formats panel on the frame object
		panel.setLayout(null);												//No predetermined layout
		panel.add(label);
		panel.add(subHead);
		panel.add(manager);
		panel.add(provider);								//Add objects to the panel
		panel.add(operator);
		panel.add(home);	
		panel.add(mainAccountingProcedureButton);
	}
	
	private void managerTerminal() {
		
		resetScreen();
		
		frame.setTitle("Manager Terminal");
		label.setBounds(178, 0, 350, 100);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setText("Request a Report");
		label.setVisible(true);
		subHead.setForeground(new Color(0));
		subHead.setText("Welcome ChocAn Manager!");
		subHead.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
		subHead.setBounds(13, -30, 350, 100);
		subHead.setVisible(true);
		
		home.setVisible(true);
		
		requestMemberReports = new JButton(new AbstractAction("Member Report") {	//Create a specific button for validate member functionality
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validateMember(3);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		requestMemberReports.setBounds(180, 85, 127, 35);
		requestMemberReports.setVisible(true);
		
		requestProviderReports = new JButton(new AbstractAction("Provider Report") {	//Create a specific button for validate member functionality
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					providerLoginScreen(2);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		requestProviderReports.setBounds(180, 130, 127, 35);
		requestProviderReports.setVisible(true);
		
		requestSummaryReports = new JButton(new AbstractAction("Summary Report") {	//Create a specific button for validate member functionality
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					showReport(2);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		requestSummaryReports.setBounds(180, 175, 127, 35);
		requestSummaryReports.setVisible(true);
		
		requestEFTReports = new JButton(new AbstractAction("EFT Report") {	//Create a specific button for validate member functionality
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					showReport(3);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		requestEFTReports.setBounds(180, 220, 127, 35);
		requestEFTReports.setVisible(true);
		
		
		
		panel.add(home);
		panel.add(subHead);
		panel.add(requestMemberReports);
		panel.add(requestProviderReports);
		panel.add(requestSummaryReports);
		panel.add(requestEFTReports);
		
		
		
	}
	
	private void showReport(int type) throws Exception {
		
		resetScreen();

		
		back = new JButton(new AbstractAction("Back") {		//Create a specific button for operator terminal
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(type == 0) {
					try {
						validateMember(3);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (type == 1) {
					try {
						providerLoginScreen(2);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					managerTerminal();
				}
			}
		});
		back.setBounds(7, 240, 100, 25);
		
		back.setVisible(true);
		home.setVisible(true);
		
		
		
		
		WriteReports report = new WriteReports();	
		
		try {
			if(type == 0) {
				report.writeMemberReport(currentMember.getIDNumber());
				FileReader reader = new FileReader(currentMember.getIDNumber() + ".txt");
				reportWindow.read(reader, currentMember.getIDNumber() + ".txt"); 
			} else if(type == 1) {
				report.writeProviderReport(currentProvider.getIDNumber());
				FileReader reader = new FileReader("p" +currentProvider.getIDNumber() + ".txt");
				reportWindow.read(reader, "p " + currentProvider.getIDNumber() + ".txt"); 
			} else if(type == 2) {
				report.writeSummaryReport();
				FileReader reader = new FileReader("Summary.txt");
				reportWindow.read(reader, "Summary.txt"); 
			} else if(type == 3) {
				report.writeEFTReport();
				FileReader reader = new FileReader("EFT.txt");
				reportWindow.read(reader, "EFT.txt"); 
			}
			reportWindow.setBounds(105, 45, 290, 220);
			reportWindow.setVisible(true);
			reportWindow.setEditable(false);
			reportWindow.setBorder(BorderFactory.createLoweredBevelBorder());
			scroll = new JScrollPane(reportWindow);
			scroll.setLocation(105, 45);
			scroll.setSize(290,220);
			scroll.setVisible(true);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			panel.add(scroll);
			label.setText("This report has been written to file:");
		} catch (Exception e){
			if(type == 0) {
				subHead.setText("Member has no services on record");
			} else if(type == 1){						//Display Suspended message
				subHead.setText("Provider has no services on record");
			} else if(type == 2) {
				subHead.setText("Summary report was not completed");
			} else if(type == 3) {
				subHead.setText("EFT report was not completed");
			}
			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			subHead.setForeground(new Color(132453650));
			subHead.setLocation(160, 75);
			subHead.setVisible(true);
			reportWindow.setVisible(false);
			label.setText("      Error writing report to file:");
		}
		
		
		label.setBounds(128, -25, 350, 100);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setVisible(true);
		
		
		panel.add(reportWindow);
		panel.add(back);
		panel.add(label);

	}

	private void providerLoginScreen(int type) throws Exception {
		
		//Visibility 
		
		resetScreen();								//Set blank screen
		home.setVisible(true);							//Show home button
		label.setVisible(true);							//Show label
		providers = new ProviderDatabase();				//Create database to be accessed
		textBox = new JTextField();						//Create input text box		
		textBox.setBounds(180, 125, 140, 25);
		panel.add(textBox);								//Add to panel
		if(type == 1 || type == 2) {
			label.setText("             Enter Provider's ID");
			
			back = new JButton(new AbstractAction("Back") {		
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override												
				public void actionPerformed(ActionEvent e) {
					if (type == 1) {
						operatorTerminal();
					} else if (type == 2) {
						managerTerminal();
					}
				}
			});
			back.setBounds(7, 240, 100, 25);
			back.setVisible(true);
			panel.add(back);
		} else {
			label.setText("Enter your ChocAn Provider Number");
		}
		label.setFont(new Font("Serif", Font.PLAIN, 14));			//Restructure label
		label.setBounds(143, 55, 350, 100);
		
		textBox.addActionListener(new ActionListener() {							//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	try {
		    		if(providers.searchProvider(textBox.getText())) {				  //If input ID is found as an ID in provider directory
		    			currentProvider = providers.getProvider(textBox.getText());
		    			if(type == 1) {
		    				updatePerson(1);
		    			} else if (type == 0){
		    				providerTerminal();	
		    			}	else {
		    				showReport(1);//Then start the providerTerminal menu
		    			}
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
		
		providerDirectory = new JButton(new AbstractAction("Provider Directory") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					providerDirectory(0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		resetScreen();
		
		frame.setTitle("Provider Terminal");
		label.setBounds(188, 5, 350, 100);
		label.setFont(new Font("Serif", Font.PLAIN, 18));
		label.setText("Select an action");
		label.setVisible(true);
		subHead.setForeground(new Color(0));
		subHead.setText("Welcome " + currentProvider.getName() + "!");
		subHead.setFont(new Font("Serif", Font.HANGING_BASELINE, 14));
		subHead.setBounds(13, -30, 350, 100);
		subHead.setVisible(true);
		home.setVisible(true);		
		validateMember.setBounds(180, 85, 127, 35);
		validateMember.setVisible(true);
		billChocAn.setBounds(180, 130, 127, 35);
		billChocAn.setVisible(true);
		providerDirectory.setBounds(180, 175, 127, 35);
		providerDirectory.setVisible(true);
		panel.add(validateMember);
		panel.add(billChocAn);
		panel.add(providerDirectory);
	
		
		
	}
	
	private void validateMember(int type) throws Exception {	//@param determines what follows after the member is validated. 0 = Nothing, 1 = BillChocAn,
		
		resetScreen();
		
		back = new JButton(new AbstractAction("Back") {		//Create a specific button for operator terminal
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(type == 2) {
					operatorTerminal();
				} else if (type == 0){
					providerTerminal();
				} else {
					managerTerminal();
				}
			}
		});
		
		members = new MemberDatabase();				//Create database to be accessed
		textBox = new JTextField();						//Create input text box		
		
		//Visibility
		

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
		    				inputService = new ServicePerformed();
		    				enterDateAndTime();				//Run billChocAnMemberValidated screen 
		    			} else if (type == 2) {
		    				updatePerson(0);
		    			} else if (type == 3) {
		    				showReport(0);
		    			} else {
		    				
		    			}
		    		} else if(members.searchMember(textBox.getText()) && members.getMember(textBox.getText()).getSuspended() == true){
		    			subHead.setText("Member Suspended");														//Display Suspended message
		    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
		    			subHead.setForeground(new Color(132453650));
		    			subHead.setLocation(200, 115);
		    			subHead.setVisible(true);
		    			if(type == 2) {
		    				updatePerson(0);
		    			} else if (type == 3) {
		    				showReport(0);
		    			} else {
		    				
		    			}
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
	
	private void enterDateAndTime() {
		
		resetScreen();
		
		inputService.setProviderNumber(currentProvider.getIDNumber());
		inputService.setMemberNumber(currentMember.getIDNumber());
		
		back = new JButton(new AbstractAction("Back") {		//Create a specific button for operator terminal
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					validateMember(1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		back.setBounds(7, 240, 100, 25);
		back.setVisible(true);
		
		home.setVisible(true);
		
		label.setText("<html>Enter Date of Service <br/>&nbsp&nbsp&nbsp MM-DD-YYYY</html>");
		label.setFont(new Font("Serif", Font.PLAIN, 14));			//Restructure label
		label.setBounds(185, 55, 350, 100);
		label.setVisible(true);
		
		textBox = new JTextField();
		textBox.setBounds(160, 125, 170, 25);
		textBox.setText("");
		textBox.setVisible(true);
		textBox.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	boolean approved = true;
		    	for(int i = 0; i < textBox.getText().length(); i++) {
		    		if(textBox.getText().length() != 10 || textBox.getText() == null) {
		    			subHead.setText("<html> &nbsp&nbsp&nbsp Incorrect Formatting <br/> Please format like above </html>");																	//Display Valid message			
		    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
		    			subHead.setForeground(new Color(132453650));
		    			subHead.setLocation(180, 115);
		    			subHead.setVisible(true);
		    			approved = false;
		    			break;
		    		} else if(i != 2 && i != 5) {
		    			if(!(Character.isDigit(textBox.getText().charAt(i)))) {
		    				subHead.setText("<html> &nbsp&nbsp&nbsp Incorrect Formatting <br/> Please format like above </html>");																	//Display Valid message			
			    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			    			subHead.setForeground(new Color(132453650));
			    			subHead.setLocation(180, 115);
			    			subHead.setVisible(true);
			    			approved = false;
			    			break;
		    			}
		    		} else {
		    			if(!(textBox.getText().charAt(i) == '-')) {
		    				subHead.setText("<html> &nbsp&nbsp&nbsp Incorrect Formatting <br/> Please format like above </html>");																	//Display Valid message			
			    			subHead.setFont(new Font("Serif", Font.PLAIN, 14));
			    			subHead.setForeground(new Color(132453650));
			    			subHead.setLocation(180, 115);
			    			subHead.setVisible(true);
			    			approved = false;
			    			break;
		    			}
		    		}
		    	}
		    	if(approved) {
		    		try {
		    			inputService.setDateProvided(textBox.getText());
						providerDirectory(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
		    	}
		    	
		    }
		});
		
		panel.add(back);
		panel.add(home);
		panel.add(textBox);
		panel.add(subHead);
		
		
	}
	
	private void providerDirectory(int type) throws Exception {
		
		resetScreen();
		
		back = new JButton(new AbstractAction("Back") {		//Create a specific button for operator terminal
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if(type == 1) {
					enterDateAndTime();
				} else {
					providerTerminal();
				}
			}
		});
		back.setBounds(7, 240, 100, 25);
		back.setVisible(true);
		
		home.setVisible(true);
		
		services = new ProviderDirectory();
		String[] columnNames = { "Service Code", "Service Name", "Price"};
		
		table = new JTable(services.returnAllServices(), columnNames);
		table.getColumnModel().getColumn(0).setPreferredWidth(145);
		table.getColumnModel().getColumn(1).setPreferredWidth(175);
		table.setBorder(BorderFactory.createLoweredBevelBorder());
		
		scrollPane = new JScrollPane(table);
	    scrollPane.setVisible(true);
	    if(type == 1) {
	    	scrollPane.setLocation(95, 35);
	    } else {
	    	scrollPane.setLocation(95, 55);
	    }
	    scrollPane.setSize(310, 120);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    
	    if(type == 1) {
	    	textBox = new JTextField();
			textBox.setBounds(170, 195, 170, 25);
			textBox.setText("");
			textBox.setVisible(true);
			textBox.addActionListener(new ActionListener() {					//Implement an action when enter key is pressed
			    @Override
			    public void actionPerformed(ActionEvent event) {
			    		try {
							if(services.getServiceName(textBox.getText()) != "") {
								inputService.setServiceCode(textBox.getText());
								confirmService();
							} else {
								subHead.setText("Incorrect Service Code");																	//Display Valid message			
								subHead.setFont(new Font("Serif", Font.PLAIN, 14));
								subHead.setForeground(new Color(132453650));
								subHead.setLocation(180, 195);
								subHead.setVisible(true);
								panel.add(subHead);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}		
			    }
			});
			
			label2.setText("Enter Service Code");
			label2.setFont(new Font("Serif", Font.PLAIN, 14));			//Restructure label
			label2.setBounds(195, 135, 350, 100);
			label2.setVisible(true);
			
			panel.add(textBox);
			panel.add(label2);
	    }
	    
	    
		label.setText("Provider Directory");
		label.setBounds(173, -30, 350, 100);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setVisible(true);
	    
	    panel.add(scrollPane);
	    panel.add(label);
	    panel.add(back);
	    panel.add(home);
		
		
	}
	
	private void confirmService() throws Exception {
		
		resetScreen();
		
		weeksServices = new WeeksServices();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		inputService.setCurrDateAndTime(dtf.format(now));
		
		back = new JButton(new AbstractAction("Back") {		//Create a specific button for operator terminal
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					providerDirectory(1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		back.setBounds(7, 240, 100, 25);
		back.setVisible(true);
		
		home.setVisible(true);
		
		label.setText("Confirm Service");
		label.setBounds(173, -30, 350, 100);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setVisible(true);
		
		label2.setText("Service:                               " + services.getServiceName(inputService.getServiceCode()));
		label2.setBounds(125, 10, 350, 100);
		label2.setFont(null);
		label2.setVisible(true);
		
		label3.setText("Current date/time:              " + inputService.getCurrDateAndTime());
		label3.setBounds(125, 30, 350, 100);
		label3.setVisible(true);
		
		label4.setText("Date of Service Provided:    " + inputService.getDateProvided());
		label4.setBounds(125, 50, 350, 100);
		label4.setVisible(true);
		
		label5.setText("Provider Number:                " + inputService.getProviderNumber());
		label5.setBounds(125, 70, 350, 100);
		label5.setVisible(true);
		
		label6.setText("Member Number:                " + inputService.getMemberNumber());
		label6.setBounds(125, 90, 350, 100);
		label6.setVisible(true);
		
		label7.setText("Comments:");
		label7.setBounds(125, 110, 350, 100);
		label7.setVisible(true);
		
		textBox = new JTextField();
		textBox.setBounds(120, 165, 280, 50);
		textBox.setText("");
		textBox.setVisible(true);

		submit = new JButton(new AbstractAction("Confirm") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				if(textBox.getText().length() > 100) {
					subHead.setText("Comment too long");																	//Display Valid message			
					subHead.setFont(new Font("Serif", Font.PLAIN, 14));
					subHead.setForeground(new Color(132453650));
					subHead.setLocation(300, 110);
					subHead.setVisible(true);
				} else {
					try {
						inputService.setComments(textBox.getText());
						weeksServices.addService(inputService);
						confirmation();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		submit.setBounds(180, 240, 140, 25);
		submit.setVisible(true);
		
		panel.add(back);
		panel.add(home);
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(textBox);
		panel.add(subHead);
		panel.add(submit);
		
		
	}
	
	private void confirmation() throws Exception {
		
		resetScreen();
		
		submit = new JButton(new AbstractAction("Return") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				providerTerminal();
			}
		});
		submit.setBounds(180, 140, 140, 35);
		submit.setVisible(true);
		
		home.setVisible(true);
		
		label.setText("Your service has been recorded");
		label.setBounds(123, 30, 350, 100);
		label.setFont(new Font("Serif", Font.BOLD, 20));
		label.setVisible(true);
		
		label2.setText("The fee to be paid is $" + services.getServiceFee(inputService.getServiceCode()));
		label2.setBounds(123, 60, 350, 100);
		label2.setFont(null);
		label2.setVisible(true);
		
		panel.add(submit);
		panel.add(home);
		panel.add(label);
		panel.add(label2);
		
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
				try {
					validateMember(2);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
				try {
					providerLoginScreen(1);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
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
					if(active.isSelected()) {
						inputMember.setSuspended(false);
					} else {
						inputMember.setSuspended(true);
					}
					textBox.setText("");
					textBox2.setText("");
					textBox3.setText("");
					textBox4.setText("");
					textBox5.setText("");
					textBox6.setText("");
					textBox7.setText("");
					try {
						members.addMember(inputMember);
						addPerson(0);
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
						addPerson(1);
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
		
		if(type == 0) {
			status.add(active);
			status.add(suspended);
			active.setBounds(300, 90, 140, 25);
			suspended.setBounds(300, 110, 140, 25);
			active.setVisible(true);
			suspended.setVisible(true);
			panel.add(active);
			panel.add(suspended);
			
		}
		
		
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
		
		textBox = new JTextField();
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
	
	private void updatePerson(int type) throws FileNotFoundException {

		resetScreen();

		members = new MemberDatabase();
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
		
		submit = new JButton(new AbstractAction("Update") {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override												
			public void actionPerformed(ActionEvent e) {
				if (type == 0) {
					
					oldID = currentMember.getIDNumber();
					
					currentMember.setName(textBox.getText());
					currentMember.setIDNumber(textBox2.getText());
					currentMember.setEmail(textBox3.getText());
					currentMember.setStreetAddress(textBox4.getText());
					currentMember.setCity(textBox5.getText());
					currentMember.setState(textBox6.getText());
					currentMember.setZip(textBox7.getText());
					if(active.isSelected() && currentMember.getSuspended()) {
						currentMember.setSuspended(false);
					} else if (suspended.isSelected() && !(currentMember.getSuspended())) {
						currentMember.setSuspended(true);
					}
					
					try {
						members.updateMember(oldID, currentMember);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {
					
					oldID = currentProvider.getIDNumber();
					
					currentProvider.setName(textBox.getText());
					currentProvider.setIDNumber(textBox2.getText());
					currentProvider.setEmail(textBox3.getText());
					currentProvider.setStreetAddress(textBox4.getText());
					currentProvider.setCity(textBox5.getText());
					currentProvider.setState(textBox6.getText());
					currentProvider.setZip(textBox7.getText());
					
					try {
						providers.updateProvider(oldID, currentProvider);
					} catch (Exception e1) {
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
			textBox.setText(currentMember.getName());
			textBox2.setText(currentMember.getIDNumber());
			textBox3.setText(currentMember.getEmail());
			textBox4.setText(currentMember.getStreetAddress());
			textBox5.setText(currentMember.getCity());
			textBox6.setText(currentMember.getState());
			textBox7.setText(currentMember.getZip());
		} else {
			textBox.setText(currentProvider.getName());
			textBox2.setText(currentProvider.getIDNumber());
			textBox3.setText(currentProvider.getEmail());
			textBox4.setText(currentProvider.getStreetAddress());
			textBox5.setText(currentProvider.getCity());
			textBox6.setText(currentProvider.getState());
			textBox7.setText(currentProvider.getZip());
		}
		if(type == 0) {
			label.setText("Update Member");
		} else {
			label.setText("Update Provider");
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
		
		if(type == 0) {
			status.add(active);
			status.add(suspended);
			active.setBounds(300, 90, 140, 25);
			suspended.setBounds(300, 110, 140, 25);
			active.setVisible(true);
			suspended.setVisible(true);
			if(currentMember.getSuspended()) {
				suspended.setSelected(true);
				active.setSelected(false);
			} else {
				suspended.setSelected(false);
				active.setSelected(true);
			}
			panel.add(active);
			panel.add(suspended);
			
		}
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

	private void resetScreen() {											//Resets every element in the panel to not visible.
		label.setVisible(false);											//This requires each new element to be manually set to 
		subHead.setVisible(false);											//visible when they are needed in a specific screen
		textBox.setVisible(false);
		home.setVisible(false);
		manager.setVisible(false);
		provider.setVisible(false);
		operator.setVisible(false);
		mainAccountingProcedureButton.setVisible(false);
		validateMember.setVisible(false);
		back.setVisible(false);
		billChocAn.setVisible(false);
		addMember.setVisible(false);
		deleteMember.setVisible(false);
		updateMember.setVisible(false);
		addProvider.setVisible(false);
		deleteProvider.setVisible(false);
		updateProvider.setVisible(false);
		providerDirectory.setVisible(false);
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
		scrollPane.setVisible(false);
		active.setVisible(false);
		suspended.setVisible(false);
		requestMemberReports.setVisible(false);
		requestProviderReports.setVisible(false);
		requestSummaryReports.setVisible(false);
		requestEFTReports.setVisible(false);
		reportWindow.setVisible(false);
		scroll.setVisible(false);
		
	}
	
	public static void main(String[] args) {
		new GUI();	//Creating a new GUI() object will simply run the program
	}
	
}


