package com.guoge2.springboot.mapper;

import com.guoge2.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这个是操作数据的mapper
@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("Insert into department(department_name) values(#{departmentName}) ")
    public  int insertDept(Department department);
    @Update("update department set department_name=#{departtmentName} where id=#{id}")
    public  int updateDept(Department department);


}
