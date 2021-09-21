package exo;

import exo.presentation.MenuPrincipal;
import exo.presentation.MenuProduit;
import util.EntityManagerProvider;

public class MainExo {

    public static void main(String[] args) {

        EntityManagerProvider.open();

        new MenuPrincipal().start();

        EntityManagerProvider.close();

    }

}
