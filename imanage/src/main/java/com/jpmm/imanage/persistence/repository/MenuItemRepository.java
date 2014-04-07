package com.jpmm.imanage.persistence.repository;

import com.jpmm.imanage.persistence.domain.MenuItem;

public interface MenuItemRepository {

  MenuItem save(MenuItem item);

  void delete(String key);

  MenuItem findById(String key);

  Iterable<MenuItem> findAll();
}
