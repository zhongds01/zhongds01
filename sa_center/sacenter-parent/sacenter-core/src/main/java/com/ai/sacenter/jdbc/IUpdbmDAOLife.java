package com.ai.sacenter.jdbc;

import java.rmi.RemoteException;

import com.ai.appframe2.bo.DataContainer;
import com.ai.appframe2.common.DataStructInterface;
import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.SFException;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * @author Administrator
 * 基于数据库服务框架接口类
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
	 * 获取操作批次号
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
     * 完成数据容器列表(数据单元为BO容器实例))数据保存
     * @param fromUpdbm 数据容器(数据单元为BO容器实例)
     * @throws RemoteException
     * @throws Exception
     */
    public void finish( java.util.List fromUpdbm ) throws RemoteException,Exception;
    
    /**
     * 完成数据容器数组(数据单元为HashMap容器实例))数据保存
     * @param fromUpdbm 数据容器(数据单元为HashMap容器实例)
     * @throws RemoteException
     * @throws Exception
     */
    public void finish( java.util.HashMap fromUpdbm[] ) throws RemoteException,Exception;
    
    /**
     * 完成数据容器集(KEY=表名,DATA=数据链表))数据存储
     * @param fromUpdbm 数据容器(KEY=表名,DATA=数据链表(数据单元为HashMap/HQSQLEntityBean))
     * @throws RemoteException
     * @throws Exception
     */
    public void finish( java.util.HashMap fromUpdbm ) throws RemoteException,Exception;
}
