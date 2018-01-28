package zgadywanie_liczb;
import java.util.Random;
import java.util.Scanner;

public class zgadywanie_liczb {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Random generator = new Random();
		int randomNumber = generator.nextInt(100)+1;
		System.out.println("Zgadnij liczbę");
		while(true){
			while(!scan.hasNextInt()){
				scan.next();
				System.out.println("To nie jest liczba!");
			}
			
			int userNumber = scan.nextInt();
			if(userNumber < randomNumber){
					System.out.println("Za mało");
			}else if(userNumber < randomNumber){
					System.out.println("Za dużo");
			}else{
					System.out.println("Zgadłeś");
					break;
			}
		}
	}
}
