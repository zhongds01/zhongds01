package com.ai.sacenter.jdbc;

import java.rmi.RemoteException;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * @author Administrator
 * �������ݿ�����ܽӿ���
 */
public interface IUpdbmDAOLife {
	/**
	 * 
	 * @param _table_name
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.math.BigDecimal getSEQUENCE( String _table_name ) throws RemoteException,Exception;
	
	/**
	 * 
	 * @param _table_name
	 * @param _region_id
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.math.BigDecimal getSEQUENCE( String _table_name, String _region_id ) throws RemoteException,Exception;
	
	/**
	 * ��ȡ�������κ�
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public long getDONE_CODE() throws RemoteException,Exception;
	
	/***
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.sql.Timestamp getSysdate() throws RemoteException,Exception;
	
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public int retrieveCount(ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM ) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @param fromCol
	 * @param startRowIndex
	 * @param endRowIndex
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public DataStructInterface[] retrieve ( ObjectType fromTYPE, String fromCond, java.util.HashMap fromPARAM, String fromCol[], int startRowIndex, int endRowIndex ) throws RemoteException,Exception;
	/**
	 * 
	 * @param fromTYPE
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public DataContainer[] retrieve(ObjectType fromTYPE, String fromCond, java.util.Map fromPARAM ) throws SFException,Exception;
	/**
	 * 
	 * @param _table_name
	 * @param fromCond
	 * @param fromPARAM
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve(String _table_name, String fromCond, java.util.Map fromPARAM) throws RemoteException, Exception;
	/**
	 * 
	 * @param _table_name
	 * @param _objecttype
	 * @param _condition
	 * @param fromPARAM
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	public java.util.ArrayList retrieve( String _table_name, ObjectType _objecttype, String _condition, java.util.Map fromPARAM) throws RemoteException, Exception;
	/**
	 * 
	 * @param fromUpdfmx
	 * @throws SFException
	 * @throws Exception
	 */
	public void finish( IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception;
	
	/**
	 * 
	 * @param fromEntity
	 * @throws RemoteException
	 * @throws Exception
	 */
	public void finish( DataStructInterface fromEntity[] ) throws RemoteException,Exception;
	
	/***
     * ������������б�(���ݵ�ԪΪBO����ʵ��))���ݱ���
     * @param fromUpdbm ��������(���ݵ�ԪΪBO����ʵ��)
     * @throws RemoteException
     * @throws Exception
     */
    public void finish( java.util.List fromUpdbm ) throws RemoteException,Exception;
    
    /**
     * ���������������(���ݵ�ԪΪHashMap����ʵ��))���ݱ���
     * @param fromUpdbm ��������(���ݵ�ԪΪHashMap����ʵ��)
     * @throws RemoteException
     * @throws Exception
     */
    public void finish( java.util.HashMap fromUpdbm[] ) throws RemoteException,Exception;
    
    /**
     * �������������(KEY=����,DATA=��������))���ݴ洢
     * @param fromUpdbm ��������(KEY=����,DATA=��������(���ݵ�ԪΪHashMap/HQSQLEntityBean))
     * @throws RemoteException
     * @throws Exception
     */
    public void finish( java.util.HashMap fromUpdbm ) throws RemoteException,Exception;
}
