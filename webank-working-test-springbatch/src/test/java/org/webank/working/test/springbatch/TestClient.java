package org.webank.working.test.springbatch;

import java.text.MessageFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-config.xml")
public class TestClient {

	@Test
	public void testMessageFormat(){
		System.out.println(MessageFormat.format("目前运行到第{0,number}次，运行时间：{1,date,yyyy-MM-dd hh:mm:ss}", 1, new Date()));
	}
	
	public static void main(String[] args) throws NoSuchJobException, JobInstanceAlreadyExistsException, JobParametersInvalidException{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		JobLauncher launcher = (JobLauncher)context.getBean("jobLauncher");
		Job job = (Job)context.getBean("helloWorld");

		try{
			JobExecution result = launcher.run(job, new JobParameters());
			System.out.println(result.toString());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
