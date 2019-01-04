package com.instance.mail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 邮件测试类 使用 mail.jar
 * 
 * @author endru
 *
 */
public class Mail
{
	// 发件人邮箱
	public static final String myEmailAccount = "zhaodr@asiainfo.com";
	// 发件人密码
	// PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
	// 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
	public static final String myEmailPassword = "********";
	// 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
	public static final String myEmailSMTPHost = "mail.asiainfo.com";
	// 收件人邮箱
	public static final String receiveMailAccount = "endruz@foxmail.com";
	// 图片路径
	public static final String picturePath = "C:\\Users\\endru\\Pictures\\Camera Roll\\桌面\\20.jpg";
	// 文件路径
	public static final String filePath = "C:\\Users\\endru\\Documents\\PersonalData\\AsiaInfo\\Document\\18.9.30 工单\\工单id_poi.xls";

	/**
	 * 创建邮件
	 * 
	 * @param session
	 * @param myEmailAccount
	 * @param receiveMailAccount
	 * @return
	 * @throws MessagingException
	 * @throws IOException
	 */
	public MimeMessage createMail(Session session, String myEmailAccount, String receiveMailAccount)
			throws MessagingException, IOException
	{
		// 1. 创建邮件对象
		// Properties props = new Properties(); // 用于连接邮件服务器的参数配置（发送邮件时才需要用到）
		// Session session = Session.getInstance(props); // 根据参数配置，创建会话对象（为了发送邮件准备的）
		MimeMessage message = new MimeMessage(session); // 创建邮件对象

		// 也可以根据已有的eml邮件文件创建 MimeMessage 对象 MimeMessage message = new
		// MimeMessage(session, new FileInputStream("MyEmail.eml"));

		// 2. From: 发件人
		// 其中 InternetAddress 的三个参数分别为: 邮箱, 显示的昵称(只用于显示, 没有特别的要求), 昵称的字符集编码
		// 真正要发送时, 邮箱必须是真实有效的邮箱。
		message.setFrom(new InternetAddress(myEmailAccount, "endRuz_send", "UTF-8"));

		// 3. To: 收件人
		message.setRecipient(MimeMessage.RecipientType.TO,
				new InternetAddress(receiveMailAccount, "endRuz_receive", "UTF-8"));
		// // To: 增加收件人（可选）
		// message.addRecipient(MimeMessage.RecipientType.TO, new
		// InternetAddress("dd@receive.com", "USER_DD", "UTF-8"));
		// // Cc: 抄送（可选）
		// message.setRecipient(MimeMessage.RecipientType.CC, new
		// InternetAddress("ee@receive.com", "USER_EE", "UTF-8"));
		// // Bcc: 密送（可选）
		// message.setRecipient(MimeMessage.RecipientType.BCC, new
		// InternetAddress("ff@receive.com", "USER_FF", "UTF-8"));

		// 4. Subject: 邮件主题
		message.setSubject("TEST邮件主题", "UTF-8");

		// // 5. Content: 邮件正文（可以使用html标签）
		// message.setContent("TEST这是邮件正文。。。", "text/html;charset=UTF-8");
		
		/*
         * 下面是邮件内容的创建:
         */

        // 5. 创建图片“节点”
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(picturePath)); // 读取本地文件
        image.setDataHandler(dh);                   // 将图片数据添加到“节点”
        image.setContentID("picture");     // 为“节点”设置一个唯一编号（在文本“节点”将引用该ID）

        // 6. 创建文本“节点”
        MimeBodyPart text = new MimeBodyPart();
        //    这里添加图片的方式是将整个图片包含到邮件内容中, 实际上也可以以 http 链接的形式添加网络图片
        text.setContent("This is joker <br/><img src='cid:picture'/>", "text/html;charset=UTF-8");

        // 7. （文本+图片）设置 文本 和 图片 “节点”的关系（将 文本 和 图片 “节点”合成一个混合“节点”）
        MimeMultipart mm_text_image = new MimeMultipart();
        mm_text_image.addBodyPart(text);
        mm_text_image.addBodyPart(image);
        mm_text_image.setSubType("related");    // 关联关系

        // 8. 将 文本+图片 的混合“节点”封装成一个普通“节点”
        //    最终添加到邮件的 Content 是由多个 BodyPart 组成的 Multipart, 所以我们需要的是 BodyPart,
        //    上面的 mm_text_image 并非 BodyPart, 所有要把 mm_text_image 封装成一个 BodyPart
        MimeBodyPart text_image = new MimeBodyPart();
        text_image.setContent(mm_text_image);

        // 9. 创建附件“节点”
        MimeBodyPart attachment = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource(filePath));  // 读取本地文件
        attachment.setDataHandler(dh2);                                             // 将附件数据添加到“节点”
        attachment.setFileName(MimeUtility.encodeText(dh2.getName()));              // 设置附件的文件名（需要编码）

        // 10. 设置（文本+图片）和 附件 的关系（合成一个大的混合“节点” / Multipart ）
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text_image);
        mm.addBodyPart(attachment);     // 如果有多个附件，可以创建多个多次添加
        mm.setSubType("mixed");         // 混合关系

        // 11. 设置整个邮件的关系（将最终的混合“节点”作为邮件的内容添加到邮件对象）
        message.setContent(mm);
        
		
		// 12. 设置显示的发件时间
		message.setSentDate(new Date());

		// 13. 保存前面的设置
		message.saveChanges();

		return message;
	}

	/**
	 * 发送邮件
	 * 
	 * @throws MessagingException
	 * @throws IOException
	 */
	public void sendMail() throws MessagingException, IOException
	{
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的 SMTP 服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证

		// PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
		// 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
		// 打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
		/*
		 * // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接, // 需要改为对应邮箱的 SMTP
		 * 服务器的端口, 具体可查看对应邮箱服务的帮助, // QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看) final String
		 * smtpPort = "465"; props.setProperty("mail.smtp.port", smtpPort);
		 * props.setProperty("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * props.setProperty("mail.smtp.socketFactory.fallback", "false");
		 * props.setProperty("mail.smtp.socketFactory.port", smtpPort);
		 */

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

		// 3. 创建一封邮件
		MimeMessage message = createMail(session, myEmailAccount, receiveMailAccount);
		// 将该邮件保存到本地
		OutputStream out = new FileOutputStream("MyEmail.eml");
		message.writeTo(out);
		out.flush();
		out.close();

		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();

		// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		//
		// PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
		// 仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
		// 类型到对应邮件服务器的帮助网站上查看具体失败原因。
		//
		// PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
		// (1) 邮箱没有开启 SMTP 服务;
		// (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
		// (3) 邮箱服务器要求必须要使用 SSL 安全连接;
		// (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
		// (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
		//
		// PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
		transport.connect(myEmailAccount, myEmailPassword);

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人,
		// 密送人
		transport.sendMessage(message, message.getAllRecipients());

		// 7. 关闭连接
		transport.close();
	}

	public static void main(String[] args) throws MessagingException, IOException
	{
		Mail testMail = new Mail();
		testMail.sendMail();
		System.out.println("over");
	}
}
