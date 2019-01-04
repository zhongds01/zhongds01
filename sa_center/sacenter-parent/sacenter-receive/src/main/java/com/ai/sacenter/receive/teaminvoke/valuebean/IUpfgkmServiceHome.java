package com.ai.sacenter.receive.teaminvoke.valuebean;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017��5��2��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IUpfgkmServiceHome implements java.io.Serializable{
	private static final long serialVersionUID = 4806023643758366505L;
	/*������*/
	private long SERVICE_ID ;
	/*��Ʒ���*/
	private long PRODUCT_ID ;
	/*��Ʒ����*/
	private IUpfgkmRelatHome _offer = null;
	public IUpfgkmServiceHome( long pRODUCT_ID ) {
		super();
		PRODUCT_ID = pRODUCT_ID;
	}
	
	/**
	 * @return ������
	 */
	public long getSERVICE_ID() {
		return SERVICE_ID;
	}

	/**
	 * @param sERVICE_ID ������
	 */
	public void setSERVICE_ID(long sERVICE_ID) {
		SERVICE_ID = sERVICE_ID;
	}

	/**
	 * @param pRODUCT_ID ��Ʒ���
	 */
	public void setPRODUCT_ID(long pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	/**
	 * @return ��Ʒ���
	 */
	public long getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	/**
	 * @return ��Ʒ����
	 */
	public IUpfgkmRelatHome getOFFER() {
		return _offer;
	}

	/**
	 * @param offer ��Ʒ����
	 */
	public void setOFFER(IUpfgkmRelatHome offer) {
		_offer = offer;
	}
}
