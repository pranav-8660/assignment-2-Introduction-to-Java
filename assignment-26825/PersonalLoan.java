
public class PersonalLoan extends LoanApplication implements Approvable{

    public PersonalLoan(String customerName, double amount) {
        super(customerName, amount, LoanType.PERSONAL);

    }

    @Override
    public LoanStatus evaluateRisk() {
        if (amount > 5_00_000) {
            this.status = LoanStatus.REJECTED;
        } else {
            this.status = LoanStatus.APPROVED;
        }
        return status;
    }
    @Override
    public boolean validateApplication() throws LoanException {
         if (amount <= 0) {
            throw new LoanException("Invalid loan amount for PersonalLoan.");
        }
        return true;    
    }
}
