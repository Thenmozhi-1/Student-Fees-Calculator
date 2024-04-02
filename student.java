public abstract class Student {
    protected int studentId;
    protected String studentName;
    protected String department;
    protected String gender;
    protected String category;
    protected double collegeFee;

    // Constructor
    public Student(int studentId, String studentName, String department, String gender, String category, double collegeFee) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.gender = gender;
        this.category = category;
        this.collegeFee = collegeFee;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCollegeFee() {
        return collegeFee;
    }

    public void setCollegeFee(double collegeFee) {
        this.collegeFee = collegeFee;
    }

    // Abstract method to calculate total fee
    public abstract double calculateTotalFee();
}
