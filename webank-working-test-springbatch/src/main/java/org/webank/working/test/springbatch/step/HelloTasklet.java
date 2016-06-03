package org.webank.working.test.springbatch.step;

import java.text.MessageFormat;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloTasklet implements Tasklet{

	public RepeatStatus execute(StepContribution contribution,
			ChunkContext chunkContext) throws Exception {
		Integer times = (Integer) chunkContext.getAttribute("times");
		times = null == times ? 0 : times;
		if(times <= 20) {
			System.out.println(MessageFormat.format("目前运行到第{0,number}次，运行时间：{1,date,yyyy-MM-dd hh:mm:ss}", 
					times,new Date()));
			times++;
			chunkContext.setAttribute("times", times);
			return RepeatStatus.CONTINUABLE;
		} else {
			System.out.println(MessageFormat.format("目前运行到第{0,number}次，运行时间：{1,date,yyyy-MM-dd hh:mm:ss}", 
					times,new Date()));
			System.out.println("执行Job：hello complete");
			return RepeatStatus.FINISHED;
		}
		
	}

}
