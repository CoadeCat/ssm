//package com.dao;
//
//import com.pojo.Department;
//import com.pojo.DepartmentExample;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author 张志强
// * @creat 2022/4/18-12:55
// * @Titile :DepartmentMapperImpl
// * @ProjectName ssm
// * @Description :TODO
// */
//
//@Component
//public class DepartmentMapperImpl implements DepartmentMapper{
//
//    @Autowired
//    private SqlSession sqlSession;
//
//    public void test(){
//        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//        List<Department> departments = mapper.selectByExample(null);
//        System.out.println(departments.toString());
//    }
//
//    @Override
//    public int countByExample(DepartmentExample example) {
//        return 0;
//    }
//
//    @Override
//    public int deleteByExample(DepartmentExample example) {
//        return 0;
//    }
//
//    @Override
//    public int deleteByPrimaryKey(Integer deptId) {
//        return 0;
//    }
//
//    @Override
//    public int insert(Department record) {
//        return 0;
//    }
//
//    @Override
//    public int insertSelective(Department record) {
//        return 0;
//    }
//
//    @Override
//    public List<Department> selectByExample(DepartmentExample example) {
//        return null;
//    }
//
//    @Override
//    public Department selectByPrimaryKey(Integer deptId) {
//        return null;
//    }
//
//    @Override
//    public List<Department> selectByExampleWithEmp(DepartmentExample example) {
//        return null;
//    }
//
//    @Override
//    public Department selectByPrimaryKeyWithEmp(Integer deptId) {
//        return null;
//    }
//
//    @Override
//    public int updateByExampleSelective(Department record, DepartmentExample example) {
//        return 0;
//    }
//
//    @Override
//    public int updateByExample(Department record, DepartmentExample example) {
//        return 0;
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(Department record) {
//        return 0;
//    }
//
//    @Override
//    public int updateByPrimaryKey(Department record) {
//        return 0;
//    }
//}
