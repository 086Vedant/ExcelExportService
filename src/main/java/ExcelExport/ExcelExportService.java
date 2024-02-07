package ExcelExport;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExcelExportService {
    
     @Inject
     UserService userSvc;

    public  byte[] generateExcelWorkbook() throws IOException 
    {
        List<User> ListUser = userSvc.getAllUsers();
        int Len = ListUser.size();
        System.out.println("Number of users : " +Len);
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet =  (XSSFSheet) workbook.createSheet("user-sheet");
        XSSFRow headRow = sheet.createRow(0);

        headRow.createCell(0).setCellValue("name");
        headRow.createCell(1).setCellValue("phone");
        headRow.createCell(2).setCellValue("city");
        
        int dataRowIndex =1;
        for(User userIt : ListUser )
        {
            XSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(userIt.name);
            dataRow.createCell(1).setCellValue(userIt.phone);
            dataRow.createCell(2).setCellValue(userIt.city);
            dataRowIndex++;
        }
         
         //Retrieving Excel as a Byte array
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
         workbook.write(bos);
         bos.close();
         workbook.close();

        return bos.toByteArray();
    }
}
