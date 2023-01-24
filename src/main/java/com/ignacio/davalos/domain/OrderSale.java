package com.ignacio.davalos.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderSale implements Serializable {
    @Id
    @GeneratedValue
    private int orderSaleId ;
    @ManyToOne
    @JoinColumn(name="customer_id",referencedColumnName="customerId", insertable=false, updatable=false)
    private Customer customerId;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_sale_id", referencedColumnName = "orderSaleId")
    private Set<OrderSaleProduct> orderSaleProducts = new HashSet<>();

    @Column
    private BigDecimal amount;
    @Column
    private Timestamp transactionDate;
    @Column
    private int rewards;


}
