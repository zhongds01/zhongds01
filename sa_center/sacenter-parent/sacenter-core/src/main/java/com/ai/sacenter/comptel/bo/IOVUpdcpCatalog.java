package com.ai.sacenter.comptel.bo;

import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ��������������</p>
 * <p>Copyright: Copyright (c) 2015��10��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IOVUpdcpCatalog {
	/**
	 * ������������
	 * @return
	 */
	public String getMODULE();
	/**
	 * ���������淶 
	 * @return
	 */
	public IProductOffer  getCOMPETE();
	/**
	 * ȫ�ַ�������
	 * @return
	 */
	public java.util.Map  getCOMPLEX();
	/**
	 * ������������
	 * @return
	 */
	public java.util.List getCATALOG();
	/**
	 * ������������
	 * @return
	 */
	public IOVUpdcpOffer[] getCOMPETENCE();
}
