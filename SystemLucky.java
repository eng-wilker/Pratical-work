/**
 * @author Wilker Martins(58535) this class is the system of lucky roulette.
 */
public class SystemLucky {
    // instant valiables
    private Person person;
    private Secret secret;

    // construtor
    public SystemLucky() {
        person = null;
        secret = null;

    }

    /**
     * adds a new player to game.
     * 
     * @param name name of new player.
     */
    public void addPerson(String name) {
        this.person = new Person(name);
    }

    /**
     * adds a new secret to game.
     * 
     * @param secret the new secret.
     */
    public void addSecret(String secret) {
        this.secret = new Secret(secret);
    }

    /**
     * Adds a given amount to balance.
     * 
     * @param amount amount quantity, in euros to be added to the wallet.
     */
    public void addBalance(int amount) {
        person.addBalance(amount);

    }

    /**
     * Dec a given amount to balance.
     * 
     * @param amount quantity, in euros to be dec to the wallet.
     */
    public void decBalance(int amount) {
        person.decBalance(amount);

    }

    /**
     * unlock a character in a locksecret instant variable.
     * 
     * @param character character to be unlocked.
     */
    public void unlockCharacter(char character) {
        secret.unlockCharacter(character);

    }

    /**
     * this method return the secret of game.
     * 
     * @return the secret.
     */

    public String getSecret() {
        return secret.getSecret();
    }

    /**
     * this method retun the player name.
     * 
     * @return the name of player.
     */
    public String getName() {
        return person.getName();
    }

    /**
     * this method retunr the current state of lockSecret.
     * 
     * @return the current state of lockSecret.
     */
    public char[] getCurrentStateSecret() {
        return secret.getLockSecret();
    }

    /**
     * this method verify if has character in the secret.
     * 
     * @param character character to be tested.
     * @return true if has character in secret, and false if hasnt.
     */
    public boolean hasCharacter(String character) {
        return secret.hasCharacter(character);
    }

    /**
     * this method compare if the current lockSecret is iqual to the secret.
     * 
     * @return true if game is finished, false if isnt.
     */
    public boolean isGameAlreadyClosed() {
        boolean temp = false;
        for (int i = 0; i < secret.getLockSecret().length; i++) {
            if (secret.getLockSecret()[i] == secret.getSecret().toCharArray()[i]) {
                temp = true;
            } else {
                temp = false;
                return temp;
            }
        }
        return temp;
    }

    /**
     * compare if secret2 iqual game secret.
     * 
     * @param secret2 secret to be tested.
     * @return true if secret2 is iqual to game secret, false if isnt.
     */
    public boolean isTheSameSecret(String secret2) {
        return secret.isTheSameSecret(secret2);
    }

    /**
     * verify if character is already chosen by player.
     * 
     * @param character character to be tested.
     * @return true if character is already chosen and false if isnt.
     */
    public boolean CharacterAlreadyChosen(char character) {
        return secret.hasCharacterAlreadyChosen(character);
    }

    /**
     * get player balance.
     * 
     * @return player balance.
     */
    public int getBalance() {
        return person.getBalance();
    }

    /**
     * get number of ocurrence of character in game secret.
     * 
     * @param character to be tested
     * @return the number of ocurrence of character in game secret.
     */
    public int numberOfOcurrencesChar(char character) {
        return secret.numberOfOcurrencesChar(character);
    }

    /**
     * return the final player balance in game.
     * 
     * @return the final balance of player in game.
     */
    public int closeGame() {
        if (person.getBalance() <= 0) {
            return 0;
        } else {
            return person.getBalance();
        }
    }
}
