public class SavingAccount extends NormalAccount {
    // INTEREST_RATE VCB 2,80	3,10	4,10	4,10	5,10 5,10
    private static final double[] INTEREST_RATE = {2.8, 3.10, 4.1, 5.1, 6.4};
    private final double MINIMUM_BALANCE = 50;
    private double startBalance;
    private final String dateCreated; 

    public SavingAccount(String name, double startBalance) {
        super(name);
        this.dateCreated = AppService.fomatCreatAt();
        this.startBalance = startBalance;
    }

    public boolean accountIsSaveAccount() {
        return this.getBlanceAccount() > MINIMUM_BALANCE;
    }

    public double getStartBalance(){
        return this.startBalance;
    }

    public double getInterestRate(int monthInterest){
        return this.INTEREST_RATE[monthInterest / 12];
    }

    /* Calculate 
     * 
     */
    public double getMonthInterest(int month){
        for(int i = 1; i < month; i++){

        }
        return 0;
    }
}


