package dao;

import java.util.ArrayList;

import Model.CartItem;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CartDao {
	    ArrayList<String> getCartItems(HttpServletRequest request);
	    void addItem(HttpServletRequest request, CartItem item);
	    void clearCart(HttpServletRequest request, HttpServletResponse response);
}
