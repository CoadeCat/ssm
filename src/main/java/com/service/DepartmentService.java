package com.service;

import com.dao.DepartmentMapper;
import com.pojo.Department;
import com.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 张志强
 * @creat 2022/4/19-23:52
 * @Titile :DepartmentService
 * @ProjectName ssm
 * @Description :TODO
 */

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAll(){
       return departmentMapper.selectByExample(null);
    }
}
