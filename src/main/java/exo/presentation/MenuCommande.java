package exo.presentation;

import exo.business.service.impl.CategorieServiceImpl;
import exo.business.service.impl.ClientServiceImpl;
import exo.business.service.impl.CommandeServiceImpl;
import exo.business.service.spec.CategorieService;
import exo.business.service.spec.ClientService;
import exo.business.service.spec.CommandeService;
import exo.data.entity.Client;
import exo.dto.CategorieDTO;
import exo.dto.CommandeDTO;
import exo.exception.ElementNotFoundException;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuCommande implements Menu{
    private final Scanner sc = new Scanner(System.in);
    private final CommandeService service = new CommandeServiceImpl();
    private final ClientService clientService = new ClientServiceImpl();

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
        System.out.println("----- TOUTES LES COMMANDES -----");
        service.getAll().forEach(System.out::println);
    }
    private void displayOne(){
        System.out.print("id de la commande : ");
        String id =  sc.nextLine() ;

        try{
            System.out.println( service.getOne(id) );
        }
        catch (ElementNotFoundException ex){
            System.out.println("La commande n'a pas été trouvé");
        }
    }
    private void add(){
        CommandeDTO.CommandeDTOBuilder builder = CommandeDTO.builder();

        System.out.print("id de commande : ");
        builder.id( sc.nextLine() );
        System.out.print("dateCreation de commande : ");
        builder.dateCreation(LocalDateTime.parse(sc.nextLine()) );
        System.out.print("dateConfirm de commande : ");
        String dateConfirm = sc.nextLine();
        if(dateConfirm.isBlank() || dateConfirm.isEmpty())
            builder.dateConfirm(null);
        else
            builder.dateConfirm( LocalDateTime.parse(sc.nextLine()) );

        try{
            System.out.print("id du client de la commande :");
            int id = Integer.parseInt(sc.nextLine());
            builder.proprietaire( clientService.getOne(id) );
            service.insert(builder.build());
        }catch (ElementNotFoundException ex){
            System.out.println("ce client n'existe pas");
        }

    }
    private void delete(){
        System.out.print("id du commande : ");
        String id =  sc.nextLine() ;

        try{
            System.out.println("Tentative de suppression");
            System.out.println( service.delete(id) );
            System.out.println("La commande a bien été supprimé");
        }
        catch (ElementNotFoundException ex){
            System.out.println("La commande n'a pas été trouvé");
        }
    }
    private void update(){
        CommandeDTO.CommandeDTOBuilder builder = CommandeDTO.builder();

        System.out.print("id de commande : ");
        builder.id( sc.nextLine() );
        System.out.print("dateCreation de commande : ");
        builder.dateCreation(LocalDateTime.parse(sc.nextLine()) );
        System.out.print("dateConfirm de commande : ");
        String dateConfirm = sc.nextLine();
        if(dateConfirm.isBlank() || dateConfirm.isEmpty())
            builder.dateConfirm(null);
        else
            builder.dateConfirm( LocalDateTime.parse(sc.nextLine()) );

        try{
            System.out.print("id du client de la commande :");
            int id = Integer.parseInt(sc.nextLine());
            builder.proprietaire( clientService.getOne(id) );

            try{
                System.out.println("Tentative d'update");
                service.update(builder.build());
                System.out.println("Update réussi");
            }catch (ElementNotFoundException ex){
                System.out.println("L'élément a modifier n'existe pas");
            }
        }catch (ElementNotFoundException ex){
            System.out.println("ce client n'existe pas");
        }


    }
    private void quit(){
        System.out.println("Au revoir!");
    }
}
