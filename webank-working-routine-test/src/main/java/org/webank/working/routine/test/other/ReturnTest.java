package org.webank.working.routine.test.other;

public class ReturnTest {

	public boolean returnFlag(){

		boolean a = getTrue();
		boolean b = getFalse();
		
		
		//从字节码来看都是相同的if else 模式
		//if(a && b)
		//	return true;
		//return false;
		
		return a && b;
	}
	
	public boolean getTrue(){
		return true;
	}
	
	public boolean getFalse(){
		return false;
	}
}
