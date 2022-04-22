package com.service;

import com.dao.EmployeeMapper;
import com.pojo.Employee;
import com.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张志强
 * @creat 2022/4/18-16:17
 * @Titile :EmployeeService
 * @ProjectName ssm
 * @Description :TODO
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getPageIteam(){

        return employeeMapper.selectByExampleWithDept(null);
    }

    public int  insertIteam(Employee employee){

        return employeeMapper.insertSelective(employee);
    }

    public boolean checkUser(String empName) {

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long i = employeeMapper.countByExample(employeeExample);
        return i == 0;
    }

    public Employee getEmpIteam(int id) {

        return employeeMapper.selectByPrimaryKey(id);
    }

    public int  updataEpm(Employee employee) {

        return  employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int deleteiteam(Integer integer) {

        return  employeeMapper.deleteByPrimaryKey(integer);
    }

    public int deleteAll(List<Integer> integerList) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(integerList);
        return employeeMapper.deleteByExample(employeeExample);
    }
}
