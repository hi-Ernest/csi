package edu.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.Dept;
import edu.team.entity.Job;

@Mapper
public interface JobDao {
	public List<Job> selectJob(String name);
	public void updateJob(Job job);
	public void insertJob(Job job);
	public void deleteJob(int id);
	public List<Job> selectJobAll();

}
