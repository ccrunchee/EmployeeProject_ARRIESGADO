package version5;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName,
                                      MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = getTotalSale() * 0.20 + baseSalary;

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee [ID: " + getEmpID()
                + ", Name: " + getEmpName()
                + ", Total Salary: ₱"
                + String.format("%,.2f", computeSalary())
                + "]";
    }
}