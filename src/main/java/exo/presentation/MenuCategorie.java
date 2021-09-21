package exo.presentation;

import exo.business.service.impl.CategorieServiceImpl;
import exo.business.service.impl.ProduitServiceImpl;
import exo.business.service.spec.CategorieService;
import exo.business.service.spec.ProduitService;
import exo.dto.CategorieDTO;
import exo.dto.ProduitDTO;
import exo.exception.ElementNotFoundException;

import java.util.Scanner;

public class MenuCategorie implements Menu{


    private final Scanner sc = new Scanner(System.in);
    private final CategorieService service = new CategorieServiceImpl();

    public void start(){

        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt( sc.nextLine() );
            mapChoix(choix);
        }while( choix != 6);

    }

    private void displayMenu() {
        System.out.println("--- MENU CATEGORIE ---");
        System.out.println("1 - afficher tout");
        System.out.println("2 - afficher un");
        System.out.println("3 - ajouter");
        System.out.println("4 - supprimer");
        System.out.println("5 - modifier");
        System.out.println("6 - quitter");
    }
    private void mapChoix(int choix){
        switch (choix) {
            case 1 -> displayAll();
            case 2 -> displayOne();
            case 3 -> add();
            case 4 -> delete();
            case 5 -> update();
            case 6 -> quit();
            default -> System.out.println("Choix invalide");
        }
    }

    private void displayAll(){
        System.out.println("----- TOUTES LES CATEGORIES -----");
        service.getAll().forEach(System.out::println);
    }
    private void displayOne(){
        System.out.print("id du categorie : ");
        String id =  sc.nextLine() ;

        try{
            System.out.println( service.getOne(id) );
        }
        catch (ElementNotFoundException ex){
            System.out.println("Le produit n'a pas été trouvé");
        }
    }
    private void add(){
        CategorieDTO.CategorieDTOBuilder builder = CategorieDTO.builder();

        System.out.print("id de categorie : ");
        builder.id( sc.nextLine() );
        System.out.print("nom de categorie : ");
        builder.nom( sc.nextLine() );
        System.out.print("description de categorie : ");
        builder.description( sc.nextLine() );

        service.insert(builder.build());
    }
    private void delete(){
        System.out.print("id du categorie : ");
        String id =  sc.nextLine() ;

        try{
            System.out.println("Tentative de suppression");
            System.out.println( service.delete(id) );
            System.out.println("Le produit a bien été supprimé");
        }
        catch (ElementNotFoundException ex){
            System.out.println("Le produit n'a pas été trouvé");
        }
    }
    private void update(){
        CategorieDTO.CategorieDTOBuilder builder = CategorieDTO.builder();

        System.out.print("id de categorie : ");
        builder.id( sc.nextLine() );
        System.out.print("nom de categorie : ");
        builder.nom( sc.nextLine() );
        System.out.print("description de categorie : ");
        builder.description( sc.nextLine() );

        try{
            System.out.println("Tentative d'update");
            service.update(builder.build());
            System.out.println("Update réussi");
        }catch (ElementNotFoundException ex){
            System.out.println("L'élément a modifier n'existe pas");
        }

    }
    private void quit(){
        System.out.println("Au revoir!");
    }

}
