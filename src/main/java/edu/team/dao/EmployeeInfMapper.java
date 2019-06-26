package edu.team.dao;

import edu.team.entity.EmployeeInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface EmployeeInfMapper {

    //通过*查询
    List<EmployeeInf> findAllEmployeeInf();

    EmployeeInf findEmployeeInfById(Integer id);


    //通过id查询查询的员工信息->部门id->部门名称


    //职位id->职位名称


    //添加职位
    void addEmployeeInf(EmployeeInf emp);

    //删除员工
    void deleteEmployeeInfById(Integer id);

    //修改员工
    boolean editEmployeeInfById(@Param("emp") EmployeeInf emp);
}