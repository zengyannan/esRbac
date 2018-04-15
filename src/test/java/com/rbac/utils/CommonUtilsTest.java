package com.rbac.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ng on 2017/4/15.
 */
public class CommonUtilsTest {
    @Test
    public void matchUserNameAndPassword() throws Exception {
        System.out.print(CommonUtils.matchUserNameAndPassword("admin","admin"));
    }

}