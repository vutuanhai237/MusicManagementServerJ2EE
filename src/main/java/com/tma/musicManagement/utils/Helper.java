package com.tma.musicManagement.utils;

import java.util.Collection;

public class Helper {
	public static int size(Iterable<?> it) {
		return ((Collection<?>) it).size();
	}
}
