package demo;

import demo.presentation.Interface;
import util.EntityManagerProvider;

public class MainClass {

    public static void main(String[] args) {

        EntityManagerProvider.open();
        new Interface().start();
        EntityManagerProvider.close();

    }
}
