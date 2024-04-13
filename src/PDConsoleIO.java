import java.util.*;
public class PDConsoleIO {
    private PlaceDB theDatabase = null;
    private Scanner input = null;
    public PDConsoleIO() {
        input = new Scanner(System.in);
    }
    // Komutları işler
    public void processCommands(PlaceDB thePlaceDatabase) {
        theDatabase = thePlaceDatabase; // Veritabanı nesnesini atanır
        int choice;
        do {
            // Tüm komutları yazdır
            System.out.println("0: Yer Ekle\n"
            		+ "1: Posta Koduna Göre Ara\n"
            		+ "2: Posta Kodu Önekine Göre Tüm Yerleri Listele\n"
            		+ "3: Posta Kodları Arasındaki Mesafe\n"
            		+ "4: Çıkış");
            choice = input.nextInt(); // Kullanıcının seçimini alır
            input.nextLine();
            switch (choice) {
                case 0:
                    doAddPlace();
                    break;
                case 1:
                    doLookupByZipcode();
                    break;
                case 2:
                    doListAllPlaces();
                    break;
                case 3:
                    doDistance();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("*** Geçersiz seçim " + choice + " - yeniden deneyin!");
            }
        } while (choice != 4);
        System.exit(0); // Programı sonlandır
    }
    // Yeni bir yer ekler
    private void doAddPlace() {
        System.out.println("Posta kodunu girin:");
        String zipcode = input.nextLine();
        System.out.println("Kenti girin:");
        String town = input.nextLine();
        System.out.println("Eyaleti girin:");
        String state = input.nextLine();
        System.out.println("Enlem ve boylamı \"10.02 , 23,12\" şeklinde girin:");
        String[] cor = input.nextLine().split(",");
        double latitude = 0.0;
        double longitude = 0.0;
        if (!cor[0].equals("") && !cor[1].equals("")) {
            latitude = Double.parseDouble(cor[0]);
            longitude = Double.parseDouble(cor[1]);
        }
        System.out.println("Nüfusu girin:");
        String populationInput = input.nextLine();
        int population = 0;
        if (!populationInput.equals("")) {
            population = Integer.parseInt(populationInput);
        }
        Place newPlace;
        if (latitude == 0.0 && longitude == 0.0) {
            newPlace = new Place(zipcode, town, state);
        } else {
            if (population == 0)
                newPlace = new LocationPlace(zipcode, town, state, latitude, longitude);
            else
                newPlace = new PopulatedPlace(zipcode, town, state, latitude, longitude, population);
        }
        theDatabase.addPlace(newPlace);
    }
    // Posta koduna göre arama yapar
    private void doLookupByZipcode() {
        System.out.println("Posta kodunu girin");
        String theZip = input.nextLine();
        if (theZip.equals("")) {
            return;
        }
        Place p = theDatabase.lookupByZipcode(theZip);
        if (p != null) {
            System.out.println(p.toString());
        } else {
            System.out.println("Böyle bir posta kodu bulunamadı");
        }
    }
    // Posta kodu önekine göre tüm yerleri listeler
    private void doListAllPlaces() {
        System.out.println("Posta kodu öneğini girin");
        String prefix = input.nextLine();
        if (prefix.equals("")) {
            return;
        }
        theDatabase.listAllPlaces(prefix);
    }
    // İki posta kodu arasındaki mesafeyi hesaplar
    private void doDistance() {
        System.out.println("İki posta kodunu girin");
        String[] zipcodes = input.nextLine().split(",");
        String zip1 = zipcodes[0].trim();
        String zip2 = zipcodes[1].trim();
        double dist = theDatabase.distance(zip1, zip2);
        if (dist == -1) {
            System.out.println("Bir veya her iki posta kodu için konum bilgisi bulunmuyor.");
        } else {
            System.out.println(zip1 + " ve " + zip2 + " arasındaki mesafe: " + dist);
        }
    }

    public static void main(String args[]) {
        PDConsoleIO ui = new PDConsoleIO();
        PlaceDB pd = new MyPlaceDatabase(5);
        ui.processCommands(pd);
    }
}
