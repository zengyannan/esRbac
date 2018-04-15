package com.rbac.service.impl;

import com.rbac.config.RbacConfig;
import com.rbac.dao.AdminDao;
import com.rbac.dao.AuthDao;
import com.rbac.dto.Tree;
import com.rbac.entity.Admin;
import com.rbac.entity.Auth;
import com.rbac.entity.Role;
import com.rbac.enums.AdminStatEnum;
import com.rbac.enums.RoleStatEnum;
import com.rbac.exception.AdminException;
import com.rbac.exception.RoleException;
import com.rbac.service.IndexService;
import com.rbac.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ng on 2017/4/10.
 */
@Service
public class IndexServiceImpl implements IndexService{

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AuthDao authDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Tree getTree(String adminId) throws AdminException,RoleException{
        try{
            Admin admin =adminDao.queryById(adminId);
            List<Auth> auths;
            Auth root;
            Byte authLevel =3;
            root =authDao.queryById(RbacConfig.AUTH_ROOT_ID);
            if(admin==null){
                throw new AdminException(AdminStatEnum.ADMIN_NO_EXIST.getStateInfo());
            }
            Role role=admin.getRole();
            if(role == null){
                throw new RoleException(RoleStatEnum.ROLE_IS_EXIST.getStateInfo());
            }
            //超级管理员
            if(role.getRoleId()== RbacConfig.SUPER_ADMIN_ROLE_ID){
                 auths=authDao.queryAllAuth(authLevel);
            }else {
                String roleAuthIds=role.getRoleAuthIds();
                int[] authIds = CommonUtils.strToIntArray(roleAuthIds,",");
                auths=authDao.queryAuthByIn(authIds,authLevel);
            }
            Tree tree=new Tree();
//            BeanUtils.copyProperties(root,tree);
            this.authToTree(root,tree);
            generatorTree(tree,auths);
            return tree;
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }catch (RoleException e){
            logger.error(e.getMessage());
            throw e;
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }


    public Auth getAuthTree(String adminId)throws AdminException,RoleException{
        Auth root=null;
        Byte authLevel =null;
        try{
            Admin admin =adminDao.queryById(adminId);
            List<Auth> auths;
            root =authDao.queryById(RbacConfig.AUTH_ROOT_ID);
            if(admin==null){
                throw new AdminException(AdminStatEnum.ADMIN_NO_EXIST.getStateInfo());
            }
            Role role=admin.getRole();
            if(role == null){
                throw new RoleException(RoleStatEnum.ROLE_IS_EXIST.getStateInfo());
            }
            //超级管理员
            if(role.getRoleId()== RbacConfig.SUPER_ADMIN_ROLE_ID){
                auths=authDao.queryAllAuth(authLevel);
            }else {
                String roleAuthIds=role.getRoleAuthIds();
                int[] authIds = CommonUtils.strToIntArray(roleAuthIds,",");
                auths=authDao.queryAuthByIn(authIds,authLevel);
            }
            this.splitNodes(root,auths);
        }catch (AdminException e){
            logger.error(e.getMessage());
            throw e;
        }catch (RoleException e){
            logger.error(e.getMessage());
            throw e;
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


    private void generatorTree(Tree tree,List<Auth> auths){
        List<Tree> nodes;
        int childNumber =this.childNumber(tree.getAuthId(),auths);
        if(childNumber>0){
            nodes =new ArrayList<Tree>();
            for (Auth auth:auths) {
                if(auth.getAuthPid()==tree.getAuthId()){
                    Tree dtree=new Tree();
                    this.authToTree(auth,dtree);
                    nodes.add(dtree);
                    this.generatorTree(dtree,auths);
                }
            }
              tree.setNodes(nodes);
        }
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

    private int  childNumber(int authId,List<Auth> auths){
        int number=0;
        for (Auth auth:auths) {
            if(auth.getAuthPid()==authId){
                number=number+1;
            }
        }
        return number;
    }

    private void authToTree(Auth auth,Tree tree){
        tree.setAuthId(auth.getAuthId());
        tree.setText(auth.getAuthName());
        tree.setAuthPid(auth.getAuthPid());
        tree.setHref(auth.getAuthUrl());
    }
}
