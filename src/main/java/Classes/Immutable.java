package Classes;

public final class Immutable {

    private final String name;
    private final String id;


    public Immutable(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }
}
