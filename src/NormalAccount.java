import java.util.ArrayList;
import java.util.Scanner;


public class NormalAccount {
    static final String currency = "VND";
    private final double BALANCE = 0.00;
    private final String accountNumber;
    private final String id;
    private final String createdAt;
    private final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private double totalWithdraw;
    //    private final ArrayList<LoanAccount> lAccounts;
//    private final ArrayList<SavingAccount> savingAccounts;
    private double blance;
    private ArrayList<Account> accounts;
    private String nameHolder;

    public NormalAccount(String name) {
        this.blance = BALANCE;
//        this.transactions = new ArrayList<>();
//        this.lAccounts = new ArrayList<>();
//        this.savingAccounts = new ArrayList<>();

        this.id = AppService.generateAccountId();
        this.nameHolder = name.toUpperCase();
        this.accountNumber = AppService.generateAccountNumber();
        this.createdAt = AppService.fomatCreatAt();
    }

    public static void createSavingAccount() {

    }

    public static void createLoanAccount() {

    }

    /*
     * Create Normal Account
     */
    public static NormalAccount createNormalAccount() {
        Scanner user = new Scanner(System.in);
        System.out.print("Name:");
        String name = user.nextLine();
        return new NormalAccount(name);
    }

    public void viewAccount() {
        System.out.println("ACCOUNT INFORMATION");
        System.out.printf("%2s-%2s-%2s", "Họ và tên:", this.nameHolder, "\n");
        System.out.printf("%2s-%2s-%2s", "Số tài khoản:", this.accountNumber, "\n");
        System.out.printf("%2s-%2s-%2s", "Ngày tạo:", this.createdAt, "\n");
        System.out.printf("%2s-%2s-%2s", "Số dư:", this.blance, "\n");
    }

    public void deposit() {
        Scanner payIn = new Scanner(System.in);
        System.out.println("Nhập số tiền cần nạp:");
        double amount = payIn.nextDouble();
        if (amount > 0) {
            this.blance += amount;
            this.transactions.add(new Transaction(TRANSACTION_TYPE.BANK_DEPOSIT, amount));
        } else {
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
    }

    public void sendMoney(NormalAccount acc) {
        Scanner _amountInput = new Scanner(System.in);
        System.out.print("Nhập số tiền bạn muốn chuyển:");
        double amount = _amountInput.nextDouble();
        if (amount > 0) {
            acc.blance += amount;
            this.updateSenderBalance(amount);
            acc.updateReceiverBalance(amount);
            this.transactions.add(new Transaction(TRANSACTION_TYPE.TRANSFER, amount));
            System.out.printf("Chuyển khoản thành công đến: %s %s", acc.getNameHolder(), "\n");
        }
    }

    public void withdraw() {
        Scanner _amountInput = new Scanner(System.in);
        System.out.print("Nhập số tiền bạn muốn rút:");
        double amount = _amountInput.nextDouble();
        if (this.blance > 50 && amount > 0) {
            this.blance -= amount;
            totalWithdraw += amount;
            this.transactions.add(new Transaction(TRANSACTION_TYPE.WITHDRAW, amount));
        } else {
            System.out.println("Số dư không đủ hoặc số tiền cần chuyển không hợp lệ!!");
        }
    }

    /*
     * Function update name of holder
     */
    private void updateNameHolder(String _nameHolder) {
        this.nameHolder = _nameHolder;
    }

    public String getNameHolder() {
        return this.nameHolder;
    }

    private void updateSenderBalance(double _amount) {
        this.blance -= _amount;
    }

    private void updateReceiverBalance(double _amount) {
        this.blance += _amount;
    }

    protected double getBlance() {
        return this.blance;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

}