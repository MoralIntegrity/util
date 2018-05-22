package edu.moral.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MoralIntegrity
 * @date 2017-12-22
 */
public class DateUtil {

    public static String convertDate(String pattern, Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String result = simpleDateFormat.format(date);

        return result;
    }

}
