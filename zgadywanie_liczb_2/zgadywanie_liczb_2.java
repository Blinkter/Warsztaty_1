package zgadywanie_liczb_2;
import java.util.Scanner;

public class zgadywanie_liczb_2 {

	public static void main(String[] args) {
		System.out.println("pomyśl liczbę a ja zgadne w max 10 próbach");
		int min = 0;
		int max = 1000;
		boolean gotIt = true;
		int guess;
		Scanner scan = new Scanner(System.in);
		
		while(gotIt){
			guess = ((max-min)/2)+ min;
			System.out.println("Zgaduję: "+guess);
			System.out.println("1 - za dużo\n2 - za mało\n3 - zgadłeś");
			String answer = scan.nextLine();
			
			if(answer.equals("3")){
				System.out.println("Wygrałem");
				break;
			}else if(answer.equals("1")){
				max = guess;
			}else if(answer.equals("2")){
				min = guess;
			}else{
				System.out.println("Nie oszukuj!");
			}
		}
	}
}
//80