package edu.team.service;

import edu.team.entity.EmployeeInf;

import java.util.List;

public interface EmployeeService {

    //通过*查询
    List<EmployeeInf> findALlEmployeeInf();

    EmployeeInf findEmployeeInfById(int id);

    //添加职位
    //boolean addEmployeeInf(JSONObject empJson);

    //删除员工
    boolean deleteEmployeeInfById(Integer id);

    //修改员工
    boolean editEmployeeInfById(EmployeeInf emp);
}
