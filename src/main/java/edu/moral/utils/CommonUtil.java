package edu.moral.utils;

import org.apache.commons.lang3.time.DateUtils;
import org.xerial.snappy.Snappy;

/**
 *
 * @author MoralIntegrity
 * @date 2017-12-20
 */
public class CommonUtil {

    /**
     * 校验空引用
     * @param args
     * @return
     */
    public static boolean checkVoid(Object... args){

        boolean result = false;

        for(Object arg : args){
            if(arg == null){
                result = true;

                break;
            }
        }
        return result;

    }

    public static boolean checkEmpty(String... args){

        boolean result = false;

        if(checkVoid(args)){

            result = true;

            return result;
        }

        for(String arg : args){

            if("".equals(arg)){
                result = true;

                break;
            }
        }

        return result;

    }

    public static void main(String...args) throws Exception{
        String template = "获取奖励#现金券 #元现金";

        String ss = "#";

        System.out.println(template.replaceFirst(ss, "12321").replaceFirst(ss, "110"));
    }


}
