import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int fib[] = new int[n+2];
		fib[0] = 1;
		fib[1] = 1;
		System.out.print(fib[0]);
		System.out.print(" ");
		System.out.print(fib[1]);
		for(int i=2; fib[i-1]<n; ++i){
			fib[i] = fib[i-1] + fib[i-2];
			if(fib[i] <= n){
				System.out.print(" ");
				System.out.print(fib[i]);
			}
		} 
		System.out.println();
	}
}