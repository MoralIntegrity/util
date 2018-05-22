package edu.moral.utils;


import edu.moral.entity.MapData;
import edu.moral.entity.MapPlan;
import edu.moral.entity.MapResult;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author MoralIntegrity
 * @date 2018-01-10
 */
public class MapUtil {


    public static Double ridePlan(double originX, double originY, double desX, double desY){

        Map<String, String> param = new HashMap(5);

        param.put("origin", originX + "," + originY);
        param.put("destination", desX + "," + desY);
        param.put("key", "16e706e89c0a6bb2e2ce303bc8058903");

        String url = "http://restapi.amap.com/v4/direction/bicycling";

        String result = HttpUtil.doGet(url, param);

        MapData data = JsonUtil.fromJson(result, MapResult.class).getData();


        double min = Double.MAX_VALUE;

        Iterator<MapPlan> iterator = data.getPaths().iterator();

        while(iterator.hasNext()){

            MapPlan item = iterator.next();

            if(item.getDistance() < min){
                min = item.getDistance();
            }

        }



        return min;
    }

    public static void main(String... args){

        double result = ridePlan(116.434307, 39.90909 , 116.434446, 39.90816);

        System.out.println(result);
    }

}
