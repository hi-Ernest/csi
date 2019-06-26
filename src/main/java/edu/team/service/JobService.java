package edu.team.service;

import edu.team.entity.Job;

public interface JobService {
	Job selectJob(String name);
    void insertJob();
	void deleteJob(String name);
	void updateJob();
}
