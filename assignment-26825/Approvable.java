public interface Approvable {
    
    public LoanStatus evaluateRisk();

    default void printDecision() {
        System.out.println("Final Decision: " + evaluateRisk());
    }
}
