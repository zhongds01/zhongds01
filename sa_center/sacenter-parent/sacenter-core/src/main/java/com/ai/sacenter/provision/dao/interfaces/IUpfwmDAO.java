package com.ai.sacenter.provision.dao.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.jdbc.IUpdbmDAOLife;
import com.ai.sacenter.provision.valuebean.IOVUpfwmComplete;
import com.ai.sacenter.provision.valuebean.IOVUpfwmCouple;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;
import com.ai.sacenter.valuebean.IUpfgkmCityHome;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 网元工单DAO</p>
 * <p>Copyright: Copyright (c) 2013-4-11</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public interface IUpfwmDAO extends IUpdbmDAOLife {
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getPS_ID() throws RemoteException,Exception;
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.math.BigDecimal getORDER_ID() throws RemoteException, Exception;
	/**
	 * 
	 * @param aREGION_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.math.BigDecimal getORDER_ID( String aREGION_ID ) throws RemoteException, Exception;
	/**
	 * 根据网元工单编号查询待网元反馈工单
	 * @param aPS_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmOrder getSFUpfwmOrder( long aPS_ID ) throws RemoteException,Exception;
	/**
	 * 根据网元工单编号查询异常在途工单信息
	 * @param aPLWK_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmOrder[] getSFUpfwmOrder( long aPLWK_ID[] ) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromPLWK
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getSFUpfwmOrder( java.util.ArrayList fromPLWK ) throws RemoteException,Exception;
	/**
	 * 根据统一开通反馈清单查询即开即通反馈工单
	 * @param fromASK
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpfwmOrder( IOVUpfwmCouple fromUpfwm[] ) throws RemoteException,Exception;
	/**
	 * 根据网元反馈单查询服务网元定单清单
	 * @param fromUpfwm 网元反馈单
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpfwmOrder( java.util.HashMap fromUpfwm[] ) throws RemoteException,Exception;
	/**
	 * 根据网元回执单查询服务网元定单清单
	 * @param fromUpfmon 网元回执单
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpfwmOrder( IOVUpfwmComplete[] fromUpfmon ) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromOffer
	 * @param fromUser
	 * @param fromBUFFER
	 * @param fromUpfwm
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList getSFUpfwmLimite( IOVUpfwmOffer fromOffer, java.util.Map fromUser, String fromBUFFER, java.util.List fromUpfwm) throws RemoteException, Exception;
	/**
	 * 根据网元工单列表中用户编号查询网元同组工单
	 * @param fromUpfwm 网元工单列表
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public ArrayUQCList getSFUpfwmGroup( ArrayUQCList fromUpfwm ) throws RemoteException, Exception;
	/**
	 * 根据当前队列为C查询已处理队列数据
	 * @param fromUpfwm
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public ArrayUQCList getSFUpfwmActive( ArrayUQCList fromUpfwm ) throws RemoteException, Exception;
	/**
	 * 根据网元批次索引查询网元到期工单
	 * @param fromUpffmx
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmCityHome getSFNotifyPassage( IUpfgkmCityHome fromUpffmx ) throws RemoteException, Exception;
	/**
	 * 根据网元批次索引查询待转移网元工单
	 * @param fromUpfgkmHome 网元批次索引
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpdfmxOffer getSFNotifyLimite( IUpfgkmCityHome fromUpfgkmHome ) throws RemoteException, Exception;
}
