package com.rbac.service;

import com.rbac.dto.AuthResult;
import com.rbac.dto.Page;
import com.rbac.dto.PageAuth;
import com.rbac.entity.Auth;
import com.rbac.exception.AuthException;
import com.rbac.exception.RoleException;


import java.util.List;

/**
 * Created by Ng on 2017/4/7.
 */
public interface AuthService {

    List<Auth> queryAll(int offset,int limit);
    Auth getAuthById(int authId);
    AuthResult insertAuth(Auth auth) throws AuthException;
    AuthResult updateAuth(Auth auth) throws AuthException;

    int deleteAuth(int authId);

    int updateState(int authId,byte authState) throws AuthException;

    List<Auth> getAllAuth();

    Page<PageAuth> getPage(int pageNow,int pageSize);

    Auth getAuthTree();

}
