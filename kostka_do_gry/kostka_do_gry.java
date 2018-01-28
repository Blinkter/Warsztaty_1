package kostka_do_gry;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class kostka_do_gry {

	static Scanner scan;
	
	public static void main(String[] args) {
		
		System.out.println("Typy kostek występujące w grach: D3, D4, D6, D8, D10, D12, D20, D100"
				+ "\nWybierz kość i wpisz ilość rzutów i modyfikator w formacie nxDy+z "
				+ "\nnp. 2D10+4");
		
		scan = new Scanner(System.in);
		String arg = scan.nextLine();
		diceRoll(arg);
		scan.close();
	}
	
	static int diceRoll(String arg){
		scan = new Scanner (System.in);
		int nDice = 0;		//ilość kości
		int dice = 0; 		//ilość ścian kości
		int mod = 0;		//modyfikator
		
		int[] propDice = {3,4,6,8,10,12,20,100};
		char[] controlArr = arg.toCharArray();	//tablica znaków
		String temp="";		//zmienna pomocnicza 
		boolean status = true;
		int score =0;
		Random generate = new Random();
		try{
			
				int pos1 = arg.indexOf('D'); //pozycja znaku D
				while(true){
					if(pos1 == 0){
						nDice = 1;
						break;
					}else		
					for(int i=0; i<pos1; i++){
						temp += Character.toString(controlArr[i]);  //pobierz ilość kości
					}
					nDice = Integer.valueOf(temp);
					temp = "";
					break;
				}
				
				if(arg.contains("+")){		//sprawdz czy istnieje modyfikator
					int pos2 = arg.indexOf('+'); //pozycja znaku +
					for(int i=pos1+1; i<pos2; i++){
						temp += Character.toString(controlArr[i]);  //pobierz ilość ścian kości
					}
					dice = Integer.valueOf(temp);
					temp = "";

					for(int i=pos2+1; i<controlArr.length; i++){
						temp += Character.toString(controlArr[i]);	//pobierz modyfikator
					}
					mod = Integer.valueOf(temp);
					temp = "";
				}else{							//brak znaku +
					for(int i=pos1+1; i<controlArr.length; i++){
						temp += Character.toString(controlArr[i]);  //pobierz ilość ścian kości
					}
					dice = Integer.valueOf(temp);
					mod = 0;
					temp = "";
				}
				
				outerLoop:
					while(status){								//sprawdz czy istnieje kostka o podanym rozmiarze
						for(int i=0; i<propDice.length; i++){
							if(dice == propDice[i]){
								break outerLoop;
							}						
						}
						System.out.println("Nie ma takiej kostki!");
						return -1;
					}
					temp = "";
			
			for(int i=0; i<nDice; i++){ //symulacja rzutów
				score += (generate.nextInt(dice)+1);
			}
			score += mod;
			System.out.println(score);
			return score;
			
		}catch (NumberFormatException e) {
			System.err.println("Niepoprawny format");
			return -1;
		}	
	}
}
