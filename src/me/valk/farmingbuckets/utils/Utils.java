package me.valk.farmingbuckets.utils;

/**
 * All Rights Reserved 2019
 * Divine Company
 * Valkyrienyanko
 */
public class Utils {
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
