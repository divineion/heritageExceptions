package com.divineion.main;

import java.util.Scanner;

import com.divineion.entities.*;
import com.divineion.utils.ApplicationMessages;
import com.divineion.utils.exceptions.EmptyValueException;
import com.divineion.utils.exceptions.NameFormatException;
import com.divineion.utils.exceptions.PositiveIntegerValueRequiredException;
import com.divineion.utils.exceptions.TooShortValueException;
import com.divineion.utils.validators.AnimalValidator;
import com.divineion.utils.validators.BirdValidator;
import com.divineion.utils.validators.DogValidator;


public class Main {
	static boolean exit = false;
	
	public static void createDog() throws PositiveIntegerValueRequiredException, EmptyValueException, TooShortValueException, NameFormatException {
		try {
			Dog chien = new Dog("Gfjf", "Chien", 5, "pit");
			System.out.println(chien);
		}
		catch(TooShortValueException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
			
			while (!exit) {
				try {
					System.out.println("Voulez-vous rentrer un chien, un oiseau, ou voulez-vous interrompre la saisie ? Saisir \"chien\", \"oiseau\" ou \"fin\"");
					String select = scanner.nextLine();

					switch (select) {
						case "chien": {
							exit = handleDog(select, scanner);
							break;
						}
						case "oiseau": {
							exit = handleBird(select, scanner);
							break;
						}
						case "fin": {
							System.out.println(ApplicationMessages.END_OF_PROGRAM);
							exit = true;
							break;
						}
						default: {
							System.out.println("Veuillez rectifier votre saisie. \n ");
							break;
						}
					} 
				}
				catch(Exception e) {
					System.out.println("Une erreur inattendue est survenue  :"+ e.getMessage());
				}
			}
			
			AnimalsList.listAllAnimals();

		}
	
	/**
	 * @param select : the user's choice from the start of the while loop (should be "chien")
	 * @param scanner : Scanner object to capture user input
	 * @return boolean : returns true to end the main program loop ; false to continue
	 * @throws PositiveIntegerValueRequiredException  : if a required number value is negative or decimal
	 * @throws EmptyValueException : if a required value is empty
	 * @throws TooShortValueException : name or breed shorter than 3 characters
	 * @throws NameFormatException : name does not start with an uppercase letter
	 * 
	 * 
	 * Steps : 
	 *  - prompts the user for the Dog's detail (name, age, breed);
	 *  - validates input in real-time;
	 *  - creates a Dog object and add it to the AnimalsList;
	 *  - allows the user to continue entering new animals or end the program.
	 */
	public static boolean handleDog(String select, Scanner scanner)  {
		try {
		String species = select;
		
		System.out.println("Veuillez saisir le nom du chien (minimum 3 caractères, commence par une majuscule)");
		String name = scanner.nextLine();
		AnimalValidator.validateAnimalName(name);
		
		System.out.println("Veuillez saisir l'âge du chien en années arrondi à l'entier inférieur");
		int age = Integer.parseInt(scanner.nextLine());
		AnimalValidator.validateAnimalAge(age);
		
		System.out.println("Veuillez saisir la race du chien");
		String breed = scanner.nextLine();
		DogValidator.validateDogBreed(breed);
		
		Animal dog = new Dog(name, species, age, breed);
		System.out.println(dog);
		
		System.out.println("Veuillez saisir : \n \"OK\" pour finaliser l'enregistrement et quitter \n \"fin\" pour quitter le programme sans enregistrer l'animal en cours \n Sinon, pressez \"Entrée\" pour finaliser cet enregistrement et saisir un nouvel animal");
		String confirmation = scanner.nextLine();
		
		if (confirmation.equals("OK")) {
			AnimalsList.addAnimal(dog);
			System.out.println(ApplicationMessages.END_OF_PROGRAM);
			return true;
		} else if (confirmation.equals("fin")) {
			System.out.println(ApplicationMessages.END_OF_PROGRAM);
			return true;
		} 
		AnimalsList.addAnimal(dog);
		AnimalsList.listAllAnimals();
		return false;
		}
		catch(PositiveIntegerValueRequiredException | EmptyValueException | TooShortValueException| NameFormatException e) {
			System.out.println(e);
		}
		catch (NumberFormatException e) {
			System.out.println(ApplicationMessages.ANIMAL_AGE_ERROR + "un nombre entier est requis");		}
		return false;
	};
	
	/**
	 * @param select : the user's choice from the start of the while loop (should be "oiseau")
	 * @param scanner : Scanner object to capture user input
	 * @return boolean : returns true to end the main program loop ; false to continue
	 * @throws PositiveIntegerValueRequiredException  : if age or numberOfFeathers value is negative or decimal
	 * @throws EmptyValueException : if a required value is empty
	 * @throws TooShortValueException : name shorter than 3 characters
	 * @throws NameFormatException : name does not start with an uppercase letter
	 * 
	 * 
	 * Steps : 
	 *  - prompts the user for the Bird's detail (name, age, numberOfFeathers);
	 *  - validates input in real-time;
	 *  - creates a Dog object and add it to the AnimalsList;
	 *  - allows the user to continue entering new animals or end the program.
	 */
	public static boolean handleBird(String select, Scanner scanner) {
		String species = select;
		try {
			System.out.println("Veuillez saisir le nom de l'oiseau (minimum 3 caractères, commence par une majuscule)");
			String name = scanner.nextLine();
			AnimalValidator.validateAnimalName(name);
			
			System.out.println("Veuillez saisir l'âge de l'oiseau arrondi à l'entier inférieur");
			int age = Integer.parseInt(scanner.nextLine());
			AnimalValidator.validateAnimalAge(age);
			
			System.out.println("Veuillez saisir le nombre de plumes de l'animal");
			int feathers = Integer.parseInt(scanner.nextLine());
			BirdValidator.validateNumberOfFeathers(feathers);
			
			Animal bird = new Bird(name, species, age, feathers);
			System.out.println(bird);
			
			System.out.println("Veuillez saisir : \n \"OK\" pour finaliser l'enregistrement et quitter \n \"fin\" pour quitter le programme sans enregistrer l'animal en cours \n Sinon, pressez \"Entrée\" pour finaliser cet enregistrement et saisir un nouvel animal");
			String confirmation = scanner.nextLine();
			
			if (confirmation.equals("OK")) {
				AnimalsList.addAnimal(bird);
				System.out.println(ApplicationMessages.END_OF_PROGRAM);
				return true;
			} else if (confirmation.equals("fin")) {
				System.out.println(ApplicationMessages.END_OF_PROGRAM);
				return true;
			}
			AnimalsList.addAnimal(bird);
			AnimalsList.listAllAnimals();
			return false;
		} 
		catch(PositiveIntegerValueRequiredException | EmptyValueException | TooShortValueException | NameFormatException e) {
			System.out.println(e.getMessage());
		}
		catch (NumberFormatException e) {
			System.out.println("Erreur -> les champs \"âge\" et \"nombre de plumes\" requièrent des nombres entiers.");
		}
		
		return exit;
	};
}
