package version4;

public class BasePlusCommissionEmployee
        extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale,
            double baseSalary
    ) {
        super(
                empID,
                empName,
                birthDate,
                dateHired,
                totalSale
        );

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
        return baseSalary
                + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Base Salary: ₱%.2f | Total Sale: ₱%.2f%n",
                getEmpID(),
                getEmpName(),
                baseSalary,
                getTotalSale()
        );
    }
}