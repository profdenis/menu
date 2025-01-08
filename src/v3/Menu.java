package complex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        boolean done = false;
        while (!done) {
            showMenu("main");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            done = handleMainMenuOption(option);
        }
    }

    private static Map<String, String> menuStrings = new HashMap<>();

    public static void showMenu(String name) {
        if (!menuStrings.containsKey(name)) {
            try {
                System.out.println("Reading menu content from file: " + name);
                String menuPath = "menu/" + name + ".txt";
                byte[] menuBytes = Files.readAllBytes(Paths.get(menuPath));
                menuStrings.put(name, new String(menuBytes));
            } catch (IOException e) {
                System.err.println("Error reading menu content: " + e.getMessage());
                System.exit(1); // Exit on error
            }
        }
        System.out.println(menuStrings.get(name));
    }

    public static boolean handleMainMenuOption(String option) {
        Scanner scanner = new Scanner(System.in);
        String subOption;

        switch (option) {
            case "1":
                System.out.println("Vous avez choisi l'option 1 !");
                showMenu("sub");
                subOption = scanner.nextLine();
                // ignore la valeur de retour parce que le sous-menu est exécuté une seule fois
                handleSubMenuOption(subOption);
                break;
            case "2":
                System.out.println("Vous avez choisi l'option 2 !");
                boolean done = false;
                while (!done) {
                    showMenu("sub");
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