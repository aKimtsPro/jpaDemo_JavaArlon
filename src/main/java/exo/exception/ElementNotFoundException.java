package exo.exception;

public class ElementNotFoundException extends RuntimeException {

    private final Object id;
    private Class<?> clazz;

    public ElementNotFoundException(Class<?> clazz, Object id) {
        super("L'element d'id {"+ id +"} n'existe pas. (" + clazz.getSimpleName() + ")");
        this.id = id;
    }

    public Object getId() {
        return id;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
