package com.ignacio.davalos.repo;

import com.ignacio.davalos.domain.OrderSale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSaleRepository extends CrudRepository<OrderSale, Integer> {
}
