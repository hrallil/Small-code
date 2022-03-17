public class App {
    public static void main(String[] args) throws Exception {
        SavingsAccount savings = new SavingsAccount("Trump", 101, 1000000, 0.02);
        savings.addIntrest();
        System.out.println("There is: $" + savings.getBalance() + " on your account");
        CheckingAccount checking = new CheckingAccount("Trump", 102, 100, savings);
        checking.writeCheck(1000);
        System.out.println("There is: $" + savings.getBalance() + " on your savings account");
        System.out.println("There is: $" + checking.getBalance() + " on your checkings account");
    }
}


class BankAccount{
    double balance;
    String owner;
    int accountID;
    public BankAccount(String owner, int accountID, double balance){
        this.owner = owner;
        this.accountID = accountID;
        this.balance = balance;

    }

    public double getBalance() {
        return balance;
    }

    public void makeDeposit(double deposit) {
        balance += deposit;
    }

    public boolean makeWithdrawl(double withdrawl) {
        if (withdrawl<= balance) {
            balance -= withdrawl;
            return true;
        }else{
            return false;
        } 
    }

    public int getAccountID() {
        return accountID;
    }

    public String getOwner() {
        return owner;
    }

}

class SavingsAccount extends BankAccount{
    double intrestRate;
    public SavingsAccount(String owner, int accountID, double balance, double intrestRate){
        super(owner, accountID, balance); //what is this????
        this.intrestRate = intrestRate; 
    }
    public void addIntrest() {
        balance += balance * intrestRate;
    }
}

class CheckingAccount extends BankAccount{
    SavingsAccount overdraftAccount;
    public CheckingAccount(String owner, int accountID, double balance, SavingsAccount OD){
        super(owner, accountID, balance); //reference to parent class??
        this.overdraftAccount = OD;
    }
    public boolean writeCheck(double amount){
        boolean makeCheck = false;
        if(super.makeWithdrawl(amount)){
            makeCheck = true;
        }else if (overdraftAccount.makeWithdrawl(amount - balance)){
            balance = 0;
            makeCheck = true;
        }
        return makeCheck;
    }

}