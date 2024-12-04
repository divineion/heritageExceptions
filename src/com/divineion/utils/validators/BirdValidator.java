package com.divineion.utils.validators;

import com.divineion.utils.ApplicationMessages;
import com.divineion.utils.exceptions.PositiveValueRequiredException;

public class BirdValidator {
	public static void validateNumberOfFeathers(int numberOfFeathers) throws PositiveValueRequiredException {
		if (numberOfFeathers < 0 || numberOfFeathers %1 !=0) {
			throw new PositiveValueRequiredException(ApplicationMessages.BIRD_FEATHERS_ERROR + ApplicationMessages.POSITIVE_VALUE_REQUIRED);
		}
	}
}
