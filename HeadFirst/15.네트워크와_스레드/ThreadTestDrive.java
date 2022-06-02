public class ThreadTestDrive {
    public static void main(String[] args) {
        Runnable threJob = new MyRunnable();
        Thread myThread = new Thread(threJob);
        myThread.start();
        System.out.println("bak in main");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println("top o the stack");
    }
}
