package com.rbac.dao;

import com.rbac.entity.Admin;
import com.rbac.entity.Auth;
import com.rbac.entity.Role;
import com.rbac.exception.AdminException;
import com.rbac.exception.RoleException;
import com.rbac.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ng on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class AuthDaoTest {
    @Resource
    private AuthDao authDao;
    @Autowired
    private IndexService indexService;

    @Test
    public void queryById() throws Exception {
        Auth auth = authDao.queryById(1);
        System.out.print(auth);
    }

    @Test
    public void queryByName() throws Exception {
        Auth auth = authDao.queryByName("系统目录");
        System.out.print(auth);
    }

    @Test
    public void insertAuth() throws Exception {
//        byte level = 2;
//        byte state = 1;
//        Auth auth = new Auth("sf", 1, "c", "a", "c-a", level, state, new Date().getTime());
//        int id = authDao.insertAuth(auth);
//        System.out.print(auth.getAuthId());
    }

    @Test
    public void updateAuth() throws Exception {
        Auth auth = authDao.queryById(16);
        auth.setAuthName("g");
        authDao.updateAuth(auth);
    }

    @Test
    public void updateState() throws Exception {

    }

    @Test
    public void delete() throws Exception {
        authDao.deleteAuth(16);
    }

    @Test
    public void queryAuthByIn() {
        String[] str = "1,12,14".split(",");
        int[] authIds = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            authIds[i] = Integer.parseInt(str[i]);
        }
        List<Auth> authList = authDao.queryAuthByIn(authIds,new Byte(null));
        System.out.print(authList);
    }

    @Test
    public void tree() {
        try {
            indexService.getTree("0");
        } catch (AdminException e) {
            System.out.print(e.getMessage());
        } catch (RoleException e) {
            System.out.print(e.getMessage());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }


    @Test
    public void nodes() {
        try {
            indexService.getAuthTree("0");
        } catch (AdminException e) {
            System.out.print(e.getMessage());
        } catch (RoleException e) {
            System.out.print(e.getMessage());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Test
    public void t() {
//        Auth auth = authDao.queryById(2);
//        System.out.print(auth);
        List<Auth> authList=authDao.queryAllAuth(new Byte("4"));
        System.out.print(authList);
    }
}