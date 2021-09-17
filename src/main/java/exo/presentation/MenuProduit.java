package exo.presentation;

import exo.business.ProduitService;
import exo.business.ProduitServiceImpl;
import exo.dto.ProduitDTO;
import exo.exception.ProduitNotFoundException;

import java.util.Scanner;

public class MenuProduit {

    private final Scanner sc = new Scanner(System.in);
    private final ProduitService service = new ProduitServiceImpl();

    public void start(){

        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt( sc.nextLine() );
            mapChoix(choix);
        }while( choix != 6);

    }

    private void displayMenu() {
        System.out.println("--- MENU PRODUIT ---");
        System.out.println("1 - afficher tout");
        System.out.println("2 - afficher un");
        System.out.println("3 - ajouter");
        System.out.println("4 - supprimer");
        System.out.println("5 - modifier");
        System.out.println("6 - quitter");
    }
    private void mapChoix(int choix){
        switch (choix) {
            case 1:
                displayAll();
                break;
            case 2:
                displayOne();
                break;
            case 3:
                add();
                break;
            case 4:
                delete();
                break;
            case 5:
                update();
                break;
            case 6:
                quit();
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    private void displayAll(){
        System.out.println("----- TOUT LES PRODUITS -----");
        service.getAll().forEach(System.out::println);
    }
    private void displayOne(){
        System.out.print("id du produit : ");
        int id = Integer.parseInt( sc.nextLine() );

        try{
            System.out.println( service.getOne(id) );
        }
        catch (ProduitNotFoundException ex){
            System.out.println("Le produit n'a pas été trouvé");
        }
    }
    private void add(){
        ProduitDTO.ProduitDTOBuilder builder = ProduitDTO.builder();

        System.out.print("marque du produit : ");
        builder.marque( sc.nextLine() );
        System.out.print("nom du produit : ");
        builder.nom( sc.nextLine() );
        System.out.print("prix du produit : ");
        builder.prix( Double.parseDouble(sc.nextLine()) );

        service.insert(builder.build());
    }
    private void delete(){
        System.out.print("id du produit : ");
        int id = Integer.parseInt( sc.nextLine() );

        try{
            System.out.println("Tentative de suppression");
            System.out.println( service.delete(id) );
            System.out.println("Le produit a bien été supprimé");
        }
        catch (ProduitNotFoundException ex){
            System.out.println("Le produit n'a pas été trouvé");
        }
    }
    private void update(){
        ProduitDTO.ProduitDTOBuilder builder = ProduitDTO.builder();

        System.out.print("id du produit : ");
        builder.id( Integer.parseInt(sc.nextLine()) );
        System.out.print("marque du produit : ");
        builder.marque( sc.nextLine() );
        System.out.print("nom du produit : ");
        builder.nom( sc.nextLine() );
        System.out.print("prix du produit : ");
        builder.prix( Double.parseDouble(sc.nextLine()) );

        try{
            System.out.println("Tentative d'update");
            service.update(builder.build());
            System.out.println("Update réussi");
        }catch (ProduitNotFoundException ex){
            System.out.println("L'élément a modifier n'existe pas");
        }

    }
    private void quit(){
        System.out.println("Au revoir!");
    }

}
