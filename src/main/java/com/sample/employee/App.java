package com.sample.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sample.employee.dao.JobDao;
import com.sample.employee.vo.Job;

public class App {

	public static void main(String[] args) {
		String resources = "classpath:/META-INF/spring/app-context.xml";
		
		ApplicationContext context = new GenericXmlApplicationContext(resources);
		
		JobDao dao = context.getBean("jobDao", JobDao.class);
		
		//dao.removeJob("IT_EDU");
		/*
		Job job = new Job();
		job.setId("IT_EDU");
		job.setTitle("IT 교육");
		job.setMinSalary(10000);
		job.setMaxSalary(16000);
		*/
		//dao.addJob(job);
		
		Job job = dao.getJob("IT_EDU");
		System.out.println(job);
	}
}
