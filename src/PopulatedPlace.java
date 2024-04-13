public class PopulatedPlace extends LocationPlace {
    private int population;
    public PopulatedPlace(String zipcode, String town, String state, double latitude, double longitude, int population) {
        super(zipcode, town, state, latitude, longitude);
        this.population = population;
    }
    // Nüfus bilgisini döndürür
    public int getPopulation() {
        return population;
    }
    // Nüfus bilgisini ayarlar
    public void setPopulation(int population) {
        this.population = population;
    }
    // Nesne bilgilerini string olarak formatlar
    @Override
    public String toString() {
        return super.toString() + ", Nüfus: " + population;
    }
}
