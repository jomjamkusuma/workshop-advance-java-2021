package solid;

/**
 * 1. Transfer money in Thailand only
 * 2. Transfer money (International)
 */


public class DemoBank {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.transferMoney(1000);

    }

    private static class BankAccount {
        public void transferMoney(int amount){
            System.out.println("Transfer"+ amount);
        }
    }
}
