import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get student details
        System.out.println("Enter Student Id");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Student name");
        String studentName = scanner.nextLine();
        System.out.println("Enter Department name");
        String department = scanner.nextLine();
        System.out.println("Enter gender");
        String gender = scanner.nextLine();
        System.out.println("Enter category");
        String category = scanner.nextLine();
        System.out.println("Enter College fee");
        double collegeFee = scanner.nextDouble();

        // Based on category, create appropriate student object and calculate total fee
        if (category.equals("DayScholar")) {
            System.out.println("Enter Bus number");
            int busNumber = scanner.nextInt();
            System.out.println("Enter the distance");
            float distance = scanner.nextFloat();

            // Create DayScholar object
            DayScholar dayScholar = new DayScholar(studentId, studentName, department, gender, category, collegeFee, busNumber, distance);

            // Calculate and display total fee
            System.out.println("Total College fee is " + dayScholar.calculateTotalFee());
        } else if (category.equals("Hosteller")) {
            System.out.println("Enter the room number");
            int roomNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("Enter the Block name");
            char blockName = scanner.nextLine().charAt(0);
            System.out.println("Enter the room type");
            String roomType = scanner.nextLine();

            // Create Hosteller object
            Hosteller hosteller = new Hosteller(studentId, studentName, department, gender, category, collegeFee, roomNumber, blockName, roomType);

            // Calculate and display total fee
            System.out.println("Total College fee is " + hosteller.calculateTotalFee());
        } else {
            System.out.println("Invalid category");
        }

        scanner.close();
    }
}

class Hosteller extends Student {
    private int roomNumber;
    private char blockName;
    private String roomType;

    // Constructor
    public Hosteller(int studentId, String studentName, String department, String gender, String category, double collegeFee,
                     int roomNumber, char blockName, String roomType) {
        super(studentId, studentName, department, gender, category, collegeFee);
        this.roomNumber = roomNumber;
        this.blockName = blockName;
        this.roomType = roomType;
    }

    // Getters and Setters (omitted for brevity)

    // Calculate total fee method
    public double calculateTotalFee() {
        double hostelFee = 0;

        // Calculate hostel fee based on blockName and roomType
        switch (blockName) {
            case 'A':
                hostelFee = roomType.equals("AC") ? 8000 : 60000;
                break;
            case 'B':
                hostelFee = roomType.equals("AC") ? 5000 : 50000;
                break;
            case 'C':
                hostelFee = roomType.equals("AC") ? 2500 : 40000;
                break;
            default:
                System.out.println("Invalid blockName");
                break;
        }

        // Calculate total amount
        if (roomType.equals("AC")) {
            return getCollegeFee() + hostelFee + 2500; // AC roomType has additional 2500
        } else {
            return getCollegeFee() + hostelFee;
        }
    }
}

class DayScholar extends Student {
    private int busNumber;
    private float distance;

    // Constructor
    public DayScholar(int studentId, String studentName, String department, String gender, String category, double collegeFee,
                      int busNumber, float distance) {
        super(studentId, studentName, department, gender, category, collegeFee);
        this.busNumber = busNumber;
        this.distance = distance;
    }

    // Getters and Setters (omitted for brevity)

    // Calculate total fee method
    public double calculateTotalFee() {
        double busFee = 0;

        // Calculate bus fee based on distance
        if (distance > 30 && distance <= 40) {
            busFee = 28000;
        } else if (distance > 20 && distance <= 30) {
            busFee = 20000;
        } else if (distance > 10 && distance <= 20) {
            busFee = 12000;
        } else if (distance <= 10) {
            busFee = 6000;
        }

        // Calculate total amount
        return getCollegeFee() + busFee;
    }
}

abstract class Student {
    protected int studentId;
    protected String studentName;
    protected String department;
    protected String gender;
    protected String category;
    protected double collegeFee;

    // Constructor (omitted for brevity)

    // Abstract method to calculate total fee
    public abstract double calculateTotalFee();
}
