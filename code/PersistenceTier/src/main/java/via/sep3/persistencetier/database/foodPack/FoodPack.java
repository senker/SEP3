package via.sep3.persistencetier.database.foodPack;

import via.sep3.persistencetier.database.seller.Seller;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="food_pack")
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

    @Column(name="start_date")
    private LocalDateTime dateTimeStart;


    @Column(name="end_date")
    private LocalDateTime dateTimeEnd;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Seller seller;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public FoodPack(String title, String description, String type, boolean is_prepared, double price, LocalDateTime dateTimeStart,
                    LocalDateTime dateTimeEnd, Seller seller) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.is_prepared = is_prepared;
        this.price = price;
        this.dateTimeStart = dateTimeStart;
        this.dateTimeEnd = dateTimeEnd;
        this.seller = seller;
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

    public LocalDateTime getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(LocalDateTime dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public LocalDateTime getDateTimeEnd() {
        return dateTimeEnd;
    }

    public void setDateTimeEnd(LocalDateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }
}
