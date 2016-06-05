package org.webank.working.springbatch.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class Service
{
	@Autowired
	JobLauncher jobLauncher;

	public static void main(String[] args) throws IOException, JobExecutionAlreadyRunningException,
	        JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
		        "classpath:spring-config.xml");
		Service service = (Service) context.getBean("service");

		while (true)
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String readLine = reader.readLine();

			if ("exit".equalsIgnoreCase(readLine))
			{
				service.exit();
			}
			else
			{
				String[] inputs = StringUtils.split(readLine, "|");
				service.runJob(inputs[0], inputs[1], context);
			}
		}
	}

	public void runJob(String jobName, String strParam, ApplicationContext context)
	        throws JobExecutionAlreadyRunningException, JobRestartException,
	        JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		Job job = (Job) context.getBean(jobName);
		JobParameters parameters = null;
		if (null != strParam && 0 < strParam.length())
		{
			Map<String, JobParameter> mapParam = new HashMap<String, JobParameter>();
			mapParam.put("inputFile", new JobParameter(strParam));
			parameters = new JobParameters(mapParam);
		}

		jobLauncher.run(job, parameters);
	}

	public void exit()
	{
		System.exit(1);
	}

	public void lunanch(Job job, JobParameters parameter)
	        throws JobExecutionAlreadyRunningException, JobRestartException,
	        JobInstanceAlreadyCompleteException, JobParametersInvalidException
	{
		jobLauncher.run(job, parameter);
		return;
	}
}
