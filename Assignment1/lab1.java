class Student {
    public String name;
    private int rollNo;
    protected String department;
    String college;

    Student() {
        college = "ABC Engineering College";
        department = "CSE";
    }

    Student(String n, int r) {
        this();
        this.name = n;
        this.rollNo = r;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }

    public void showCollege() {
        System.out.println("College: " + college);
    }

    protected void showDepartment() {
        System.out.println("Department: " + department);
    }
}

public class lab1 {
    public static void main(String[] args) {
        Student s1 = new Student("Aditya", 101);
        s1.displayInfo();
        s1.showCollege();
        s1.showDepartment();
    }
}
