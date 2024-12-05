package com.divineion.utils.validators;

import com.divineion.utils.ApplicationMessages;
import com.divineion.utils.exceptions.PositiveIntegerValueRequiredException;

public class BirdValidator {
	public static void validateNumberOfFeathers(int numberOfFeathers) throws PositiveIntegerValueRequiredException {
		if (numberOfFeathers < 0 || numberOfFeathers %1 !=0) {
			throw new PositiveIntegerValueRequiredException(ApplicationMessages.BIRD_FEATHERS_ERROR + ApplicationMessages.POSITIVE_VALUE_REQUIRED);
		}
	}
}
