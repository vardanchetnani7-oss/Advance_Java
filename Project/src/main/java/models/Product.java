package models;

public class Product {
private int pid;
private int sid;
private String pname;
private int pprice;
private String pcategory;
private String pimage;

public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPprice() {
	return pprice;
}
public void setPprice(int pprice) {
	this.pprice = pprice;
}
public String getPcategory() {
	return pcategory;
}
public void setPcategory(String pcategory) {
	this.pcategory = pcategory;
}
public String getPimage() {
	return pimage;
}
public void setPimage(String pimage) {
	this.pimage = pimage;
}

@Override
public String toString() {
	return "Product [pid=" + pid + ", sid=" + sid + ", pname=" + pname + ", pprice=" + pprice + ", pcategory="
			+ pcategory + ", pimage=" + pimage + "]";
}



}
