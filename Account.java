 public class Account {
    private double funds;

    public Account(double initialFunds) {
        this.funds = initialFunds;
    }

    public double getFunds() {
        return funds;
    }

    public void addFunds(double amount) {
        if (amount > 0) {
            this.funds += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void subtractFunds(double amount) {
        if (amount > 0 && amount <= funds) {
            this.funds -= amount;
        } else if (amount > funds) {
            System.out.println("Insufficient funds for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
