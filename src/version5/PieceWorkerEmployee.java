package version5;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate,
                               MyDate dateHired, int totalPiecesFinished,
                               double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = totalPiecesFinished * ratePerPiece;

        if (getBirthDate().getMonth() == currentMonth) {
            salary += 5000;
        }

        return salary;
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee [ID: " + getEmpID()
                + ", Name: " + getEmpName()
                + ", Total Salary: ₱"
                + String.format("%,.2f", computeSalary())
                + "]";
    }
}