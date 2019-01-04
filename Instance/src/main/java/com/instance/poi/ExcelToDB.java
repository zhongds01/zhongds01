package com.instance.poi;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * Excel数据导入数据库
 * 使用 poi.jar、mysql-connector.jar
 * @author endru
 *
 */
public class ExcelToDB
{
	// POIFS系统对象，管理文件系统的整个生命周期。
	private POIFSFileSystem fs;
	// excel工作簿对象
	private HSSFWorkbook wb;
	// sheet表单对象
	private HSSFSheet sheet;
	// row行对象
	private HSSFRow row;

	/**
	 * 读取Excel数据内容
	 * 
	 * @param url
	 *            Excel表格的路径
	 * @return List<Map<Integer, String>> 包含单元格数据内容的List对象
	 * @throws FileNotFoundException
	 */
	public List<Map<Integer, String>> readExcelContent(String url) throws FileNotFoundException
	{
		// contentList对象存储excel内容
		List<Map<Integer, String>> contentList = new ArrayList<Map<Integer, String>>();
		// 输入流
		InputStream is = new FileInputStream(url);
		try
		{
			// 实例化
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 获取第一个sheet表单
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		// 获取表单第一行
		row = sheet.getRow(0);
		// 获取第一行的物理列数
		int colNum = row.getPhysicalNumberOfCells();
		// 获取正文内容，正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++)
		{
			// str对象存储一个单元格中的数据
			String str = "";
			// content对象存储一行数据
			Map<Integer, String> content = new HashMap<Integer, String>();
			// 获取当前行的row对象
			row = sheet.getRow(i);
			// 获取行中的数据
			for (int j = 0; j < colNum; j++)
			{
				// 单元格中的数据放入str中
				str = readCell(row.getCell(j)).trim();
				// Excel每一行放到Map中
				content.put(j, str);
			}
			// 放到List集合
			contentList.add(content);
		}
		// 返回正文内容
		return contentList;
	}

	/**
	 * 获取单元格中的值
	 * 
	 * @param cell
	 * @return
	 */
	private String readCell(HSSFCell cell)
	{
		if (cell == null)
			return "";
		switch (cell.getCellType())
		{
		// 数字
		case HSSFCell.CELL_TYPE_NUMERIC:
			// 日期格式的处理
			if (HSSFDateUtil.isCellDateFormatted(cell))
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
				System.out.println(cellValue);
				return cellValue;
			}
			return String.valueOf(cell.getNumericCellValue());
		// 字符串
		case HSSFCell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		// 公式
		case HSSFCell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		// 空白
		case HSSFCell.CELL_TYPE_BLANK:
			return "";
		// 布尔取值
		case HSSFCell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue() + "";
		// 错误类型
		case HSSFCell.CELL_TYPE_ERROR:
			return cell.getErrorCellValue() + "";
		}
		return "";
	}

	public void saveToDB()
	{
		String URL = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC  ";
		String DRIVER = "com.mysql.jdbc.Driver";
		String USER = "root";
		String PASSWORD = "4814";
		String FILEPATH = "C:\\Users\\endru\\Documents\\PersonalData\\AsiaInfo\\Document\\18.9.30 工单\\工单id_poi.xls";
		try
		{
			// 加载MySql驱动
			Class.forName(DRIVER);
			// 获得数据库连接
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected database successfully...");

			// 设置数据库不自动提交
			conn.setAutoCommit(false);

			// 创建表格
			System.out.println("Creating table in given database...");
			Statement stmt = conn.createStatement();
			String sql_create = "CREATE TABLE worksheet (id INTEGER not NULL PRIMARY KEY, title VARCHAR(255), date DATE)";
			stmt.executeUpdate(sql_create);
			System.out.println("Created table in given database...");
			stmt.close();

			// 写入内容
			// 获得Excel表格的内容
			System.out.println("Inserting data into table...");
			ExcelToDB excelReader = new ExcelToDB();
			List<Map<Integer, String>> contentList = excelReader.readExcelContent(FILEPATH);

			// 获得Map的key的个数
			int cloumtCount = contentList.get(0).size();

			String sql = "INSERT INTO worksheet(id, title, date) VALUES(?,?,?)";
			// 预编译SQL，减少sql执行
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 传参
			for (int i = 0; i < contentList.size(); i++)
			{
				for (int j = 1; j <= cloumtCount; j++)
				{
					pstmt.setObject(j, contentList.get(i).get(j - 1));
				}
				pstmt.addBatch();
			}
			// 执行
			pstmt.executeBatch();
			System.out.println("Inserted data into table...");
			conn.commit();
			pstmt.close();
			conn.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		ExcelToDB excelToDB = new ExcelToDB();
		excelToDB.saveToDB();
		System.out.println("over");
	}
}
