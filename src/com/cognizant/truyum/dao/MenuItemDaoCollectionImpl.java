package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList = null;

	public MenuItemDaoCollectionImpl() {
		super();
		try {
			if (menuItemList == null) {
				menuItemList = new ArrayList<MenuItem>();
				menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
						"Main Course", true));
				menuItemList.add(new MenuItem(2, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
						"Main Course", false));
				menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
						"Main Course", false));
				menuItemList.add(new MenuItem(4, "French Fries", 57.00f, false, DateUtil.convertToDate("22/07/2017"),
						"Starters", true));
				menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f, true,
						DateUtil.convertToDate("02/11/2022"), "Dessert", true));
			}
		} catch (Exception e) {
		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> arrayList = new ArrayList<MenuItem>();
		Date currdate = null;
		try {
			currdate = DateUtil.convertToDate("16/04/2020");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (MenuItem menuItem : menuItemList) {
			if (currdate.compareTo(menuItem.getDateOfLaunch()) >= 0 && menuItem.isActive()) {
				arrayList.add(menuItem);
			}
		}
		return arrayList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for (MenuItem menuItems : menuItemList) {
			if (menuItem.getId() == menuItems.getId()) {
				menuItems.setName(menuItem.getName());
				menuItems.setActive(menuItem.isActive());
				menuItems.setFreeDelivery(menuItem.isFreeDelivery());
				menuItems.setCategory(menuItem.getCategory());
				menuItems.setPrice(menuItem.getPrice());
				menuItems.setDateOfLaunch(menuItem.getDateOfLaunch());
				break;
			}
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for (MenuItem menuItem : menuItemList) {
			if(menuItem.getId()==menuItemId) {
				return menuItem;
			}
		}
		return null;
	}

}
