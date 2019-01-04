package com.ai.sacenter.valuebean;

import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.provision.valuebean.IOVUpfwmResponse;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.UpdcUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmOffer;
import com.ai.sacenter.valuebean.IPlatformTemplate.IUpffmsOffer;
import com.ai.sacenter.valuebean.IProgramTemplate.IUpdfcmpOffer;
import com.ai.sacenter.valuebean.IProgramTemplate.IUpdpgmOffer;
import com.ai.sacenter.valuebean.ISystemTemplate.IImplCapital;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 服务激活构件</p>
 * <p>Copyright: Copyright (c) 2015-5-17</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IOVUpdcpmOffer implements java.io.Serializable{
	private static final long serialVersionUID = 5871071774313419257L;
	/*发起方工单*/
	private Object  _objective = null;
	/*服务激活组件*/
	private IUpdcpmHome       _program = new IUpdcpmHome();
	/*服务应答规范*/
	private IUpfgrpHome       _asking  = new IUpfgrpHome();
	/*服务能力集*/
	private java.util.HashMap _subflow = new java.util.HashMap();
	public IOVUpdcpmOffer( Object objective ) {
		super();
		_objective = objective;
	}
	
	public IOVUpdcpmOffer( Object objective, SFException exception ) {
		super();
		_objective       = objective;
		_program._nature = exception;
	}
	
	/**
	 * @return 发起方工单
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}
	
	/**
	 * @return 服务激活组件
	 */
	public IUpdcpmHome getPROGRAM() {
		return _program;
	}
	
	/**
	 * @return 服务应答规范
	 */
	public IUpfgrpHome getASKING() {
		return _asking;
	}
	
	/**
	 * 服务应答规范
	 * @param originate 发起方应答
	 * @param home  落地方应答
	 */
	public void setPLWK_ASKING(IOVUpfwmResponse originate, IOVUpfwmResponse home) {
		if( originate != null ){ _asking._origing = originate;}
		if( home != null ){ _asking._homeing = home;}
	}
	
	/**
	 * @return 服务能力集
	 */
	public java.util.HashMap getSUBFLOW() {
		return _subflow;
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
			if( _program._component != null ){
				_program.transferAsXml( fromRoot.addElement( "PROGRAM" ) );
			}
			if( _asking != null ){
				_asking.transferAsXml( fromRoot.addElement( "PLATFORM" ) );
			}
			fromXML = XmlUtils.IXml._format( document.asXML() );
		}
		catch( java.lang.Exception exception ){
			fromXML = super.toString();
		}
		finally{
			
		}
		return fromXML;
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-18</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpdcpmHome implements java.io.Serializable{
		private static final long serialVersionUID = 4439276275723324797L;
		/*解决方案规范*/
		private IUpdpgmOffer   _program    = null;
		/*解决方案组件*/
		private IUpdfcmpOffer  _component  = null;
		/*国际规范*/
		private SFException    _nature     = null;
		/*方案组件网元*/
		private IUpffmOffer    _platform   = null;
		/*解决组件类库*/
		private IImplCapital   _implcass   = null; 
		/*服务测代码策略*/
		private IUpffmsOffer   _respond    = null;
		/*服务激活关系组件*/
		private java.util.List _subflow    = new java.util.ArrayList();
		public IUpdcpmHome(){
			super();
		}
		
		/**
		 * @return 解决方案规范
		 */
		public IUpdpgmOffer getPROGRAM() {
			return _program;
		}
		
		/**
		 * @param _program 解决方案规范
		 */
		public void setPROGRAM(IUpdpgmOffer _program) {
			this._program = _program;
		}
		
		/**
		 * @return 解决方案组件
		 */
		public IUpdfcmpOffer getCOMPONENT() {
			return _component;
		}
		
		/**
		 * @param capital 解决方案组件
		 */
		public void setCOMPONENT(IUpdfcmpOffer component) throws Exception{
			_component = component;
			_implcass  = SystemUtils.ISystem.getSFUpfgkmCapital( _component.getIMPLCLASS() );
			_platform  = UpdcUtils.ISubFlow.getPLATFORM( _implcass ); 
		}
		
		/**
		 * @return 国际规范
		 */
		public SFException getNATURE() {
			return _nature;
		}

		/**
		 * @param nature 国际规范
		 */
		public void setNATURE(SFException nature) {
			_nature = nature;
		}

		/**
		 * @return 方案组件网元
		 */
		public IUpffmOffer getPLATFORM() {
			return _platform;
		}

		/**
		 * @param platform 方案组件网元
		 */
		public void setPLATFORM(IUpffmOffer platform) {
			_platform = platform;
		}

		/**
		 * @return 解决组件类库
		 */
		public IImplCapital getIMPLCLASS() {
			return _implcass;
		}
		
		/**
		 * @param implcass 解决组件类库
		 */
		public void setIMPLCLASS(IImplCapital implcass) {
			_implcass = implcass;
		}
		
		/**
		 * @return 应答代码策略
		 */
		public IUpffmsOffer getRESPOND() {
			if( _respond == null && _nature != null ){
				_respond = new IUpffmsOffer( _nature );
			}
			else if( _respond == null ){
				_nature = ExceptionFactory.getSucceed();
				_respond = new IUpffmsOffer( _nature );
			}
			return _respond;
		}
		
		/**
		 * @param respond 应答代码策略
		 */
		public void setRESPOND(IUpffmsOffer respond) {
			_respond = respond;
		}
		
		/**
		 * @return 服务激活关系组件
		 */
		public java.util.List getSUBFLOW() {
			return _subflow;
		}
		
		/**
		 * 
		 * @param element
		 * @throws Exception
		 */
		private void transferAsXml( org.dom4j.Element element ) throws Exception{
			try
			{
				element.addElement("ID"       ).setText( _component.getID       () );
				element.addElement("NAME"     ).setText( _component.getNAME     () );
				element.addElement("CATEGORY" ).setText( _component.getCATEGORY () );
				element.addElement("PROGRAM"  ).setText( _program.getID         () );
				if( _platform != null ){
					element.addElement("PLATFORM"  ).setText( _platform.getID   () );
				}
				if( _component.getCATALOG() != null && _component.getCATALOG().size() > 0 ){
					org.dom4j.Element _future_ = element.addElement( "FUTURE" );
					if( _component.getCATALOG() != null && _component.getCATALOG().size() > 0 ){
						for( java.util.Iterator itera = _component.getCATALOG().iterator(); itera.hasNext(); ){
							IProgramTemplate.IUpdfcmpCatalog fromCatalog = (IProgramTemplate.IUpdfcmpCatalog)itera.next();
							org.dom4j.Element ___future__ = _future_.addElement( "FUTURE" );
							___future__.addElement("ID"       ).setText( String.valueOf( fromCatalog.getID() ) );
							___future__.addElement("NAME"     ).setText( fromCatalog.getNAME                () );
							___future__.addElement("COMPONENT").setText( fromCatalog.getSUBFIGURE           () );
							___future__.addElement("COMPLEX"  ).setText( fromCatalog.getCOMPLEX() != null?
									fromCatalog.getCOMPLEX():""  );
						}
					}
				}
				if( _respond != null ){
					org.dom4j.Element __respond__ = element.addElement( "RESPOND" );
					__respond__.addElement( "ID"      ).setText( _respond.getID                                      () );
					__respond__.addElement( "NAME"    ).setText( _respond.getNAME                                    () );
					__respond__.addElement( "SUCCEED" ).setText( String.valueOf( _respond.getSUCCEED               () ) );
					__respond__.addElement( "COMPLEX" ).setText( _respond.getCOMPLEX() != null?_respond.getCOMPLEX():"" );
				}
				if( _subflow != null && _subflow.size() > 0 ){
					org.dom4j.Element _subflow_ = element.addElement( "SUBFLOW" );
					for( java.util.Iterator itera = _subflow.iterator(); itera.hasNext(); ){
						IProgramTemplate.IUpdfcmpOffer fromCatalog = (IProgramTemplate.IUpdfcmpOffer)itera.next();
						org.dom4j.Element ___subflow__ = _subflow_.addElement( "FUTURE" );
						___subflow__.addElement ("ID"       ).setText( fromCatalog.getID      () );
						___subflow__.addElement ("NAME"     ).setText( fromCatalog.getNAME    () );
						___subflow__.addElement("CATEGORY" ).setText( fromCatalog.getCATEGORY() );
					}
				}
			}
			finally{
				
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
				org.dom4j.Element fromRoot = document.addElement( "InterBOSS" );
				if( _component != null ){
					transferAsXml( fromRoot.addElement( "PROGRAM" ) );
				}
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
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2015-5-19</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgrpHome implements java.io.Serializable{
		private static final long serialVersionUID = 4485457610514153655L;
		/*发起方应答信息*/
		private IOVUpfwmResponse _origing = null;
		/*落地方应答信息*/
		private IOVUpfwmResponse _homeing = null;
		public IUpfgrpHome(){
			super();
		}
		
		/**
		 * @return 落地方应答
		 */
		public IOVUpfwmResponse getHOMEING() {
			return _homeing;
		}
		
		/**
		 * @param homing 落地方应答
		 */
		public void setHOMEING(IOVUpfwmResponse homing) {
			_homeing = homing;
		}
		
		/**
		 * @return 发起方应答
		 */
		public IOVUpfwmResponse getORIGING() {
			return _origing;
		}
		
		/**
		 * @param origing 发起方应答
		 */
		public void setORIGING(IOVUpfwmResponse origing) {
			_origing = origing;
		}
		
		/**
		 * 
		 * @param element
		 * @throws Exception
		 */
		private void transferAsXml( org.dom4j.Element element ) throws Exception{
			try
			{
				if( _origing != null ){
					XmlUtils.IXml._createIXml( element, "PLATFORM", _origing );
				}
				if( _homeing != null ){
					XmlUtils.IXml._createIXml( element, "SUBFLOW", _homeing );
				}
			}
			finally{
				
			}
		}
	}
}
