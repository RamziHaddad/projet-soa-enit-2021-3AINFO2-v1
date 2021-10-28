package enit.bank.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Price {

    @Id
    private int idProd;

    @Column
    private double price;

    @Column
    private double promo;

    public Price() {
    }

    public Price(int idProd, double price, double promo) {
        this.idProd = idProd;
        this.price = price;
        this.promo = promo;
    }

}
