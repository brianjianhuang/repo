package com.jpmm.imanage.persistence.repository;

import com.jpmm.imanage.persistence.domain.Order;

import java.util.UUID;

public interface OrdersRepository {

  Order save(Order order);

  void delete(UUID key);

  Order findById(UUID key);

  Iterable<Order> findAll();
}
