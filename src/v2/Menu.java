package v2;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        boolean done = false;
        while (!done) {
            showMainMenu();
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            done = handleMainMenuOption(option);
        }
    }

    public static void showMainMenu() {
        System.out.println("Choisissez une option :");
        System.out.println("1. Sous-menu (1 fois)");
        System.out.println("2. Sous-menu (boucle)");
        System.out.println("3. Option 3");
        System.out.println("4. Quitter");
    }

    public static void showSubMenu() {
        System.out.println("Choisissez une option :");
        System.out.println("a. Option a");
        System.out.println("b. Option b");
        System.out.println("c. Option c");
        System.out.println("d. Quitter");
    }

    public static boolean handleMainMenuOption(String option) {
        Scanner scanner = new Scanner(System.in);
        String subOption;

        switch (option) {
            case "1":
                System.out.println("Vous avez choisi l'option 1 !");
                showSubMenu();
                subOption = scanner.nextLine();
                // ignore la valeur de retour parce que le sous-menu est exécuté une seule fois, pas de boucle ici ; on
                // pourrait utiliser la valeur de retour pour déterminer si une option valide a été sélectionnée ou non
                handleSubMenuOption(subOption);
                break;
            case "2":
                // plusieurs lignes de code dans un seul bloc case, probablement mieux de les extraire dans une méthode
                System.out.println("Vous avez choisi l'option 2 !");
                boolean done = false;
                while (!done) {
                    showSubMenu();
                    subOption = scanner.nextLine();
                    done = handleSubMenuOption(subOption);
                }
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

    public static boolean handleSubMenuOption(String option) {
        switch (option) {
            case "a":
                System.out.println("Vous avez choisi l'option a !");
                break;
            case "b":
                System.out.println("Vous avez choisi l'option b !");
                break;
            case "c":
                System.out.println("Vous avez choisi l'option c !");
                break;
            case "d":
                System.out.println("Vous voulez quitter le sous-menu!");
                return true;
            default:
                System.out.println("Option invalide. SVP choisir une option valide.");
        }
        return false;
    }
}