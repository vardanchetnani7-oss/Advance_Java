package model;

public class Users {
private int id;
private String name;
private long contact;
private String address;

public Users() {
	
}

Users(int id,String name,long contact , String address){
	this.id = id;
	this.name = name;
	this.contact = contact;
	this.address =address;
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

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "Users [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
}

}
