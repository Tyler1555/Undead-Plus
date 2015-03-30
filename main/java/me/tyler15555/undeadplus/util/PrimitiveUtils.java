package me.tyler15555.undeadplus.util;

public class PrimitiveUtils {

	public static boolean fromInt(int i) {
		switch(i) {
		case 0:
			return false;
		case 1:
			return true;
		default:
			return false;
		}
	}
	
	public static int fromBoolean(boolean bool) {
		return bool == true ? 1 : 0;
	}

}
