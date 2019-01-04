package com.ai.sacenter.jdbc;

import com.ai.appframe2.common.ObjectType;
import com.ai.appframe2.common.Operator;
import com.ai.appframe2.common.Property;
import com.ai.appframe2.common.Relation;
import com.ai.sacenter.jdbc.dialect.MySQL5HQSQLTable;
import com.ai.sacenter.jdbc.dialect.OracleHQSQLTable;
import com.ai.sacenter.jdbc.dialect.SybaseHQSQLTable;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.StringUtils;
import com.ai.sacenter.util.XmlUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014-10-8</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 3.0 
 */
public class HQSQLTable implements ObjectType,java.io.Serializable{
	private static final long serialVersionUID = -1780802204470125373L;
	/*表所在用户*/
	protected String owner;
	/*表名*/
	protected String table;
	/*类逻辑*/
	protected String bottle;
	/*表列*/
	protected java.util.HashMap column = new java.util.HashMap();
	/*主键*/
	protected java.util.HashMap primary = new java.util.HashMap();
	/*激活状态*/
	private int active ;
	/*SQL*/
	private HQSQLBottle destiny = null;
	public HQSQLTable() throws Exception{
		super();
		bottle = HQSQLEntityBean.class.getName()   ; 
		active = HQSQLConst.Category.Status.UNKNOWN;
	}
	
	public HQSQLTable( String _table_name) throws Exception{
		super();
		owner  = null                             ;
		table  = _table_name                      ;
		bottle = HQSQLEntityBean.class.getName()  ; 
		active = HQSQLConst.Category.Status.SCHEMA;
	}
	
	public HQSQLTable( ObjectType _schema ) throws Exception{
		super();
		owner  = _schema.getDataSource          ();
		table  = _schema.getMapingEnty          ();
		bottle = _schema.getFullName            ();
		_readFromFile( _schema                   );
		active = HQSQLConst.Category.Status.SCHEMA;
	}
	
	public HQSQLTable( HQSQLTable _table_, ObjectType _objecttype ) throws Exception{
		super();
		owner  = _table_.owner                    ;
		table  = _table_.table                    ;
		bottle = _objecttype.getFullName()        ; 
		_readFromFile( _table_                   );
		active = HQSQLConst.Category.Status.SCHEMA;
	}
	
	public HQSQLTable( String _owner, String _table_name) throws Exception{
		super();
		owner  = _owner                           ;
		table  = _table_name                      ;
		bottle = HQSQLEntityBean.class.getName()  ; 
		active = HQSQLConst.Category.Status.SCHEMA;
	}
	
	public HQSQLTable(String _owner, String _table_name, ObjectType _table) throws Exception{
		super();
		owner  = _owner                            ;
		table  = _table_name                       ;
		bottle = _table.getFullName()              ; 
		_readFromFile( _table                     );
		active = HQSQLConst.Category.Status.SCHEMA ;
	}

	/**
	 * 
	 * @param _schema
	 * @throws Exception
	 */
	private void _readFromFile( ObjectType _schema) throws Exception{
		for( java.util.Iterator itera = _schema.getProperties().values().iterator(); itera.hasNext(); ){
			Property _property = (Property)itera.next();
			if( _property instanceof HQSQLColumn ){ 
				HQSQLColumn _column = new HQSQLColumn( (HQSQLColumn)_property );
				column.put( _column.getName(), _column );
			}
			else{
				HQSQLColumn _column = new HQSQLColumn( _property ); 
				column.put( _column.getName(), _column );
			}
		}
		for( java.util.Iterator itera = _schema.getKeyProperties().keySet().iterator(); itera.hasNext(); ){
			String _property = (String)itera.next();
			HQSQLColumn _primary = (HQSQLColumn)column.get( _property );
			if( _primary == null ){ continue; }
			primary.put( _primary.getName(), _primary );
		}
	}
	
