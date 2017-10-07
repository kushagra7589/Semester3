import java.util.Scanner;

public class Permutation {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] letters_in_a = new int[26];
		int[] letters_in_b = new int[26];
		String a = input.nextLine();
		String b = input.nextLine();
		for(int i = 0; i<a.length(); i++){
			letters_in_a[a.charAt(i) - 97]++;
			letters_in_b[b.charAt(i) - 97]++;
		}
		int flag = 1;
		for(int i=0; i<26; i++){
			if(letters_in_a[i] != letters_in_b[i]){
				System.out.println("Not a permutation!");
				flag = 0;
				break;
			}
		}
		if(flag == 1)
			System.out.println("Permutation");
	}
}