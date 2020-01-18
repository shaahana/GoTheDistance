import java.util.ArrayList;

public class Database {
    private ArrayList<Produce> db;

    public Database() {
        this.db = new ArrayList<>(20);

    }

    public void loadDB() {
        Produce a = new Produce("apple", 3306.3, "Washington State");
        Produce b = new Produce("pear", 3306.3, "Washington State");
        Produce c = new Produce("orange", 1725.07, "Florida");
        Produce d = new Produce("grapefruit", 1725.07, "Florida");
        Produce e = new Produce("lemon", 1725.07, "Florida");
        Produce f = new Produce("lime", 1725.07, "Florida");
        Produce g = new Produce("clementine", 1725.07, "Florida");
        Produce h = new Produce("tangerine", 1725.07, "Florida");
        Produce i = new Produce("cabbage", 3573.63, "California");
        Produce j = new Produce("lettuce", 3573.63, "California");
        Produce k = new Produce("grapes", 3573.63, "California");
        Produce l = new Produce("avocado", 3482.03, "Michoacan, Mexico");
        Produce m = new Produce("watermelon", 3482.03, "Michoacan, Mexico");
        Produce n = new Produce("mango", 3482.03, "Michoacan, Mexico");
        Produce o = new Produce("banana", 3893.54, "Guatemala");
        Produce p = new Produce("tomato", 3482.03, "Michoacan, Mexico");
        Produce q = new Produce("melon", 3573.63, "California");
        Produce r = new Produce("soybean", 1502.14, "Iowa");
        Produce s = new Produce("onion", 3573.63, "California");
        Produce t = new Produce("potato", 3009.73, "Idaho");

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
        Produce other = new Produce("other", 3257.06, "Average Estimate based on database");
        return other;
    }
}
