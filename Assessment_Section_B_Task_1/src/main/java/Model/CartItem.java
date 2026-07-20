package Model;

public class CartItem {
	private static final long serialVersionUID = 1L;
	private String name;
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartItem(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartItem [name=" + name + ", quantity=" + quantity + "]";
	}
	
	
}
