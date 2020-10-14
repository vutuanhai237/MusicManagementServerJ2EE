package com.tma.musicManagement.validation;

import com.tma.musicManagement.model.Music;
import com.tma.musicManagement.utils.Constant;

public class MusicValidation {
	public static String check(Music music) throws Exception {
		try {
			return GenreValidation.check(music.getGenre());
		} catch (Exception e) {
			throw new Exception(Constant.genreNull);
		}
	}
}
