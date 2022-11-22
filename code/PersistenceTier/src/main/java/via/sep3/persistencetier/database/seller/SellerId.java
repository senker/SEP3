package via.sep3.persistencetier.database.seller;

import java.io.Serializable;

public class SellerId implements Serializable {
    private Long cvr;
    private String email;

    public SellerId(Long cvr, String email)
    {
        this.cvr = cvr;
        this.email = email;
    }

    public SellerId()
    {

    }

    public Long getCvr()
    {
        return cvr;
    }

    public void setCvr(Long cvr)
    {
        this.cvr = cvr;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
