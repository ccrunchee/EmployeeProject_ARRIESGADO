package version5;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate,
                              MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary;

        if (totalSale >= 100000) {
            salary = totalSale * 0.15;
        } else if (totalSale >= 50000) {
            salary = totalSale * 0.10;
        } else {
            salary = totalSale * 0.05;
        }

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    @Override
    public String toString() {
        return "CommissionEmployee [ID: " + getEmpID()
                + ", Name: " + getEmpName()
                + ", Total Salary: ₱"
                + String.format("%,.2f", computeSalary())
                + "]";
    }
}