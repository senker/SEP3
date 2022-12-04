package via.sep3.persistencetier.database.foodPack;

import via.sep3.persistencetier.seller.Seller;

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

    @ManyToOne
    @JoinColumn(name = "seller_cvr")
    private Seller seller;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public FoodPack(String title, String description, String type, boolean is_prepared, double price, Seller seller) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.is_prepared = is_prepared;
        this.price = price;
        this.seller = seller;
    }

    public FoodPack() {

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
