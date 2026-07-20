package dao;

import java.util.ArrayList;

import Model.CartItem;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartDaoImpl implements CartDao {
	private static final String CART_SESSION_KEY = "cart";
	 
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<String> getCartItems(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
 
        if (session == null) {
            return new ArrayList<>();
        }
 
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute(CART_SESSION_KEY);
        return (cart != null) ? cart : new ArrayList<>();
    }
 
    @Override
    @SuppressWarnings("unchecked")
    public void addItem(HttpServletRequest request, CartItem item) {
        if (item == null || item.getName() == null || item.getName().trim().isEmpty()) {
            return;
        }
 
        HttpSession session = request.getSession(); // create session if absent
 
        ArrayList<String> cart = (ArrayList<String>) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute(CART_SESSION_KEY, cart);
        }
 
        cart.add(item.toString()); 
    }
 
    @Override
    public void clearCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
