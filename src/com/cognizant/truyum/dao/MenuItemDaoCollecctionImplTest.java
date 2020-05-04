package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

import java.util.List;

public class MenuItemDaoCollectionImplTest{
	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItem = menuItemDao.getMenuItemListAdmin();
		for (MenuItem item : menuItem) {
			System.out.println(item.toString());
		}
	}
	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItem = menuItemDao.getMenuItemListCustomer();
		for (MenuItem item : menuItem) {
			System.out.println(item.toString());
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MenuItem item = new MenuItem(1, "Dosa", 30.00f, true, DateUtil.convertToDate("22/07/2015"),"Main Course" ,true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(item);
		System.out.println(menuItemDao.getMenuItem(1).toString());	
	}

	public static void testGetMenuItem() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println(menuItemDao.getMenuItem(1).toString());
	}
	
	public static void main(String[] args) throws ParseException{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();	
		testModifyMenuItem();
		testGetMenuItem();
	}
	
}
