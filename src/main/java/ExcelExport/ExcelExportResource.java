package ExcelExport;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;



 @Path("/export")
 public class ExcelExportResource {
    
    @Inject
    ExcelExportService ExcelExportSvc; 

    @GET
    @Produces("application/vnd.ms-excel")
    public Response ExportUserExcel() throws IOException 
    {   
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=user.xlsx";
    
        InputStream is = new ByteArrayInputStream(ExcelExportSvc.generateExcelWorkbook());
        return Response.ok(is).header(headerKey, headerValue).build();
    } 

 }




