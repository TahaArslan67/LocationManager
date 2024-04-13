public interface PlaceDB {
  public Place lookupByZipcode(String zipcode);
  public void addPlace(Place newPlace);
  public void listAllPlaces(String prefix);
  public double distance(String zip1, String zip2);
}
