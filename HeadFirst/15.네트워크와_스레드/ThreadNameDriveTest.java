public class ThreadNameDriveTest implements Runnable {
    public static void main(String[] args) {
        ThreadNameDriveTest runner = new ThreadNameDriveTest();
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        alpha.setName("1번 스레드 굴러가욧!");
        beta.setName("2번 스레드 굴러가욧!");
        alpha.start();
        beta.start();
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running ");
        }
    }
}
