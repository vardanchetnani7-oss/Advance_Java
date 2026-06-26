package models;

public class Cart {
	private int cart_id, pid, cus_id, pprice, total_price, qty;
	private String payment_status;

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", pid=" + pid + ", cus_id=" + cus_id + ", pprice=" + pprice
				+ ", total_price=" + total_price + ", qty=" + qty + ", payment_status=" + payment_status + "]";
	}

	
}
