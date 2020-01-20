import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.Math;

public class Database {
    private ArrayList<Produce> db;

    public Database() {
        this.db = new ArrayList<>(20);

    }

    public void loadDB(String filepath) throws Exception{
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);
        String currentLine = br.readLine();
        while(currentLine!=null){
            String[] split = currentLine.split(",");
            String name = split[0];
            int kgC = (int) Double.parseDouble(split[1]);
            String origin = split[2];
            int dist = Integer.parseInt(split[3]);
            Produce p = new Produce(name, kgC, origin, dist);
            db.add(p);
            currentLine=br.readLine();
        }
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
                } else {kgC= 15*dist;}


                Produce newP = new Produce(name, kgC, origin, dist);
                db.add(newP);


                return newP;


            }
        }
        System.out.println("Country not found");
        return null;
    }
    public void saveDB(String filepath, Produce p){
        String name = p.getName();
        String kgC = String.valueOf(p.getKgCarbon());
        String origin = p.getOrigin();
        String dist = String.valueOf(p.getDist());
        try{
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(name+","+kgC+","+origin+","+dist);

            pw.flush();
            pw.close();
            bw.close();
            fw.close();
        }
        catch(Exception e){
            System.out.println("Error: record not saved");
        }
//        for(int i=0; i<db.size(); i++){
//            //Produce p = db.get(i);
//            String name = p.getName();
//            String kgC = String.valueOf(p.getKgCarbon());
//            String origin = p.getOrigin();
//            String dist = String.valueOf(p.getDist());
//            try{
//                FileWriter fw = new FileWriter(filepath,true);
//                BufferedWriter bw = new BufferedWriter(fw);
//                PrintWriter pw = new PrintWriter(bw);
//                pw.println(name+","+kgC+","+origin+","+dist);
//
//                pw.flush();
//                pw.close();
//                bw.close();
//                fw.close();
//            }
//            catch(Exception e){
//                System.out.println("Error: record not saved");
//            }
//        }
    }
}
