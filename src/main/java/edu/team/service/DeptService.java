package edu.team.service;

import java.util.List;

import edu.team.entity.Dept;

/**
 * 项目初始Service接口示例
 */
public interface DeptService {
	List<Dept> selectDept(String name);
	String insertDept(Dept dept);
	String deleteDept(int id);
	String updateDept(Dept dept);
	List<Dept> selectDeptAll();
}

