package exo.presentation;

import exo.business.service.impl.CategorieServiceImpl;
import exo.business.service.impl.ClientServiceImpl;
import exo.business.service.spec.CategorieService;
import exo.business.service.spec.ClientService;
import exo.dto.CategorieDTO;
import exo.dto.ClientDTO;
import exo.dto.ProduitDTO;
import exo.exception.ElementNotFoundException;

import java.util.Scanner;

public class MenuClient implements Menu{
    private final Scanner sc = new Scanner(System.in);
    private final ClientService service = new ClientServiceImpl();

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
        System.out.println("----- TOUS LES CLIENTS -----");
        service.getAll().forEach(System.out::println);
    }
    private void displayOne(){
        System.out.print("id du client : ");
        int id = Integer.parseInt( sc.nextLine() );

        try{
            System.out.println( service.getOne(id) );
        }
        catch (ElementNotFoundException ex){
            System.out.println("Le client n'a pas été trouvé");
        }
    }
    private void add(){
        ClientDTO.ClientDTOBuilder builder = ClientDTO.builder();

        System.out.print("prenom du client : ");
        builder.prenom(sc.nextLine());
        System.out.print("nom du client : ");
        builder.nom(sc.nextLine());
        System.out.print("adresse du client : ");
        builder.adresse(sc.nextLine());
        System.out.print("email du client : ");
        builder.email(sc.nextLine());

        service.insert(builder.build());
    }
    private void delete(){
        System.out.print("id du client : ");
        int id = Integer.parseInt( sc.nextLine() );

        try{
            System.out.println("Tentative de suppression");
            System.out.println( service.delete(id) );
            System.out.println("Le client a bien été supprimé");
        }
        catch (ElementNotFoundException ex){
            System.out.println("Le client n'a pas été trouvé");
        }
    }
    private void update(){
        ClientDTO.ClientDTOBuilder builder = ClientDTO.builder();

        System.out.print("id du client : ");
        builder.id(Integer.parseInt(sc.nextLine()));
        System.out.print("prenom du client : ");
        builder.prenom(sc.nextLine());
        System.out.print("nom du client : ");
        builder.nom(sc.nextLine());
        System.out.print("adresse du client : ");
        builder.adresse(sc.nextLine());
        System.out.print("email du client : ");
        builder.email(sc.nextLine());

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
