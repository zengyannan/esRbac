package com.rbac.service.impl;

import com.rbac.config.RbacConfig;
import com.rbac.dao.AuthDao;
import com.rbac.dto.AuthResult;
import com.rbac.dto.Page;
import com.rbac.dto.PageAuth;
import com.rbac.entity.Admin;
import com.rbac.entity.Auth;
import com.rbac.entity.Role;
import com.rbac.enums.AdminStatEnum;
import com.rbac.enums.AuthStatEnum;
import com.rbac.enums.RoleStatEnum;
import com.rbac.exception.AdminException;
import com.rbac.exception.AuthException;
import com.rbac.exception.RoleException;
import com.rbac.service.AuthService;
import com.rbac.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ng on 2017/4/7.
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthDao authDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    public List<Auth> queryAll(int offset, int limit) {
        return authDao.queryAll(offset,limit);
    }

    @Override
    public AuthResult insertAuth(Auth auth) throws AuthException {
        try{
            Auth dAuth = authDao.queryByName(auth.getAuthName());
            if(dAuth!=null){
                throw new AuthException(AuthStatEnum.AUTH_IS_EXIST.getStateInfo());
            }
            Auth pAuth = authDao.queryById(auth.getAuthPid());
            auth.setAuthUrl(this.getUrl(auth.getAuthC(),auth.getAuthA()));
            auth.setAuthLevel(new Byte(new Integer(pAuth.getAuthLevel()+1).toString()));
            int result = authDao.insertAuth(auth);
            if(result>0){
                result =authDao.updateAuthPath(auth.getAuthId(),auth.getAuthPid()+"-"+auth.getAuthId());
            }
            if(result > 0){
                auth = authDao.queryByName(auth.getAuthName());
                return new AuthResult(auth,AuthStatEnum.UPDATE_SUCCESS);
            }else{
                throw new AuthException(AuthStatEnum.UPDATE_FAIL.getStateInfo());
            }
        }catch (AuthException e){
            logger.error(e.getMessage());
            throw  e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public AuthResult updateAuth(Auth auth) throws AuthException {
        try{
            Auth dAuth = authDao.queryById(auth.getAuthId());
            if(dAuth==null){
                throw new AuthException(AuthStatEnum.AUTH_NO_EXIST.getStateInfo());
            }
            Auth pAuth = authDao.queryById(auth.getAuthPid());
            auth.setAuthUrl(this.getUrl(auth.getAuthC(),auth.getAuthA()));
            auth.setAuthLevel(new Byte(new Integer(pAuth.getAuthLevel()+1).toString()));
            auth.setAuthPath(auth.getAuthPid()+"-"+auth.getAuthId());
            int result = authDao.updateAuth(auth);
            if(result > 0){
                auth = authDao.queryByName(auth.getAuthName());
                return new AuthResult(auth,AuthStatEnum.UPDATE_SUCCESS);
            }else{
                throw new AuthException(AuthStatEnum.UPDATE_FAIL.getStateInfo());
            }
        }catch (AuthException e){
            logger.error(e.getMessage());
            throw  e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public int deleteAuth(int authId) {
        int result;
        try {
            result = authDao.deleteAuth(authId);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public int updateState(int authId, byte authState) throws AuthException {
        int result;
        try{
            Auth dAuth = authDao.queryById(authId);
            if(dAuth==null){
                throw new AuthException(AuthStatEnum.AUTH_NO_EXIST.getStateInfo());
            }
            result = authDao.updateState(authId,authState);
        }catch (AuthException e){
            logger.error(e.getMessage());
            throw  e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }


    public Auth getAuthTree(){
        Auth root=null;
        Byte authLevel =null;
        try{
            root =authDao.queryById(RbacConfig.AUTH_ROOT_ID);
            List<Auth> auths;
            auths=authDao.queryAllAuth(authLevel);
            this.splitNodes(root,auths);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return root;
    }



    private void splitNodes(Auth node,List<Auth> auths){
        List<Auth> children=null;
        if(hasChild(node.getAuthId(),auths)){
            children=new ArrayList<Auth>();
            for (Auth auth:auths) {
                if(node.getAuthId()==auth.getAuthPid()){
                    children.add(auth);
                    splitNodes(auth,auths);
                }
            }
        }
        node.setChildren(children);
    }

    private boolean hasChild(int authId,List<Auth> auths){
        boolean result=false;
        for (Auth auth:auths) {
            if(auth.getAuthPid()==authId){
                result=true;
            }
        }
        return result;
    }

    @Override
    public List<Auth> getAllAuth() {
        return authDao.queryAllAuth(null);
    }

    @Override
    public Page<PageAuth> getPage(int pageNow, int pageSize) {
        long count =authDao.getTotalCount();
        Page page =new Page(pageNow,pageSize,count);
        page.pagination();
        List<Auth> authList =authDao.queryAll(page.getOffset(),page.getPageSize());
        List<PageAuth> list =new ArrayList<>();
        for (Auth auth:authList) {
            PageAuth pageAuth = new PageAuth();
            BeanUtils.copyProperties(auth,pageAuth,new String[]{"authCreatetime"});
            pageAuth.setAuthCreatetime(new Date(auth.getAuthCreatetime()));
            list.add(pageAuth);
        }
        page.setList(list);
        return page;
    }

    @Override
    public Auth getAuthById(int authId) {
        return authDao.queryById(authId);
    }

    private String getUrl(String c, String a){
        if(!c.equals("")&&!a.equals("")){
            return "/"+c+"/"+a;
        }else{
            return "";
        }
    }


    public AuthDao getAuthDao() {
        return authDao;
    }

    public void setAuthDao(AuthDao authDao) {
        this.authDao = authDao;
    }
}
