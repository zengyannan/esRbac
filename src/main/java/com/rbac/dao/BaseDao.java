package com.rbac.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;



/**
 * Created by Ng on 2017/3/30.
 */
public interface BaseDao<T> {


    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<T> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     *查询 根据什么排序 是否倒序
     * @param offset
     * @param limit
     * @param orderBy
     * @param isDesc
     * @return
     */
    List<T> queryAllOrderBy(@Param("offset") int offset,
                                @Param("limit") int limit,
                                @Param("orderBy") String orderBy,
                                @Param("isDesc") String isDesc);

    /**
     * 查询总记录数
     * @return
     */

    long getTotalCount();

//    /**
//     *
//     * @param obj
//     * @return
//     */
//    int update(@Param("obj") T obj);
//
//    /**
//     *
//     * @param obj
//     * @return
//     */
//    int insert(@Param("obj") T obj);


}
