public class TestSyncDrive implements Runnable {
    private int balance;

    public static void main(String[] args) {
        TestSyncDrive job = new TestSyncDrive();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }

    public void increment() {
        int i = balance;
        balance = i + 1;
        // synchronized (this) {
        // balance = i + 1;
        // }
    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("Balance is " + balance);
        }
    }
}
