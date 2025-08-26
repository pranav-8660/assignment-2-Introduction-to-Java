public class HomeLoan extends LoanApplication implements Approvable{

    public HomeLoan(String customerName, double amount) {
        super(customerName, amount, LoanType.HOME);
    }

    @Override
    public LoanStatus evaluateRisk() {
        if (amount < 50_00_000) {
            this.status = LoanStatus.APPROVED;
        } else {
            this.status = LoanStatus.REJECTED;
        }
        return status;
    }

    @Override
    public boolean validateApplication() throws LoanException{
        
        if (amount <= 0) {
            throw new LoanException("Invalid loan amount for HomeLoan.");
        }
        return true;
    }
    
}
