package chocan;


/**
 * Class for Weekly Reports
 * @author Jake Bischoff
 *
 */
public class SendWeeklyReports {

		/**
		 * Constructor for sendWeeklyReports
		 */
		public SendWeeklyReports() {

		}
		
		/**
		 * Void function calling WriteReport to send out weekly reports
		 * Creates all the weekly reports, including member reports, provider reports, summary reports, and EFT reports
		 */
		
		public void mainAccountingProcedure() {
			WriteReports weeklyReports = new WriteReports();
			weeklyReports.writeMemberReport(0);
			weeklyReports.writeProviderReport(0);
			weeklyReports.writeSummaryReport();
		}
}  
