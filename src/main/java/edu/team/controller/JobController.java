package edu.team.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.team.entity.Dept;
import edu.team.entity.Job;
import edu.team.service.DeptService;
import edu.team.service.JobService;
import edu.team.service.Impl.JobServiceImpl;

/**
 * 项目初始control层示例
 */
@Controller
public class JobController {
	@Autowired
    private JobService jobService;
	
	@RequestMapping(value="/selectJob")
	public Job selectJob() {
	    return jobService.selectJob("萧炎");
	}
	
	@RequestMapping(value="/insertJob")
	public void insertJob() {
		jobService.insertJob();
	}
	
	@RequestMapping(value="/deleteJob")
	public void deleteJob() {
		jobService.deleteJob("萧炎");
	}
	
	@RequestMapping(value="/updateJob")
	public void updateJob() {
		jobService.updateJob();
	}

}
