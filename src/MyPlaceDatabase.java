public class MyPlaceDatabase implements PlaceDB {
    private Place[] places;
    private int size;
    public MyPlaceDatabase(int capacity) {
        places = new Place[capacity];
        size = 0;
    }
    // Yeni bir yer ekler
    @Override
    public void addPlace(Place newPlace) {
        // Eklenen yerin veritabanında olup olmadığını kontrol eder
        if (lookupByZipcode(newPlace.getZipcode()) != null) {
            System.out.println("Posta kodu zaten veritabanında mevcut.");
            return;
        }
        places[size++] = newPlace; // Yeni yeri veritabanına ekler
    }
    // Belirli bir posta koduna göre yer arar
    @Override
    public Place lookupByZipcode(String zipcode) {
        for (int i = 0; i < size; i++) {
            if (places[i].getZipcode().equals(zipcode)) {
                return places[i]; // Posta koduna göre eşleşen yeri döndürür
            }
        }
        return null;
    }
    // Belirli bir önek ile başlayan tüm yerleri listeler
    @Override
    public void listAllPlaces(String prefix) {
        for (int i = 0; i < size; i++) {
            if (places[i].getZipcode().startsWith(prefix)) {
                System.out.println(places[i]);
            }
        }
    }
    // İki posta kodu arasındaki mesafeyi hesaplar
    @Override
    public double distance(String zip1, String zip2) {
        // İlgili posta kodlarına sahip yerleri bulur
        Place place1 = lookupByZipcode(zip1);
        Place place2 = lookupByZipcode(zip2);
        // Eğer bir veya her iki posta kodu için yer bulunamaz veya bulunan yerler LocationPlace türünde değilse -1 döndürür
        if (place1 == null || place2 == null || !(place1 instanceof LocationPlace) || !(place2 instanceof LocationPlace)) {
            return -1; // Konum bilgisi eksik
        }
        LocationPlace locationPlace1 = (LocationPlace) place1;
        LocationPlace locationPlace2 = (LocationPlace) place2;
        // İki yer arasındaki mesafeyi hesaplar
        return Math.sqrt(Math.pow(locationPlace1.getLatitude() - locationPlace2.getLatitude(), 2) + Math.pow(locationPlace1.getLongitude() -locationPlace2.getLongitude(), 2));
    }
}
