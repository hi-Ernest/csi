package edu.team.service.Impl;

import edu.team.dao.EmployeeInfMapper;
import edu.team.entity.EmployeeInf;
import edu.team.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInfServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeInfMapper employeeInfMapper;

    @Override
    public List<EmployeeInf> findALlEmployeeInf() {
        return employeeInfMapper.findAllEmployeeInf();
    }

    @Override
    public EmployeeInf findEmployeeInfById(int id) {
        return employeeInfMapper.findEmployeeInfById(id);
    }

//    @Override
//    public boolean addEmployeeInf(JSONObject empJson) {
//        EmployeeInf emp = new EmployeeInf();
//
//        //前端的部门信息(传入1.2....)
//        //职位信息(传入1.2...)
////        EmployeeInf employeeInf =
////           new EmployeeInf(1,1,"deptId", "Integer", "jobId", "name","cardId","address","postCode","tel","phone","qqNum", "email;", "sex;","party;", "birthday;", "race","speciality")
//
//        //通过id查找部门名称
//        //需要查找所有的部门id和名称
//
//        //进入增加界面的时候 调用接口 显示职位和部门(id name)
//        //点击增加的按钮时候,可以直接获取id
//
//
//        emp.setName(empJson.getString("name"));
//        emp.setCardId(empJson.getString("cardId"));
//        emp.setEducation(empJson.getString("education"));
//        emp.setEmail(empJson.getString("email"));
//        emp.setPhone(empJson.getString("phone"));
//        emp.setTel(empJson.getString("tel"));
//        emp.setParty(empJson.getString("party"));
//        emp.setQqNum(empJson.getString("qqNum"));
//        emp.setAddress(empJson.getString("address"));
//        emp.setPostCode(empJson.getString("postCode"));
//        emp.setBirthday(empJson.getString("birthday"));
//        emp.setRace(empJson.getString("race"));
//        emp.setSpeciality(empJson.getString("speciality"));
//        emp.setHobby(empJson.getString("hobby"));
//
//        employeeInfMapper.addEmployeeInf(emp);
//
//        return true;
//    }


    @Override
    public boolean deleteEmployeeInfById(Integer id) {
        employeeInfMapper.deleteEmployeeInfById(id);
        return true;
    }

    @Override
    public boolean editEmployeeInfById(EmployeeInf emp) {
        employeeInfMapper.editEmployeeInfById(emp);
        return true;
    }
}
