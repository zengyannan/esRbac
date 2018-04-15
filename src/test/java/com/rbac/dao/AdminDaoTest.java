package com.rbac.dao;

import com.rbac.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static javafx.scene.input.KeyCode.R;
import static org.junit.Assert.*;

/**
 * Created by Ng on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AdminDaoTest {
    @Resource
    private AdminDao adminDao;

    @Test
    public void queryById() throws Exception {
        Admin admin = adminDao.queryById("600e0384-7811-4874-b654-ac341a6eaeaa");
        System.out.print(admin);
    }

    @Test
    public void queryByName() throws Exception {
        Admin admin = adminDao.queryByName("admin");
        System.out.print(admin);
    }
    @Test
    public void queryAll() throws Exception {
        List<Admin> list = adminDao.queryAll(0,12);
        System.out.print(list);
    }

    @Test
    public void insertAdmin() throws Exception {
        byte state =1;
        long now = new Date().getTime();
        String uuid =UUID.randomUUID().toString();
        Admin admin =new Admin(
                uuid,
                "laixinx",
                "xinxin",
                "123",
                now,
                now,
                "ss@qq.com",
                "13726215363",
                state
                );
        adminDao.insertAdmin(admin);
    }

    @Test
    public void updateAdmin() throws Exception {
        Admin admin =adminDao.queryById("12F26129-DC5F-55F9-4068-E7862BF88D47");
        admin.setAdminName("maomao1");
        admin.setAdminNickname("毛毛");
        int result = adminDao.updateAdmin(admin);
        System.out.print(result);
    }


    @Test
    public void updateState() throws Exception {
        byte state =1;
        adminDao.updateState("13254DBD-5A09-699B-B182-D6460B9D3837",state);
    }

    @Test
    public void delete() throws Exception {
        System.out.print("17b7a6fa-aa46-4c3c-ae13-6c65eb1a7449".length());
        adminDao.deleteAdmin("17b7a6fa-aa46-4c3c-ae13-6c65eb1a7449");
    }

    @Test
    public void setRole() throws Exception {
        adminDao.setRole("13254DBD-5A09-699B-B182-D6460B9D3837",3);
    }
    @Test
    public void total(){
        System.out.println("===========================================");
        System.out.println(adminDao.getTotalCount());
    }

}