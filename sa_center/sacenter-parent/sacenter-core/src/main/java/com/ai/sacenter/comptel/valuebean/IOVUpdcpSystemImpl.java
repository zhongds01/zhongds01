package com.ai.sacenter.comptel.valuebean;

import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.valuebean.IProfessionalTemplate.IProductOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IUpfgsmOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015��10��13��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdcpSystemImpl implements IOVUpdcpOffer {
	protected long   _compete ;
	protected long   _product ;
	protected String _comptel ;
	protected IUpfgsmOffer  _catalog;
	protected IProductOffer _provider;
	protected java.util.Map _complex = new java.util.HashMap();
	public IOVUpdcpSystemImpl() {
		super();
	}
	
	public IOVUpdcpSystemImpl( long fromCOMPETE, 
			long fromPRODUCT,
			IUpfgsmOffer fromCATALOG,
			IProductOffer fromPROVIDER){
		super();
		_compete  = fromCOMPETE ;
		_product  = fromPRODUCT ;
		_catalog  = fromCATALOG ;
		_provider = fromPROVIDER;
	}
	
	/**
	 * @return �����������
	 */
	public long getCOMPETE() {
		return _compete;
	}
	
	/**
	 * @param cOMPETE �����������
	 */
	public void setCOMPETE(long cOMPETE) {
		_compete = cOMPETE;
	}
	
	/**
	 * @return �����Ʒ���
	 */
	public long getPRODUCT() {
		return _product;
	}
	
	/**
	 * @param pRODUCT �����Ʒ���
	 */
	public void setPRODUCT(long pRODUCT) {
		_product = pRODUCT;
	}
	
	/**
	 * @return ��������ֵ
	 */
	public String getCOMPTEL() {
		return _comptel;
	}
	
	/**
	 * @param cOMPTEL ��������ֵ
	 */
	public void setCOMPTEL(String cOMPTEL) {
		_comptel = cOMPTEL;
	}
	
	/**
	 * �������̱���
	 */
	public String getSUBFLOW() {
		return null;
	}

	/**
	 * @return ����ӳ��淶
	 */
	public IUpfgsmOffer getCATALOG() {
		return _catalog;
	}
	
	/**
	 * @param cATALOG ����ӳ��淶
	 */
	public void setCATALOG(IUpfgsmOffer cATALOG) {
		_catalog = cATALOG;
	}
	
	/**
	 * @return �����Ʒ
	 */
	public IProductOffer getPROVIDER() {
		return _provider;
	}

	/**
	 * @param pROVIDER �����Ʒ
	 */
	public void setPROVIDER(IProductOffer pROVIDER) {
		_provider = pROVIDER;
	}

	/**
	 * @return ������������
	 */
	public java.util.Map getCOMPLEX() {
		return _complex;
	}
}
