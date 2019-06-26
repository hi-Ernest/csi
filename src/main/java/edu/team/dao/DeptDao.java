package edu.team.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import edu.team.entity.Dept;

@Mapper
public interface DeptDao {
	
	public List<Dept> selectDept(String name);
	public void updateDept(Dept dept);
	public void insertDept(Dept dept);
	public void deleteDept(String name);
	public List<Dept> selectDeptAll();

}