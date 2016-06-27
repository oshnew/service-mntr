package com.biz.common;

/**
 * Sql 세션 명 정의 상수
 *  - context-mybatis-mapper.xml 파일의 SqlSessionTemplate 빈 ID와 같아야 한다.
 *  
 * @author 엄승하
 */
public class SqlSessionNm {

	/** DB Sql세션명(모니터링 마스터) **/
	public static final String MNTR_MASTER = "mntr-master-sqlSession";

	/** DB Sql세션명(모니터링 SLAVE) **/
	public static final String MNTR_SLAVE = "mntr-slave-sqlSession";

}