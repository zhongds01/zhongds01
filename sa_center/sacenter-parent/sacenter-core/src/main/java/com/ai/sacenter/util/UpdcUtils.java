package com.ai.sacenter.util;

import com.ai.appframe2.common.ObjectType;
import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.ISystemResultHome;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.comptel.bo.IOVUpdcpCatalog;
import com.ai.sacenter.comptel.bo.IOVUpdcpOffer;
import com.ai.sacenter.core.UpdcFactory;
import com.ai.sacenter.core.bo.ISAOffer;
import com.ai.sacenter.core.bo.ISAOrder;
import com.ai.sacenter.core.bo.ISAQueue;
import com.ai.sacenter.core.bo.ISATask;
import com.ai.sacenter.core.bo.SAOffer;
import com.ai.sacenter.core.bo.SAOfferFail;
import com.ai.sacenter.core.bo.SAOfferHis;
import com.ai.sacenter.core.bo.SAOrder;
import com.ai.sacenter.core.bo.SAOrderFail;
import com.ai.sacenter.core.bo.SAOrderHis;
import com.ai.sacenter.core.bo.SAQueue;
import com.ai.sacenter.core.valuebean.IOVOfferPentium;
import com.ai.sacenter.core.valuebean.IOVOrderPentium;
import com.ai.sacenter.core.valuebean.IOVTaskPentium;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.core.valuebean.IOVQueuePentium;
import com.ai.sacenter.jdbc.HQSQLFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOrder;
import com.ai.sacenter.provision.valuebean.IOVUpfwmOffer;
import com.ai.sacenter.target.IUpdbsFactory;
import com.ai.sacenter.target.valuebean.IOVUpdbsComplete;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderRequest;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderResponse;
import com.ai.sacenter.teaminvoke.valuebean.IOVOrderUser;
import com.ai.sacenter.valuebean.IOVUpdspmLife;
import com.ai.sacenter.valuebean.IPlatformTemplate;
import com.ai.sacenter.valuebean.IProfessionalTemplate;
import com.ai.sacenter.valuebean.ISystemTemplate;
import com.ai.sacenter.valuebean.IOVUpdbpmOffice;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015年7月23日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class UpdcUtils {
	public UpdcUtils() {
		super();
	}
	/**
	 * 根据查询条件查询服务定单
	 * @param aTYPE 
	 * @param fromSQL
	 * @param pList
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVOrderPentium[] getSFOrder( ObjectType aTYPE,
			String fromSQL , 
			java.util.Map fromPARAM ) throws SFException,Exception{
		IOVOrderPentium fromOrder[] = null;
		try
		{
			java.util.List _orders = HQSQLFactory.getOracle().retrieve(aTYPE, fromSQL, fromPARAM);
			fromOrder = new IOVOrderPentium[ _orders != null? _orders.size():0 ];
			for( int index = 0 ; _orders != null && index < _orders.size() ; index++ ){
				fromOrder[index] = new IOVOrderPentium( (ISAOrder)_orders.get( index ) );
			}
			if( fromOrder != null && fromOrder.length > 0 ){
				getSFOffer(aTYPE, fromPARAM, fromOrder);
				for( int index = 0; fromOrder != null && index < fromOrder.length; index++ ){
					IPeriodGraphToken fromOfferHome = fromOrder[index].getORDER().getTOKEN();
					try
					{
						for( java.util.Iterator itera = fromOrder[index].getORDER().getOFFER().iterator(); itera.hasNext(); ){
							IOVOfferPentium fromOffer = (IOVOfferPentium)itera.next();
							if( StringUtils.isBlank( fromOffer.getSUBFLOW() ) == false ){
								ClassUtils.IMerge.merge( fromOfferHome.getDeque(), fromOffer.getORDER().getOFFER() );
							}
						}
					}
					finally{
						fromOfferHome.getDeque().clear();
					}
				}
			}
		}
		finally{
			
		}
		return fromOrder;
	}
	/**
	 * 完成服务定单订购属性转载
	 * @param aTYPE 服务定单类型
	 * @param fromPARAM 查询参数
	 * @param fromORDER
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVOrderPentium[] getSFOffer( ObjectType aTYPE, 
			java.util.Map fromPARAM,
			IOVOrderPentium fromORDER[] ) throws SFException,Exception{
		java.util.HashMap fromINDEX = new java.util.HashMap();
		java.util.Map  fromPARA  = new java.util.HashMap();
		java.util.List fromNAME = new java.util.ArrayList();
		try
		{
			for( int index = 0 ; fromORDER != null && index < fromORDER.length ; index++ ){
				Long aPLWK_ORDER = new Long( fromORDER[index].getORDER_ID() );
				String aINDEX = ClassUtils.getINDEX( new String[]{ "ORDER_ID_" , 
						String.valueOf( index ) } );
				fromNAME.add( ClassUtils.getINDEX( new String[]{":",aINDEX} ) );
				fromPARA.put( aINDEX , aPLWK_ORDER );
				fromINDEX.put( aPLWK_ORDER, fromORDER[index] );
			}
			ObjectType aOffer = ICustom.ICustomX.wrap( aTYPE );
			if( aOffer != null && fromORDER != null && fromORDER.length > 0 ){
				try
				{
					StringBuilder aSQL = new StringBuilder(" ORDER_ID IN ( ");
					aSQL.append( StringUtils.join( fromNAME.iterator(), " , " ) )
					    .append(" ) order by ORDER_ID , SORT_BY , OFFER_ID ");
					String fromSubCol[] = new String[]{ISAOrder.S_RegionId, ISAOrder.S_CompleteDate };
					for( int index = 0; index < fromSubCol.length; index++ ){
						if( fromPARAM.get( fromSubCol[index] ) == null ) continue;
						fromPARA.put( fromSubCol[index], fromPARAM.get( fromSubCol[index] ) );
					}
					java.util.List _offers = HQSQLFactory.getOracle().retrieve(aOffer, aSQL.toString(), fromPARA);
					for( int index = 0; _offers != null && index < _offers.size(); index++ ){
						ISAOffer aOFFER = (ISAOffer)_offers.get( index );
						Long aPLWK_ORDER = new Long( aOFFER.getOrderId() );
						IOVOrderPentium fromOrder = (IOVOrderPentium)fromINDEX.get( aPLWK_ORDER );
						if( fromOrder == null ) continue;
						IPeriodGraphToken fromTokenHome = fromOrder.getORDER().getTOKEN();
						IOVOfferPentium fromOffer = ICustom._wrap( aOFFER, new IOVOfferPentium() );
						if( StringUtils.isBlank( fromOffer.getSUBFLOW() ) ){
							ClassUtils.IMerge.merge( fromOffer.getORDER().getOFFER(), fromTokenHome.getDeque() );
						}
						fromOrder.getORDER().getOFFER().add( fromOffer );
					}
				}
				finally{
					
				}
			}
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromPARA != null ){ fromPARA.clear(); fromPARA = null; }
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
		}
		return fromORDER;
	}
	/**
	 * 根据查询条件查询服务定单
	 * @param fromTABLE
	 * @param fromSQL
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVOrderPentium[] getSFOrder( java.util.Map fromTABLE, 
			String fromSQL, 
			java.util.Map fromPARAM ) throws SFException,Exception{
		java.util.List fromList= new ArrayUQCList();
		try
		{
			for( java.util.Iterator itera = fromTABLE.keySet().iterator(); itera.hasNext(); ){
				String fromTable[] = StringUtils.wildcardArray( (String)itera.next(), "_$_" );
				ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromTable[0] );
				java.util.HashMap fromPARA = new java.util.HashMap( fromPARAM );
				try
				{
					fromPARA.put( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, fromTable[1] );
					IOVOrderPentium fromOrder[] = UpdcUtils.getSFOrder(fromTYPE, fromSQL, fromPARA);
					if( fromOrder != null && fromOrder.length > 0 ){
						ClassUtils.IMerge.merge( fromOrder, fromList );
					}
				}
				finally{
					if( fromPARA != null ){ fromPARA.clear(); fromPARA = null; }
				}
			}
		}
		finally{
			
		}
		return (IOVOrderPentium[])fromList.toArray( new IOVOrderPentium[]{} );
	}
	/**
	 * 根据查询条件查询服务任务
	 * @param fromTYPE
	 * @param fromSQL
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVTaskPentium[] getSFTask(ObjectType fromTYPE,
				String fromSQL , 
				java.util.Map fromPARAM ) throws SFException,Exception{
		IOVTaskPentium fromTASK[] = null;
		try
		{
			java.util.List _tasks = HQSQLFactory.getOracle().retrieve( fromTYPE, fromSQL, fromPARAM);
			fromTASK = new IOVTaskPentium[ _tasks != null?_tasks.size():0 ];
			for( int index = 0 ; _tasks != null && index < _tasks.size() ; index++ ){
				fromTASK[index] = new IOVTaskPentium( (ISATask)_tasks.get( index ) );
			}
		}
		finally{
			
		}
		return fromTASK;
	}
	/**
	 * 根据查询条件查询服务任务
	 * @param fromTABLE
	 * @param fromSQL
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVTaskPentium[] getSFTask( java.util.Map fromTABLE, 
			String fromSQL, 
			java.util.Map fromPARAM ) throws SFException,Exception{
		java.util.List fromList= new ArrayUQCList();
		try
		{
			for( java.util.Iterator itera = fromTABLE.keySet().iterator(); itera.hasNext(); ){
				String fromTable[] = StringUtils.wildcardArray( (String)itera.next(), "_$_" );
				ObjectType fromTYPE = ClassUtils.IClass.getASTBOType( fromTable[0] );
				java.util.HashMap fromPARA = new java.util.HashMap( fromPARAM );
				try
				{
					fromPARA.put( IUpdcConst.IUpdbm.IUpdmc.REGION_ID, fromTable[1] );
					IOVTaskPentium fromTASK[] = UpdcUtils.getSFTask(fromTYPE, fromSQL, fromPARA);
					if( fromTASK != null && fromTASK.length > 0 ){
						ClassUtils.IMerge.merge( fromTASK, fromList );
					}
				}
				finally{
					if( fromPARA != null ){ fromPARA.clear(); fromPARA = null; }
				}
			}
		}
		finally{
			
		}
		return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
	}
	/**
	 * 根据查询条件查询服务队列
	 * @param fromTYPE
	 * @param fromSQL
	 * @param fromPARAM
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVQueuePentium[] getSFQueue(ObjectType fromTYPE,
				String fromSQL , 
				java.util.Map fromPARAM ) throws SFException,Exception{
		IOVQueuePentium fromQueue[] = null;
		try
		{
			java.util.List _queues = HQSQLFactory.getOracle().retrieve( SAQueue.S_TYPE, fromSQL, fromPARAM );
			fromQueue = new IOVQueuePentium[ _queues != null && _queues.size() > 0?_queues.size():0];
			for( int index = 0; _queues != null && index < _queues.size(); index++ ){
				fromQueue[index] = new IOVQueuePentium( (ISAQueue)_queues.get( index ) );
			}
		}
		finally{
			
		}
		return fromQueue;
	}
	
	/**
	 * 根据服务订购转换服务正常定单
	 * @param fromMBean
	 * @param fromOrder
	 * @param fromRequest
	 * @param fromUSER
	 * @param aCOMPETENCE
	 * @param aContext
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVOrderPentium wrap(MBeanDelegate fromMBean,
			IOVOrderPentium fromOrder,
			IOVOrderRequest fromRequest,
			IOVOrderUser fromUSER,
			IProfessionalTemplate.ICompetenceOffer aCOMPETENCE, 
			IUpdcContext aContext) throws SFException, Exception{
		try
		{
			fromOrder.setCUST_ORDER     ( fromRequest.getCUST_ORDER     () );
			fromOrder.setDONE_CODE      ( fromRequest.getDONE_CODE      () );
			fromOrder.setCATEGORY       ( IUpdcConst.IUpdbm.IUpdbf.NORMAL  );
			fromOrder.setCATALOG        ( fromRequest.getCATALOG        () );
			fromOrder.setBUSINESS       ( fromRequest.getBUSINESS       () );
			fromOrder.setUSER_ID        ( fromUSER.getUSER_ID           () );
			fromOrder.setBILL_ID        ( fromUSER.getBILL_ID           () );
			fromOrder.setSUB_BILL_ID    ( fromUSER.getSUB_BILL_ID       () );
			fromOrder.setCREATE_DATE    ( fromMBean.getCREATE           () );
			fromOrder.setREGION_ID      ( fromRequest.getREGION_ID      () );
			fromOrder.setREGION_CODE    ( fromUSER.getREGION_ID         () );
			fromOrder.setCOMPETENCE     ( aCOMPETENCE.getID             () );
			fromOrder.setUSER_REGION_ID ( fromUSER.getUSER_REGION_ID    () );
			fromOrder.setORDER_REGION_ID( fromRequest.getORDER_REGION_ID() );
			fromOrder.setPRIORITY       ( fromRequest.getPRIORITY       () );
			fromOrder.setCOMPOSITE      ( fromRequest.getCOMPOSITE      ()  );
			fromOrder.setORDER_DATE     ( fromRequest.getORDER_DATE     () );
			fromOrder.setSTAFF_ID       ( fromRequest.getSTAFF_ID       () );
			fromOrder.setORG_ID         ( fromRequest.getORG_ID         () );
			fromOrder.setCHANNEL        ( fromRequest.getCHANNEL        () );
			fromOrder.getORDER().setCOMPETENCE( aCOMPETENCE     );
			if( StringUtils.isBlank( fromMBean.getCHANNEL() ) ){
				fromMBean.setCHANNEL( fromRequest.getCHANNEL  () );
			}
			
		}
		finally{
			
		}
		return fromOrder;
	}
	/**
	 * 
	 * @param fromOrder
	 * @param fromUser
	 * @param fromChain
	 * @param fromUpdcpm
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public static IOVOfferPentium wrap( IOVOrderPentium fromOrder, 
			IOVOrderUser fromUser, 
			IOVUpdcpCatalog fromChain,
			IOVUpdcpOffer fromUpdcpm ) throws SFException, Exception{
		IOVOfferPentium fromOffer = null;
		try
		{
			fromOffer = new IOVOfferPentium();
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			fromOffer.setOFFER_ID   ( UpdcFactory.getIUpdcDAO().getOFFER_ID() );
			fromOffer.setORDER_ID   ( fromOrder.getORDER_ID                () );
			fromOffer.setUSER_ID    ( fromOrder.getUSER_ID                 () );
			fromOffer.setCREATE_DATE( fromMBean.getCREATE                  () );
			fromOffer.setREGION_ID  ( fromOrder.getREGION_ID               () );
			fromOffer.setCOMPETE_ID ( fromUpdcpm.getCOMPETE                () );
			fromOffer.setPRODUCT_ID ( fromUpdcpm.getPRODUCT                () );
			fromOffer.setSUBFLOW    ( fromUpdcpm.getSUBFLOW                () );
			fromOffer.setSORT_BY    ( fromUpdcpm.getCATALOG().getSORT_BY   () );
			fromOffer.setCOMPTEL    ( fromUpdcpm.getCOMPTEL                () );
			UpdcUtils.ICustom._wrap ( fromChain, fromUpdcpm, fromOffer        );
			fromOffer.setSTATE      ( IUpdcConst.IState.C                     );
		}
		finally{
			
		}
		return fromOffer;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015年7月28日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ICustom{
		public ICustom(){
			super();
		}
		/**
		 * 
		 * @param fromOrder
		 * @param fromGoal
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderPentium _wrap( IOVOrderPentium fromOrder, IOVOrderPentium fromGoal ) throws SFException,Exception{
			try
			{
				if( fromOrder.getINSTANCE() == null /*服务定单在途*/){
					ISAOrder aOrder = new SAOrder();
					ICustom._wrap( fromOrder, aOrder );
					ICustom._wrap( aOrder, fromGoal );
				}
				else if( fromOrder.getINSTANCE() instanceof SAOrder/*服务在途定单*/){
					ISAOrder aOrder = new SAOrder();
					ICustom._wrap( fromOrder , aOrder );
					ICustom._wrap( aOrder, fromGoal );
					fromGoal.setINSTANCE( aOrder );
				}
				else/*服务异常定单*/{
					ISAOrder aOrder = new SAOrderFail();
					ICustom._wrap( fromOrder , aOrder );
					ICustom._wrap( aOrder, fromGoal );
					fromGoal.setINSTANCE( aOrder );
				}
			}
			finally{
				
			}
			return fromGoal;
		}
		/**
		 * 
		 * @param fromOffer
		 * @param fromGoal
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOfferPentium _wrap( IOVOfferPentium fromOffer, IOVOfferPentium fromGoal ) throws SFException,Exception{
			try
			{
				if( fromOffer.getINSTANCE() == null /*服务定单在途*/){
					ISAOffer aOFFER = new SAOffer();
					ICustom._wrap( fromOffer, aOFFER );
					ICustom._wrap( aOFFER , fromGoal );
				}
				else if( fromOffer.getINSTANCE() instanceof SAOffer /*服务在途定单*/){
					ISAOffer aOFFER = new SAOffer();
					ICustom._wrap( fromOffer, aOFFER );
					ICustom._wrap( aOFFER , fromGoal );
					fromGoal.setINSTANCE( aOFFER );
				}
				else/*服务异常定单*/{
					ISAOffer aOFFER = new SAOfferFail();
					ICustom._wrap( fromOffer, aOFFER );
					ICustom._wrap( aOFFER , fromGoal );
					fromGoal.setINSTANCE( aOFFER );
				}
			}
			finally{
				
			}
			return fromGoal;
		}
		/**
		 * InstanceIDataO转换为ISAInstance
		 * @param fromOrder
		 * @param aORDER
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVOrderPentium fromOrder ,ISAOrder aORDER ) throws SFException,Exception{
			try
			{
				java.sql.Timestamp aCREATE_DATE = UpdcFactory.getIUpdcDAO().getSysdate();
				aORDER.setOrderId       ( fromOrder.getORDER_ID       () );                                                               
				aORDER.setCustOrder     ( fromOrder.getCUST_ORDER     () );                                                               
				aORDER.setDoneCode      ( fromOrder.getDONE_CODE      () );                                                               
				aORDER.setCategory      ( fromOrder.getCATEGORY       () );
				aORDER.setCatalog       ( fromOrder.getCATALOG        () );                                                               
				aORDER.setBusiness      ( fromOrder.getBUSINESS       () );                                                               
				aORDER.setUserId        ( fromOrder.getUSER_ID        () );                                                               
				aORDER.setBillId        ( fromOrder.getBILL_ID        () );                                                               
				aORDER.setSubBillId     ( fromOrder.getSUB_BILL_ID    () );                                                               
				aORDER.setCreateDate    ( fromOrder.getCREATE_DATE() != null?fromOrder.getCREATE_DATE():aCREATE_DATE );                                                               
				aORDER.setRegionId      ( fromOrder.getREGION_ID      () ); 
				aORDER.setRegionCode    ( fromOrder.getREGION_CODE    () );
				aORDER.setCompetence    ( fromOrder.getCOMPETENCE     () );                                                               
				if( fromOrder.getCREATE_ORDER_ID() > 0 ) aORDER.setCreateOrderId( fromOrder.getCREATE_ORDER_ID() );
				if( fromOrder.getCREATE_TASK_ID()  > 0 ) aORDER.setCreateTaskId ( fromOrder.getCREATE_TASK_ID()  );
				if( fromOrder.getGROUP_ORDER_ID()  > 0 ) aORDER.setGroupOrderId ( fromOrder.getGROUP_ORDER_ID()  );                                                             
				aORDER.setUserRegionId  ( fromOrder.getUSER_REGION_ID () );
				aORDER.setOrderRegionId ( fromOrder.getORDER_REGION_ID() );
				aORDER.setPriority      ( fromOrder.getPRIORITY       () );     
				aORDER.setComposite     ( fromOrder.getCOMPOSITE      () );
				aORDER.setOrderDate     ( fromOrder.getORDER_DATE     () );
				aORDER.setChannelId     ( fromOrder.getCHANNEL        () );                                                               
				aORDER.setFailLog       ( fromOrder.getFAIL_LOG       () );                                                               
				aORDER.setOrgId         ( fromOrder.getORG_ID         () );                                                               
				aORDER.setStaffId       ( fromOrder.getSTAFF_ID       () );                                                               
				aORDER.setCompleteDate  ( fromOrder.getCOMPLETE_DATE  () );                                                               
				aORDER.setState         ( fromOrder.getSTATE          () );
				aORDER.setStateDate     ( fromOrder.getSTATE_DATE() != null?fromOrder.getSTATE_DATE():aCREATE_DATE);
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromOffer
		 * @param aOFFER
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVOfferPentium fromOffer, ISAOffer aOFFER ) throws SFException,Exception{
			try
			{
				aOFFER.setOfferId      ( fromOffer.getOFFER_ID     () ); 
				aOFFER.setOrderId      ( fromOffer.getORDER_ID     () ); 
				aOFFER.setUserId       ( fromOffer.getUSER_ID      () ); 
				aOFFER.setCreateDate   ( fromOffer.getCREATE_DATE  () ); 
				aOFFER.setRegionId     ( fromOffer.getREGION_ID    () ); 
				aOFFER.setCompeteId    ( fromOffer.getCOMPETE_ID   () ); 
				aOFFER.setProductId    ( fromOffer.getPRODUCT_ID   () ); 
				aOFFER.setSubflow      ( fromOffer.getSUBFLOW      () ); 
				aOFFER.setSortBy       ( (int)fromOffer.getSORT_BY () ); 
				aOFFER.setComptel      ( fromOffer.getCOMPTEL      () ); 
				aOFFER.setParam01      ( fromOffer.getPARAM_01     () ); 
				aOFFER.setParam02      ( fromOffer.getPARAM_02     () ); 
				aOFFER.setParam03      ( fromOffer.getPARAM_03     () ); 
				aOFFER.setParam04      ( fromOffer.getPARAM_04     () ); 
				aOFFER.setParam05      ( fromOffer.getPARAM_05     () ); 
				aOFFER.setCompleteDate ( fromOffer.getCOMPLETE_DATE() ); 
				aOFFER.setState        ( fromOffer.getSTATE        () ); 
			}
			finally{
				
			}
		}
		/**
		 * ISAInstance转换为InstanceIDataO
		 * @param aORDER
		 * @param fromOrder
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( ISAOrder aORDER , IOVOrderPentium fromOrder ) throws SFException,Exception{
			try
			{
				fromOrder.setORDER_ID       ( aORDER.getOrderId        () );
				fromOrder.setCUST_ORDER     ( aORDER.getCustOrder      () );
				fromOrder.setDONE_CODE      ( aORDER.getDoneCode       () );
				fromOrder.setCATEGORY       ( aORDER.getCategory       () );
				fromOrder.setCATALOG        ( aORDER.getCatalog        () );
				fromOrder.setBUSINESS       ( aORDER.getBusiness       () );
				fromOrder.setUSER_ID        ( aORDER.getUserId         () );
				fromOrder.setBILL_ID        ( aORDER.getBillId         () );
				fromOrder.setSUB_BILL_ID    ( aORDER.getSubBillId      () );
				fromOrder.setCREATE_DATE    ( aORDER.getCreateDate     () );
				fromOrder.setREGION_ID      ( aORDER.getRegionId       () );
				fromOrder.setREGION_CODE    ( aORDER.getRegionCode     () );
				fromOrder.setCOMPETENCE     ( aORDER.getCompetence     () );
				fromOrder.setCREATE_ORDER_ID( aORDER.getCreateOrderId  () );
				fromOrder.setCREATE_TASK_ID ( aORDER.getCreateTaskId   () );
				fromOrder.setGROUP_ORDER_ID ( aORDER.getGroupOrderId   () );
				fromOrder.setUSER_REGION_ID ( aORDER.getUserRegionId   () );
				fromOrder.setORDER_REGION_ID( aORDER.getOrderRegionId  () );
				fromOrder.setPRIORITY       ( aORDER.getPriority       () );
				fromOrder.setCOMPOSITE      ( aORDER.getComposite      () );
				fromOrder.setORDER_DATE     ( aORDER.getOrderDate      () );
				fromOrder.setCHANNEL        ( aORDER.getChannelId      () );
				fromOrder.setFAIL_LOG       ( aORDER.getFailLog        () );
				fromOrder.setORG_ID         ( aORDER.getOrgId          () );
				fromOrder.setSTAFF_ID       ( aORDER.getStaffId        () );
				fromOrder.setCOMPLETE_DATE  ( aORDER.getCompleteDate   () );
				fromOrder.setSTATE          ( aORDER.getState          () );
				fromOrder.setSTATE_DATE     ( aORDER.getStateDate      () );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param fromOffer
		 * @param fromUpffmx
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap _wrap( IOVOfferPentium fromOffer, java.util.HashMap fromUpffmx ) throws SFException,Exception{
			try
			{
				IProfessionalTemplate.IProductOffer fromUpdcpm = null;
				fromUpdcpm = UpdcpUtils.ISystem.getCOMPETE( fromOffer.getCOMPETE_ID() );
				if( fromUpdcpm != null && StringUtils.isBlank( fromOffer.getCOMPTEL() ) == false ){ 
					fromUpffmx.put( fromUpdcpm.getCOMPETE(), fromOffer.getCOMPTEL() ); 
				}
				String fromPARAM[] = new String[]{ fromOffer.getPARAM_01(), fromOffer.getPARAM_02(),
						                           fromOffer.getPARAM_03(), fromOffer.getPARAM_04(),
						                           fromOffer.getPARAM_05() };
				for( int index = 0; fromPARAM != null && index < fromPARAM.length; index++ ){
					if( StringUtils.isBlank( fromPARAM[index] ) ) continue;
					JdomUtils.ICustom.wrap(fromPARAM[index], fromUpffmx );
				}
			}
			finally{
				
			}
			return fromUpffmx;
		}
		
		/**
		 * 
		 * @param fromChain
		 * @param fromUpdcpm
		 * @param fromOffer
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVUpdcpCatalog fromChain,
				IOVUpdcpOffer fromUpdcpm,
				IOVOfferPentium fromOffer )throws SFException,Exception{
			try
			{
				IOVOfferPentium.IOfferMBeanHome fromOfferHome = fromOffer.getORDER();
				IProfessionalTemplate.IProductOffer fromUpffx = fromUpdcpm.getPROVIDER();
				if( fromUpffx != null && StringUtils.isBlank( fromOffer.getCOMPTEL() ) == false ){ 
					fromOfferHome.getOFFER().put( fromUpffx.getCOMPETE(), fromOffer.getCOMPTEL() ); 
				}
				if( StringUtils.isBlank( fromOffer.getSUBFLOW() ) == false ){
					ClassUtils.IMerge.merge( fromChain.getCOMPLEX(), fromOfferHome.getOFFER() );
				}
				ClassUtils.IMerge.merge( fromUpdcpm.getCOMPLEX(), fromOfferHome.getOFFER() );
				String fromPARAM[] = SystemUtils.ICustom.substringAsL( fromUpdcpm.getCOMPLEX(), ";" );
				IBeanWrapper fromWrapper = new IBeanWrapper( fromOffer );
				for (int index = 0; index < 5; index++) {
					String fromFIELD = ClassUtils.getINDEX(new String[] { "PARAM_",
							index < 5 ? "0" : "", String.valueOf(index + 1) });
					if (index < fromPARAM.length) {
						fromWrapper.setPropertyValue( fromFIELD, fromPARAM[index] );
					} else {
						fromWrapper.setPropertyValue( fromFIELD, null );
					}
				}
			}
			finally{
				
			}
		} 

		/**
		 * 
		 * @param aOFFER
		 * @param fromOffer
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOfferPentium _wrap( ISAOffer aOFFER, 
				 IOVOfferPentium fromOffer ) throws SFException,Exception{
			try
			{
				fromOffer.setOFFER_ID     ( aOFFER.getOfferId     () ); 
				fromOffer.setORDER_ID     ( aOFFER.getOrderId     () ); 
				fromOffer.setUSER_ID      ( aOFFER.getUserId      () ); 
				fromOffer.setCREATE_DATE  ( aOFFER.getCreateDate  () ); 
				fromOffer.setREGION_ID    ( aOFFER.getRegionId    () ); 
				fromOffer.setCOMPETE_ID   ( aOFFER.getCompeteId   () ); 
				fromOffer.setPRODUCT_ID   ( aOFFER.getProductId   () ); 
				fromOffer.setSUBFLOW      ( aOFFER.getSubflow     () ); 
				fromOffer.setSORT_BY      ( aOFFER.getSortBy      () ); 
				fromOffer.setCOMPTEL      ( aOFFER.getComptel     () ); 
				fromOffer.setPARAM_01     ( aOFFER.getParam01     () ); 
				fromOffer.setPARAM_02     ( aOFFER.getParam02     () ); 
				fromOffer.setPARAM_03     ( aOFFER.getParam03     () ); 
				fromOffer.setPARAM_04     ( aOFFER.getParam04     () ); 
				fromOffer.setPARAM_05     ( aOFFER.getParam05     () ); 
				fromOffer.setCOMPLETE_DATE( aOFFER.getCompleteDate() ); 
				fromOffer.setSTATE        ( aOFFER.getState       () );
				fromOffer.setINSTANCE     ( aOFFER                   );
				ICustom._wrap( fromOffer, fromOffer.getORDER().getOFFER() );
			}
			finally{
				
			}
			return fromOffer;
		}
		/**
		 * TaskIDataO转换为ISATask
		 * @param fromTASK
		 * @param aTASK
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVTaskPentium fromTASK , ISATask aTASK ) throws SFException,Exception{
			try
			{
				java.sql.Timestamp aCREATE_DATE = UpdcFactory.getIUpdcDAO().getSysdate();
				aTASK.setTaskId        ( fromTASK.getTASK_ID        () );                                                                                                                                                               
				aTASK.setOrderId       ( fromTASK.getORDER_ID       () );                                                                                                                                                               
				aTASK.setOfferId       ( fromTASK.getOFFER_ID       () );
				aTASK.setUserId        ( fromTASK.getUSER_ID        () );                                                                                                                                                               
				aTASK.setRegionId      ( fromTASK.getREGION_ID      () );                                                                                                                                                               
				aTASK.setSubflow       ( fromTASK.getSUBFLOW        () );                                                                                                                                                               
				aTASK.setPlatform      ( fromTASK.getPLATFORM       () );                                                                                                                                                               
				aTASK.setDirective     ( fromTASK.getDIRECTIVE      () );                                                                                                                                                               
				aTASK.setPlwkCoding    ( fromTASK.getPLWK_CODING    () );                                                                                                                                                               
				aTASK.setPlwkCreate    ( fromTASK.getPLWK_CREATE    () );
				aTASK.setPlwkComplete  ( fromTASK.getPLWK_COMPLETE  () );
				aTASK.setPriority      ( (int)fromTASK.getPRIORITY  () );                                                                                                                                                               
				aTASK.setSortBy        ( (int)fromTASK.getSORT_BY   () );                                                                                                                                                               
				aTASK.setParam         (fromTASK.getPARAM() != null?fromTASK.getPARAM():"");
				if( fromTASK.getDEPEND_TASK_ID() > 0 ) aTASK.setDependTaskId(fromTASK.getDEPEND_TASK_ID());                                                                                                                                                               
				if( fromTASK.getCREATE_TASK_ID() > 0 ) aTASK.setCreateTaskId(fromTASK.getCREATE_TASK_ID());
				aTASK.setStationId     ( fromTASK.getSTATION_ID     () );
				aTASK.setRedoTimes     ( (int)fromTASK.getREDO_TIMES() );                                                                                                                                                               
				aTASK.setDoneTimes     ( (int)fromTASK.getDONE_TIMES() );                                                                                                                                                               
				aTASK.setDoneResult    ( fromTASK.getDONE_RESULT    () );                                                                                                                                                               
				if( fromTASK.getSTAFF_ID() != null ) aTASK.setStaffId( fromTASK.getSTAFF_ID () );                                                                                                                                                               
				if( fromTASK.getORG_ID() != null )   aTASK.setOrgId  ( fromTASK.getORG_ID   () );                                                                                                                                                               
				if( fromTASK.getFAIL_LOG() != null ) aTASK.setFailLog( fromTASK.getFAIL_LOG () );                                                                                                                                                               
				aTASK.setCreateDate    ( fromTASK.getCREATE_DATE() != null?fromTASK.getCREATE_DATE():aCREATE_DATE);                                                                                                                                                               
				aTASK.setCompleteDate  ( fromTASK.getCOMPLETE_DATE  () );                                                                                                                                                               
				aTASK.setState         (fromTASK.getSTATE           () );
				aTASK.setStateDate     (fromTASK.getSTATE_DATE() != null?fromTASK.getSTATE_DATE():aCREATE_DATE );  
			}
			finally{
				
			}
		}
		/**
		 * ISATask转换为TaskIDataO
		 * @param aTASK
		 * @param fromTASK
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( ISATask aTASK ,IOVTaskPentium fromTASK ) throws SFException,Exception{
			try
			{
				fromTASK.setTASK_ID       ( aTASK.getTaskId        () );                                                                                                                                                               
				fromTASK.setORDER_ID      ( aTASK.getOrderId       () );                                                                                                                                                               
				fromTASK.setOFFER_ID      ( aTASK.getOfferId       () );
				fromTASK.setUSER_ID       ( aTASK.getUserId        () );                                                                                                                                                               
				fromTASK.setREGION_ID     ( aTASK.getRegionId      () );                                                                                                                                                               
				fromTASK.setSUBFLOW       ( aTASK.getSubflow       () );                                                                                                                                                               
				fromTASK.setPLATFORM      ( aTASK.getPlatform      () );                                                                                                                                                               
				fromTASK.setDIRECTIVE     ( aTASK.getDirective     () );                                                                                                                                                               
				fromTASK.setPLWK_CODING   ( aTASK.getPlwkCoding    () );                                                                                                                                                               
				fromTASK.setPLWK_CREATE   ( aTASK.getPlwkCreate    () );
				fromTASK.setPLWK_COMPLETE ( aTASK.getPlwkComplete  () );
				fromTASK.setPRIORITY      ( aTASK.getPriority      () );                                                                                                                                                               
				fromTASK.setSORT_BY       ( aTASK.getSortBy        () );                                                                                                                                                               
				fromTASK.setPARAM         ( aTASK.getParam() != null?aTASK.getParam():"");                                                                                                                                                               
				fromTASK.setDEPEND_TASK_ID( aTASK.getDependTaskId  () );                                                                                                                                                               
				fromTASK.setCREATE_TASK_ID( aTASK.getCreateTaskId  () );   
				fromTASK.setSTATION_ID    ( aTASK.getStationId     () );
				fromTASK.setREDO_TIMES    ( aTASK.getRedoTimes     () );                                                                                                                                                               
				fromTASK.setDONE_TIMES    ( aTASK.getDoneTimes     () );                                                                                                                                                               
				fromTASK.setDONE_RESULT   ( aTASK.getDoneResult()!=null?aTASK.getDoneResult():"");                                                                                                                                                               
				fromTASK.setSTAFF_ID      ( aTASK.getStaffId       () );                                                                                                                                                               
				fromTASK.setORG_ID        ( aTASK.getOrgId         () );                                                                                                                                                               
				fromTASK.setFAIL_LOG      ( aTASK.getFailLog       () );                                                                                                                                                               
				fromTASK.setCREATE_DATE   ( aTASK.getCreateDate    () );                                                                                                                                                               
				fromTASK.setCOMPLETE_DATE ( aTASK.getCompleteDate  () );                                                                                                                                                               
				fromTASK.setSTATE         ( StringUtils.trimLeft( aTASK.getState() , 1 ));
				fromTASK.setSTATE_DATE    ( aTASK.getStateDate     () );  
				fromTASK.setINSTANCE      ( aTASK                     );
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromTASK
		 * @param fromOrder
		 * @param fromUpdbm
		 * @param fromUpfm
		 * @param fromUpfom
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVTaskPentium fromTASK , 
				IOVOrderPentium fromOrder , 
				ISystemTemplate.IUpdbpmOffer fromUpdbm,
				IPlatformTemplate.IUpffmOffer fromUpfm,
				IPlatformTemplate.IUpffmOperate fromUpfom ) throws SFException,Exception{
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromTASK.setTASK_ID    ( UpdcFactory.getIUpdcDAO().getORDER_ID() );
				fromTASK.setORDER_ID   ( fromOrder.getORDER_ID                () );
				fromTASK.setUSER_ID    ( fromOrder.getUSER_ID                 () );
				fromTASK.setREGION_ID  ( fromOrder.getREGION_ID               () );
				fromTASK.setSUBFLOW    ( Long.parseLong(fromUpdbm.getID       ()));
				fromTASK.setPLATFORM   ( fromUpfm.getID                       () );
				fromTASK.setDIRECTIVE  ( fromUpdbm.getDIRECTIVE               () );
				fromTASK.setPRIORITY   ( fromUpdbm.getPRIORITY                () );
				fromTASK.setSORT_BY    ( fromUpdbm.getSORT_BY                 () );
				fromTASK.setREDO_TIMES ( fromUpfom.getREDO_TIMES              () );
				fromTASK.setCREATE_DATE( fromMBean.getCREATE                  () );
				fromTASK.setSTATE      ( IUpdcConst.IState.C                     );
				fromTASK.getORDER().setSUBFLOW( fromUpdbm );
				fromTASK.getORDER().setCOMPLETE(fromUpdbm, fromUpfm);
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param fromTASK
		 * @param fromOrder
		 * @param fromUpdbm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( IOVTaskPentium fromTASK , 
				IOVOrderPentium fromOrder , 
				ISystemTemplate.IUpdbpmOffer fromUpdbm ) throws SFException,Exception{
			try
			{
				MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
				fromTASK.setORDER_ID   ( fromOrder.getORDER_ID   () );
				fromTASK.setUSER_ID    ( fromOrder.getUSER_ID    () );
				fromTASK.setREGION_ID  ( fromOrder.getREGION_ID  () );
				fromTASK.setSUBFLOW( Long.parseLong(fromUpdbm.getID()) );
				fromTASK.setPLATFORM   ( fromUpdbm.getPLATFORM   () );
				fromTASK.setDIRECTIVE  ( fromUpdbm.getDIRECTIVE  () );
				fromTASK.setPRIORITY   ( fromUpdbm.getPRIORITY   () );
				fromTASK.setSORT_BY    ( fromUpdbm.getSORT_BY    () );
				fromTASK.setREDO_TIMES ( fromUpdbm.getPRIORITY   () );
				fromTASK.setCREATE_DATE( fromMBean.getCREATE     () );
				fromTASK.setSTATE      ( IUpdcConst.IState.C        );
				fromTASK.getORDER().setSUBFLOW( fromUpdbm );
			}
			finally{
				
			}
		}
		/**
		 * 
		 * @param aQUEUE
		 * @param fromUpfwm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void _wrap( ISAQueue aQUEUE , IOVQueuePentium fromUpfwm ) throws SFException,Exception{
			try
			{
				fromUpfwm.setQUEUE_ID     ( aQUEUE.getQueueId     () );              
				fromUpfwm.setORDER_ID     ( aQUEUE.getOrderId     () );              
				fromUpfwm.setCATEGORY     ( aQUEUE.getCategory    () );              
				fromUpfwm.setPLQK_ID      ( aQUEUE.getPlqkId      () );              
				fromUpfwm.setUSER_ID      ( aQUEUE.getUserId      () );              
				fromUpfwm.setBILL_ID      ( aQUEUE.getBillId      () );              
				fromUpfwm.setCREATE_DATE  ( aQUEUE.getCreateDate  () );              
				fromUpfwm.setREGION_ID    ( aQUEUE.getRegionId    () );              
				fromUpfwm.setPLATFORM     ( aQUEUE.getPlatform    () );     
				fromUpfwm.setPROGRAM      ( aQUEUE.getProgram     () );
				fromUpfwm.setPRIORITY     ( aQUEUE.getPriority    () );              
				fromUpfwm.setPARAM        ( aQUEUE.getParam       () );              
				fromUpfwm.setPLWK_CODING  ( aQUEUE.getPlwkCoding  () );              
				fromUpfwm.setPLWK_DESCRIBE( aQUEUE.getPlwkDescribe() );              
				fromUpfwm.setPLWK_CREATE  ( aQUEUE.getPlwkCreate  () );
				fromUpfwm.setPLWK_COMPLETE( aQUEUE.getPlwkComplete() );
				fromUpfwm.setREDO_TIMES   ( aQUEUE.getRedoTimes   () );              
				fromUpfwm.setDONE_TIMES   ( aQUEUE.getDoneTimes   () );              
				fromUpfwm.setSRC_SYSTEM   ( aQUEUE.getSrcSystem   () );
				fromUpfwm.setORG_ID       ( aQUEUE.getOrgId       () );              
				fromUpfwm.setSTAFF_ID     ( aQUEUE.getStaffId     () );              
				fromUpfwm.setRESULT       ( aQUEUE.getResult      () );              
				fromUpfwm.setSTATE        ( aQUEUE.getState       () );
				fromUpfwm.setCOMPLETE_DATE( aQUEUE.getCompleteDate() );   
			}
			finally{
				
			}
		}
		
		/**
		 * 把CREATE和aDELETE属性存在到服务定单结果字段中
		 * @param fromOrder
		 * @param aCREATE
		 * @param aDELETE
		 */
		public static void _wrap( IOVOrderPentium fromOrder, 
				Object aCREATE[][], 
				String aDELETE[] ){
			java.util.Map fromASK = new java.util.HashMap();
			try
			{
				try
				{
					XmlUtils.XPath( fromOrder.getFAIL_LOG(), fromASK );
				}
				catch( java.lang.Exception eee){
					fromASK = new java.util.HashMap();
				}
				ClassUtils.IMerge.merge( aCREATE , fromASK , true );
				ClassUtils.IMerge.purge( fromASK , aDELETE );
				fromOrder.setFAIL_LOG( XmlUtils.createNoformatXml("ucmframe", fromASK ) );
			}
			catch( java.lang.Exception ee){
				
			}
			finally{
				if( fromASK != null ){ fromASK.clear(); fromASK = null;}
			}
		}
		/**
		 * 
		 * @param fromPentium
		 * @param fromOrder
		 * @param fromASK
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderResponse _wrap( IOVOrderRequest fromRequest,
				IOVOrderPentium fromOrder,
				IOVOrderResponse fromASK,
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				fromASK.setROCKET_ID ( fromRequest.getROCKET_ID () );
				fromASK.setCUST_ORDER( fromRequest.getCUST_ORDER() );
				fromASK.setCATALOG   ( fromRequest.getCATALOG   () );
				fromASK.setBUSINESS  ( fromRequest.getBUSINESS  () );
				fromASK.setORIGINATOR( fromRequest.getORIGINATOR() );
				fromASK.setCHANNEL   ( fromRequest.getCHANNEL   () );
				fromASK.setUSER_ID   ( fromRequest.getUSER_ID   () );
				fromASK.setBILL_ID   ( fromRequest.getBILL_ID   () );
				fromASK.setREGION_ID ( fromRequest.getREGION_ID () );
				fromASK.setDONE_CODE ( fromRequest.getDONE_CODE () );
				fromASK.setDONE_DATE ( fromRequest.getDONE_DATE () );
				SFException aEXCEPTION = ICustomX._jj_respond( fromOrder, aContext );
				fromASK.getRESULT().setRspCode( aEXCEPTION.getFaultCode       () );
				fromASK.getRESULT().setRspHome( IUpdcConst.IUpfwm.IUpfm.ucmframe );
				fromASK.getRESULT().setRspDesc( aEXCEPTION.getMessage         () );
				IOVOrderPentium fromORDER = UpdcUtils.ISystem.getCTKSFOrder( fromOrder );
				if( fromORDER != null && fromORDER.getORDER().getRESPOND() != null ){
					ISystemResultHome fromResult = fromORDER.getORDER().getRESPOND().getRspBody();
					fromASK.getRESULT().mergeAsGroup( fromResult );
				}
			}
			finally{
				
			}
			return fromASK;
		}
		
		/**
		 * 把aITaskSRCL合并到aITaskDESL，如任务编号相同则用aITaskSRCL替换到aITaskDESL中
		 * @param aITaskSRCL
		 * @param aITaskDESL
		 * @return
		 */
		public static IOVTaskPentium[] merge( IOVTaskPentium aITaskSRCL[] , IOVTaskPentium aITaskDESL[] ){
			for( int index = 0 ; aITaskSRCL != null && index < aITaskSRCL.length ; index++ ){
				for( int aINDEX = 0 ; aINDEX < aITaskDESL.length ; aINDEX++ ){
					if( aITaskDESL[aINDEX].getTASK_ID() != aITaskSRCL[index].getTASK_ID() ) continue;
					aITaskDESL[aINDEX] = aITaskSRCL[index];
				}
			}
			return aITaskDESL;
		}
		
		/**
		 * 
		 * @param fromTASK
		 * @param fromGROUP
		 */
		public static void groupAsState( IOVTaskPentium fromTASK[] , 
				java.util.Map fromGROUP ){
			for(int index = 0; fromTASK != null && index < fromTASK.length ; index++ ){
				if( fromGROUP.containsKey( fromTASK[index].getSTATE() ) == false ){
					fromGROUP.put( fromTASK[index].getSTATE() , new java.util.ArrayList() );
				}
				((java.util.List)fromGROUP.get( fromTASK[index].getSTATE() )).add( fromTASK[index] );
			}
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromASKING
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static java.util.HashMap groupAsOffer( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				java.util.HashMap fromASKING ) throws SFException,Exception{
			try
			{
				IOVOrderPentium.IOrderOfferHome fromOrderHome = fromOrder.getORDER();
				if( fromASKING == null ){ fromASKING = new java.util.HashMap(); }
				if( fromTASK != null && fromTASK.getORDER().getOFFER() != null ){
					IOVOfferPentium fromOrdOffer = fromTASK.getORDER().getOFFER();
					UpdcUtils.ICustom._wrap( fromOrdOffer, fromASKING );
				}
				else/*服务全量订购单*/{
					IProfessionalTemplate.IProductOffer fromUpdcpm = null;
					for( java.util.Iterator itera = fromOrderHome.getOFFER().iterator(); itera.hasNext(); ){
						IOVOfferPentium fromOrdOffer = (IOVOfferPentium)itera.next();
						fromUpdcpm = UpdcpUtils.ISystem.getCOMPETE( fromOrdOffer.getCOMPETE_ID() );
						if( StringUtils.isBlank( fromOrdOffer.getSUBFLOW() ) /*全局变量*/){
							ICustom._wrap( fromOrdOffer, fromASKING );
						}
						else if( fromUpdcpm.isPRICE() /*产品类开通*/){
							ICustom._wrap( fromOrdOffer, fromASKING );
						}
						else if( fromUpdcpm.isVIRTUAL() /*虚拟类开通*/){
							ICustom._wrap( fromOrdOffer, fromASKING );
						}
						else if( fromUpdcpm.isSERVICE() /*服务类开通*/){
							IProfessionalTemplate.IProductComptel fromUpffwm = fromUpdcpm.getCOMPTEL();
							if( fromUpffwm == null /*单服务类开通*/){
								ICustom._wrap( fromOrdOffer, fromASKING );
							}
							else if( ( fromUpffwm.isPRICE() || fromUpffwm.isMULTLE() ) == false /*单服务类开通*/){
								ICustom._wrap( fromOrdOffer, fromASKING );
							}
							else/*单产品类开通*/{
								IOVOfferPentium.IOfferMBeanHome fromOfferHome = fromOrdOffer.getORDER();
								for( java.util.Iterator iterap = fromOfferHome.getOFFER().entrySet().iterator(); iterap.hasNext(); ){
									java.util.Map.Entry fromEntry = (java.util.Map.Entry)iterap.next();
									if( fromASKING.containsKey( fromEntry.getKey() ) == false /*节点不存在则添加*/){
										fromASKING.put( fromEntry.getKey(), fromEntry.getValue() );
									}
									else/*节点存在则合并*/{
										StringBuilder fromUpffmx = new StringBuilder();
										try
										{
											fromUpffmx.append( fromASKING.get( fromEntry.getKey() ) );
											if( StringUtils.isBlank( fromUpffmx.toString() ) == false ){ fromUpffmx.append("/"); }
											fromUpffmx.append( fromEntry.getValue() );
											fromASKING.put( fromEntry.getKey(), fromUpffmx.toString() );
										}
										finally{
											if( fromUpffmx != null ){ fromUpffmx = null; }
										}
									}
								}
							}
						}
					}
				}
				
			}
			finally{
				
			}
			return fromASKING;
		}
		
		/**
		 * 
		 * @param fromTASK
		 * @param fromUpfwm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IOVTaskPentium fromTASK[], 
				IOVQueuePentium fromUpfwm[] ) throws SFException,Exception{
			java.util.Map fromINDEX = new java.util.HashMap();
			try
			{
				for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
					fromINDEX.put( new Long(fromUpfwm[index].getPLQK_ID()), fromUpfwm[index] );
				}
				for( int index = 0; fromTASK != null && index < fromTASK.length; index++ ){
					Long fromPLWK = new Long( fromTASK[index].getTASK_ID() );
					fromTASK[index].getORDER().setORIGING( fromINDEX.get( fromPLWK ) );
				}
			}
			finally{
				if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			}
		}
		/**
		 * 
		 * @param fromTASK
		 * @param fromUpfwm
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IOVTaskPentium fromTASK[], 
				IOVUpfwmOrder fromUpfwm[] ) throws SFException,Exception{
			java.util.Map fromINDEX = new java.util.HashMap();
			try
			{
				for( int index = 0 ; fromUpfwm != null && index < fromUpfwm.length; index++ ){
					fromINDEX.put( new Long(fromUpfwm[index].getTASK_ID()), fromUpfwm[index] );
				}
				for( int index = 0; fromTASK != null && index < fromTASK.length; index++ ){
					Long fromPLWK = new Long( fromTASK[index].getTASK_ID() );
					fromTASK[index].getORDER().setORIGING( fromINDEX.get( fromPLWK ) );
				}
			}
			finally{
				if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
			}
			
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromTASK
		 * @param fromUpdbm
		 * @throws Exception
		 */
	    public static void transferAsOrder( IOVOrderPentium fromOrder, IOVTaskPentium fromTASK[], java.util.List fromUpdbm ) throws Exception{
	    	try
	    	{
	    		for(int index = 0 ; index < fromTASK.length ; index++){
		    		if( fromTASK[index].getORDER_ID() == fromOrder.getORDER_ID() ){
		    			fromUpdbm.add( fromTASK[index] );
		    		}
		    	}
	    	}
	    	finally{
	    		
	    	}
	    }
	    
	    /**
		 * 服务任务单转换开通异常
		 * @param fromORDER 服务定单
		 * @param fromTASK 服务异常单
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static SFException transferAsRespond( IOVOrderPentium fromORDER,
				IOVTaskPentium fromTASK,
				IUpdcContext aContext ) throws SFException,Exception{
			SFException aEXCEPTION = null;
			try
			{
				aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, "" );
				if( fromTASK != null && StringUtils.isBlank( fromTASK.getPLWK_CODING() ) == false ){
					IPlatformTemplate.IUpffmOffer fromUpffmx = null;
					fromUpffmx = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( fromTASK.getPLATFORM() );
					if( StringUtils.isBlank( fromTASK.getDONE_RESULT() ) == false ){
						aEXCEPTION = ICustomX._jj_respond(fromORDER, fromTASK, aContext);
					}
					else{
						aEXCEPTION = ExceptionFactory.getException( fromTASK.getPLWK_CODING(),
								StringUtils.isBlank( fromTASK.getDONE_RESULT() )?
										"":fromTASK.getDONE_RESULT() );
					}
					aEXCEPTION.setCategory( fromUpffmx.getCODE() );
				}
			}
			finally{
				
			}
			return aEXCEPTION;
		}
		
		public static class ICustomX{
			public ICustomX(){
				super();
			}
			
			/**
			 * 根据源表持久化类型转换二级持久化类型
			 * @param fromTYPE
			 * @return
			 */
			public static ObjectType wrap( ObjectType fromTYPE ){
				ObjectType fromGloal = null;
				try
				{
					if( fromTYPE.equals( SAOrder.S_TYPE ) ){
						fromGloal = SAOffer.S_TYPE;
					}
					else if( fromTYPE.equals( SAOrderFail.S_TYPE ) ){
						fromGloal = SAOfferFail.S_TYPE;
					}
					else if( fromTYPE.equals( SAOrderHis.S_TYPE ) ){
						fromGloal = SAOfferHis.S_TYPE;
					}
				}
				finally{
					
				}
				return fromGloal;
			}
			
		    /**
		     * 
		     * @param fromOrder
		     * @param aContext
		     * @return
		     * @throws SFException
		     * @throws Exception
		     */
		    public static SFException _jj_respond( IOVOrderPentium fromOrder, IUpdcContext aContext ) throws SFException,Exception{
		    	SFException aEXCEPTION = null;
		    	IOVUpdbsComplete fromUpfgxm = null;
		    	try
		    	{
		    		aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, new String[]{});
		    		if( fromOrder != null ){
		    			if( fromOrder.isCOMPLETE() /*正常报竣工*/ || fromOrder.isRUNNING() /*定单在途*/){
							aEXCEPTION = ExceptionFactory.getException( IUpdcConst.IUpdfx.SUCCEED, new String[]{ });
						}
						else/*异常报竣*/{
							fromUpfgxm = IUpdbsFactory.getIUpdbsSV().getSFOrder(fromOrder, aContext);
							aEXCEPTION = ExceptionFactory.getException( fromUpfgxm.getPLWK_CODING(), 
									fromUpfgxm.getPLWK_DESCRIBE());
						}
		    		}
		    	}
		    	finally{
		    		if( fromUpfgxm != null ){ fromUpfgxm = null; }
		    	}
		    	return aEXCEPTION;
		    }
		    
		    /**
			 * 
			 * @param fromORDER
			 * @param fromTASK
			 * @param aContext
			 * @return
			 * @throws SFException
			 * @throws Exception
			 */
			public static SFException _jj_respond( IOVOrderPentium fromORDER,
					IOVTaskPentium fromTASK,
					IUpdcContext aContext ) throws SFException,Exception{
				SFException aEXCEPTION = null;
				try
				{
					String fromRspCode = null,fromRspDesc = null;
					java.util.Map fromASK = new java.util.HashMap();
					try
					{
						fromRspCode = fromTASK.getPLWK_CODING();
						XmlUtils.XPath( fromTASK.getDONE_RESULT(), fromASK );
						fromRspDesc = (String)fromASK.get( IUpdcConst.IUpfwm.PLWK_DESCRIBE );
						if( StringUtils.isBlank( fromRspDesc ) ){
							fromRspDesc = fromTASK.getDONE_RESULT();
						}
					}
					catch( java.lang.Exception aException ){
						fromRspDesc = fromTASK.getDONE_RESULT();
					}
					finally{
						if( fromASK != null ){ fromASK.clear(); fromASK = null; }
					}
					aEXCEPTION = ExceptionFactory.getException( fromRspCode, fromRspDesc );
				}
				finally{
					
				}
				return aEXCEPTION;
			}
		}
	}
	public static class ISystem{
		public ISystem(){
			super();
		}
		
		/**
		 * 获取当前待提交服务定单缓存
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderPentium[] getSFOrder( IUpdcContext aContext ) throws SFException,Exception{
			IOVOrderPentium __order__[] = null;
			try
			{
				__order__ = (IOVOrderPentium[])UpfsvcManager.getSession().getIUpdfmxLifite( IOVOrderPentium.class );
			}
			finally{
				
			}
			return __order__;
		}
		
		/**
		 * 获取当前待提交服务定单缓存
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium[] getSFTask( IUpdcContext aContext ) throws SFException,Exception{
			IOVTaskPentium __task__[] = null;
			try
			{
				__task__ = (IOVTaskPentium[])UpfsvcManager.getSession().getIUpdfmxLifite( IOVTaskPentium.class );
			}
			finally{
				
			}
			return __task__;
		}
		
		/**
		 * 查询当前线程事务中全量服务定单
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderPentium[] getCTKSFOrder() throws SFException,Exception{
			java.util.List fromList = new ArrayUQCList();
			try
			{
				IOVOrderPentium fromOrder[] = (IOVOrderPentium[])UpfsvcManager.getSession().getIUpdbpmLifite( IOVOrderPentium.class );
				if( fromOrder != null && fromOrder.length > 0 ) ClassUtils.IMerge.merge( fromOrder , fromList );
				fromOrder = (IOVOrderPentium[])UpfsvcManager.getSession().getIUpdfmxLifite( IOVOrderPentium.class );
				if( fromOrder != null && fromOrder.length > 0 ) ClassUtils.IMerge.merge( fromOrder , fromList );
			}
			finally{
				
			}
			return (IOVOrderPentium[])fromList.toArray( new IOVOrderPentium[]{} );
		}
		
		/**
		 * 根据流程订单编号查询当前线程事务中副本服务订单
		 * @param aORDER_ID 流程订单编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderPentium getCTKSFOrder( long aORDER_ID ) throws SFException,Exception{
			IOVOrderPentium fromPentium = null;
			try
			{
				IOVOrderPentium aORDER = null;
				IOVOrderPentium fromORDER[] = getCTKSFOrder();
				for( int index = 0 ; fromORDER != null && index < fromORDER.length ; index++ ){
					if( fromORDER[index].getORDER_ID() == aORDER_ID ){
						aORDER = fromORDER[index];
						break;
					}
				}
				if( aORDER != null ){ fromPentium = new IOVOrderPentium( aORDER ); }
			}
			finally{
				
			}
			return fromPentium;
		}
		
		/**
		 * 根据服务定单查询当前线程事务中副本服务订单,如不存在则返回当前服务定单
		 * @param fromORDER 服务定单
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderPentium getCTKSFOrder( IOVOrderPentium fromORDER ) throws SFException,Exception{
			IOVOrderPentium fromOrder = null;
			try
			{
				if( fromORDER != null && fromORDER.getORDER_ID() > 0 ){
					fromOrder = ISystem.getCTKSFOrder( fromORDER.getORDER_ID() );
					if( fromOrder == null ){ fromOrder = fromORDER; }
				}
			}
			finally{
				
			}
			return fromOrder;
		}
		
		/**
		 * 根据服务群组定单号查询当前线程事务中该服务群组服务子定单
		 * @param aGROUP_ORDER_ID 服务群组定单号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVOrderPentium[] getCTKSFMember( long aGROUP_ORDER_ID ) throws SFException,Exception{
			IOVOrderPentium fromOrder[] = null;
			java.util.List fromPentium = new ArrayUQCList();
			try
			{
				IOVOrderPentium fromORDER[] = getCTKSFOrder();
				for( int index = 0 ; fromORDER != null && index < fromORDER.length ; index++ ){
					if( fromORDER[index].getGROUP_ORDER_ID() == aGROUP_ORDER_ID ){
						fromPentium.add( new IOVOrderPentium( fromORDER[index] ) );
					}
				}
				fromOrder = (IOVOrderPentium[])fromPentium.toArray( new IOVOrderPentium[]{} );
			}
			finally{
				if( fromPentium != null ){ fromPentium.clear(); fromPentium = null; }
			}
			return fromOrder;
		}
		
		/**
		 * 查询当前线程事务中全量服务定单任务
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium[] getCTKSFTask( ) throws SFException,Exception{
			java.util.List fromList = new ArrayUQCList();
			try
			{
				IOVTaskPentium fromTask[] = (IOVTaskPentium[])UpfsvcManager.getSession().getIUpdbpmLifite( IOVTaskPentium.class );
				if( fromTask != null && fromTask.length > 0 ) ClassUtils.IMerge.merge( fromTask , fromList );
				fromTask = (IOVTaskPentium[])UpfsvcManager.getSession().getIUpdfmxLifite( IOVTaskPentium.class );
				if( fromTask != null && fromTask.length > 0 ) ClassUtils.IMerge.merge( fromTask , fromList );
			}
			finally{
				
			}
			return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
		}
		
		/**
		 * 根据流程订单查询线程变量上全量(非副本)服务任务
		 * @param fromOrder 服务定单
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium[] getCTKSFTask( IOVOrderPentium fromOrder ) throws SFException,Exception{
			java.util.List fromList = new java.util.ArrayList();
			try
			{
				IOVTaskPentium fromTASK[] = getCTKSFTask();
				for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
					if( fromTASK[index].getORDER_ID() == fromOrder.getORDER_ID() ){
						fromList.add( fromTASK[index] );
					}
				}
			}
			finally{
				
			}
			return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
		}
		
		/**
		 * 根据流程订单查询线程变量上全量(副本)服务任务
		 * @param fromOrder 服务定单
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium[] getCTKBPMTask( IOVOrderPentium fromOrder ) throws SFException,Exception{
			java.util.List fromList = new java.util.ArrayList();
			try
			{
				IOVTaskPentium fromTASK[] = ISystem.getCTKSFTask( fromOrder );
				for( int index = 0; fromTASK != null && index < fromTASK.length; index++ ){
					fromList.add( new IOVTaskPentium( fromTASK[index] ) );
				}
			}  
			finally{
				
			}
			return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
		}
		
		/**
		 * 根据流程订单查询线程变量上副本服务任务单
		 * @param fromOrder
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium[] getCTKBPKTask( IOVOrderPentium fromOrder ) throws SFException,Exception{
			java.util.List fromList = new java.util.ArrayList();
			try
			{
				IOVTaskPentium fromTASK[] = getCTKSFTask();
				for( int index = 0 ; fromTASK != null && index < fromTASK.length ; index++ ){
					if( fromTASK[index].isCREATE() && fromTASK[index].getORDER_ID() == fromOrder.getORDER_ID() ){
						fromList.add( new IOVTaskPentium( fromTASK[index] ) );
					}
				}
			}
			finally{
				
			}
			return (IOVTaskPentium[])fromList.toArray( new IOVTaskPentium[]{} );
		}
		
		/**
		 * 根据流程订单任务编号查询线程变量上副本服务订单任务
		 * @param aTASK_ID 流程订单任务编号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVTaskPentium getCTKSFTask( long aTASK_ID ) throws SFException,Exception{
			IOVTaskPentium fromPentium = null;
			try
			{
				IOVTaskPentium fromTASK = null;
				IOVTaskPentium fromArray[] = getCTKSFTask();
				for( int index = 0 ; fromArray != null && index < fromArray.length ; index++ ){
					if( fromArray[index].getTASK_ID() == aTASK_ID ){
						fromTASK = fromArray[index];
						break;
					}
				}
				if( fromTASK != null ){ fromPentium = new IOVTaskPentium( fromTASK ); }
			}
			finally{
				
			}
			return fromPentium;
		}
		
		/**
		 * 查询当前线程事务中全量网元定单
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOrder[] getCTKSFUpfwm( ) throws SFException,Exception{
			java.util.List fromUpdfmx = new ArrayUQCList();
			try
			{
				IOVUpfwmOrder fromUpfwm[] = (IOVUpfwmOrder[])UpfsvcManager.getSession().getIUpdbpmLifite( IOVUpfwmOrder.class );
				if( fromUpfwm != null && fromUpfwm.length > 0 ) ClassUtils.IMerge.merge( fromUpfwm, fromUpdfmx );
				fromUpfwm = (IOVUpfwmOrder[])UpfsvcManager.getSession().getIUpdfmxLifite( IOVUpfwmOrder.class );
				if( fromUpfwm != null && fromUpfwm.length > 0 ) ClassUtils.IMerge.merge( fromUpfwm, fromUpdfmx );
			}
			finally{
				
			}
			return (IOVUpfwmOrder[])fromUpdfmx.toArray( new IOVUpfwmOrder[]{} );
		}
		
		/**
		 * 根据网元工单号查询线程变量上副本网元定单
		 * @param aPS_ID 网元工单号
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpfwmOrder getCTKSFUpfwm( long aPS_ID ) throws SFException,Exception{
			IOVUpfwmOrder fromUpfwm = null;
			try
			{
				IOVUpfwmOrder fromOrder = null;
				IOVUpfwmOrder fromArray[] = ISystem.getCTKSFUpfwm();
				for( int index = 0 ; fromArray != null && index < fromArray.length ; index++ ){
					if( fromArray[index].getPS_ID() == aPS_ID ){
						fromOrder = fromArray[index];
						break;
					}
				}
				if( fromOrder != null ){ fromUpfwm = new IOVUpfwmOrder( fromOrder ); }
			}
			finally{
				
			}
			return fromUpfwm;
		}
		
		/**
		 * 
		 * @param fromOrder
		 * @param fromINDEX
		 * @throws SFException
		 * @throws Exception
		 */
		public static void transfer( IOVOrderPentium fromOrder[], java.util.Map fromINDEX ) throws SFException,Exception{
			for( int index = 0 ; fromOrder != null && index < fromOrder.length ; index++ ){
				fromINDEX.put( new Long( fromOrder[index].getORDER_ID() ), fromOrder[index] );
			}
		}
		
		/**
		 * 
		 * @param fromTASK
		 * @param fromINDEX
		 * @return
		 */
		public static IOVOrderPentium getSFOrder( IOVTaskPentium fromTASK , java.util.Map fromINDEX ){
			return (IOVOrderPentium)fromINDEX.get( new Long( fromTASK.getORDER_ID() ) );
		}
		
		/**
		 * 流程工单进入网元指令模式
		 * @param fromOrder 流程订单
		 * @param fromTASK 流程任务
		 * @param aContext
		 * @throws SFException
		 * @throws Exception
		 */
		public static void finishSFUpfwm( IOVOrderPentium fromOrder , 
				IOVTaskPentium fromTASK , 
				IUpdcContext aContext ) throws SFException,Exception{
			try
			{
				if (fromTASK != null && fromOrder != null){
					IOVTaskPentium.ITaskOfferHome fromOFFER = fromTASK.getORDER();
					fromOFFER.getTOKEN().setToken( IPeriodGraphToken.IToken.ACTIVE );
				}
			}
			finally{
				
			}
		}
		
		public static class ISystemX{
			public ISystemX(){
				super();
			}
		}
	}
	public static class ISubFlow{
		public ISubFlow(){
			super();
		}
		
		/**
		 * 查询当前线程上服务定单
		 * @param aContext
		 * @return
		 */
		public static IOVOrderPentium getORDER( IUpdcContext aContext ){
			IOVOrderPentium fromOrder = null;
			try
			{
				java.util.Map[] fromXML = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < fromXML.length ; index++ ){
					fromOrder = (IOVOrderPentium)fromXML[index].get( IUpdcConst.IUpdbm.IUpdbf.ORDER );
					if( fromOrder != null ) break;
				}
			}
			finally{
				
			}
			return fromOrder;
		}
		
		/**
		 * 查询当前线程上开通任务
		 * @param aContext
		 * @return
		 */
		public static IOVTaskPentium getTASK( IUpdcContext aContext ){
			IOVTaskPentium fromTASK = null;
			try
			{
				java.util.Map[] fromXML = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < fromXML.length ; index++ ){
					fromTASK = (IOVTaskPentium)fromXML[index].get( IUpdcConst.IUpdbm.IUpdbf.TASK );
					if( fromTASK != null ) break;
				}
			}
			finally{
				
			}
			return fromTASK;
		}
		
		/**
		 * 查询当前线程上业务网元工单
		 * @param aContext
		 * @return
		 */
		public static IOVUpfwmOffer getPROVISION( IUpdcContext aContext ){
			IOVUpfwmOffer fromUpfwm = null;
			try
			{
				java.util.Map[] fromXML = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < fromXML.length ; index++ ){
					fromUpfwm = (IOVUpfwmOffer)fromXML[index].get( IUpdcConst.IUpdbm.IUpdbf.PROVISION );
					if( fromUpfwm != null ) break;
				}
			}
			finally{
				
			}
			return fromUpfwm;
		}
		
		/**
		 * 根据当前服务任务获取当前服务网元规范
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 逻辑指令
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpdbpmOffer getSUBFLOW( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
			    IUpdcContext aContext) throws SFException, Exception{
			ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
			try
			{
				fromUpdbm = fromTASK.getORDER().getSUBFLOW();
				if( fromUpdfwm.getCHILDREN() != null ) fromUpdbm = fromUpdfwm.getCHILDREN();
			}
			finally{
				
			}
			return fromUpdbm;
		}
		
		/**
		 * 根据当前服务任务获取当前服务网元解决方案规范
		 * @param fromOrder 服务定单
		 * @param fromTASK 服务任务
		 * @param fromUpdfwm 逻辑指令
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static ISystemTemplate.IUpdbpmOffer getPROGRAM( IOVOrderPentium fromOrder, 
				IOVTaskPentium fromTASK, 
				IOVUpdspmLife fromUpdfwm,
			    IUpdcContext aContext) throws SFException, Exception{
			ISystemTemplate.IUpdbpmOffer fromUpdbm = null;
			try
			{
				fromUpdbm = fromTASK.getORDER().getSUBFLOW();
				if( fromUpdfwm.getCHILDREN() != null && fromUpdfwm.getCHILDREN().isPROGRAM() ){
					fromUpdbm = fromUpdfwm.getCHILDREN();
				}
			}
			finally{
				
			}
			return fromUpdbm;
		}
		
		/**
		 * 查询当前线程上逻辑指令
		 * @param aContext
		 * @return
		 */
		public static IPlatformTemplate.IUpffmDirective getDIRECTIVE( IUpdcContext aContext ){
			IPlatformTemplate.IUpffmDirective fromUpdfm = null;
			try
			{
				java.util.Map[] fromXML = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < fromXML.length ; index++ ){
					fromUpdfm = (IPlatformTemplate.IUpffmDirective)fromXML[index].get( IUpdcConst.IUpdbm.IUpdbf.DIRECTIVE );
					if( fromUpdfm != null ) break;
				}
			}
			finally{
				
			}
			return fromUpdfm;
		}
		
		/**
		 * 当前当前线程网元指令集
		 * @param fromUpdfm 如为null则取线程上指令集
		 * @param aContext
		 * @return
		 */
		public static String getDIRECTIVE( IPlatformTemplate.IUpffmDirective fromUpdfm, IUpdcContext aContext ){
			String fromUpdfwm = null;
			try
			{
				if( fromUpdfm == null ) fromUpdfm = ISubFlow.getDIRECTIVE( aContext );
				if( fromUpdfm != null ) fromUpdfwm = fromUpdfm.getDIRECTIVE();
			}
			finally{
				
			}
			return fromUpdfwm;
		}
		
		/**
		 * 查询当前线程上网元操作
		 * @param aContext
		 * @return
		 */
		public static IPlatformTemplate.IUpffmOperate getOPERATE( IUpdcContext aContext ){
			IPlatformTemplate.IUpffmOperate fromUpffom = null;
			try
			{
				java.util.Map[] aUpdsmoLife = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < aUpdsmoLife.length ; index++ ){
					fromUpffom = (IPlatformTemplate.IUpffmOperate)aUpdsmoLife[index].get( IUpdcConst.IUpdbm.IUpdbf.OPERATE );
					if( fromUpffom != null ) break;
				}
			}
			finally{
				
			}
			return fromUpffom;
		}
		
		/**
		 * 获取系统网元定义
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmOffer getPLATFORM() throws SFException,Exception{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			try
			{
				fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( IUpdcConst.IUpfwm.IUpfm.ucmframe );
			}
			finally{
				
			}
			return fromUpffm;
		}
		
		/**
		 * 根据网元编码获取网元定义
		 * @param aPLATFORM 网元编码
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmOffer getPLATFORM( String aPLATFORM ) throws SFException,Exception{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			try
			{
				fromUpffm = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( aPLATFORM );
			}
			finally{
				
			}
			return fromUpffm;
		}
		
		/**
		 * 查询当前线程上网元定义
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmOffer getPLATFORM(IUpdcContext aContext) throws SFException,Exception{
			IPlatformTemplate.IUpffmOffer fromUpffm = null;
			try
			{
				java.util.Map[] aUpdsmoLife = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < aUpdsmoLife.length ; index++ ){
					fromUpffm = (IPlatformTemplate.IUpffmOffer)aUpdsmoLife[index].get( IUpdcConst.IUpdbm.IUpdbf.PLATFORM );
					if( fromUpffm != null ) break;
				}
			}
			finally{
				
			}
			return fromUpffm;
		}
		
		/**
		 * 根据异常类型查询异常类型对应网元信息
		 * @param aEXCEPTION 异常类型
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IPlatformTemplate.IUpffmOffer getPLATFORM( java.lang.Exception aEXCEPTION ){
			IPlatformTemplate.IUpffmOffer fromNetWork = null;
			try
			{
				String aPLATFORM = IUpdcConst.IUpfwm.IUpfm.ucmframe;
				if (aEXCEPTION != null && aEXCEPTION instanceof SFException/* 逻辑异常 */) {
					SFException fromRsRsp = (SFException) aEXCEPTION;
					if( StringUtils.isBlank( fromRsRsp.getOriginator() ) == false)
						aPLATFORM = fromRsRsp.getOriginator();
				}
				fromNetWork = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( aPLATFORM );
			}
			catch( java.lang.Exception aException ){
				throw ExceptionFactory.getException( aException );
			}
			finally{
				
			}
			return fromNetWork;
		}
		
		/**
		 * 根据组件资产查询组件资产对应网元信息
		 * @param fromUpdcpm
		 * @return
		 */
		public static IPlatformTemplate.IUpffmOffer getPLATFORM( ISystemTemplate.IImplCapital fromUpdcpm ){
			IPlatformTemplate.IUpffmOffer fromNetWork = null;
			try
			{
				ISystemTemplate.ICenterCatalog _catalog_ = null;
				if( fromUpdcpm != null && StringUtils.isBlank( fromUpdcpm.getIMPLCLASS() ) == false ){
					_catalog_ = IUpdcfgFactory.getIBasicSV().getSFCenterCatalog( fromUpdcpm.getIMPLCLASS(), IUpdcConst.IUpdbm.IUpdbf.PLATFORM );
				}
				if( _catalog_ == null ){
					fromNetWork = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer();
				}
				else{
					fromNetWork = IUpdcfgFactory.getIUpffmSV().getSFUpffmOffer( _catalog_.getCOMPOSITE() );
				}
			}
			catch( java.lang.Exception aException ){
				throw ExceptionFactory.getException( aException );
			}
			finally{
				
			}
			return fromNetWork;
		}
		
		/**
		 * 查询当前线程上逻辑号段
		 * @param aContext
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public static IOVUpdbpmOffice getSEGMENT(IUpdcContext aContext) throws SFException,Exception{
			IOVUpdbpmOffice fromOffice = null;
			try
			{
				java.util.Map[] fromXML = ISubFlowX._getISTKUpdfxm( aContext );
				for( int index = 0 ; index < fromXML.length ; index++ ){
					fromOffice = (IOVUpdbpmOffice)fromXML[index].get( IUpdcConst.IUpdbm.IUpdbf.SEGMENT );
					if( fromOffice != null ) break;
				}
			}
			finally{
				
			}
			return fromOffice;
		}
		
		public static class ISubFlowX{
			public ISubFlowX(){
				super();
			}
			
			/**
			 * 
			 * @param aContext
			 * @return
			 */
			private static java.util.Map[] _getISTKUpdfxm( IUpdcContext aContext ){
				java.util.List fromUpdfmx = new java.util.ArrayList();
				try
				{
					fromUpdfmx.add( aContext );
					if( UpfsvcManager.getBlankSession() != null ){
						fromUpdfmx.add( UpfsvcManager.getSession().getComposite() );
					}
				}
				finally{
					
				}
				return (java.util.Map[])fromUpdfmx.toArray( new java.util.Map[]{} );
			}
		}
	}
}
