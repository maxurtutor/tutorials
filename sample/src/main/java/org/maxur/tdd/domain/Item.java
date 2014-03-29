package org.maxur.tdd.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/14/14</pre>
 */
@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="amount", column=@Column(name="AMOUNT")),
            @AttributeOverride(name="currency", column=@Column(name="CURRENCY"))
    })
    private Money price;

    public Item() {
    }

    public Item(Long id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Money price) {
        this.price = price;
    }
}
