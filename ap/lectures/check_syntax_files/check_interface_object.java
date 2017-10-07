interface a {
	void method1();
	// {
	// 	System.out.println("Hello");
	// }
}

class b implements a {
	public void method1()
	{
		int x = 10;
	}
}

class c extends b {
	public void hello(){
		System.out.println("Hello");
	}
}

class driver {
	public static void main(String args[])
	{
		a A;
		b B;
		c C = new c();
		A = C;
		A.method1();
		// A.hello();
	}
}