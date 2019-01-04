package com.ai.sacenter.receive.teaminvoke.in.impl;

import java.rmi.RemoteException;

import com.ai.pce.ivalues.IItemValue;
import com.ai.pce.ivalues.IProductRelatServiceValue;
import com.ai.pce.ivalues.ISendFlagValue;
import com.ai.pce.ivalues.ISpServiceValue;
import com.ai.pce.ivalues.IUpItemFeatureValue;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.common.UpdcEclipseImpl;
import com.ai.sacenter.receive.OtherFactory;
import com.ai.sacenter.receive.teaminvoke.in.interfaces.IProductSV;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmItemHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmMiscHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmRelatHome;
import com.ai.sacenter.receive.teaminvoke.valuebean.IUpfgkmServiceHome;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.UpdcpUtils;
import com.ai.sacenter.valuebean.IProfessionalTemplate;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016Äê6ÔÂ19ÈÕ</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ProductSVImpl extends UpdcEclipseImpl implements IProductSV {
	public ProductSVImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IProductSV#getProductItemById(long)
	 */
	public IUpfgkmItemHome getProductItemById(long aProductId) throws RemoteException, Exception {
		IUpfgkmItemHome fromUpfgkmHome = null;
		try
		{
			IItemValue fromProdItem = null;
			fromUpfgkmHome = new IUpfgkmItemHome( aProductId );
			fromProdItem = OtherFactory.getIProductSV().getProductItemById( aProductId );
			if( fromProdItem != null ){
				fromUpfgkmHome.setOFFER( new IUpfgkmItemHome.IUpfgkmOfferHome( fromProdItem.getProductItemId() ) );
				fromUpfgkmHome.getOFFER().setPRODUCT_ID ( fromProdItem.getProductItemId() ); 
				fromUpfgkmHome.getOFFER().setNAME       ( fromProdItem.getName         () ); 
				fromUpfgkmHome.getOFFER().setCATEGORY   ( fromProdItem.getItemType     () ); 
				fromUpfgkmHome.getOFFER().setCOMPETE_ID ( fromProdItem.getCode         () ); 
				fromUpfgkmHome.getOFFER().setPRICE_ID   ( fromProdItem.getExtendId     () ); 
				fromUpfgkmHome.getOFFER().setPLAN_ID    ( fromProdItem.getChecker      () ); 
			}
		}
		finally{
			
		}
		return fromUpfgkmHome;
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IProductSV#getServiceByProdId(long)
	 */
	public IUpfgkmServiceHome getServiceByProdId(long aProductId) throws RemoteException, Exception {
		IUpfgkmServiceHome fromUpfgkmHome = null;
		try
		{
			IProductRelatServiceValue fromItemRel[] = null;
			fromItemRel = OtherFactory.getIProductSV().getServiceByProdId( aProductId );
			if( fromItemRel != null && fromItemRel.length > 0 ){
				fromUpfgkmHome = new IUpfgkmServiceHome( aProductId );
				fromUpfgkmHome.setOFFER( new IUpfgkmRelatHome() );
				fromUpfgkmHome.setSERVICE_ID                 ( fromItemRel[ fromItemRel.length - 1 ].getServiceId          () );
				fromUpfgkmHome.setPRODUCT_ID                 ( fromItemRel[ fromItemRel.length - 1 ].getProductId          () );
				fromUpfgkmHome.getOFFER().setPRODUCT_ID      ( fromItemRel[ fromItemRel.length - 1 ].getProductItemId      () );
				fromUpfgkmHome.getOFFER().setRELAT_PRODUCT_ID( fromItemRel[ fromItemRel.length - 1 ].getRelatProductItemId () );
				fromUpfgkmHome.getOFFER().setCATEGORY        ( fromItemRel[ fromItemRel.length - 1 ].getProdItemRelatKindId() );
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_A   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrA        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_B   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrB        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_C   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrC        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_D   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrD        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_E   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrE        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_F   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrF        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_G   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrG        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_H   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrH        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_I   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrI        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_J   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrJ        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_K   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrK        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_L   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrL        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_M   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrM        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_N   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrN        () );                       
				fromUpfgkmHome.getOFFER().setEXTEND_ATTR_O   ( fromItemRel[ fromItemRel.length - 1 ].getExtendAttrO        () );  
			}
		}
		finally{
			
		}
		return fromUpfgkmHome;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IProductSV#getUpSpInfoByProdId(long)
	 */
	public IUpfgkmMiscHome getUpSpInfoByProdId(long aProductId) throws RemoteException, Exception {
		IUpfgkmMiscHome fromUpfgkmHome = null;
		SFUpdbfxCustomImpl fromUpdbfxImpl = new SFUpdbfxCustomImpl();
		try
		{
			IProfessionalTemplate.IProductComptel fromSubject = null;
			fromUpfgkmHome = new IUpfgkmMiscHome( aProductId );
			fromSubject = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpSubject( String.valueOf( aProductId ) );
			IItemValue fromProdItem = OtherFactory.getIProductSV().getProductItemById( fromUpfgkmHome.getPRODUCT_ID() );
			ISpServiceValue fromSpHome = OtherFactory.getIProductSV().getSpServiceByProductId( aProductId );
			if( fromSpHome != null && fromProdItem != null ){
				fromUpfgkmHome.setOFFER( new java.util.ArrayList<IUpfgkmMiscHome.IUpfgkmOfferHome>() );
				fromUpdbfxImpl.finishSFUpfgkmMisc(fromSpHome,
						fromProdItem,
						fromSubject, 
						fromUpfgkmHome);
			}
			else if( fromProdItem != null && fromSubject != null && StringUtils.isBlank( 
					fromSubject.getEXTEND_ATTR_A() ) == false ){
				fromUpfgkmHome.setOFFER( new java.util.ArrayList<IUpfgkmMiscHome.IUpfgkmOfferHome>() );
				fromUpdbfxImpl.finishSFUpfgkmMisc(fromSubject,
						fromProdItem,
						fromUpfgkmHome);
			}
		}
		finally{
			if( fromUpdbfxImpl != null ){ fromUpdbfxImpl = null; }
		}
		return fromUpfgkmHome;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.teaminvoke.in.interfaces.IProductSV#getSpInfoByProdId(long)
	 */
	public IUpfgkmMiscHome getSpInfoByProdId(long aProductId) throws RemoteException, Exception {
		IUpfgkmMiscHome fromUpfgkmHome = null;
		SFUpdbfxCustomImpl fromUpdbfxImpl = new SFUpdbfxCustomImpl();
		try
		{
			IProfessionalTemplate.IProductComptel fromSubject = null;
			fromUpfgkmHome = new IUpfgkmMiscHome( aProductId );
			fromSubject = IUpdcfgFactory.getIUpdcpmSV().getSFUpdcpSubject( String.valueOf( aProductId ) );
			IItemValue fromProdItem = OtherFactory.getIProductSV().getProductItemById( fromUpfgkmHome.getPRODUCT_ID() );
			if( fromProdItem != null && fromSubject != null && StringUtils.isBlank( fromSubject.getEXTEND_ATTR_A() ) == false ){
				fromUpfgkmHome.setOFFER( new java.util.ArrayList<IUpfgkmMiscHome.IUpfgkmOfferHome>() );
				fromUpdbfxImpl.finishSFUpfgkmMisc(fromSubject, fromProdItem, fromUpfgkmHome);
			}
		}
		finally{
			if( fromUpdbfxImpl != null ){ fromUpdbfxImpl = null; }
		}
		return fromUpfgkmHome;
	}
	
}

class SFUpdbfxCustomImpl{
	public SFUpdbfxCustomImpl(){
		super();
	}
	
	/**
	 * 
	 * @param fromSpHome
	 * @param fromProdItem
	 * @param fromSubject
	 * @param fromUpfgkmHome
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmMisc( ISpServiceValue fromSpHome,
			IItemValue fromProdItem,
			IProfessionalTemplate.IProductComptel fromSubject,
			IUpfgkmMiscHome fromUpfgkmHome ) throws SFException,Exception{
		try
		{
			IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = new IUpfgkmMiscHome.IUpfgkmOfferHome();
			ISendFlagValue fromCscHome[] = OtherFactory.getIProductSV().getSendType( new long[]{ fromUpfgkmHome.getPRODUCT_ID() } );
			IUpItemFeatureValue fromSpFeature[] = OtherFactory.getIProductSV().getItemFeature( fromUpfgkmHome.getPRODUCT_ID() );
			fromOfferHome.setPRODUCT_ID( fromSpHome.getProdId                    () );
			fromOfferHome.setSPROM_ID  ( String.valueOf( fromProdItem.getExtendId()));
			fromOfferHome.setPRICE_ID  ( String.valueOf( fromProdItem.getExtendId()));
			fromOfferHome.setPLAN_ID   ( String.valueOf( fromProdItem.getChecker ()));
			fromOfferHome.setSPID      ( fromSpHome.getSpCode                    () );
			fromOfferHome.setBIZCODE   ( fromSpHome.getOperatorCode              () );
			fromOfferHome.setBILLFLG   ( String.valueOf( fromSpHome.getBillFlag() ) );
			fromOfferHome.setSERVTYPE  ( fromSpHome.getServType                  () );
			fromOfferHome.setPLATFLG   ( "G"                                        );
			if( fromSubject != null && StringUtils.isBlank( fromSubject.getEXTEND_ATTR_F() ) == false ){
				fromOfferHome.setPLATFLG( fromSubject.getEXTEND_ATTR_F  () );
			}
			fromOfferHome.setPRODFLG   ( "L"                                        );
			for( int index = 0; fromSpFeature != null && index < fromSpFeature.length; index++ ){
				if( fromSpFeature[index].getFeatureId() == 100081){
					fromOfferHome.setPRODFLG( StringUtils.equals( fromSpFeature[index].getFeatureValue(), "1")?"P":"L");
				}
			}
			fromOfferHome.setGLOBAL   ( fromCscHome != null && fromCscHome.length > 0 
					&& fromCscHome[0].getSendFlag() == 0?"L":"G");
			fromUpfgkmHome.getOFFER().add( fromOfferHome );
		}
		finally{
			
		}
	}

	/**
	 * 
	 * @param fromSubject
	 * @param fromProdItem
	 * @param fromUpfgkmHome
	 * @throws SFException
	 * @throws Exception
	 */
	public void finishSFUpfgkmMisc( IProfessionalTemplate.IProductComptel fromSubject, 
			IItemValue fromProdItem,
			IUpfgkmMiscHome fromUpfgkmHome ) throws SFException,Exception{
		java.util.Map<String,String> fromBatchX[] = null;
		java.util.Map<String,String> fromOffer = new java.util.HashMap<String,String>();
		try
		{
			ClassUtils.IMerge.merge( new Object[][]{{"SPID", fromSubject.getEXTEND_ATTR_A()},
				{"BIZCODE" , fromSubject.getEXTEND_ATTR_B()},
				{"BILLFLG" , fromSubject.getEXTEND_ATTR_C()},
				{"GLOBAL"  , fromSubject.getEXTEND_ATTR_C()},
				{"PRODFLG" , fromSubject.getEXTEND_ATTR_E()},
				{"PLATFLG" , fromSubject.getEXTEND_ATTR_F()},
				{"SERVTYPE", fromSubject.getEXTEND_ATTR_G()}}, fromOffer, true );
			fromBatchX = UpdcpUtils.ICustom.batchx(fromOffer, 
					"SPID=SPID;BIZCODE=BIZCODE;BILLFLG=BILLFLG;PRODFLG=PRODFLG;PLATFLG=PLATFLG;GLOBAL=GLOBAL", 
					true, 
					fromOffer);
			for( int index = 0; fromBatchX != null && index < fromBatchX.length; index++ ){
				IUpfgkmMiscHome.IUpfgkmOfferHome fromOfferHome = new IUpfgkmMiscHome.IUpfgkmOfferHome();
				ClassUtils.IClass.transfer(fromBatchX[index], fromOfferHome );
				fromOfferHome.setPRODUCT_ID( fromProdItem.getProductItemId           () );
				fromOfferHome.setSPROM_ID  ( String.valueOf( fromProdItem.getExtendId()));
				fromOfferHome.setPRICE_ID  ( String.valueOf( fromProdItem.getExtendId()));
				fromOfferHome.setPLAN_ID   ( String.valueOf( fromProdItem.getChecker ()));
				fromUpfgkmHome.getOFFER().add( fromOfferHome );
			}
		}
		finally{
			if( fromOffer != null ){ fromOffer.clear(); fromOffer = null; }
			if( fromBatchX != null ){ fromBatchX = null; }
		}
	}
}
