package version2;

public class Main2 {

    public static void main(String[] args) {

        Name employeeName = new Name("Alice", "Smith", "M.", "");

        MyDate verificationDate = new MyDate(18, 9, 2026);
        MyDate birthDate = new MyDate(18, 9, 2000);
        MyDate dateHired = new MyDate(1, 6, 2022);

        HourlyEmployee hourlyEmployee = new HourlyEmployee(101, employeeName, birthDate, dateHired, 45, 200);

        System.out.println("--- Name & Date Output Verification ---");
        System.out.println("Name: " + employeeName);
        System.out.println("Date: " + verificationDate);

        System.out.println();

        System.out.println("--- Hourly Employee Payroll Test ---");

        System.out.println("[displayHourlyEmployee()]");
        hourlyEmployee.displayHourlyEmployee();

        System.out.println();

        System.out.println("[toString()]");
        System.out.println(hourlyEmployee);

        System.out.println();

        System.out.println("[Birthday Incentive Check]");

        System.out.printf("Regular Month (Oct) Salary: ₱%,.2f%n", hourlyEmployee.computeSalary(10));

        System.out.printf("Birth Month (Sep) Salary (+₱5,000.00): ₱%,.2f%n", hourlyEmployee.computeSalary(9));
    }
}
