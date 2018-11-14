package edu.moral.utils;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with default template
 *
 * @author : MoralIntegrity
 * @date : 2018-10-21 21:21
 * description : util edu.moral.utils class RewardUtil
 */
public class RewardUtil {

    public static void main(String...args) throws Exception{
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    rewardGenerator();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }


    private static void rewardGenerator() throws Exception{

        Connection connection = DBUtil.getConnection("jdbc:mysql://localhost:3306/moral", "root", "root");


        String sql = "insert into reward_record(reward_code, join_count, result) values(?, ?, ?)";
        String query = "select reward_code from reward where reward_id = ?";

        int joinMin = 10000;

        int joinMax = 99999;

        int poolMax = 17424;

        int generateCount = 3000;

        Random random = new Random();

        PreparedStatement statement = null;
        ResultSet resultSet = null;


        for(int i = 0; i < generateCount; i++){

            int currentIndex = random.nextInt(poolMax) + 1;
            int currentCode = 0;

            statement = connection.prepareStatement(query);

            statement.setInt(1, currentIndex);

            resultSet = statement.executeQuery();

            while(resultSet.next()){
                currentCode = resultSet.getInt(1);
            }

            int currentCount = random.nextInt(joinMax - joinMin) + joinMin;

            Double result = (currentCode * 1.0 / 1000000) * currentCount;

            statement = connection.prepareStatement(sql);

            statement.setInt(1, currentCode);
            statement.setInt(2, currentCount);
            statement.setInt(3, result.intValue());

            statement.execute();
        }

        DBUtil.close(resultSet);
        DBUtil.close(statement);
        DBUtil.close(connection);

    }

    private static void initNumberPool() throws Exception{
        Connection connection = DBUtil.getConnection("jdbc:mysql://localhost:3306/moral", "root", "root");

        String sql = "insert into reward(reward_code) values(?)";

        int begin = 1;
        int end = 999999;
        int count = 0;

        PreparedStatement statement = null;

        for(int i = begin; i<= end; i++){
            if(isLegalNumber(i)){

                statement = connection.prepareStatement(sql);

                statement.setInt(1, i);
                statement.execute();

                //System.out.println(i);
                count++;
            }

        }


        System.out.println(count);

        DBUtil.close(statement);
        DBUtil.close(connection);

    }

    private static boolean isLegalNumber(Integer number){

        List<Integer> numberBit = splitNumberToBit(number, 6);

        //numberBit.forEach(System.out::print);

        //System.out.println();

        int a,b,c,d,e,f;

        a = numberBit.get(5);
        b = numberBit.get(4);
        c = numberBit.get(3);
        d = numberBit.get(2);
        e = numberBit.get(1);
        f = numberBit.get(0);

        if(a == 0 && b == 0 || c == 0 && d == 0 || e ==0 && f == 0){
            return false;
        }

        if(b > 1 || d > 3 || f > 3){
            return false;
        }

        return !(a > 6 && b >= 1 || c > 3 && d >= 3 || e > 3 && f >= 3);
    }

    private static List<Integer> splitNumberToBit(Integer number, Integer size) {

        List<Integer> bit = Lists.newArrayList();

        for(int i = 0 ;i < size; i++){
            bit.add(0);
        }

        for(int i = 0 ;i < size; i++){
            bit.set(i, number % 10);

            number /= 10;
        }

        return bit;
    }

}
