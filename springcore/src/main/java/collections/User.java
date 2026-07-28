package collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private List<String>address;
	private Set<Long>contact;
	private Map<Integer, String>bankData;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, List<String> address, Set<Long> contact, Map<Integer, String> bankData) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.bankData = bankData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public Set<Long> getContact() {
		return contact;
	}

	public void setContact(Set<Long> contact) {
		this.contact = contact;
	}

	public Map<Integer, String> getBankData() {
		return bankData;
	}

	public void setBankData(Map<Integer, String> bankData) {
		this.bankData = bankData;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", bankData="
				+ bankData + "]";
	}

}
