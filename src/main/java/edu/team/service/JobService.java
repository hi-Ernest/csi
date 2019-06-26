package edu.team.service;

import edu.team.entity.Job;

import java.util.List;

public interface JobService {
	Job selectJob(String name);
    void insertJob();
	void deleteJob(String name);
	void updateJob();
	List<Job> selectAllJobs();

	//通过Id找到职位name
	String selectNameById(Integer id);

}
