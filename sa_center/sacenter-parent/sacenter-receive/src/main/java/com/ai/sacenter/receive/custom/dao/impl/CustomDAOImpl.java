package com.ai.sacenter.receive.custom.dao.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.receive.IUpdbfsConst;
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
import com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO;
import com.ai.sacenter.receive.custom.dbcp.ICustomDAOImpl;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;

public class CustomDAOImpl extends ICustomDAOImpl implements ICustomDAO {

	public CustomDAOImpl(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsUserByUserId(long, java.lang.String)
	 */
	public InsUser getIInsUserByUserId(long aUSER_ID, 
			String aREGION_ID) throws RemoteException, Exception {
		InsUser fromInsUser[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( " and ").append( CustomUtils.ICustom.getSqlSysdate() )
			       .append( " between EFFECTIVE_DATE and EXPIRE_DATE ");
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromInsUser = (InsUser[])retrieve(InsUser.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsUser != null && fromInsUser.length > 0?fromInsUser[0]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsUserByUserId(long[], java.lang.String)
	 */
	public InsUser[] getIInsUserByUserId(long[] aUSER_ID, String aREGION_ID) throws RemoteException, Exception {
		InsUser fromUser[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.List<String> fromNAME = new java.util.ArrayList<String>();
		try
		{
			for( int index = 0; aUSER_ID != null && index < aUSER_ID.length; index++ ){
				String fromKEY = ClassUtils.getINDEX( new String[]{"p_USER_ID_", 
						String.valueOf( index ) });
				fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromKEY } ) );
				fromPARAM.put( fromKEY, new Long( aUSER_ID[index] ) );
			}
			fromPARAM.put( "REGION_ID", aREGION_ID );
			fromSQL.append(" USER_ID in ( ")
			       .append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) and ").append( CustomUtils.ICustom.getSqlSysdate() )
			       .append("  between EFFECTIVE_DATE and EXPIRE_DATE " );
			fromUser = (InsUser[])retrieve(InsUser.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsUserOsStateByUserId(long, java.lang.String)
	 */
	public InsUserOsState getIInsUserOsStateByUserId(long aUSER_ID,
			String aREGION_ID) throws RemoteException, Exception {
		InsUserOsState fromUserOsState[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( " and ").append( CustomUtils.ICustom.getSqlSysdate() )
			       .append( " between EFFECTIVE_DATE and EXPIRE_DATE ");
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromUserOsState = (InsUserOsState[])retrieve(InsUserOsState.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromUserOsState != null && fromUserOsState.length > 0?fromUserOsState[fromUserOsState.length - 1]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsUserOsStateByUserId(long[], java.lang.String)
	 */
	public InsUserOsState[] getIInsUserOsStateByUserId(long[] aUSER_ID,
			String aREGION_ID) throws RemoteException, Exception {
		InsUserOsState fromUser[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		java.util.List<String> fromNAME = new java.util.ArrayList<String>();
		try
		{
			for( int index = 0; aUSER_ID != null && index < aUSER_ID.length; index++ ){
				String fromKEY = ClassUtils.getINDEX( new String[]{"p_USER_ID_", 
						String.valueOf( index ) });
				fromNAME.add( ClassUtils.getINDEX( new String[]{ ":", fromKEY } ) );
				fromPARAM.put( fromKEY, new Long( aUSER_ID[index] ) );
			}
			fromPARAM.put( "REGION_ID", aREGION_ID );
			fromSQL.append(" USER_ID in ( ")
			       .append( StringUtils.join( fromNAME.iterator(), " , " ) )
			       .append(" ) and ").append( CustomUtils.ICustom.getSqlSysdate() )
			       .append("  between EFFECTIVE_DATE and EXPIRE_DATE " );
			fromUser = (InsUserOsState[])retrieve(InsUserOsState.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromNAME != null ){ fromNAME.clear(); fromNAME = null; }
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
			if( fromSQL != null ){ fromSQL = null; }
		}
		return fromUser;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsOfferByUserId(long, java.lang.String)
	 */
	public InsOffer[] getIInsOfferByUserId(long aUSER_ID, 
			String aREGION_ID) throws RemoteException, Exception {
		InsOffer fromInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromInsOffer = (InsOffer[])retrieve(InsOffer.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsOffer;
	}
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsOfferByInsOfferId(long, java.lang.String)
	 */
	public InsOffer getIInsOfferByInsOfferId(long aInsOfferId,
			String aREGION_ID) throws RemoteException, Exception {
		InsOffer aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" OFFER_INST_ID = :p_OFFER_INST_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_NOW ) );
			fromPARAM.put("p_OFFER_INST_ID", new Long( aInsOfferId ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			aInsOffer = (InsOffer[])retrieve(InsOffer.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer != null && aInsOffer.length > 0?aInsOffer[aInsOffer.length - 1]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getInsOffInsUserByUserId(long, java.lang.String)
	 */
	public InsOfferInsUser[] getInsOffInsUserByUserId(long aUSER_ID,
			String aREGION_ID) throws RemoteException, Exception {
		InsOfferInsUser fromInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_USER_ID", new Long( aUSER_ID ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromInsOffer = (InsOfferInsUser[])retrieve(InsOfferInsUser.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getInsOffInsUserByInsOfferId(long, long, java.lang.String)
	 */
	public InsOfferInsUser getInsOffInsUserByInsOfferId(long aInsOfferId, long aUserId, String aRegionId) throws RemoteException, Exception {
		InsOfferInsUser fromInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append(" and OFFER_INST_ID = :p_OFFER_INST_ID ");
			fromPARAM.put("p_OFFER_INST_ID", new Long( aInsOfferId ) );
			fromPARAM.put("p_USER_ID", new Long ( aUserId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			fromInsOffer = (InsOfferInsUser[])retrieve(InsOfferInsUser.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsOffer != null && fromInsOffer.length > 0?fromInsOffer[ fromInsOffer.length - 1 ]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getInsOffInsUserByInsOfferId(long, int, int, java.lang.String)
	 */
	public InsOfferInsUser getInsOffInsUserByInsOfferId(long aInsOfferId,
			int aIsMainOffer, 
			int aIsGrpMainUser, 
			String aREGION_ID) throws RemoteException, Exception {
		InsOfferInsUser fromInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" OFFER_INST_ID = :p_OFFER_INST_ID ")
			       .append(" and IS_MAIN_OFFER = :p_IS_MAIN_OFFER " )
			       .append(" and IS_GRP_MAIN_USER = :p_IS_GRP_MAIN_USER ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_OFFER_INST_ID", new Long( aInsOfferId ) );
			fromPARAM.put("p_IS_MAIN_OFFER", new Integer( aIsMainOffer ) );
			fromPARAM.put("p_IS_GRP_MAIN_USER", new Integer( aIsGrpMainUser ) );
			fromPARAM.put("REGION_ID", aREGION_ID );
			fromInsOffer = (InsOfferInsUser[])retrieve(InsOfferInsUser.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return fromInsOffer != null && fromInsOffer.length > 0?fromInsOffer[0]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsSrvByUserId(long, java.lang.String)
	 */
	public InsProdInsSrv[] getIInsSrvByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		InsProdInsSrv aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_USER_ID", new Long( aUserId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			aInsOffer = (InsProdInsSrv[])retrieve(InsProdInsSrv.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsSrvByInsSrvpkgId(long, long, java.lang.String)
	 */
	public InsProdInsSrv[] getIInsSrvByInsSrvpkgId(long aUserId, long aInsSrvpkgId, String aRegionId) throws RemoteException, Exception {
		InsProdInsSrv aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append(" and PROD_INST_ID = :p_PROD_INST_ID " );
			fromPARAM.put("p_USER_ID", new Long( aUserId ) );
			fromPARAM.put("p_PROD_INST_ID", new Long( aInsSrvpkgId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			aInsOffer = (InsProdInsSrv[])retrieve(InsProdInsSrv.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsSrvAttrByUserId(long, java.lang.String)
	 */
	public InsSrvAttr[] getIInsSrvAttrByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		InsSrvAttr aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_USER_ID", new Long( aUserId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			aInsOffer = (InsSrvAttr[])retrieve(InsSrvAttr.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsSrvAttrByProdSrvRelatId(long, long, java.lang.String)
	 */
	public InsSrvAttr[] getIInsSrvAttrByProdSrvRelatId(long aUserId, long aProdSrvRelatId, String aRegionId) throws RemoteException, Exception {
		InsSrvAttr aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append(" and PROD_SRV_RELAT_ID = :p_PROD_SRV_RELAT_ID " );
			fromPARAM.put("p_USER_ID", new Long( aUserId ) );
			fromPARAM.put("p_PROD_SRV_RELAT_ID", new Long( aProdSrvRelatId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			aInsOffer = (InsSrvAttr[])retrieve(InsSrvAttr.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsSrvpkgByUserId(long, java.lang.String)
	 */
	public InsProd[] getIInsSrvpkgByUserId(long aUserId, String aRegionId) throws RemoteException, Exception {
		InsProd aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append( CustomUtils.ICustom.getSqlValidType( 
			    		   IUpdbfsConst.IEnum.IEffective.VALID_TYPE_ALL ) );
			fromPARAM.put("p_USER_ID", new Long( aUserId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			aInsOffer = (InsProd[])retrieve(InsProd.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getIInsSrvpkgByInsSrvpkgId(long, long, java.lang.String)
	 */
	public InsProd getIInsSrvpkgByInsSrvpkgId(long aUserId, long aInsSrvpkgId, String aRegionId) throws RemoteException, Exception {
		InsProd aInsOffer[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(" USER_ID = :p_USER_ID ")
			       .append(" and PROD_INST_ID = :p_PROD_INST_ID" );
			fromPARAM.put("p_USER_ID", new Long( aUserId ) );
			fromPARAM.put("p_PROD_INST_ID", new Long( aInsSrvpkgId ) );
			fromPARAM.put("REGION_ID", aRegionId );
			aInsOffer = (InsProd[])retrieve(InsProd.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aInsOffer != null && aInsOffer.length > 0?aInsOffer[ aInsOffer.length - 1]:null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getCmIndivCust(long, java.lang.String)
	 */
	public CmIndivCust getCmIndivCust(long aCUST_ID, String regionId) throws RemoteException, Exception {
		CmIndivCust aCmIndivCust[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(CmIndivCust.S_IndivCustId).append(" = :p_CUST_ID and ")
				   .append(CmIndivCust.S_State).append(" = :p_STATE");
			fromPARAM.put("p_CUST_ID", new Long( aCUST_ID ) );
			fromPARAM.put("p_STATE", "U" );
			fromPARAM.put("REGION_ID", regionId );
			aCmIndivCust = (CmIndivCust[])retrieve(CmIndivCust.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aCmIndivCust!=null && aCmIndivCust.length>0?aCmIndivCust[aCmIndivCust.length-1]:null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getVpmnCust(long, java.lang.String)
	 */
	public CmVpmnCust getVpmnCust(long aCUST_ID, String regionId) throws RemoteException, Exception {
		CmVpmnCust aCmVpmnCust[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(CmVpmnCust.S_VpmnCustId).append(" = :p_VPMN_CUST_ID and ")
			 	   .append(CmVpmnCust.S_State).append(" = :p_STATE");
			fromPARAM.put("p_VPMN_CUST_ID", new Long( aCUST_ID ) );
			fromPARAM.put("p_STATE", "U" );
			fromPARAM.put("REGION_ID", regionId );
			aCmVpmnCust = (CmVpmnCust[])retrieve(CmVpmnCust.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aCmVpmnCust!=null && aCmVpmnCust.length>0?aCmVpmnCust[aCmVpmnCust.length-1]:null;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.dao.interfaces.ICustomDAO#getFamilyCust(long, java.lang.String)
	 */
	public CmFamilyCust getFamilyCust(long aCUST_ID,
			String regionId) throws RemoteException, Exception {
		CmFamilyCust aCmFamilyCust[] = null;
		StringBuilder fromSQL = new StringBuilder();
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		try
		{
			fromSQL.append(CmFamilyCust.S_FamilyCustId).append(" = :p_FAMILY_CUST_ID and ")
			       .append(CmFamilyCust.S_State).append(" = :p_STATE");
			fromPARAM.put("p_FAMILY_CUST_ID", new Long( aCUST_ID ) );
			fromPARAM.put("p_STATE", "U" );
			fromPARAM.put("REGION_ID", regionId );
			aCmFamilyCust = (CmFamilyCust[])retrieve(CmFamilyCust.S_TYPE, 
					fromSQL.toString(), 
					fromPARAM );
		}
		finally{
			if( fromPARAM != null ){ fromPARAM.clear(); fromPARAM = null; }
		}
		return aCmFamilyCust!=null && aCmFamilyCust.length>0?aCmFamilyCust[aCmFamilyCust.length-1]:null;
	}
}
