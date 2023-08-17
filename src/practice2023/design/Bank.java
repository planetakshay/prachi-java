package practice2023.design;

/**
 * https://leetcode.com/problems/simple-bank-system/
 */
public class Bank {

    private final long[] balances;

    public Bank(long[] balance) {
        this.balances = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValid(account1) || !isValid(account2)) {
            System.out.println("Sorry, Both account1 and account 2 must be valid account numbers.");
            return false;
        }
        int fromAccount = account1 - 1;
        int toAccount = account2 - 1;
        if (balances[fromAccount] >= money) {
            balances[toAccount] += money;
            balances[fromAccount] -= money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        int toAccount = account - 1;
        balances[toAccount] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        int fromAccount = account - 1;
        if (balances[fromAccount] >= money) {
            balances[fromAccount] -= money;
            return true;
        }
        return false;
    }

    public boolean isValid(int account) {
        int byIndex = account - 1;
        return byIndex >= 0 && byIndex < balances.length;
    }
}
