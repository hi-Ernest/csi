package edu.team.service;

import java.util.List;

import edu.team.entity.Dept;

/**
 * 项目初始Service接口示例
 */
public interface DeptService {
	List<Dept> selectDept(String name);

    void insertDept(Dept dept);

	void deleteDept(String name);

	void updateDept(Dept dept);

	List<Dept> selectDeptAll();

	//通过id找到name
	String selectNameById(int id);
}

