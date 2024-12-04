package com.divineion.entities;

import com.divineion.utils.exceptions.EmptyValueException;
import com.divineion.utils.exceptions.NameFormatException;
import com.divineion.utils.exceptions.PositiveValueRequiredException;
import com.divineion.utils.exceptions.TooShortValueException;
import com.divineion.utils.validators.BirdValidator;

public class Bird extends Animal {
	private int numberOfFeathers;

	public Bird(String name, String espece, int age, int numberOfFeathers) throws PositiveValueRequiredException, EmptyValueException, TooShortValueException, NameFormatException {
		super(name, espece, age);
		BirdValidator.validateNumberOfFeathers(numberOfFeathers);
		this.numberOfFeathers = numberOfFeathers;
	}
	
	public int getNumberOfFeathers() {
		return numberOfFeathers;
	}

	public void setNombreDePlumes(int numberOfFeathers) throws NumberFormatException {
		if (numberOfFeathers < 0) {
			
		}
		this.numberOfFeathers = numberOfFeathers;
	}
	
	void fly() {
		System.out.println("Je vole");
	}
	
	@Override
	public void feed(String food) {
		System.out.println("Je ne mange que " + food);
	}


	@Override
	public void sleep() {
		System.out.println("Je dors dans un nid.");
	}
	
	@Override
	public String toString() {
		return super.toString() +  " et j'ai " + numberOfFeathers + " plumes";
	}
	
	@Override
	public void behave() {
		fly();
	}
}
