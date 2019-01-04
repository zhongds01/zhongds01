package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.IPeriodGraphToken;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ������ȿ�����</p>
 * <p>Copyright: Copyright (c) 2015-1-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdbmtcLife implements java.io.Serializable{
	private static final long serialVersionUID = 4667573945034922065L;
	/*������*/
	private UUID ID = null;
	/*��ű��*/
	private long INDEX = 0;
	/*��������*/
	private ISystemTemplate.IStaticOffer _account = null;
	/*���ƻ���*/
	private IPeriodGraphToken _token = new IPeriodGraphToken();
	public IOVUpdbmtcLife(){
		super();
		ID = UUID.getUUID();
	}
	
	public IOVUpdbmtcLife( ISystemTemplate.IStaticOffer account, long aINDEX ){
		super();
		ID = UUID.getUUID();
		_account = account;
		INDEX = aINDEX;
	}
	
	public IOVUpdbmtcLife( ISystemTemplate.IStaticOffer account ){
		super();
		_account = account;
	}
	
	public IOVUpdbmtcLife( long aINDEX ){
		super();
		ID = UUID.getUUID();
		INDEX = aINDEX;
	}
	
	/**
	 * @return ��������
	 */
	public ISystemTemplate.IStaticOffer getACCOUNT() {
		return _account;
	}
	
	/**
	 * @param account ��������
	 */
	public void setACCOUNT(ISystemTemplate.IStaticOffer account) {
		_account = account;
	}
	
	/**
	 * @return ���ƻ���
	 */
	public IPeriodGraphToken getTOKEN() {
		return _token;
	}
	
	/**
	 * @param token ���ƻ���
	 */
	public void setTOKEN(IPeriodGraphToken token) {
		_token = token;
	}
	
	/**
	 * @return ��ű��
	 */
	public long getINDEX() {
		return INDEX;
	}
	
	/**
	 * @param ��ű��
	 */
	public void setINDEX(long index) {
		INDEX = index;
	}
	
	/**
	 * @return ������
	 */
	public UUID getID() {
		return ID;
	}
	
	/**
	 * ��������Ϊ����������
	 * @return
	 */
	public boolean isWHITELST(){
		return _account != null && StringUtils.equals( _account.getVALUE(), 
				IUpdcConst.IUpfwm.IUpfms.WHITELST );
	}
	
	/**
	 * ��������Ϊ����������
	 * @return
	 */
	public boolean isBLACKLST(){
		return _account != null && StringUtils.equals( _account.getVALUE(), 
				IUpdcConst.IUpfwm.IUpfms.BLACKLST );
	}
	
}
