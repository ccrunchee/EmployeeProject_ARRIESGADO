package version4;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(
            int empID,
            Name empName,
            MyDate birthDate,
            MyDate dateHired,
            double totalSale
    ) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double computeSalary(int currentMonth) {

        double commissionRate;

        if (totalSale < 10000) {
            commissionRate = 0.05;
        } else if (totalSale < 50000) {
            commissionRate = 0.10;
        } else if (totalSale < 100000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        double salary = totalSale * commissionRate;

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | Total Sale: ₱%.2f%n",
                getEmpID(),
                getEmpName(),
                totalSale
        );
    }
}