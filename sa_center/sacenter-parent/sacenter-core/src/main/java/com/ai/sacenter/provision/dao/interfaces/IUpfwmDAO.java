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
 * <p>Description: ��Ԫ����DAO</p>
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
	 * ������Ԫ������Ų�ѯ����Ԫ��������
	 * @param aPS_ID
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpfwmOrder getSFUpfwmOrder( long aPS_ID ) throws RemoteException,Exception;
	/**
	 * ������Ԫ������Ų�ѯ�쳣��;������Ϣ
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
	 * ����ͳһ��ͨ�����嵥��ѯ������ͨ��������
	 * @param fromASK
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpfwmOrder( IOVUpfwmCouple fromUpfwm[] ) throws RemoteException,Exception;
	/**
	 * ������Ԫ��������ѯ������Ԫ�����嵥
	 * @param fromUpfwm ��Ԫ������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.HashMap getSFUpfwmOrder( java.util.HashMap fromUpfwm[] ) throws RemoteException,Exception;
	/**
	 * ������Ԫ��ִ����ѯ������Ԫ�����嵥
	 * @param fromUpfmon ��Ԫ��ִ��
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
	 * ������Ԫ�����б����û���Ų�ѯ��Ԫͬ�鹤��
	 * @param fromUpfwm ��Ԫ�����б�
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public ArrayUQCList getSFUpfwmGroup( ArrayUQCList fromUpfwm ) throws RemoteException, Exception;
	/**
	 * ���ݵ�ǰ����ΪC��ѯ�Ѵ����������
	 * @param fromUpfwm
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public ArrayUQCList getSFUpfwmActive( ArrayUQCList fromUpfwm ) throws RemoteException, Exception;
	/**
	 * ������Ԫ����������ѯ��Ԫ���ڹ���
	 * @param fromUpffmx
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IUpfgkmCityHome getSFNotifyPassage( IUpfgkmCityHome fromUpffmx ) throws RemoteException, Exception;
	/**
	 * ������Ԫ����������ѯ��ת����Ԫ����
	 * @param fromUpfgkmHome ��Ԫ��������
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public IOVUpdfmxOffer getSFNotifyLimite( IUpfgkmCityHome fromUpfgkmHome ) throws RemoteException, Exception;
}
