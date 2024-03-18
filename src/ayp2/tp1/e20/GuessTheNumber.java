package ayp2.tp1.e20;

import java.util.Random;
import java.util.Scanner;
/**
 * 
 */
public class GuessTheNumber {
	
	private static int[] numbers = new int[1000];
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	
	public GuessTheNumber() {
		initRange();
		showIntro();
		
		boolean quit = false;
		
		play();

		do {
			System.out.print("Jugar de nuevo? S = Sí / N = No\n");
			String choice = scanner.nextLine();
			if(choice.startsWith("N")) {
				System.out.print("Gracias por jugar. Hasta pronto!");
				quit = true;
			} else {
				//play();
			}
		} while(!quit);
	}
	
	private static void initRange() {
		for(int x = 0; x < 1000; x++) {
			numbers[x] = x++;
		}
	}
	
	private int getRandomNumber() {
		return random.nextInt(numbers.length); 
	}
	
	private void showIntro() {
		System.out.print("Bienvenid@ al juego de adivinar el número.\n\n");
		System.out.print("Voy a pensar un número del 1 al 1000 y deberás que adivinarlo.\n\n");
		System.out.print("Cómo pista te diré si el número que ingresaste es menor o mayor al número que elegí.\n\n");
		System.out.print("Comencemos!\n\n");
	}
	
	private void play() {
		int numberToGuess = getRandomNumber();
		int userNumber;
		
	
		do {
			System.out.print("Ingresá un número entre 1 y 1000: ");
			userNumber = scanner.nextInt();
			if(userNumber > numberToGuess) {
				System.out.print("Mi número es menor!\n");
			} else if(userNumber < numberToGuess) {
				System.out.print("Mi número es mayor!\n\n");
			}
			
		} while(numberToGuess != userNumber);
		
		System.out.print("Adivinaste!\n");
		
	}
	
	  
	
}
