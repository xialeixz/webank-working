package org.webank.working.routine.test.logger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTester {

	private Logger logger = LoggerFactory.getLogger(LogTester.class);
	
	@Test
	public void test(){
		logger.info("this is info msg : {}", 1);
		logger.error("this is error msg : {}", 2);
		logger.debug("this is debug msg : {}", 2);
		
		//hehe
		
		//bababab
	}
	
}
