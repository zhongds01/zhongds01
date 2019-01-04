package com.ai.sacenter.valuebean;

import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * 
 * <p>Title: sacenter-core</p>
 * <p>Description: 服务组件组</p>
 * <p>Copyright: Copyright (c) 2017年11月29日</p>
 * <p>Company: AI(NanJing)</p>
 * @author huiyu
 * @version 3.0
 */
public class IUpdcpmGroup implements java.io.Serializable{
	private static final long serialVersionUID = 1888800800029893769L;
	/*发起方单*/
	private Object _objective = null;
	/*服务组件组*/
	private IUpdcpmOfferHome _program = new IUpdcpmOfferHome();
	public IUpdcpmGroup( Object objective, IProgramTemplate.IUpdfcmpOffer  program ) throws Exception{
		super();
		_objective = objective;
		_program.mergeAsGroup( program );
	}
	
	/**
	 * @return 发起方单
	 */
	public Object getOBJECTIVE() {
		return _objective;
	}

	/**
	 * @return 服务组件组
	 */
	public IUpdcpmOfferHome getPROGRAM() {
		return _program;
	}

	public static class IUpdcpmOfferHome implements java.io.Serializable{
		private static final long serialVersionUID = 3179194796135187212L;
		/*服务组件*/
		private IProgramTemplate.IUpdfcmpOffer  _program  = null;
		/*组件类库*/
		private ISystemTemplate.IImplCapital   _implcass = null;
		/*服务组件组*/
		private java.util.List _group = new java.util.ArrayList();
		/*服务能力集*/
		private java.util.Map _subflow = new java.util.HashMap();
		public IUpdcpmOfferHome(){
			super();
		}
		
		/**
		 * @return 服务组件资产
		 */
		public IProgramTemplate.IUpdfcmpOffer getPROGRAM() {
			return _program;
		}
		
		/**
		 * 
		 * @return 服务最终组件资产
		 */
		public IProgramTemplate.IUpdfcmpOffer getPROJECT(){
			IProgramTemplate.IUpdfcmpOffer _project = _program;
			if( _group != null && _group.size() > 0 ){
				_project = (IProgramTemplate.IUpdfcmpOffer)_group.get( _group.size() - 1 );
			}
			return _project;
		}

		/**
		 * 
		 * @param program 服务组件资产
		 * @throws Exception
		 */
		public void setPROGRAM(IProgramTemplate.IUpdfcmpOffer program) throws Exception{
			_program = program;
		}
		
		/**
		 * 
		 * @param program 服务组件资产
		 * @throws Exception
		 */
		public void mergeAsGroup( IProgramTemplate.IUpdfcmpOffer program) throws Exception{
			_program = program;
			_implcass = SystemUtils.ISystem.getSFUpfgkmCapital( program.getIMPLCLASS() );
		}
		
		/**
		 * @return 组件类库
		 */
		public ISystemTemplate.IImplCapital getIMPLCLASS() {
			return _implcass;
		}
		
		/**
		 * @param implcass 组件类库
		 */
		public void setIMPLCLASS(ISystemTemplate.IImplCapital implcass) {
			_implcass = implcass;
		}
		
		/**
		 * @return 服务组件组
		 */
		public java.util.List getGROUP() {
			return _group;
		}
		
		/**
		 * @return 服务能力集
		 */
		public java.util.Map getSUBFLOW() {
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
				org.dom4j.Element fromRootInfo = fromRoot.addElement( "COMPONENT" );
				fromRootInfo.addElement("ID"       ).setText( _program.getID       () );
				fromRootInfo.addElement("NAME"     ).setText( _program.getNAME     () );
				fromRootInfo.addElement("CATEGORY" ).setText( _program.getCATEGORY () );
				if( _program.getCATALOG() != null && _program.getCATALOG().size() > 0 ){
					org.dom4j.Element fromExtInfo = fromRootInfo.addElement( "FUTURE" );
					if( _program.getCATALOG() != null && _program.getCATALOG().size() > 0 ){
						for( java.util.Iterator itera = _program.getCATALOG().iterator(); itera.hasNext(); ){
							IProgramTemplate.IUpdfcmpCatalog fromCatalog = (IProgramTemplate.IUpdfcmpCatalog)itera.next();
							org.dom4j.Element fromCatInfo = fromExtInfo.addElement( "FUTURE" );
							fromCatInfo.addElement("ID"       ).setText( String.valueOf( fromCatalog.getID() ) );
							fromCatInfo.addElement("NAME"     ).setText( fromCatalog.getNAME                () );
							fromCatInfo.addElement("COMPONENT").setText( fromCatalog.getSUBFIGURE           () );
							fromCatInfo.addElement("COMPLEX"  ).setText( fromCatalog.getCOMPLEX() != null?
									fromCatalog.getCOMPLEX():""  );
						}
					}
				}
				if( _group != null && _group.size() > 0 ){
					org.dom4j.Element fromExtInfo = fromRootInfo.addElement( "SUBFLOW" );
					for( java.util.Iterator itera = _group.iterator(); itera.hasNext(); ){
						IProgramTemplate.IUpdfcmpOffer fromCatalog = (IProgramTemplate.IUpdfcmpOffer)itera.next();
						org.dom4j.Element fromCatInfo = fromExtInfo.addElement( "FUTURE" );
						fromCatInfo.addElement ("ID"       ).setText( fromCatalog.getID      () );
						fromCatInfo.addElement ("NAME"     ).setText( fromCatalog.getNAME    () );
						fromCatInfo.addElement("CATEGORY" ).setText( fromCatalog.getCATEGORY() );
					}
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
}
