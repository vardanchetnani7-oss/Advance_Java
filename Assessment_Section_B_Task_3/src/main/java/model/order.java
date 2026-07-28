package model;

public class order {
	

private int orderid;
private String customerName;
private String restaurantName;
private double totalAmount;
private String status;


public order() {
	super();
	// TODO Auto-generated constructor stub
}

public order(int orderid, String customerName, String restaurantName, double totalAmount, String status) {
	super();
	this.orderid = orderid;
	this.customerName = customerName;
	this.restaurantName = restaurantName;
	this.totalAmount = totalAmount;
	this.status = status;
}

public int getOrderid() {
	return orderid;
}

public void setOrderid(int orderid) {
	this.orderid = orderid;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public String getRestaurantName() {
	return restaurantName;
}

public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}

public double getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "order [orderid=" + orderid + ", customerName=" + customerName + ", restaurantName=" + restaurantName
			+ ", totalAmount=" + totalAmount + ", status=" + status + "]";
}

}
