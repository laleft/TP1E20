package ayp2.tp1.e20;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase para jugar el juego GuessTheNumber
 * El programa genera un número aleatorio en el
 * rango de 1 a 1000 (ambos inclusive)
 * y el usuario debe adivinar qué número es.
 * 
 * @author sdebernardez
 * @version 1.0
 * 
 * @ TODO: Posibilidad de elegir el rango del número a adivinar
 */
public class GuessTheNumber {
	
	private static int[] numbers = new int[1000]; // array para almacenar los número de 1 a 1000
	Random random = new Random();
	Scanner scanner = new Scanner(System.in);
	
	public GuessTheNumber() {
		initRange();
		showIntro();
		runGame();	
	}
	
	/**
	 * Inicializa el array 'numbers'
	 * 
	 * @param
	 * @return void
	 */
	private static void initRange() {
		for(int x = 0; x < 1000; x++) {
			numbers[x] = x + 1;
		}
	}
	
	/**
	 * Muestra una pantalla de bienvenida y las instrucciones del juego
	 * 
	 * @param
	 * @return void
	 */
	private void showIntro() {
		System.out.print("Bienvenid@ al juego de adivinar el número.\n\n");
		System.out.print("Voy a pensar un número del 1 al 1000 y deberás que adivinarlo.\n\n");
		System.out.print("Cómo pista te diré si el número que ingresaste es menor o mayor al número que elegí.\n\n");
		System.out.print("Comencemos!\n");
	}
	
	
	 /**
	  * Es el método que mantiene corriendo el juego hasta que el usuario
	  * decida salir
	  * 
	  * @param
	  * @return void
	  */
	private void runGame() {
		boolean quit = false;
		
		// Mientras 'quit' sea falso se jugará otra partida
		while(!quit) {
			
			// Ejecuta el juego
			play();
			
			System.out.print("Ingresá 'N' para salir o Enter para jugar de nuevo.");
			String choice = scanner.nextLine();
			if(choice.startsWith("N") || choice.startsWith("n")) {
				System.out.print("\nGracias por jugar conmigo. Hasta pronto!\n");
				quit = true;
			}
		}
	}  
	
	/**
	 * Ejecuta el juego
	 * 
	 * @param
	 * @return void
	 */
	private void play() {

		int numberToGuess = getRandomNumber(); // obtiene un número aleatorio
		int userNumber;
		int rounds = 0;
		do {
			
			System.out.print("\nIngresá un número entre 1 y 1000: ");
			
			// Valida que lo ingresado sea un número
			while(!scanner.hasNextInt()) {
				System.out.print("\n### ¡Por favor, ingresa sólo números!\n");
				System.out.print("\nIngresá un número entre 1 y 1000: ");
				scanner.next();
			}
			
			userNumber = scanner.nextInt();				
			scanner.nextLine(); // limpia el buffer
			
			// Compara los números
			if(userNumber > numberToGuess) {
				System.out.print("Mi número es menor!\n");
			} else if(userNumber < numberToGuess) {
				System.out.print("Mi número es mayor!\n");
			}
			
			rounds++; // Incrementa el número de intentos
			
		} while(numberToGuess != userNumber);
		
		System.out.printf("\n\n*** ¡ADIVINASTE EL NÚMERO EN %d INTENTOS! ***\n\n", rounds);
		
	}
	
	/**
	 * Obtiene un número aleateorio
	 * 
	 * @param
	 * @return int Número aleatorio
	 */
	private int getRandomNumber() {
		return random.nextInt(numbers.length); 
	}
	
}
