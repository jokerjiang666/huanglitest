package com.jiang.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

// excel导出工具类
public class ExcelUtil {

    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
        ExportParams exportParams = new ExportParams();
        exportParams.setCreateHeadRows(isCreateHeader);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        if (workbook != null) ;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            try {
                throw new Exception(e.getMessage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

}