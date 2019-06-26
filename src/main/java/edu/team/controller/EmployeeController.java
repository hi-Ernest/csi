package edu.team.controller;

import edu.team.entity.Dept;
import edu.team.entity.EmployeeInf;
import edu.team.entity.Job;
import edu.team.service.DeptService;
import edu.team.service.EmployeeService;
import edu.team.service.JobService;
import edu.team.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;


    @Autowired
    private JobService jobService;


    /**
     * 查询所有员工信息
     * 完成
     */
    @RequestMapping(value = "/findAllEmployee", method = RequestMethod.GET)
    public List<EmployeeInf> findAllEmployee() {

        List<EmployeeInf> list = employeeService.findALlEmployeeInf();

        return list;
    }

    /**
     * 员工信息删除
     * 成功
     */
    @RequestMapping(value = "deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(String ids) {

        String result;
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            result = employeeService.deleteEmployeeInfById(Integer.valueOf(id[i]));
            if ("FAIL".equals(result)) {
                return JacksonUtil.objectToJson("FAIL");
            }
        }
        return JacksonUtil.objectToJson("SUCCESS");
    }



    //点击记录-----弹出信息
    @RequestMapping("/findEmployeeById")
    public void findEmployeeById() {

        EmployeeInf emp = employeeService.findEmployeeInfById(1212);
        System.out.println(emp.toString());

    }

    //增加页面前加载JOB
    @RequestMapping(value="/showAddEmployeeForJob", method = RequestMethod.GET)
    public String showAddEmployeeForJob() {
        List<Job> jobs = jobService.selectAllJobs();
        return JacksonUtil.objectToJson(jobs);
    }

    //增加页面前加载DEPT
    @RequestMapping(value="/showAddEmployeeForDept", method = RequestMethod.GET)
    public String showAddEmployeeForDept() {

        List<Dept> depts = deptService.selectDeptAll();

        return JacksonUtil.objectToJson(depts);
    }


    //增加
    @RequestMapping(value="/addEmployee", method = RequestMethod.POST)
    @ResponseBody
    public String addEmployee(@RequestBody String employee) {

        System.out.println(" ********************************** ");
        System.out.println(employee);

        Map<String, Object> map = JacksonUtil.jsonToMap(employee);


        System.out.println(map.toString() +"       ----------------------------");
        employeeService.addEmployeeInf(map);

        return "SUCCESS";
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
