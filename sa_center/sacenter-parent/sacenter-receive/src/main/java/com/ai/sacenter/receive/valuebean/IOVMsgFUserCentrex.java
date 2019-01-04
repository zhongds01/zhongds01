package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通用户资费包</p>
 * <p>Copyright: Copyright (c) 2018年4月3日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVMsgFUserCentrex extends IOVMsgFCentrex{
	private static final long serialVersionUID = 3473101162504085687L;
	public IOVMsgFUserCentrex() {
		super();
	}

	public IOVMsgFUserCentrex(IOVMsgFOffer centrex) {
		super(centrex);
	}

	public IOVMsgFUserCentrex(IOVMsgFCentrex centrex) {
		super(centrex);
		for( java.util.Iterator<IOVMsgFOffer> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFUserOffer fromOffer = (IOVMsgFUserOffer)itera.next();
			CENTREX.add( new IOVMsgFUserOffer( fromOffer ) ); 
		}
	}
	
	public IOVMsgFUserCentrex(IOVMsgFUserCentrex centrex) {
		super(centrex);
		for( java.util.Iterator<IOVMsgFOffer> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFUserOffer fromOffer = (IOVMsgFUserOffer)itera.next();
			CENTREX.add( new IOVMsgFUserOffer( fromOffer ) );
		}
	}
	
	public IOVMsgFUserCentrex( IOVUserCentrex centrex ) throws Exception{
		super( centrex );
		for( java.util.Iterator<IOVUserOrder> itera = centrex.getCENTREX().iterator(); itera.hasNext(); ){
			IOVUserOrder fromUserOrder = (IOVUserOrder)itera.next();
			IOVMsgFUserOffer fromUserOffer = new IOVMsgFUserOffer();
			CustomUtils.ICustom._wrap( fromUserOrder, fromUserOffer );
			CENTREX.add( fromUserOffer ); 
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.valuebean.IOVMsgFCentrex#mergeAsCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public void mergeAsCentrex(IOVMsgFOffer centrex) throws Exception {
		IOVMsgFUserOffer useroffer = (IOVMsgFUserOffer)CENTREX.get( centrex );
		if( useroffer == null ){ CENTREX.add( new IOVMsgFUserOffer( centrex ) ); }
		else{ useroffer.mergeAsGroup( centrex); } 
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.valuebean.IOVMsgFCentrex#mergeAsCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFCentrex)
	 */
	public void mergeAsCentrex(IOVMsgFCentrex centrex) throws Exception {
		for( java.util.Iterator<IOVMsgFOffer> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFUserOffer useroffer = (IOVMsgFUserOffer)itera.next();
			mergeAsCentrex( useroffer );
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String fromXML = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "InterBOSS" );
			userCentrexToXml( _root.addElement( "CENTREX" ) );
			fromXML = XmlUtils.IXml._format( document.asXML() );
		}
		catch( java.lang.Exception exception ){
			fromXML = super.toString();
		}
		finally{
			
		}
		return fromXML;
	}
}
