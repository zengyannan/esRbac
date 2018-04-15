package com.rbac.dao;

import com.rbac.entity.Auth;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Ng on 2017/3/30.
 */
public interface AuthDao extends BaseDao<Auth> {


    Auth queryByIdTest(@Param("authId") int authId);


    Auth queryById(@Param("authId") int authId);

    Auth queryByName(@Param("authName") String authName);


//               int insert(@Param("authId") int authId,
//               @Param("authName") String authName,
//               @Param("authPid") int authPid,
//               @Param("authC") String authC,
//               @Param("authA") String authA,
//               @Param("authPath") String authPath,
//               @Param("authUrl") String authUrl,
//               @Param("authLevel") byte authLevel,
//               @Param("authState") byte authState,
//               @Param("authCreatetime") int authCreatetime
//               );

    int insertAuth(@Param("auth")Auth auth);

    int updateAuth(@Param("auth")Auth auth);

//    int update(@Param("authId") int authId,
//               @Param("authName") String authName,
//               @Param("authPid") int authPid,
//               @Param("authC") String authC,
//               @Param("authA") String authA,
//               @Param("authPath") String authPath,
//               @Param("authUrl") String authUrl,
//               @Param("authLevel") byte authLevel,
//               @Param("authState") byte authState
//    );


    List<Auth> queryAllAuth(@Param("authLevel") Byte authLevel);

    List<Auth> queryAuthByIn(@Param("authIds") int[] authIds,@Param("authLevel") Byte authLevel);

    int updateState(@Param("authId") int authId,@Param("authState") Byte authState);


    int deleteAuth(@Param("authId") int authId);


    int updateAuthPath(@Param("authId") int authId,@Param("authPath") String authPath);


}
