package com.biz.common.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date관련 유틸
 *
 * @author 엄승하
 */
public class DateUtil {
	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	/**
	 * 문자열 String이 해당 포맷에 맞는지 체크
	 * 
	 * @param checkStr 체크할 날짜 String
	 * @param checkFmt 체쿠할 날짜 포맷
	 * @return
	 */
	public static boolean isValidFormat(String checkStr, DateTimeFormatter checkFmt) {

		try {
			DateTime.parse(checkStr, checkFmt); //parse를 이용해서 포맷 체크
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}