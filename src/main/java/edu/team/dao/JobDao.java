package edu.team.dao;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.Job;

@Mapper
public interface JobDao {
	Job selectJob(String name);
	void updateJob();
	void insertJob();
	void deleteJob(String name);

}
