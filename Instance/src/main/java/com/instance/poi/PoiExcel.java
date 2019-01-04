package com.instance.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CreationHelper;

/**
 * Excel文件读写测试类
 * 使用 poi.jar
 * @author endru
 *
 */
public class PoiExcel
{
	/**
	 * 写入Excel
	 * @param file
	 * @throws IOException
	 */
	private void writeExcel(String file) throws IOException
	{
		// 创建excel工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建sheet表单对象
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 创建row行对象
		HSSFRow row = sheet.createRow(0);
		
		// 创建cell单元格对象
		HSSFCell cell=row.createCell(0);	   
		// 设置cell单元格对象值     
		cell.setCellValue(6000); 
		// 设置保留两位小数		           
		HSSFCellStyle cellStyle = wb.createCellStyle();                
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));                
		cell.setCellStyle(cellStyle);	
		// 在该行写入各种类型的数据		
		row.createCell(1).setCellValue(true);		
		row.createCell(2).setCellValue("赵端孺");		
		row.createCell(3).setCellValue(21);							
		//在写入 日期格式的 数据需要进行特殊处理(这是一种 简单的处理方式)		
		CreationHelper createHelper=wb.getCreationHelper();		
		HSSFCellStyle style=wb.createCellStyle();		
		style.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));				
		cell=row.createCell(4);		
		cell.setCellValue(new Date());		
		cell.setCellStyle(style);
		
		row.createCell(6).setCellValue("zdr");
		
		
		HSSFRow row_2 = sheet.createRow(2);
		row_2.createCell(1).setCellValue(false);		
		row_2.createCell(2).setCellValue("张韵婷");		
		row_2.createCell(3).setCellValue(21);	
		
		
		//最后写回磁盘
		FileOutputStream out = new FileOutputStream(file); 
		wb.write(out);
		out.close();
	}
	
	/**
	 * 读取Excel
	 * @param file
	 * @throws IOException
	 */
	private void readExcel(String file) throws IOException
	{
		// 读取excel文件内容
		FileInputStream input = new FileInputStream(file);
		POIFSFileSystem fs = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		
		// 获取excel表格的第一个sheet
		HSSFSheet sheet = wb.getSheetAt(0);
		if (sheet == null)
		{
			return;
		}
		// 获取sheet的物理行数
//		int rowNums = sheet.getPhysicalNumberOfRows();
//		if(rowNums != 0)
//		{
			// 遍历该sheet的行
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++)
			{
				HSSFRow row = sheet.getRow(rowNum);
				if(row == null)
					continue;
				// 遍历该行的所有单元格,getLastCellNum()获取最后一个单元格的编号，若为0则无法判断这是否意味着工作表上有零单元格，或者位置为零。
				for(int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++)
				{
					HSSFCell cell = row.getCell(cellNum);
					if(cell == null)
						continue;
					String strVal=readCell(cell);							
					System.out.print(" " + strVal);

				}
				System.out.println();
			}
//		}
		input.close();
	}
	
	/**
	 * 获取单元格中的值
	 * @param cell
	 * @return
	 */
	private String readCell(HSSFCell cell)
	{
		if (cell == null) 			
			return "";		
		switch (cell.getCellType()) 
		{				
			//数字			
			case HSSFCell.CELL_TYPE_NUMERIC:								
				//日期格式的处理				
				if (HSSFDateUtil.isCellDateFormatted(cell)) 
				{					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");					
					return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();				
				}								
				return String.valueOf(cell.getNumericCellValue());										
			//字符串			
			case HSSFCell.CELL_TYPE_STRING:			
				return cell.getStringCellValue();						
			//公式			
			case HSSFCell.CELL_TYPE_FORMULA:				
				return cell.getCellFormula();							
			//空白			
			case HSSFCell.CELL_TYPE_BLANK:			
				return "";						
			//布尔取值			
			case HSSFCell.CELL_TYPE_BOOLEAN:				
				return cell.getBooleanCellValue() + "";					
			//错误类型			
			case HSSFCell.CELL_TYPE_ERROR:				
				return cell.getErrorCellValue() + "";		
		}				
		return "";
	}

	public static void main(String[] args) throws IOException
	{
		PoiExcel tpe = new PoiExcel();
		// excel文件路径
		String file = "C:\\Users\\endru\\Desktop\\PoiExcel.xls";
		// 写 excel
		tpe.writeExcel(file);
		// 读excel
		tpe.readExcel(file);
	}

}
