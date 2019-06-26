package edu.team.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import edu.team.dao.DeptDao;
import edu.team.entity.Dept;
import edu.team.service.DeptService;

/**
 * 初始项目ServiceImpl示例
 */
@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> selectDept(String name) {
        return deptDao.selectDept(name);
    }
    
    @Override
    public String insertDept(Dept dept) {
        try {
        	deptDao.insertDept(dept);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }
    
    @Override
    public String deleteDept(int id) {
    	 try {
    		 deptDao.deleteDept(id);
             return "SUCCESS";
         } catch (Exception e) {
             System.out.println(e);
             return "FAIL";
         }
    }
    
    @Override
    public String updateDept(Dept dept) {
        try {
        	deptDao.updateDept(dept);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }
    
    @Override
    public List<Dept> selectDeptAll() {
        return deptDao.selectDeptAll();
    }
}
