import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many customers do you want to input?");
        int noCust = sc.nextInt();
        sc.nextLine(); // consume the newline character
        Banking[] C = new Banking[noCust];
        for (int i = 0; i < C.length; i++) {
            C[i] = new Banking();
            C[i].openAccount();
        }

        int ch;
        do {
            System.out.println("Welcome to the banking system application");
            System.out.println("1. Display all your account details\n2. Search account by Account #\n3. Deposit an amount\n4. Withdraw an amount\n5. Exit");
            System.out.println("Please enter your choice");
            ch = sc.nextInt();
            sc.nextLine(); // consume the newline character
            switch (ch) {
                case 1:
                    for (Banking banking : C) {
                        banking.showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String accNo = sc.nextLine();
                    boolean found = false;
                    for (Banking banking : C) {
                        found = banking.search(accNo);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no.: ");
                    accNo = sc.nextLine();
                    found = false;
                    for (Banking banking : C) {
                        found = banking.search(accNo);
                        if (found) {
                            banking.deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No.: ");
                    accNo = sc.nextLine();
                    found = false;
                    for (Banking banking : C) {
                        found = banking.search(accNo);
                        if (found) {
                            banking.withdrawal();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 5:
                    System.out.println("See you soon...");
                    break;
            }
        } while (ch != 5);
    }
}
