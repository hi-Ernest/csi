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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.team.entity.Dept;
import edu.team.service.DeptService;
import edu.team.util.JacksonUtil;


/**
 * 项目初始control层示例
 */
@RestController
public class DeptController {
	
	@Autowired
    private DeptService deptService;
	
	@RequestMapping(value="/selectDept",method=RequestMethod.POST)
	public List<Dept> selectDept(String name) {
	   return deptService.selectDept(name);
	   
	}
	
	@RequestMapping(value="/selectAllDept",method=RequestMethod.GET)
	public List<Dept> selectAllDept() {
		
	    return deptService.selectDeptAll();
	}
	
	@RequestMapping(value="/insertDept",method=RequestMethod.POST)
	public String insertDept(String name,String remake) {
		Dept dept=new Dept();
		dept.setName(name);
		dept.setRemake(remake);
	    String result=deptService.insertDept(dept);
	    if ("FAIL".equals(result)) {
            return JacksonUtil.objectToJson("FAIL");
        }else {
           return JacksonUtil.objectToJson("SUCCESS");
        }
	}
	
	@RequestMapping(value="/deleteDept",method=RequestMethod.POST)
	public String deleteDept(String ids) {
	    String result;
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            result = deptService.deleteDept(Integer.valueOf(id[i]));
            if ("FAIL".equals(result)) {
                return JacksonUtil.objectToJson("FAIL");
            }
        }
        return JacksonUtil.objectToJson("SUCCESS");
	}
	
	@RequestMapping(value="/updateDept",method=RequestMethod.POST)
	public String updateDept(int id,String name,String remake) {
		Dept dept=new Dept();
		dept.setId(id);
		dept.setName(name);
		dept.setRemake(remake);
	    String result=deptService.updateDept(dept);
	    if ("FAIL".equals(result)) {
            return JacksonUtil.objectToJson("FAIL");
        }else {
           return JacksonUtil.objectToJson("SUCCESS");
        }
	}

}
