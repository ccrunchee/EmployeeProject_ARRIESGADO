package version3;

public class Main3 {

    public static void main(String[] args) {

        Name alice = new Name("Alice", "Smith", "M.", "");
        Name bob = new Name("Bob", "Jones", "C.", "Jr.");
        Name maria = new Name("Maria", "Reyes", "L.", "");
        Name kevin = new Name("Kevin", "Tan", "S.", "");
        Name david = new Name("David", "White", "A.", "");

        MyDate aliceBirth = new MyDate(18, 9, 2000);
        MyDate bobBirth = new MyDate(5, 4, 1998);
        MyDate mariaBirth = new MyDate(12, 9, 1999);
        MyDate kevinBirth = new MyDate(20, 6, 2001);
        MyDate davidBirth = new MyDate(10, 12, 2002);

        MyDate aliceHired = new MyDate(1, 6, 2022);
        MyDate bobHired = new MyDate(15, 1, 2023);
        MyDate mariaHired = new MyDate(10, 3, 2021);
        MyDate kevinHired = new MyDate(20, 8, 2022);
        MyDate davidHired = new MyDate(5, 7, 2024);

        Employee[] roster = new Employee[6];

        int employeeCount = 0;
        int targetMonth = 9;

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        roster[employeeCount++] = new HourlyEmployee(101, alice, aliceBirth, aliceHired, 45, 200);

        System.out.println("Added: " + alice + " (Hourly) -> Success");

        roster[employeeCount++] = new PieceWorkerEmployee(201, bob, bobBirth, bobHired, 250, 15);

        System.out.println("Added: " + bob + " (Piece Worker) -> Success");

        roster[employeeCount++] = new CommissionEmployee(301, maria, mariaBirth, mariaHired, 150000);

        System.out.println("Added: " + maria + " (Commission) -> Success");

        roster[employeeCount++] = new BasePlusCommissionEmployee(401, kevin, kevinBirth, kevinHired, 150000, 9500);

        System.out.println("Added: " + kevin + " (Base Plus Commission) -> Success");

        roster[employeeCount++] = new HourlyEmployee(102, david, davidBirth, davidHired, 40, 200);

        System.out.println("Added: " + david + " (Hourly) -> Success");

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + employeeCount + " / " + roster.length);

        int hourlyCount = 0;
        int pieceWorkerCount = 0;
        int commissionCount = 0;
        int basePlusCount = 0;

        for (int i = 0; i < employeeCount; i++) {

            if (roster[i] instanceof BasePlusCommissionEmployee) {
                basePlusCount++;
            } else if (roster[i] instanceof CommissionEmployee) {
                commissionCount++;
            } else if (roster[i] instanceof PieceWorkerEmployee) {
                pieceWorkerCount++;
            } else if (roster[i] instanceof HourlyEmployee) {
                hourlyCount++;
            }
        }

        System.out.println("Hourly Employees: " + hourlyCount);
        System.out.println("Piece Worker Employees: " + pieceWorkerCount);
        System.out.println("Commission Employees (Pure): " + commissionCount);
        System.out.println("Base Plus Commission Employees: " + basePlusCount);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        for (int i = 0; i < employeeCount; i++) {

            Employee employee = roster[i];

            double basePay = employee.computeSalary();
            double totalPay = employee.computeSalary(targetMonth);
            double birthdayBonus = totalPay - basePay;

            String type = "";

            if (employee instanceof BasePlusCommissionEmployee) {
                type = "Base Plus Commission";
            } else if (employee instanceof CommissionEmployee) {
                type = "Commission";
            } else if (employee instanceof PieceWorkerEmployee) {
                type = "Piece Worker";
            } else if (employee instanceof HourlyEmployee) {
                type = "Hourly";
            }

            System.out.printf(
                    "[%s] ID: %d | Name: %s | Salary: ₱%,.2f",
                    type,
                    employee.getEmpID(),
                    employee.getEmpName(),
                    totalPay
            );

            if (birthdayBonus > 0) {
                System.out.println(" (Birthday Bonus Applied)");
            } else {
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        int removeID = 201;

        System.out.println("Removing Employee ID " + removeID + " (" + bob + ")... Successfully removed.");

        int removeIndex = -1;

        for (int i = 0; i < employeeCount; i++) {
            if (roster[i].getEmpID() == removeID) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex != -1) {
            for (int i = removeIndex; i < employeeCount - 1; i++) {
                roster[i] = roster[i + 1];
            }

            roster[employeeCount - 1] = null;
            employeeCount--;
        }

        System.out.println(
                "Current Employee Count: " + employeeCount
        );

        System.out.println();
        System.out.println("Remaining Employees in Roster:");

        for (int i = 0; i < employeeCount; i++) {

            Employee employee = roster[i];

            System.out.println(
                    (i + 1)
                            + ". ID: " + employee.getEmpID()
                            + " | Name: " + employee.getEmpName()
                            + " | Type: "
                            + employee.getClass().getSimpleName()
            );
        }

        System.out.println("======================================================================");
    }
}