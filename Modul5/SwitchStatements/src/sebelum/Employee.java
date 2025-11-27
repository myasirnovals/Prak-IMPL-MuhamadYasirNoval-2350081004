package sebelum;

public class Employee {
    private EmployeeType type;

    enum EmployeeType {
        ENGINEER,
        SALESMAN,
        MANAGER
    }

    private final int _monthlySalary;
    private final int _commission;
    private final int _bonus;

    Employee(EmployeeType type, int monthlySalary, int commission, int bonus) {
        this.type = type;
        _monthlySalary = monthlySalary;
        _commission = commission;
        _bonus = bonus;
    }

    private EmployeeType getType() {
        return type;
    }

    int payAmount() {
        switch (getType()) {
            case ENGINEER:
                return _monthlySalary;
            case SALESMAN:
                return _monthlySalary + _commission;
            case MANAGER:
                return _monthlySalary + _bonus;
            default:
                throw new RuntimeException("Incorrect Employee");
        }
    }
}
