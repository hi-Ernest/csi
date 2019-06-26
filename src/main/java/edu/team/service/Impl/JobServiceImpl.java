package edu.team.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.team.dao.JobDao;
import edu.team.entity.Job;
import edu.team.service.JobService;

import java.util.List;

/**
 * 初始项目ServiceImpl示例
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;


    @Override
    public Job selectJob(String name) {
        return jobDao.selectJob(name);
    }
    
    @Override
    public void insertJob() {
    	jobDao.insertJob();
    }
    
    @Override
    public void deleteJob(String name) {
    	jobDao.deleteJob(name);
    }
    
    @Override
    public void updateJob() {
    	jobDao.updateJob();
    }

    @Override
    public List<Job> selectAllJobs() {
        return jobDao.selectAllJobs();
    }

    @Override
    public String selectNameById(Integer id) {
        return jobDao.selectNameById(id).getName();
    }
}
