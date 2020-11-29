/**
 * @author Wilker Martins(58535) this class is a player class.
 */
public class Person {
    // instante variables
    private String name;
    private int balance;

    // construtor
    public Person(String name) {
        this.name = name;
        balance = 0;
    }

    /**
     * Adds a given amount to the contents of the wallet.
     * 
     * @param amount quantity in euros to be added.
     */
    public void addBalance(int amount) {
        balance += amount;
    }

    /**
     * Dec a given amount to the contents of the wallet.
     * 
     * @param amount quantity in euros to be dec.
     */
    public void decBalance(int amount) {
        balance -= amount;
    }

    /**
     * give the current balance.
     * 
     * @return current balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Get the player name
     * 
     * @return name of player.
     */
    public String getName() {
        return name;
    }
}
