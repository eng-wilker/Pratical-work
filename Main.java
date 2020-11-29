
/**
 * @author Wilker Martins(58535) Main class.
 */
import java.lang.System;
import java.util.Scanner;

public class Main {
    // constants
    public static final int BONUSADD = 1000;
    private static final int BONUSDEC = 2000;
    private static final String ROLETA = "roleta";
    private static final String PUZZLE = "puzzle";
    private static final String SAIR = "sair";
    private static final String PONTOS = "pontos";
    private static final String PAINEL = "painel";
    private static final String INVALIDCOMAND = "Comando invalido";
    private static final String ENDGAME = "O jogo terminou";
    private static final String INVALIDVALUE = "Valor invalido";
    private static final String INVALIDSTRING = "Letra invalida";
    private static final String GAMENOTCLOSED = "O jogo ainda nao tinha terminado";
    private static final String NOMONEY = "Parabens! Infelizmente nao ganhou dinheiro";

    public static void main(String[] args) {
        SystemLucky sys = new SystemLucky();
        Scanner input = new Scanner(System.in);
        addSecret(sys, input);
        addPlayer(sys, input);
        String comand = input.next();

        while (!comand.equals(SAIR)) {
            switch (comand) {
                case ROLETA:
                    spinTheRoulette(sys, input);
                    break;
                case PUZZLE:
                    tryToGuess(sys, input);
                    break;
                case PAINEL:
                    getPainel(sys, input);
                    break;
                case PONTOS:
                    getPoints(sys);
                    break;
                default:
                    System.out.println(INVALIDCOMAND);
                    input.nextLine();
            }
            comand = input.next();
        }
        input.close();
        closeGame(sys);
    }

    /**
     * add a player to game.
     * 
     * @param sys   system of lucky roullete.
     * @param input input class.
     */
    private static void addPlayer(SystemLucky sys, Scanner input) {
        String name = input.nextLine().trim();
        if (name.length() >= 1 && name.length() <= 40) {
            sys.addPerson(name);
        }

    }

    /**
     * add a secret to game.
     * 
     * @param sys   system of lucky roulette.
     * @param input input class.
     */
    private static void addSecret(SystemLucky sys, Scanner input) {
        String secret = input.nextLine().toLowerCase().trim();
        if (secret.length() >= 1 && secret.length() <= 100) {
            sys.addSecret(secret);
        }
    }

    /**
     * spin the roulette in game.
     * 
     * @param sys   system of lucky roulette.
     * @param input input class.
     */
    public static void spinTheRoulette(SystemLucky sys, Scanner input) {
        int value = input.nextInt();
        String temp = input.nextLine().trim();
        char character = temp.charAt(0);
        if (value > 0) {
            if ((Character.isLetter(character)) && (Character.isLowerCase(character)) && temp.length() == 1) {
                if (!sys.isGameAlreadyClosed()) {
                    if (!sys.CharacterAlreadyChosen(character)) {
                        if (sys.hasCharacter(temp)) {
                            sys.unlockCharacter(character);
                            sys.addBalance(value * sys.numberOfOcurrencesChar(character));
                        } else
                            sys.decBalance(value);
                    } else
                        sys.decBalance(value);
                } else
                    System.out.println(ENDGAME);
            } else
                System.out.println(INVALIDSTRING);
        } else
            System.out.println(INVALIDVALUE);
    }

    /**
     * try to unlock the secret.
     * 
     * @param sys   system of lucky roulette.
     * @param input input class.
     */
    public static void tryToGuess(SystemLucky sys, Scanner input) {
        String secret2 = input.nextLine().trim();
        if (!sys.isGameAlreadyClosed()) {
            if (secret2.length() >= 1 && secret2.length() <= 100) {
                if (sys.isTheSameSecret(secret2)) {
                    sys.addBalance(BONUSADD);
                } else {
                    sys.decBalance(BONUSDEC);
                }
            }
        } else
            System.out.println(ENDGAME);

    }

    /**
     * call the current painel
     * 
     * @param sys   system of lucky roulette.
     * @param input input class.
     */
    public static void getPainel(SystemLucky sys, Scanner input) {
        System.out.println(sys.getCurrentStateSecret());

    }

    /**
     * get the current points
     * 
     * @param sys system of lucky roulette.
     */
    public static void getPoints(SystemLucky sys) {
        System.out.println(sys.getName() + " tem " + sys.getBalance() + " pontos");
    }

    /**
     * method to close game and get the results.
     * 
     * @param sys system of lucky roulette.
     */
    public static void closeGame(SystemLucky sys) {
        if (sys.isGameAlreadyClosed()) {
            if (sys.getBalance() > 0) {
                System.out.println("Parabens! Ganhou " + sys.closeGame() + " euros");
            } else
                System.out.println(NOMONEY);
        } else
            System.out.println(GAMENOTCLOSED);
    }

}
