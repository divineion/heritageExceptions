package com.divineion.entities;

import java.util.HashSet;

public class AnimalsList {
	private static HashSet <Animal> list = new HashSet<Animal>();
	
	public static void addAnimal(Animal animal) {
		if (AnimalsList.list.add(animal)) {
			System.out.println("L'animal " + animal.name + " a été enregistré");
		
		} else {
			System.out.println("problème pendant l'enregistrement de l'animal");
		}
	}
	
	public static void removeAnimal(Animal animal) throws Exception {
		AnimalsList.list.remove(animal);
		if (list.contains(animal)) {
			throw new Exception("L'animal n'a pas été supprimé");
		}
	}
	
	public static void listAllAnimals() {
		StringBuilder list = new StringBuilder();
		for (Animal animal :  AnimalsList.list) {
			list.append(animal.getName()).append(" (").append(animal.getClass().getSimpleName()).append(") ").append("\n");
		}
		System.out.println("liste des animaux enregistrés : \n" + list.toString() + "\n");
	}
	
}
