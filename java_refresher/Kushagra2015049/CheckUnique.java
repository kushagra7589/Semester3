import java.util.Scanner;

public class CheckUnique {
	public static int CheckChar(String a){
		int[] letters = new int[127];
		for(int i=0; i<a.length(); i++){
			letters[a.charAt(i)]++;
		}
		for(int x:letters){
			if(x>1)
				return 0;
		}
		return 1;
	}
	public static int CheckWord(String a){
		String[] array = a.split(" ");

		for(int i =1; i<array.length; i++){
			for(int j =0; j<i; j++){
				if(array[i].equals(array[j]))
					return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		System.out.println(a);
		System.out.print("Unique characters[0/1]: ");
		System.out.println(CheckChar(a));
		System.out.print("Unique words[0/1]: ");
		System.out.println(CheckWord(a));
	}
}