package com.ai.sacenter.core.service.interfaces;

import java.rmi.RemoteException;

import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: ���񼤻���ķ���</p>
 * <p>Copyright: Copyright (c) 2015��11��5��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public interface IUpdcSV {
	/**
	 * ��ȡ��ǰ���Ĳ�����ˮ��
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getORDER_ID() throws RemoteException,Exception;
	
	/**
	 * ���񹤵��־û�������ͨ��[��������]
	 * @param fromUpdfmx �����첽��
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void orderComplteAsyn( IOVUpdfmxOffer fromUpdfmx ) throws RemoteException,Exception;
}
