import java.util.HashMap;

public class DeadLockTestDrive {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abba"));
        ;
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap();
            int windowLeft = 0;
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i)) && windowLeft <= map.get(s.charAt(i))) {
                    windowLeft = map.get(s.charAt(i));
                } else {
                    int target = i - windowLeft + 1;
                    result = Math.max(result, target);
                }
            }
            return result;
        }
    }
}

// class Transaction implements Runnable {
// private final String id;
// private final Account from;
// private final Account to;
// private final double amount;

// public Transaction(String id, Account from, Account to, double amount) {
// this.id = id;
// this.from = from;
// this.to = to;
// this.amount = amount;
// }

// @Override
// public void run() {
// synchronized (from) {
// from.withdraw(amount);
// try {
// Thread.sleep(500);
// } catch (InterruptedException e) {
// }
// synchronized (to) {
// to.deposit(amount);
// }
// }
// System.out.println(amount + "is transfered from " + from + " to " + to);
// Integer.MIN_VALUE
// }
// }

// class Account {
// private final String name;
// private double balance;

// public Account(String name) {
// this.name = name;
// }

// public void withdraw(double amount) {
// this.balance -= amount;
// }

// public void deposit(double amount) {
// this.balance += amount;
// }

// public double getBalance() {
// return this.balance;
// }

// @Override
// public String toString() {
// return name;
// }
// }
