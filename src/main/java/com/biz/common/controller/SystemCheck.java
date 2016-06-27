package com.biz.common.controller;

import java.lang.management.ManagementFactory;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  시스템 정상 체크와 관련한 컨트롤러
 *   - ex) WAS, DB가 다운되었는지 외부에서 호출하는 URL 제공
 *  
 * @author 엄승하
 */
@Controller
@RequestMapping("/systemCheck")
public class SystemCheck {
	private static final Logger LOG = LoggerFactory.getLogger(SystemCheck.class);

	@Autowired
	private ApplicationContext ctx;

	/**
	 * 정상인지 체크
	 * 
	 * @return
	 */
	@RequestMapping(value = "/checkOn")
	public ResponseEntity<String> checkOn() {

		try {

			//TODO-FIXME: DB 체크기능 추가
			return new ResponseEntity<String>("Server is ON.", HttpStatus.OK);

		} catch (Exception e) {
			LOG.error("Exception msg:{} | stack trace:", e.getMessage(), e);
			return new ResponseEntity<String>("Server is ERROR.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 현재 스레드풀 및 전체 스레드갯수 정보를 리턴
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/threadPool/currentInfo")
	public LinkedHashMap<String, Object> getCurrentThreadInfo() {

		ThreadPoolTaskExecutor taskExecutor = ctx.getBean(ThreadPoolTaskExecutor.class);

		LinkedHashMap<String, Object> rtn = new LinkedHashMap<String, Object>();
		rtn.put("currentActiveCount", taskExecutor.getActiveCount()); //현재활성 스레드 갯수
		rtn.put("currentPoolSize", taskExecutor.getPoolSize()); //현재 스레드풀의 갯수
		rtn.put("corePoolSize", taskExecutor.getCorePoolSize()); //active 스레드 수가 코어갯수보다 적다면 놀고있는 스레드를 먼저 사용
		rtn.put("maxPoolSize", taskExecutor.getMaxPoolSize()); //최대 스레드풀 갯수
		rtn.put("keepAliveSeconds", taskExecutor.getKeepAliveSeconds()); //해당 시간만큼 아무일도 하지 않는 스레드는 없앰
		rtn.put("threadNamePrefix", taskExecutor.getThreadNamePrefix());
		rtn.put("systemTotalThreadCount", ManagementFactory.getThreadMXBean().getThreadCount()); //프로그램의 전체 스레드 갯수

		return rtn;
	}

}
