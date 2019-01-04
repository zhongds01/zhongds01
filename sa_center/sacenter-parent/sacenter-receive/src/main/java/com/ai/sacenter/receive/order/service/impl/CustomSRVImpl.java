package com.ai.sacenter.receive.order.service.impl;

import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.IUpdbfsConst;
import com.ai.sacenter.receive.custom.ICustomFactory;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOfferX;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.order.IOrderFactory;
import com.ai.sacenter.receive.order.service.interfaces.ICustomSRV;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.util.CustomUtils.ICustom;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFOfferX;
import com.ai.sacenter.receive.valuebean.IOVMsgFOrdCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFPlan;
import com.ai.sacenter.receive.valuebean.IOVMsgFRequest;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserCentrex;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFUserPlan;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于开通用户API</p>
 * <p>Copyright: Copyright (c) 2017年3月7日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class CustomSRVImpl extends UpdcEclipseImpl implements ICustomSRV {

	public CustomSRVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFUser(long, java.lang.String)
	 */
	public IOVUser getSFUser(long aUSER_ID, String aREGION_ID) throws SFException, Exception {
		IOVUser fromUser = null;
		try
		{
			fromUser = ICustomFactory.getICustomSV().getSFUserByUserId( aUSER_ID, aREGION_ID );
		}
		finally{
			
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFCustom(long, java.lang.String, java.lang.String)
	 */
	public IOVCustom getSFCustom(long aCUSTOM_ID, 
			String aCUSTOM_TYPE,
			String aREGION_ID) throws SFException, Exception {
		IOVCustom fromCustom = null;
		try
		{
			fromCustom = ICustomFactory.getICustomSV().getSFCustom( aCUSTOM_ID, aCUSTOM_TYPE, aREGION_ID );
		}
		finally{
			
		}
		return fromCustom;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFUserOrder(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser)
	 */
	public IOVMsgFOffer[] getSFUserOrder(IOVMsgFRequest fromRequest,
			IOVMsgFUser fromMsgFUser) throws SFException, Exception {
		CarbonList<IOVMsgFOffer> fromOfferHome = new CarbonList<IOVMsgFOffer>();
		try
		{
			IOVUser fromUser = ICustomFactory.getICustomSV().getSFUserOrderByUserId( fromMsgFUser.getUSER_ID(), 
					fromMsgFUser.getUSER_REGION_ID() );
			if( fromUser != null && fromUser.getORDER() != null ){
				for( java.util.Iterator<IOVUserCentrex> itera = fromUser.getORDER().iterator(); itera.hasNext(); ){
					IOVUserCentrex fromCentrex = (IOVUserCentrex)itera.next();
					for( java.util.Iterator<IOVUserOrder> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVUserOrder fromUserOrder = (IOVUserOrder)iterap.next();
						if( fromUserOrder.isVALID() == false/*无效用户订购关系*/) continue;
						IOVMsgFOffer fromMsgFOffer = new IOVMsgFUserOffer();
						CustomUtils.ICustom._wrap( fromUserOrder, fromMsgFOffer );
						fromOfferHome.add( fromMsgFOffer );
					}
				}
			}
		}
		finally{
			
		}
		return (IOVMsgFOffer[])fromOfferHome.toArray( new IOVMsgFOffer[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFUserOrder(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVMsgFOffer[] getSFUserOrder(IOVMsgFRequest fromRequest, 
			IOVMsgFUser fromMsgFUser,
			IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		CarbonList<IOVMsgFOffer> fromOfferHome = new CarbonList<IOVMsgFOffer>();
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			IOVUser fromUser = ICustomFactory.getICustomSV().getSFUserOrderByUserId( fromMsgFUser.getUSER_ID(), 
					fromMsgFUser.getUSER_REGION_ID() );
			if( fromUser != null && fromUser.getORDER() != null ){
				for( java.util.Iterator<IOVUserCentrex> itera = fromUser.getORDER().iterator(); itera.hasNext(); ){
					IOVUserCentrex fromCentrex = (IOVUserCentrex)itera.next();
					if( fromMsgFUser.getORDER( fromCentrex.getINS_OFFER_ID() ) == null ){ continue; }
					for( java.util.Iterator<IOVUserOrder> iterap = fromCentrex.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVUserOrder fromUserOrder = (IOVUserOrder)iterap.next();
						if( fromUserOrder.isVALIDNOW( fromMBean.getCREATE() ) == false/*无效用户订购关系*/) continue;
						IOVMsgFOffer fromUserOffer = new IOVMsgFUserOffer();
						CustomUtils.ICustom._wrap( fromUserOrder, fromUserOffer );
						fromOfferHome.add( fromUserOffer );
					}
				}
			}
		}
		finally{
			
		}
		return (IOVMsgFOffer[])fromOfferHome.toArray( new IOVMsgFOffer[]{} );
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFUserCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser)
	 */
	public IOVMsgFUser getSFUserCentrex(IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser) throws SFException, Exception {
		IOVMsgFUser fromMsgFCentrex = null;
		try
		{
			IOVUser fromUser = ICustomFactory.getICustomSV().getSFUserOrderByUserId( fromMsgFUser.getUSER_ID(), fromMsgFUser.getUSER_REGION_ID() );
			if( fromUser != null && fromUser.getORDER() != null ){
				fromMsgFCentrex = CustomUtils.ICustom._wrap(fromUser, new IOVMsgFUser() );
				for( java.util.Iterator<IOVUserOffer> itera = fromUser.getOFFER().iterator(); itera.hasNext(); ){
					IOVUserOffer useroffer = (IOVUserOffer)itera.next();
					IOVMsgFPlan fromMsgFPlan = CustomUtils.ICustom._wrap( useroffer, new IOVMsgFUserPlan() );
					fromMsgFCentrex.getCENTREX().add( fromMsgFPlan );
				}
				for( java.util.Iterator<IOVUserCentrex> itera = fromUser.getORDER().iterator(); itera.hasNext(); ){
					IOVUserCentrex usercentrex = (IOVUserCentrex)itera.next();
					fromMsgFCentrex.mergeAsCentrex( new IOVMsgFUserCentrex( usercentrex ) );
				}
				fromMsgFCentrex.userCentrexLimite();
			}
		}
		finally{
			
		}
		return fromMsgFCentrex;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFUserCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFUser, int)
	 */
	public IOVMsgFUser getSFUserCentrex(IOVMsgFRequest fromRequest, IOVMsgFUser fromMsgFUser, int fromVALID) throws SFException, Exception {
		IOVMsgFUser fromMsgFCentrex = null;
		try
		{
			IOVMsgFRequest.IMsgFOfferHome fromMetaHome = fromRequest.getORDER();
			IOVUser fromUser = ICustomFactory.getICustomSV().getSFUserOrderByUserId( fromMsgFUser.getUSER_ID(), fromMsgFUser.getUSER_REGION_ID() );
			if( fromUser != null ){
				fromMsgFCentrex = CustomUtils.ICustom._wrap(fromUser, new IOVMsgFUser() );
				for( java.util.Iterator<IOVUserOffer> itera = fromUser.getOFFER().iterator(); itera.hasNext(); ){
					IOVUserOffer useroffer = (IOVUserOffer)itera.next();
					if( useroffer.isVALID( fromVALID, fromMetaHome.getCREATOR() ) == false ){ continue; }
					IOVMsgFPlan fromMsgFPlan = CustomUtils.ICustom._wrap( useroffer, new IOVMsgFUserPlan() );
					fromMsgFCentrex.getCENTREX().add( fromMsgFPlan );
				}
				for( java.util.Iterator<IOVUserCentrex> itera = fromUser.getORDER().iterator(); itera.hasNext(); ){
					IOVUserCentrex usercentrex = (IOVUserCentrex)itera.next();
					if( usercentrex.isVALID( fromVALID, fromMetaHome.getCREATOR() )  == false ){ continue; }
					fromMsgFCentrex.mergeAsCentrex( new IOVMsgFUserCentrex( usercentrex ) );
				}
				fromMsgFCentrex.userCentrexLimite();
			}
		}
		finally{
			
		}
		return fromMsgFCentrex;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFOfferUser(com.ai.sacenter.receive.valuebean.IOVMsgFRequest, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUser getSFOfferUser(IOVMsgFRequest fromRequest,
			IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUser fromUser = null;
		try
		{
			IOVMsgFUser fromMsgFUser = fromRequest.getUSER( fromMsgFOffer.getUSER_ID() );
			fromUser = ICustomFactory.getICustomSV().getSFOfferUser(fromMsgFUser, fromMsgFOffer);
		}
		finally{
			
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFUserVpmnType(com.ai.sacenter.receive.valuebean.IOVMsgFUser)
	 */
	public IOVUserOffer getSFUserVpmnType(IOVMsgFUser fromUser) throws SFException, Exception {
		IOVUserOffer fromOfferHome = null;
		try
		{
			IOVUserOffer fromUserOffer = ICustomFactory.getICustomSV().getSFUserOffer( fromUser );
			if( fromUserOffer != null ){
				IProfessionalTemplate.IProductCombine fromGroup = IOrderFactory.getIProductSV().getSFPVpmnGroup();
				if( fromGroup != null && fromGroup.getCOMBINE( String.valueOf( fromUserOffer.getOFFER_ID() )) != null ){
					fromOfferHome = fromUserOffer;
				}
			}
		}
		finally{
			
		}
		return fromOfferHome;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#getSFGroupOffer(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUserOffer getSFGroupOffer(IOVMsgFUser fromUser,
			IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUserOffer fromOffer = null;
		try
		{
			fromOffer = ICustomFactory.getICustomSV().getSFUserOffer(fromUser, fromMsgFOffer);
		}
		finally{
			
		}
		return fromOffer;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#finishSFUserLoad(java.util.Map)
	 */
	public void finishSFUserLoad(java.util.Map<String, CarbonList<Long>> fromUpdfmx) throws SFException, Exception {
		try
		{
			for( java.util.Iterator<java.util.Map.Entry<String, CarbonList<Long>>> itera = fromUpdfmx.entrySet().iterator(); itera.hasNext(); ){
				java.util.Map.Entry<String, CarbonList<Long>> fromEntry = (java.util.Map.Entry<String, CarbonList<Long>>)itera.next();
				String _user_region_id = (String)fromEntry.getKey();
				java.util.List<Long> _user_id_home = (CarbonList<Long>)fromEntry.getValue();
				long _user_id[] = new long[ _user_id_home.size() ];
				for( int index = 0; index < _user_id_home.size(); index++ ){
					Long __user_id = (Long)_user_id_home.get( index );
					_user_id[index] = __user_id.longValue();
				}
				ICustomFactory.getICustomSV().finishSFUserLoader( _user_id, _user_region_id );
			}
		}
		finally{
			
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.order.service.interfaces.ICustomSRV#finishSFCentrexUser(com.ai.sacenter.receive.valuebean.IOVMsgFRequest)
	 */
	public void finishSFCentrexUser(IOVMsgFRequest fromRequest) throws SFException, Exception {
		try
		{
			class SFCustomTfImpl{
				private SFCustomUser _user = new SFCustomUser();
				public SFCustomTfImpl(){
					super();
				}
				
				/**
				 * 开通定单用户转换为用户
				 * @param fromMsgFUser
				 * @param fromUser
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferAsUser( IOVMsgFUser fromMsgFUser, IOVUser fromUser ) throws SFException, Exception{
					try
					{
						if( StringUtils.isBlank( fromMsgFUser.getUSER_STATUS() ) == false ){
							fromUser.setSTATUS   ( fromMsgFUser.getUSER_STATUS() );
						}
						if( StringUtils.isBlank( fromMsgFUser.getOS_STATUS() ) == false ){
							fromUser.setOS_STATUS ( fromMsgFUser.getOS_STATUS  () );
						}
						for( java.util.Iterator<IOVMsgFOfferX> itera = fromMsgFUser.getNATURE().iterator(); itera.hasNext(); ){
							IOVMsgFOfferX fromMsgFOfferX = (IOVMsgFOfferX)itera.next();
							IOVUserOfferX fromOfferX = ICustom._wrap( fromMsgFOfferX, new IOVUserOfferX() );
							if( fromUser.getNATURE().contains( fromOfferX ) == false ){ continue; }
							if( StringUtils.equals( fromOfferX.getATTR_ID(), IUpdbfsConst.IUpdbm.IUser.NEWMSDN ) ){
								fromUser.setBILL_ID( fromOfferX.getATTR_VALUE() );
							}
							else if( StringUtils.equals( fromOfferX.getATTR_ID(), IUpdbfsConst.IUpdbm.IUser.NEWIMSI ) ){
								fromUser.setSUB_BILL_ID( fromOfferX.getATTR_VALUE() );
							}
							else{
								fromUser.getNATURE().add( fromOfferX );
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 开通定单套餐转换为用户套餐
				 * @param fromMsgFUser
				 * @param fromUser
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferAsCentrex( IOVMsgFUser fromMsgFUser, IOVUser fromUser ) throws SFException, Exception{
					try
					{
						for( java.util.Iterator<IOVMsgFPlan> itera = fromMsgFUser.getCENTREX().iterator(); itera.hasNext(); ){
							IOVMsgFPlan _msgfoffer = (IOVMsgFPlan)itera.next();
							IOVUserOffer _useroffer = CustomUtils.ICustom._wrap( _msgfoffer, new IOVUserOffer() );
							if( _msgfoffer.isVALIDALL() && fromUser.getOFFER().get( _useroffer ) == null ){
								fromUser.getOFFER().add( _useroffer );
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 开通定单订购转换为用户订购
				 * @param fromMsgFUser
				 * @param fromUser
				 * @throws SFException
				 * @throws Exception
				 */
				private void _transferAsUserOffer( IOVMsgFUser fromMsgFUser, IOVUser fromUser ) throws SFException, Exception{
					try
					{
						//开通定单订购转换为用户订购
						for( java.util.Iterator<IOVMsgFOrdCentrex> itera = fromMsgFUser.getORDER().iterator(); itera.hasNext(); ){
							IOVMsgFOrdCentrex fromMsgFCentrex = (IOVMsgFOrdCentrex)itera.next();
							IOVUserCentrex __usercentrex = CustomUtils.ICustom._wrap(fromMsgFCentrex, new IOVUserCentrex() );
							_user.submitAsCentrex( fromUser, __usercentrex );
							fromUser.orderAsCentrex( __usercentrex );
						}
						//开通用户订购转换为用户订购
						for( java.util.Iterator<IOVMsgFUserCentrex> itera = fromMsgFUser.getUSER().iterator(); itera.hasNext(); ){
							IOVMsgFUserCentrex fromMsgFCentrex = (IOVMsgFUserCentrex)itera.next();
							IOVUserCentrex _usercentrex = CustomUtils.ICustom._wrap(fromMsgFCentrex, new IOVUserCentrex() );
							IOVUserCentrex _ordercentrex = _user.getSFCentrex( fromUser, _usercentrex );
							IOVUserCentrex __usercentrex = fromUser.getORDER( fromMsgFCentrex.getINS_PROD_ID() );
							if( _ordercentrex == null/*属于开通用户服务产品*/){
								fromUser.orderAsCentrex( _usercentrex );
							}
							else if( __usercentrex != null/*属于开通用户服务产品[属性合并]*/){
								fromUser.userAsCentrex( _usercentrex, _ordercentrex );
							}
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromMsgFUser
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				private IOVUser _transferAsCreate( IOVMsgFUser fromMsgFUser ) throws SFException, Exception{
					IOVUser fromUser = null;
					try
					{
						fromUser = new IOVUser();
						CustomUtils.ICustom._wrap( fromMsgFUser, fromUser );
						fromUser.setORDER( new CarbonList<IOVUserCentrex>   () );
						fromUser.setOFFER( new CarbonList<IOVUserOffer>     () );
						fromUser.setGROUP( new CarbonList<IOVUserOrderOffer>() );
						//开通定单套餐转换为用户套餐
						_transferAsCentrex( fromMsgFUser, fromUser );
						//开通定单订购转换为用户订购
						_transferAsUserOffer( fromMsgFUser, fromUser );
					}
					finally{
					
					}
					return fromUser;
				}
				
				/**
				 * 
				 * @param fromMsgFUser
				 * @param fromUser
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				private IOVUser _transferAsUpdate( IOVMsgFUser fromMsgFUser, IOVUser fromUser ) throws SFException,Exception{
					try
					{
						//开通定单用户转换为用户
						_transferAsUser( fromMsgFUser, fromUser );
						//开通定单套餐转换为用户套餐
						_transferAsCentrex( fromMsgFUser, fromUser );
						//开通定单订购转换为用户订购
						_transferAsUserOffer( fromMsgFUser, fromUser );
					}
					finally{
						
					}
					return fromUser;
				}
				
				/**
				 * 
				 * @param fromMsgFUser
				 * @throws SFException
				 * @throws Exception
				 */
				public void transferAsUser( IOVMsgFUser fromMsgFUser ) throws SFException,Exception{
					try
					{
						String _user_id_ = CustomUtils.ICatalog._custom_user_id( fromMsgFUser.getUSER_ID() );
						IUpdfmxDirectory _user_factory = UpfsvcManager.getSession().getIUpfxCustom( _user_id_ );
						IOVUser __user__ = _user_factory != null?(IOVUser)_user_factory.getBottle():null;
						if( __user__ != null ){
							__user__ = _transferAsUpdate( fromMsgFUser, __user__ );
							_user_factory = new IUpdfmxDirectory( _user_id_, __user__ );
						}
						else{
							__user__ = _transferAsCreate( fromMsgFUser );
							_user_factory = new IUpdfmxDirectory( _user_id_, __user__ );
						}
						UpfsvcManager.getSession().submitIUpfxCustom( _user_factory.getGroup(), _user_factory );
						if( __user__ != null && __user__.getCUSTOM() != null ){
							IOVCustom __custom__ = __user__.getCUSTOM();
							String _custom_id_ = CustomUtils.ICatalog._custom_cust_id( __custom__.getCUST_ID(), __custom__.getCUST_TYPE() );
							IUpdfmxDirectory __custom_factory = new IUpdfmxDirectory( _custom_id_, __custom__ );
							UpfsvcManager.getSession().submitIUpfxCustom( __custom_factory.getGroup(), __custom_factory );
						}
					}
					finally{
						
					}
				}
				
				/**
				 * 
				 * @param fromRequest
				 * @throws SFException
				 * @throws Exception
				 */
				public void transferAsGroup( IOVMsgFRequest fromRequest ) throws SFException,Exception{
					try
					{
						
					}
					finally{
						
					}
				}
				
				class SFCustomUser{
					private java.util.Map<String,Object> _custom = new java.util.HashMap<String,Object>();
					public SFCustomUser(){
						super();
					}
					
					/**
					 * 
					 * @param fromUser
					 * @return
					 */
					public java.util.Map<String,Object> getSFUser( IOVUser fromUser ){
						java.util.Map<String,Object> _tables = null;
						try
						{
							String fromUSER_ID = CustomUtils.ICatalog._custom_user_id( fromUser.getUSER_ID() );
							if( ( _tables = (java.util.Map<String,Object>)_custom.get( fromUSER_ID ) ) == null ){
								_custom.put( fromUSER_ID, _tables = new java.util.HashMap<String,Object>() );
							}
						}
						finally{
							
						}
						return _tables;
					}
					
					/**
					 * 
					 * @param fromUser
					 * @param fromCentrex
					 * @return
					 */
					public IOVUserCentrex getSFCentrex( IOVUser fromUser, IOVUserCentrex fromCentrex  ){
						IOVUserCentrex _usercentrex = null;
						try
						{
							java.util.Map<String,Object> _tables = getSFUser( fromUser );
							if( fromCentrex.getINS_PROD_ID() > 0 ){
								String _custom_sprom_id = CustomUtils.ICatalog._custom_sprom_id( fromCentrex.getINS_PROD_ID() );
								_usercentrex = (IOVUserCentrex)_tables.get( _custom_sprom_id );
							}
						}
						finally{
							
						}
						return _usercentrex;
					}
					
					/**
					 * 
					 * @param fromMsgFUser
					 * @param fromMsgFOffer
					 */
					public void submitAsCentrex( IOVUser fromUser, IOVUserCentrex fromMsgFOffer ){
						try
						{
							java.util.Map<String,Object> _tables = getSFUser( fromUser );
							if( fromMsgFOffer.getINS_PROD_ID() > 0 ){
								String _custom_sprom_id = CustomUtils.ICatalog._custom_sprom_id( fromMsgFOffer.getINS_PROD_ID() );
								_tables.put( _custom_sprom_id, fromMsgFOffer );
							}
						}
						finally{
							
						}
					}
					
				}
			}
			SFCustomTfImpl fromCustomImpl = new SFCustomTfImpl();
			try
			{
				//开通用户群
				fromCustomImpl.transferAsGroup( fromRequest );
				//开通定单用户
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getUSER().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					fromCustomImpl.transferAsUser( fromMsgFUser );
				}
				//开通关联用户
				for( java.util.Iterator<IOVMsgFUser> itera = fromRequest.getCENTREX().iterator(); itera.hasNext(); ){
					IOVMsgFUser fromMsgFUser = (IOVMsgFUser)itera.next();
					fromCustomImpl.transferAsUser( fromMsgFUser );
				}
			}
			finally{
				if( fromCustomImpl != null ){ fromCustomImpl = null; }
			}
		}
		finally{
			
		}
	}
}