	/**
	 * 
	 */
	private void _preparedFromBottle(){
		java.util.HashMap _columns = new java.util.HashMap();
    	try
		{
    		destiny = new HQSQLBottle();
			for( java.util.Iterator itera = column.values().iterator(); itera.hasNext(); ){
				HQSQLColumn _column = (HQSQLColumn)itera.next();
				if( _column.isASTVirtual() ){ continue; }
				String fromINDEX = ClassUtils.getINDEX( new String[]{ ":", _column.getName() } );
				_columns.put( fromINDEX, _column.getName() );
			}
			destiny._create = "insert into " + table + " ( " + 
			           StringUtils.join( _columns.values().iterator(), " , ") + " ) values ( " + 
                           StringUtils.join( _columns.keySet().iterator(), "  , " ) + " ) ";
			destiny._query = "select " + StringUtils.join( _columns.values().iterator(), " , ") + 
					" from "+ table + " where 1 = 1 ";
			_columns.clear();
            for( java.util.Iterator itera = primary.values().iterator(); itera.hasNext(); ){
            	HQSQLColumn _column = (HQSQLColumn)itera.next();
            	String fromINDEX = ClassUtils.getINDEX( new String[]{ _column.getName(), " = :", _column.getName() } );
				_columns.put( _column.getName(), fromINDEX );
			}
            if( _columns != null && _columns.size() > 0 ){
            	destiny._delete = "delete from " + table + " where " + 
            	                 StringUtils.join( _columns.values().iterator(), " and ") + " ";
            	destiny._modify = "update " + table + " set {_MODIFY_HQSQL_} where " + 
	                             StringUtils.join( _columns.values().iterator(), " and ") + " ";
            }
		}
		finally{
			if( _columns != null ){ _columns.clear(); _columns = null;}
		}
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return table;
	}

	/**
	 * @return the owner
	 */
	public String getDataSource() {
		return owner;
	}
	
	/**
	 * @return the type
	 */
	public String getMapingEntyType() {
		return "table";
	}

	/**
	 * @return the table
	 */
	public String getMapingEnty() {
		return table;
	}

	/**
	 * @return the classname
	 */
	public String getClassName() {
		throw new java.lang.UnsupportedOperationException();
	}

	/**
	 * @return the fullname
	 */
	public String getFullName() {
		return bottle;
	}
	
	/**
	 * @return the column
	 */
	public java.util.HashMap getProperties() {
		return column;
	}

	/**
	 * 根据列名获取列定义
	 * @param columnname
	 * @return
	 */
	public HQSQLColumn getProperty(String columnname) {
		return (HQSQLColumn)column.get( columnname );
	}
    
	/**
	 * @return the columnname
	 */
	public String[] getPropertyNames() {
		return (String[])column.keySet().toArray( new String[]{} );
	}

	/**
	 * @param columnname
	 * @return
	 */
	public boolean hasProperty(String columnname) {
		HQSQLColumn _column = (HQSQLColumn)column.get( columnname );
		return _column != null?true:false;
	}

	/**
	 * @return the primary
	 */
	public java.util.HashMap getKeyProperties() {
		return primary;
	}

	/**
	 * @param columnname
	 * @return
	 */
	public boolean isKeyProperty(String columnname) {
		HQSQLColumn _column = (HQSQLColumn)primary.get( columnname );
		return _column != null?true:false;
	}

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(int _active) {
		active = _active;
		if( isACTIVE() ){ _preparedFromBottle(); }
	}
	
	/**
	 * @return the delegate
	 */
	public HQSQLBottle getSQL() {
		return destiny;
	}
	
	/**
	 * @return the mainattr
	 */
	public String getMainAttr() {
		String _mainattr = null;
		if( primary != null && primary.size() > 0 ){
			HQSQLColumn _column[] = (HQSQLColumn[])primary.values().toArray( new HQSQLColumn[]{} );
			_mainattr = _column != null && _column.length > 0?_column[ _column.length - 1 ].getName():null;
		}
		return _mainattr;
	}

	/**
	 * @return the datafilter
	 */
	public String getDataFilter() {
		return null;
	}
	
	/**
	 * @return the relation
	 */
	public Relation getRelation(String field) {
		return null;
	}

