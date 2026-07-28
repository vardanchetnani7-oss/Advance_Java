package dao;

import java.util.List;

import model.order;

public interface orderdao {

	boolean placeOrder(order o);
	order getorderByid(int id);
	List<order>getallorder();
	boolean updateStatus(int id,String status);
	
}
