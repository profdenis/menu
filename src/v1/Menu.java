package v1;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        boolean done = false;
        while (!done) {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            done = handleOption(option);
        }
    }

    public static void showMenu() {
        System.out.println("Choisissez une option :");
        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Quitter");
    }

    public static boolean handleOption(String option) {
        switch (option) {
            case "1":
                System.out.println("Vous avez choisi l'option 1 !");
                break;
            case "2":
                System.out.println("Vous avez choisi l'option 2 !");
                break;
            case "3":
                System.out.println("Vous avez choisi l'option 3 !");
                break;
            case "4":
                System.out.println("Vous voulez quitter !");
                return true;
            default:
                System.out.println("Option invalide. SVP choisir une option valide.");
        }
        return false;
    }
}