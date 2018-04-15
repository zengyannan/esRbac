package com.rbac.service.impl;

import com.rbac.dao.AdminDao;
import com.rbac.dto.AdminResult;
import com.rbac.dto.Page;
import com.rbac.dto.PageAdmin;
import com.rbac.entity.Admin;
import com.rbac.enums.AdminStatEnum;
import com.rbac.enums.LoginStatEnum;
import com.rbac.enums.RegisterStatEnum;
import com.rbac.exception.AdminException;
import com.rbac.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ng on 2017/4/2.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    private Logger logger =LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Admin> getAdminList(int offset,int limit) {

        return adminDao.queryAll(offset,limit);
    }

    @Override
    public Page getPage(int pageNow, int pageSize) {
        long count =adminDao.getTotalCount();
        Page<PageAdmin> page = new Page(pageNow,pageSize,count);
        page.pagination();
        List<Admin> adminList =adminDao.queryAll(page.getOffset(),page.getPageSize());
        List<PageAdmin> list =new ArrayList();
        for (Admin admin: adminList) {
            PageAdmin pAdmin= new PageAdmin();
            BeanUtils.copyProperties(admin,pAdmin,new String[]{"adminCreatetime","adminModifytime"});
            pAdmin.setAdminCreatetime(new Date(admin.getAdminCreatetime()));
            pAdmin.setAdminModifytime(new Date(admin.getAdminModifytime()));
            list.add(pAdmin);
        }
        page.setList(list);
        return page;
    }

    @Override
    public AdminResult updateAdmin(Admin admin) throws AdminException{
        try {
            Admin dAdmin = adminDao.queryById(admin.getAdminId());
            if (dAdmin == null) {
                throw new AdminException(AdminStatEnum.ADMIN_NO_EXIST.getStateInfo());
            }
            dAdmin=adminDao.queryByName(admin.getAdminName());
            if(dAdmin!=null && !dAdmin.getAdminId().equals(admin.getAdminId())){
                throw new AdminException(AdminStatEnum.ADMIN_NAME_IS_EXIST.getStateInfo());
            }
            int result = adminDao.updateAdmin(admin);
            if(result>0){
                return new AdminResult(AdminStatEnum.UPDATE_SUCCESS);
            }else {
                throw new AdminException(AdminStatEnum.UPDATE_FAIL.getStateInfo());
            }
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public int deleteAdmin(String adminId) {
        int result;
        try {
            result = adminDao.deleteAdmin(adminId);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public int setRole(String adminId, int adminRoleId) throws AdminException{
        int result;
        try {
            Admin admin = adminDao.queryById(adminId);
            if (admin == null) {
                throw new AdminException(AdminStatEnum.ADMIN_NO_EXIST.getStateInfo());
            }
            result = adminDao.setRole(adminId,adminRoleId);
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public int updateState(String adminId, byte adminState)throws AdminException {
        int result;
        try {
            Admin admin = adminDao.queryById(adminId);
            if (admin == null) {
                throw new AdminException(AdminStatEnum.ADMIN_NO_EXIST.getStateInfo());
            }
            result = adminDao.updateState(adminId,adminState);
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public AdminResult login(String adminName, String adminPassword) throws AdminException {
        try {
            Admin admin = adminDao.queryByName(adminName);
            if (admin == null) {
                throw new AdminException(AdminStatEnum.ADMIN_NO_EXIST.getStateInfo());
            }
            if(admin.getAdminState()==0){
                throw new AdminException(LoginStatEnum.ADMIN_NO_USED.getStateInfo());
            }
            if(admin.getRole().getRoleState()==0){
                throw new AdminException(LoginStatEnum.ADMIN_ROLE_NO_USED.getStateInfo());
            }
            if (adminPassword.equals(admin.getAdminPassword())) {
                return new AdminResult(admin, LoginStatEnum.LOGIN_SUCCESS);
            }else{
                throw new AdminException(LoginStatEnum.PASSWORD_ERROR.getStateInfo());
            }
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public AdminResult register(Admin admin) throws  AdminException{
        try{
            Admin dAdmin = adminDao.queryByName(admin.getAdminName());
        if(dAdmin!=null){
              throw new AdminException(AdminStatEnum.ADMIN_IS_EXIST.getStateInfo());
        }
            String adminId = UUID.randomUUID().toString();
            admin.setAdminId(adminId);
            int result = adminDao.insertAdmin(admin);
            if(result > 0){
                return new AdminResult(admin, RegisterStatEnum.REGISTER_SUCCESS);
            }else {
                throw new AdminException(RegisterStatEnum.REGISTER_FAIL.getStateInfo());
            }
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }
        catch (Exception e){
            logger.error(e.getMessage());
            throw  e;
        }
    }

    @Override
    public Admin getAdminById(String adminId) {
        return adminDao.queryById(adminId);
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
