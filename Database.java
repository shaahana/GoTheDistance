import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Database {
    private ArrayList<Produce> db;

    public Database() {
        this.db = new ArrayList<>(20);

    }

    public void loadDB() {
        Produce a = new Produce("apple", 3306, "Washington State");
        Produce b = new Produce("pear", 3306, "Washington State");
        Produce c = new Produce("orange", 1725, "Florida");
        Produce d = new Produce("grapefruit", 1725, "Florida");
        Produce e = new Produce("lemon", 1725, "Florida");
        Produce f = new Produce("lime", 1725, "Florida");
        Produce g = new Produce("clementine", 1725, "Florida");
        Produce h = new Produce("tangerine", 1725, "Florida");
        Produce i = new Produce("cabbage", 3573, "California");
        Produce j = new Produce("lettuce", 3573, "California");
        Produce k = new Produce("grapes", 3573, "California");
        Produce l = new Produce("avocado", 3482, "Michoacan, Mexico");
        Produce m = new Produce("watermelon", 3482, "Michoacan, Mexico");
        Produce n = new Produce("mango", 3482, "Michoacan, Mexico");
        Produce o = new Produce("banana", 3893, "Guatemala");
        Produce p = new Produce("tomato", 3482, "Michoacan, Mexico");
        Produce q = new Produce("melon", 3573, "California");
        Produce r = new Produce("soybean", 1502, "Iowa");
        Produce s = new Produce("onion", 3573, "California");
        Produce t = new Produce("potato", 3009, "Idaho");

        this.db.add(a);
        this.db.add(b);
        this.db.add(c);
        this.db.add(d);
        this.db.add(e);
        this.db.add(f);
        this.db.add(g);
        this.db.add(h);
        this.db.add(i);
        this.db.add(j);
        this.db.add(k);
        this.db.add(l);
        this.db.add(m);
        this.db.add(n);
        this.db.add(o);
        this.db.add(p);
        this.db.add(q);
        this.db.add(r);
        this.db.add(s);
        this.db.add(t);

    }

    public ArrayList<Produce> getDb() {
        return db;
    }

    public Produce find(String name) {
        int size = db.size();
        for (int i = 0; i<size; i++) {
            Produce p = db.get(i);
            String pName = p.getName();
            if (name.equalsIgnoreCase(pName)) {
                return p;
            }
        }
        return null;
    }

    public Produce addNew(String name, String origin) throws FileNotFoundException{
        //search for country in database
        double carbonOut;
        double mtlLati = 45.508800;
        double mtlLongi = -73.571750;
        String fileName = "country_coordinates.csv";
        File file = new File(fileName);

        Scanner inputStream = new Scanner(file);
        while(inputStream.hasNext()){
            String data = inputStream.next();
            String[] split = data.split(",");
            String country = split[3];
            if(country.equalsIgnoreCase(origin)){
                String lat = split[1];
                String lon = split[2];
                double lati = Double.parseDouble(lat);
                double longi = Double.parseDouble(lon);

                double dist = 2*6371*Math.asin(Math.sqrt(Math.pow((Math.sin((lati*(Math.PI/180.0)-mtlLati*(Math.PI/180))/2)), 2)+Math.cos(lati*(Math.PI/180))*Math.cos(mtlLati*(Math.PI/180))*Math.pow(Math.sin(((longi*(Math.PI/180)-mtlLongi*(Math.PI/180))/2)),2)));
                double kgC;
                if(country.equalsIgnoreCase("United-States")||country.equalsIgnoreCase("Mexico")){
                     kgC = 0.9*dist;
                } else {kgC=15*dist;}


                Produce newP = new Produce(name, kgC, origin);
                db.add(newP);
                return newP;


            }
        }
        System.out.println("Country not found");
        return null;
    }
}
