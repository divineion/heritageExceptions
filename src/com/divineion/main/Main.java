package com.divineion.main;

import java.util.Scanner;

import com.divineion.entities.*;
import com.divineion.utils.ApplicationMessages;
import com.divineion.utils.exceptions.AnimalBreedException;
import com.divineion.utils.exceptions.EmptyValueException;
import com.divineion.utils.exceptions.NameFormatException;
import com.divineion.utils.exceptions.PositiveValueRequiredException;
import com.divineion.utils.exceptions.TooShortValueException;


public class Main {
	static boolean exit = false;

	public static void main(String[] args) throws PositiveValueRequiredException {		
		Scanner scanner = new Scanner(System.in);	
		
			while (exit == false) {
				try {
					System.out.println("Voulez-vous rentrer un chien, un oiseau, ou voulez-vous interrompre la saisie ? Saisir \"chien\", \"oiseau\" ou \"fin\"");
					String action = scanner.nextLine();

					switch (action) {
						case "chien": {
							handleDog(action, scanner);
							break;
						}
						case "oiseau": {
							handleBird(action, scanner);
							break;
						}
						case "fin": {
							System.out.println(ApplicationMessages.END_OF_PROGRAMM);
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
					System.out.println(e);
				}
			}
		}
	
	public static boolean handleDog(String action, Scanner scanner) throws PositiveValueRequiredException, AnimalBreedException, EmptyValueException, TooShortValueException, NameFormatException {
		
		try {
		String species = action;
		
		System.out.println("Veuillez saisir le nom du chien (minimum 3 lettres)");
		String name = scanner.nextLine();
		
		System.out.println("Veuillez saisir l'âge du chien en années arrondi à l'entier inférieur");
		int age = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Veuillez saisir la race du chien");
		String breed = scanner.nextLine();
		
		Animal dog = new Dog(name, species, age, breed);
		System.out.println(dog);
		
		System.out.println("Veuillez saisir : \n \"OK\" pour finaliser l'enregistrement et quitter \n \"fin\" pour quitter le programme sans enregistrer l'animal en cours \n Sinon, pressez \"Entrée\" pour finaliser cet enregistrement et saisir un nouvel animal");
		String confirmation = scanner.nextLine();
		
		if (confirmation.equals("OK")) {
			AnimalsList.addAnimal(dog);
			System.out.println(ApplicationMessages.END_OF_PROGRAMM);
			return exit = true;
		} else if (confirmation.equals("fin")) {
			System.out.println(ApplicationMessages.END_OF_PROGRAMM);
			return exit = true;
		} 
		AnimalsList.addAnimal(dog);
		AnimalsList.listAllAnimals();
		return exit = false;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return exit;
	};
	
	public static boolean handleBird(String action, Scanner scanner) {
		String species = action;
		try {
			System.out.println("Veuillez saisir le nom de l'oiseau (minimum 3 lettres)");
			String name = scanner.nextLine();
			
			System.out.println("Veuillez saisir l'âge de l'oiseau arrondi à l'entier inférieur");
			int age = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Veuillez saisir le nombre de plumes de l'animal");
			int feathers = Integer.parseInt(scanner.nextLine());
			
			Animal bird = new Bird(name, species, age, feathers);
			System.out.println(bird);
			
			System.out.println("Veuillez saisir : \n \"OK\" pour finaliser l'enregistrement et quitter \n \"fin\" pour quitter le programme sans enregistrer l'animal en cours \n Sinon, pressez \"Entrée\" pour finaliser cet enregistrement et saisir un nouvel animal");
			String confirmation = scanner.nextLine();
			
			if (confirmation.equals("OK")) {
				AnimalsList.addAnimal(bird);
				System.out.println(ApplicationMessages.END_OF_PROGRAMM);
				return exit = true;
			} else if (confirmation.equals("fin")) {
				System.out.println(ApplicationMessages.END_OF_PROGRAMM);
				return exit = true;
			}
			AnimalsList.addAnimal(bird);
			AnimalsList.listAllAnimals();
			return exit = false;
		} 
		catch(Exception e) {
			System.out.println(e);
		}
		
		return exit;
	};
}
