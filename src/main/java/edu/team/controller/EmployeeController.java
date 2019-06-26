package edu.team.controller;

import edu.team.entity.EmployeeInf;
import edu.team.service.EmployeeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //待测试...
    @RequestMapping(value = "/findAllEmployee", method = RequestMethod.GET)
    public List<EmployeeInf> findAllEmployee() {

        List<EmployeeInf> list = employeeService.findALlEmployeeInf();

        System.out.println(list.size());

        for (EmployeeInf emp2: list) {
            System.out.println(emp2.toString());
        }

        return list;
    }


    //待测试...
    @RequestMapping("/findEmployeeById")
    public void findEmployeeById() {

        EmployeeInf emp = employeeService.findEmployeeInfById(1212);
        System.out.println(emp.toString());

    }


    @RequestMapping(value="/addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public String addEmployee(@RequestBody String employee) {

        System.out.println(employee);

        JSONObject jsonObject = JSONObject.fromObject(employee);
        System.out.println(jsonObject.toString());

        employeeService.addEmployeeInf(jsonObject);

        return "SUCCESS";
    }


    /**
     * 员工信息删除
     */
    @RequestMapping("deleteEmployee")
    public void deleteEmployee() {
        employeeService.deleteEmployeeInfById(22);
    }

    /**
     * 员工信息编辑
     */
    @RequestMapping("editEmployee")
    public void editEmployee() {
        //接收前端的JSON数据
        EmployeeInf employeeInf = new EmployeeInf(1, 1, 1,"chr");
        employeeService.editEmployeeInfById(employeeInf);
    }

}
