package exo.exception;

public class ProduitNotFoundException extends RuntimeException {

    private final int id;

    public ProduitNotFoundException(int id) {
        super("Le produit d'id {"+ id +"} n'est pas en DB.");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
