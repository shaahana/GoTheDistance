import java.util.ArrayList;

public class Produce {
    private String name;
    private double kgCarbon;
    private String origin;

    public Produce(String name, double kgCarbon, String origin) {
        this.name = name;
        this.kgCarbon = kgCarbon;
        this.origin = origin;
    }

    public String getName() {return this.name;}

    public double getKgCarbon() {return this.kgCarbon;}

    public String getOrigin() {return this.origin;}

}