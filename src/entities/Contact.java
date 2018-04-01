package entities;

import javax.persistence.*;

@Entity
public class Contact {
    private Integer cId;
    private Integer uId;
    private String city;
    private String region;
    private String address;
    private String afm;
    private User userByUId;

    @Id
    @Column(name = "c_id", nullable = false)
    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Basic
    @Column(name = "u_id", nullable = false)
    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "region", nullable = false, length = 50)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "afm", nullable = false, length = 50)
    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (cId != null ? !cId.equals(contact.cId) : contact.cId != null) return false;
        if (uId != null ? !uId.equals(contact.uId) : contact.uId != null) return false;
        if (city != null ? !city.equals(contact.city) : contact.city != null) return false;
        if (region != null ? !region.equals(contact.region) : contact.region != null) return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        if (afm != null ? !afm.equals(contact.afm) : contact.afm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cId != null ? cId.hashCode() : 0;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (afm != null ? afm.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "u_id", referencedColumnName = "u_id", nullable = false)
    public User getUserByUId() {
        return userByUId;
    }

    public void setUserByUId(User userByUId) {
        this.userByUId = userByUId;
    }
}
