public class RyanAndMonicaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob ryanMonica = new RyanAndMonicaJob();
        Thread one = new Thread(ryanMonica);
        Thread two = new Thread(ryanMonica);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            // System.out.println(i + " running " + " money left : " +
            // account.getBalance());
            makeWithdrawMoney(10);
            if (account.getBalance() < 0) {
                System.out.println("OverDrwan!!");
            }
        }
    }

    private synchronized void makeWithdrawMoney(int amount) {
        if (account.getBalance() >= amount) {
            try {
                System.out.println(Thread.currentThread().getName() + " going to sleep !");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " Complete Withdraw !!");
        } else {
            System.out.println("Sorry not enough money for " + Thread.currentThread().getName());
        }
    }
}

class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int n) {
        balance -= n;
    }
}