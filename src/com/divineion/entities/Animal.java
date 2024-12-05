package com.divineion.entities;

import com.divineion.utils.exceptions.EmptyValueException;
import com.divineion.utils.exceptions.NameFormatException;
import com.divineion.utils.exceptions.PositiveIntegerValueRequiredException;
import com.divineion.utils.exceptions.TooShortValueException;
import com.divineion.utils.validators.AnimalValidator;

public abstract class Animal {
	/**
	 * Animal class constructor
	 * @param name : the name of the animal ; must be capitalized, cannot be neither empty nor null.
	 * @param species : the animal species ; cannot be neither empty nor null.
	 * @param age : the animal age ; cannot be neither null nor negative. 
	 * 
	 */
	protected String name;
	protected String species;
	protected int age;
	
	public Animal(String name, String species, int age) throws PositiveIntegerValueRequiredException, EmptyValueException, TooShortValueException, NameFormatException {
		setName(name);
		setSpecies(species);
		setAge(age);
	}

	/**
	 * @return the animal name 
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * @return the species of the animal
	 */
	public String getSpecies() {
		return this.species;
	}
	
	/**
	 * @return the age of the animal
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Define the name of the animal
	 * @param nom
	 * @throws NameFormatException 
	 * @throws TooShortValueException 
	 * @throws EmptyValueException 
	 */
	public void setName(String name) throws EmptyValueException, TooShortValueException, NameFormatException {
		AnimalValidator.validateAnimalName(name);
		this.name = name;
	}
	
	/**
	 * Define the species of the animal
	 * @param species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	
	/**
	 * Define the age of the animal
	 * @param age
	 * @throws PositiveIntegerValueRequiredException 
	 */
	public void setAge(int age) throws PositiveIntegerValueRequiredException {
		AnimalValidator.validateAnimalAge(age);
		this.age = age;
	}
	
	/**
	 * Method to define how  the animal feed
	 * @param nourriture
	 */
	public void feed(String food) {
		System.out.println("Je peux manger " + food);
	};
	
	public abstract void sleep();
	
	public abstract void behave();
	
	@Override
	public String toString() {
		return "Je m'appelle "+ this.name + ", j'ai " + this.age + " ans et je suis un "+ this.species;
	}
}
