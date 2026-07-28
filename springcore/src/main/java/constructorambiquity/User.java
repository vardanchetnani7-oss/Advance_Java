package constructorambiquity;


public class User {

	private int i;
	private int j;
	public User(int i, int j) {
		super();
		System.out.println("int constructor called");
		this.i = i;
		this.j = j;
	}
	
	public User(String i,String j) {
		super();
		System.out.println("String constructor called");
		this.i = Integer.parseInt(i);
		this.j = Integer.parseInt(j);
	}
	
	public User(double i, double j) {
		System.out.println("double constructor called");
		this.i = (int) i;
		this.j = (int) j;
	}

	@Override
	public String toString() {
		return "User [i=" + i + ", j=" + j + "]";
	}
	
}