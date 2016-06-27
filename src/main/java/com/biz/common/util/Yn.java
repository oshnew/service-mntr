package com.biz.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * YN관련 클래스 
 *  - 대소문자 무관하게 처리(파라미터를 대문자로 치환하여 처리)
 * 
 * @author 엄승하
 */
public class Yn {
	public static final String YY = "Y";
	public static final String NN = "N";

	public static boolean yes(String yn) {
		return YY.equals(StringUtils.upperCase(yn));
	}

	public static boolean no(String yn) {
		return NN.equals(StringUtils.upperCase(yn));
	}

	public static boolean isValidYn(String yn) {

		if (YY.equals(yn) == false && NN.equals(yn) == false) {
			return false;
		}

		return true;
	}
}