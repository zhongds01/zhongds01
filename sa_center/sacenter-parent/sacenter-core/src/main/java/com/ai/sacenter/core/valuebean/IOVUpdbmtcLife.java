package com.ai.sacenter.core.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.util.IPeriodGraphToken;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UUID;
import com.ai.sacenter.valuebean.ISystemTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务调度控制类</p>
 * <p>Copyright: Copyright (c) 2015-1-22</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdbmtcLife implements java.io.Serializable{
	private static final long serialVersionUID = 4667573945034922065L;
	/*事务编号*/
	private UUID ID = null;
	/*序号编号*/
	private long INDEX = 0;
	/*名单控制*/
	private ISystemTemplate.IStaticOffer _account = null;
	/*控制缓存*/
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
	 * @return 名单控制
	 */
	public ISystemTemplate.IStaticOffer getACCOUNT() {
		return _account;
	}
	
	/**
	 * @param account 名单控制
	 */
	public void setACCOUNT(ISystemTemplate.IStaticOffer account) {
		_account = account;
	}
	
	/**
	 * @return 控制缓存
	 */
	public IPeriodGraphToken getTOKEN() {
		return _token;
	}
	
	/**
	 * @param token 控制缓存
	 */
	public void setTOKEN(IPeriodGraphToken token) {
		_token = token;
	}
	
	/**
	 * @return 序号编号
	 */
	public long getINDEX() {
		return INDEX;
	}
	
	/**
	 * @param 序号编号
	 */
	public void setINDEX(long index) {
		INDEX = index;
	}
	
	/**
	 * @return 事务编号
	 */
	public UUID getID() {
		return ID;
	}
	
	/**
	 * 名单控制为白名单控制
	 * @return
	 */
	public boolean isWHITELST(){
		return _account != null && StringUtils.equals( _account.getVALUE(), 
				IUpdcConst.IUpfwm.IUpfms.WHITELST );
	}
	
	/**
	 * 名单控制为黑名单控制
	 * @return
	 */
	public boolean isBLACKLST(){
		return _account != null && StringUtils.equals( _account.getVALUE(), 
				IUpdcConst.IUpfwm.IUpfms.BLACKLST );
	}
	
}
