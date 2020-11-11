package src.chocan;


/**
 * Class for Weekly Reports
 * @author Jake Bischoff
 *
 */
public class SendWeeklyReports {

		/**
		 * Constructor for service
		 */
		public SendWeeklyReport() {

		}
		
		/**
		 * Void function calling WriteReport to send out weekly reports
		 */
		public void mainAccountingProcedure() {
			WriteReport weeklyReports = new WriteReports();
			weeklyReports.writeMemberReport(0);
			weeklyReports.writeProviderReport(0);
			weeklyReports.writeSummaryReport();
		}
}  
