package edu.moral;


import edu.moral.utils.DBUtil;
import edu.moral.utils.ExcelUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MoralIntegrity
 * @date 2017-12-20
 *
 *
 * python ~/Desktop/read_useInfo.py
 */
public class MoralMain {

    public static void main(String...args){

        Connection connection = DBUtil.getConnection();

        PreparedStatement statement = null;

        ResultSet resultSet = null;

        try{

            String sql = "select mc_customer_id,head_url from mc_customer where ifnull(head_url,'') != '' order by mc_customer_id";

            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            Map<String, List<String>> content = new HashMap<>();

            String filePath = "D:/tmp/";
            String fileName = "userInfo";
            String fileType = ".xlsx";
            String sheetName = "info";

            String titleOne = resultSet.getMetaData().getColumnLabel(1);

            String titleTwo = resultSet.getMetaData().getColumnLabel(2);

            List<String> id = new ArrayList<>();
            List<String> url = new ArrayList<>();

            while(resultSet.next()){

                id.add(resultSet.getString(1));
                url.add(resultSet.getString(2));
            }

            content.put(titleOne, id);
            content.put(titleTwo, url);

            ExcelUtil.writeContent(filePath, fileName, fileType, sheetName, content);

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
    }
}
