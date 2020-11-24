package chocan;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.*;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * class for requesting different types of reports
 * @author Alisha
 *
 */
public class RequestReports {
		
	public RequestReports() {
		
	}
	
	/**
	 * GUI for the type of report
	 * Writes the appropriate report based on the type of report selected
	 * @throws Exception
	 */
	public void reportRequestGUI() {
		JButton memberReport = new JButton(new AbstractAction("Member Report") {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton providerReport = new JButton(new AbstractAction("Provider Report") {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton summaryReport = new JButton(new AbstractAction("Summary Report") {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JButton EFTReport = new JButton(new AbstractAction("EFT Report") {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JFrame mFrame = new JFrame();
		JPanel mPanel = new JPanel();
		JLabel mLabel = new JLabel("Select the type of report you would like to generate:");
		
		mPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 100, 300));
		mPanel.setLayout(new GridLayout(0, 1));
		mPanel.add(mLabel);
		mPanel.add(memberReport);
		mPanel.add(providerReport);
		mPanel.add(summaryReport);
		mPanel.add(EFTReport);
		
		mFrame.add(mPanel, BorderLayout.CENTER);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setTitle("Chocan Software");
		mFrame.pack();
		mFrame.setVisible(true);
	 		
	}
}
	 

