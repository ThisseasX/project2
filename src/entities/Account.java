package entities;

import javax.persistence.*;

@Entity
public class Account {
    private Integer accId;
    private Integer uId;
    private Double balance;
    private User userByUId;

    @Id
    @Column(name = "acc_id", nullable = false)
    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
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
    @Column(name = "balance", nullable = false, precision = 0)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (accId != null ? !accId.equals(account.accId) : account.accId != null) return false;
        if (uId != null ? !uId.equals(account.uId) : account.uId != null) return false;
        if (balance != null ? !balance.equals(account.balance) : account.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accId != null ? accId.hashCode() : 0;
        result = 31 * result + (uId != null ? uId.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
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
