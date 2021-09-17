package exo;

import exo.data.dao.ProduitDAO;
import exo.data.entity.Produit;
import exo.exception.ProduitNotFoundException;
import exo.presentation.MenuProduit;
import util.EntityManagerProvider;

import java.util.Optional;

public class MainExo {

    public static void main(String[] args) {

        EntityManagerProvider.open();

        new MenuProduit().start();

        EntityManagerProvider.close();

    }

}
