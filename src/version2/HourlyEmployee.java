
package version2;

public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.ratePerHour = 0;
        this.totalHoursWorked = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.ratePerHour = 0;
        this.totalHoursWorked = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        setRatePerHour(ratePerHour);
        setTotalHoursWorked(totalHoursWorked);
    }

    public int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimePay =
                (totalHoursWorked - 40) * ratePerHour * 1.5;

        return regularPay + overtimePay;
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();

        if (birthDate.getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    public void displayHourlyEmployee() {
        System.out.printf(
                "ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%.2f/hr%n",
                empID, empName, birthDate, dateHired,
                totalHoursWorked, ratePerHour
        );
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired,
                totalHoursWorked, ratePerHour, computeSalary()
        );
    }
}