package edu.moral.common;


import java.net.InetAddress;

/**
 *
 * @author MoralIntegrity
 * @date 2017-12-22
 */
public class Const {

    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";


    public static void main(String...args) throws Exception{


        String ip = "192.168.0.215";

        String ping = "ping -l 65500 -t " + ip;

        Process result = Runtime.getRuntime().exec(ping);

        System.out.println(result);
    }

}
