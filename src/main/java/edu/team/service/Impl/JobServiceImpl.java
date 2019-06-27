package edu.team.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.team.dao.DeptDao;
import edu.team.dao.JobDao;
import edu.team.entity.Dept;
import edu.team.entity.Job;
import edu.team.service.DeptService;
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
    public List<Job> selectJob(String name) {
        return jobDao.selectJob(name);
    }
    
    @Override
    public String insertJob(Job job) {
        try {
        	jobDao.insertJob(job);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }
    
    @Override
    public String deleteJob(int id) {
    	 try {
    		 jobDao.deleteJob(id);
             return "SUCCESS";
         } catch (Exception e) {
             System.out.println(e);
             return "FAIL";
         }
    }
    
    @Override
    public String updateJob(Job job) {
        try {
        	jobDao.updateJob(job);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }
    
    @Override
    public List<Job> selectJobAll() {
        return jobDao.selectJobAll();
    }

    @Override
    public Job selectJobByName(String name) {
        return jobDao.selectJobByName(name);
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
