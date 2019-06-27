package edu.team.service;

import edu.team.entity.EmployeeInf;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //通过*查询
    List<EmployeeInf> findALlEmployeeInf();

    EmployeeInf findEmployeeInfById(int id);

    //添加职位
    String addEmployeeInf(Map<String, Object> map);

    //删除员工
    String deleteEmployeeInfById(Integer id);

    //修改员工
    String editEmployeeInfById(Map<String, Object> map);


    //通过*查询
    List<EmployeeInf> selectEmployee(Map<String, Object> map);

}
