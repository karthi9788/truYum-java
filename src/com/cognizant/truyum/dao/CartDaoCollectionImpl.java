package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts = null;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (!userCarts.containsKey(userId)) {
			userCarts.put(userId, new Cart(new ArrayList<MenuItem>(), 0));
		}
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		menuItemList.add(menuItem);
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = userCarts.get(userId);

		if (cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException("");
		}
		for (MenuItem menuItem : cart.getMenuItemList()) {
			cart.setTotal(cart.getTotal() + menuItem.getPrice());
		}
		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				menuItemList.remove(menuItem);
				break;
			}
		}
	}
}
