package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.IPeriodGraphToken;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��Ԫ������ȼ�</p>
 * <p>Copyright: Copyright (c) 2011-10-17</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVUpdspmLife implements java.io.Serializable {
	private static final long serialVersionUID = -474388751590934376L;
	/*Ŀ����Ԫ*/
	private IPlatformTemplate.IUpffmOffer   PLATFORM;
	/*��ָ��*/
	private IPlatformTemplate.IUpffmDirective DIRECTIVE;
	/*��ָ��*/
	private IPlatformTemplate.IUpffmSubFlow CHILDREN = null;
	/*��ͨ����*/
	private IPlatformTemplate.IUpffmOperate OPERATE = null;
	/*ָ����*/
	private ISystemTemplate.IImplCapital JAVA = null;
	/*��ͨ����*/
	private java.util.List  BPMING = new java.util.ArrayList();
	/*�ⲿ��Ԫ��չ����*/
	private java.util.Map  GRAPHICS = new java.util.HashMap();
	/*��ʱ��������*/
	private IPeriodGraphToken TOKEN = new IPeriodGraphToken();
	/*��ָ��*/
	private IOVUpdspmLife PARENT = null;
	public IOVUpdspmLife() {
		super();
	}
	public IOVUpdspmLife(IOVUpdspmLife fromUpdfwm){
		PLATFORM  = fromUpdfwm.PLATFORM;
		DIRECTIVE = fromUpdfwm.DIRECTIVE;
		CHILDREN  = fromUpdfwm.CHILDREN;
		OPERATE   = fromUpdfwm.OPERATE;
		PARENT    = fromUpdfwm.PARENT;
		JAVA      = fromUpdfwm.JAVA;
		GRAPHICS.putAll( fromUpdfwm.GRAPHICS );
		TOKEN._wrap( fromUpdfwm.TOKEN );
	}
	
	/**
	 * @return the cHILDREN
	 */
	public IPlatformTemplate.IUpffmSubFlow getCHILDREN() {
		return CHILDREN;
	}
	/**
	 * @param children the cHILDREN to set
	 */
	public void setCHILDREN(IPlatformTemplate.IUpffmSubFlow children) {
		CHILDREN = children;
	}
	/**
	 * @return the dIRECTIVE
	 */
	public IPlatformTemplate.IUpffmDirective getDIRECTIVE() {
		return DIRECTIVE;
	}
	/**
	 * @param directive the dIRECTIVE to set
	 */
	public void setDIRECTIVE(IPlatformTemplate.IUpffmDirective directive) {
		DIRECTIVE = directive;
	}
	/**
	 * @return the jAVA
	 */
	public ISystemTemplate.IImplCapital getJAVA() {
		return JAVA;
	}
	/**
	 * @param java the jAVA to set
	 */
	public void setJAVA(ISystemTemplate.IImplCapital java) {
		JAVA = java;
	}
	/**
	 * @return the oPERATE
	 */
	public IPlatformTemplate.IUpffmOperate getOPERATE() {
		return OPERATE;
	}
	/**
	 * @param operate the oPERATE to set
	 */
	public void setOPERATE(IPlatformTemplate.IUpffmOperate operate) {
		OPERATE = operate;
	}
	/**
	 * @return the pARENT
	 */
	public IOVUpdspmLife getPARENT() {
		return PARENT;
	}
	/**
	 * @param parent the pARENT to set
	 */
	public void setPARENT(IOVUpdspmLife parent) {
		PARENT = parent;
	}
	/**
	 * @return the pLATFORM
	 */
	public IPlatformTemplate.IUpffmOffer getPLATFORM() {
		return PLATFORM;
	}
	/**
	 * @param platform the pLATFORM to set
	 */
	public void setPLATFORM(IPlatformTemplate.IUpffmOffer platform) {
		PLATFORM = platform;
	}
	
	/**
	 * @return the gRAPHICS
	 */
	public java.util.Map getGRAPHICS() {
		return GRAPHICS;
	}
	
	/**
	 * @return the tOKEN
	 */
	public IPeriodGraphToken getTOKEN() {
		return TOKEN;
	}
	/**
	 * @return the bPMING
	 */
	public java.util.List getBPMING() {
		return BPMING;
	}
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2016��3��7��</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class IOVUpdspmHome implements java.io.Serializable{
		private static final long serialVersionUID = -8543519566664186467L;
		public IOVUpdspmHome(){
			super();
		}
	}
}
