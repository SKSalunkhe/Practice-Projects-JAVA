package BankingSystem_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankingSystem {

    static List<Account> accounts = new ArrayList<>();
    static int nextAccountNumber = 1001;


    static Account findAccount(int number){
        for(Account a : accounts){
            if(a.getAccountNumber() == number){
                return a;
            }
        }
        return null;
    }

    static Account askForAccount(Scanner sc){
        System.out.println("Enter AC number : ");
        int number = sc.nextInt();
        Account acc = findAccount(number);
        if (acc == null){
            System.out.println("Account not found");
        }
        return acc;
    }

    static void createAccount(Scanner sc){
        System.out.println("Enter Account Holder Name : " );
        String name = sc.nextLine();
        System.out.println("Type (1 = Savings , 2 = Current )");
        int type = sc.nextInt();
        System.out.println("Opening balance");
        double amount = sc.nextDouble();

        Account acc;
        if(type == 1){
            acc = new SavingsAccount(nextAccountNumber, name, amount);
        } else if (type == 2) {
            acc = new CurrentAccount(nextAccountNumber, name, amount);
        }else{
            System.out.println("Invalid Account type...");
            return;
        }

        accounts.add(acc);
        System.out.println("Account  created." +
                " Account number : " + nextAccountNumber);
        nextAccountNumber++;
    }

    static void depositMoney(Scanner sc)throws InsufficientFundsException {
        Account acc = askForAccount(sc);
        if(acc == null){return;}
        System.out.println("Amount to deposit : ");
        acc.deposit(sc.nextDouble());
        System.out.println("Deposited. New balance : " + acc.getBalance());
    }

    static void withdrawMoney(Scanner sc)throws InsufficientFundsException {
        Account acc = askForAccount(sc);
        if(acc == null) return;
        System.out.println("Amount to withdraw : ");
        acc.withdraw(sc.nextDouble());
        System.out.println("Amount withdrawn. New Balance : " + acc.getBalance());
    }

    static void showBalance(Scanner sc){
        Account acc = askForAccount(sc);
        if(acc == null) return;
        System.out.println(acc.getHolderName() + " | Balance : " + acc.getBalance());
    }

    static void showHistory(Scanner sc){
        Account acc = askForAccount(sc);
        if(acc == null ) return;
        acc.showHistory();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do{
            System.out.println("  ");
            System.out.println("/---- Banking System ----/");
            System.out.println("1. Create AC ");
            System.out.println("2. Deposit Money ");
            System.out.println("3. Withdraw Money ");
            System.out.println("4. View Balance ");
            System.out.println("5. Transaction History ");
            System.out.println("6. Exit ");
            System.out.println("Choice : ");

            try{
                choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1 : createAccount(sc); break;
                    case 2 : depositMoney(sc); break;
                    case 3 : withdrawMoney(sc); break;
                    case 4 : showBalance(sc); break;
                    case 5 : showHistory(sc); break;
                    case 6 :
                        System.out.println("GoodByeee..."); break;
                    default :
                        System.out.println("Invalid choice..");
                }
            }catch (InsufficientFundsException e){
                System.out.println("Transaction failed : " + e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Error : " + e.getMessage());
            }catch(InputMismatchException e){
                System.out.println("Imvalid input, Enter only numbers where needed.");
                sc.nextInt();
                choice = 0;
            }
        }while(choice != 6);
        sc.close();
    }
}
