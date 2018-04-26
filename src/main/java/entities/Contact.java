package entities;

import javax.persistence.*;

@SuppressWarnings("RedundantIfStatement")
@NamedQuery(name = "Contact.getAll", query = "SELECT c FROM Contact c")
@Entity
public class Contact {

    private Integer contactId;
    private String city;
    private String region;
    private String address;
    private String ssn;
    private User userByUserId;

    @Id
    @Column(name = "contact_id", nullable = false)
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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
    @Column(name = "ssn", nullable = false, length = 50)
    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (contactId != null ? !contactId.equals(contact.contactId) : contact.contactId != null) return false;
        if (city != null ? !city.equals(contact.city) : contact.city != null) return false;
        if (region != null ? !region.equals(contact.region) : contact.region != null) return false;
        if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
        if (ssn != null ? !ssn.equals(contact.ssn) : contact.ssn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId != null ? contactId.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
