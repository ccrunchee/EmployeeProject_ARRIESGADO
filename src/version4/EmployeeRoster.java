package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.empList = new Employee[max];
        this.max = 10;
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.empList = new Employee[this.max];
        this.max = 10;
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }

        empList[count] = emp;
        count++;

        return true;
    }

    public Employee removeEmployee(int empID) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        Employee removedEmployee = empList[index];

        for (int i = index; i < count - 1; i++) {
            empList[i] = empList[i + 1];
        }

        empList[count - 1] = null;
        count--;

        return removedEmployee;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }

        return null;
    }

    public int countHE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i].getClass() == CommissionEmployee.class) {
                total++;
            }
        }

        return total;
    }

    public int countBPCE() {
        int total = 0;

        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }

        return total;
    }


}
