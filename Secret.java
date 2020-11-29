/**
 * @author Wilker Martins(58535) this class is save the game secret.
 */
public class Secret {
    // instant valiables
    private String secret;
    private char[] lockSecret;

    // construtor
    public Secret(String secret) {
        this.secret = secret;
        lockSecret = secret.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            if (Character.isLetter(lockSecret[i])) {
                lockSecret[i] = '-';
            }
        }

    }

    /**
     * this method verify if has character in the secret.
     * 
     * @param character character to be tested.
     * @return true if has character in secret, and false if hasnt.
     */
    public boolean hasCharacter(String character) {
        return secret.contains(character);
    }

    /**
     * verify if character is already chosen by player.
     * 
     * @param character character to be tested.
     * @return true if character is already chosen and false if isnt.
     */
    public boolean hasCharacterAlreadyChosen(char character) {
        boolean temp = false;
        for (int i = 0; i < lockSecret.length; i++) {
            if (lockSecret[i] == character) {
                lockSecret[i] = character;
                temp = true;
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
        if (this.secret.equals(secret2)) {
            lockSecret = secret.toCharArray();
            return true;
        } else {
            return false;
        }

    }

    /**
     * this method return the secret of game.
     * 
     * @return the secret.
     */
    public String getSecret() {
        return secret;
    }

    /**
     * this method retunr the current state of lockSecret.
     * 
     * @return the current state of lockSecret.
     */
    public char[] getLockSecret() {
        return lockSecret;
    }

    /**
     * unlock a character in a locksecret instant variable.
     * 
     * @param character character to be unlocked.
     */
    public void unlockCharacter(char character) {
        char[] temp = secret.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == character) {
                lockSecret[i] = character;
            }
        }
    }

    /**
     * get number of ocurrence of character in game secret.
     * 
     * @param character to be tested
     * @return the number of ocurrence of character in game secret.
     */
    public int numberOfOcurrencesChar(char character) {
        char[] temp = secret.toCharArray();
        int total = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == character) {
                total++;
            }
        }
        return total;
    }
}
