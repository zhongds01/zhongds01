package com.ai.sacenter.receive.custom.service.impl;

import java.rmi.RemoteException;

import com.ai.sacenter.SFException;
import com.ai.sacenter.common.IUpdfmxDirectory;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.custom.CustomFactory;
import com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer;
import com.ai.sacenter.receive.expire.valuebean.IOVExpireUser;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.receive.valuebean.IOVMsgFOffer;
import com.ai.sacenter.receive.valuebean.IOVMsgFUser;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.TimeUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016年3月23日</p>
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
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserByUserId(long, java.lang.String)
	 */
	public IOVUser getSFUserByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		IOVUser fromUSER = null;
		try
		{
			String _custom_user_id = CustomUtils.ICatalog._custom_user_id( aUserId );
			IUpdfmxDirectory _user_directory_ = UpfsvcManager.getSession().getIUpfxCustom( _custom_user_id );
			if( _user_directory_ != null ){
				fromUSER = (IOVUser)_user_directory_.getBottle();
			}
			else if( CustomUtils.IIfElse.isRECEIVE() == false /*非开通定单发起*/){
				fromUSER = CustomFactory.getICustomSV().getIInsUserByUserId( aUserId, aRegionId );
				_user_directory_ = new IUpdfmxDirectory( _custom_user_id, fromUSER );
				UpfsvcManager.getRocket().submitIUpfxCustom( _custom_user_id, _user_directory_ );
			}
		}
		finally{
			
		}
		return fromUSER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#finishSFUserLoader(long[], java.lang.String)
	 */
	public void finishSFUserLoader(long[] aUserId, String aRegionId) throws SFException, Exception {
		java.util.Map<Long,IOVUser> fromUserMap = new java.util.HashMap<Long,IOVUser>();
		try
		{
			IOVUser fromUSER[] = CustomFactory.getICustomSV().getIInsUserByUserId( aUserId, aRegionId );
			for( int index = 0; fromUSER != null && index < fromUSER.length; index++ ){
				Long fromINDEX = new Long( fromUSER[index].getUSER_ID() );
				fromUserMap.put( fromINDEX, fromUSER[index] );
			}
			for( int index = 0; aUserId != null && index < aUserId.length; index++ ){
				String _custom_user_id = CustomUtils.ICatalog._custom_user_id( aUserId[index] );
				IOVUser fromUser = (IOVUser)fromUserMap.get( new Long( aUserId[index] ) );
				IUpdfmxDirectory _user_directory_ = new IUpdfmxDirectory( _custom_user_id, fromUser );
				UpfsvcManager.getRocket().submitIUpfxCustom( _custom_user_id, _user_directory_ );
			}
		}
		finally{
		
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOfferByUserId(long, java.lang.String)
	 */
	public IOVUser getSFUserOfferByUserId(long aUserId, String aRegionId) throws SFException, Exception {
		IOVUser fromUSER = null;
		try
		{
			fromUSER = getSFUserByUserId( aUserId, aRegionId );
			if( fromUSER != null && fromUSER.getOFFER() == null ){
				if( CustomUtils.IIfElse.isRECEIVE()/*开通定单发起*/){
					fromUSER.setOFFER( new CarbonList<IOVUserOffer>() );
				}
				else{
					CarbonList<IOVUserOffer> fromOFFER = CustomFactory.getICustomSV().getIInsOfferByUserId( aUserId, aRegionId );
					fromUSER.setOFFER( fromOFFER != null? fromOFFER:new CarbonList<IOVUserOffer>() );
				}
				
			}
		}
		finally{
			
		}
		return fromUSER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOfferByInsOfferId(long, java.lang.String)
	 */
	public IOVUserOffer getSFUserOfferByInsOfferId(long aInsOfferId, String aRegionId) throws SFException, Exception {
		IOVUserOffer fromOffer = null;
		try
		{
			String _custom_offer_id_ = CustomUtils.ICatalog._custom_offer_id( aInsOfferId, aRegionId );
			IUpdfmxDirectory _offer_directory_ = UpfsvcManager.getSession().getIUpfxCustom( _custom_offer_id_ );
			if( _offer_directory_ != null ){
				fromOffer = (IOVUserOffer)_offer_directory_.getBottle();
			}
			else if( CustomUtils.IIfElse.isRECEIVE() == false/*非开通定单*/ ){
				fromOffer = CustomFactory.getICustomSV().getIInsOfferByInsOfferId( aInsOfferId, aRegionId );
				_offer_directory_ = new IUpdfmxDirectory( _custom_offer_id_, fromOffer );
				UpfsvcManager.getRocket().submitIUpfxCustom( _custom_offer_id_, _offer_directory_ );
			}
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOrderByUserId(long, java.lang.String)
	 */
	public IOVUser getSFUserOrderByUserId(long aUserId, String aRegionId) throws SFException, Exception {
		IOVUser fromUSER = null;
		try
		{
			fromUSER = getSFUserByUserId( aUserId, aRegionId );
			if( fromUSER != null && fromUSER.getORDER() == null ){
				if( CustomUtils.IIfElse.isRECEIVE()/*开通定单发起*/){
					fromUSER.setORDER( new CarbonList<IOVUserCentrex>() );
				}
				else{
					CarbonList<IOVUserCentrex> fromORDER = CustomFactory.getICustomSV().getIInsSrvpkgByUserId( aUserId, aRegionId );
					fromUSER.setORDER( fromORDER != null? fromORDER:new CarbonList<IOVUserCentrex>() );
				}
			}
		}
		finally{

		}
		return fromUSER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserGroupByUserId(long, java.lang.String)
	 */
	public IOVUser getSFUserGroupByUserId(long aUserId, String aRegionId) throws SFException, Exception {
		IOVUser fromUSER = null;
		try
		{
			fromUSER = getSFUserOrderByUserId( aUserId, aRegionId );
			if( fromUSER != null && fromUSER.getGROUP() == null ){
				if( CustomUtils.IIfElse.isRECEIVE()/*开通定单发起*/){
					fromUSER.setGROUP( new CarbonList<IOVUserOrderOffer>() );
				}
				else{
					CarbonList<IOVUserOrderOffer> fromGROUP = CustomFactory.getICustomSV().getIInsOffInsUserByUserId( aUserId, aRegionId );
					fromUSER.setGROUP( fromGROUP != null? fromGROUP:new CarbonList<IOVUserOrderOffer>() );
				}
				for( java.util.Iterator<IOVUserCentrex> itera = fromUSER.getORDER().iterator(); itera.hasNext(); ){
					IOVUserCentrex fromUserOrder = (IOVUserCentrex)itera.next();
					for( java.util.Iterator<IOVUserOrder> iterap = fromUserOrder.getCENTREX().iterator(); iterap.hasNext(); ){
						IOVUserOrder fromOrder = (IOVUserOrder)iterap.next();
						IOVUserOrderOffer fromGroup = fromUSER.getGROUP( fromOrder.getINS_OFFER_ID() );
						CustomUtils.ICustom._wrap( fromGroup, fromOrder );
					}
				}
			}
		}
		finally{
			
		}
		return fromUSER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUserCentrex getSFUserCentrex(IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUserCentrex fromUserOrder = null;
		try
		{
			IOVUser fromUSER = getSFUserOrderByUserId( fromMsgFUser.getUSER_ID(), fromMsgFUser.getUSER_REGION_ID() );
			if( fromUSER != null && fromUSER.getORDER() != null ){
				fromUserOrder = fromUSER.getORDER( fromMsgFOffer.getINS_PROD_ID() );
			}
		}
		finally{
			
		}
		return fromUserOrder;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOrder(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUserOrder getSFUserOrder(IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUserOrder fromOrder = null;
		try
		{
			IOVUserCentrex fromUserOrder = getSFUserCentrex(fromMsgFUser, fromMsgFOffer);
			if( fromUserOrder != null ){ fromOrder = fromUserOrder.getCENTREX( fromMsgFOffer.getSERVICE_ID() ); }
			if( fromOrder == null && CustomUtils.IIfElse.isRECEIVE() == false/*非开通定单发起[访问信息中心]*/){
				IOVUserCentrex fromCentrex = CustomFactory.getICustomSV().getIInsSrvpkgByInsSrvpkgId(fromMsgFUser.getUSER_ID(), 
						fromMsgFOffer.getINS_PROD_ID(), 
						fromMsgFUser.getUSER_REGION_ID() );
				if( fromCentrex != null ){ fromOrder = fromCentrex.getCENTREX( fromMsgFOffer.getSERVICE_ID() ); }
			}
			else if( fromOrder.getGROUP() == null && CustomUtils.IIfElse.isRECEIVE() == false/*非开通定单发起[访问信息中心]*/ ){
				IOVUserOrderOffer fromGroup = CustomFactory.getICustomSV().getIInsGrpOfferByInsOfferId(fromOrder.getINS_OFFER_ID(), 
						fromOrder.getUSER_ID(), 
						fromMsgFUser.getUSER_REGION_ID() );
				CustomUtils.ICustom._wrap( fromGroup, fromOrder );
			}
		}
		finally{
			
		}
		return fromOrder;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOrder(com.ai.sacenter.receive.expire.valuebean.IOVExpireUser, com.ai.sacenter.receive.expire.valuebean.IOVExpireOffer)
	 */
	public IOVUserOrder getSFUserOrder(IOVExpireUser fromExpUser, IOVExpireOffer fromExpOffer) throws RemoteException, Exception {
		IOVUserOrder fromOffer = null;
		try
		{
			IOVUser fromUser = getSFUserOrderByUserId(fromExpUser.getUSER_ID(), fromExpUser.getUSER_REGION_ID() );
			if( fromUser != null && fromUser.getORDER() != null ){
				IOVUserCentrex fromUserOrder = fromUser.getORDER( fromExpOffer.getINS_PROD_ID() );
				if( fromUserOrder != null && fromUserOrder.getCENTREX().size() > 0 ){
					fromOffer = fromUserOrder.getCENTREX( fromExpOffer.getSERVICE_ID() );
				}
			}
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFGroupOrderOffer(long, java.lang.String)
	 */
	public IOVUserOrderOffer getSFGroupOrderOffer(long aInsOfferId, String aRegionId) throws SFException, Exception {
		IOVUserOrderOffer fromGrpOrdOffer = null;
		try
		{
			String _custom_group_offer_id = CustomUtils.ICatalog._custom_group_offer_id(aInsOfferId, aRegionId);
			IUpdfmxDirectory _group_directory_ = UpfsvcManager.getSession().getIUpfxCustom( _custom_group_offer_id );
			if( _group_directory_ != null ){
				fromGrpOrdOffer = (IOVUserOrderOffer)_group_directory_.getBottle();
			}
			else if( CustomUtils.IIfElse.isRECEIVE() == false/*非开通定单发起*/ ) {
				fromGrpOrdOffer = CustomFactory.getICustomSV().getIInsGrpOfferByInsOfferId( aInsOfferId, aRegionId );
				_group_directory_ = new IUpdfmxDirectory( _custom_group_offer_id, fromGrpOrdOffer );
				UpfsvcManager.getRocket().submitIUpfxCustom( _custom_group_offer_id, _group_directory_ );
			}
		}
		finally{
			
		}
		return fromGrpOrdOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFOrderOffer(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUserOrderOffer getSFOrderOffer(IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUserOrderOffer fromOrderOffer = null;
		try
		{
			IOVUserOrder fromOffer = getSFUserOrder(fromMsgFUser, fromMsgFOffer);
			if( fromOffer != null && fromOffer.getGROUP() != null ){
				fromOrderOffer = fromOffer.getGROUP();
			}
			else if( fromOffer != null ){
				IOVUser fromUSER = getSFUserGroupByUserId( fromOffer.getUSER_ID(), fromMsgFUser.getUSER_REGION_ID() );
				fromOrderOffer = fromUSER.getGROUP( fromOffer.getINS_OFFER_ID() );
			}
		}
		finally{
			
		}
		return fromOrderOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFOfferUser(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUser getSFOfferUser(IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUser fromOfferUser = null;
		try
		{
			IOVUserOffer fromOrdOffer = getSFUserOffer(fromMsgFUser, fromMsgFOffer);
			if( fromOrdOffer != null ){
				fromOfferUser = getSFUserByUserId( fromOrdOffer.getUSER_ID(), fromOrdOffer.getREGION_ID() );
			}
		}
		finally{
			
		}
		return fromOfferUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFGroupUser(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUser getSFGroupUser(IOVMsgFUser fromMsgFUser, IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUser fromGroup = null;
		try
		{
			IOVUserOrderOffer fromOrdOffer = getSFOrderOffer(fromMsgFUser, fromMsgFOffer);
			if( fromOrdOffer != null ){
				String _group_user_id_ = CustomUtils.ICatalog._custom_group_user_id(fromOrdOffer.getINS_OFFER_ID(), fromOrdOffer.getGROUP_REGION_ID() );
				IUpdfmxDirectory _group_directory_ = UpfsvcManager.getSession().getIUpfxCustom( _group_user_id_ );
				if( _group_directory_ != null ){
					fromGroup = (IOVUser)_group_directory_.getBottle();
				}
				else if( CustomUtils.IIfElse.isRECEIVE() == false/*非开通定单发起*/ ){
					fromOrdOffer = CustomFactory.getICustomSV().getIInsGrpOfferByInsOfferId( fromOrdOffer.getINS_OFFER_ID(), fromOrdOffer.getGROUP_REGION_ID() );
					if( fromOrdOffer != null ){
						fromGroup = getSFUserByUserId( fromOrdOffer.getUSER_ID(), fromOrdOffer.getGROUP_REGION_ID() );
					}
					_group_directory_ = new IUpdfmxDirectory( _group_user_id_, fromGroup );
					UpfsvcManager.getRocket().submitIUpfxCustom( _group_user_id_, _group_directory_ );
				}
			}
		}
		finally{
			
		}
		return fromGroup;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOffer(com.ai.sacenter.receive.valuebean.IOVMsgFUser)
	 */
	public IOVUserOffer getSFUserOffer(IOVMsgFUser fromMsgFUser) throws SFException, Exception {
		IOVUserOffer fromUserOffer = null;
		try
		{
			MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
			IOVUser fromUser = getSFUserOfferByUserId( fromMsgFUser.getUSER_ID(), fromMsgFUser.getUSER_REGION_ID() );
			if( fromUser != null && fromUser.getOFFER() != null ){
				for( java.util.Iterator<IOVUserOffer> itera = fromUser.getOFFER().iterator(); itera.hasNext(); ){
					IOVUserOffer fromOffer = (IOVUserOffer)itera.next();
					if( fromOffer.isOfferPlan() && TimeUtils.middle( fromOffer.getEFFECTIVE(), 
							fromMBean.getCREATOR(), fromOffer.getEXPIRE() ) ){
						fromUserOffer = fromOffer;
						break;
					}
				}
			}
		}
		finally{
			
		}
		return fromUserOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFUserOffer(com.ai.sacenter.receive.valuebean.IOVMsgFUser, com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public IOVUserOffer getSFUserOffer(IOVMsgFUser fromMsgFUser,
			IOVMsgFOffer fromMsgFOffer) throws SFException, Exception {
		IOVUserOffer fromUserOffer = null;
		try
		{
			IOVUserOrderOffer fromOrdOffer = getSFOrderOffer(fromMsgFUser, fromMsgFOffer);
			if( fromOrdOffer != null ){
				fromUserOffer = getSFUserOfferByInsOfferId( fromOrdOffer.getINS_OFFER_ID(), 
						fromOrdOffer.getGROUP_REGION_ID() );
			}
		}
		finally{
			
		}
		return fromUserOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSRV#getSFCustom(long, java.lang.String, java.lang.String)
	 */
	public IOVCustom getSFCustom(long aCustomId, 
			String aCustomType,
			String aRegionId) throws SFException, Exception {
		IOVCustom fromCustom = null;
		try
		{
			String _custom_cust_id_ = CustomUtils.ICatalog._custom_cust_id(aCustomId, aCustomType);
			IUpdfmxDirectory _custom_directory_ = UpfsvcManager.getSession().getIUpfxCustom( _custom_cust_id_ );
			if( _custom_directory_ != null ){
				fromCustom = (IOVCustom)_custom_directory_.getBottle();
			}
			else if( CustomUtils.IIfElse.isRECEIVE() == false /*非开通定单发起*/){
				fromCustom = CustomFactory.getICustomSV().getICustom(aCustomId, aCustomType, aRegionId );
				_custom_directory_ = new IUpdfmxDirectory( _custom_cust_id_, fromCustom );
				UpfsvcManager.getRocket().submitIUpfxCustom( _custom_cust_id_, _custom_directory_ );
			}
		}
		finally{
			
		}
		return fromCustom;
	}
}
