package v3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean done = false;

        while (!done) {
            if (showMenu("main")) {
                String option = scanner.nextLine();
                done = handleMainMenuOption(option);
            } else {
                done = true;
            }
        }
    }

    private static Map<String, String> menuStrings = new HashMap<>();

    public static boolean showMenu(String name) {
        if (!menuStrings.containsKey(name)) {
            try {
                String menuPath = "menu/" + name + ".txt";
                byte[] menuBytes = Files.readAllBytes(Paths.get(menuPath));
                menuStrings.put(name, new String(menuBytes));
            } catch (IOException e) {
                System.err.println("Error reading menu content: " + e.getMessage());
                return false;
            }
        }
        System.out.println(menuStrings.get(name));
        return true;
    }

    public static boolean handleMainMenuOption(String option) {
        switch (option) {
            case "1":
                handleMainMenuCase1();
                break;
            case "2":
                handleMainMenuCase2();
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

    private static void handleMainMenuCase1() {
        System.out.println("Vous avez choisi l'option 1 !");
        if (showMenu("sub")) {
            String option = scanner.nextLine();
            // ignore la valeur de retour parce que le sous-menu est exécuté une seule fois, pas de boucle ici ;
            // on pourrait utiliser la valeur de retour pour déterminer si une option valide a été sélectionnée
            // ou non
            handleSubMenuOption(option);
        }
    }

    private static void handleMainMenuCase2() {
        System.out.println("Vous avez choisi l'option 2 !");
        boolean done = false;
        while (!done) {
            if (showMenu("sub")) {
                String option = scanner.nextLine();
                done = handleSubMenuOption(option);
            } else {
                done = true;
            }
        }
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