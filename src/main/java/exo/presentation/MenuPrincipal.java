package exo.presentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuPrincipal implements Menu {

    private final Map<String, Menu> menus;
    private final Scanner sc = new Scanner(System.in);

    public MenuPrincipal() {
        this.menus = new HashMap<>();
        menus.put("categorie", new MenuCategorie());
        menus.put("produit", new MenuProduit());
        menus.put("client", new MenuClient());
        menus.put("commande", new MenuCommande());
    }

    public void start(){

        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt( sc.nextLine() );
            mapChoix(choix);
        }while( choix != 5);

    }

    private void displayMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1 - produit");
        System.out.println("2 - categorie");
        System.out.println("3 - client");
        System.out.println("4 - commande");
        System.out.println("5 - quitter");
    }
    private void mapChoix(int choix){
        switch (choix) {
            case 1 -> menus.get("produit").start();
            case 2 -> menus.get("categorie").start();
            case 3 -> menus.get("client").start();
            case 4 -> menus.get("commande").start();
            case 5 -> quit();
            default -> System.out.println("Choix invalide");
        }
    }
    private void quit(){
        System.out.println("Au revoir!");
    }
}
