package ConstructorInj;


public class User {

	private int id;
	private String name;
	private long contact;
	private String address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, long contact, String address) {
		super();
		System.out.println("data set by constructor");
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("id set by the setter function");

		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("name set by the setter function");

		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		System.out.println("contact set by the setter function");

		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("address set by the setter function");

		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
	}

}