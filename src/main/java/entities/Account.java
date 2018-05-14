package entities;

import javax.persistence.*;

@SuppressWarnings({"DefaultAnnotationParam", "RedundantIfStatement"})
@NamedQueries({
        @NamedQuery(name = "Account.getAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.getAllVendors", query = "SELECT a FROM Account a WHERE a.userByUserId.role.roleId = 2"),
        @NamedQuery(name = "Account.getByUser", query = "SELECT a FROM Account a WHERE a.userByUserId = :user")
})
@Entity
public class Account {

    private Integer accountId;
    private Double balance;
    private User userByUserId;

    @Id
    @Column(name = "account_id", nullable = false)
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
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

        if (accountId != null ? !accountId.equals(account.accountId) : account.accountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return accountId != null ? accountId.hashCode() : 0;
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
