package edu.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.Dept;
import edu.team.entity.Job;

import java.util.List;

@Mapper
public interface JobDao {
	public List<Job> selectJob(String name);
	public void updateJob(Job job);
	public void insertJob(Job job);
	public void deleteJob(int id);
	public List<Job> selectJobAll();

	Job selectJobByName(String name);

	void updateJob();
	void insertJob();
	void deleteJob(String name);
	List<Job> selectAllJobs();

	//通过Id找到职位name
	Job selectNameById(Integer id);

}
