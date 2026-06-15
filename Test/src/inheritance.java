
class A {
	
// default constructor
A(){
	System.out.println("default A constructor");
}
//constructor
A(int i){
	System.out.println("i="+i);
}

public void classA() {
	System.out.println("method 1");
}

}
//SINGLE LEVEL INHERITANCE 

class B extends A{
	public void classB() {
		System.out.println("method 2");
	}
}

//MUTLILEVEL INHERITANCE 

class C extends B{
	public void classC() {
		System.out.println("method 3");

	}
}

public class inheritance{
	public static void main(String[] args) {
		B b = new B();
		b.classB();
	}
}




