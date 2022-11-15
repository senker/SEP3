package via.sep3.persistencetier.database;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Seller EXAMPLE:
 * firstName: David,
 * lastName: Williams,
 * phoneNumber: 87766554,
 * email: veganparadise@gmail.com,
 * cvr: 123456789,
 * companyName: VeganParadise,
 * description: descriptioN,
 * type:vegan,
 * website: veganparadise.com
 * rating: 2.0
 */

/**
 * Seller EXAMPLE 2 - ID: 987654321
 */

@Entity(name="Seller")
@Table(name="seller")
public class Seller extends User{
    @Id
    @Column(name="cvr")
    private Long cvr;
    @Column(name="company_name",
            columnDefinition="varchar(255)",
            nullable=false)
    private String companyName;
    @Column(name="description",
            columnDefinition="varchar(255)")
    private String description;
    @Column(name="type",
            columnDefinition="varchar(255)"
    )
    private String type;
    @Column(name="website",
            columnDefinition="varchar(255)")
    private String website;
    @Column(name="rating",
            columnDefinition="integer default 0")
    private Float rating;


    public Seller(
            String firstName,
            String lastName,
            Address address,
            Long phoneNumber,
            String email,
            Long cvr,
            String companyName,
            String description,
            String type,
            String website,
            Float rating) {
        super(firstName,lastName,address,phoneNumber,email);
        this.cvr = cvr;
        this.companyName = companyName;
        this.description = description;
        this.type = type;
        this.website = website;
        this.rating = rating;
    }

    public Seller() {
        super("","",null,0L,"");
    }



    public Long getCvr() {
        return cvr;
    }

    public void setCvr(Long cvr) {
        this.cvr = cvr;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}