package edu.moral.utils;

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


}
