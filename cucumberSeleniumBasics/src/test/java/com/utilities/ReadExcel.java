package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ReadExcel {
	
	public static HashMap<String,String> readTheExcel(String TestcaseName) throws IOException {

        FileInputStream file = new FileInputStream(
                "C:\\Users\\Mohit K\\Desktop\\readExcel.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        Sheet sh = wb.getSheet("newSheet");

        HashMap<String, String> map
                = new HashMap<String, String>();

        for (int i = 0; i <= sh.getLastRowNum(); i++) {

            String keyword = sh.getRow(i)
                    .getCell(0)
                    .getStringCellValue();
            if(keyword.equals(TestcaseName)){
                Row row = sh.getRow(i);
                for(int j = 0; j < row.getLastCellNum(); j++){

                    String key = sh.getRow(0).getCell(j).getStringCellValue();
                    String value = row.getCell(j).getStringCellValue();

                    map.put(key, value);

                }
            }

        }
        return map;
     //System.out.println(map.get("Address"));
    }


}
