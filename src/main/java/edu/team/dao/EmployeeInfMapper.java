package edu.team.dao;

import edu.team.entity.EmployeeInf;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeInfMapper {

    //通过*查询
    List<EmployeeInf> findAllEmployeeInf();

    EmployeeInf findEmployeeInfById(Integer id);

    //添加职位
    void addEmployeeInf(EmployeeInf emp);

    //删除员工
    void deleteEmployeeInfById(Integer id);

    //修改员工
    void editEmployeeInfById(EmployeeInf emp);


    List<EmployeeInf> selectEmployee(EmployeeInf emp);

}