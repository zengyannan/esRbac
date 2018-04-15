package com.rbac.utils;

import com.rbac.model.UserModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by Ng on 2017/3/31.
 */
public class CommonUtils {


    public static int  dateToInt(Date date){
        return new Long( new Date().getTime()).intValue();
    }

    public static int[] strToIntArray(String str,String separator){
        String[] strArray =str.split(separator);
        int [] intArray =new int[strArray.length];
        for(int i=0;i<strArray.length;i++){
            intArray[i]=Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static List<Boolean> matchUserNameAndPassword(String userName,String password){
        boolean flag;
        Pattern pattern;
        Matcher matcher;
        List<Boolean> result =new ArrayList<>();
        pattern =Pattern.compile("^[a-zA-Z0-9_]{4,15}$");
        matcher=pattern.matcher(userName);
        if(matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        pattern=Pattern.compile("^[a-zA-Z0-9]{5,17}$");
        matcher=pattern.matcher(password);
        if(matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        return result;
    }
    public static List<Boolean> validateUser(UserModel user){
        boolean flag;
        Pattern pattern;
        Matcher matcher;
        List<Boolean> result =new ArrayList<>();
        pattern =Pattern.compile("^[a-zA-Z0-9_]{4,15}$");
        matcher=pattern.matcher(user.getName());
        if(matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        pattern=Pattern.compile("^[a-zA-Z0-9]{5,17}$");
        matcher=pattern.matcher(user.getPassword());
        if(matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        pattern=Pattern.compile("[@#\\$%\\^&\\*]+/g");
        matcher=pattern.matcher(user.getNickname());
        if(!matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        pattern=Pattern.compile("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
        matcher=pattern.matcher(user.getEmail());
        if(matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        pattern=Pattern.compile("^1[3|4|5|8][0-9]\\d{8}$");
        matcher=pattern.matcher(user.getTel());
        if(matcher.matches()){
            flag=true;
        }else {
            flag=false;
        }
        result.add(flag);
        return result;
    }

}
