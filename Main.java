import java.util.Scanner;

public class Main {

    public static void main (String args[]) {

        Database db = new Database();
        db.loadDB();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Produce p = db.find(input);
        double kgCarbon = p.getKgCarbon();
        String origin = p.getOrigin();

        System.out.println(kgCarbon);
        System.out.println(origin);

    }
}
