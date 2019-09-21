package edureka.sathya.com.retrofitexample.flowerlist.model;

public class Flower {

    public final String url;
    public final String details;
    public final int rating;
    public final String name;
    public final String desc;

    public Flower(String url, String details, int rating, String name, String desc) {
        this.url = url;
        this.details = details;
        this.rating = rating;
        this.name = name;
        this.desc = desc;
    }
}
