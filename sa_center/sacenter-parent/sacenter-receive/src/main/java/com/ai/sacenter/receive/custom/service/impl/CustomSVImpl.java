package com.ai.sacenter.receive.custom.service.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.SFException;
import com.ai.sacenter.common.MBeanDelegate;
import com.ai.sacenter.common.UpfsvcManager;
import com.ai.sacenter.receive.custom.CustomFactory;
import com.ai.sacenter.receive.custom.ICustomConst;
import com.ai.sacenter.receive.custom.bo.CmFamilyCust;
import com.ai.sacenter.receive.custom.bo.CmIndivCust;
import com.ai.sacenter.receive.custom.bo.CmVpmnCust;
import com.ai.sacenter.receive.custom.bo.InsOffer;
import com.ai.sacenter.receive.custom.bo.InsOfferInsUser;
import com.ai.sacenter.receive.custom.bo.InsProd;
import com.ai.sacenter.receive.custom.bo.InsProdInsSrv;
import com.ai.sacenter.receive.custom.bo.InsSrvAttr;
import com.ai.sacenter.receive.custom.bo.InsUser;
import com.ai.sacenter.receive.custom.bo.InsUserOsState;
import com.ai.sacenter.receive.custom.group.bo.CmGroupCust;
import com.ai.sacenter.receive.custom.service.interfaces.ICustomSV;
import com.ai.sacenter.receive.custom.valuebean.IOVCustom;
import com.ai.sacenter.receive.custom.valuebean.IOVUser;
import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrderOffer;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.util.CarbonList;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.TimeUtils;

