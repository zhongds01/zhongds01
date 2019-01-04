package com.ai.sacenter.cboss.dao.remote.impl;

import com.ai.sacenter.IUpdcContext;
import com.ai.sacenter.SFException;
import com.ai.sacenter.cache.IUpdcfgFactory;
import com.ai.sacenter.cboss.IUpfgsmConst;
import com.ai.sacenter.cboss.IUpfgsmFactory;
import com.ai.sacenter.cboss.bo.IISARadiusIndex;
import com.ai.sacenter.jdbc.HQSQLEntityBean;
import com.ai.sacenter.jdbc.HQSQLTable;
import com.ai.sacenter.subtable.ISubSQLOffer;
import com.ai.sacenter.subtable.impl.SFSubTableWrapImpl;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JSONUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;
import com.ai.sacenter.valuebean.IUpfgsmTemplate;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-12-4</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class IUpfgsmRemoteTfImpl extends SFSubTableWrapImpl{
	private static final long serialVersionUID = -4745907190629581842L;
	public IUpfgsmRemoteTfImpl() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 平台订购索引上发表[CBOSS]</p>
	 * <p>Copyright: Copyright (c) 2014-12-4</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmNotifyTfImpl extends SFSubTableWrapImpl{
		private static final long serialVersionUID = -5688287402311769089L;
		public IUpfgsmNotifyTfImpl(){
			super();
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 平台订购索引上发表[CBOSS]</p>
	 * <p>Copyright: Copyright (c) 2014-12-4</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IUpfgsmNotifyXTfImpl extends  IUpfgsmRemoteTfImpl{
		private static final long serialVersionUID = 1452877979356917460L;
		public IUpfgsmNotifyXTfImpl(){
			super();
		}
		
		/* (non-Javadoc)
		 * @see com.ai.sacenter.subtable.impl.SFSubTableWrapImpl#transform(com.ai.sacenter.jdbc.HQSQLEntityBean, com.ai.sacenter.subtable.ISubSQLOffer, com.ai.sacenter.IUpdcContext)
		 */
		public java.util.HashMap transform(HQSQLEntityBean fromBroke, ISubSQLOffer fromSubSQL, IUpdcContext aContext) throws SFException, Exception {
			java.util.HashMap fromUpfwm = new java.util.HashMap();
			try
			{   
				class SFUpffxRemoteImpl{
					public SFUpffxRemoteImpl(){
						super();
					}
					
					/**
					 * 
					 * @param fromMBean
					 * @param _catalog
					 * @param _objective_
					 * @param __strings__
					 * @param aContext
					 * @throws SFException
					 * @throws Exception
					 */
					private void __transfer(HQSQLTable _table_, IUpfgsmTemplate.IUpfgsmxOffer _catalog, Object _objective_, java.util.ArrayList<String> __strings__, IUpdcContext aContext ) throws SFException, Exception{
						try
						{
							HQSQLTable.HQSQLColumn __column__ = _table_.getProperty( IUpfgsmConst.IUpfwmCol.PROPERTY_VALUE );
							if( _objective_ != null && _objective_ instanceof java.util.Collection ){
								java.util.Collection __stringlist__ = (java.util.Collection)_objective_;
								for( java.util.Iterator itera = __stringlist__.iterator(); itera.hasNext(); ){
									Object ___string___ = itera.next();
									if( ___string___ == null ){ continue; }
									__transfer(_table_, _catalog, ___string___, __strings__, aContext);
								}
							}
							else if( _objective_ != null && _objective_ instanceof java.util.Map ){
								java.util.Map __stringlist__ = (java.util.Map)_objective_;
								for( java.util.Iterator itera = __stringlist__.entrySet().iterator(); itera.hasNext(); ){
									java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
									if( fromEntry.getValue() == null || _catalog.getCOMPETE().equals( fromEntry.getKey() ) == false ){ continue; }
									__transfer(_table_, _catalog, fromEntry.getValue(), __strings__, aContext);
								}
							}
							else if( _objective_ != null && _objective_ instanceof String && JSONUtils.IJson.isJSONString( (String)_objective_ ) ){
								String __string__[] = StringUtils.substringAsL( (String)_objective_, __column__.getMaxLength() );
								for( int __index__ = 0; __string__ != null && __index__ < __string__.length; __index__++ ){
									__strings__.add( __string__[ __index__ ] );
								}
							}
							else if( _objective_ != null && _objective_ instanceof String && XmlUtils.IXml.isXML( (String)_objective_ ) ){
								String __string__[] = StringUtils.substringAsL( (String)_objective_, __column__.getMaxLength() );
								for( int __index__ = 0; __string__ != null && __index__ < __string__.length; __index__++ ){
									__strings__.add( __string__[ __index__ ] );
								}
							}
							else if( _objective_ != null && ClassUtils.IClass.isPrimitive( _objective_ ) ){
								String __string__[] = StringUtils.wildcardArray( _objective_.toString() , "|" );
								for( int __index__ = 0 ; __string__ != null && __index__ < __string__.length ; __index__++ ){
									if( __string__[__index__] == null ) continue;
									__strings__.add( StringUtils.replace( __string__[__index__], "&", "|" ) );
								}
							}
							else if( _objective_ != null ){
								String __jsonstring__ = JSONUtils.fromBean( _objective_ );
								String __string__[] = StringUtils.substringAsL( __jsonstring__.toString(), __column__.getMaxLength() );
								for( int __index__ = 0; __string__ != null && __index__ < __string__.length; __index__++ ){
									__strings__.add( __string__[ __index__ ] );
								}
							}
						}
						finally{
							
						}
					}
					
					/**
					 * 
					 * @param _table_
					 * @param _catalog
					 * @param fromUpffx
					 * @param aContext
					 * @return
					 * @throws SFException
					 * @throws Exception
					 */
					public String[] _transfer(HQSQLTable _table_, IUpfgsmTemplate.IUpfgsmxOffer _catalog, Object fromUpffx, IUpdcContext aContext ) throws SFException, Exception{
						java.util.ArrayList<String> __strings__ = new java.util.ArrayList<String>();
						try
						{
							if( fromUpffx != null && fromUpffx instanceof java.util.List ){
								__transfer(_table_, _catalog, fromUpffx, __strings__, aContext);
							}
							else if( fromUpffx != null && fromUpffx instanceof java.util.Map ){
								__transfer(_table_, _catalog, fromUpffx, __strings__, aContext);
							}
							else if( fromUpffx != null ){
								__transfer(_table_, _catalog, fromUpffx, __strings__, aContext);
							}
						}
						finally{
							
						}
						return (String[])__strings__.toArray( new String[]{} );
					}
					
				}
				SFUpffxRemoteImpl fromUpffxImpl = new SFUpffxRemoteImpl();
				java.util.Map fromUpfgsmx = null;
				try
				{
					ISubSQLOffer.IUpdfmxOffer fromUpdfmx = fromSubSQL.getSubFlow();
					String _platform = fromUpdfmx.getSubFlow().get( IISARadiusIndex.S_BusiType ).toString();
					IUpfgsmTemplate.IUpfgsmOffer fromUpfgsm = IUpdcfgFactory.getIUpffmSV().getSFUpfgsmMisc( _platform );
					fromUpfgsmx = IUpfgsmFactory.getIUpfgsmSV().finishSFUpfgsmMisc(fromUpdfmx.getSubFlow(), aContext);
					if( fromUpfgsm != null && fromUpfgsmx != null && fromUpfgsmx.size() > 0 ){
						for( java.util.Iterator itera = fromUpfgsmx.entrySet().iterator(); itera.hasNext(); ){
							java.util.Map.Entry fromEntry = (java.util.Map.Entry)itera.next();
							IUpfgsmTemplate.IUpfgsmxOffer __catalog = fromUpfgsm.getMAPPING( fromEntry.getKey().toString() );
							String _property_value[] = fromUpffxImpl._transfer( fromUpdfmx.getSubJect(), __catalog, fromEntry.getValue(), aContext );
							if( _property_value == null || _property_value.length <= 0 ) continue;
							for( int index = 0; _property_value != null && index < _property_value.length; index++ ){
								java.util.HashMap fromNotifyX = transfer(fromBroke, fromSubSQL, aContext);
								fromNotifyX.put( IUpfgsmConst.IUpfwmCol.PROPERTY_ID   , __catalog.getMAPPING     () );
								fromNotifyX.put( IUpfgsmConst.IUpfwmCol.PROPERTY_SEQ  , String.valueOf( index + 1 ) );
								fromNotifyX.put( IUpfgsmConst.IUpfwmCol.PROPERTY_VALUE, _property_value[index]      );
								OracleUtils.ISystem.wrap( fromUpdfmx.getSubJsql().getTARGET(), 
										new java.util.Map[]{ fromNotifyX }, 
										fromUpfwm );
							}
						}
					}
				}
				finally{
					if( fromUpfgsmx != null ){ fromUpfgsmx.clear(); fromUpfgsmx = null; }
					if( fromUpffxImpl != null ){ fromUpffxImpl = null; }
				}
				
			}
			finally{
				
			}
			return fromUpfwm;
		}
	}
}
