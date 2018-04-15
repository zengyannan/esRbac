package com.rbac.service.impl;

import com.rbac.dao.AuthDao;
import com.rbac.dao.RoleDao;
import com.rbac.dto.Page;
import com.rbac.dto.PageRole;
import com.rbac.dto.RoleResult;
import com.rbac.entity.Auth;
import com.rbac.entity.Role;
import com.rbac.enums.RoleStatEnum;
import com.rbac.exception.RoleException;
import com.rbac.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Ng on 2017/4/3.
 */
@Service
public class RoleServiceImpl implements  RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AuthDao authDao;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Role> getRoleList(int offset,int limit)  {
        return roleDao.queryAll(offset,limit);
    }

    @Override
    public RoleResult insertRole(Role role) throws RoleException{
        try{
        Role dRole = roleDao.queryByName(role.getRoleName());
        if(dRole!=null){
            throw new RoleException(RoleStatEnum.ROLE_IS_EXIST.getStateInfo());
        }
            role.setRoleAuthAc(this.generatorAuthAc(role.getRoleAuthIds()));
            int result = roleDao.insertRole(role);
            if(result > 0){
                return new RoleResult(role,RoleStatEnum.UPDATE_SUCCESS);
            }else{
                throw new RoleException(RoleStatEnum.UPDATE_FAIL.getStateInfo());
            }
        }catch (RoleException e) {
            logger.error(e.getMessage());
            throw e;
        }catch(Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public RoleResult updateRole(Role role) throws RoleException {
        try{
            Role dRole = roleDao.queryById(role.getRoleId());
            if(dRole == null){
                throw new RoleException(RoleStatEnum.ROLE_NO_EXIST.getStateInfo());
            }
            role.setRoleAuthAc(this.generatorAuthAc(role.getRoleAuthIds()));
            int result = roleDao.updateRole(role);
            if(result > 0){
                role = roleDao.queryById(role.getRoleId());
                return new RoleResult(role,RoleStatEnum.UPDATE_SUCCESS);
            }else{
                throw  new RoleException(RoleStatEnum.UPDATE_FAIL.getStateInfo());
            }
        }catch (RoleException e){
            logger.error(e.getMessage());
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public int deleteRole(int roleId) {
        int result;
        try{
            result = roleDao.deleteRole(roleId);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    private String generatorAuthAc(String authIds) {
        try {
//            Role dRole = roleDao.queryById(roleId);
//            if(dRole == null){
//                throw new RoleException(RoleStatEnum.ROLE_NO_EXIST.getStateInfo());
//            }
            String [] strAuthIds =authIds.split(",");
            String roleAuthAc="";
            List<Auth> authList =authDao.queryAllAuth(null);
            //是否有可用的ac链接
            boolean haveAc=false;
            //查出对应authid模块 拼接模块ac
            for (Auth auth:authList) {
                for (String authid:strAuthIds) {
                    if(auth.getAuthId()==Integer.parseInt(authid)){
                        if(!auth.getAuthA().equals("")&&!auth.getAuthC().equals("")){
                            roleAuthAc+=auth.getAuthC()+"-"+auth.getAuthA()+",";
                            haveAc=true;
                        }
                    }
                }
            }
            //去掉多余逗号
            if(haveAc) {
                roleAuthAc = roleAuthAc.substring(0, roleAuthAc.length() - 1);
            }
            return roleAuthAc;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public int updateState(int roleId,byte roleState) throws RoleException {
        int result;
        try {
            Role dRole = roleDao.queryById(roleId);
            if(dRole == null){
                throw new RoleException(RoleStatEnum.ROLE_IS_EXIST.getStateInfo());
            }
            result = roleDao.updateState(roleId,roleState);

        }catch (RoleException e){
            logger.error(e.getMessage());
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
        return result;
    }

    @Override
    public Page<PageRole> getPage(int pageNow, int pageSize) {
        long count = roleDao.getTotalCount();
        Page<PageRole> page= new Page(pageNow,pageSize,count);
        page.pagination();
        List<Role> roleList = roleDao.queryAll(page.getOffset(),page.getPageSize());
        List<PageRole> list = new ArrayList<>();
        for (Role role:roleList) {
            PageRole pageRole = new PageRole();
            BeanUtils.copyProperties(role,pageRole,new String[]{"roleCreatetime"});
            pageRole.setRoleCreatetime(new Date(role.getRoleCreatetime()));
            list.add(pageRole);
        }
        page.setList(list);
        return page;
    }

    @Override
    public Role getRoleById(int roleId) {
        return roleDao.queryById(roleId);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDao.queryAllRole();
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public AuthDao getAuthDao() {
        return authDao;
    }

    public void setAuthDao(AuthDao authDao) {
        this.authDao = authDao;
    }
}

