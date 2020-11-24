package chocan;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainGUI {
	
	JLabel label;
	JFrame frame;
	JPanel panel;

	public mainGUI() {
		
		JButton manager = new JButton(new AbstractAction("Manager") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				RequestReports requestReports = new RequestReports();
				requestReports.reportRequestGUI();
				
			}
		});
		
		JButton provider = new JButton(new AbstractAction("Provider") {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton member = new JButton(new AbstractAction("Member") {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel("Select your account type");
		
		panel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(label);
		panel.add(manager);
		panel.add(provider);
		panel.add(member);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chocan Software");
		frame.pack();
		frame.setVisible(true);
		
	}
}

