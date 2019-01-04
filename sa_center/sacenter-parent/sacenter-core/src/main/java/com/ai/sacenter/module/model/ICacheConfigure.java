package com.ai.sacenter.module.model;

import com.ai.appframe2.complex.cache.ICache;
import com.ai.appframe2.complex.xml.cfg.caches.Cache;
import com.ai.sacenter.SFException;
import com.ai.sacenter.i18n.ExceptionFactory;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.JdomUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.SystemUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: sacenter-core</p>
 * <p>Description: ��������</p>
 * <p>Copyright: Copyright (c) 2017��7��19��</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ICacheConfigure implements java.io.Serializable{
	private static final long serialVersionUID = -976833203509123779L;
	private IParameterGroup _runtime_paramgroup = null;
	private IRouteGroup _runtime_routegroup = null;
	private static java.util.Map _runtime_clustergroup = new java.util.concurrent.ConcurrentHashMap();
	public ICacheConfigure() throws Exception{
		super();
		try{
			String configXml = JdomUtils.IConfigure.getIConfigCache();
			if( configXml != null ){ 
				initialize( XmlUtils.parseFileXml( configXml ) ); 
			}
			else{
				_runtime_paramgroup = new IParameterGroup();
				_runtime_routegroup = new IRouteGroup();
				_runtime_routegroup.mergeAsDefault();
			}
		}
		catch( java.lang.Exception exception ){
			throw new SFException("IOS0010016", "Service Open Template File <AIUpdcCache.xml> In the JVM, the eligible file is not checked");
		}
	}
	
	public ICacheConfigure( org.dom4j.Element element ) throws Exception {
		super();
		initialize( element );
	}
	
	/**
	 * 
	 * @param fromRoot
	 * @throws Exception
	 */
	private void initialize( org.dom4j.Element fromRoot ) throws Exception{
		try
		{
			org.dom4j.Element _configure = (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='CACHE_PARAMETERS']");
			if( _configure == null && _runtime_paramgroup == null ){
				_runtime_paramgroup = new IParameterGroup();
			}
			else if( _configure != null ){
				if( _runtime_paramgroup == null ){ _runtime_paramgroup = new IParameterGroup(); }
				_runtime_paramgroup.mergeAsGroup( _configure );
			}
			
			_configure = (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='CACHE_ROUTER']");
			if( _configure == null && _runtime_routegroup == null  ){
				_runtime_routegroup = new IRouteGroup();
			}
			else if( _configure != null ){ 
				if( _runtime_routegroup == null ){ _runtime_routegroup = new IRouteGroup(); }
				_runtime_routegroup.mergeAsGroup( _configure ); 
			}
			
			_configure = (org.dom4j.Element)fromRoot.selectSingleNode("item[@name='CACHE_SERVERS']");
			if( _configure != null ){
				java.util.List fromCluster = _configure.elements( "item" );
				for( java.util.Iterator itera = fromCluster.iterator(); itera.hasNext(); ){
					org.dom4j.Element _element = (org.dom4j.Element)itera.next();
					String _used = _element.attributeValue( "use", "TRUE" );
					if( _used.equalsIgnoreCase( "TRUE" ) == false ) continue;
					IClusterGroup _cluster = new IClusterGroup( _element );
					_runtime_clustergroup.put( _cluster.getGROUP(), _cluster );
				}
			}
		}
		finally{
			
		}
	}
	
	/**
	 * ����·��
	 * @return
	 */
	public IRouteGroup getRoute(){
		return _runtime_routegroup;
	}
	
	/**
	 * ����ָ����Ⱥ��ȡ����·��
	 * @param _group ��Ⱥ����
	 * @return
	 */
	public java.util.Map getRoute( String _group ){
		java.util.Map fromINDEX = new java.util.HashMap();
		try
		{
			IClusterGroup _cluster = getCluster( _group );
			for( java.util.Iterator itera = _runtime_routegroup._route.values().iterator(); itera.hasNext(); ){
				ICacheRoute _route = (ICacheRoute)itera.next();
				if( _cluster._group.equalsIgnoreCase( _route.getGROUP() ) ){
					fromINDEX.put( _route.getID(), _route );
				}
			}
		}
		finally{
			
		}
		return fromINDEX;
	}
	
	/**
	 * ���ݻ������ȡ����·��
	 * @param _cache_ ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ICacheRoute getRoute( ICache _cache_ ) throws SFException,Exception{
		ICacheRoute __route__ = null;
		try
		{
			if( _runtime_routegroup == null ){ _runtime_routegroup = new IRouteGroup(); }
			__route__ = _runtime_routegroup.getRoute( _cache_ );
		}
		finally{
			
		}
		return __route__;
	}
	
	/**
	 * ���ݻ������ȡ����·��
	 * @param _cache_ ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public ICacheRoute getRoute( Cache _cache_ ) throws SFException,Exception{
		ICacheRoute __route__ = null;
		try
		{
			if( _runtime_routegroup == null ){ _runtime_routegroup = new IRouteGroup(); }
			__route__ = _runtime_routegroup.getRoute( _cache_ );
		}
		finally{
			
		}
		return __route__;
	}
	
	/**
	 * ���ݼ�Ⱥ�����ȡ��Ⱥ����
	 * @param _cluster ��Ⱥ����
	 * @return
	 */
	public IClusterGroup getCluster( String _cluster){
		IClusterGroup _clustergroup = null;
		try
		{
			_clustergroup = (IClusterGroup)_runtime_clustergroup.get( _cluster );
			if( _clustergroup == null ){
				String message = "Service Open Cache Cluster <{0}> Not Queryed Open Cache Cluster Configuration";
				throw new SFException("IOS0011093", JdomUtils.ICustom._wrapAsMessage(message, new Object[]{ _cluster } ) );
			}
		}
		finally{
			
		}
		return _clustergroup;
	}
	
	/**
	 * ���ݻ������ȡ����·�ɼ�Ⱥ
	 * @param _cache_ ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IClusterGroup getCluster( ICache _cache_ ) throws SFException,Exception{
		IClusterGroup _clustergroup_ = null;
		try
		{
			if( _runtime_routegroup == null ){ _runtime_routegroup = new IRouteGroup(); }
			ICacheRoute __route__ = _runtime_routegroup.getRoute( _cache_ );
			_clustergroup_ = (IClusterGroup)_runtime_clustergroup.get( __route__._group );
			if( _clustergroup_ == null && __route__.isMYSQL() /*�������ݿ�ģʽ*/ ){
				_runtime_clustergroup.put( __route__._group, _clustergroup_ = new IClusterGroup( __route__._group ) );
			}
			else if( _clustergroup_ == null ){
				ExceptionFactory.throwIllegal("IOS0011093", new Object[]{ __route__._group } );
			}
		}
		finally{
			
		}
		return _clustergroup_;
	}
	
	/**
	 * ���ݻ������ȡ����·�ɼ�Ⱥ
	 * @param _cache_ ������
	 * @return
	 * @throws SFException
	 * @throws Exception
	 */
	public IClusterGroup getCluster( Cache _cache_ ) throws SFException,Exception{
		IClusterGroup _clustergroup_ = null;
		try
		{
			if( _runtime_routegroup == null ){ _runtime_routegroup = new IRouteGroup(); }
			ICacheRoute __route__ = _runtime_routegroup.getRoute( _cache_ );
			_clustergroup_ = (IClusterGroup)_runtime_clustergroup.get( __route__._group );
			if( _clustergroup_ == null && __route__.isMYSQL() /*�������ݿ�ģʽ*/ ){
				_runtime_clustergroup.put( __route__._group, _clustergroup_ = new IClusterGroup( __route__._group ) );
			}
			else if( _clustergroup_ == null ){
				ExceptionFactory.throwIllegal("IOS0011093", new Object[]{ __route__._group } );
			}
		}
		finally{
			
		}
		return _clustergroup_;
	}
	
	/**
	 * �������
	 * @return
	 */
	public IParameterGroup getParam(){
		return _runtime_paramgroup;
	}
	
	/**
	 * 
	 * @param _froup
	 * @return
	 */
	public ICacheParameter getParam( String _froup ){
		ICacheParameter fromCache = null;
		try
		{
			if( _runtime_paramgroup == null ){ 
				fromCache = new ICacheParameter(); 
			}
			else{
				fromCache = (ICacheParameter)_runtime_paramgroup._group.get( _froup );
				if( fromCache == null ){ 
					fromCache = new ICacheParameter(); 
				}
			}
		}
		finally{
			
		}
		return fromCache;
	}
	
	public static class IRouteGroup implements java.io.Serializable{
		private static final long serialVersionUID = -9016587061110131796L;
		/*·������*/
		private java.util.HashMap _route = new java.util.HashMap();
		public IRouteGroup() throws Exception{
			super();
		}
		
		public IRouteGroup( org.dom4j.Element fromRoot ) throws Exception{
			super();
			mergeAsGroup( fromRoot );
		}
		
		/**
		 * 
		 * @param fromRoot
		 * @throws Exception
		 */
		private void mergeAsGroup( org.dom4j.Element fromRoot ) throws Exception{
			java.util.List fromRoute = fromRoot.elements( "item" );
			for( java.util.Iterator itera = fromRoute.iterator(); itera.hasNext(); ){
				org.dom4j.Element _element = (org.dom4j.Element)itera.next();
				String _used = _element.attributeValue( "use", "TRUE" );
				if( _used.equalsIgnoreCase( "TRUE" ) == false ) continue;
				ICacheRoute _cache = new ICacheRoute( _element );
				_route.put( _cache._id, _cache );
			}
		}
		
		/**
		 * 
		 * @return
		 * @throws Exception
		 */
		private ICacheRoute mergeAsDefault() throws Exception{
			ICacheRoute _default = new ICacheRoute();
			_route.put( _default.getID(), _default );
			return _default;
		}
		
		/**
		 * 
		 * @param id
		 * @param persistence
		 * @return
		 * @throws Exception
		 */
		private ICacheRoute mergeAsDefault( String id, String persistence ) throws Exception{
			ICacheRoute _default = new ICacheRoute( id, persistence );
			_route.put( _default.getID(), _default );
			return _default;
		}
		
		/**
		 * ·������
		 * @return
		 */
		public java.util.HashMap getRoute(){
			return _route;
		}
		
		/**
		 * ���ݻ���·�ɱ����ȡ����·��
		 * @param _group ����·�ɱ���
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public ICacheRoute getRoute( String _group ) throws SFException,Exception{
			ICacheRoute fromRoute = null;
			try
			{
				fromRoute = (ICacheRoute)_route.get( _group );
				if( fromRoute == null ){
					String message = "Service open cache <{0}> not open to open cache routing configuration";
					throw new SFException("IOS0011092", JdomUtils.ICustom._wrapAsMessage(message, new Object[]{_group} ) );
				}
			}
			finally{
				
			}
			return fromRoute;
		}
		
		/**
		 * ���ݻ���ʵ���ȡ����·��
		 * @param _cache_ ����ʵ��
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public ICacheRoute getRoute( ICache _cache_ ) throws SFException,Exception{
			ICacheRoute __route__ = null;
			try
			{
				if( _cache_ == null /*���ݿ⼶����*/ ){
					__route__ = (ICacheRoute)_route.get( ICacheConst.IRoute.DATABASE );
					if( __route__ == null ){ __route__ = mergeAsDefault(); }
				}
				else{
					Cache __cache__ = SystemUtils.ISystem.getSFUpfgkmCache( _cache_ );
					if( __cache__ == null /*���ݿ⼶����*/ ){
						__route__ = (ICacheRoute)_route.get( ICacheConst.IRoute.DATABASE );
						if( __route__ == null ){ __route__ = mergeAsDefault(); }
					}
					else{
						__route__ = (ICacheRoute)_route.get( __cache__.getDataType() );
						if( __route__ == null && StringUtils.equalsIgnoreCase( __cache__.getDataType(), 
								ICacheConst.IRoute.DATABASE ) ){
							__route__ = mergeAsDefault( __cache__.getDataType(), ICacheConst.IRoute.DEFAULT );
						}
						else if( __route__ == null ){
							ExceptionFactory.throwIllegal("IOS0011094", new Object[]{ __cache__.getClass().getName() } );
						}
					}
				}
			}
			finally{
				
			}
			return __route__;
		}
	
		/**
		 * ���ݻ���ʵ���ȡ����·��
		 * @param _cache_ ����ʵ��
		 * @return
		 * @throws SFException
		 * @throws Exception
		 */
		public ICacheRoute getRoute( Cache _cache_ ) throws SFException,Exception{
			ICacheRoute __route__ = null;
			try
			{
				if( _cache_ == null /*���ݿ⼶����*/ ){
					__route__ = (ICacheRoute)_route.get( ICacheConst.IRoute.DATABASE );
					if( __route__ == null ){ __route__ = mergeAsDefault(); }
				}
				else{
					__route__ = (ICacheRoute)_route.get( _cache_.getDataType() );
					if( __route__ == null && StringUtils.equalsIgnoreCase( _cache_.getDataType(), 
							ICacheConst.IRoute.DATABASE ) ){
						__route__ = mergeAsDefault( _cache_.getDataType(), ICacheConst.IRoute.DEFAULT );
					}
					else if( __route__ == null ){
						ExceptionFactory.throwIllegal("IOS0011094", new Object[]{ _cache_.getClass().getName() } );
					}
				}
			}
			finally{
				
			}
			return __route__;
		}
	}
	
	public static class ICacheRoute implements java.io.Serializable{
		private static final long serialVersionUID = -868170624266795511L;
		/*·�ɱ���*/
		private String _id;
		/*·������*/
		private String _cache;
		/*·����*/
		private String _group;
		/*�־û���*/
		private String _persistence;
		/*·������*/
		private String _desc;
		public ICacheRoute(){
			super();
			_id          = ICacheConst.IRoute.DATABASE;
			_cache       = ICacheConst.IRoute.DATABASE;
			_group       = ICacheConst.IRoute.DATABASE;
			_persistence = ICacheConst.IRoute.DEFAULT ;
		}
		
		public ICacheRoute( String id, String persistence ){
			super();
			_id          = id                         ;
			_cache       = ICacheConst.IRoute.DATABASE;
			_group       = ICacheConst.IRoute.DATABASE;
			_persistence = persistence                ;
		}
		
		public ICacheRoute( org.dom4j.Element _element ){
			super();
			_id          = _element.attributeValue( "id"         , "DATABASE" );
			_cache       = _element.attributeValue( "cache"      , "DATABASE" );
			_group       = _element.attributeValue( "group"      , "DATABASE" );
			_persistence = _element.attributeValue( "persistence", ICacheConst.IRoute.DEFAULT );
			_desc        = _element.attributeValue( "desc"       , ""         );
		}
		
		/**
		 * @return ·�ɱ���
		 */
		public String getID() {
			return _id;
		}
		
		/**
		 * @return ·������
		 */
		public String getCACHE() {
			return _cache;
		}
		
		/**
		 * @return ·����
		 */
		public String getGROUP() {
			return _group;
		}
		
		/**
		 * @return �־û���
		 */
		public String getPERSISTENCE() {
			return _persistence;
		}

		/**
		 * @return ·������
		 */
		public String getDESC() {
			return _desc;
		}
		
		/**
		 * �Ƿ񻺴�����Ϊ���ݿ�ģʽ
		 * @return
		 */
		public boolean isMYSQL(){
			return StringUtils.equals( _cache, ICacheConst.IRoute.DATABASE );
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
				org.dom4j.Element _cacheroute = _root.addElement( "_route_" );
				_cacheroute.addElement( "_id_"   ).setText( _id    );
				_cacheroute.addElement( "_type_" ).setText( _cache );
				_cacheroute.addElement( "_desc_" ).setText( _desc  );
				org.dom4j.Element _routegroup = _cacheroute.addElement( "_group_" );
				_routegroup.addElement( "_group_"   ).setText( _group       );
				_routegroup.addElement( "_dialect_" ).setText( _persistence );
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
	
	public static class IParameterGroup implements java.io.Serializable{
		private static final long serialVersionUID = -4500911289076772919L;
		private java.util.Map _group = new java.util.HashMap();
		public IParameterGroup() throws Exception{
			super();
		}
		
		public IParameterGroup( org.dom4j.Element fromRoot ) throws Exception{
			super();
			mergeAsGroup( fromRoot );
		}
		
		private void mergeAsGroup( org.dom4j.Element fromRoot ) throws Exception{
			java.util.List fromGroup = fromRoot.elements( "item" );
			for( java.util.Iterator itera = fromGroup.iterator(); itera.hasNext(); ){
				org.dom4j.Element _element = (org.dom4j.Element)itera.next();
				String _used = _element.attributeValue( "use", "TRUE" );
				if( _used.equalsIgnoreCase( "TRUE" ) == false ) continue;
				ICacheParameter group = new ICacheParameter( _element );
				_group.put( group.getGROUP(), group );
			}
		}
		
		/**
		 * @return the _group
		 */
		public java.util.Map getGROUP() {
			return _group;
		}
		
	}
	public static class ICacheParameter implements java.io.Serializable{
		private static final long serialVersionUID = -5049698803482689490L;
		private String _group = null;
		private String _desc  = null;
		private java.util.Map _parameter = new java.util.HashMap();
		public ICacheParameter( ){
			super();
		}
		
		public ICacheParameter( org.dom4j.Element fromRoot ) throws Exception {
			super();
			_group = fromRoot.attributeValue( "name" );
			_desc  = fromRoot.attributeValue( "desc" );
			java.util.List fromGroup = fromRoot.elements( "item" );
			for( java.util.Iterator itera = fromGroup.iterator(); itera.hasNext(); ){
				org.dom4j.Element _element = (org.dom4j.Element)itera.next();
				String _used = _element.attributeValue( "use", "TRUE" );
				if( _used.equalsIgnoreCase( "TRUE" ) == false ) continue;
				_parameter.put( _element.element("name"), _element.getTextTrim() );
			}
		}
		
		/**
		 * @return the _group
		 */
		public String getGROUP() {
			return _group;
		}

		/**
		 * @return the _desc
		 */
		public String getDESC() {
			return _desc;
		}

		/**
		 * @return the _parameter
		 */
		public java.util.Map getPARAM() {
			return _parameter;
		}
		
		/**
		 * ���ز�������
		 * @param ������
		 * @return
		 */
		public boolean getAsBoolean( String paramName ){
			return ClassUtils.IClass.getAsBoolean( getAsString( paramName ) );
		}

		/**
		 * �����ֽ�����
		 * @param paramName ������
		 * @return
		 */
		public byte getAsByte( String paramName ){
			return ClassUtils.IClass.getAsByte( getAsString( paramName ) );
		}

		/**
		 * ���ض������ͱ���
		 * @param paramName ������
		 * @return
		 */
		public short getAsShort( String paramName ){
			return ClassUtils.IClass.getAsShort( getAsString( paramName ) );
		}

		/**
		 * ���������ͱ���
		 * @param paramName ������
		 * @return
		 */
		public int getAsInt( String paramName ){
			return ClassUtils.IClass.getAsInt( getAsString( paramName ) );
		}

		/**
		 * ���������ͱ���
		 * @param paramName ������
		 * @param _default 
		 * @return
		 */
		public int getAsInt( String paramName, int _default ){
			String _param = getAsString( paramName );
			if( _param == null ){ return _default; }
			else{ return Integer.parseInt( _param ); }
		}
		
		/**
		 * ���س������ͱ���
		 * @param paramName ������
		 * @param _default
		 * @return
		 */
		public long getAsLong( String paramName  ){
			return Long.parseLong( getAsString( paramName ) );
		}
		
		/**
		 * ���س������ͱ���
		 * @param paramName ������
		 * @param _default
		 * @return
		 */
		public long getAsLong( String paramName, long _default  ){
			String _param = getAsString( paramName );
			if( _param == null ){ return _default; }
			else{ return Long.parseLong( _param ); }
		}
		
		/**
		 * ���ظ����ͱ���
		 * @param paramName ������
		 * @return
		 */
		public float getAsFloat( String paramName ){
			return ClassUtils.IClass.getAsFloat( getAsString( paramName ) );
		}
		
		/**
		 * ����˫���ȸ����ͱ���
		 * @param paramName ������
		 * @return
		 */
		public double getAsDouble( String paramName ){
			return ClassUtils.IClass.getAsDouble( getAsString( paramName ) );
		}
		
		/**
		 * �����ַ���
		 * @param paramName ������
		 * @return
		 */
		public String getAsString( String paramName ){
			return (String)_parameter.get( paramName );
		}
		
		/**
		 * ���������ͱ���
		 * @param paramName ������
		 * @return
		 */
		public java.util.Date getAsDate( String paramName ){
			return ClassUtils.IClass.getAsDate( getAsString( paramName ) );
		}
		
		/**
		 * ���������ͱ���
		 * @param paramName ������
		 * @return
		 */
		public java.sql.Timestamp getAsTimestamp( String paramName ){
			return ClassUtils.IClass.getAsTimestamp( getAsString( paramName ) );
		}
		
	}
	
	public static class IClusterGroup implements java.io.Serializable{
		private static final long serialVersionUID = -4140721881243684904L;
		private String _group = null;
		private java.util.HashMap _cluster = new java.util.HashMap();
		public IClusterGroup( String group ) throws Exception{
			super();
			_group = group;
		}
		
		public IClusterGroup( org.dom4j.Element fromRoot ) throws Exception {
			super();
			_group = fromRoot.attributeValue( "name" );
			java.util.List fromGroup = fromRoot.elements( "item" );
			for( java.util.Iterator itera = fromGroup.iterator(); itera.hasNext(); ){
				org.dom4j.Element _element = (org.dom4j.Element)itera.next();
				String _used = _element.attributeValue( "use", "TRUE" );
				if( _used.equalsIgnoreCase( "TRUE" ) == false ) continue;
				ICacheCluster fromCluster = new ICacheCluster( _element );
				if( _cluster.containsKey( fromCluster.getTYPE() ) == false ){
					_cluster.put( fromCluster.getTYPE(), new java.util.ArrayList() );
				}
				((java.util.List)_cluster.get( fromCluster.getTYPE() ) ).add( fromCluster );
			}
		}
		
		/**
		 * @return ��Ⱥ����
		 */
		public String getGROUP() {
			return _group;
		}

		/**
		 * @return ��Ⱥ�嵥
		 */
		public java.util.HashMap getCLUSTER() {
			return _cluster;
		}
		
		/**
		 * ��ȡ����Ⱥ�嵥
		 * @return
		 */
		public ICacheCluster[] getMASTER( ) {
			return getCLUSTER( ICacheConst.MASTER );
		}
		
		/**
		 * ��ȡ����Ⱥ�嵥
		 * @return
		 */
		public ICacheCluster[] getSLAVE( ) {
			return getCLUSTER( ICacheConst.SLAVE );
		}
		
		/**
		 * ���ݼ�Ⱥ���ͻ�ȡ��Ⱥ�嵥
		 * @param _id ��Ⱥ����
		 * @param _type ��Ⱥ����
		 * @return
		 */
		public ICacheCluster getCLUSTER( String _id, String _type ) {
			ICacheCluster fromCluster = null;
			java.util.List cluster = (java.util.List)_cluster.get( _type );
			if( cluster != null ){
				for( java.util.Iterator itera = cluster.iterator(); itera.hasNext(); ){
					ICacheCluster __cluster = (ICacheCluster)itera.next();
					if( StringUtils.equals( __cluster.getID(), _id ) ){
						fromCluster = __cluster;
						break;
					}
				}
			}
			return fromCluster;
		}
		
		/**
		 * ���ݼ�Ⱥ���ͻ�ȡ��Ⱥ�嵥
		 * @param _type ��Ⱥ����
		 * @return
		 */
		public ICacheCluster[] getCLUSTER( String _type ) {
			java.util.List fromCluster = (java.util.List)_cluster.get( _type );
			if( fromCluster == null ){
				return null;
			}
			else{
				return (ICacheCluster[])fromCluster.toArray( new ICacheCluster[]{} );
			}
		}
		
	}
	
	public static class ICacheCluster implements java.io.Serializable{
		private static final long serialVersionUID = 6391645303980047526L;
		private String _id = null;
		private String _type = null;
		private String _home = null;
		public ICacheCluster( org.dom4j.Element fromRoot ) throws Exception {
			super();
			_id   = fromRoot.attributeValue( "id"                       );
			_type = fromRoot.attributeValue( "type", ICacheConst.MASTER );
			_home = fromRoot.getTextTrim                               ();
		}
		
		/**
		 * @return ��Ⱥ����
		 */
		public String getID() {
			return _id;
		}
		
		/**
		 * @return ��Ⱥ����
		 */
		public String getTYPE() {
			return _type;
		}

		/**
		 * @return ��Ⱥ��ַ
		 */
		public String getHOME() {
			return _home;
		}
	}
	
	public static interface ICacheConst{
		/*����Ⱥ*/
		public final static String MASTER = "MASTER";
		/*����Ⱥ*/
		public final static String SLAVE  = "SLAVE" ;
		public static interface IRoute{
			/*���ݿ�*/
			public final static String DATABASE = "DATABASE";
			/*·�ɳ־û�*/
			public final static String DEFAULT  = com.ai.sacenter.cache.impl.DialectSystemImpl.class.getName();
		}
	}
}
