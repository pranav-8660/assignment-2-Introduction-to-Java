import java.util.*;
import java.lang.reflect.Method;


public class Main {

    private static void processLoans(List<LoanApplication> loans,LoanProcessor loanProcessor,Map<LoanType,List<LoanApplication>> loanmap){


        for(LoanApplication loan:loans){
            try {
                loanProcessor.process(loan);
                loanmap.computeIfAbsent(loan.type, k-> new ArrayList<>()).add(loan);
            } catch (LoanException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


    private static void printAuditlogs(Class<?> clazz){

        System.out.println("Audit Log Methods:-");

        for(Method m: clazz.getMethods()){
            if(m.isAnnotationPresent(AuditLog.class)){
                System.out.println("Annotated method-"+ m.getName());
            }
        }

    }

    private static void printGroupedApplications(Map<LoanType,List<LoanApplication>> loanmap){
        System.out.println("All applications:-");

        for(var entry:loanmap.entrySet()){
            System.out.println("Loan type:- "+entry.getKey());
            LoanUtils.printApplications(entry.getValue());
        }
    }

    private static void printSortedApplications(List<LoanApplication> loans) {
        System.out.println("\nSorted Applications by Amount:-");
        loans.sort(Comparator.comparingDouble(a -> a.amount));
        LoanUtils.printApplications(loans);
    }



    public static void main(String[] args) {
        
        Map<LoanType, List<LoanApplication>> loanMap = new HashMap<>();

        LoanApplication l1 = new HomeLoan("Pranav", 30_00_000);
        LoanApplication l2 = new HomeLoan("Prajwal", 60_00_000);
        LoanApplication l3 = new PersonalLoan("Vishva", 2_00_000);
        LoanApplication l4 = new PersonalLoan("Ganesh", 8_00_000);

        List<LoanApplication> loans = Arrays.asList(l1, l2, l3, l4);

        //processing loan with lambda function
        LoanProcessor processor = (LoanApplication app) -> {
            if (app.validateApplication()) {
                app.apply();
                if (app instanceof Approvable) {
                    LoanStatus finalStatus = ((Approvable) app).evaluateRisk();
                    System.out.println(app.customerName + " - " + finalStatus);
                }
            }
        };

        //Process loans
        for (LoanApplication loan : loans) {
            try {
                processor.process(loan);

                // Store in map
                loanMap.computeIfAbsent(loan.type, k -> new ArrayList<>()).add(loan);

            } catch (LoanException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        //find @AuditLog methods
        System.out.println("\nAudit Log Methods:-");
        for (Method m : Approvable.class.getMethods()) {
            if (m.isAnnotationPresent(AuditLog.class)) {
                System.out.println("Annotated Method: " + m.getName());
            }
        }

        // Print Applications
        System.out.println("\nAll Applications:-");
        for (Map.Entry<LoanType, List<LoanApplication>> entry : loanMap.entrySet()) {
            System.out.println("Loan Type: " + entry.getKey());
            LoanUtils.printApplications(entry.getValue());
        }

        //Sorting applications by amount
        System.out.println("\nSorted Applications by Amount:-");
        loans.sort(Comparator.comparingDouble(a -> a.amount));
        LoanUtils.printApplications(loans);
    }
}