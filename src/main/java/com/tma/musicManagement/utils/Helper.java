package com.tma.musicManagement.utils;

import java.util.Collection;

public class Helper {
	public static int size(Iterable<?> it) {
		if (it instanceof Collection)
			return ((Collection<?>) it).size();
		return 0;
	}
}
