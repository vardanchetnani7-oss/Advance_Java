package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.CartItem;
import dao.CartDao;
import dao.CartDaoImpl;


/**
 * Servlet implementation class CartController
 */
@WebServlet(name = "CartServlet",urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CartDao cartDao = new CartDaoImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		showCart(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("clear".equalsIgnoreCase(action)) {
			cartDao.clearCart(request,response);
			response.sendRedirect(request.getContextPath()+"/cleared.jsp");
			return;
		}
		
		CartItem item = buildCartItemFromRequest(request);
		cartDao.addItem(request,item);
		showCart(request,response);
	}
	
	private CartItem buildCartItemFromRequest(HttpServletRequest request) {
		String itemName = request.getParameter("itemName");
		String quantityParam = request.getParameter("quantity");
		
		int quantity = 1;
		try {
			if(quantityParam != null && !quantityParam.trim().isEmpty()) {
				quantity =Integer.parseInt(quantityParam.trim());
				if(quantity < 1) {
					quantity =1;
				}
			}
		}
		
		catch(NumberFormatException e){
			quantity = 1;
		}
		
		return new CartItem(itemName == null?null:itemName.trim(),quantity);
	}
	
	private void showCart(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
		dispatcher.forward(request,response);
		
	}

}
