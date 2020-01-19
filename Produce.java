import java.util.ArrayList;

public class Produce {
    private String name;        //the name of the produce item (ie "pear")
    private double kgCarbon;    //kg of CO2 released from transport of the item
    private String origin;      //origin of the produce
    private int dist;        //distance between the origin and MTL

    public Produce(String name, double kgCarbon, String origin, double dist) {
        this.name = name;
        this.kgCarbon =  kgCarbon;
        this.origin = origin;
        this.dist = (int) dist;
    }

    public String getName() {return this.name;}

    public double getKgCarbon() {return this.kgCarbon;}

    public String getOrigin() {return this.origin;}

    public int getDist(){return this.dist;}

}