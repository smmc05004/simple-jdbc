package com.sample.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.sample.employee.vo.Job;

public class JobDao {

	private JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void addJob(Job job) {
		String sql = "insert Into jobs(job_id, job_title, min_salary, max_salary) values (?,?,?,?)";
		//insert, update, delete 시 update()사용
		template.update(sql, job.getId(), 
							 job.getTitle(),
							 job.getMinSalary(),
							 job.getMaxSalary());
	}
	
	public void removeJob(String id) {
		String sql = "delete from jobs where job_id=?";
		template.update(sql, id);
	}
	
	public Job getJob(String id) {
		String sql = "select job_id, job_title, min_salary, max_salary from jobs where job_id=?";
		return template.queryForObject(sql, new RowMapper<Job>() {

			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMinSalary(rs.getInt("min_salary"));
				job.setMaxSalary(rs.getInt("max_salary"));
				
				return job;
			}
		}, id);
	}
	
	public List<Job> getAllJobs() {
		String sql = "select * from jobs order by job_id";
		return template.query(sql, new RowMapper<Job>() {

			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMinSalary(rs.getInt("min_salary"));
				job.setMaxSalary(rs.getInt("max_salary"));
				
				return job;
			}
			
		});
	}
	
	public List<Job> getJobsBySalary (int salary) {
		String sql = "select * from jobs where min_salary <= ? and max_salary >= ?";
		return template.query(sql, new RowMapper<Job>() {

			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				Job job = new Job();
				job.setId(rs.getString("job_id"));
				job.setTitle(rs.getString("job_title"));
				job.setMinSalary(rs.getInt("min_salary"));
				job.setMaxSalary(rs.getInt("max_salary"));
				
				return job;
			}
			
		}, salary, salary);
	}
} 
