package org.webank.working.thinking.enums;

import java.util.Random;

import org.apache.log4j.Logger;
import org.webank.working.thinking.tools.OutputUtils;

enum Signal
{
	GREEN, YELLOW, RED
}

public class SwitchEnum
{
	private Signal signal;

	private Random random = new Random();
	
	private static Logger logger = Logger.getLogger(SwitchEnum.class);

	public void change()
	{
		this.signal = Signal.values()[random.nextInt(Signal.values().length - 1)];
	}

	@Override
	public String toString()
	{
		String msg = "实例当前持有";

		switch (this.signal)
		{
			case RED:
				msg += "红色信号";
				break;
			case YELLOW:
				msg += "黄色信号";
				break;
			case GREEN:
				msg += "绿色信号";
				break;
			// 注意default并不能解析为null的情况，null在switch中会直接报空指针异常
			default:
				msg += "无色信号";
				break;
		}

		return msg;
	}

	public static void main(String[] args)
	{
		SwitchEnum switchEnum = new SwitchEnum();
		for (int i = 0; i < 7; i++)
		{
			//switchEnum.change();
			logger.debug("hello debug");
			logger.info("hello info");
			logger.error("hello error");
			//OutputUtils.print(switchEnum.toString());
		}
	}
}
