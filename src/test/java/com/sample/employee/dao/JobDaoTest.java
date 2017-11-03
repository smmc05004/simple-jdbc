package com.sample.employee.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.employee.vo.Job;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/app-context.xml")
public class JobDaoTest {

	@Autowired
	JobDao jobdao;
	
	@Test
	// 테스트할 dao의 패키지 이름을 같게 하면 import안 해도 됌
	// 리턴타입을 적어도 무의미 so, void로 설정
	public void testGetAllJobs() {
		List<Job> jobs = jobdao.getAllJobs();
		
		Assert.assertEquals(20, jobs.size());
	}
	
	@Test
	public void testGetJobsBySalary() {
		List<Job> jobs17000 = jobdao.getJobsBySalary(17000);
		List<Job> jobs10000 = jobdao.getJobsBySalary(10000);
		
		Assert.assertEquals(2, jobs17000.size());
		Assert.assertEquals(9, jobs10000.size());
	}
}
