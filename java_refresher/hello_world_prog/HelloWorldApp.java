public class HelloWorldApp {
	public static void main(String[] args){
			System.out.println(args.length);
			if(args.length > 0)
				for(String arg: args){
					System.out.println(arg);
				}
			else
				System.out.println("Hello World!!");

			String str = "Hello Again";
			System.out.println(str);
			str = "Hello Students";
			str.concat(", Welcome");
			System.out.println(str);
			System.out.println(str.concat(", Welcome"));
			str = str.concat(", Welcome");
			System.out.println(str);
			int a  = 10;
			double f = 1.0;
			System.out.printf("%d %.10f\n", a, f);
			double[] myList = new double[10];
			for(int i = 0; i<10 ;i++){
				myList[i] = i*i;
			}
			for(double x : myList){
				System.out.println(x);
			}
 	}	
}