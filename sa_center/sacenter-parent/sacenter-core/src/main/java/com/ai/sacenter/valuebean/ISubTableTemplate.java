package com.ai.sacenter.valuebean;

import com.ai.sacenter.IUpdcConst;
import com.ai.sacenter.base.basic.bo.ISAIdGenerator;
import com.ai.sacenter.base.basic.bo.ISASubTable;
import com.ai.sacenter.base.basic.bo.ISASubTableCau;
import com.ai.sacenter.base.basic.bo.ISASubTableCol;
import com.ai.sacenter.base.basic.bo.ISASubTableRel;
import com.ai.sacenter.util.ClassUtils;
import com.ai.sacenter.util.OracleUtils;
import com.ai.sacenter.util.StringUtils;

/**
 * <p>Title: ucmframe</p>
 * <p>Description: 分表规则</p>
 * <p>Copyright: Copyright (c) 2013-4-1</p>
 * <p>Company: AI(NanJing)</p>
 * @author maohuiyun
 * @version 2.0 
 *
 */
public class ISubTableTemplate implements java.io.Serializable{
	private static final long serialVersionUID = -5747856760273000100L;
	public ISubTableTemplate() {
		super();
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-10-8</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class IdGenerator implements java.io.Serializable{
		private static final long serialVersionUID = -8548969031987407477L;
		private long   ID           ;                                                     
		private String TABLE        ;                                                     
		private String CHANNEL      ;
		private String REGION       ;                                                     
		private String DESCRIPTION  ;                                                     
		private String SEQUENCE     ; 
		private String REGION_NUMBER;
		private String FUNCTION     ;  
		private String CONTROL      ;                                                     
		private Object IMPLCLASS    ;
		public IdGenerator(ISAIdGenerator aIdGenerator) throws Exception{
			super();
			ID            = aIdGenerator.getId          ();                                                     
			TABLE         = aIdGenerator.getTableName   ();                                                     
			CHANNEL       = aIdGenerator.getChannelId   ();
			REGION        = aIdGenerator.getRegionId    ();                                                     
			DESCRIPTION   = aIdGenerator.getDescription ();                                                     
			SEQUENCE      = aIdGenerator.getSequence    ();     
			REGION_NUMBER = aIdGenerator.getRegionNumber();
			FUNCTION      = aIdGenerator.getFunction    ();                                                     
			CONTROL       = aIdGenerator.getControl     ();                                                     
			if( StringUtils.isBlank( FUNCTION ) == false ){
				IMPLCLASS = Class.forName( FUNCTION ).newInstance();
			}
		}
		
		/**
		 * @return the cHANNEL
		 */
		public String getCHANNEL() {
			return CHANNEL;
		}

		/**
		 * @param channel the cHANNEL to set
		 */
		public void setCHANNEL(String channel) {
			CHANNEL = channel;
		}

		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}

		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}

		/**
		 * @return the fUNCTION
		 */
		public String getFUNCTION() {
			return FUNCTION;
		}

