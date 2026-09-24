package version5;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate,
                          MyDate dateHired, float totalHoursWorked,
                          double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary;

        if (totalHoursWorked <= 40) {
            salary = totalHoursWorked * ratePerHour;
        } else {
            double overtimeHours = totalHoursWorked - 40;
            salary = (40 * ratePerHour)
                    + (overtimeHours * ratePerHour * 1.5);
        }

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    @Override
    public String toString() {
        return "HourlyEmployee [ID: " + getEmpID()
                + ", Name: " + getEmpName()
                + ", Total Salary: ₱"
                + String.format("%,.2f", computeSalary())
                + "]";
    }
}