class Employee {
    int salary;

    void displaySalary() {
        System.out.println(salary);
    }
}

class FullTimeEmployee extends Employee {

    void calculateSalary() {
        System.out.println("For Full Time Employee (50% Hike):");
        System.out.print("Salary Before Hike: ");
        displaySalary();

        salary = salary + (salary / 2);
        System.out.print("Salary After Hike: ");
        displaySalary();
        System.out.println();
    }
}

class InternEmployee extends Employee {

    void calculateSalary() {
        System.out.println("For Intern Employee (25% Hike):");
        System.out.print("Salary Before hike: ");
        displaySalary();

        
        salary = salary + (salary / 4);

        System.out.print("Salary After hike: ");
        displaySalary();
        System.out.println();
    }
}
public class lab2 {
    public static void main(String[] args) {
        FullTimeEmployee ft = new FullTimeEmployee();
        ft.salary = 5000;
        ft.calculateSalary();
        InternEmployee i = new InternEmployee();
        i.salary = 2000;
        i.calculateSalary();
    }
}