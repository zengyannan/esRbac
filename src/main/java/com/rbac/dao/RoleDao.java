package com.rbac.dao;



import com.rbac.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by Ng on 2017/3/30.
 */
public interface RoleDao extends BaseDao<Role>{

    /**
     *
     * @param roleId
     * @return
     */
    Role queryById(@Param("roleId") int roleId);

    Role queryByName(@Param("roleName") String roleName);

//    int insert(@Param("roleId") int roleId,
//                    @Param("roleName") String roleName,
//                    @Param("roleCreatetime") int roleCreatetime,
//                    @Param("roleState") byte roleState);



//    int update(@Param("roleId") int roleId,
//                    @Param("roleName") String roleName
//    );

    int insertRole(@Param("role") Role role);

    int updateRole(@Param("role") Role role);

//    int grandAuth(@Param("roleId") int roleId,
//                  @Param("roleAuthIds") String roleAuthIds,
//                  @Param("roleAuthAc") String roleAuthAc);


    int updateState(@Param("roleId") int roleId,@Param("roleState") byte roleState);


    int deleteRole(@Param("roleId") int roleId);

    List<Role> queryAllRole();
}
