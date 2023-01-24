package com.ignacio.davalos.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @Column
//    @SequenceGenerator(name= "customer_sequence", sequenceName = "customer_sequence_id", initialValue=1, allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.AUTO, generator="customer_sequence")
    private Long customerId;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
