package com.company;

import net.sf.jasperreports.engine.*;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

import java.util.Map;
import java.util.HashMap;

public class Main {

    private static Map[] initializeMapArray() {
        HashMap[] reportRows = new HashMap[4];
        HashMap row1Map = new HashMap();
        HashMap row2Map = new HashMap();
        HashMap row3Map = new HashMap();
        HashMap row4Map = new HashMap();
        row1Map.put("tail_num", "N263Y");
        row1Map.put("aircraft_serial", "T-11");
        row1Map.put("aircraft_model", "39 ROSCOE TRNR RACER");
        row1Map.put("engine_model", "R1830 SERIES");
        row2Map.put("tail_num", "N4087X");
        row2Map.put("aircraft_serial", "BA100-163");
        row2Map.put("aircraft_model", "BRADLEY AEROBAT");
        row2Map.put("engine_model", "R2800 SERIES");
        row3Map.put("tail_num", "N43JE");
        row3Map.put("aircraft_serial", "HAYABUSA 1");
        row3Map.put("aircraft_model", "NAKAJIMA KI-43 IIIA");
        row3Map.put("engine_model", "R1830 SERIES");
        row4Map.put("tail_num", "N912S");
        row4Map.put("aircraft_serial", "9973CC");
        row4Map.put("aircraft_model", "PA18-150");
        row4Map.put("engine_model", "R-1820 SER");
        reportRows[0] = row1Map;
        reportRows[1] = row2Map;
        reportRows[2] = row3Map;
        reportRows[3] = row4Map;

        return reportRows;
    }

    private static JRDataSource createReportDataSource()
    {
        JRMapArrayDataSource dataSource;
        Map[] reportRows = initializeMapArray();
        dataSource = new JRMapArrayDataSource(reportRows);
        return dataSource;
    }

    public static void main(String[] args) {
	// write your code here
        try
        {
            System.out.println("Compiling report...");
             JasperReport jasperReport = JasperCompileManager.compileReport(
             "C:\\Users\\bodya17\\Desktop\\reports\\FirstReport.jrxml");
//            JRDataSource dataSource = new JREmptyDataSource();

            JRDataSource dataSource = createReportDataSource();

            Map params = new HashMap<String, String>();
            params.put("title", "1212122!");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\bodya17\\Desktop\\FirstReport.pdf");
            
//            JasperExportManager.exportReportToPdfFile(
//                "C:\\Users\\bodya17\\Desktop\\reports\\FirstReport.jrxml",
//                "C:\\Users\\bodya17\\Desktop\\FirstReport.pdf"
//            );
             System.out.println("Done!");
        }
        catch (JRException e)
        {
            e.printStackTrace();
        }
    }
}
