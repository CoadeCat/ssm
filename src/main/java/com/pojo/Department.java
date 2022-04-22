package com.pojo;

import java.util.Collection;
import java.util.List;

public class Department {

    public Department() {
    }

    public Department(Integer deptId, String deptName, List<Employee> employees) {

        this.deptId = deptId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_dept.dept_id
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */
    private Integer deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_dept.dept_name
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */
    private String deptName;


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_dept.dept_name
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_dept.dept_id
     *
     * @return the value of tb_dept.dept_id
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_dept.dept_id
     *
     * @param deptId the value for tb_dept.dept_id
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_dept.dept_name
     *
     * @return the value of tb_dept.dept_name
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_dept.dept_name
     *
     * @param deptName the value for tb_dept.dept_name
     *
     * @mbggenerated Sun Apr 17 16:50:33 CST 2022
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}