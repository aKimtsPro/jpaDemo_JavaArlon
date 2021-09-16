import entities.manager.EntityManagerProvider;
import entities.presentation.Interface;

public class MainClass {

    public static void main(String[] args) {

        EntityManagerProvider.open();
        new Interface().start();
        EntityManagerProvider.close();
    }
}
