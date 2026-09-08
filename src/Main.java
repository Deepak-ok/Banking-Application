public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Deepak", 5000.00);

        BankingApp bankingApp = new BankingApp(account);
        bankingApp.start();
    }
}
