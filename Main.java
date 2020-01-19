import java.util.Scanner;

public class Main {

    public static void main (String args[]) throws Exception {

        Database db = new Database();
        db.loadDB();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s to search, a to add: ");
        String in = sc.nextLine();

        if(in.equalsIgnoreCase("s")){
            System.out.print("Enter the name of your produce: ");
            String input = sc.nextLine();

            Produce p = db.find(input);
            if(p==null){
                System.out.println("Produce not found, please enter the following information to the database.");

                System.out.print("Enter the name of the produce: ");

                String newName = sc.nextLine();

                System.out.print("Enter the country of origin. Replace all spaces with '-': " );

                String newOrigin = sc.nextLine();

                Produce newP = db.addNew(newName, newOrigin);
                double newKgC = newP.getKgCarbon();

                System.out.println("Thank you! Your entry has been successfully added to the database.");

                System.out.println("Approximately " +  (int) newKgC + " kg of carbon dioxide were released from shipment of this product.");

                int newTree = (int) (newKgC/22.0);
                System.out.println("It would take about " + newTree + " trees one year to offset this amount of carbon dioxide.");
                return;
            }
            double kgCarbon = p.getKgCarbon();
            String origin = p.getOrigin();

            System.out.println("This product came from: " + origin);
            System.out.println("Approximately " +  kgCarbon + " kg of carbon dioxide were released from shipment of this product.");


            int tree = (int) (kgCarbon/22.0);
            System.out.println("It would take about " + tree + " trees one year to offset this amount of carbon dioxide.");

        } else if(in.equalsIgnoreCase("a")){
            System.out.print("Enter the name of the produce: ");

            String newName = sc.nextLine();

            System.out.print("Enter the country of origin. Replace all spaces with '-': " );

            String newOrigin = sc.nextLine();

            Produce newP = db.addNew(newName, newOrigin);
            double newKgC = newP.getKgCarbon();

            System.out.println("Thank you! Your entry has been successfully added to the database.");

            System.out.println("Approximately " +  (int) newKgC + " kg of carbon dioxide were released from shipment of this product.");

            int newTree = (int) (newKgC/22.0);
            System.out.println("It would take about " + newTree + " trees one year to offset this amount of carbon dioxide.");

        } else{
            System.out.println("Please enter 's' or 'a'");
        }

    }

}
