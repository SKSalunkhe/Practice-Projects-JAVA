package BankingSystem_6;

public class SavingsAccount extends Account{
    private static final double MIN_Balance = 500.0;

    public SavingsAccount(long accountNumber, String holderName, double initialBalance){
        super( accountNumber, holderName, initialBalance);
        if (initialBalance < MIN_Balance){
            throw new IllegalArgumentException("Savings account needs balance more than "+ MIN_Balance + " to open.");
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount > balance){
            throw new InsufficientFundsException("Savings AC shud keep min balance of "+ MIN_Balance);
            //System.out.println("Savings AC should keep min balance of "+ MIN_Balance);
        }
        super.withdraw(amount);
    }

}
