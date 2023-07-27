import java.text.SimpleDateFormat;
import java.util.Date;

public class AppService {

    /*
     * Random generate id for user
     */
    public static String generateAccountId() {
        return "100" + (char) ('0' + Math.random() * ('9' - '5' + 1));
    }

    /*
     * Random generate fake account number
     * Retun account type string
     */
    public static String generateAccountNumber() {
        return "16708" + (char) ('0' + Math.random() * ('9' - '5' + 1));
    }

    /*
     * Random fomat date type hour/minute/second day/month/year
     * Return date type String
     */

    public static String fomatCreatAt() {
        SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Date createdAt = new Date();
        return formatDate.format(createdAt);
    }


    /*
     * Welcome app
     * Print main menu
     */
    public static void loadApp() {
        System.out.println("                                          MAIN MENU                                      ");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%28s%32s%38s", "Trading Account", "Save Account", "Loan Account\n");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s%-23s%-25s%25s", "10: Login", "11: Create Account", "23: Bank Saving", "34: Bank Loan\n");
        System.out.printf("%-25s%-23s%-25s%25s", "12: Withdraw", "13: Deposit", "24: Interest rate", "35: View Account\n");
        System.out.printf("%-25s%-23s%-25s%25s", "14: Send Money", "15: View Account", "25: View Account", "36: Attempts loans\n");
        System.out.printf("%-25s%-23s%-25s%25s", "16: Transaction History", "", "26: Deposit", "47: Interest rate\n");
        System.out.printf("%s", "0: Exit");
        System.out.println();
        System.out.print("Select number: ");
    }
}