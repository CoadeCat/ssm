package com.dao;

import com.pojo.Department;
import com.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author 张志强
 * @creat 2022/4/17-19:55
 * @Titile :Test01
 * @ProjectName ssm
 * @Description :TODO
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Application.xml")
public class Test01 {

@Autowired
DepartmentMapper departmentMapper;

@Autowired
EmployeeMapper employeeMapper;

@Autowired
SqlSession sqlSession;

    @Test
    public void test01(){
        List<Department> departments = departmentMapper.selectByExample(null);
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        System.out.println(employees);
    }

    @Test
    public void test02(){
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);


        for (int i = 0; i < 100 ; i++) {
            Random random = new Random();
            byte j = (byte) random.nextInt(2);
            String substring = UUID.randomUUID().toString().substring(0, 4);
            mapper.insert(new Employee(null, substring, j,substring+"@qq.com",(i%3+1)));
        }

    }

    @Test
    public void test03(){


    }

}
