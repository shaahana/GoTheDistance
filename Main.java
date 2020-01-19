import java.util.Scanner;

public class Main {

    public static void main (String args[]) throws Exception {
        Database db = new Database();
        db.loadDB("database.txt");
        Main.startPrompt(db);
    }

    public static void goAgain(Database db) throws Exception{
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Would you like to access the database again? Y/N: ");
        String resp = sc.nextLine();
        if(resp.charAt(0)=='y'||resp.charAt(0)=='Y'){
            Main.startPrompt(db);
        } else if (resp.charAt(0)=='n'||resp.charAt(0)=='N'){
            System.out.println("Have a nice day!");
        }
        else{
            System.out.println("Please enter Y or N");
            Main.goAgain(db);
        }
    }

    public static void startPrompt (Database db) throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s to search or a to add: ");
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
                int dist = newP.getDist();

                db.saveDB("database.txt");
                System.out.println("Thank you! Your entry has been successfully added to the database.");

                System.out.println("Your product was shipped "+dist+" km");

                System.out.println("Approximately " +  (int) newKgC + " kg of carbon dioxide were released from this shipment.");

                int newTree = (int) (newKgC/22.0);
                System.out.println("It would take about " + newTree + " trees one year to offset this amount of carbon dioxide.");
                return;
            }
            double kgCarbon = p.getKgCarbon();
            int dist = p.getDist();
            String origin = p.getOrigin();

            System.out.println("This product came from: " + origin);
            System.out.println("It was shipped "+dist+" km");
            System.out.println("Approximately " +  kgCarbon + " kg of carbon dioxide were released from this shipment.");


            int tree = (int) (kgCarbon/22.0);
            System.out.println("It would take about " + tree + " trees one year to offset this amount of carbon dioxide.");


        } else if(in.equalsIgnoreCase("a")){
            System.out.print("Enter the name of the produce: ");

            String newName = sc.nextLine();

            System.out.print("Enter the country of origin. Replace all spaces with a dash '-': " );

            String newOrigin = sc.nextLine();

            Produce newP = db.addNew(newName, newOrigin);
            double newKgC = newP.getKgCarbon();
            int newDist = newP.getDist();

            db.saveDB("database.txt");
            System.out.println("Thank you! Your entry has been successfully added to the database.");

            System.out.println("Your product was shipped "+newDist+" km");

            System.out.println("Approximately " +  (int) newKgC + " kg of carbon dioxide were released from this shipment.");

            int newTree = (int) (newKgC/22.0);
            System.out.println("It would take about " + newTree + " trees one year to offset this amount of carbon dioxide.");

            //would you like to enter another product

        } else{
            System.out.println("Please enter 's' or 'a'");
            Main.goAgain(db);
        }
        Main.goAgain(db);
    }

}
