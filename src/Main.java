package version1;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Hourly Employee Test ---");

        HourlyEmployee hourly1 = new HourlyEmployee();
        hourly1.setEmpID(101);
        hourly1.setEmpName("Alice Smith");
        hourly1.setTotalHoursWorked(45);
        hourly1.setRatePerHour(200);

        HourlyEmployee hourly2 = new HourlyEmployee(
                102, "Nhico Bob", 38, 250
        );

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);


        System.out.println();
        System.out.println("--- Piece Worker Employee Test ---");

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee();
        piece1.setEmpID(201);
        piece1.setEmpName("Bob Bobbers");
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15);

        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(
                202, "Bobbylon", 150, 20
        );

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);


        System.out.println();
        System.out.println("--- Commission Employee Test ---");

        CommissionEmployee commission1 = new CommissionEmployee();
        commission1.setEmpID(301);
        commission1.setEmpName("David Bobber");
        commission1.setTotalSale(75000);

        CommissionEmployee commission2 = new CommissionEmployee(
                302, "Bobby Garcia", 150000
        );

        System.out.println("[displayCommissionEmployee()]");
        commission1.displayCommissionEmployee();
        commission2.displayCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(commission1);
        System.out.println(commission2);


        System.out.println();
        System.out.println("--- Base Plus Commission Employee Test ---");

        BasePlusCommissionEmployee basePlus1 =
                new BasePlusCommissionEmployee();

        basePlus1.setEmpID(401);
        basePlus1.setEmpName("Peter Parker");
        basePlus1.setTotalSale(60000);
        basePlus1.setBaseSalary(15000);

        BasePlusCommissionEmployee basePlus2 =
                new BasePlusCommissionEmployee(
                        402, "Bob Parker", 200000, 25000
                );

        System.out.println("[displayBasePlusCommissionEmployee()]");
        basePlus1.displayBasePlusCommissionEmployee();
        basePlus2.displayBasePlusCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(basePlus1);
        System.out.println(basePlus2);
    }
}