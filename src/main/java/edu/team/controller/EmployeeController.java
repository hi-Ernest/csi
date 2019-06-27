package edu.team.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.team.entity.Dept;
import edu.team.entity.EmployeeInf;
import edu.team.entity.Job;
import edu.team.service.DeptService;
import edu.team.service.EmployeeService;
import edu.team.service.JobService;
import edu.team.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/findAllEmployee", method = RequestMethod.POST)
    public PageInfo<EmployeeInf> findAllEmployee(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        PageInfo<EmployeeInf> pageInfo = new PageInfo<EmployeeInf>(employeeService.findALlEmployeeInf());
        return pageInfo;
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
    @RequestMapping(value = "/findEmployeeById", method = RequestMethod.POST)
    public EmployeeInf findEmployeeById(String id) {

        EmployeeInf emp = employeeService.findEmployeeInfById(Integer.valueOf(id));
        System.out.println(emp.toString());

        return emp;

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

        Map<String, Object> map = JacksonUtil.jsonToMap(employee);

        employeeService.addEmployeeInf(map);

        return JacksonUtil.objectToJson("SUCCESS");
    }

    /**
     * 条件查询员工信息
     * 完成
     */
    @RequestMapping(value = "/selectEmployee", method = RequestMethod.POST)
    @ResponseBody
    public List<EmployeeInf> selectEmployee(@RequestBody String emp) {

        Map<String, Object> map = JacksonUtil.jsonToMap(emp);

        List<EmployeeInf> list = employeeService.selectEmployee(map);

        return list;
    }


    /**
     * 员工信息编辑
     */
    @RequestMapping("/editEmployee")
    public String editEmployee(@RequestBody String employee) {

        System.out.println(employee + "    ****************************************");


        Map<String, Object> map = JacksonUtil.jsonToMap(employee);

        employeeService.editEmployeeInfById(map);

        return JacksonUtil.objectToJson("SUCCESS");
    }

}
