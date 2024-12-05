package com.divineion.entities;

import com.divineion.utils.exceptions.EmptyValueException;
import com.divineion.utils.exceptions.NameFormatException;
import com.divineion.utils.exceptions.PositiveIntegerValueRequiredException;
import com.divineion.utils.exceptions.TooShortValueException;
import com.divineion.utils.validators.DogValidator;

public class Dog extends Animal {
	private String breed;
	private String food;

	public Dog(final String name, final String species, final int age, final String breed)
			throws PositiveIntegerValueRequiredException, EmptyValueException, TooShortValueException,
			NameFormatException {
		super(name, species, age);
		setBreed(breed);
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) throws TooShortValueException {
		DogValidator.validateDogBreed(breed);

		this.breed = breed;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public void bark() {
		System.out.println("J'aboie");
	}

	@Override
	public void feed(String food) {
		System.out.println("Je peux manger " + food);
	}

	@Override
	public void sleep() {
		System.out.println("Je dors dans une niche");
	}

	@Override
	public String toString() {
		return super.toString() + " et je suis de race " + breed;
	}

	@Override
	public void behave() {
		bark();
	}
}
