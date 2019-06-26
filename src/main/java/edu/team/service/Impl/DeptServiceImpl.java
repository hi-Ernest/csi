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
    public void insertDept(Dept dept) {
        deptDao.insertDept(dept);
    }
    
    @Override
    public void deleteDept(String name) {
        deptDao.deleteDept(name);
    }
    
    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }
    
    @Override
    public List<Dept> selectDeptAll() {
        return deptDao.selectDeptAll();
    }
}
