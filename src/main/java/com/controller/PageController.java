package com.controller;

import com.dao.DepartmentMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Department;
import com.pojo.Employee;
import com.pojo.Msg;
import com.service.DepartmentService;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张志强
 * @creat 2022/4/18-16:10
 * @Titile :PageController
 * @ProjectName ssm
 * @Description :TODO
 */

@Controller
public class PageController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/")
    public String indexpage(@RequestParam(value = "pg",defaultValue = "1")Integer nowpage, Model model){

        PageHelper.startPage(nowpage,5);
        List<Employee> pageIteam = employeeService.getPageIteam();
        PageInfo pageInfo = new PageInfo(pageIteam,5);
        model.addAttribute("page",pageInfo);
        return "index";
    }

//    @RequestMapping("/emp")
//    public String indexpage01(@RequestParam(value = "pg",defaultValue = "1")Integer nowpage, Model model){
//
//        PageHelper.startPage(nowpage,5);
//        List<Employee> pageIteam = employeeService.getPageIteam();
//        PageInfo pageInfo = new PageInfo(pageIteam,5);
//        model.addAttribute("page",pageInfo);
//        return "list";
//    }

    @RequestMapping("/emp")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pg",defaultValue = "1")Integer nowpage){
        PageHelper.startPage(nowpage,5);
        List<Employee> pageIteam = employeeService.getPageIteam();
        PageInfo pageInfo = new PageInfo(pageIteam,5);
       return Msg.success().add("page",pageInfo);
    }


    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable(value = "id") Integer id){

        Employee employee = employeeService.getEmpIteam(id);

        return Msg.success().add("emp",employee);
    }


    @RequestMapping("/dept")
    @ResponseBody
    public Msg getSelectDept(){

        List<Department> all = departmentService.getAll();
        return Msg.success().add("dept",all);
    }


    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid  Employee employee, BindingResult bindingResult){

        Map<String, Object> map = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError:fieldErrors) {
                     map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            employeeService.insertIteam(employee);
            return Msg.success();
        }

    }

    @ResponseBody
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    public Msg updataEmp( Employee employee,BindingResult bindingResult){

        Map<String, Object> map = new HashMap<String, Object>();
        if (bindingResult.hasErrors()) {

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError:fieldErrors) {
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            employeeService.updataEpm(employee);
            return Msg.success();
        }

    }


    //检查用户名是否已经存在于数据库
    @ResponseBody
    @PostMapping("/checkuser")
    public Msg checkuser(@RequestParam("empName")String empName){

        //先判断用户名是否满足正则表达式，若不满足无需去数据库查询
        String regx = "^[\u2E80-\u9FFF]{2,5}";
        if(!empName.matches(regx)){
            return Msg.fail().add("va_msg", "学生姓名必须是2-5位汉字");
        }

        //数据库用户名重复校验
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg", "学生姓名已存在");
        }
    }


    @RequestMapping(value = "/emp/{id}" ,method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteiteam(@PathVariable(value = "id") String id){
        List<Integer> integerList = new ArrayList<>();
        if(id.contains("-")) {
            String[] split = id.split("-");
            for(String s : split) {
                int i = Integer.parseInt(s);
                integerList.add(i);
            }
             employeeService.deleteAll(integerList);

        }else {
            Integer integer = Integer.parseInt(id);
            int deleteiteam = employeeService.deleteiteam(integer);

        }
        return Msg.success();
    }

}
