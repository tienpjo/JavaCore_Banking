public class SavingAccount extends NormalAccount {
    private final boolean activeSaveAccount;

    public SavingAccount(String name) {
        super(name);
        activeSaveAccount = this.getBlance() > 50;
    }
}
