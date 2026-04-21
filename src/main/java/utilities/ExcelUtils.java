package utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    private static Sheet sheet;

    public static void loadExcel(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                    "Sheet '" + sheetName + "' not found in Excel"
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(
                "Failed to load Excel file from path: " + path, e
            );
        }
    }

    public static String getData(int row, int cell) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(cell));
    }
}
