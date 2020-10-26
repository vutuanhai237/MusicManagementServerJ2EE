package com.tma.musicManagement.validation;

import com.tma.musicManagement.model.Genre;
import com.tma.musicManagement.utils.Constant;

public class GenreValidation {
	public static String check(Genre genre) throws Exception {
		try {
			if (genre.getName().length() < 100 || genre.getName().length() > 1) {
				return Constant.VALID;
			}
			return Constant.GENRE_NOT_VALID;
		} catch (Exception e) {
			throw new Exception(Constant.GENRE_NULL);
		}

	}

}
