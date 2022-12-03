package via.sep3.persistencetier.database.foodPack;

import javax.persistence.*;


@Entity
public class FoodPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "is_prepared")
    private boolean is_prepared;

    @Column(name = "price")
    private double price;

    public FoodPack(int id, String title, String description, String type, boolean is_prepared, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.is_prepared = is_prepared;
        this.price = price;
    }

    public FoodPack() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIs_prepared() {
        return is_prepared;
    }

    public void setIs_prepared(boolean is_prepared) {
        this.is_prepared = is_prepared;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
