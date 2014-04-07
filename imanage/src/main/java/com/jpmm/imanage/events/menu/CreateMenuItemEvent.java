package com.jpmm.imanage.events.menu;


import com.jpmm.imanage.events.CreateEvent;

public class CreateMenuItemEvent extends CreateEvent {

  private MenuItemDetails details;

  public CreateMenuItemEvent(MenuItemDetails details) {
    this.details = details;
  }

  public MenuItemDetails getDetails() {
    return details;
  }
}
