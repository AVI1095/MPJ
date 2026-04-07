/* Write a Java program to showcase the use of File I/O Exception Handling in Java

Write a menu-driven program for banking systems which accepts the personal
data for Customers(cid, cname, amount). Implement the user-defined/standard
exceptions, wherever required to handle the following situations:
1. Account should be created with a minimum amount of Rs. 1000.
2. For withdrawal of amount, if wth_amt>total amount.
3. cid should be in the specific range of 1 to 20.
4. Entered amount should be positive.
Store these records in file using suitable I/O classes */

import java.io.*;
import java.util.*;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class InvalidCIDException extends Exception {
    public InvalidCIDException(String msg) {
        super(msg);
    }
}

class Customer {
    int cid;
    String cname;
    double amount;

    Customer(int cid, String cname, double amount) {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }
}

public class lab4 {
    static final String FILE_NAME = "customers.txt";
    static Scanner sc = new Scanner(System.in);

    static void createAccount() {
        try {
            System.out.print("Enter Customer ID (1-20): ");
            int cid = sc.nextInt();
            sc.nextLine();

            if (cid < 1 || cid > 20) {
                throw new InvalidCIDException("CID must be between 1 and 20");
            }

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Initial Amount: ");
            double amount = sc.nextDouble();

            if (amount < 1000) {
                throw new InvalidAmountException("Min bal should be >= 1000");
            }

            if (amount < 0) {
                throw new InvalidAmountException("Amount cannot be negative");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));
            bw.write(cid + "," + name + "," + amount);
            bw.newLine();
            bw.close();

            System.out.println("Account Created");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void display() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("\n--- Customer Records ---");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("CID: " + data[0] + " Name: " + data[1] + " Balance: " + data[2]);
            }
            br.close();

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    static void withdraw() {
        try {
            System.out.print("Enter CID: ");
            int cid = sc.nextInt();

            System.out.print("Enter Withdrawal Amount: ");
            double w_amt = sc.nextDouble();

            if (w_amt < 0) {
                throw new InvalidAmountException("Amount must be positive");
            }

            File inputFile = new File(FILE_NAME);
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int fileCid = Integer.parseInt(data[0]);
                double balance = Double.parseDouble(data[2]);

                if (fileCid == cid) {
                    found = true;

                    if (w_amt > balance) {
                        throw new InsufficientBalanceException("Insufficient balance");
                    }

                    balance -= w_amt;
                    bw.write(fileCid + "," + data[1] + "," + balance);
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found) {
                System.out.println("Withdraw successful");
            } else {
                System.out.println("Cust not found");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nBANK MENU");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Display Records");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}