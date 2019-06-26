package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.Job;

import java.util.List;

@Mapper
public interface JobDao {
	Job selectJob(String name);
	void updateJob();
	void insertJob();
	void deleteJob(String name);
	List<Job> selectAllJobs();

	//通过Id找到职位name
	Job selectNameById(Integer id);

}
