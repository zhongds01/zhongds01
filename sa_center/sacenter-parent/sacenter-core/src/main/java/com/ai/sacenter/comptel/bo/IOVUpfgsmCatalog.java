package com.ai.sacenter.comptel.bo;

/**
 * 
 * <p>Title: ucmframe</p>
 * <p>Description: ������Ԫӳ�伯</p>
 * <p>Copyright: Copyright (c) 2015��11��6��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0
 */
public interface IOVUpfgsmCatalog {
	/***
	 * ӳ��淶����
	 * @return
	 */
	public String getMODULE();
	/**
	 * ӳ��淶ģ��
	 * @return
	 */
	public Object getOBJECTIVE();
	/***
	 * ӳ����
	 * @return 
	 */
	public java.util.Map getMAPPINGS();
}
