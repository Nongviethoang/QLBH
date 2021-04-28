import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;

import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
import com.haui.SaleLaptop.reponsitory.AnhRepository;

public class DemoExcel {
	
	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
	public static void main(String[] args) throws IOException{
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("SP");
		List<Emp>list=new ArrayList<Emp>();
		list.add(new Emp(1, 20, "hoang",new Salare(1, 200000, 20)));
		list.add(new Emp(2, 20, "hoang",new Salare(2, 200000, 30)));
		list.add(new Emp(3, 20, "hoang",new Salare(1, 300000, 25)));
		list.add(new Emp(4, 20, "hoang",new Salare(2, 2222222, 22)));
		list.add(new Emp(4, 20, "hoang",new Salare(2, 2222222, 22)));
		list.add(new Emp(4, 20, "hoang",new Salare(2, 2222222, 22)));
		list.add(new Emp(4, 20, "hoang",new Salare(2, 2222222, 22)));
		list.add(new Emp(231, 20, "hoang",new Salare(2, 2222222, 222)));
		list.add(new Emp(4, 20, "hoang",new Salare(2, 2222222, 22)));
		 int rownum = 0;
	        Cell cell;
	        Row row;
	        //
	        HSSFCellStyle style = createStyleForTitle(workbook);
	 
	        row = sheet.createRow(rownum);
	 
	        // EmpNo
	        cell = row.createCell(0, CellType.STRING);
	        cell.setCellValue("EmpNo");
	        cell.setCellStyle(style);
	        // EmpName
	        cell = row.createCell(1, CellType.STRING);
	        cell.setCellValue("Name");
	        cell.setCellStyle(style);
	        // age
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("Age");
	        cell.setCellStyle(style);
	     // age
	        cell = row.createCell(2, CellType.STRING);
	        cell.setCellValue("Salary");
	        cell.setCellStyle(style);

	        // Data
	        for (Emp emp : list) {
	            rownum++;
	            row = sheet.createRow(rownum);
	 
	            // EmpNo (A)
	            cell = row.createCell(0, CellType.STRING);
	            cell.setCellValue(emp.getId());
	            // EmpName (B)
	            cell = row.createCell(1, CellType.STRING);
	            cell.setCellValue(emp.getName());
	            // age (C)
	            cell = row.createCell(2, CellType.NUMERIC);
	            cell.setCellValue(emp.getAge());
	            //salary
	            cell = row.createCell(3, CellType.STRING);
	            cell.setCellValue(emp.getSalare().toString());
	           
	        }
	        File file = new File("D:/demo/employeee.xls");
	        if(file.getParentFile().exists())
	        {
	        	FileOutputStream outFile = new FileOutputStream(file);
		        workbook.write(outFile);;
		        outFile.close();
		        System.out.println("Created file: " + file.getAbsolutePath());
	        }
	        
	        
	        
	       
	        
	}
}
