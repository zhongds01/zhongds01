package com.ai.sacenter.core.dao.impl;

import java.rmi.RemoteException;

import com.ai.appframe2.common.DataStructInterface;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.SFException;
import com.ai.sacenter.core.bo.ISAOffer;
import com.ai.sacenter.core.bo.ISAOrder;
import com.ai.sacenter.core.bo.ISATask;
import com.ai.sacenter.core.bo.SAOffer;
import com.ai.sacenter.core.bo.SAOfferFail;
import com.ai.sacenter.core.bo.SAOfferHis;
import com.ai.sacenter.core.bo.SAOrder;
import com.ai.sacenter.core.bo.SAOrderFail;
import com.ai.sacenter.core.bo.SAOrderHis;
import com.ai.sacenter.core.bo.SAQueue;
import com.ai.sacenter.core.bo.SATask;
import com.ai.sacenter.core.bo.SATaskFail;
import com.ai.sacenter.core.bo.SATaskHis;
import com.ai.sacenter.core.dao.interfaces.IUpdcDAO;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.jdbc.impl.ISystemDAOImpl;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.util.ArrayUQCList;
import com.ai.sacenter.util.ArrayUQList;
import com.ai.sacenter.util.CenterUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.valuebean.IOVUpdfmxOffer;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011-10-13</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class UpdcDAOImpl extends ISystemDAOImpl implements IUpdcDAO {

	public UpdcDAOImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getORDER_ID()
	 */
	public long getORDER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( SAOrder.S_TYPE.getMapingEnty() ).longValue();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getPLQK_ID()
	 */
	public long getPLQK_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( SAOrder.S_TYPE.getMapingEnty() ).longValue();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getOFFER_ID()
	 */
	public long getOFFER_ID() throws RemoteException, Exception {
		return super.getSEQUENCE( SAOffer.S_TYPE.getMapingEnty() ).longValue();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFOrder(java.lang.String)
	 */
	public IOVOrderPentium[] getSFOrder(String aVM_ORDER_ID) throws RemoteException, Exception {
		java.util.List fromORDER = new java.util.ArrayList();
		java.util.Map fromPARAM = new java.util.HashMap();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append( " DONE_CODE = :p_DONE_CODE " );
			fromPARAM.put( "p_DONE_CODE", aVM_ORDER_ID );
			fromPARAM.put( "REGION_ID"  , CenterUtils.ICustom.getRegionId() );
			/*1.查询服务定单在途表*/
			IOVOrderPentium fromOrder[] = UpdcUtils.getSFOrder( SAOrder.S_TYPE , fromSQL.toString() , fromPARAM );
			if( fromOrder != null && fromOrder.length > 0 ){ ClassUtils.IMerge.merge( fromOrder , fromORDER ); }
			/*2.查询服务定单失败表*/
			fromOrder = UpdcUtils.getSFOrder( SAOrderFail.S_TYPE , fromSQL.toString() , fromPARAM );
			if( fromOrder != null && fromOrder.length > 0 ){ ClassUtils.IMerge.merge( fromOrder , fromORDER ); }
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return (IOVOrderPentium[])fromORDER.toArray( new IOVOrderPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFOrder(java.lang.String, long, java.lang.String)
	 */
	public IOVOrderPentium getSFOrder(String aORDER_ID, long aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		IOVOrderPentium fromOrder[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append( " DONE_CODE = :p_DONE_CODE and USER_ID = :p_USER_ID " );
			fromPARAM.put( "p_DONE_CODE", aORDER_ID );
			fromPARAM.put( "p_USER_ID"  , new Long( aUSER_ID ) );
			fromPARAM.put( "REGION_ID"  , aREGION_ID );
			/*1.查询服务定单在途表*/
			fromOrder = UpdcUtils.getSFOrder( SAOrder.S_TYPE , fromSQL.toString() , fromPARAM );
			if( fromOrder == null || fromOrder.length <=0 ){
				/*2.查询服务定单失败表*/
				fromOrder = UpdcUtils.getSFOrder( SAOrderFail.S_TYPE , fromSQL.toString() , fromPARAM );
			}
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromOrder != null && fromOrder.length > 0?fromOrder[fromOrder.length - 1]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFOrder(com.ai.sacenter.core.valuebean.IOVTaskPentium, long)
	 */
	public IOVOrderPentium getSFOrder(IOVTaskPentium fromTASK, long aORDER_ID) throws RemoteException, Exception {
		IOVOrderPentium fromOrder[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append( " ORDER_ID = :p_ORDER_ID " );
			fromPARAM.put( "p_ORDER_ID", new Long( aORDER_ID ) );
			fromPARAM.put( "REGION_ID", CenterUtils.ICustom.getRegionIdByOrderId( aORDER_ID ) );
			if( fromTASK != null && fromTASK.isHUMAN() ){
				fromOrder = UpdcUtils.getSFOrder( SAOrderFail.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			else if( fromTASK != null && fromTASK.isHUMAN() == false ){
				fromOrder = UpdcUtils.getSFOrder( SAOrder.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			else{
				fromOrder = UpdcUtils.getSFOrder( SAOrder.S_TYPE, fromSQL.toString(), fromPARAM );
				if( fromOrder == null || fromOrder.length <= 0 ){
					fromOrder = UpdcUtils.getSFOrder( SAOrderFail.S_TYPE, fromSQL.toString(), fromPARAM );
				}
			}
		}
		finally{ 
			if( fromSQL != null ){ fromSQL = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromOrder != null && fromOrder.length > 0 ?fromOrder[0]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFMember(com.ai.sacenter.core.valuebean.IOVOrderPentium)
	 */
	public IOVOrderPentium[] getSFMember(IOVOrderPentium fromGroup) throws RemoteException, Exception {
		IOVOrderPentium fromChildren[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append( " GROUP_ORDER_ID = :p_GROUP_ORDER_ID " );
			fromPARAM.put( "p_GROUP_ORDER_ID", new Long( fromGroup.getORDER_ID() ) );
			fromPARAM.put( "REGION_ID", CenterUtils.ICustom.getRegionIdByOrderId( 
					fromGroup.getORDER_ID() ) );
			if( fromGroup != null && fromGroup.isHUMAN() ){
				fromChildren = UpdcUtils.getSFOrder( SAOrderFail.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			else if( fromGroup != null && fromGroup.isHUMAN() == false ){
				fromChildren = UpdcUtils.getSFOrder( SAOrder.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			else{
				fromChildren = UpdcUtils.getSFOrder( SAOrder.S_TYPE, fromSQL.toString(), fromPARAM );
				if( fromChildren == null || fromChildren.length <= 0 ){
					fromChildren = UpdcUtils.getSFOrder( SAOrderFail.S_TYPE, fromSQL.toString(), fromPARAM );
				}
			}
		}
		finally{
			if( fromSQL != null ){ fromSQL = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromChildren;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFOrder(com.ai.sacenter.core.valuebean.IOVTaskPentium[])
	 */
	public IOVOrderPentium[] getSFOrder(IOVTaskPentium[] fromTASK) throws RemoteException, Exception {
		IOVOrderPentium[] fromORDER = null;
		java.util.HashMap fromTABLE = new java.util.HashMap();
		java.util.Map fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append(" ORDER_ID IN ( ");
			for( int index = 0 ; index < fromTASK.length ; index++ ){
				if( fromTASK[index].getINSTANCE() == null ) continue;
				String aINDEX = ClassUtils.getINDEX( new String[]{ "p_ORDER_ID_" , 
						String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
				fromPARAM.put( aINDEX , new Long( fromTASK[index].getORDER_ID() ) );
				
				String aTYPE = SAOrder.S_TYPE.getFullName();
				if( fromTASK[index].isHUMAN() ) aTYPE = SAOrderFail.S_TYPE.getFullName();
				
				aINDEX = ClassUtils.getINDEX( new String[]{ aTYPE , "_$_", fromTASK[index].getREGION_ID() } );
				if( fromTABLE.containsKey(  aINDEX  ) == false ) fromTABLE.put( aINDEX , new java.util.ArrayList() );
				((java.util.List)fromTABLE.get( aINDEX ) ).add( fromTASK[index] );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) );
			fromSQL.append(" ) order by ORDER_ID ");
			if( fromPARAM != null && fromPARAM.size() > 0 ){
				fromORDER = UpdcUtils.getSFOrder(fromTABLE, fromSQL.toString(), fromPARAM);
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ) { fromPARAM.clear() ; fromPARAM = null;}
			if( fromTABLE != null ){ fromTABLE.clear(); fromTABLE = null;}
		}
		return fromORDER;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(long)
	 */
	public IOVTaskPentium getSFTask(long aTASK_ID) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append( " TASK_ID = :p_TASK_ID " );
			fromPARAM.put( "p_TASK_ID", new Long( aTASK_ID ) );
			fromPARAM.put( "REGION_ID", CenterUtils.ICustom.getRegionIdByOrderId( 
					aTASK_ID ) );
			fromTASK = UpdcUtils.getSFTask( SATask.S_TYPE , fromSQL.toString(), fromPARAM );
			if( fromTASK == null || fromTASK.length <= 0 ){ 
				fromTASK = UpdcUtils.getSFTask( SATaskFail.S_TYPE, fromSQL.toString(), fromPARAM );
			}
		}
		finally{ 
			if( fromSQL != null ){ fromSQL = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromTASK != null && fromTASK.length > 0 ?fromTASK[0]:null;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTaskFail(long[])
	 */
	public IOVTaskPentium[] getSFTaskFail(long[] aTASK_ID) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append(" TASK_ID IN ( ");
			for( int index = 0 ; index < aTASK_ID.length ; index++ ){
				String aINDEX = ClassUtils.getINDEX( new String[]{ "p_TASK_ID_", 
						String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
				fromPARAM.put( aINDEX , new Long( aTASK_ID[index] ) );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) );
			fromSQL.append(" ) order by TASK_ID ");
			fromTASK  = UpdcUtils.getSFTask( SATaskFail.S_TYPE, 
					fromSQL.toString(), fromPARAM );
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ) { fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(com.ai.sacenter.valuebean.QueueIDataO)
	 */
	public IOVTaskPentium getSFTask(IOVQueuePentium fromQueue) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append( " TASK_ID = :p_TASK_ID " );
			fromPARAM.put( "p_TASK_ID", new Long( fromQueue.getPLQK_ID() ) );
			fromPARAM.put( "REGION_ID", CenterUtils.ICustom.getRegionIdByOrderId( 
					fromQueue.getPLQK_ID() ) );
			if( fromQueue.isHUMAN() ){ 
				fromTASK = UpdcUtils.getSFTask( SATaskFail.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			else{
				fromTASK = UpdcUtils.getSFTask( SATask.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			if( fromTASK != null && fromTASK.length > 0 ){
				UpdcUtils.ICustom.transfer(fromTASK, new IOVQueuePentium[]{ fromQueue } );
			}
		}
		finally{ 
			if( fromSQL != null ){ fromSQL = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromTASK != null && fromTASK.length > 0 ?fromTASK[0]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(com.ai.sacenter.core.valuebean.IOVQueuePentium[])
	 */
	public IOVTaskPentium[] getSFTask(IOVQueuePentium[] fromQueue) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.HashMap fromTABLE = new java.util.HashMap();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		try
		{
			StringBuilder fromSQL = new StringBuilder(" TASK_ID in ( ");
			for( int index = 0 ; fromQueue != null && index < fromQueue.length; index++ ){
				String aINDEX = ClassUtils.getINDEX( new String[]{ "p_TASK_ID_", 
						String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
				fromPARAM.put( aINDEX , new Long( fromQueue[index].getPLQK_ID() ) );
				
				String aTYPE = SATask.S_TYPE.getFullName();
				if( fromQueue[index].isHUMAN() ) aTYPE = SATaskFail.S_TYPE.getFullName();
				
				aINDEX = ClassUtils.getINDEX( new String[]{aTYPE, "_$_", 
						CenterUtils.ICustom.getRegionIdByOrderId( 
								fromQueue[index].getPLQK_ID() )} );
				if( fromTABLE.containsKey(  aINDEX  ) == false ) fromTABLE.put( aINDEX , new java.util.ArrayList() );
				((java.util.List)fromTABLE.get( aINDEX ) ).add( fromQueue[index] );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
			      .append(" ) order by TASK_ID ");
			if( fromTABLE != null && fromTABLE.size() > 0 && 
					fromPARAM != null && fromPARAM.size() > 0 ){
				fromTASK = UpdcUtils.getSFTask(fromTABLE, fromSQL.toString(), fromPARAM);
				if( fromTASK != null && fromTASK.length > 0 ){
					UpdcUtils.ICustom.transfer( fromTASK, fromQueue );
				}
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
			if( fromTABLE != null ){ fromTABLE.clear(); fromTABLE = null;}
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder)
	 */
	public IOVTaskPentium getSFTask(IOVUpfwmOrder fromUpfwm) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.Map fromPARAM = new java.util.HashMap();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append( " TASK_ID = :p_TASK_ID " );
			fromPARAM.put( "p_TASK_ID", new Long( fromUpfwm.getTASK_ID() ) );
			fromPARAM.put( "REGION_ID", CenterUtils.ICustom.getRegionIdByOrderId( 
					fromUpfwm.getTASK_ID() ) );
			if( fromUpfwm.isHUMAN() ){ 
				fromTASK = UpdcUtils.getSFTask( SATaskFail.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			else{
				fromTASK = UpdcUtils.getSFTask( SATask.S_TYPE, fromSQL.toString(), fromPARAM );
			}
			if( fromTASK != null && fromTASK.length > 0 ){
				UpdcUtils.ICustom.transfer(fromTASK, new IOVUpfwmOrder[]{fromUpfwm});
			}
		}
		finally{ 
			if( fromSQL != null ){ fromSQL = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
		}
		return fromTASK != null && fromTASK.length > 0 ?fromTASK[0]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(com.ai.sacenter.provision.valuebean.IOVUpfwmOrder[])
	 */
	public IOVTaskPentium[] getSFTask(IOVUpfwmOrder[] fromUpfwm) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.HashMap fromUpdbm = new java.util.HashMap();
		java.util.HashMap fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		try
		{
			StringBuilder fromSQL = new StringBuilder(" TASK_ID in ( ");
			for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
				String aINDEX = ClassUtils.getINDEX( new String[]{ "p_TASK_ID_", 
						String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
				fromPARAM.put( aINDEX , new Long( fromUpfwm[index].getTASK_ID() ) );
				
				String aTYPE = SATask.S_TYPE.getFullName();
				if( fromUpfwm[index].isHUMAN() ) aTYPE = SATaskFail.S_TYPE.getFullName();
				
				aINDEX = ClassUtils.getINDEX( new String[]{aTYPE, "_$_", 
						CenterUtils.ICustom.getRegionIdByOrderId( 
								fromUpfwm[index].getTASK_ID() )} );
				if( fromUpdbm.containsKey(  aINDEX  ) == false ) fromUpdbm.put( aINDEX , new java.util.ArrayList() );
				((java.util.List)fromUpdbm.get( aINDEX ) ).add( fromUpfwm[index] );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) order by TASK_ID ");
			if( fromUpdbm != null && fromUpdbm.size() > 0 && 
					fromPARAM != null && fromPARAM.size() > 0 ){
				fromTASK = UpdcUtils.getSFTask(fromUpdbm, fromSQL.toString(), fromPARAM);
				if( fromTASK != null && fromTASK.length > 0 ){
					UpdcUtils.ICustom.transfer(fromTASK, fromUpfwm);
				}
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
			if( fromUpdbm != null ){ fromUpdbm.clear(); fromUpdbm = null;}
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium[])
	 */
	public IOVTaskPentium[] getSFTask(IOVOrderPentium fromOrder[]) throws RemoteException, Exception {
		IOVTaskPentium fromTASK[] = null;
		java.util.HashMap fromTABLE = new java.util.HashMap();
		java.util.Map  fromPARAM = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		try
		{
			StringBuilder fromSQL = new StringBuilder();
			fromSQL.append(" ORDER_ID IN ( ");
			for( int index = 0 ; index < fromOrder.length ; index++ ){
				if( fromOrder[index].getINSTANCE() == null ) continue;
				String aINDEX = ClassUtils.getINDEX( new String[]{ "p_ORDER_ID_" , 
						String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
				fromPARAM.put( aINDEX , new Long( fromOrder[index].getORDER_ID() ) );
				
				String aTYPE = SATask.S_TYPE.getFullName();
				if( fromOrder[index].isHUMAN() ) aTYPE = SATaskFail.S_TYPE.getFullName();
				
				aINDEX = ClassUtils.getINDEX( new String[]{aTYPE, "_$_", 
						fromOrder[index].getREGION_ID() } );
				if( fromTABLE.containsKey(  aINDEX  ) == false ) fromTABLE.put( aINDEX , new java.util.ArrayList() );
				((java.util.List)fromTABLE.get( aINDEX ) ).add( fromOrder[index] );
			}
			fromSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) order by TASK_ID ");
			if( fromPARAM != null && fromPARAM.size() > 0 ){
				fromTASK = UpdcUtils.getSFTask(fromTABLE, fromSQL.toString(), fromPARAM);
			}
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null;}
			if( fromNAME != null ) { fromNAME.clear() ; fromNAME = null;}
			if( fromTABLE != null ){ fromTABLE.clear(); fromTABLE = null;}
		}
		return fromTASK;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFTask(com.ai.sacenter.core.valuebean.IOVOrderPentium[], com.ai.sacenter.core.valuebean.IOVTaskPentium[])
	 */
	public IOVTaskPentium[] getSFTask(IOVOrderPentium[] fromOrder,
			IOVTaskPentium[] fromTASK) throws RemoteException, Exception {
		java.util.List fromUpdbm = new ArrayUQCList();
		try
		{
			IOVTaskPentium fromTask[] = getSFTask( fromOrder );
			if( fromTask != null && fromTask.length > 0 ){
				ClassUtils.IMerge.merge( fromTask , fromUpdbm );
			}
			if( fromTASK != null && fromTASK.length > 0 ){
				ClassUtils.IMerge.merge( fromTASK , fromUpdbm );
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromUpdbm.toArray( new IOVTaskPentium[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#getSFQueue(com.ai.sacenter.util.ArrayUQList)
	 */
	public ArrayUQList getSFQueue(ArrayUQList fromUpfwm) throws RemoteException, Exception {
		java.util.HashMap fromPARAM = new java.util.HashMap();	
		java.util.HashMap fromNAME = new java.util.HashMap();
		try
		{
			for( int index = 0 ; index < fromUpfwm.size(); index++ ){
				IOVQueuePentium fromQueue = (IOVQueuePentium)fromUpfwm.get( index );
				Long aUSER_ID = new Long( fromQueue.getUSER_ID() );
				if( StringUtils.equals( fromQueue.getSTATE() , IUpdcConst.IState.C ) == false ||
						fromNAME.containsKey( aUSER_ID ) ) continue;
				String aINDEX = ClassUtils.getINDEX( new String[]{ "p_USER_ID_", 
						String.valueOf( index ) } );
				fromPARAM.put( aINDEX , aUSER_ID );
				fromPARAM.put( SAQueue.S_Platform , fromQueue.getPLATFORM() );
				fromNAME.put( aUSER_ID , ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
			}
			if( fromNAME != null && fromNAME.size() > 0 ){
				StringBuilder fromSQL = new StringBuilder(" STATE = 'R' and USER_ID in (  ");
				fromSQL.append( StringUtils.join( fromNAME.values().iterator(), " , " ) )
				       .append(" ) order by USER_ID ");
				IOVQueuePentium fromQueue[] = UpdcUtils.getSFQueue(SAQueue.S_TYPE, fromSQL.toString(), fromPARAM);
				for( int index = 0 ; fromQueue != null && index < fromQueue.length; index++ ){
					if( fromUpfwm.indexOf( fromQueue[index] ) >= 0 ) continue;
					fromUpfwm.add( fromQueue[index] );
				}
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null;}
			if( fromPARAM != null ){ fromPARAM.clear() ; fromPARAM = null;}
		}
		return fromUpfwm;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.core.dao.interfaces.IUpdcDAO#finishSFOrder(com.ai.sacenter.core.valuebean.IOVOrderPentium[], com.ai.sacenter.core.valuebean.IOVTaskPentium[])
	 */
	public void finishSFOrder(IOVOrderPentium[] fromOrder, IOVTaskPentium[] fromTASK) throws RemoteException, Exception {
		try
		{
			class SFUpdbfxPtmtImpl{
				private IUpdbfxPtmtHome _order = new IUpdbfxPtmtHome();
				public SFUpdbfxPtmtImpl(){
					super();
				}
				/**
				 * 
				 * @param fromOrder
				 * @param fromTASK
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVTaskPentium[] transferAsGroup( IOVOrderPentium[] fromOrder, IOVTaskPentium[] fromTASK) throws SFException, Exception{
					try
					{
						UpdcUtils.ISystem.transfer( fromOrder, _order._order );
						fromTASK = getSFTask( fromOrder, fromTASK );
						for(int index = 0 ; index < fromTASK.length ; index++){
							Long aORDER_ID = new Long( fromTASK[index].getORDER_ID() );
							if( _order._order.containsKey( aORDER_ID ) == false ){
								_order._update.add( fromTASK[index] );
							}
						}
					}
					finally{
						
					}
					return fromTASK;
				}
				
				/**
				 * 
				 * @param _update
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				public void transferAsUpdate( java.util.List _update, IOVUpdfmxOffer fromUpdfmx) throws SFException,Exception{
					try
					{
						IOVOrderPentium fromOrder[] = (IOVOrderPentium[])ClassUtils.IClass.arrayDesign( _update, IOVOrderPentium.class );
				    	for( int index = 0 ; index < fromOrder.length ; index++ ){
				    		if( _order.isASTUpdate( fromOrder[index].getINSTANCE() ) == false ) continue;
				    		if( fromOrder[index].getINSTANCE() == null ){
				    			fromOrder[index].setINSTANCE( new SAOrder() );
				    			UpdcUtils.ICustom._wrap( fromOrder[index], fromOrder[index].getINSTANCE() );
				    		}
				    		fromOrder[index].setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
				    		fromUpdfmx.getORDER().getORDER().add( fromOrder[index].getINSTANCE() );
				    		_transferAsOfferUpdate( fromOrder[index], fromUpdfmx );
				    	}
				    	IOVTaskPentium fromTASK[] = (IOVTaskPentium[])ClassUtils.IClass.arrayDesign( _update, IOVTaskPentium.class );
				    	for( int index = 0 ; index < fromTASK.length ; index++ ){
				    		if( _order.isASTUpdate( fromTASK[index].getINSTANCE() ) == false ) continue;
				    		if( fromTASK[index].getINSTANCE() == null ){
				    			fromTASK[index].setINSTANCE( new SATask() );
				    			UpdcUtils.ICustom._wrap( fromTASK[index], fromTASK[index].getINSTANCE() );
				    		}
				    		fromTASK[index].setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
				    		fromUpdfmx.getORDER().getORDER().add( fromTASK[index].getINSTANCE() );
				    	}
			    	}
			    	finally{
			    		
			    	}
				}
				
				/**
				 *
				 * @param fromOrder
				 * @param fromTASK
				 * @param fromUpdfmx
				 * @throws SFException
		         * @throws Exception
		         */
				public void transferAsOrder( IOVOrderPentium fromOrder[], IOVTaskPentium fromTASK[], IOVUpdfmxOffer fromUpdfmx ) throws SFException,Exception{
					java.util.List fromHistory = new ArrayUQCList();
					java.util.List fromUpdate = new ArrayUQCList();
					java.util.List fromFail = new ArrayUQCList();
					try
					{
						for( int index = 0; index < fromOrder.length; index++ ){
							if( fromOrder[index].isOFFLINE() ) continue;
							if( fromOrder[index].isHISTORY() ){
								fromHistory.add( fromOrder[index] );
								UpdcUtils.ICustom.transferAsOrder( fromOrder[index], fromTASK, fromHistory );
							}
							else if( fromOrder[index].isFAILURE() ){
								fromFail.add( fromOrder[index] );
								UpdcUtils.ICustom.transferAsOrder( fromOrder[index], fromTASK, fromFail );
							}
							else{
								fromUpdate.add( fromOrder[index] );
								UpdcUtils.ICustom.transferAsOrder( fromOrder[index], fromTASK, fromUpdate );
							}
						}
						transferAsFailure( fromFail, fromUpdfmx );
						transferAsUpdate( fromUpdate, fromUpdfmx );
						transferAsHistory( fromHistory, fromUpdfmx );
					}
					finally{
						if( fromFail != null ){ fromFail.clear() ; fromFail = null;}
						if( fromUpdate != null ){ fromUpdate.clear() ; fromUpdate = null;}
						if( fromHistory != null ){ fromHistory.clear() ; fromHistory = null;}
					}
				}
				
				/**
				 * 
				 * @param _failure
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
			    private void transferAsFailure( java.util.List _failure, IOVUpdfmxOffer fromUpdfmx) throws SFException,Exception{
			    	try
			    	{
			    		IOVOrderPentium fromOrder[] = (IOVOrderPentium[])ClassUtils.IClass.arrayDesign( _failure, IOVOrderPentium.class );
				    	for( int index = 0 ; index < fromOrder.length ; index++ ){
				    		SAOrderFail fromFail = new SAOrderFail();
				    		fromOrder[index].setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
				    		UpdcUtils.ICustom._wrap( fromOrder[index], fromFail );
				    		if( fromOrder[index].getINSTANCE() != null ){
				    			fromOrder[index].getINSTANCE().setStsToOld();
				    			fromOrder[index].getINSTANCE().delete();
				    			fromUpdfmx.getORDER().getORDER().add( fromOrder[index].getINSTANCE() );
				    		}
				    		fromUpdfmx.getORDER().getORDER().add( fromFail );
				    		_transferAsOfferFail( fromOrder[index], fromUpdfmx );
				    	}
				    	IOVTaskPentium fromTask[] = (IOVTaskPentium[])ClassUtils.IClass.arrayDesign( _failure, IOVTaskPentium.class );
				    	for( int index = 0 ; index < fromTask.length ; index++ ){
				    		SATaskFail fromFail = new SATaskFail();
				    		fromTask[index].setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
				    		UpdcUtils.ICustom._wrap( fromTask[index] , fromFail );
				    		if( fromTask[index].getINSTANCE() != null ){
				    			fromTask[index].getINSTANCE().setStsToOld();
				    			fromTask[index].getINSTANCE().delete();
				    			fromUpdfmx.getORDER().getORDER().add( fromTask[index].getINSTANCE() );
				    		}
				    		fromUpdfmx.getORDER().getORDER().add( fromFail );
				    	}
			    	}
			    	finally{
			    		
			    	}
			    }
			    
			    /**
			     * 
			     * @param _history
			     * @param fromUpdfmx
			     * @throws RemoteException
			     * @throws Exception
			     */
			    private void transferAsHistory( java.util.List _history, IOVUpdfmxOffer fromUpdfmx) throws SFException,Exception{
			    	try
			    	{
			    		IOVOrderPentium fromOrder[] = (IOVOrderPentium[])ClassUtils.IClass.arrayDesign( _history, IOVOrderPentium.class );
				    	for( int index = 0 ; index < fromOrder.length ; index++ ){
				    		ISAOrder fromHistory = new SAOrderHis();
				    		fromOrder[index].setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
				    		UpdcUtils.ICustom._wrap( fromOrder[index], fromHistory );
				    		if( fromOrder[index].getINSTANCE() != null ){
				    			fromOrder[index].getINSTANCE().setStsToOld();
				    			fromOrder[index].getINSTANCE().delete();
				    			fromUpdfmx.getORDER().getORDER().add( fromOrder[index].getINSTANCE() );
				    		}
				    		fromUpdfmx.getORDER().getORDER().add( fromHistory );
				    		_transferAsOfferHistory( fromOrder[index], fromUpdfmx );
				    	}
				    	IOVTaskPentium fromTASK[] = (IOVTaskPentium[])ClassUtils.IClass.arrayDesign( _history, IOVTaskPentium.class );
				    	for( int index = 0 ; index < fromTASK.length ; index++ ){
				    		ISATask fromHistory = new SATaskHis();
				    		fromTASK[index].setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
				    		UpdcUtils.ICustom._wrap( fromTASK[index] , fromHistory );
				    		if( fromTASK[index].getINSTANCE() != null ){
				    			fromTASK[index].getINSTANCE().setStsToOld();
				    			fromTASK[index].getINSTANCE().delete();
				    			fromUpdfmx.getORDER().getORDER().add( fromTASK[index].getINSTANCE() );
				    		}
				    		fromUpdfmx.getORDER().getORDER().add( fromHistory );
				    	}
			    	}
			    	finally{
			    		
			    	}
			    }
			    
			    /**
				 * 
				 * @param fromOrder
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferAsOfferFail( IOVOrderPentium fromOrder, IOVUpdfmxOffer fromUpdfmx) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = fromOrder.getORDER().getOFFER().iterator(); itera.hasNext(); ){
			    			IOVOfferPentium fromUpdcpm = (IOVOfferPentium)itera.next();
			    			ISAOffer fromOffer = new SAOfferFail();
			    			UpdcUtils.ICustom._wrap( fromUpdcpm, fromOffer );
			    			fromOffer.setCompleteDate( fromUpdfmx.getORDER().getCOMPLETE() );
			    			if( fromUpdcpm.getINSTANCE() != null ){
			    				fromUpdcpm.getINSTANCE().setStsToOld();
			    				fromUpdcpm.getINSTANCE().delete();
			    				fromUpdfmx.getORDER().getORDER().add( fromUpdcpm.getINSTANCE() );
			    			}
			    			fromUpdfmx.getORDER().getORDER().add( fromOffer );
			    		}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferAsOfferHistory( IOVOrderPentium fromOrder, IOVUpdfmxOffer fromUpdfmx) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = fromOrder.getORDER().getOFFER().iterator(); itera.hasNext(); ){
			    			IOVOfferPentium fromUpdcpm = (IOVOfferPentium)itera.next();
			    			ISAOffer fromOffer = new SAOfferHis();
			    			UpdcUtils.ICustom._wrap( fromUpdcpm, fromOffer );
			    			fromOffer.setCompleteDate( fromUpdfmx.getORDER().getCOMPLETE() );
			    			if( fromUpdcpm.getINSTANCE() != null ){
			    				fromUpdcpm.getINSTANCE().setStsToOld();
			    				fromUpdcpm.getINSTANCE().delete();
			    				fromUpdfmx.getORDER().getORDER().add( fromUpdcpm.getINSTANCE() );
			    			}
			    			fromUpdfmx.getORDER().getORDER().add( fromOffer );
			    		}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromOrder
				 * @param fromUpdfmx
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferAsOfferUpdate( IOVOrderPentium fromOrder, IOVUpdfmxOffer fromUpdfmx) throws SFException,Exception{
					try
					{
						for( java.util.Iterator itera = fromOrder.getORDER().getOFFER().iterator(); itera.hasNext(); ){
			    			IOVOfferPentium fromUpdcpm = (IOVOfferPentium)itera.next();
			    			if( _order.isASTUpdate( fromUpdcpm.getINSTANCE() ) == false ) continue;
			    			if( fromUpdcpm.getINSTANCE() == null ){
	    		    			fromUpdcpm.setINSTANCE( new SAOffer() );
				    			UpdcUtils.ICustom._wrap( fromUpdcpm, fromUpdcpm.getINSTANCE() );
				    		}
	    		    		fromUpdcpm.setCOMPLETE_DATE( fromUpdfmx.getORDER().getCOMPLETE() );
	    		    		fromUpdfmx.getORDER().getORDER().add( fromUpdcpm.getINSTANCE() );
			    		}
					}
					finally{
						
					}
				}
				
				class IUpdbfxPtmtHome{
					private java.util.List _update = new java.util.ArrayList();
					private java.util.Map _order = new java.util.HashMap();
					public IUpdbfxPtmtHome(){
						super();
					}
					/***
					 * 判断是否已更新
					 * @param fromEntity
					 * @return
					 * @throws Exception
					 */
					public boolean isASTUpdate(DataStructInterface fromEntity) throws Exception {
						return fromEntity == null || ( fromEntity != null && (fromEntity.isNew() || 
								fromEntity.isDeleted() || fromEntity.isModified()));
					}
				}
			}
			SFUpdbfxPtmtImpl fromUpdbfxImpl = new SFUpdbfxPtmtImpl();
			IOVUpdfmxOffer fromUpdfmx = new IOVUpdfmxOffer();
			try
			{
				fromUpdfmx.getORDER().setCOMPLETE( new java.sql.Timestamp( System.currentTimeMillis() ) );
				SFUpdbfxPtmtImpl.IUpdbfxPtmtHome fromUpdbfxHome = fromUpdbfxImpl._order;
				fromTASK = fromUpdbfxImpl.transferAsGroup( fromOrder, fromTASK );
				if( fromOrder != null && fromOrder.length > 0 ){
					fromUpdbfxImpl.transferAsOrder( fromOrder, fromTASK, fromUpdfmx );
				}
				if( fromUpdbfxHome._update != null && fromUpdbfxHome._update.size() > 0 ){
					fromUpdbfxImpl.transferAsUpdate( fromUpdbfxHome._update, fromUpdfmx );
				}
				if( fromUpdfmx != null && fromUpdfmx.getORDER().getORDER().size() > 0 ){
					super.finish( fromUpdfmx );
				}
			}
			finally{
				if( fromUpdfmx != null ){ fromUpdfmx.getORDER().getORDER().clear(); fromUpdfmx = null; }
				if( fromUpdbfxImpl != null ){ fromUpdbfxImpl._order = null; fromUpdbfxImpl = null; }
			}
		}
		finally{
			
		}
	}

}
