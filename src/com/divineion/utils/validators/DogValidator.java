package com.divineion.utils.validators;

import com.divineion.utils.ApplicationMessages;
import com.divineion.utils.exceptions.AnimalBreedException;

public class DogValidator {
	public static void validateDogBreed(String breed) throws AnimalBreedException  {
		if (breed.length() < 3) {
			throw new AnimalBreedException(ApplicationMessages.DOG_BREED_ERROR + ApplicationMessages.VALUE_TOO_SHORT + "\n La race de l'animal doit comporter au minimum 3 caractères");
		}
	}
}