	/**
	 * @return the relations
	 */
	public java.util.HashMap getRelations() {
		return new java.util.HashMap();
	}

	/**
	 * @return the relation
	 */
	public boolean hasRelation(String field) {
		return false;
	}
	
	/**
	 * @return the operators
	 */
	public java.util.HashMap getOperators() {
		return new java.util.HashMap();
	}
	
	/**
	 * @return the operator
	 */
	public Operator getOperator(String field) {
		return null;
	}

	/**
	 * @return the operator
	 */
	public boolean hasOperator(String field) {
		return false;
	}

	/**
	 * @return the debug
	 */
	public String debug() {
		return "";
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSCHEMA(){
		return active == HQSQLConst.Category.Status.SCHEMA;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isACTIVE(){
		return active == HQSQLConst.Category.Status.ACTIVE;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTYPE(){
		return null;
	}
	
	/**
	 * 是否为JDBC_BO模式
	 * @return
	 */
	public boolean isORACLE(){
		return this instanceof OracleHQSQLTable;
	}
	
	/**
	 * 是否为JDBC_MYSQL模式
	 * @return
	 */
	public boolean isMYSQL5(){
		return this instanceof MySQL5HQSQLTable;
	}
	
	/**
	 * 是否为JDBC_SYBASE模式
	 * @return
	 */
	public boolean isSYBASE(){
		return this instanceof SybaseHQSQLTable;
	}
	
	/**
	 * JDBC模式
	 * @return
	 */
	public boolean isJDBC(){
		return this instanceof MySQL5HQSQLTable || this instanceof SybaseHQSQLTable;
	}
	
	/**
	 * 非APP模式和JDBC模式
	 * @return
	 */
	public boolean isCUSTOM(){
		return ( isORACLE() || isJDBC() ) == false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String _xml = null;
		try
		{
			org.dom4j.Document document = org.dom4j.DocumentHelper.createDocument();
			org.dom4j.Element _root = document.addElement( "InterBOSS" );
			_root.addElement( "OWNER" ).setText( owner != null?owner:""   );
			_root.addElement( "TABLE" ).setText( table != null?table:""   );
			_root.addElement( "BOTTLE").setText( bottle != null?bottle:"" );
			if( destiny != null && active == HQSQLConst.Category.Status.ACTIVE ){
				org.dom4j.Element _destiny = _root.addElement( "DESTINY" );
				_destiny.addElement( "_create" ).setText( destiny._create != null?destiny._create:"" );
				_destiny.addElement( "_delete" ).setText( destiny._delete != null?destiny._delete:"" );
				_destiny.addElement( "_modify" ).setText( destiny._modify != null?destiny._modify:"" );
				_destiny.addElement( "_query"  ).setText( destiny._query  != null?destiny._query:""  );
			}
			_xml = XmlUtils.IXml._format( document, "UTF-8" );
		}
		catch( java.lang.Exception exception ){
			_xml = super.toString();
		}
		return _xml;
	}
	
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2013-4-2</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class HQSQLColumn implements Property,java.io.Serializable{
		private static final long serialVersionUID = 4365563886200253940L;
		private String  _name     ;
		private String  _type     ;
		private Class   _javatype ;
		private String  _type_name;
		private int     _datatype ;
		private String  _nullable ;
		private int     _size     ;
		private int     _digits   ;
		private String  _default  ;
		public HQSQLColumn(){
			super();
			_type      = HQSQLConst.Category.Column.COLUMN;
			_javatype  = Column.Blank.class               ;
			_type_name = null                             ;
			_datatype  = java.sql.Types.NULL              ;
			_nullable  = HQSQLConst.Category.Null.Null    ;
			_size      = 0                                ;
			_digits    = 0                                ;
		}
		
		public HQSQLColumn( String name ){
			super();
			_name      = name                             ;
			_type      = HQSQLConst.Category.Column.COLUMN;
			_javatype  = Column.Blank.class               ;
			_type_name = null                             ;
			_datatype  = java.sql.Types.NULL              ;
			_nullable  = HQSQLConst.Category.Null.Null    ;
			_size      = Integer.MAX_VALUE                ;
			_digits    = 0                                ;
		}
		
		public HQSQLColumn( String name, Class javatype ){
			super();
			_name     = name                             ;
			_type     = HQSQLConst.Category.Column.COLUMN;
			_javatype = javatype                         ;
			_nullable = HQSQLConst.Category.Null.Null    ;
			_type_name = null                            ;
			_datatype = java.sql.Types.JAVA_OBJECT       ;
			_size     = Integer.MAX_VALUE                ;
			_digits   = 0                                ;
		}
		
		public HQSQLColumn( HQSQLColumn column ){
			super();
			_name      = column._name     ;
			_type      = column._type     ;
			_javatype  = column._javatype ;
			_type_name = column._type_name;
			_datatype  = column._datatype ;
			_nullable  = column._nullable ;
			_size      = column._size     ;
			_digits    = column._digits   ;
		}
		
		public HQSQLColumn( HQSQLColumn column, Object object ){
			super();
			_name     = column._name       ;
			_type     = column._type       ;
			if( object == null ){
				_javatype = Column.Blank.class;
			}
			else{
				_javatype = object.getClass() ;
			}
			_type_name = column._type_name ;
			_datatype  = column._datatype  ;
			_nullable  = column._nullable  ;
			_size      = column._size      ;
			_digits    = column._digits    ;
		}
		
		public HQSQLColumn( Property _column ) throws Exception{
			super();
			if( _column.getType().equalsIgnoreCase( "Virtual" ) ){
				_name      = _column.getName()                 ;
				_type      = HQSQLConst.Category.Column.VIRTUAL;
				_type_name = _column.getJavaDataType         ();
				_nullable  = HQSQLConst.Category.Null.Null     ;
				_size      = _column.getMaxLength()            ;
				_digits    = _column.getFloatLength()          ;
				wrapAsCalled( _column.getJavaDataType      () );
				_default   = _column.getDefaultValue         ();
			}
			else{
				_name      = _column.getMapingColName()        ;
				_type      = HQSQLConst.Category.Column.COLUMN ;
				if( _column.getType().equalsIgnoreCase( "PK" ) ){
					_type  = HQSQLConst.Category.Column.PRIMARY;
				}
				_type_name = _column.getDatabaseDataType()     ;
				_nullable  = HQSQLConst.Category.Null.Null     ;
				_size      = _column.getMaxLength()            ;
				_digits    = _column.getFloatLength()          ;
				wrapAsCalled( _column.getDatabaseDataType() )  ;
				_default   = _column.getDefaultValue        () ;
			}
		}
		
		public HQSQLColumn( java.sql.ResultSet result ) throws Exception{
			super();
			_name        = result.getString( "COLUMN_NAME" ).toUpperCase();
			_type        = HQSQLConst.Category.Column.COLUMN              ;
			_datatype    = result.getInt   ( "DATA_TYPE" )                ; 
			_type_name   = result.getString( "TYPE_NAME" )                ;
  			int _integer = result.getInt   ( "NULLABLE" )                 ;
  			if( _integer == java.sql.DatabaseMetaData.columnNoNulls ){
				_nullable = HQSQLConst.Category.Null.NoNull;
			}
			else if( _integer == java.sql.DatabaseMetaData.columnNullable ){
				_nullable = HQSQLConst.Category.Null.Null;
			}
			else{
				_nullable = HQSQLConst.Category.Null.Unknown;
			}
  			java.math.BigDecimal _decimal = result.getBigDecimal("COLUMN_SIZE");
  			if( _decimal != null ) { _size = _decimal.intValue();    }
  			_decimal = result.getBigDecimal( "DECIMAL_DIGITS"        );
  			if( _decimal != null ) { _digits = _decimal.intValue();  }
  			wrapAsCalled( result.getString( "TYPE_NAME" )            );
  			_datatype = result.getInt( "DATA_TYPE"                   ); 
		}
		
		/**
		 * @return the name
		 */
		public String getName() {
			return _name;
		}
		
		/**
		 * @return the name
		 */
		public String getMapingColName() {
			return _name;
		}
		
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			_name = name;
		}
		
		/**
		 * @return the _type
		 */
		public String getType() {
			return _type;
		}

		/**
		 * @param _type the _type to set
		 */
		public void setType(String type) {
			_type = type;
		}

		/**
		 * @return the javatype
		 */
		public Class getJavaType() {
			return _javatype;
		}
		
		/**
		 * @return the javatype
		 */
		public String getJavaDataType() {
			if( _javatype.equals( java.lang.Boolean.class ) ){
				return "Boolean";
			}
			else if( _javatype.equals( java.lang.Byte.class ) ){
				return "Byte";
			}
			else if( _javatype.equals( java.lang.Short.class ) ){
				return "Short";
			}
			else if( _javatype.equals( java.lang.Integer.class ) ){
				return "Int";
			}
			else if( _javatype.equals( java.lang.Long.class ) ){
				return "Long";
			}
			else if( _javatype.equals( java.lang.Float.class ) ){
				return "Float";
			}
			else if( _javatype.equals( java.lang.Double.class ) ){
				return "Double";
			}
			else if( _javatype.equals( java.sql.Date.class ) ){
				return "Date";
			}
			else if( _javatype.equals( java.sql.Time.class ) ){
				return "Time";
			}
			else if( _javatype.equals( java.sql.Timestamp.class ) ){
				return "DateTime";
			}
			return "String";
		}

		/**
		 * @param javatype the javatype to set
		 */
		public void setJavaType(Class javatype) {
			_javatype = javatype;
		}
		
		/**
		 * @return the type_name
		 */
		public String getTypeName() {
			return _type_name;
		}
		
		/**
		 * @return the type_name
		 */
		public String getDatabaseDataType() {
			return _type_name;
		}

		/**
		 * @param category the _category to set
		 */
		public void setTypeName(String type_name) {
			_type_name = type_name;
		}
		
		/**
		 * @return the datatype
		 */
		public int getDataType() {
			return _datatype;
		}

		/**
		 * @param datatype the datatype to set
		 */
		public void setDataType(int datatype) {
			_datatype = datatype ;
		}

		/**
		 * @return the nullable
		 */
		public String getNullable() {
			return _nullable;
		}
		
		/**
		 * @param nullable the nullable to set
		 */
		public void setNullable(String nullable) {
			_nullable = nullable;
		}
		
		/**
		 * @return the size
		 */
		public int getMaxLength() {
			return _size;
		}

		/**
		 * @param size the size to set
		 */
		public void setMaxLength(int size) {
			_size = size;
		}
		
		/**
		 * @return the digits
		 */
		public int getFloatLength() {
			return _digits;
		}
		
		/**
		 * @param digits the digits to set
		 */
		public void setFloatLength(int digits) {
			_digits = digits;
		}
		
		/**
		 * @return the _default
		 */
		public String getDefaultValue() {
			return _default;
		}

		/**
		 * @param _default the _default to set
		 */
		public void setFloatLength(String __default) {
			_default = __default;
		}
		
		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#getDisplayColNames()
		 */
		public String[] getDisplayColNames() {
			throw new java.lang.UnsupportedOperationException();
		}

		
		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#getRelationCondition()
		 */
		public String getRelationCondition() {
			throw new java.lang.UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#getRelationObjectTypeName()
		 */
		public String getRelationObjectTypeName() {
			throw new java.lang.UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#getRelationObjectTypeOutJoin()
		 */
		public String getRelationObjectTypeOutJoin() {
			throw new java.lang.UnsupportedOperationException();
		}

		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#getRemark()
		 */
		public String getRemark() {
			return "";
		}

		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#hasAlias()
		 */
		public boolean hasAlias() {
			return false;
		}

		/* (non-Javadoc)
		 * @see com.ai.appframe2.common.Property#isCollection()
		 */
		public boolean isCollection() {
			return false;
		}

		/**
		 * 
		 * @param category
		 * @return
		 * @throws Exception
		 */
		private Class wrapAsCalled( String category ) throws Exception{
			NString _category = new NString( category );
			if( _category.equals( "Boolean" ) ){
				_datatype = java.sql.Types.BOOLEAN ;
				_javatype = java.lang.Boolean.class;
			}
			else if( _category.equals( "Bit" ) ){
				_datatype = java.sql.Types.BIT     ;
				_javatype = java.lang.Boolean.class;
			}
			else if( _category.equals( "Byte" ) ){
				_datatype = java.sql.Types.TINYINT;
				_javatype = java.lang.Byte.class  ;
			}
			else if( _category.equals( "TinyInt" ) ){
				_datatype = java.sql.Types.TINYINT;
				_javatype = java.lang.Byte.class  ;
			}
			else if( _category.equals( "Binary" ) ){
				_datatype = java.sql.Types.BINARY ;
				_javatype = java.lang.Byte[].class  ;
			}
			else if( _category.equals( "Varbinary" ) ){
				_datatype = java.sql.Types.VARBINARY ;
				_javatype = java.lang.Byte[].class  ;
			}
			else if( _category.equals( "LongVarbinary" ) ){
				_datatype = java.sql.Types.LONGVARBINARY ;
				_javatype = java.lang.Byte[].class  ;
			}
			else if( _category.equals( "Blob" ) ){
				_datatype = java.sql.Types.BLOB     ;
				_javatype = java.lang.Byte[].class  ;
			}
			else if( _category.equals( "Clob" ) ){
				_datatype = java.sql.Types.CLOB     ;
				_javatype = java.lang.String.class  ;
			}
			else if( _category.equals( "Short" ) ){
				_datatype = java.sql.Types.SMALLINT;
				_javatype = java.lang.Short.class  ;
			}
			else if( _category.equals( "SmallInt" ) ){
				_datatype = java.sql.Types.SMALLINT;
				_javatype = java.lang.Short.class  ;
			}
			else if( _category.equals( "Int" ) ){
				_datatype = java.sql.Types.INTEGER ;
				_javatype = java.lang.Integer.class;
			}
			else if( _category.equals( "Integer" ) ){
				_datatype = java.sql.Types.INTEGER ;
				_javatype = java.lang.Integer.class;
			}
			else if( _category.equals( "Long" ) ){
				_datatype = java.sql.Types.DECIMAL ;
				_javatype = java.lang.Long.class   ;
			}
			else if( _category.equals( "BigInt" ) ){
				_datatype = java.sql.Types.BIGINT  ;
				_javatype = java.lang.Long.class   ;
			}
			else if( _category.equals( "Float" ) ){
				_datatype = java.sql.Types.FLOAT ;
				_javatype = java.lang.Float.class;
			}
			else if( _category.equals( "Real" ) ){
				_datatype = java.sql.Types.REAL  ;
				_javatype = java.lang.Float.class;
			}
			else if( _category.equals( "Double" ) ){
				_datatype = java.sql.Types.DOUBLE ;
				_javatype = java.lang.Double.class;
			}
			else if( _category.equals( "Number" ) ){
				_datatype = java.sql.Types.DECIMAL ;
				_javatype = java.lang.Long.class   ;
				if( _size <=0 ){ _size = 20; _digits = 0; }
				else if( _digits > 0 ){
					_javatype = java.lang.Double.class;
					if( _size <= 101 ){ _javatype = java.lang.Float.class; }
				}
			}
			else if( _category.equals( "Numeric" ) ){
				_datatype = java.sql.Types.NUMERIC;
				_javatype = java.lang.Long.class   ;
				if( _size <=0 ){ _size = 20; _digits = 0; }
				else if( _digits > 0 ){
					_javatype = java.lang.Double.class;
					if( _size <= 101 ){ _javatype = java.lang.Float.class; }
				}
			}
			else if( _category.equals( "Decimal" ) ){
				_datatype = java.sql.Types.DECIMAL ;
				_javatype = java.lang.Long.class   ;
				if( _size <=0 ){ _size = 20; _digits = 0; }
				else if( _digits > 0 ){
					_javatype = java.lang.Double.class;
					if( _size <= 101 ){ _javatype = java.lang.Float.class; }
				}
			}
			else if( _category.startsWith( "TimeStamp" ) ){
				_datatype = java.sql.Types.TIMESTAMP;
				_javatype = java.sql.Timestamp.class;
			}
			else if( _category.startsWith( "DateTime" ) ){
				_datatype = java.sql.Types.TIMESTAMP;
				_javatype = java.sql.Timestamp.class;
			}
			else if( _category.equals( "Date" ) ){
				_datatype = java.sql.Types.DATE;
				_javatype = java.sql.Date.class;
				String _compatible = System.getProperty( "oracle.jdbc.V8Compatible" );
				if( _compatible != null && _compatible.equalsIgnoreCase( "TRUE" ) ){
					_datatype = java.sql.Types.TIMESTAMP;
					_javatype = java.sql.Timestamp.class  ;
				}
			}
			else if( _category.startsWith( "Time" ) ){
				_datatype = java.sql.Types.TIME;
				_javatype = java.sql.Time.class;
			}
			else if( _category.equals( "Char" ) ){
				_datatype = java.sql.Types.CHAR      ;
				_javatype = java.lang.String.class   ;
			}
			else if( _category.equals( "Character" ) ){
				_datatype = java.sql.Types.CHAR      ;
				_javatype = java.lang.String.class   ;
			}
			else if( _category.equals("Varchar") ){
				_datatype = java.sql.Types.VARCHAR;
				_javatype = java.lang.String.class;
			}
			else if( _category.equals("NVarchar") ){
				_datatype = java.sql.Types.NVARCHAR;
				_javatype = java.lang.String.class ;
			}
			else if( _category.equals( "Varchar2" ) ){
				_datatype = java.sql.Types.VARCHAR;
				_javatype = java.lang.String.class;
			}
			else if( _category.equals( "String" ) ){
				_datatype = java.sql.Types.VARCHAR;
				_javatype = java.lang.String.class;
			}
            else if( _category.equals( "LongVarchar" ) ){
				_datatype = java.sql.Types.LONGVARCHAR;
				_javatype = java.lang.String.class;
			}
			else if( _category.equals( "LongNVarchar" ) ){
				_datatype = java.sql.Types.LONGNVARCHAR;
				_javatype = java.lang.String.class     ;
			}
			else{
				_datatype = java.sql.Types.JAVA_OBJECT;
				_javatype = java.lang.Object.class    ;
			}
			return _javatype;
		}
		
		/**
		 * 是否为主键
		 * @return
		 */
		public boolean isASTPrimary(){
			return _type.equalsIgnoreCase( HQSQLConst.Category.Column.PRIMARY );
		}
		
		/**
		 * 是否为实体字段
		 * @return
		 */
		public boolean isASTColumn(){
			return _type.equalsIgnoreCase( HQSQLConst.Category.Column.COLUMN ) || 
					_type.equalsIgnoreCase( HQSQLConst.Category.Column.PRIMARY );
		}
		
		/**
		 * 是否为虚拟字段
		 * @return
		 */
		public boolean isASTVirtual(){
			return _type.equalsIgnoreCase( HQSQLConst.Category.Column.VIRTUAL );
		}
		
		/**
		 * 是否空类型
		 * @return
		 */
		public boolean isASTBlank(){
			return Column.Blank.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否布尔类型
		 * @return
		 */
		public boolean isASTBoolean( ){
			return java.lang.Boolean.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否字节数组
		 * @return
		 */
		public boolean isASTArray(){
			return java.lang.Byte[].class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否字节类型
		 * @return
		 */
		public boolean isASTByte( ){
			return java.lang.Byte.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否短整数类型
		 * @return
		 */
		public boolean isASTShort( ){
			return java.lang.Short.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否整数类型
		 * @return
		 */
		public boolean isASTInt( ){
			return java.lang.Integer.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否长整数类型
		 * @return
		 */
		public boolean isASTLong( ){
			return java.lang.Long.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否单精度类型
		 * @return
		 */
		public boolean isASTFloat( ){
			return java.lang.Float.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否双精度类型
		 * @return
		 */
		public boolean isASTDouble( ){
			return java.lang.Double.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否为大整数[BigInteger]
		 * @return
		 */
		public boolean isASTMumeric(){
			return java.math.BigInteger.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否为大数字[BigDecimal]
		 * @return
		 */
		public boolean isASTDecimal(){
			return java.math.BigDecimal.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否为时间类型
		 * @return
		 */
		public boolean isASTTime(){
			return java.sql.Time.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否日期类型
		 * @return
		 */
		public boolean isASTDate(){
			return java.sql.Date.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否日期时间类型
		 * @return
		 */
		public boolean isASTTimestamp(){
			return java.sql.Timestamp.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否数字字段
		 * @return
		 */
		public boolean isASTDigital(){
			return java.lang.Number.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否字符类型
		 * @return
		 */
		public boolean isASTChar( ){
			return java.lang.Character.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否字符串类型
		 * @return
		 */
		public boolean isASTString( ){
			return java.lang.String.class.isAssignableFrom( _javatype );
		}
		
		/**
		 * 是否其他类型
		 * @return
		 */
		public boolean isASTObject( ){
			return java.lang.Object.class.isAssignableFrom( _javatype ) || _datatype == java.sql.Types.JAVA_OBJECT;
		}
		
		/**
		 * 是否可空
		 */
		public boolean isASTNull(){
			return _nullable == null || _nullable.equals( HQSQLConst.Category.Null.NoNull ) == false;
		}
		
		/**
		 * 是否不可空
		 * @return
		 */
		public boolean isASTNoNull(){
			return _nullable != null && _nullable.equals( HQSQLConst.Category.Null.NoNull );
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			boolean _equal = false;
			try
			{
				if( obj instanceof HQSQLColumn ){
					_equal = _name.equals( ((HQSQLColumn)obj)._name );
				}
				else if( obj instanceof java.lang.String ){
					_equal = _name.equals( (String)obj );
				}
			}
			finally{
				
			}
			return _equal;
		}
		
		public class NString implements java.io.Serializable{
			private static final long serialVersionUID = -6874592456745533695L;
			private String _string;
			public NString( String string ){
				super();
				_string = string;
			}
			
			/**
			 * @return the _string
			 */
			public String getString() {
				return _string;
			}

			/**
			 * 是否相同[忽律大小写]
			 * @param string
			 * @return
			 */
			public boolean equals( String string ){
				return _string != null && string != null && _string.equalsIgnoreCase( string );
			}
			
			/**
			 * 
			 * @param string
			 * @return
			 */
			public boolean startsWith( String string ){
				return _string != null && string != null && _string.toUpperCase().startsWith( string.toUpperCase() );
			}
		}
		
		public static class Column implements java.io.Serializable{
			private static final long serialVersionUID = 6673280031987284253L;
			public Column(){
				super();
			}
			
			public static class Blank implements java.io.Serializable{
				private static final long serialVersionUID = 5633786151632758323L;
				public Blank(){
					super();
				}
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-10-29</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class HQSQLBottle implements java.io.Serializable{
		private static final long serialVersionUID = -1629836721297231789L;
		/*目标SQL[INSERT]*/
		protected String _create;
		/*源表SQL[DELETE]*/
		protected String _delete;
		/*源表SQL[UPDATE]*/
		protected String _modify;
		/*源表SQL[SELECT]*/
		protected String _query;
		public HQSQLBottle(){
			super();
		}
		
		/**
		 * @return the cREATE
		 */
		public String getCREATE() {
			return _create;
		}
		
		/**
		 * @return the dELETE
		 */
		public String getDELETE() {
			return _delete;
		}
		
		/**
		 * @return the mODIFY
		 */
		public String getMODIFY() {
			return _modify;
		}
		
		/**
		 * @return the qUERY
		 */
		public String getQUERY() {
			return _query;
		}
	}
	
}
