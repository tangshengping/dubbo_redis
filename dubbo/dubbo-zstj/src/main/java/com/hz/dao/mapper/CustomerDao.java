package com.hz.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hz.bean.mybatis.Customer;

@Mapper
public interface CustomerDao {

    @Select("select * from customer where id=#{id}")
    public Customer selectid(@Param("id") Integer id);

    @Insert("insert into customer values(null,#{name},#{age})")
    public boolean insertCustomer(@Param("name") String name,@Param("age") int age);

    @SuppressWarnings("rawtypes")
	@Select("select * from customer u join customer u1  where u.id=#{id}")
    public List<Map> select(@Param("id") Integer id);

    //XML自动注入
    Customer selectCustomerById(@Param("id") Integer id);

}