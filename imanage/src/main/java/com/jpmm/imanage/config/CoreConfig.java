package com.jpmm.imanage.config;

import com.jpmm.imanage.core.services.MenuEventHandler;
import com.jpmm.imanage.core.services.MenuService;
import com.jpmm.imanage.core.services.OrderEventHandler;
import com.jpmm.imanage.core.services.OrderService;
import com.jpmm.imanage.core.services.WorkstreamEventHandler;
import com.jpmm.imanage.core.services.WorkstreamService;
import com.jpmm.imanage.persistence.services.MenuPersistenceService;
import com.jpmm.imanage.persistence.services.OrderPersistenceService;
import com.jpmm.imanage.persistence.services.WorkstreamPersistenceService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
	@Bean
	public MenuService menuService(MenuPersistenceService menuPersistenceService) {
		return new MenuEventHandler(menuPersistenceService);
	}
  @Bean
  public OrderService orderService(OrderPersistenceService orderPersistenceService) {
    return new OrderEventHandler(orderPersistenceService);
  }
  @Bean
  public WorkstreamService workstreamService(WorkstreamPersistenceService workstreamPersistenceService) {
    return new WorkstreamEventHandler(workstreamPersistenceService);
  }
}