		/**
		 * @param function the fUNCTION to set
		 */
		public void setFUNCTION(String function) {
			FUNCTION = function;
		}

		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}

		/**
		 * @param id the iD to set
		 */
		public void setID(long id) {
			ID = id;
		}

		/**
		 * @return the iMPLCLASS
		 */
		public Object getIMPLCLASS() {
			return IMPLCLASS;
		}

		/**
		 * @param implclass the iMPLCLASS to set
		 */
		public void setIMPLCLASS(Object implclass) {
			IMPLCLASS = implclass;
		}

		/**
		 * @return the rEGION
		 */
		public String getREGION() {
			return REGION;
		}

		/**
		 * @param region the rEGION to set
		 */
		public void setREGION(String region) {
			REGION = region;
		}

		/**
		 * @return the rEGION_NUMBER
		 */
		public String getREGION_NUMBER() {
			return REGION_NUMBER;
		}

		/**
		 * @param region_number the rEGION_NUMBER to set
		 */
		public void setREGION_NUMBER(String region_number) {
			REGION_NUMBER = region_number;
		}

		/**
		 * @return the sEQUENCE
		 */
		public String getSEQUENCE() {
			return SEQUENCE;
		}

		/**
		 * @param sequence the sEQUENCE to set
		 */
		public void setSEQUENCE(String sequence) {
			SEQUENCE = sequence;
		}

		/**
		 * @return the tABLE
		 */
		public String getTABLE() {
			return TABLE;
		}

		/**
		 * @param table the tABLE to set
		 */
		public void setTABLE(String table) {
			TABLE = table;
		}

		/**
		 * 是否采用APP模式
		 * @return
		 */
		public boolean isAPP(){
			return FUNCTION == null || StringUtils.isBlank( FUNCTION );
		}
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 网元全量分表规范</p>
	 * <p>Copyright: Copyright (c) 2018年4月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISubSQLCombine implements java.io.Serializable{
		private static final long serialVersionUID = -4913652325966899198L;
		private java.util.HashMap SUBFLOW = new java.util.HashMap();
		public ISubSQLCombine(){
			super();
		}
		
		/**
		 * @return the sUBFLOW
		 */
		public java.util.HashMap getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * 
		 * @param _PLATFORM
		 * @return
		 */
		public ISubSQLGroup getSUBFLOW( String _PLATFORM ){
			return (ISubSQLGroup)SUBFLOW.get( _PLATFORM );
		}
		
		/**
		 * 
		 * @param _network
		 * @throws Exception
		 */
		public void mergeAsNetWork( ISubSQLGroup _network ) throws Exception{
			SUBFLOW.put( _network.getPLATFORM(), _network );
		}
		
	}
	
	/**
	 * 
	 * <p>Title: sacenter-core</p>
	 * <p>Description: 网元分表规范</p>
	 * <p>Copyright: Copyright (c) 2018年4月27日</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISubSQLGroup implements java.io.Serializable{
		private static final long serialVersionUID = -4301163423341236617L;
		private String PLATFORM;
		private java.util.HashMap SUBFLOW = new java.util.HashMap();
		public ISubSQLGroup( ISASubTable _subtable ){
			super();
			PLATFORM = _subtable.getPlatform();
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}

		/**
		 * @return the sUBFLOW
		 */
		public java.util.HashMap getSUBFLOW() {
			return SUBFLOW;
		}
		
		/**
		 * 
		 * @param _table
		 * @return
		 */
		public ISubSQLTable getSUBFLOW( String _table ){
			ISubSQLTable fromSubSQL = null;
			try
			{
				String _table_name = OracleUtils.ICustom.getTableName( _table );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_BASIC, 
						new String[]{ _table_name } );
				fromSubSQL = (ISubSQLTable)SUBFLOW.get( fromINDEX );
			}
			finally{
				
			}
			return fromSubSQL;
		}
		
		/**
		 * 
		 * @param _subtable
		 * @throws Exception
		 */
		public void mergeAsSubFlow( ISASubTable _subtable ) throws Exception{
			try
			{
				ISubSQLTable fromSubSQL = new ISubSQLTable( _subtable );
				String _table_name = OracleUtils.ICustom.getTableName( fromSubSQL.getTABLE() );
				String fromINDEX = ClassUtils.getINDEX( IUpdcConst.ICache.ICachePref.I_SUBTABLE_BASIC, 
						new String[]{ _table_name } );
				SUBFLOW.put( fromINDEX, fromSubSQL );
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _table
		 * @param _category
		 * @return
		 */
		public ISubSQLTableRel getSUBJECT( String _table, String _category ){
			ISubSQLTableRel fromSubJect = null;
			try
			{
				ISubSQLTable fromSubSQL = getSUBFLOW( _table );
				if( fromSubSQL != null ){
					fromSubJect = (ISubSQLTableRel)fromSubSQL.getTARGET().get( _category );
				}
			}
			finally{
				
			}
			return fromSubJect;
		}
		
		/**
		 * 
		 * @param aSubTableRel
		 */
		public void mergeAsSubJect( ISASubTableRel aSubTableRel ){
			try
			{
				ISubSQLTable fromSubSQL = getSUBFLOW( aSubTableRel.getTableName() );
				if( fromSubSQL != null ){
					ISubSQLTableRel fromSubJect = new ISubSQLTableRel( aSubTableRel );
					fromSubSQL.getTARGET().put( fromSubJect.getCATEGORY(), fromSubJect );
				}
			}
			finally{
				
			}
		}
		
		/**
		 * 
		 * @param _table
		 * @param _category
		 * @return
		 */
		public java.util.List getSUBJSQL( String _table, String _category ){
			java.util.List fromSubJSQL = null;
			try
			{
				ISubSQLTableRel fromSubJect = getSUBJECT( _table, _category );
				if( fromSubJect != null ){ fromSubJSQL = fromSubJect.getMAPPING(); }
			}
			finally{
				
			}
			return fromSubJSQL;
		}
		
		/**
		 * 
		 * @param aSubTableCol
		 */
		public void mergeAsSubJSQL( ISASubTableCol aSubTableCol ){
			try
			{
				ISubSQLTableRel fromSubJect = getSUBJECT( aSubTableCol.getTableName(), aSubTableCol.getCategory() );
				if( fromSubJect != null ){ fromSubJect.getMAPPING().add( new ISubSQLTableCol( aSubTableCol ) ); }
			}
			finally{
				
			}
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 分表规范/p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ISubSQLTable implements java.io.Serializable{
		private static final long serialVersionUID = 6709035004217949418L;
		private String TABLE        ;
		private String PLATFORM_    ;
		private String DESCRIPTION  ;
		private String PERSISTENT   ;
		private String CONTROL      ;
		private String SEQUENCE     ;
		private long   LOCATION     ;
		private String BASE         ;
		private String BUFFER       ;
		private String MULTIPLE     ;
		private String SUGGEST      ;
		private String FAIL         ;
		private String HISTORY      ;
		private java.util.HashMap TARGET = new java.util.HashMap();
		public ISubSQLTable(ISASubTable aSubTable) throws Exception{
			super();
			TABLE         = aSubTable.getTableName    ();
			PLATFORM_     = aSubTable.getPlatform     ();
			DESCRIPTION   = aSubTable.getDescription  ();
			PERSISTENT    = aSubTable.getPersistent   ();
			CONTROL       = aSubTable.getControl      ();
			SEQUENCE      = aSubTable.getSequence     ();
			LOCATION      = aSubTable.getLocation     ();
			BASE          = aSubTable.getBase         ();
			BUFFER        = aSubTable.getBuffer       ();
			MULTIPLE      = aSubTable.getMultiple     ();
			SUGGEST       = aSubTable.getSuggest      ();
			FAIL          = aSubTable.getFail         ();
			HISTORY       = aSubTable.getHistory      ();
		}
		
		/**
		 * @return the bASE
		 */
		public String getBASE() {
			return BASE;
		}

		/**
		 * @param base the bASE to set
		 */
		public void setBASE(String base) {
			BASE = base;
		}

		/**
		 * @return the bUFFER
		 */
		public String getBUFFER() {
			return BUFFER;
		}

		/**
		 * @param buffer the bUFFER to set
		 */
		public void setBUFFER(String buffer) {
			BUFFER = buffer;
		}

		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}

		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}

		/**
		 * @return the fAIL
		 */
		public String getFAIL() {
			return FAIL;
		}

		/**
		 * @param fail the fAIL to set
		 */
		public void setFAIL(String fail) {
			FAIL = fail;
		}

		/**
		 * @return the hISTORY
		 */
		public String getHISTORY() {
			return HISTORY;
		}

		/**
		 * @param history the hISTORY to set
		 */
		public void setHISTORY(String history) {
			HISTORY = history;
		}

		/**
		 * @return the lOCATION
		 */
		public long getLOCATION() {
			return LOCATION;
		}

		/**
		 * @param location the lOCATION to set
		 */
		public void setLOCATION(long location) {
			LOCATION = location;
		}

		/**
		 * @return the mULTIPLE
		 */
		public String getMULTIPLE() {
			return MULTIPLE;
		}

		/**
		 * @param multiple the mULTIPLE to set
		 */
		public void setMULTIPLE(String multiple) {
			MULTIPLE = multiple;
		}

		/**
		 * @return the pERSISTENT
		 */
		public String getPERSISTENT() {
			return PERSISTENT;
		}

		/**
		 * @param persistent the pERSISTENT to set
		 */
		public void setPERSISTENT(String persistent) {
			PERSISTENT = persistent;
		}

		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}

		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}

		/**
		 * @return the sEQUENCE
		 */
		public String getSEQUENCE() {
			return SEQUENCE;
		}

		/**
		 * @param sequence the sEQUENCE to set
		 */
		public void setSEQUENCE(String sequence) {
			SEQUENCE = sequence;
		}

		/**
		 * @return the sUGGEST
		 */
		public String getSUGGEST() {
			return SUGGEST;
		}

		/**
		 * @param suggest the sUGGEST to set
		 */
		public void setSUGGEST(String suggest) {
			SUGGEST = suggest;
		}

		/**
		 * @return the tABLE
		 */
		public String getTABLE() {
			return TABLE;
		}

		/**
		 * @param table the tABLE to set
		 */
		public void setTABLE(String table) {
			TABLE = table;
		}

		/**
		 * @param target the tARGET to set
		 */
		public void setTARGET(java.util.HashMap target) {
			TARGET = target;
		}

		/**
		 * @return the tARGET
		 */
		public java.util.HashMap getTARGET() {
			return TARGET;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 分表规则/p>
	 * <p>Copyright: Copyright (c) 2011-10-13</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 2.0 
	 *
	 */
	public static class ISubSQLTableRel implements java.io.Serializable{
		private static final long serialVersionUID = 7500788326339472595L;
		private String TABLE        ;
		private String PLATFORM_    ;
		private String DESCRIPTION  ;
		private String CATEGORY     ;
		private String TARGET       ;
		private String PERSISTENT   ;
		private String CONTROL      ;
		private java.util.List MAPPING = new java.util.ArrayList();
		public ISubSQLTableRel( ISASubTableRel aSubTableRel ){
			super();
			TABLE         = aSubTableRel.getTableName    ();
			PLATFORM_     = aSubTableRel.getPlatform     ();
			DESCRIPTION   = aSubTableRel.getDescription  ();
			CATEGORY      = aSubTableRel.getCategory     ();
			TARGET        = aSubTableRel.getTarget       ();
			PERSISTENT    = aSubTableRel.getPersistent   ();
			CONTROL       = aSubTableRel.getControl      ();
		}
		
		/**
		 * @return the cATEGORY
		 */
		public String getCATEGORY() {
			return CATEGORY;
		}

		/**
		 * @param category the cATEGORY to set
		 */
		public void setCATEGORY(String category) {
			CATEGORY = category;
		}

		/**
		 * @return the cONTROL
		 */
		public String getCONTROL() {
			return CONTROL;
		}

		/**
		 * @param control the cONTROL to set
		 */
		public void setCONTROL(String control) {
			CONTROL = control;
		}

		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}

		/**
		 * @param description the dESCRIPTION to set
		 */
		public void setDESCRIPTION(String description) {
			DESCRIPTION = description;
		}

		/**
		 * @return the pERSISTENT
		 */
		public String getPERSISTENT() {
			return PERSISTENT;
		}

		/**
		 * @param persistent the pERSISTENT to set
		 */
		public void setPERSISTENT(String persistent) {
			PERSISTENT = persistent;
		}

		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}

		/**
		 * @param platform_ the pLATFORM_ to set
		 */
		public void setPLATFORM_(String platform_) {
			PLATFORM_ = platform_;
		}

		/**
		 * @return the tABLE
		 */
		public String getTABLE() {
			return TABLE;
		}

		/**
		 * @param table the tABLE to set
		 */
		public void setTABLE(String table) {
			TABLE = table;
		}

		/**
		 * @param mapping the mAPPING to set
		 */
		public void setMAPPING(java.util.List mapping) {
			MAPPING = mapping;
		}

		/**
		 * @param target the tARGET to set
		 */
		public void setTARGET(String target) {
			TARGET = target;
		}

		/**
		 * @return the tARGET
		 */
		public String getTARGET() {
			return TARGET;
		}
		/**
		 * @return the mAPPING
		 */
		public java.util.List getMAPPING() {
			return MAPPING;
		}
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: 异步目标列映射</p>
	 * <p>Copyright: Copyright (c) 2014-7-1</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISubSQLTableCol extends ISystemTemplate.IUpfgsmxOffer implements java.io.Serializable{
		private static final long serialVersionUID = -6442986471473264090L;
		private String TABLE        ;
		private String PLATFORM     ;
		public ISubSQLTableCol(ISASubTableCol fromCol){
			super();
			ID            = String.valueOf(fromCol.getColumnId());
			NAME          = fromCol.getDescription (); 
			CATEGORY      = fromCol.getCategory    (); 
			SORT_BY       = fromCol.getSortBy      ();
			PLATFORM      = fromCol.getPlatform    (); 
			COMPETE       = fromCol.getSrcColumn   ();
			MAPPING       = fromCol.getDestColumn  ();
			TABLE         = fromCol.getTableName   ();
			IMPLCLASS     = fromCol.getImplclass   (); 
			COMPLEX       = fromCol.getComplex     (); 
			CONTROL       = fromCol.getControl     (); 
		}
		
		/**
		 * @return the pLATFORM
		 */
		public String getPLATFORM() {
			return PLATFORM;
		}
		
		/**
		 * @param platform the pLATFORM to set
		 */
		public void setPLATFORM(String platform) {
			PLATFORM = platform;
		}
		
		/**
		 * @return the tABLE
		 */
		public String getTABLE() {
			return TABLE;
		}
		
		/**
		 * @param table the tABLE to set
		 */
		public void setTABLE(String table) {
			TABLE = table;
		}
		
	}
	/**
	 * 
	 * <p>Title: ucmframe</p>
	 * <p>Description: </p>
	 * <p>Copyright: Copyright (c) 2014-3-25</p>
	 * <p>Company: AI(NanJing)</p>
	 * @author maohuiyun
	 * @version 3.0
	 */
	public static class ISubSQLTableCau implements java.io.Serializable{
		private static final long serialVersionUID = -2871384906474349211L;
		private long   ID          ;    
		private String TABLE       ;    
		private String NAME        ;    
		private String COLUMN      ;    
		private String PLATFORM_   ;    
		private String DESCRIPTION ;    
		private String SUFFIX_A    ;    
		private String SUFFIX_B    ;    
		private String SUFFIX_C    ;    
		private String SUFFIX_D    ;    
		private String SUFFIX_E    ;    
		private String SUFFIX_F    ;    
		private String SUFFIX_G    ;    
		private String SUFFIX_H    ;    
		private String SUFFIX_I    ;    
		private String SUFFIX_J    ;    
		private String SUFFIX_K    ;    
		private String SUFFIX_L    ;    
		private String SUFFIX_M    ;    
		private String SUFFIX_N    ;    
		private String SUFFIX_O    ;
		public ISubSQLTableCau( ISASubTableCau aSubTableCol ){
			super();
			ID           = aSubTableCol.getColumnId     ();    
			TABLE        = aSubTableCol.getTableName    ();    
			NAME         = aSubTableCol.getColumnName   ();    
			COLUMN       = aSubTableCol.getColumnValue  ();    
			PLATFORM_    = aSubTableCol.getPlatform     ();    
			DESCRIPTION  = aSubTableCol.getDescription  ();    
			SUFFIX_A     = aSubTableCol.getSuffixA      ();    
			SUFFIX_B     = aSubTableCol.getSuffixB      ();    
			SUFFIX_C     = aSubTableCol.getSuffixC      ();    
			SUFFIX_D     = aSubTableCol.getSuffixD      ();    
			SUFFIX_E     = aSubTableCol.getSuffixE      ();    
			SUFFIX_F     = aSubTableCol.getSuffixF      ();    
			SUFFIX_G     = aSubTableCol.getSuffixG      ();    
			SUFFIX_H     = aSubTableCol.getSuffixH      ();    
			SUFFIX_I     = aSubTableCol.getSuffixI      ();    
			SUFFIX_J     = aSubTableCol.getSuffixJ      ();    
			SUFFIX_K     = aSubTableCol.getSuffixK      ();    
			SUFFIX_L     = aSubTableCol.getSuffixL      ();    
			SUFFIX_M     = aSubTableCol.getSuffixM      ();    
			SUFFIX_N     = aSubTableCol.getSuffixN      ();    
			SUFFIX_O     = aSubTableCol.getSuffixO      ();
		}
		
		/**
		 * @return the cOLUMN
		 */
		public String getCOLUMN() {
			return COLUMN;
		}
		
		/**
		 * @return the dESCRIPTION
		 */
		public String getDESCRIPTION() {
			return DESCRIPTION;
		}
		
		/**
		 * @return the iD
		 */
		public long getID() {
			return ID;
		}
		
		/**
		 * @return the nAME
		 */
		public String getNAME() {
			return NAME;
		}
		
		/**
		 * @return the pLATFORM_
		 */
		public String getPLATFORM_() {
			return PLATFORM_;
		}
		
		/**
		 * @return the sUFFIX_A
		 */
		public String getSUFFIX_A() {
			return SUFFIX_A;
		}
		
		/**
		 * @return the sUFFIX_B
		 */
		public String getSUFFIX_B() {
			return SUFFIX_B;
		}
		
		/**
		 * @return the sUFFIX_C
		 */
		public String getSUFFIX_C() {
			return SUFFIX_C;
		}
		
		/**
		 * @return the sUFFIX_D
		 */
		public String getSUFFIX_D() {
			return SUFFIX_D;
		}
		
		/**
		 * @return the sUFFIX_E
		 */
		public String getSUFFIX_E() {
			return SUFFIX_E;
		}
		
		/**
		 * @return the sUFFIX_F
		 */
		public String getSUFFIX_F() {
			return SUFFIX_F;
		}
		
		/**
		 * @return the sUFFIX_G
		 */
		public String getSUFFIX_G() {
			return SUFFIX_G;
		}
		
		/**
		 * @return the sUFFIX_H
		 */
		public String getSUFFIX_H() {
			return SUFFIX_H;
		}
		
		/**
		 * @return the sUFFIX_I
		 */
		public String getSUFFIX_I() {
			return SUFFIX_I;
		}
		
		/**
		 * @return the sUFFIX_J
		 */
		public String getSUFFIX_J() {
			return SUFFIX_J;
		}
		
		/**
		 * @return the sUFFIX_K
		 */
		public String getSUFFIX_K() {
			return SUFFIX_K;
		}
		
		/**
		 * @return the sUFFIX_L
		 */
		public String getSUFFIX_L() {
			return SUFFIX_L;
		}
		
		/**
		 * @return the sUFFIX_M
		 */
		public String getSUFFIX_M() {
			return SUFFIX_M;
		}
		
		/**
		 * @return the sUFFIX_N
		 */
		public String getSUFFIX_N() {
			return SUFFIX_N;
		}
		
		/**
		 * @return the sUFFIX_O
		 */
		public String getSUFFIX_O() {
			return SUFFIX_O;
		}
		
		/**
		 * @return the tABLE
		 */
		public String getTABLE() {
			return TABLE;
		}
	}
}
