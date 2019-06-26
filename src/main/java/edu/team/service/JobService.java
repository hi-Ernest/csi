package edu.team.service;

import java.util.List;

import edu.team.entity.Dept;
import edu.team.entity.Job;

public interface JobService {
	List<Job> selectJob(String name);
	String insertJob(Job job);
	String deleteJob(int id);
	String updateJob(Job job);
	List<Job> selectJobAll();
}
