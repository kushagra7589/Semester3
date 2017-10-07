import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[100000];
		int n = input.nextInt();
		System.out.print("N = ");
		System.out.println(n);
		for(int i = 0; i < n; i++){
			arr[i] = input.nextInt();
		}
		// for(int x: arr){
		// 	System.out.println("Index: ");
		// 	System.out.println(x);
		// }
		int l = 0;
		int u = n;
		while(l < u){
			int mid = l + (u-l)/2;
			if(arr[mid] == 1)
				u = mid;
			else
				l = mid + 1;
		}
		System.out.println(l);
	}
}