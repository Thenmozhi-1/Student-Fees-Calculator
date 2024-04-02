public class Hosteller extends Student {
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

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public char getBlockName() {
        return blockName;
    }

    public void setBlockName(char blockName) {
        this.blockName = blockName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

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
            return collegeFee + hostelFee + 2500; // AC roomType has additional 2500
        } else {
            return collegeFee + hostelFee;
        }
    }
}
