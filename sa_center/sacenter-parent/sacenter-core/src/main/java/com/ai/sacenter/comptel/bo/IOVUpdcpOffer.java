package com.ai.sacenter.comptel.bo;

import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������������</p>
 * <p>Copyright: Copyright (c) 2015��10��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IOVUpdcpOffer {
	/**
	 * @return �����������
	 */
	public long getCOMPETE();
	
	/**
	 * @param cOMPETE �����������
	 */
	public void setCOMPETE(long cOMPETE);
	
	/**
	 * @return �����Ʒ���
	 */
	public long getPRODUCT();
	
	/**
	 * @param pRODUCT �����Ʒ���
	 */
	public void setPRODUCT(long pRODUCT);
	
	/**
	 * @return ��������ֵ
	 */
	public String getCOMPTEL();
	
	/**
	 * @param cOMPTEL ��������ֵ
	 */
	public void setCOMPTEL(String cOMPTEL);
	
	/**
	 * �������̱���
	 * @return
	 */
	public String getSUBFLOW();
	
	/**
	 * @return ����ӳ��淶
	 */
	public IUpfgsmOffer getCATALOG();
	
	/**
	 * @param cATALOG ����ӳ��淶
	 */
	public void setCATALOG(IUpfgsmOffer cATALOG);
	
	/**
	 * @return �����Ʒ
	 */
	public IProductOffer getPROVIDER();
	
	/**
	 * 
	 * @param pROVIDER �����Ʒ
	 */
	public void setPROVIDER( IProductOffer pROVIDER );
	
	/**
	 * @return ������������
	 */
	public java.util.Map getCOMPLEX();
}
