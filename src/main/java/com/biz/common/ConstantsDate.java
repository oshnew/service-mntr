package com.biz.common;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 날짜관련 상수 클래스
 * 
 * @author 엄승하
 */
public class ConstantsDate {

	/** 날짜포맷 : yyyyMMddHHmmss  */
	public static final String YMDHIS = "yyyyMMddHHmmss";

	/** 날짜포맷 : yyyy-MM-dd HH:mm:ss  */
	public static final String READABLE_YMDHIS = "yyyy-MM-dd HH:mm:ss";

	/** 날짜포맷 : yyyy-MM-dd */
	public static final String READABLE_YMD = "yyyy-MM-dd";

	/** 날짜포맷 : yyyyMM  */
	public static final String YM = "yyyyMM";

	/** 날짜포맷 : yyyyMMdd  */
	public static final String YMD = "yyyyMMdd";

	/** 날짜포맷 : yyyyMMddHH  */
	public static final String YMDH = "yyyyMMddHH";

	/** 날짜포맷 : yyyyMMddHHmm  */
	public static final String YMDHI = "yyyyMMddHHmm";

	/** 날짜포맷(시분_1) : HH:mm  */
	public static final String HM_1 = "HH:mm";

	/** JODA 포맷터 : yyyyMM  */
	public static final DateTimeFormatter FMTR_YM = DateTimeFormat.forPattern(YM);

	/** JODA 포맷터 : yyyyMMdd  */
	public static final DateTimeFormatter FMTR_YMD = DateTimeFormat.forPattern(YMD);

	/** JODA 포맷터 : yyyyMMddHH  */
	public static final DateTimeFormatter FMTR_YMDH = DateTimeFormat.forPattern(YMDH);

	/** JODA 포맷터 : yyyyMMddHHmm  */
	public static final DateTimeFormatter FMTR_YMDHI = DateTimeFormat.forPattern(YMDHI);

	/** JODA DateTimeFormatter : Etc/GMT이 포함된 yyyyMMddHHmmss용  */
	public static final DateTimeFormatter FMT_ETC_TIMEZONE_YMDHIS = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss ZZZ");

	/** JODA DateTimeFormatter : yyyyMMddHHmmss용  */
	public static final DateTimeFormatter FMTR_YMDHIS = DateTimeFormat.forPattern(YMDHIS);

	/** JODA DateTimeFormatter : yyyy-MM-dd HH:mm:ss용  */
	public static final DateTimeFormatter FMTR_READ_YMDHIS = DateTimeFormat.forPattern(READABLE_YMDHIS);

}
