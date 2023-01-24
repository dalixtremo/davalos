package com.ignacio.davalos.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaleProduct  implements Serializable{
    @Id
    @GeneratedValue
    private int orderSaleProductId;

    @Column(name = "order_sale_id")
    private int orderSaleId;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name="quantity")
    private int quantity;


}
