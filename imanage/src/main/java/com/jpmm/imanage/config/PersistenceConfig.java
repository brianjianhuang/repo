package com.jpmm.imanage.config;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jpmm.imanage.persistence.domain.MenuItem;
import com.jpmm.imanage.persistence.domain.Order;
import com.jpmm.imanage.persistence.repository.MenuItemMemoryRepository;
import com.jpmm.imanage.persistence.repository.MenuItemRepository;
import com.jpmm.imanage.persistence.repository.OrderStatusMemoryRepository;
import com.jpmm.imanage.persistence.repository.OrderStatusRepository;
import com.jpmm.imanage.persistence.repository.OrdersMemoryRepository;
import com.jpmm.imanage.persistence.repository.OrdersRepository;
import com.jpmm.imanage.persistence.repository.WorkstreamMemoryRepository;
import com.jpmm.imanage.persistence.repository.WorkstreamRepository;
import com.jpmm.imanage.persistence.services.MenuPersistenceEventHandler;
import com.jpmm.imanage.persistence.services.MenuPersistenceService;
import com.jpmm.imanage.persistence.services.OrderPersistenceEventHandler;
import com.jpmm.imanage.persistence.services.OrderPersistenceService;
import com.jpmm.imanage.persistence.services.WorkstreamPersistenceEventHandler;
import com.jpmm.imanage.persistence.services.WorkstreamPersistenceService;

@Configuration
public class PersistenceConfig {

	@Bean
	public OrdersRepository orderRepository() {
		return new OrdersMemoryRepository(new HashMap<UUID, Order>());
	}

	@Bean
	public OrderStatusRepository orderStatusRepository() {
		return new OrderStatusMemoryRepository();
	}

	@Bean
	public OrderPersistenceService ordersPersistenceService() {
		return new OrderPersistenceEventHandler(orderRepository(), orderStatusRepository());
	}

	@Bean
	public MenuItemRepository menuItemRepository() {
		return new MenuItemMemoryRepository(defaultMenu());
	}

	@Bean
	public MenuPersistenceService menuPersistenceService(MenuItemRepository menuItemRepository) {
		return new MenuPersistenceEventHandler(menuItemRepository);
	}

	@Bean
	public WorkstreamRepository workstreamRepository() {
		return new WorkstreamMemoryRepository();
	}

	@Bean
	public WorkstreamPersistenceService workstreamPersistenceService(WorkstreamRepository workstreamRepository) {
		return new WorkstreamPersistenceEventHandler(workstreamRepository);
	}

	private Map<String, MenuItem> defaultMenu() {
		Map<String, MenuItem> items = new HashMap<String, MenuItem>();
		items.put("YM1", menuItem("YM1", new BigDecimal("1.99"), 11, "Yummy Noodles"));
		items.put("YM2", menuItem("YM2", new BigDecimal("2.99"), 12, "Special Yummy Noodles"));
		items.put("YM3", menuItem("YM3", new BigDecimal("3.99"), 13, "Low cal Yummy Noodles"));
		return items;
	}

	private MenuItem menuItem(String id, BigDecimal cost, int minutesToPrepare, String name) {
		MenuItem item = new MenuItem();
		item.setId(id);
		item.setCost(cost);
		item.setMinutesToPrepare(minutesToPrepare);
		item.setName(name);
		return item;
	}

}
