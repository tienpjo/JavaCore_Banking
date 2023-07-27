import java.util.Date;

public class Transaction extends NormalAccount {
    private final TRANSACTION_TYPE type;
    private final double amount;
    private final Date date;

    public Transaction(TRANSACTION_TYPE type, double amount) {
        super("");
        this.type = type;
        this.date = new Date();
        this.amount = amount;
    }

    public void printTransaction() {
        System.out.printf("%35s", "HISTORY TRANSACTION");
        System.out.printf("%20s%15.2f%15.2f\n",
                this.getType(),
                this.getAmount(),
                this.getBlance());
    }

    private String getDate() {
        return this.date.toString();
    }

    private TRANSACTION_TYPE getType() {
        return this.type;
    }


    private double getAmount() {
        return this.amount;
    }

}
