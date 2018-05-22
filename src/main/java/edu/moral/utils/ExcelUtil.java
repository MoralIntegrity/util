package edu.moral.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MoralIntegrity
 * @date 2017-12-20
 */
public class ExcelUtil {

    private static final String XLS = ".xls";

    private static final String XLSX = ".xlsx";

    private static final Map<String, Integer> TITLE = new HashMap<>();

    private static final int TITLE_ROW = 0;

    private static final int CONTENT_ROW = TITLE_ROW + 1;

    public static File createFile(String filePath, String fileName, String fileType) {

        if (CommonUtil.checkEmpty(filePath, fileName, fileType)) {

            System.out.println("==== 参数不可为空 ====");

            return null;
        }

        StringBuilder fullName = new StringBuilder().append(filePath).append(fileName).append(fileType);

        File file = null;
        try {

            File path = new File(filePath);

            if(!path.exists()){
                path.mkdirs();
            }

            file = new File(fullName.toString());

        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("==== 创建文件出错 ====");

        }


        return file;
    }

    public static void writeContent(String filePath, String fileName, String fileType, String sheetName, Map<String, List<String>> content) {

        if (CommonUtil.checkEmpty(sheetName)) {

            System.out.println("==== sheet名称不可为空 ====");

            return;
        }

        File file = createFile(filePath, fileName, fileType);

        Sheet sheet = null;

        Workbook workBook = null;

        if (XLS.equals(fileType)) {

            workBook = new HSSFWorkbook();

        } else if (XLSX.equals(fileType)) {

            workBook = new XSSFWorkbook();

        } else {

            System.out.println("==== 文件类型：" + fileType + "无法识别 ====");

            return;
        }

        sheet = workBook.createSheet(sheetName);

        // Excel 表头
        Row row = sheet.createRow(TITLE_ROW);

        Cell cell = null;

        int index = 0;

        int max = 0;

        for (Map.Entry<String, List<String>> entry : content.entrySet()) {

            cell = row.createCell(index);
            cell.setCellValue(entry.getKey());

            TITLE.put(String.valueOf(entry.getKey()), index + 1);

            if(entry.getValue().size() > max){
                max = entry.getValue().size();
            }

            index++;
        }

        boolean flag = false;
        // Excel 内容
        for (Map.Entry<String, List<String>> entry : content.entrySet()) {

            int point = TITLE.get(entry.getKey());

            List<String> value = entry.getValue();


            for (int i = 0; i < max; i++) {

                if(i >= value.size()) {
                    break;
                }
                if(flag) {
                    row = sheet.getRow(CONTENT_ROW + i);
                }else {
                    row = sheet.createRow(CONTENT_ROW + i);
                }
                row.createCell(point - 1).setCellValue(value.get(i));


            }
            flag = true;

        }


        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);

            workBook.write(outputStream);



        } catch (Exception ex) {
            ex.printStackTrace();

            System.out.println("==== 文件写入出错 ====");
        }finally {
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();

                    System.out.println("==== 关闭输出流出错 ====");
                }
                outputStream = null;
            }
        }


    }


}
