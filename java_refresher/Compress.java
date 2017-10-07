import java.util.Scanner;

public class Compress {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		String com  = "" + a.charAt(0);
		int count = 1;
		for(int i=1; i<a.length(); ++i){
			if(a.charAt(i) ==  a.charAt(i-1)){
				count++;
			}
			else{
				com = com + count;
				com = com + a.charAt(i);
				count = 1;
			}
		}
		com = com + count;
		System.out.println(com);
	}
}