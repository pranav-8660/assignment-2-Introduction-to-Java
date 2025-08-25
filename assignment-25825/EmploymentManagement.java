// ENUM for departments
enum Department {
    DEVELOPMENT,
    HR,
    FINANCE,
    OPERATIONS
}

// ENUM for employee levels
enum EmployeeLevel {
    JUNIOR,
    MID,
    SENIOR,
    LEAD
}

// INTERFACE for Payroll
interface Payroll {
    double calculateSalary();
    double calculateSalary(double bonus);  // Overloaded
}

// INTERFACE for Performance Review
interface PerformanceReview {
    void reviewPerformance();
}

// ABSTRACT CLASS
abstract class Employee {
    protected int id;
    protected String name;
    protected Department department;
    protected EmployeeLevel level;

    public Employee(int id, String name, Department department, EmployeeLevel level) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.level = level;
    }

    // Abstract method
    public abstract String getRole();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Dept: " + department + ", Level: " + level);
    }
}

// CONCRETE CLASS Developer
class Developer extends Employee implements Payroll, PerformanceReview {
    private String techStack;

    public Developer(int id, String name, EmployeeLevel level, String techStack) {
        super(id, name, Department.DEVELOPMENT, level);
        this.techStack = techStack;
    }

    // Overriding abstract method
    @Override
    public String getRole() {
        return "Software Developer";
    }

    // Implementing Payroll
    @Override
    public double calculateSalary() {
        switch (level) {
            case JUNIOR: return 50000;
            case MID: return 80000;
            case SENIOR: return 120000;
            case LEAD: return 160000;
            default: return 0;
        }
    }

    // Overloaded method
    @Override
    public double calculateSalary(double bonus) {
        return calculateSalary() + bonus;
    }

    @Override
    public void reviewPerformance() {
        System.out.println(name + "'s performance is reviewed based on coding and problem-solving skills.");
    }
}

// CONCRETE CLASS Manager
class Manager extends Employee implements Payroll, PerformanceReview {
    private int teamSize;

    public Manager(int id, String name, EmployeeLevel level, int teamSize) {
        super(id, name, Department.OPERATIONS, level);
        this.teamSize = teamSize;
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public double calculateSalary() {
        switch (level) {
            case JUNIOR: return 70000;
            case MID: return 100000;
            case SENIOR: return 140000;
            case LEAD: return 200000;
            default: return 0;
        }
    }

    @Override
    public double calculateSalary(double bonus) {
        return calculateSalary() + (teamSize * 2000) + bonus;
    }

    @Override
    public void reviewPerformance() {
        System.out.println(name + " is reviewed based on leadership and team management.");
    }
}

// MAIN CLASS to test
public class EmploymentManagement {
    public static void main(String[] args) {
        Employee dev = new Developer(1, "Pranav V", EmployeeLevel.SENIOR, "Java, Spring Boot");
        Employee mgr = new Manager(2, "Prajwal M", EmployeeLevel.LEAD, 10);

        dev.displayDetails();
        System.out.println(dev.getRole() + " Salary: " + ((Payroll)dev).calculateSalary(5000));
        ((PerformanceReview)dev).reviewPerformance();

        System.out.println("-------------------");

        mgr.displayDetails();
        System.out.println(mgr.getRole() + " Salary: " + ((Payroll)mgr).calculateSalary(10000));
        ((PerformanceReview)mgr).reviewPerformance();
    }
}
