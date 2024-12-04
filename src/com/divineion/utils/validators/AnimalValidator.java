package com.divineion.utils.validators;

import com.divineion.utils.ApplicationMessages;
import com.divineion.utils.exceptions.EmptyValueException;
import com.divineion.utils.exceptions.NameFormatException;
import com.divineion.utils.exceptions.PositiveValueRequiredException;
import com.divineion.utils.exceptions.TooShortValueException;

public class AnimalValidator {
	public static void validateAnimalAge(int age) throws PositiveValueRequiredException {
		if (age < 0) {
			throw new PositiveValueRequiredException("Erreur -> âge de l'animal : " + ApplicationMessages.POSITIVE_VALUE_REQUIRED);
		}
	}
	
	public static void validateAnimalName(String name) throws EmptyValueException, TooShortValueException, NameFormatException {
		if (name.isEmpty()) {
			throw new EmptyValueException(ApplicationMessages.ANIMAL_NAME_ERROR + ApplicationMessages.VALUE_CANNOT_BE_EMPTY);
		}
		
		if (name.length() < 3) {
			throw new TooShortValueException(ApplicationMessages.ANIMAL_NAME_ERROR + ApplicationMessages.VALUE_TOO_SHORT);
		}
		
		if (!name.substring(0,1).equals(name.substring(0,1).toUpperCase())) {
			throw new NameFormatException(ApplicationMessages.ANIMAL_NAME_ERROR + ApplicationMessages.CAPITALIZED_REQUIRED);
		}
	}
}
