package edu.team.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.team.entity.Dept;
import edu.team.entity.Document;
import edu.team.service.DeptService;


/**
 * 项目初始control层示例
 */
@RestController
public class DeptController {
	
	@Autowired
    private DeptService deptService;
	
	@RequestMapping(value="/selectDept",method=RequestMethod.POST)
	public PageInfo<Dept> selectDept(String name, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
	   PageHelper.startPage(pageNum, 10);
       if ("".equals(name) || null == name) {
           return new PageInfo<Dept>(deptService.selectDeptAll());
       } else {
           return new PageInfo<Dept>(deptService.selectDept(name));
       }
	   
	}
	
	@RequestMapping(value="/selectAllDept",method=RequestMethod.POST)
	public PageInfo<Dept> selectAllDept(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		PageHelper.startPage(pageNum, 10);
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptService.selectDeptAll());
        return pageInfo;
	}
	
	@RequestMapping(value="/insertDept",method=RequestMethod.POST)
	public String insertDept(String name,String remake) {
		Dept dept=new Dept();
		dept.setName(name);
		dept.setRemake(remake);
	    deptService.insertDept(dept);
	    return "success";
	}
	
	@RequestMapping(value="/deleteDept",method=RequestMethod.POST)
	public void deleteDept() {
	    deptService.deleteDept(2);
	 //   return "";
	}
	
	@RequestMapping(value="/updateDept",method=RequestMethod.POST)
	public void updateDept(int id,String name,String remake) {
		Dept dept=new Dept();
		dept.setId(id);
		dept.setName(name);
		dept.setRemake(remake);
	    deptService.updateDept(dept);
	  //  return "";
	}

}
