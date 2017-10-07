abstract class Vehicle
{
	void method1()
	{
		System.out.println("YoYo");
	}
}

class Car extends Vehicle
{
	int  a = 2;
	void method2()
	{
		int b = 3;
		System.out.println("Yo");
		class Car2
		{
			void method3()
			{
				System.out.println(a + b);
			}
		}
		Car2 c1 = new Car2();
		c1.method3();
	}
}

public class Try
{
	public static void main(String args[])
	{
		Car c = new Car();
		c.method2();
		//Car2 c1 = new Car.Car2();
		//c1.method3();
		Object o1 = new Object();
		String s1 = (String)o1;
		System.out.println(s1);
//		c.method4();
	}
}
