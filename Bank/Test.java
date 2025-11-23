import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        teest r = new teest();
        int choice = -1;

        do {
            System.out.println("\nplease Enter 1 for Credit");
            System.out.println("please Enter 2 for Debit");
            System.out.println("please Enter 3 for View Balance");
            System.out.println("please Enter 4 for Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number for choice.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to credit: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Enter a valid integer amount.");
                        sc.next();
                        break;
                    }
                    int amount1 = sc.nextInt();
                    r.crediteblns(amount1);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Enter a valid integer amount.");
                        sc.next();
                        break;
                    }
                    int amount2 = sc.nextInt();
                    r.debitblns(amount2);
                    break;

                case 3:
                    System.out.println("Available Balance: " + r.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid option! Choose 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }
}

class teest {
    private int balance;

    public void crediteblns(int amount) {
        if (amount <= 0) {
            System.out.println("Enter positive amount to credit.");
            return;
        }
        balance += amount;
        System.out.println("Credited --> " + amount);
        System.out.println("Available Balance --> " + balance);
    }

    public void debitblns(int amount) {
        if (amount <= 0) {
            System.out.println("Enter positive amount to withdraw.");
            return;
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Debited --> " + amount);
            System.out.println("Available Balance --> " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}
