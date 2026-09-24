package version4;

public class Main4 {

    public static void main(String[] args) {

        EmployeeRoster roster = new EmployeeRoster(6);

        Name alice = new Name("Alice", "Smith", "M.");
        Name bob = new Name("Bob", "Jones", "C. Jr.");
        Name maria = new Name("Maria", "Reyes", "L.");
        Name kevin = new Name("Kevin", "Tan", "S.");
        Name david = new Name("David", "White", "A.");

        MyDate aliceBirth = new MyDate(9, 15, 2000);
        MyDate bobBirth = new MyDate(4, 20, 2001);
        MyDate mariaBirth = new MyDate(9, 10, 2000);
        MyDate kevinBirth = new MyDate(6, 25, 1999);
        MyDate davidBirth = new MyDate(2, 14, 2002);

        MyDate hiredDate = new MyDate(6, 1, 2022);

        HourlyEmployee aliceEmployee =
                new HourlyEmployee(
                        101,
                        alice,
                        aliceBirth,
                        hiredDate,
                        45,
                        200
                );

        PieceWorkerEmployee bobEmployee =
                new PieceWorkerEmployee(
                        201,
                        bob,
                        bobBirth,
                        hiredDate,
                        250,
                        15
                );

        CommissionEmployee mariaEmployee =
                new CommissionEmployee(
                        301,
                        maria,
                        mariaBirth,
                        hiredDate,
                        100000
                );

        BasePlusCommissionEmployee kevinEmployee =
                new BasePlusCommissionEmployee(
                        401,
                        kevin,
                        kevinBirth,
                        hiredDate,
                        150000,
                        2000
                );

        HourlyEmployee davidEmployee =
                new HourlyEmployee(
                        102,
                        david,
                        davidBirth,
                        hiredDate,
                        40,
                        200
                );

        System.out.println("======================================================================");
        System.out.println();
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println();

        System.out.println(
                "Added: " + alice + " (Hourly) -> "
                        + (roster.addEmployee(aliceEmployee) ? "Success" : "Failed")
        );
        System.out.println();

        System.out.println(
                "Added: " + bob + " (Piece Worker) -> "
                        + (roster.addEmployee(bobEmployee) ? "Success" : "Failed")
        );
        System.out.println();

        System.out.println(
                "Added: " + maria + " (Commission) -> "
                        + (roster.addEmployee(mariaEmployee) ? "Success" : "Failed")
        );
        System.out.println();

        System.out.println(
                "Added: " + kevin + " (Base Plus Commission) -> "
                        + (roster.addEmployee(kevinEmployee) ? "Success" : "Failed")
        );
        System.out.println();

        System.out.println(
                "Added: " + david + " (Hourly) -> "
                        + (roster.addEmployee(davidEmployee) ? "Success" : "Failed")
        );
        System.out.println();

        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println();

        System.out.println(
                "Total Employees: " + roster.getCount()
                        + " / " + roster.getMax()
        );
        System.out.println();

        System.out.println(
                "Hourly Employees: " + roster.countHE()
        );
        System.out.println();

        System.out.println(
                "Piece Worker Employees: " + roster.countPWE()
        );
        System.out.println();

        System.out.println(
                "Commission Employees (Pure): " + roster.countCE()
        );
        System.out.println();

        System.out.println(
                "Base Plus Commission Employees: "
                        + roster.countBPCE()
        );

        System.out.println();
        System.out.println("======================================================================");
        System.out.println();
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println();

        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println();
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println();
        System.out.println("======================================================================");
        System.out.println();

        Employee removed = roster.removeEmployee(201);

        if (removed != null) {
            System.out.println(
                    "Removing Employee ID 201 ("
                            + removed.getEmpName()
                            + ")... Successfully removed."
            );
        }

        System.out.println();

        System.out.println(
                "Current Employee Count: " + roster.getCount()
        );

        System.out.println();
        System.out.println("Remaining Employees in Roster:");
        System.out.println();

        roster.displayAllEmployees();

        System.out.println();
        System.out.println("======================================================================");
    }
}