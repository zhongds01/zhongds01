package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于订单模型服务产品</p>
 * <p>Copyright: Copyright (c) 2016年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFOrdOffer extends IOVMsgFOffer implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -7469295166935820024L;
	public IOVMsgFOrdOffer() {
		super();
	}
	
	public IOVMsgFOrdOffer(IOVMsgFUser fromUser, long aCOMPETE_ID, String aSTATUS ){
		super(fromUser, aCOMPETE_ID, aSTATUS);
	}
	
	public IOVMsgFOrdOffer(IOVMsgFUser fromUser, org.dom4j.Element Element) {
		super( fromUser, Element );
	}
	
	public IOVMsgFOrdOffer(IOVMsgFOffer centrex) {
		super(centrex);
	}
	
	public IOVMsgFOrdOffer(IOVMsgFOfferX centrex) {
		super(centrex);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
			org.dom4j.Element fromOrdProdInfo = fromRoot.addElement( "ORDER" );
			msgfOfferToXML( fromOrdProdInfo );
			fromXML = XmlUtils.IXml._format( document.asXML() );
		}
		catch( java.lang.Exception exception ){
			fromXML = super.toString();
		}
		finally{
			
		}
		return fromXML;
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.valuebean.IOVMsgFOffer#equals(java.lang.Object)
	 */
	public boolean equals(Object objective) {
		if( objective == null ){
			return false;
		}
		else if( objective instanceof IOVMsgFOrdOffer == false ){
			return false;
		}
		else{
			IOVMsgFOrdOffer offer = (IOVMsgFOrdOffer)objective;
			return INS_PROD_ID > 0 && offer.INS_PROD_ID > 0 && 
					INS_PROD_ID == offer.INS_PROD_ID;
		}
	}

	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.valuebean.IOVMsgFOffer#compareTo(java.lang.Object)
	 */
	public int compareTo(Object objective) {
		long doCompare = 0;
		try
		{
			doCompare = objective != null && objective instanceof IOVMsgFOrdOffer?0:1;
			if( doCompare == 0 ){
				IOVMsgFOrdOffer offer = (IOVMsgFOrdOffer)objective;
				doCompare = INS_PROD_ID > 0 && offer.INS_PROD_ID > 0?0:1;
				if( doCompare == 0 ){
					doCompare = INS_PROD_ID - offer.INS_PROD_ID;
				}
			}
		}
		finally{
			
		}
		return doCompare == 0?0:(doCompare > 0?1:-1);
	}
}
