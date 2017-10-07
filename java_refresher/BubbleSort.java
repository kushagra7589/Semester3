import java.util.Scanner;

public class BubbleSort {
	public static int [] sort(int[] arr, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n-i-1;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		for(int i=0; i<n; i++){
			array[i] = input.nextInt();
		}
		array = sort(array, n);
		for(int x:array){
			System.out.print(x);
			System.out.print(" ");
		}
		System.out.println();
 	}
}