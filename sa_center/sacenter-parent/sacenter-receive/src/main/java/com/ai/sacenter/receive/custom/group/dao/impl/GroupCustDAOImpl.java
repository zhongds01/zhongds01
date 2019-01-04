package com.ai.sacenter.receive.custom.group.dao.impl;

import java.rmi.RemoteException;
import com.ai.sacenter.receive.custom.dbcp.ICustomDAOImpl;
import com.ai.sacenter.receive.custom.group.bo.CmGroupCust;
import com.ai.sacenter.receive.custom.group.dao.interfaces.IGroupCustDAO;

public class GroupCustDAOImpl extends ICustomDAOImpl implements IGroupCustDAO {
	public GroupCustDAOImpl(){
		super();
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.custom.group.dao.interfaces.IGroupCustDAO#getGroupCust(long, java.lang.String)
	 */
	public CmGroupCust getGroupCust(long aCUSTOM_ID, 
			String aREGION_ID) throws RemoteException, Exception {
		CmGroupCust aCmGroupCustomer[] = null;
		java.util.HashMap<String,Object> fromPARAM = new java.util.HashMap<String,Object>();
		StringBuilder fromSQL = new StringBuilder();
		try
		{
			fromSQL.append(CmGroupCust.S_GroupCustId).append(" = :p_GROUP_CUST_ID ");
			fromPARAM.put( "p_GROUP_CUST_ID", new Long( aCUSTOM_ID ) );
			fromPARAM.put( "REGION_ID", aREGION_ID );
			aCmGroupCustomer = (CmGroupCust[])retrieve(CmGroupCust.S_TYPE, 
					fromSQL.toString(),
					fromPARAM);
		}finally{
			if(fromPARAM!=null){fromPARAM.clear();fromPARAM = null;}
		}
		return aCmGroupCustomer != null && aCmGroupCustomer.length > 0?
				aCmGroupCustomer[aCmGroupCustomer.length - 1]:null;
	}
}
