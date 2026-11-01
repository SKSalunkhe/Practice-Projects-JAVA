package BankingSystem_5;

import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
public class Account{
    protected long accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> history = new ArrayList<>();

    public Account(long accountNumber, String holderName, double initialBalance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        history.add("Account opened with : " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount <= 0){
            throw new IllegalArgumentException("Deposit has to greater than 0.");
            //System.out.println("Deposit has to greater than 0.");
        }
        balance += amount;
        history.add("Deposit  : " + amount + " added" + "|| Balance :" + balance);
    }

    public void withdraw (double amount) throws InsufficientFundsException{
        if(amount <= 0){
            throw new IllegalArgumentException("Amount to be withdrawn has to be greater than 0.");
            //System.out.println("Amount to be withdrawn has to be greater than 0.");
        }
        if(amount > balance){
            throw new InsufficientFundsException("Not enough balance.");
            //System.out.println("Not enough balance.");
        }
        balance -= amount;
        history.add("Withdrawn :" + amount + " | Balance : " + balance);
    }

    public long getAccountNumber(){

        return accountNumber;
    }
    public String getHolderName(){

        return holderName;
    }
    public double getBalance(){

        return balance;
    }

    public void showHistory(){
        System.out.println("---     History for AC : " + accountNumber + "     ---");
        for(String h : history){
            System.out.println(h);
        }
    }
}
