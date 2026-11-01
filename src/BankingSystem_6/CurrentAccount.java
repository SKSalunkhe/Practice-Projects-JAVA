package BankingSystem_6;

public class CurrentAccount extends Account{
    private static final double OVERDRAFT_Limit = 1000.0;

    public CurrentAccount(long accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount > balance + OVERDRAFT_Limit){
            throw new InsufficientFundsException("Overdraft limit of \" + OVERDRAFT_Limit + \" execeded.");
            //System.out.println("Overdraft limit of " + OVERDRAFT_Limit + " execeded.");
        }
        super.withdraw(amount);
    }
}
