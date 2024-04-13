public class LocationPlace extends Place {
    private double latitude; // Enlem
    private double longitude; // Boylam
    public LocationPlace(String zipcode, String town, String state, double latitude, double longitude) {
        super(zipcode, town, state); // Üst sınıfın kurucu metodunu çağırır
        this.latitude = latitude; // Enlem bilgisini ayarlar
        this.longitude = longitude; // Boylam bilgisini ayarlar
    }
    // Enlem bilgisini döndürür
    public double getLatitude() {
        return latitude;
    }
    // Enlem bilgisini ayarlar
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    // Boylam bilgisini döndürür
    public double getLongitude() {
        return longitude;
    }
    // Boylam bilgisini ayarlar
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    // Nesne bilgilerini string olarak döndürür
    @Override
    public String toString() {
        return super.toString() + ", Enlem: " + latitude + ", Boylam: " + longitude;
    }
}
