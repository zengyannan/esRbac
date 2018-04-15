package com.rbac.dao;

import com.rbac.entity.Admin;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Ng on 2017/3/30.
 */
public interface AdminDao extends BaseDao<Admin> {
    /**
     *
     * @param adminId
     * @return
     */
     Admin queryById(@Param("adminId") String adminId);


    /**
     * 添加管理员
     * @param adminId
     * @param adminName
     * @param adminNickname
     * @param adminPassword
     * @param adminCreatetime
     * @param adminModifytime
     * @param adminEmail
     * @param adminTel
     * @param adminState
     * @return
     */
//     int insert(@Param("adminId") String adminId,
//                     @Param("adminName") String adminName,
//                     @Param("adminNickname") String adminNickname,
//                     @Param("adminPassword") String adminPassword,
//                     @Param("adminCreatetime") int adminCreatetime,
//                     @Param("adminModifytime") int adminModifytime,
//                     @Param("adminEmail") String adminEmail,
//                     @Param("adminTel") String adminTel,
//                     @Param("adminState") byte adminState);


    Admin queryByName(@Param("adminName")String adminName);


    /**
     * 修改admin
     * @param adminId
     * @param adminName
     * @param adminNickname
     * @param adminPassword
     * @param adminCreatetime
     * @param adminModifytime
     * @param adminEmail
     * @param adminTel
     * @return
     */
//    int update(@Param("adminId") String adminId,
//                    @Param("adminName") String adminName,
//                    @Param("adminNickname") String adminNickname,
//                    @Param("adminPassword") String adminPassword,
//                    @Param("adminCreatetime") int adminCreatetime,
//                    @Param("adminModifytime") int adminModifytime,
//                    @Param("adminEmail") String adminEmail,
//                    @Param("adminTel") String adminTel
//                    );


    int insertAdmin(@Param("admin") Admin admin);

    /**
     *
     * @param admin
     * @return
     */
    int updateAdmin(@Param("admin") Admin admin);
    /**
     * 更改状态 亦可用于逻辑删除
     * @param adminId
     * @param adminState
     * @return
     */
    int updateState(@Param("adminId") String adminId,@Param("adminState") byte adminState);

    /**
     * 物理删除
     * @param adminId
     * @return
     */
    int deleteAdmin(@Param("adminId") String adminId);

    /**
     * 设置对应角色
     * @param adminId
     * @param adminRoleId
     * @return
     */
    int setRole(@Param("adminId") String adminId,@Param("adminRoleId") int adminRoleId);
}
