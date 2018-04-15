package com.rbac.service;

import com.rbac.dto.Page;
import com.rbac.dto.PageRole;
import com.rbac.dto.RoleResult;
import com.rbac.entity.Role;
import com.rbac.exception.RoleException;

import java.util.List;

/**
 * Created by Ng on 2017/4/3.
 */
public interface RoleService {

     List<Role> getRoleList(int offset,int limit);

     Page<PageRole> getPage(int offset, int limit);


     RoleResult insertRole(Role role) throws RoleException;

     RoleResult updateRole(Role role) throws RoleException;

     int deleteRole(int roleId);


     int updateState(int roleId,byte roleState) throws RoleException;

     List<Role> getAllRole();

     Role getRoleById(int roleId);

}
