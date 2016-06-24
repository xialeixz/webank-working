package org.webank.working.routine.test.string;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SubStringTest {

	Logger logger = Logger.getLogger(SubStringTest.class);
	
	@Test
	public void testSubString(){
		String deductStageHst = "NNNNNNNOOOONNNNNNNOOO";
		//NNNNNNNOOOONNNNNNNOOO
		//   NNNNOOOONNNNNNNOOO
		//logger.info(deductStageHst.trim().substring(deductStageHst.trim().length() - 3));
		//subString(int index)中index是从首部位置第n个开始截取后续的
		logger.info(deductStageHst.trim().substring(3));
	}
}
