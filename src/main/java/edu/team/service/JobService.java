package edu.team.service;

import edu.team.entity.Job;

import java.util.List;


public interface JobService {
	List<Job> selectJob(String name);
	String insertJob(Job job);
	String deleteJob(int id);
	String updateJob(Job job);
	List<Job> selectJobAll();

	Job selectJobByName(String name);
//    void insertJob();
//	void deleteJob(String name);
//	void updateJob();
	List<Job> selectAllJobs();

	//通过Id找到职位name
	String selectNameById(Integer id);

}
