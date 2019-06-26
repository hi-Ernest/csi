package edu.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.team.entity.Dept;

@Mapper
public interface DeptDao {
	
	List<Dept> selectDept(String name);
	void updateDept(Dept dept);
	void insertDept(Dept dept);
	void deleteDept(String name);
	List<Dept> selectDeptAll();

	Dept selectNameById(Integer id);

}