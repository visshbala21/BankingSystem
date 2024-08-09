import java.util.Scanner;

public class Banking {
    private String accNo;
    private String accoType;
    private String name;
    private long balance;
    Scanner sc = new Scanner(System.in);

    public void openAccount() {
        System.out.println("Please enter your account #");
        accNo = sc.nextLine();
        System.out.println("Please enter your account type");
        accoType = sc.nextLine();
        System.out.println("Please type your legal name");
        name = sc.nextLine();
        while (true) {
            System.out.println("What is your bank balance?");
            if (sc.hasNextLong()) {
                balance = sc.nextLong();
                sc.nextLine(); // consume the newline character
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the balance.");
                sc.next(); // clear the invalid input
            }
        }
    }

    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account number: " + accNo);
        System.out.println("Account type is: " + accoType);
        System.out.println("The remaining balance in your account is: " + balance);
    }

    public void deposit() {
        long amt;
        while (true) {
            System.out.println("Please enter the amount of money you would like to deposit");
            if (sc.hasNextLong()) {
                amt = sc.nextLong();
                balance += amt;
                System.out.println("Your balance is now: " + balance);
                sc.nextLine(); // consume the newline character
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the amount.");
                sc.next(); // clear the invalid input
            }
        }
    }

    public void withdrawal() {
        long amt;
        while (true) {
            System.out.println("Please enter the amount of money you would like to withdraw");
            if (sc.hasNextLong()) {
                amt = sc.nextLong();
                if (amt > balance) {
                    System.out.println("Your balance is less than your current amount, transaction failed");
                } else {
                    balance -= amt;
                    System.out.println("Your balance is now: " + balance);
                }
                sc.nextLine(); // consume the newline character
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number for the amount.");
                sc.next(); // clear the invalid input
            }
        }
    }

    public boolean search(String ac_no) {
        if (accNo.equals(ac_no)) {
            showAccount();
            return true;
        }
        return false;
    }
}
