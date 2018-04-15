package com.rbac.dao;

import com.rbac.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Ng on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class RoleDaoTest {
    @Resource
    private  RoleDao roleDao;
    @Test
    public void queryById() throws Exception {
       Role role=roleDao.queryById(1);
        System.out.print(role);
    }

    @Test
    public void queryByName() throws Exception {
        Role role = roleDao.queryByName("超级管理员");
        System.out.print(role);
    }

    @Test
    public void insertRole() throws Exception {
        byte state =1;
        Role role =new Role("sb",new Date().getTime(),state);
        roleDao.insertRole(role);
    }

    @Test
    public void updateRole() throws Exception {
        Role role =roleDao.queryById(4);
        role.setRoleName("ff");
        roleDao.updateRole(role);
    }

    @Test
    public void grandAuth() throws Exception {

    }

    @Test
    public void updateState() throws Exception {

    }

    @Test
    public void deleteRole() throws Exception {
        roleDao.deleteRole(4);
    }

}