package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
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
            if (empList[i].getClass() == HourlyEmployee.class) {
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

    public void displayHE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof HourlyEmployee) {

                HourlyEmployee employee =
                        (HourlyEmployee) empList[i];

                employee.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee employee =
                        (PieceWorkerEmployee) empList[i];

                employee.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {

        for (int i = 0; i < count; i++) {

            if (empList[i].getClass() == CommissionEmployee.class) {

                CommissionEmployee employee =
                        (CommissionEmployee) empList[i];

                employee.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {

        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) empList[i];

                employee.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {

        for (int i = 0; i < count; i++) {

            System.out.printf(
                    "%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1,
                    empList[i].getEmpID(),
                    empList[i].getEmpName(),
                    empList[i].getClass().getSimpleName()
            );
        }
    }

    public void displayPayroll(int currentMonth) {

        for (int i = 0; i < count; i++) {

            Employee emp = empList[i];

            double salary = 0;
            String type = "";

            if (emp instanceof BasePlusCommissionEmployee) {

                BasePlusCommissionEmployee employee =
                        (BasePlusCommissionEmployee) emp;

                salary = employee.computeSalary(currentMonth);
                type = "Base Plus Commission";

            } else if (emp.getClass() == CommissionEmployee.class) {

                CommissionEmployee employee =
                        (CommissionEmployee) emp;

                salary = employee.computeSalary(currentMonth);
                type = "Commission";

            } else if (emp instanceof PieceWorkerEmployee) {

                PieceWorkerEmployee employee =
                        (PieceWorkerEmployee) emp;

                salary = employee.computeSalary(currentMonth);
                type = "Piece Worker";

            } else if (emp instanceof HourlyEmployee) {

                HourlyEmployee employee =
                        (HourlyEmployee) emp;

                salary = employee.computeSalary(currentMonth);
                type = "Hourly";
            }

            System.out.printf(
                    "[%s] ID: %d | Name: %s | Salary: ₱%,.2f",
                    type,
                    emp.getEmpID(),
                    emp.getEmpName(),
                    salary
            );

            if (emp.getBirthDate().getMonth() == currentMonth) {
                System.out.print(" (Birthday Bonus Applied)");
            }

            System.out.println();
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }
}
