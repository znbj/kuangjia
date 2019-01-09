package com.itheima.domain;

public class Account {
    private Integer id;
    private Double money;
    private String cardNumber;
    private Integer u_id;
    private User user;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", money=").append(money);
        sb.append(", cardNumber='").append(cardNumber).append('\'');
        sb.append(", u_id=").append(u_id);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }
}
