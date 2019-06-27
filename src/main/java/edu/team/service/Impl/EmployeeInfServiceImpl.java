package edu.team.service.Impl;

import edu.team.dao.EmployeeInfMapper;
import edu.team.entity.EmployeeInf;
import edu.team.service.DeptService;
import edu.team.service.EmployeeService;
import edu.team.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeInfServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeInfMapper employeeInfMapper;

    @Autowired
    private JobService jobService;

    @Autowired
    private DeptService deptService;

    @Override
    public List<EmployeeInf> findALlEmployeeInf() {

        List<EmployeeInf> list = employeeInfMapper.findAllEmployeeInf();

        for(EmployeeInf emp : list ) {

            System.out.println(emp.toString()+ " -----------------------------------");

            emp.setJobName(jobService.selectNameById(emp.getJobId()));
            emp.setDeptName(deptService.selectNameById(emp.getDeptId()));
            if (emp.getSex()==1)
                emp.setSexName("男");
            else
                emp.setSexName("女");
        }

        return list;
    }

    @Override
    public String deleteEmployeeInfById(Integer id) {
        try {
            employeeInfMapper.deleteEmployeeInfById(id);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }

    @Override
    public EmployeeInf findEmployeeInfById(int id) {
        return employeeInfMapper.findEmployeeInfById(id);
    }

    @Override
    public String addEmployeeInf(Map<String, Object> map) {

        EmployeeInf emp = new EmployeeInf();

        emp.setName((String)map.get("name"));
        emp.setCardId((String) map.get("cardId"));

        //1：男 2：女
        emp.setSex(Integer.parseInt((String) map.get("sex")));

        //根据职位name查找职位的id
        String a = map.get("jobId").toString();

        System.out.println(a+ "     ************************************");

        int jobId = jobService.selectJobByName(a).getId();
        //存入数据库
        emp.setJobId(jobId);

        emp.setEducation((String) map.get("education"));
        emp.setEmail((String) map.get("email"));
        emp.setPhone((String) map.get("phone"));
        emp.setTel((String) map.get("tel"));
        emp.setParty((String) map.get("party"));
        emp.setQqNum((String) map.get("qqNum"));
        emp.setAddress((String) map.get("address"));
        emp.setPostCode((String) map.get("postCode"));
        emp.setBirthday((String) map.get("birthday"));
        emp.setRace((String) map.get("race"));
        emp.setSpeciality((String) map.get("speciality"));
        emp.setHobby((String) map.get("hobby"));

        emp.setRemake((String) map.get("remake"));

        //根据部门name查找部门的id
        int deptid = deptService.selectDept((String) map.get("deptId")).get(0).getId();

        //存入数据库
        emp.setDeptId(deptid);

        try {
            employeeInfMapper.addEmployeeInf(emp);
            return "SUCCESS";
        } catch (Exception e) {
            System.out.println(e);
            return "FAIL";
        }
    }


    @Override
    public boolean editEmployeeInfById(EmployeeInf emp) {
        employeeInfMapper.editEmployeeInfById(emp);
        return true;
    }

    @Override
    public List<EmployeeInf> selectEmployee(Map<String, Object> map) {

        EmployeeInf emp = new EmployeeInf();

        emp.setName((String)map.get("name"));
        emp.setCardId((String) map.get("cardId"));
        emp.setPhone((String) map.get("phone"));

        List<EmployeeInf> list = employeeInfMapper.selectEmployee(emp);

        for(EmployeeInf e : list ) {
            emp.setJobName(jobService.selectNameById(e.getJobId()));
            emp.setDeptName(deptService.selectNameById(e.getDeptId()));
        }

        System.out.println(list.get(0).getJobName()+ "******************************");

        return list;
    }

}
