import java.util.List;

class LoanUtils {
    public static <T extends LoanApplication> void printApplications(List<T> apps) {
        for (T app : apps) {
            System.out.println(app);
        }
    }
}