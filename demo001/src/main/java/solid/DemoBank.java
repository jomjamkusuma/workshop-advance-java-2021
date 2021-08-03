package solid;

/**
 * 1. Transfer money in Thailand only
 * 2. Transfer money (International)
 */


public class DemoBank {
    public static void main(String[] args) {
        TransferMoneyProcess interBankAccount = new InterBankAccount();
        TransferMoneyProcess localBankAccount = new LocalBankAccount();
        interBankAccount.transferMoney(1000);
        localBankAccount.transferMoney(2000);

    }

    interface TransferMoneyProcess { void transferMoney(int amount); }

    private static class InterBankAccount implements TransferMoneyProcess{
        public void transferMoney(int amount){
            System.out.println("Transfer International");
        }
    }
    private static class LocalBankAccount implements TransferMoneyProcess {
        public void transferMoney(int amount){
            System.out.println("Transfer Local");
        }
    }
}
