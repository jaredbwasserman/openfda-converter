package com.jaredbwasserman.openfda.excel;

public class ExcelWriterFactory {
    private static FastexcelExcelWriter fastexcelExcelWriter = null;

    public static ExcelWriter getExcelWriter() {
        if (null == fastexcelExcelWriter) {
            fastexcelExcelWriter = new FastexcelExcelWriter();
        }
        return fastexcelExcelWriter;
    }
}
