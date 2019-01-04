package com.ai.sacenter.receive.valuebean;

import com.ai.sacenter.receive.custom.valuebean.IOVUserCentrex;
import com.ai.sacenter.receive.custom.valuebean.IOVUserOrder;
import com.ai.sacenter.receive.util.CustomUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-receive</p>
 * <p>Description: 开通定单资费包</p>
 * <p>Copyright: Copyright (c) 2018年4月3日</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVMsgFOrdCentrex extends IOVMsgFCentrex {
	private static final long serialVersionUID = 6235297529440870670L;
	public IOVMsgFOrdCentrex() {
		super();
	}

	public IOVMsgFOrdCentrex(IOVMsgFOffer centrex) {
		super( centrex );
	}

	public IOVMsgFOrdCentrex(IOVMsgFCentrex centrex) {
		super( centrex );
		for( java.util.Iterator<IOVMsgFOffer> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFOrdOffer orderoffer = (IOVMsgFOrdOffer)itera.next();
			CENTREX.add( new IOVMsgFOrdOffer( orderoffer ) ); 
		}
	}
	
	public IOVMsgFOrdCentrex(IOVMsgFOrdCentrex centrex) {
		super( centrex );
		for( java.util.Iterator<IOVMsgFOffer> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFOrdOffer orderoffer = (IOVMsgFOrdOffer)itera.next();
			CENTREX.add( new IOVMsgFOrdOffer( orderoffer ) ); 
		}
	}
	
	public IOVMsgFOrdCentrex( IOVUserCentrex centrex) throws Exception{
		super( centrex );
		for( java.util.Iterator<IOVUserOrder> itera = centrex.getCENTREX().iterator(); itera.hasNext(); ){
			IOVUserOrder userorder = (IOVUserOrder)itera.next();
			IOVMsgFOrdOffer orderoffer = new IOVMsgFOrdOffer();
			CustomUtils.ICustom._wrap( userorder, orderoffer );
			CENTREX.add( orderoffer ); 
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.valuebean.IOVMsgFCentrex#mergeAsCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFOffer)
	 */
	public void mergeAsCentrex(IOVMsgFOffer centrex) throws Exception {
		IOVMsgFOrdOffer orderoffer = (IOVMsgFOrdOffer)CENTREX.get( centrex );
		if( orderoffer == null ){ CENTREX.add( new IOVMsgFOrdOffer( centrex ) ); }
		else{ orderoffer.mergeAsGroup( centrex); } 
	}
	
	/* (non-Javadoc)
	 * @see com.ai.sacenter.receive.valuebean.IOVMsgFCentrex#mergeAsCentrex(com.ai.sacenter.receive.valuebean.IOVMsgFCentrex)
	 */
	public void mergeAsCentrex(IOVMsgFCentrex centrex) throws Exception {
		for( java.util.Iterator<IOVMsgFOffer> itera = centrex.CENTREX.iterator(); itera.hasNext(); ){
			IOVMsgFOrdOffer orderoffer = (IOVMsgFOrdOffer)itera.next();
			mergeAsCentrex( orderoffer );
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
