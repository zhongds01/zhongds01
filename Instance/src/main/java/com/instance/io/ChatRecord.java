package com.instance.io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatRecord
{
	/**
	 * 设置聊天记录保存路径
	 *
	 * @param path
	 * @return
	 */
	public static File setChatRecordPath(String path)
	{
		File file = new File(path);
		try
		{
			if (!file.exists())
			{
				file.createNewFile();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * 读取聊天记录
	 *
	 * @param path
	 * @return
	 */
	public static List<String> readRecord(String path, int saveTime)
	{
		File file = setChatRecordPath(path);
		List<String> recordList = new ArrayList<String>();
		String line = null;
		BufferedReader br = null;
		try
		{
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader
			br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			line = br.readLine(); // 一次读入一行数据
			while (!(line == null || line.equals("")))
			{
				String[] recordInfo = line.split("_");
				// 获取聊天记录时间
				long past = simpleDateFormat.parse(recordInfo[0].trim()).getTime();
				// 获取当前时间
				long now = (new Date()).getTime();
				int days = (int) ((now - past) / (1000 * 60 * 60 * 24));
				if (days < saveTime)
					recordList.add(line);
				line = br.readLine(); // 一次读入一行数据
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				br.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		writeRecords(recordList, path);
		return recordList;
	}

	/**
	 * 写入一条聊天记录
	 *
	 * @param who
	 * @param towho
	 * @param content
	 * @param path
	 */
	public static void writeRecord(String date, String who, String towho, String content, String path)
	{

		File file = setChatRecordPath(path);
		// 获取当前日期
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String date = simpleDateFormat.format(new Date());

		// 拼接聊天记录
		StringBuffer sb = new StringBuffer();
		sb.append(date);
		sb.append("_");
		sb.append(who);
		sb.append("_");
		sb.append(towho);
		sb.append("_");
		sb.append(content);

		BufferedWriter out = null;
		try
		{
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file, true));//falg为true追加写入，为false覆盖写入
			out = new BufferedWriter(output);
			out.write(sb.toString() + "\r\n");
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				out.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写入多条聊天记录
	 *
	 * @param records
	 * @param path
	 */
	public static void writeRecords(List<String> records, String path)
	{
		File file = setChatRecordPath(path);
		BufferedWriter out = null;
		try
		{
			OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(file, false));//true追加写入，false覆盖写入
			out = new BufferedWriter(output);
			for (String record : records)
			{
				out.write(record + "\r\n");
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				out.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		int saveTime = 7;
		String path = "ChatRecord.txt";
		String who = "zyt";
		String towho = "zdr";
		String content = "222222";
		StringBuffer date = new StringBuffer("2018-10-19 16:08");
		for (int i = 1; i <= 9; i++)
		{
			date.setCharAt(9, (char) (i + '0'));
			writeRecord(date.toString(), who, towho, content, path);
		}

		System.out.println(readRecord(path, saveTime));
	}
}