public class CustomSVImpl implements ICustomSV {
	public CustomSVImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsUserByUserId(long, java.lang.String)
	 */
	public IOVUser getIInsUserByUserId(long aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		IOVUser fromUser = null;
		try
		{
			class SFUserLoaderImpl{
				public SFUserLoaderImpl(){
					super();
				}
				/**
				 * 
				 * @param fromUser
				 * @param fromOffer
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVUserOrderOffer getSFUserGroupByInsOfferId( IOVUser fromUser, 
						IOVUserOrder fromOffer ) throws SFException, Exception{
					IOVUserOrderOffer fromOrdOff = null;
					try
					{
						InsOfferInsUser fromInsOffUser = null;
						fromOrdOff = fromUser.getGROUP( fromOffer.getINS_OFFER_ID() );
						if( fromOrdOff == null ){
							fromInsOffUser = CustomFactory.getICustomDAO().getInsOffInsUserByInsOfferId(fromOffer.getINS_OFFER_ID(), 
									fromOffer.getUSER_ID(), fromUser.getREGION_ID() );
							if( fromInsOffUser != null ){
								fromOrdOff = CustomUtils.ICustom._wrap( fromInsOffUser );
							}
						}
					}
					finally{
						
					}
					return fromOrdOff;
				}
				/**
				 * 
				 * @param fromUser
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserOffer( IOVUser fromUser ) throws SFException,Exception{
					try
					{
						MBeanDelegate fromMBean = UpfsvcManager.getMBean().getQuality();
						CarbonList<IOVUserOffer> fromGROUP = getIInsOfferByUserId(fromUser.getUSER_ID(), fromUser.getREGION_ID() );
						fromUser.setOFFER( fromGROUP != null?fromGROUP:new CarbonList<IOVUserOffer>() );
						for( java.util.Iterator<IOVUserOffer> itera = fromUser.getOFFER().iterator(); itera.hasNext(); ){
							IOVUserOffer fromOffer = (IOVUserOffer)itera.next();
							if( fromOffer.isOfferPlan() && TimeUtils.middle( fromOffer.getEFFECTIVE(), 
									fromMBean.getCREATOR(), fromOffer.getEXPIRE() ) ){
								fromUser.setBRAND_ID( fromOffer.getBRAND_ID() );
								break;
							}
						}
					}
					finally{
						
					}
				}
				/**
				 * 
				 * @param fromUser
				 * @throws SFException
				 * @throws Exception
				 */
				public void finishSFUserOrder( IOVUser fromUser ) throws SFException,Exception{
					try
					{
						CarbonList<IOVUserOrderOffer> fromGROUP = getIInsOffInsUserByUserId(fromUser.getUSER_ID(), fromUser.getREGION_ID() );
						fromUser.setGROUP( fromGROUP != null?fromGROUP:new CarbonList<IOVUserOrderOffer>() );
						CarbonList<IOVUserCentrex> fromDeque = getIInsSrvpkgByUserId(fromUser.getUSER_ID(), fromUser.getREGION_ID() );
						fromUser.setORDER( fromDeque != null? fromDeque:new CarbonList<IOVUserCentrex>() );
						for( java.util.Iterator<IOVUserCentrex> itera = fromUser.getORDER().iterator(); itera.hasNext(); ){
							IOVUserCentrex fromCarbon = (IOVUserCentrex)itera.next();
							for( java.util.Iterator<IOVUserOrder> iterap = fromCarbon.getCENTREX().iterator(); iterap.hasNext(); ){
								IOVUserOrder fromOrder = (IOVUserOrder)iterap.next();
								IOVUserOrderOffer fromGroup = getSFUserGroupByInsOfferId(fromUser, fromOrder);
								CustomUtils.ICustom._wrap( fromGroup, fromOrder );
							}
						}
					}
					finally{
						
					}
				}
			}
			SFUserLoaderImpl fromUserImpl =  new SFUserLoaderImpl();
			try
			{
				InsUser _insUser = CustomFactory.getICustomDAO().getIInsUserByUserId(aUSER_ID, aREGION_ID);
				if( _insUser != null ){
					InsUserOsState _insOsState = CustomFactory.getICustomDAO().getIInsUserOsStateByUserId(aUSER_ID, aREGION_ID);
					fromUser = CustomUtils.ICustom._wrap( _insUser, _insOsState );
					fromUserImpl.finishSFUserOffer( fromUser );
					fromUserImpl.finishSFUserOrder( fromUser );
				}
			}
			finally{
				if( fromUserImpl != null ){ fromUserImpl = null; }
			}
		
		}
		finally{
			
		}
		return fromUser;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsUserByUserId(long[], java.lang.String)
	 */
	public IOVUser[] getIInsUserByUserId(long[] aUserId, String aRegionId) throws RemoteException, Exception {
		IOVUser fromUser[] = null;
		java.util.Map<Long,InsUserOsState> fromINDEX = new java.util.HashMap<Long,InsUserOsState>();
		try
		{
			InsUserOsState fromInsUserOsState[] = null;
			InsUser fromInsUser[] = CustomFactory.getICustomDAO().getIInsUserByUserId(aUserId, aRegionId);
			fromInsUserOsState = CustomFactory.getICustomDAO().getIInsUserOsStateByUserId(aUserId, aRegionId);
			if( fromInsUser != null && fromInsUser.length > 0 ){
				for( int index = 0; fromInsUserOsState != null && index < fromInsUserOsState.length; index++ ){
					fromINDEX.put( new Long( fromInsUserOsState[index].getUserId() ), fromInsUserOsState[index] );
				}
				fromUser = new IOVUser[ fromInsUser.length ];
				for( int index = 0; fromInsUser != null && index < fromInsUser.length; index++ ){
					InsUserOsState aInsUserOsState = (InsUserOsState)fromINDEX.get( new Long( fromInsUser[index].getUserId() ) );
					fromUser[index] = CustomUtils.ICustom._wrap(fromInsUser[index], aInsUserOsState);
				}
			}
		}
		finally{
			if( fromINDEX != null ){ fromINDEX.clear(); fromINDEX = null; }
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsSrvpkgByUserId(long, java.lang.String)
	 */
	public CarbonList<IOVUserCentrex> getIInsSrvpkgByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		CarbonList<IOVUserCentrex> fromORDER = new CarbonList<IOVUserCentrex>();
		try
		{
			class SFUserLoaderImpl{
				public SFUserLoaderImpl(){
					super();
				}
				/**
				 * 
				 * @param aUserId
				 * @param aRegionId
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public SFUserOffer getSFInsSrvpkgByUserId( long aUserId, String aRegionId ) throws SFException,Exception{
					SFUserOffer fromOffer = new SFUserOffer();
					try
					{
						fromOffer.compete = CustomFactory.getICustomDAO().getIInsSrvByUserId( aUserId, aRegionId );
						if( fromOffer.compete != null && fromOffer.compete.length > 0 ){
							fromOffer.product = CustomFactory.getICustomDAO().getIInsSrvpkgByUserId( aUserId, aRegionId );
							fromOffer.attribute = CustomFactory.getICustomDAO().getIInsSrvAttrByUserId( aUserId, aRegionId );
						}
					}
					finally{
						
					}
					return fromOffer;
				}
				/**
				 * 
				 * @param fromUserOffer
				 * @param aInsSrv
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public InsProd getIInsSrvpkgByInsSrvpkgId(SFUserOffer fromUserOffer, 
						InsProdInsSrv aInsSrv ) throws SFException,Exception{
					InsProd fromInsSrvpkg = null;
					try
					{
						for( int index = 0; fromUserOffer.product != null && index < fromUserOffer.product.length; index++ ){
							if( fromUserOffer.product[index].getProdInstId() == aInsSrv.getProdInstId() ){
								fromInsSrvpkg = fromUserOffer.product[index];
							}
						}
						if( fromInsSrvpkg == null ){
							fromInsSrvpkg = CustomFactory.getICustomDAO().getIInsSrvpkgByInsSrvpkgId(aInsSrv.getUserId(), 
									aInsSrv.getProdInstId(), 
									aInsSrv.getRegionId() );
						}
					}
					finally{
						
					}
					return fromInsSrvpkg;
				}
				/**
				 * 
				 * @param fromUser
				 * @param fromUserOffer
				 * @param aInsSrv
				 * @return
				 * @throws SFException
				 * @throws Exception
				 */
				public InsSrvAttr[] getIInsSrvAttrByInsSrvId( SFUserOffer fromUserOffer, 
						InsProdInsSrv aInsSrv ) throws SFException,Exception{
					java.util.List<InsSrvAttr> fromArray = new java.util.ArrayList<InsSrvAttr>();
					try
					{
						for( int index = 0; fromUserOffer.attribute != null && index < fromUserOffer.attribute.length; index++ ){
							if( fromUserOffer.attribute[index].getProdSrvRelatId() == aInsSrv.getProdSrvRelatId() ){
								fromArray.add( fromUserOffer.attribute[index] );
							}
						}
					}
					finally{
						
					}
					return (InsSrvAttr[])fromArray.toArray( new InsSrvAttr[]{} );
				}
				class SFUserOffer{
					InsProdInsSrv compete[];
					InsProd product[];
					InsSrvAttr attribute[];
					public SFUserOffer(){
						super();
					}
				}
			}
			SFUserLoaderImpl fromUserImpl = new SFUserLoaderImpl();
			SFUserLoaderImpl.SFUserOffer fromUserGroup = null;
			try
			{
				IOVUserOrder fromOrder = null;
				IOVUserOrderOffer fromOrdOffer = null;
				fromUserGroup = fromUserImpl.getSFInsSrvpkgByUserId( aUserId, aRegionId );
				for( int index = 0; fromUserGroup.compete != null && index < fromUserGroup.compete.length; index++ ){
					InsProd fromInsSrvpkg = fromUserImpl.getIInsSrvpkgByInsSrvpkgId( fromUserGroup,
							fromUserGroup.compete[index] );
					if( fromInsSrvpkg == null ) continue;
					InsSrvAttr fromInsSrvAttr[] = fromUserImpl.getIInsSrvAttrByInsSrvId(fromUserGroup,
							fromUserGroup.compete[index] );
					fromOrder = CustomUtils.ICustom._wrap(fromOrdOffer,
							fromUserGroup.compete[index], 
							fromInsSrvpkg, 
							fromInsSrvAttr);
					IOVUserCentrex fromCentrex = (IOVUserCentrex)fromORDER.get( fromOrder );
					if( fromCentrex == null ){ fromORDER.add( fromCentrex = new IOVUserCentrex( fromOrder ) ); }
					fromCentrex.getCENTREX().add( fromOrder );
				}
			}
			finally{
				if( fromUserGroup != null ){ fromUserGroup = null; }
				if( fromUserImpl != null ){ fromUserImpl = null; }
			}
		}
		finally{
			
		}
		return fromORDER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsSrvpkgByInsSrvpkgId(long, long, java.lang.String)
	 */
	public IOVUserCentrex getIInsSrvpkgByInsSrvpkgId(long aUserId, long aInsSrvpkgId, String aRegionId) throws RemoteException, Exception {
		IOVUserCentrex fromUserOrder = null;
		try
		{
			InsProd fromInsProd = null;
			InsProdInsSrv fromInsSrv[] = CustomFactory.getICustomDAO().getIInsSrvByInsSrvpkgId(aUserId, 
					aInsSrvpkgId, 
					aRegionId );
			if( fromInsSrv != null && fromInsSrv.length > 0 ){
				fromInsProd = CustomFactory.getICustomDAO().getIInsSrvpkgByInsSrvpkgId( aUserId,
						aInsSrvpkgId, 
						aRegionId );
			}
			if( fromInsSrv != null && fromInsSrv.length > 0 && fromInsProd != null  ){
				fromUserOrder = new IOVUserCentrex( fromInsProd );
				IOVUserOrderOffer fromOrdOff = this.getIInsGrpOfferByInsOfferId(fromInsProd.getOfferInstId(), 
						fromInsProd.getUserId(), 
						fromInsProd.getRegionId() );
				for( int index = 0; fromInsSrv != null && index < fromInsSrv.length; index++ ){
					InsSrvAttr fromInsSrvAttr[] = CustomFactory.getICustomDAO().getIInsSrvAttrByProdSrvRelatId(fromInsSrv[index].getUserId(), 
							fromInsSrv[index].getProdSrvRelatId(), 
							fromInsSrv[index].getRegionId() );
					IOVUserOrder fromOrder = CustomUtils.ICustom._wrap(fromOrdOff, 
							fromInsSrv[index], 
							fromInsProd, 
							fromInsSrvAttr );
					fromUserOrder.getCENTREX().add( fromOrder );
				}
			}
		}
		finally{
			
		}
		return fromUserOrder;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsOffInsUserByUserId(long, java.lang.String)
	 */
	public CarbonList<IOVUserOrderOffer> getIInsOffInsUserByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		CarbonList<IOVUserOrderOffer> fromGROUP = new CarbonList<IOVUserOrderOffer>();
		try
		{
			InsOfferInsUser fromUserOffer[] = CustomFactory.getICustomDAO().getInsOffInsUserByUserId(aUserId, aRegionId);
			for( int index = 0; fromUserOffer != null && index < fromUserOffer.length; index++ ){
				IOVUserOrderOffer fromGroup = CustomUtils.ICustom._wrap( fromUserOffer[index] );
				fromGROUP.add( fromGroup );
			}
		}
		finally{
			
		}
		return fromGROUP;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsOfferByUserId(long, java.lang.String)
	 */
	public CarbonList<IOVUserOffer> getIInsOfferByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		CarbonList<IOVUserOffer> fromOFFER = new CarbonList<IOVUserOffer>();
		try
		{
			InsOffer fromInsOffer[] = null;
			fromInsOffer = CustomFactory.getICustomDAO().getIInsOfferByUserId(aUserId, aRegionId);
			for( int index = 0; fromInsOffer != null && index < fromInsOffer.length; index++ ){
				IOVUserOffer fromOffer = CustomUtils.ICustom._wrap( fromInsOffer[index] );
				fromOFFER.add( fromOffer );
			}
		}
		finally{
			
		}
		return fromOFFER;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsOfferByInsOfferId(long, java.lang.String)
	 */
	public IOVUserOffer getIInsOfferByInsOfferId(long aInsOfferId, String aRegionId) throws RemoteException, Exception {
		IOVUserOffer fromOffer = null;
		try
		{
			InsOffer aInsOffer = CustomFactory.getICustomDAO().getIInsOfferByInsOfferId(aInsOfferId, aRegionId);
			if( aInsOffer != null ){ 
				fromOffer = CustomUtils.ICustom._wrap( aInsOffer ); 
			}
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsGrpOfferByInsOfferId(long, java.lang.String)
	 */
	public IOVUserOrderOffer getIInsGrpOfferByInsOfferId(long aInsOfferId, String aRegionId) throws SFException, Exception {
		IOVUserOrderOffer fromOffer = null;
		try
		{
			InsOfferInsUser fromOfferUser = null;
			fromOfferUser = CustomFactory.getICustomDAO().getInsOffInsUserByInsOfferId(aInsOfferId, 
					ICustomConst.IOffer.NOT_MAIN_OFFER, 
					ICustomConst.IOffer.IS_GRP_MAIN_USER, 
					aRegionId);
			if( fromOfferUser == null ){
				fromOfferUser = CustomFactory.getICustomDAO().getInsOffInsUserByInsOfferId(aInsOfferId, 
						ICustomConst.IOffer.IS_MAIN_OFFER, 
						ICustomConst.IOffer.IS_GRP_MAIN_USER, 
						aRegionId);
			}
			if( fromOfferUser != null ){ fromOffer = CustomUtils.ICustom._wrap( fromOfferUser ); }
		}
		finally{
			
		}
		return fromOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getIInsGrpOfferByInsOfferId(long, long, java.lang.String)
	 */
	public IOVUserOrderOffer getIInsGrpOfferByInsOfferId(long aInsOfferId, long aUserId, String aRegionId) throws RemoteException, Exception {
		IOVUserOrderOffer fromOrdOff = null;
		try
		{
			InsOfferInsUser fromInsOffUser = null;
			fromInsOffUser = CustomFactory.getICustomDAO().getInsOffInsUserByInsOfferId(aInsOfferId, 
					aUserId, aRegionId );
			if( fromInsOffUser != null ){
				fromOrdOff = CustomUtils.ICustom._wrap( fromInsOffUser );
			}
		}
		finally{
			
		}
		return fromOrdOff;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.service.interfaces.ICustomSV#getICustom(long, java.lang.String, java.lang.String)
	 */
	public IOVCustom getICustom(long aCUSTOM_ID, 
			String aCUSTOM_TYPE, 
			String aREGION_ID) throws RemoteException, Exception {
		IOVCustom fromCustom = null;
		try
		{
			class SFCustomImpl{
				public SFCustomImpl(){
					super();
				}
				/**
				 * 
				 * @param aCUSTOM_ID
				 * @param aREGION_ID
				 * @param fromCustom
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVCustom finishIIndiviCustom(long aCUSTOM_ID, 
						String aCUSTOM_TYPE,
						String aREGION_ID) throws SFException,Exception{
					IOVCustom fromCustom = null;
					try
					{
						CmIndivCust fromCust = CustomFactory.getICustomDAO().
								getCmIndivCust(aCUSTOM_ID, aREGION_ID);
						if(fromCust != null){
							fromCustom = new IOVCustom(aCUSTOM_ID, aCUSTOM_TYPE, aREGION_ID);
							fromCustom.setGROUP_ID(String.valueOf(fromCust.getIndivCustId()));
							fromCustom.setCUST_NAME(fromCust.getCustName());
							String custAddress = fromCust.getCustAddress();
							if( custAddress != null && custAddress.indexOf("~") != -1 ){
								custAddress = String.valueOf( fromCust.getOldObj( 
										CmIndivCust.S_CustAddress ) );
							}
							fromCustom.setCOUNTRY_CODE(fromCust.getCountyId());
							fromCustom.setREGION_ID( fromCust.getRegionId() );
						}
					}
					finally{
						
					}
					return fromCustom;
				}
				/**
				 * 
				 * @param aCUSTOM_ID
				 * @param aREGION_ID
				 * @param fromCustom
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVCustom finishIFamilyCustom(long aCUSTOM_ID, 
						String aCUSTOM_TYPE,
						String aREGION_ID ) throws SFException,Exception{
					IOVCustom fromCustom = null;
					try
					{
						CmFamilyCust fromCmFamilyCust = CustomFactory.getICustomDAO().
								getFamilyCust(aCUSTOM_ID, aREGION_ID);
						if(fromCmFamilyCust!=null){
							fromCustom = new IOVCustom(aCUSTOM_ID, aCUSTOM_TYPE, aREGION_ID);
							fromCustom.setCUST_NAME( String.valueOf(fromCmFamilyCust.getOldObj( 
									CmFamilyCust.S_CustName ) ) );
							String custAddress = fromCmFamilyCust.getCustAddress();
							if( custAddress != null && custAddress.indexOf("~") != -1 ){
								custAddress = String.valueOf( fromCmFamilyCust.getOldObj( 
										CmFamilyCust.S_CustAddress ) );
							}
							fromCustom.setCUST_ADDRESS(custAddress);
							fromCustom.setCUST_LEVEL(String.valueOf(fromCmFamilyCust.getCustLevel()));
						}
					}
					finally{
						
					}
					return fromCustom;
				}
				/**
				 * 
				 * @param aCUSTOM_ID
				 * @param aREGION_ID
				 * @param fromCustom
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVCustom finishIVpmnCustom(long aCUSTOM_ID,
						String aCUSTOM_TYPE,
						String aREGION_ID) throws SFException,Exception{
					IOVCustom fromCustom = null;
					try
					{
						CmVpmnCust fromCmVpmnCust = CustomFactory.getICustomDAO().
								getVpmnCust(aCUSTOM_ID, aREGION_ID);
						if(fromCmVpmnCust!=null){
							fromCustom = new IOVCustom(aCUSTOM_ID, aCUSTOM_TYPE, aREGION_ID);
							fromCustom.setCUST_NAME(String.valueOf(fromCmVpmnCust.getOldObj(CmGroupCust.S_CustName)) );
							fromCustom.setGROUP_ID(String.valueOf( fromCmVpmnCust.getGroupId() ) );
							fromCustom.setGROUP_TYPE( String.valueOf( fromCmVpmnCust.getGroupType() ) );
							String custAddress = fromCmVpmnCust.getCustAddress();
							if(custAddress !=null && custAddress.indexOf("~")!=-1){
								custAddress=String.valueOf(fromCmVpmnCust.getOldObj(CmVpmnCust.S_CustAddress));
							}
							fromCustom.setCUST_ADDRESS(custAddress);
							fromCustom.setCONTACT_NAME (fromCmVpmnCust.getContact   () );//联系人
							fromCustom.setCONTACT_PHONE(fromCmVpmnCust.getPhone     () );//联系号码
							fromCustom.setCUST_CODE    ( String.valueOf(fromCmVpmnCust.getRgroupId()) );
						}
					}
					finally{
						
					}
					return fromCustom;
				}
				/**
				 * 
				 * @param aCUSTOM_ID
				 * @param aREGION_ID
				 * @param fromCustom
				 * @throws SFException
				 * @throws Exception
				 */
				public IOVCustom finishIGroupCustom(long aCUSTOM_ID,
						String aCUSTOM_TYPE,
						String aREGION_ID ) throws SFException,Exception{
					IOVCustom fromCustom = null;
					try
					{	
						CmGroupCust fromCmGroupCust = CustomFactory.getIGroupDAO().getGroupCust(aCUSTOM_ID, aREGION_ID);
						if(fromCmGroupCust!=null){
							fromCustom = new IOVCustom(aCUSTOM_ID, aCUSTOM_TYPE, aREGION_ID);
							fromCustom.setCUST_NAME( String.valueOf( fromCmGroupCust.getOldObj(CmGroupCust.S_CustName)) );
							fromCustom.setGROUP_ID ( String.valueOf( fromCmGroupCust.getGroupId() ) );
							String custAddress = fromCmGroupCust.getCustAddress();
							if(custAddress !=null && custAddress.indexOf("~")!=-1){
								custAddress=String.valueOf(fromCmGroupCust.getOldObj(CmGroupCust.S_CustAddress));
							}
							fromCustom.setCUST_ADDRESS(custAddress);
							fromCustom.setCUST_LEVEL(String.valueOf(fromCmGroupCust.getCustLevel()));
						}
					}
					finally{
						
					}
					return fromCustom;
				}
			}
			SFCustomImpl fromCustomImpl = new SFCustomImpl();
			try
			{
				if( StringUtils.equals(aCUSTOM_TYPE, 
						ICustomConst.ICustType.INDIVIDUAL)/*个人客户*/ ){
					fromCustom =fromCustomImpl.finishIIndiviCustom(aCUSTOM_ID,
							aCUSTOM_TYPE,
							aREGION_ID);
				}
				else if( StringUtils.equals(aCUSTOM_TYPE, 
						ICustomConst.ICustType.FAMILY)/*家庭客户*/ ){
					fromCustom = fromCustomImpl.finishIFamilyCustom(aCUSTOM_ID,
							aCUSTOM_TYPE,
							aREGION_ID);
				}
				else if( StringUtils.equals(aCUSTOM_TYPE, 
						ICustomConst.ICustType.VPMN)/*虚拟网客户*/ ){
					fromCustom = fromCustomImpl.finishIVpmnCustom(aCUSTOM_ID,
							aCUSTOM_TYPE,
							aREGION_ID);
				}
				else if( StringUtils.equals(aCUSTOM_TYPE, 
						ICustomConst.ICustType.GROUP)/*集团客户*/ ){
					fromCustom = fromCustomImpl.finishIGroupCustom(aCUSTOM_ID,
								aCUSTOM_TYPE,
								aREGION_ID);
				}
			}
			finally{
				if( fromCustomImpl != null ){ fromCustomImpl = null;}
			}
		}
		finally{
			
		}
		return fromCustom;
	}
}
