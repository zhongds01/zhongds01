package com.ai.sacenter.i18n;

import com.ai.appframe2.util.locale.ICustomLocaleResource;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: 开通国际语言资源</p>
 * <p>Copyright: Copyright (c) 2017年5月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpdfxResource extends ICustomLocaleResource {
	/**
	 * 根据资源编码获取APP层国际资源[如异常则生成默认国际资源]
	 * @param resource
	 * @param args
	 * @return
	 */
	public String getLocal( String resource, Object args[] );
	
	/**
	 * 获取当前语言属性 
	 * @return
	 */
	public java.util.Locale getDefault();
	
	/**
	 * 根据资源编码获取国际资源规范
	 * @param resource 资源编码
	 * @return
	 */
	public ISystemTemplate.IUpfgkmResource getDefault( String resource );
	
	/**
	 * 根据资源编码获取国际资源[如异常则生成默认国际资源]
	 * @param resource 资源编码
	 * @param args 参数
	 * @return
	 */
	public String getDefault( String resource, Object args[] );
	
	/**
	 * 根据资源编码获取国际资源[如异常则抛异常]
	 * @param resource 资源编码
	 * @param args 参数
	 * @return
	 */
	public String getResource( String resource, Object args[] );
	
	/**
	 * 根据异常类型转换为开通异常
	 * @param exception 异常类型
	 * @return
	 */
	public SFException getResource( java.lang.Exception exception );
	
	/**
	 * 根据异常类型转换为开通异常
	 * @param originator 发起方
	 * @param exception 异常类型
	 * @return
	 */
	public SFException getResource( String originator, java.lang.Exception exception );
	
	/**
	 * 根据异常类型转换为开通异常
	 * @param faultCode 国际编码
	 * @param args 国际参数
	 * @param exception 异常类型
	 * @return
	 */
	public SFException getResource(String faultCode, Object[] args, java.lang.Exception exception);
	
	/**
	 * 根据异常国际编码转换为开通异常
	 * @param faultCode 异常国际编码
	 * @param args 异常编码参数
	 * @param originator 网元类型
	 * @param exception 异常类型
	 * @return
	 */
	public SFException getResource(String faultCode, Object[] args, String originator, java.lang.Exception exception);
	
	/**
	 * 根据异常类型转换为开通对外异常
	 * @param exception 异常类型
	 * @param args 参数
	 * @return
	 */
	public SFBsException getExtend( java.lang.Exception exception, Object[] args );
}
