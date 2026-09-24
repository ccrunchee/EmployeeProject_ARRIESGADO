package version5;

public class Main5 {

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster();

        Name alice = new Name("Alice", "Smith", "M.");
        Name bob = new Name("Bob", "Jones", "C. Jr.");
        Name maria = new Name("Maria", "Reyes", "L.");
        Name kevin = new Name("Kevin", "Tan", "S.");

        MyDate aliceBirth = new MyDate(15, 9, 2000);
        MyDate bobBirth = new MyDate(20, 4, 2001);
        MyDate mariaBirth = new MyDate(10, 9, 2000);
        MyDate kevinBirth = new MyDate(25, 6, 1999);

        MyDate hiredDate = new MyDate(1, 6, 2022);

        HourlyEmployee aliceEmployee = new HourlyEmployee(101, alice, aliceBirth, hiredDate, 45, 200);

        PieceWorkerEmployee bobEmployee = new PieceWorkerEmployee(201, bob, bobBirth, hiredDate, 250, 15);

        CommissionEmployee mariaEmployee = new CommissionEmployee(301, maria, mariaBirth, hiredDate, 100000);

        BasePlusCommissionEmployee kevinEmployee = new BasePlusCommissionEmployee(401, kevin, kevinBirth, hiredDate, 150000, 2000);

        roster.addEmployee(aliceEmployee);
        System.out.println("Enrolled: Smith, Alice M. (Hourly)");

        roster.addEmployee(bobEmployee);
        System.out.println("Enrolled: Jones, Bob C. Jr. (Piece Worker)");

        roster.addEmployee(mariaEmployee);
        System.out.println("Enrolled: Reyes, Maria L. (Commission)");

        roster.addEmployee(kevinEmployee);
        System.out.println("Enrolled: Tan, Kevin S. (Base Plus Commission)");

        System.out.println("Total Roster Size: "
                + roster.countEmployees() + " employees");

        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");

        roster.displayPayroll(9);

        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");

        System.out.print("Removing Employee ID 201... ");

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("Updated Roster Size: "
                + roster.countEmployees());

        System.out.println("Current Active Employees:");

        roster.displayAllEmployees();

        System.out.println("======================================================================");
    }
}