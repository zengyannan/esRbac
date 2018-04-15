package com.rbac.service;

import com.rbac.dto.AdminResult;
import com.rbac.dto.Page;
import com.rbac.entity.Admin;
import com.rbac.entity.Auth;
import com.rbac.exception.AdminException;

import java.util.List;

/**
 * Created by Ng on 2017/4/2.
 */
public interface AdminService {


    /**
     * 查询管理员列表
     * @return
     */
    List<Admin> getAdminList(int offset,int limit);

    Page getPage(int pageNow,int pageSize);

    AdminResult updateAdmin(Admin admin) throws AdminException;

    int deleteAdmin(String adminId);


    int setRole(String adminId,int adminRoleId)throws AdminException;

    int updateState(String adminId,byte adminState)throws AdminException;

    AdminResult login(String adminName, String adminPassword) throws AdminException;

    AdminResult register(Admin admin) throws AdminException;

    Admin getAdminById(String adminId);
}
