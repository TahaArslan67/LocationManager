public class Place {
    private String zipcode;
    private String town;
    private String state;
    public Place(String zipcode, String town, String state) {
        this.zipcode = zipcode;
        this.town = town;
        this.state = state;
    }
    // Posta kodu bilgisini döndürür
    public String getZipcode() {
        return zipcode;
    }
    // Posta kodu bilgisini ayarlar
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    // Kent bilgisini döndürür
    public String getTown() {
        return town;
    }
    // Kent bilgisini ayarlar
    public void setTown(String town) {
        this.town = town;
    }
    // Eyalet bilgisini döndürür
    public String getState() {
        return state;
    }
    // Eyalet bilgisini ayarlar
    public void setState(String state) {
        this.state = state;
    }
    // Nesne bilgilerini string olarak döndürr
    @Override
    public String toString() {
        return zipcode + ": " + town + ", " + state;
    }
}
