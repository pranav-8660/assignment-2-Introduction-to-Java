public abstract class LoanApplication {

    private static int counter = 1000;
    protected int applicationId;
    protected String customerName;
    protected double amount;
    protected LoanType type;
    protected LoanStatus status;

    public LoanApplication(String customerName, double amount, LoanType type) {
        this.applicationId = counter++;
        this.customerName = customerName;
        this.amount = amount;
        this.type = type;
        this.status = null;
    }

    public abstract boolean validateApplication() throws LoanException;

    public void apply() {
        this.status = LoanStatus.PENDING;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "ID=" + applicationId +
                ", Name='" + customerName + '\'' +
                ", Amount=" + amount +
                ", Type=" + type +
                ", Status=" + status +
                '}';
    }

    static {
        System.out.println("SmartLoan System initialized.");
    }
}
