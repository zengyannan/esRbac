package com.rbac.service;

import com.rbac.dto.Tree;
import com.rbac.entity.Auth;
import com.rbac.exception.AdminException;

import com.rbac.exception.RoleException;

/**
 * Created by Ng on 2017/4/10.
 */
public interface IndexService {

    Tree getTree(String adminId) throws AdminException,RoleException;
    Auth getAuthTree(String adminId)throws AdminException,RoleException;
}
