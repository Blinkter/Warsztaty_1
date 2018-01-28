package Symulator_LOTTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Symulator_LOTTO {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		//DODAWANIE LICZB DO TABLIC
		System.out.println("Podaj liczbę");
		Integer[] shot = new Integer[6];
		Integer[] numbers = new Integer[50];
		for(int i=0; i < numbers.length; i++){
			numbers[i]=i+1;
		}
		for(int i=0; i < shot.length; i++){
			while(!scan.hasNextInt()){
				scan.next();
				System.out.println("to nie jest liczba");
			}
			boolean check = true;
			Integer temp = scan.nextInt();
			if(0>temp || temp>50){
				System.out.println("Liczba nie mieści się w podanym zakresie");	
				check=false;
				i--;
			}
			
			
			for(int j = 0; j < shot.length; j++){
				if(temp == shot[j]){
					System.out.println("taka liczba już jest");	
					check=false;
					i--;
				}
			}
				if(check==true){
					shot[i] = temp;
					check = true;
				}
			
		}
		int count=0;
		
		
		Arrays.sort(shot);
		System.out.println(Arrays.toString(shot));
		Collections.shuffle(Arrays.asList(numbers));
		System.out.print("Wylosowane: ");
		for(int i=0;i<6;i++){
		System.out.print(numbers[i]+" ");
		}
		for(int i=0; i < shot.length; i++){
			for(int j=0; j < shot.length; j++){
				if(shot[i]==numbers[j]){
					count++;
				}
			}
		}
		if(count==3){
			System.out.println("Trafiłeś 3 razy.");
		}else if(count==4){
			System.out.println("Trafiłeś 4 razy.");
		}else if(count==5){
			System.out.println("Trafiłeś 5 razy.");
		}else if(count==6){
			System.out.println("Trafiłeś 6 razy.");
		}else{
			System.out.println("Trafiłeś 2 lub mniej razy.");
		}
		scan.close();
	}
}
