package edu.team.service.Impl;

import edu.team.dao.EmployeeInfMapper;
import edu.team.entity.EmployeeInf;
import edu.team.service.DeptServcie;
import edu.team.service.EmployeeService;
import edu.team.service.JobService;
import edu.team.util.JacksonUtil;
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
    private DeptServcie deptServcie;

    @Override
    public List<EmployeeInf> findALlEmployeeInf() {

        List<EmployeeInf> list = employeeInfMapper.findAllEmployeeInf();

        for(EmployeeInf emp : list ) {
            emp.setJobName(jobService.selectNameById(emp.getJobId()));
            emp.setDeptName(deptServcie.selectNameById(emp.getDeptId()));
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

        //前端的部门信息(传入1.2....)
        //职位信息(传入1.2...)

        //通过id查找部门名称
        //需要查找所有的部门id和名称

        //进入增加界面的时候 调用接口 显示职位和部门(id name)
        //点击增加的按钮时候,可以直接获取id


        emp.setName((String)map.get("name"));
        emp.setCardId((String) map.get("cardId"));

        //1：男 2：女
        emp.setSex((Integer) map.get("sex"));

        //job的id
        emp.setJobId((Integer) map.get("jobId"));


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

        //部门的id
        emp.setDeptId((Integer) map.get("deptId"));

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
}
