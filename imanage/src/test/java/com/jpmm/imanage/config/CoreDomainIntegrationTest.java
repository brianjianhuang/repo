package com.jpmm.imanage.config;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpmm.imanage.config.CoreConfig;
import com.jpmm.imanage.config.PersistenceConfig;
import com.jpmm.imanage.core.services.MenuService;
import com.jpmm.imanage.events.menu.AllMenuItemsEvent;
import com.jpmm.imanage.events.menu.RequestAllMenuItemsEvent;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, CoreConfig.class})
public class CoreDomainIntegrationTest {
	
	@Autowired
	MenuService menuService;
			
	@Test
	public void thatAllMenuItemsReturned() {
		
	AllMenuItemsEvent allMenuItems = menuService.requestAllMenuItems(new RequestAllMenuItemsEvent());
	
	assertEquals(3, allMenuItems.getMenuItemDetails().size());
			
	}	

}
