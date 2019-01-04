package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 基于订购模型服务产品</p>
 * <p>Copyright: Copyright (c) 2016年3月22日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class IOVMsgFUserOffer extends IOVMsgFOffer implements java.lang.Comparable<Object>,java.io.Serializable{
	private static final long serialVersionUID = -3151968799713757257L;
	public IOVMsgFUserOffer() {
		super();
	}

	public IOVMsgFUserOffer(IOVMsgFUser fromUser, long aCOMPETE_ID, String aSTATUS ){
		super(fromUser, aCOMPETE_ID, aSTATUS);
	}
	
	public IOVMsgFUserOffer(IOVMsgFUser fromUser, org.dom4j.Element Element) {
		super( fromUser, Element );
	}
	
	public IOVMsgFUserOffer(IOVMsgFOffer aOffer) {
		super(aOffer);
	}
	
	public IOVMsgFUserOffer(IOVMsgFOfferX aOfferX) {
		super(aOfferX);
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
			org.dom4j.Element fromOrdProdInfo = fromRoot.addElement( "USER" );
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
		else if( objective instanceof IOVMsgFUserOffer == false ){
			return false;
		}
		else{
			IOVMsgFUserOffer offer = (IOVMsgFUserOffer)objective;
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
			doCompare = objective != null && objective instanceof IOVMsgFUserOffer?0:1;
			if( doCompare == 0 ){
				IOVMsgFUserOffer offer = (IOVMsgFUserOffer)objective;
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
